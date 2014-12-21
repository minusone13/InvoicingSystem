package data.initial;

import java.rmi.RemoteException;

import po.Tool;
import data.commoditydata.StubStockDataController;

public class InitialStock 
{//初始化商品管理的文件 Stock.ser
	public InitialStock()
	{
		Tool.Clean(Tool.stock);
		StubStockDataController data = null;
		try
		{
			data = StubStockDataController.getInstance();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			data.Initial();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
