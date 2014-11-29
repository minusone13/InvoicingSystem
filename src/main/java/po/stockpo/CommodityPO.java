package po.stockpo;

import java.io.Serializable;
import java.util.*;


public class CommodityPO implements Serializable, Cloneable{
	String id;
	String parent;
	String name;
	String model;
	int number;
	double in;
	double out;
	double lastin;
	double lastout;
	double average;
	ArrayList<CommodityRecordPO> record=new ArrayList<CommodityRecordPO>();
	public CommodityPO(){}
	public CommodityPO(String parent,String name,String model,int number,double in,double out,double lastin,double lastout,double average)
	{	
		this.parent=parent;
		this.name=name;
		id=parent+"\\"+name;
		this.model=model;
		this.number=number;
		this.in=in;
		this.out=out;
		this.lastin=lastin;
		this.lastout=lastout;
		this.average=average;
	}
	public CommodityPO(String parent,String name,String model,int number,double in,double out,double lastin,double lastout,double average,ArrayList<CommodityRecordPO> record)
	{	
		this.parent=parent;
		this.name=name;
		id=parent+"\\"+name;
		this.model=model;
		this.number=number;
		this.in=in;
		this.out=out;
		this.lastin=lastin;
		this.lastout=lastout;
		this.average=average;
		this.record=record;
	}
	public CommodityPO(String parent,String name)
	{
		this.parent=parent;
		this.name=name;
	}
	public CommodityPO clone()
	{
		CommodityPO cloned = null;
		try {
			cloned=(CommodityPO)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cloned;
	}
	public String getParent()
	{
		return parent;
	}
	public String getName()
	{
		return name;
	}
	public int getNumber()
	{
		return number;
	}
	public double getIn()
	{
		return in;
	}
	public double getOut()
	{
		return out;
	}
	public double getLastIn()
	{
		return lastin;
	}
	public double getLastOut()
	{
		return lastout;
	}
	public void setNumber(int number)
	{
		this.number=number;
	}
	public void setLastIn(double lastin)
	{
		this.lastin=lastin;
	}
	public void setLastOut(double lastout)
	{
		this.lastout=lastout;
	}
	public void setIn(double in)
	{
		this.in=in;
	}
	public void setOut(double out)
	{
		this.out=out;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
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
	public void setParent(String parent) {
		this.parent = parent;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<CommodityRecordPO> getRecord() {
		return record;
	}
	public void setRecord(ArrayList<CommodityRecordPO> record) {
		this.record = record;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
