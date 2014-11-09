package businesslogic.commoditybl;

import po.*;
import po.CommodityPO.Type;
import vo.*;

public class MockCommodity {
	String parent;//the ID of parent Category
	String name;
	String model;
	int number;
	double in;
	double out;
	double lastin;
	double lastout;
	double average;
	
	public MockCommodity(){}
	public MockCommodity(CommodityPO po)
	{
		parent=po.getParent();
		name=po.getName();
		model=po.getModel();
		number=po.getNumber();
		in=po.getIn();
		out=po.getOut();
		lastin=po.getLastIn();
		lastout=po.getLastOut();
		average=po.getAverage();
	}
	public MockCommodity(MockCommodityVO vo)
	{
		parent=vo.getparent();
		name=vo.getname();
		model=vo.getmodel();
		number=0;
		in=vo.getin();
		out=vo.getout();
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
	
	public CommodityPO toPO()
	{
		return new CommodityPO(Type.Commodity,parent,name,model,number,in,out,lastin,lastout,average);
	}
}
