package dataservice.commoditydataservice;

import java.util.ArrayList;

import po.*;
import po.stockpo.*;
import vo.RM;

public interface StubCommodityDataService {
	public RM insert(CommodityPO po);
	public RM insert(PackPO po);
	public RM insert(CategoryPO po);
	public boolean insert(AdjustmentRecordPO po);
	
	
	public CommodityListPO getAll();
	public ArrayList<CommodityPO> findCommodity(String name);
	public RM deleteCommodity(String name, String model);
	public RM deleteCategory(String id);
	public boolean update(CommodityPO po);
	public boolean update(CategoryPO po);
	public CommodityPO findCommodity(String name, String model);
	public ArrayList<StockPO> openCategory(String id);
}
