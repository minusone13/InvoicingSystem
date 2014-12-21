package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.*;
import po.stockpo.*;

public interface StubCommodityDataService extends Remote
{
	public void setFilePath(String s);//用于查看期初建账信息

	public void setDefaultFile();//返回默认库存文件路径

	//简单插入，就是向List里面add
	public RM insert(CommodityPO po);

	public RM insert(PackPO po);

	public RM insert(CategoryPO po);

	public boolean insert(AdjustmentRecordPO po);//用于商品调价

	public CommodityListPO getAll();//没有用到，预留一个接口

	public ArrayList<CommodityPO> findCommodity(String name);//同商品名称不同型号

	public ArrayList<CommodityPO> fuzzyFindCommodity(String s, int precision);
	//模糊查找参见BLService的接口

	public RM deleteCommodity(String name, String model);//名称型号唯一确定商品

	public RM deleteCategory(String id);

	//简单的删除后再增加
	public boolean update(CommodityPO po);

	public RM update(CategoryPO po, String newName);

	public RM update(PackPO po);

	public ArrayList<PackPO> getAllPacks();

	public CommodityPO findCommodity(String name, String model);

	// public CategoryPO findCategory(String id);
	public PackPO findPack(String PackID);

	public ArrayList<StockPO> openCategory(String id);
	//打开一个ID标记的分类，打开的可能是子分类或商品，种类在PO中的Type标识

	public ArrayList<AdjustmentRecordPO> getAdjustmentRecords();//商品调价历史

	public ArrayList<CommodityPO> getAllCommodity();// 用于库存盘点

	public int getCountNo();// 盘点序号
}
