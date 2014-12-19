package data.commoditydata;

import java.io.Serializable;
import po.stockpo.CommodityPO;

public class MockCommodityData implements Serializable
{
	CommodityPO po;// 详见PO中的注释

	public MockCommodityData(CommodityPO po)
	{
		this.po = po;
	}

	public boolean canBeDeleted()
	{
		return (po.getRecord() == null || po.getRecord().size() == 0);
	}

	public boolean contents(String s)
	{
		return (po.getId().indexOf(s) != -1 || po.getName().indexOf(s) != -1 || po
				.getModel().indexOf(s) != -1);
	}

	public boolean equals(MockCommodityData com)
	{
		return (po.getName().equals(com.getName()) && po.getModel().equals(
				com.getModel()));
	}

	public boolean equals(String name, String model)
	{
		return (po.getName().equals(name) && po.getModel().equals(model));
	}

	public String getID()
	{
		return po.getId();
	}

	public double getIn()
	{
		return po.getIn();
	}

	public double getLastin()
	{
		return po.getLastin();
	}

	public double getLastout()
	{
		return po.getLastout();
	}

	public String getModel()
	{
		return po.getModel();
	}

	public String getName()
	{
		return po.getName();
	}

	public int getNumber()
	{
		return po.getNumber();
	}

	public double getOut()
	{
		return po.getOut();
	}

	public String getParent()
	{
		return po.getParent();
	}

	public CommodityPO getPo()
	{
		return po;
	}

	public void setID(String iD)
	{
		po.setId(iD);;
	}

	public void setIn(double in)
	{
		po.setIn(in);;
	}

	public void setLastin(double lastin)
	{
		po.setLastIn(lastin);;
	}

	public void setLastout(double lastout)
	{
		po.setLastOut(lastout);;
	}

	public void setNumber(int number)
	{
		po.setNumber(number);;
	}

	public void setOut(double out)
	{
		po.setOut(out);;
	}

	public void setParent(String parent)
	{
		po.setParent(parent);
		po.setId(po.getParent() + "\\" + po.getName());
	}

	public void setPo(CommodityPO po)
	{
		this.po = po;
	}
}
