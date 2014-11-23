package vo.stockvo;


public class StockVO {
	//当不清楚类型时使用StockVO，如打开一个分类前，并不知道下一层是商品还是分类
	public enum Type
	{//指明类型
		Category,
		Commodity
	}
	Type t;
	
	CategoryVO cat;
	CommodityVO com;
	public StockVO(CommodityVO vo)
	{
		t=t.Commodity;
		cat=null;
		com=vo;
	}
	public StockVO(CategoryVO vo)
	{
		t=t.Category;
		cat=vo;
		com=null;
	}
	public CategoryVO getCat() {
		return cat;
	}
	public void setCat(CategoryVO cat) {
		this.cat = cat;
	}
	public CommodityVO getCom() {
		return com;
	}
	public void setCom(CommodityVO com) {
		this.com = com;
	}
	public Type getT() {
		return t;
	}
	public void setT(Type t) {
		this.t = t;
	}
}
