package po;


public class CommodityPO {
	public enum Type
	{
		Category,
		Commodity
	} 
	Type t;
	String parent;
	String name;
	String model;
	int number;
	double in;
	double out;
	double lastin;
	double lastout;
	public CommodityPO(Type t,String parent,String name,String model,int number,double in,double out,double lastin,double lastout)
	{
		this.t=t;
		this.parent=parent;
		this.name=name;
		this.model=model;
		this.number=number;
		this.in=in;
		this.out=out;
		this.lastin=lastin;
		this.lastout=lastout;
	}
	public Type getType()
	{
		return t;
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
}
