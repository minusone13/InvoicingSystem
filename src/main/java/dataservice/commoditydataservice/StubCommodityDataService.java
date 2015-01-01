package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.*;
import po.stockpo.*;

public interface StubCommodityDataService extends Remote
{
	public void setFilePath(String s) throws RemoteException;//用于查看期初建账信息

	public void setDefaultFile() throws RemoteException;//返回默认库存文件路径

	//简单插入，就是向List里面add
	public RM insert(CommodityPO po) throws RemoteException;

	public RM insert(PackPO po) throws RemoteException;

	public RM insert(CategoryPO po) throws RemoteException;

	public boolean insert(AdjustmentRecordPO po)throws RemoteException;//用于商品调价

	public CommodityListPO getAll()throws RemoteException;//没有用到，预留一个接口

	public ArrayList<CommodityPO> findCommodity(String name)throws RemoteException;//同商品名称不同型号

	public ArrayList<CommodityPO> fuzzyFindCommodity(String s, int precision)throws RemoteException;
	//模糊查找参见BLService的接口

	public RM deleteCommodity(String name, String model) throws RemoteException;//名称型号唯一确定商品

	public RM deleteCategory(String id)throws RemoteException;

	//简单的删除后再增加
	public boolean update(CommodityPO po) throws RemoteException;

	public RM update(CategoryPO po, String newName) throws RemoteException;

	public RM update(PackPO po) throws RemoteException;

	public ArrayList<PackPO> getAllPacks()throws RemoteException;

	public CommodityPO findCommodity(String name, String model)throws RemoteException;

	// public CategoryPO findCategory(String id);
	public PackPO findPack(String PackID)throws RemoteException;

	public ArrayList<StockPO> openCategory(String id) throws RemoteException;
	//打开一个ID标记的分类，打开的可能是子分类或商品，种类在PO中的Type标识

	public ArrayList<AdjustmentRecordPO> getAdjustmentRecords()throws RemoteException;//商品调价历史

	public ArrayList<CommodityPO> getAllCommodity()throws RemoteException;// 用于库存盘点

	public int getCountNo()throws RemoteException;// 盘点序号
}
