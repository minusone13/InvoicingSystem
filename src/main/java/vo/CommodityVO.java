package vo;

public class CommodityVO {
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
	public CommodityVO(String parent,String name)
	{
		t=t.Category;
		this.parent=parent;
		this.name=name;
	}
	public CommodityVO(String parent,String name,String model,double in,double out)
	{
		t=t.Commodity;
		this.parent=parent;
		this.name=name;
		this.model=model;
		this.in=in;
		this.out=out;
	}
	public String getparent()
	{
		return parent;
	}
	public String getname()
	{
		return name;
	}
	public String getmodel()
	{
		return model;
	}
	public int getnumber()
	{
		return number;
	}
	public double getin()
	{
		return in;
	}
	public double getout()
	{
		return out;
	}
	public double getlastin()
	{
		return lastin;
	}
	public double getlastout()
	{
		return lastout;
	}
	public void setlastin(double lastin)
	{
		this.lastin=lastin;
	}
	public void setlastout(double lastout)
	{
		this.lastout=lastout;
	}
}
