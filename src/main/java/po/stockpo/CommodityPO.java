package po.stockpo;

import java.io.Serializable;
import java.util.*;

public class CommodityPO implements Serializable, Cloneable
{
	//参见businesslogic/commoditybl/MockCommodity.java
	String id;
	String parent;
	String name;
	String model;
	int number;
	double in;
	double out;
	double lastin;
	double lastout;
	int alertLine;
	ArrayList<CommodityRecordPO> record = new ArrayList<CommodityRecordPO>();
	ArrayList<CommodityRecordPO> prepareRecord = new ArrayList<CommodityRecordPO>();

	public CommodityPO()
	{}

	public CommodityPO(String parent, String name)
	{
		this.parent = parent;
		this.name = name;
	}

	public CommodityPO(String parent, String name, String model, int number,
			double in, double out, double lastin, double lastout, int alertLine)
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
	}

	public CommodityPO(String parent, String name, String model, int number,
			double in, double out, double lastin, double lastout,
			int alertLine, ArrayList<CommodityRecordPO> record,
			ArrayList<CommodityRecordPO> prepareRecord)
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

	@Override
	public CommodityPO clone()
	{
		CommodityPO cloned = null;
		try
		{
			cloned = (CommodityPO) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cloned;
	}

	public int getAlertLine()
	{
		return alertLine;
	}

	public String getId()
	{
		return id;
	}

	public double getIn()
	{
		return in;
	}

	public double getLastin()
	{
		return lastin;
	}

	public double getLastIn()
	{
		return lastin;
	}

	public double getLastout()
	{
		return lastout;
	}

	public double getLastOut()
	{
		return lastout;
	}

	public String getModel()
	{
		return model;
	}

	public String getName()
	{
		return name;
	}

	public int getNumber()
	{
		return number;
	}

	public double getOut()
	{
		return out;
	}

	public String getParent()
	{
		return parent;
	}

	public ArrayList<CommodityRecordPO> getPrepareRecord()
	{
		return prepareRecord;
	}

	public ArrayList<CommodityRecordPO> getRecord()
	{
		return record;
	}

	public void setAlertLine(int alertLine)
	{
		this.alertLine = alertLine;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setIn(double in)
	{
		this.in = in;
	}

	public void setLastin(double lastin)
	{
		this.lastin = lastin;
	}

	public void setLastIn(double lastin)
	{
		this.lastin = lastin;
	}

	public void setLastout(double lastout)
	{
		this.lastout = lastout;
	}

	public void setLastOut(double lastout)
	{
		this.lastout = lastout;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public void setOut(double out)
	{
		this.out = out;
	}

	public void setParent(String parent)
	{
		this.parent = parent;
	}

	public void setPrepareRecord(ArrayList<CommodityRecordPO> prepareRecord)
	{
		this.prepareRecord = prepareRecord;
	}

	public void setRecord(ArrayList<CommodityRecordPO> record)
	{
		this.record = record;
	}
}
