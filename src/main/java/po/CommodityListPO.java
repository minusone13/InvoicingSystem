package po;

import java.util.*;

public class CommodityListPO {
	ArrayList<CommodityPO> cats;
	public CommodityListPO(ArrayList<CommodityPO> cats)
	{
		this.cats=cats;
	}
	public CommodityListPO()
	{
	}
	public ArrayList<CommodityPO> getList()
	{
		return cats;
	}
}
