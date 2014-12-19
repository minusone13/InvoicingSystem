package po.stockpo;

import java.io.Serializable;

public class StockPO implements Serializable, Cloneable
{
	// 当不清楚类型时使用StockPO，如打开一个分类前，并不知道下一层是商品还是分类
	public enum Type
	{// 指明类型
		Category, Commodity
	}

	Type t;
	CategoryPO cat;
	CommodityPO com;

	public StockPO(CategoryPO po)
	{
		t = Type.Category;
		cat = po;
		com = null;
	}

	public StockPO(CommodityPO po)
	{
		t = Type.Commodity;
		cat = null;
		com = po;
	}

	public CategoryPO getCat()
	{
		return cat;
	}

	public CommodityPO getCom()
	{
		return com;
	}

	public Type getT()
	{
		return t;
	}

	public void setCat(CategoryPO cat)
	{
		this.cat = cat;
	}

	public void setCom(CommodityPO com)
	{
		this.com = com;
	}

	public void setT(Type t)
	{
		this.t = t;
	}
}
