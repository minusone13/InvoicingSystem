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
	int alertLine;
	ArrayList<CommodityRecord> record=new ArrayList<CommodityRecord>();
	ArrayList<CommodityRecord> prepareRecord=new ArrayList<CommodityRecord>();
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
		alertLine=po.getAlertLine();
		record=posToCom(po.getRecord());
		prepareRecord=posToCom(po.getPrepareRecord());
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
		alertLine=vo.getAlertLine();
		if (vo.getRecord()!=null)
		{
			record=vosToCom(vo.getRecord());
		}
		prepareRecord=vosToCom(vo.getPrepareRecord());
	}
	
	public void add(CommodityRecord r)
	{
		record.add(r);
	}
	public void prepareDelete(CommodityRecord r)
	{
		for(int i=0;i<prepareRecord.size();i++)
			if(prepareRecord.get(i).equals(r))
				prepareRecord.remove(i);
	}
	public void prepareAdd(CommodityRecord r)
	{
		prepareRecord.add(r);
	}
	public CommodityPO toPO()
	{
		return new CommodityPO(parent,name,model,number,in,out,lastin,lastout,alertLine,toRecordPOs(record), toRecordPOs(prepareRecord));
	}
	public CommodityVO toVO()
	{
		
		return new CommodityVO(parent,name,model,number,in,out,lastin,lastout,alertLine,toRecordVOs(record), toRecordVOs(prepareRecord));
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
	public int getAlertLine() {
		return alertLine;
	}
	public void setAlertLine(int alertLine) {
		this.alertLine = alertLine;
	}
	public ArrayList<CommodityRecord> getRecord() {
		return record;
	}
	public void setRecord(ArrayList<CommodityRecord> record) {
		this.record = record;
	}
	private ArrayList<CommodityRecordPO> toRecordPOs(ArrayList<CommodityRecord> h)
	{
		ArrayList<CommodityRecordPO> result=null;
		if(h!=null)
		{
			result=new ArrayList<CommodityRecordPO>();
			for(int i=0;i<h.size();i++)
				result.add(h.get(i).toPO());
		}
		return result;
	}
	private ArrayList<CommodityRecordVO> toRecordVOs(ArrayList<CommodityRecord> h)
	{
		ArrayList<CommodityRecordVO> result=null;
		if(h!=null)
		{
			result=new ArrayList<CommodityRecordVO>();
			for(int i=0;i<h.size();i++)
				result.add(h.get(i).toVO());
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
