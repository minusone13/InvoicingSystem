package dataservice.commoditydataservice;

import java.util.ArrayList;

import po.CommodityListPO;
import po.CommodityPO;

public interface CommodityDataService {
	public boolean addCommodity(CommodityPO po);
	public CommodityListPO getAll();
	public ArrayList<CommodityPO> findCommodity(String name);
	public boolean deleteCommodity(String name, String model);
	public boolean updateCommodity(CommodityPO po);
	public boolean addCategory(String parent, String name);
}
