package dataservice.commoditydataservice;

import java.util.ArrayList;

import po.*;
import po.stockpo.CategoryPO;
import po.stockpo.CommodityListPO;
import po.stockpo.CommodityPO;
import po.stockpo.StockPO;
import vo.RM;

public interface StubCommodityDataService {
	public RM insert(CommodityPO po);
	public CommodityListPO getAll();
	public ArrayList<CommodityPO> findCommodity(String name);
	public boolean deleteCommodity(String name, String model);
	public boolean updateCommodity(CommodityPO po);
	public RM insert(CategoryPO po);
	public CommodityPO findCommodity(String name, String model);
	public ArrayList<StockPO> openCategory(String id);
}
