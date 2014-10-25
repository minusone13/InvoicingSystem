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
	CommodityVO(String parent,String name,String model,double in,double out)
	{
		this.parent=parent;
		this.name=name;
		this.model=model;
		this.in=in;
		this.out=out;
	}
}
