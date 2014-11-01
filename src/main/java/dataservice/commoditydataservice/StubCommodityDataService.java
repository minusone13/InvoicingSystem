package dataservice.commoditydataservice;

import java.util.ArrayList;

import po.*;

public interface StubCommodityDataService {
	public boolean addCommodity(CommodityPO po);
	public CommodityListPO getAll();
	public ArrayList<CommodityPO> findCommodity(String name);
	public boolean deleteCommodity(String name, String model);
	public boolean updateCommodity(CommodityPO po);
	public boolean addCategory(String parent, String name);
	public CommodityPO findCommodity(String name, String model);
}
