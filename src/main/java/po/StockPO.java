package po;

public class StockPO {
	public enum Type
	{
		Category,
		Commodity
	} 
	Type t;
	CategoryPO cat;
	CommodityPO com;
	public StockPO(CommodityPO po)
	{
		t=t.Commodity;
		cat=null;
		com=po;
	}
	public StockPO(CategoryPO po)
	{
		t=t.Category;
		cat=po;
		com=null;
	}
	public CategoryPO getCat() {
		return cat;
	}
	public void setCat(CategoryPO cat) {
		this.cat = cat;
	}
	public CommodityPO getCom() {
		return com;
	}
	public void setCom(CommodityPO com) {
		this.com = com;
	}
	public Type getT() {
		return t;
	}
	public void setT(Type t) {
		this.t = t;
	}
}
