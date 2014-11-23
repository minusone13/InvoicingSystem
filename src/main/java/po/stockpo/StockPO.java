package po.stockpo;

public class StockPO {
	//当不清楚类型时使用StockPO，如打开一个分类前，并不知道下一层是商品还是分类
	public enum Type
	{//指明类型
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
