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
	ArrayList<CommodityRecordPO> record=null;
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
		record=po.getRecord();
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
		record=new ArrayList<CommodityRecordPO>();
		ArrayList<CommodityRecordVO> temp=vo.getRecord();
		for(int i=0;i<temp.size();i++)
		{
			CommodityRecordVO recordvo=temp.get(i);
			CommodityRecordPO recordpo=new CommodityRecordPO(recordvo.getD(),recordvo.getOutquantity(),recordvo.getInquantity(),
					recordvo.getOutamount(),recordvo.getInamount(),recordvo.getSalequantity(),recordvo.getImportquantity(),
					recordvo.getSaleamount(),recordvo.getImportamount());
			record.add(recordpo);
		}
	}
	
	
	public CommodityPO toPO()
	{
		return new CommodityPO(parent,name,model,number,in,out,lastin,lastout,average,record);
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
	public ArrayList<CommodityRecordPO> getRecord() {
		return record;
	}
	public void setRecord(ArrayList<CommodityRecordPO> record) {
		this.record = record;
	}
}
