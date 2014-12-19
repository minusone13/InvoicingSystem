package po.stockpo;

import java.util.*;

public class CommodityListPO
{
	ArrayList<CommodityPO> cats;

	public CommodityListPO()
	{}

	public CommodityListPO(ArrayList<CommodityPO> cats)
	{
		this.cats = cats;
	}

	public ArrayList<CommodityPO> getList()
	{
		return cats;
	}
}
