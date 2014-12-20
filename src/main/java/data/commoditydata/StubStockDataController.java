package data.commoditydata;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.stockservice.StockDataForFinancial;
import dataservice.commoditydataservice.*;
import po.*;
import po.stockpo.*;

public class StubStockDataController extends UnicastRemoteObject implements StubCommodityDataService,
		StockDataForFinancial
{// 这是一个单体模式的类，因为这样读写文件方便些
	public static StubStockDataController getInstance()throws RemoteException
	{// 单体模式
		if (instance == null)
			instance = new StubStockDataController();
		return instance;
	}

	private static StubStockDataController instance = null;
	StubCommodityList l;

	File f;

	public StubStockDataController()throws RemoteException
	{
		read();
	}

	//没有注释的方法参见dataservice/commoditydataservice/StubCommodityDataService.java
	public RM deleteCategory(String id)throws RemoteException
	{
		read();
		RM result = l.deleteCategory(id);
		save();
		return result;
	}

	public RM deleteCommodity(String name, String model)throws RemoteException
	{
		read();
		RM result = l.deleteCommodity(name, model);
		save();
		return result;
	}

	public CategoryPO findCategory(String id)throws RemoteException
	{
		read();
		StubCategoryData result = l.findCategory(id);
		if (result == null)
			return null;
		return result.getPo().clone();
	}

	public ArrayList<CommodityPO> findCommodity(String name)throws RemoteException
	{
		read();
		return l.findCommodity(name);
	}

	public CommodityPO findCommodity(String name, String model)throws RemoteException
	{
		read();
		MockCommodityData result = l.findCommodity(name, model);
		if (result == null)
			return null;
		return result.getPo().clone();
	}

	public PackPO findPack(String packID)throws RemoteException
	{
		read();
		return l.findPack(packID);
	}

	public ArrayList<CommodityPO> fuzzyFindCommodity(String s, int precision)throws RemoteException
	{
		read();
		return l.fuzzyFindCommodity(s, precision);
	}

	public ArrayList<AdjustmentRecordPO> getAdjustmentRecords()throws RemoteException
	{
		read();
		ArrayList<AdjustmentRecordPO> result = l.getAdjustmentRecords();
		return result;
	}

	public CommodityListPO getAll()throws RemoteException
	{// this is for financial
		read();
		return new CommodityListPO();
	}

	public ArrayList<CommodityPO> getAllCommodity()throws RemoteException
	{
		read();
		ArrayList<CommodityPO> result = l.getAllCommodity();
		save();
		return result;
	}

	public ArrayList<PackPO> getAllPacks()throws RemoteException
	{
		read();
		return l.getAllPacks();
	}

	public int getCountNo()throws RemoteException
	{
		read();
		return l.getCountNo();
	}

	public StubCommodityList getL()throws RemoteException
	{
		read();
		return l;
	}

	public void Initial()throws RemoteException
	{//初始化方法，程序第一次运行时使用
		f = Tool.Opendoc(Tool.stock);

		// some initial under;
		ObjectOutputStream oos = null;
		try
		{
			oos = new ObjectOutputStream(new FileOutputStream(f));
		}
		catch (FileNotFoundException e2)
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		catch (IOException e2)
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try
		{
			oos.writeObject(new StubCommodityList());
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{
			oos.close();
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		read();
		// some initial procedure under;
		l.initial();
		save();
	}

	public boolean insert(AdjustmentRecordPO po)throws RemoteException
	{
		read();
		boolean result = l.insert(po);
		save();
		return result;
	}

	public RM insert(CategoryPO po)throws RemoteException
	{
		read();
		RM result = l.insert(po);
		save();
		return result;
	}

	public RM insert(CommodityPO po)throws RemoteException
	{
		read();
		RM result = l.insert(po);
		save();
		return result;
	}

	public RM insert(PackPO po)throws RemoteException
	{
		read();
		RM result = l.insert(po);
		save();
		return result;
	}

	public ArrayList<StockPO> openCategory(String id)throws RemoteException
	{
		read();
		StubCategoryData cat = l.findCategory(id);
		if (cat == null)
			return null;
		return l.findCategory(id).open();
	}

	public void read()throws RemoteException
	{
		f = Tool.Opendoc(Tool.stock);

		ObjectInputStream ois = null;
		try
		{
			ois = new ObjectInputStream(new FileInputStream(f));
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StubCommodityList temp = null;
		try
		{
			temp = (StubCommodityList) ois.readObject();
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (temp != null)
			l = temp;
		else
			System.out.println("CommodityList读取为NULL，可能在初始化时出现");
		try
		{
			ois.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean save()throws RemoteException
	{
		save(f);
		return true;
	}

	public boolean save(File file)throws RemoteException
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(file));
			oos.writeObject(l);
			oos.writeObject(null);
			oos.close();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		return true;
	}

	public boolean save(String s)throws RemoteException
	{
		File file = Tool.Opendoc(s);
		save(file);
		return true;
	}

	public boolean saveAndBuild(String s)throws RemoteException
	{//用于期初建账
		read();
		l.accountBuild();
		save(s);
		return true;
	}

	public void setDefaultFile()throws RemoteException
	{
		Tool.stock = Tool.defaultstock;
		instance = new StubStockDataController();
	}

	public void setFilePath(String s) 
	{
		Tool.stock = s;
		try
		{
			instance = new StubStockDataController();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setL(StubCommodityList l)throws RemoteException
	{
		read();
		this.l = l;
	}

	public RM update(CategoryPO po, String newName)throws RemoteException
	{
		read();
		RM result = l.update(po, newName);
		save();
		return result;
	}

	public boolean update(CommodityPO po)throws RemoteException
	{
		read();
		boolean result = l.update(po);
		save();
		return result;
	}

	public RM update(PackPO po)throws RemoteException
	{
		read();
		RM result = l.update(po);
		save();
		return result;
	}
}
