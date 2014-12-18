package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.*;
import po.stockpo.*;

public interface StubCommodityDataService extends Remote{
	public RM insert(CommodityPO po);
	public RM insert(PackPO po);
	public RM insert(CategoryPO po);
	public boolean insert(AdjustmentRecordPO po);
	
	
	public CommodityListPO getAll();
	public ArrayList<CommodityPO> findCommodity(String name);
	public ArrayList<CommodityPO> fuzzyFindCommodity(String s,int precision);
	public RM deleteCommodity(String name, String model);
	public RM deleteCategory(String id);
	public boolean update(CommodityPO po);
	public RM update(CategoryPO po,String newName);
	public RM update(PackPO po);
	public ArrayList<PackPO> getAllPacks();
	public CommodityPO findCommodity(String name, String model);
	//public CategoryPO findCategory(String id);
	public PackPO findPack(String PackID);
	public ArrayList<StockPO> openCategory(String id);
	
	public ArrayList<AdjustmentRecordPO> getAdjustmentRecords();
	public ArrayList<CommodityPO> getAllCommodity();//用于库存盘点
	
	public int getCountNo();//盘点序号
}
