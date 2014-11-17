package vo.stockvo;


public class StockVO {
	public enum Type
	{
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
