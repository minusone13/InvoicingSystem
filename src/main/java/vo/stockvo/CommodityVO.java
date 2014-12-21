package vo.stockvo;

import java.util.ArrayList;

import businesslogic.commoditybl.CommodityRecord;

public class CommodityVO
{
	public CommodityVO(String parent, String name, String model, int number,
			double in, double out, double lastin, double lastout,
			int alertLine, ArrayList<CommodityRecordVO> record,
			ArrayList<CommodityRecordVO> prepareRecord)
	{
		this.parent = parent;
		this.name = name;
		id = parent + "\\" + name;
		this.model = model;
		this.number = number;
		this.in = in;
		this.out = out;
		this.lastin = lastin;
		this.lastout = lastout;
		this.alertLine = alertLine;
		this.record = record;
		this.prepareRecord = prepareRecord;
	}

	//参见businesslogic/commoditybl/MockCommodity.java
	String id;// ID恒等于parent+"\\"+name
	String parent;// 父分类的ID
	String name;
	String model;// 名称和型号唯一确定一个商品
	int number;
	double in;
	double out;
	double lastin;
	double lastout;
	int alertLine;
	ArrayList<CommodityRecordVO> record = new ArrayList<CommodityRecordVO>();
	ArrayList<CommodityRecordVO> prepareRecord = new ArrayList<CommodityRecordVO>();

	public CommodityVO(String parent, String name, String model, double in,
			double out)
	{// this is for ui
		this.parent = parent;
		this.name = name;
		id = parent + "\\" + name;
		this.model = model;
		this.in = in;
		this.out = out;
	}

	public CommodityVO(String parent, String name, String model, double in,
			double out, int alertLine)
	{// this is for ui
		this.parent = parent;
		this.name = name;
		id = parent + "\\" + name;
		this.model = model;
		this.in = in;
		this.out = out;
		this.alertLine = alertLine;
	}

	public CommodityVO()
	{}

	public String getParent()
	{
		return parent;
	}

	public void setParent(String parent)
	{
		this.parent = parent;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public double getIn()
	{
		return in;
	}

	public void setIn(double in)
	{
		this.in = in;
	}

	public double getOut()
	{
		return out;
	}

	public void setOut(double out)
	{
		this.out = out;
	}

	public double getLastin()
	{
		return lastin;
	}

	public void setLastin(double lastin)
	{
		this.lastin = lastin;
	}

	public double getLastout()
	{
		return lastout;
	}

	public void setLastout(double lastout)
	{
		this.lastout = lastout;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public int getAlertLine()
	{
		return alertLine;
	}

	public void setAlertLine(int alertLine)
	{
		this.alertLine = alertLine;
	}

	public ArrayList<CommodityRecordVO> getRecord()
	{
		return record;
	}

	public void setRecord(ArrayList<CommodityRecordVO> record)
	{
		this.record = record;
	}

	public ArrayList<CommodityRecordVO> getPrepareRecord()
	{
		return prepareRecord;
	}

	public void setPrepareRecord(ArrayList<CommodityRecordVO> prepareRecord)
	{
		this.prepareRecord = prepareRecord;
	}

}
