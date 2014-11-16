package vo.stockpo;

public class MockCommodityVO {
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
	public MockCommodityVO(String parent,String name)
	{
		t=t.Category;
		this.parent=parent;
		this.name=name;
	}
	public MockCommodityVO(String parent,String name,String model,double in,double out)
	{
		t=t.Commodity;
		this.parent=parent;
		this.name=name;
		this.model=model;
		this.in=in;
		this.out=out;
	}
	public Type getT() {
		return t;
	}
	public void setT(Type t) {
		this.t = t;
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
	
}
