package dataservice.commoditydataservice;

import java.util.ArrayList;

import po.*;
import po.stockpo.CommodityListPO;
import po.stockpo.CommodityPO;
import vo.RM;

public interface StubCommodityDataService {
	public RM addCommodity(CommodityPO po);
	public CommodityListPO getAll();
	public ArrayList<CommodityPO> findCommodity(String name);
	public boolean deleteCommodity(String name, String model);
	public boolean updateCommodity(CommodityPO po);
	public boolean addCategory(String parent, String name);
	public CommodityPO findCommodity(String name, String model);
}
