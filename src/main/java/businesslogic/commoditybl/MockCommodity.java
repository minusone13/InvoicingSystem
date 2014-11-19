package businesslogic.commoditybl;

import java.util.ArrayList;

import po.*;
import po.stockpo.CommodityPO;
import po.stockpo.CommodityRecordPO;
import vo.*;
import vo.stockvo.CommodityRecordVO;
import vo.stockvo.CommodityVO;

public class MockCommodity {
	String id;
	String parent;//the ID of parent Category
	String name;
	String model;
	int number;
	double in;
	double out;
	double lastin;
	double lastout;
	double average;
	ArrayList<CommodityRecord> record=null;
	public MockCommodity(){}
	public MockCommodity(CommodityPO po)
	{
		parent=po.getParent();
		name=po.getName();
		id=parent+"\\"+name;
		model=po.getModel();
		number=po.getNumber();
		in=po.getIn();
		out=po.getOut();
		lastin=po.getLastIn();
		lastout=po.getLastOut();
		average=po.getAverage();
		record=posToCom(po.getRecord());
	}
	public MockCommodity(CommodityVO vo)
	{
		parent=vo.getParent();
		name=vo.getName();
		id=parent+"\\"+name;
		model=vo.getModel();
		number=0;
		in=vo.getIn();
		out=vo.getOut();
		lastin=vo.getLastin();
		lastout=vo.getLastout();
		average=vo.getAverage();
		if (vo.getRecord()!=null)
		{
			record=vosToCom(vo.getRecord());
		}
	}
	
	
	public CommodityPO toPO()
	{
		return new CommodityPO(parent,name,model,number,in,out,lastin,lastout,average,toRecordPOs());
	}
	public CommodityVO toVO()
	{
		
		return new CommodityVO(parent,name,model,number,in,out,lastin,lastout,average,toRecordVOs());
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getIn() {
		return in;
	}
	public void setIn(double in) {
		this.in = in;
	}
	public double getOut() {
		return out;
	}
	public void setOut(double out) {
		this.out = out;
	}
	public double getLastin() {
		return lastin;
	}
	public void setLastin(double lastin) {
		this.lastin = lastin;
	}
	public double getLastout() {
		return lastout;
	}
	public void setLastout(double lastout) {
		this.lastout = lastout;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public ArrayList<CommodityRecord> getRecord() {
		return record;
	}
	public void setRecord(ArrayList<CommodityRecord> record) {
		this.record = record;
	}
	private ArrayList<CommodityRecordPO> toRecordPOs()
	{
		ArrayList<CommodityRecordPO> result=null;
		if(record!=null)
		{
			result=new ArrayList<CommodityRecordPO>();
			for(int i=0;i<record.size();i++)
				result.add(record.get(i).toPO());
		}
		return result;
	}
	private ArrayList<CommodityRecordVO> toRecordVOs()
	{
		ArrayList<CommodityRecordVO> result=null;
		if(record!=null)
		{
			result=new ArrayList<CommodityRecordVO>();
			for(int i=0;i<record.size();i++)
				result.add(record.get(i).toVO());
		}
		return result;
	}
	private ArrayList<CommodityRecord> posToCom(ArrayList<CommodityRecordPO> h)
	{
		ArrayList<CommodityRecord> result=null;
		if(h!=null)
		{
			result=new ArrayList<CommodityRecord>();
			for(int i=0;i<h.size();i++)
				result.add(new CommodityRecord(h.get(i)));
		}
		return result;
	}
	private ArrayList<CommodityRecord> vosToCom(ArrayList<CommodityRecordVO> h)
	{
		ArrayList<CommodityRecord> result=null;
		if(h!=null)
		{
			result=new ArrayList<CommodityRecord>();
			for(int i=0;i<h.size();i++)
				result.add(new CommodityRecord(h.get(i)));
		}
		return result;
	}
}
