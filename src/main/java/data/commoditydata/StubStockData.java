package data.commoditydata;

import java.util.ArrayList;

import dataservice.commoditydataservice.*;
import po.*;

public class StubStockData implements StubCommodityDataService{
	public boolean addCommodity(CommodityPO po)
	{
		return true;
	}
	public CommodityListPO getAll()
	{
		return new CommodityListPO();
	}
	public ArrayList<CommodityPO> findCommodity(String name)
	{
		return new ArrayList<CommodityPO>();
	}
	public boolean deleteCommodity(String name, String model)
	{
		return true;
	}
	public boolean updateCommodity(CommodityPO po)
	{
		return true;
	}
	public boolean addCategory(String parent, String name)
	{
		return true;
	}
}
