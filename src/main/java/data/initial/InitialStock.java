package data.initial;

import java.rmi.RemoteException;

import po.Tool;
import data.commoditydata.StockDataController;

public class InitialStock 
{//初始化商品管理的文件 Stock.ser
	public InitialStock()
	{
		Tool.Clean(Tool.stock);
		StockDataController data = null;
		try
		{
			data = StockDataController.getInstance();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data.Initial();
	}
}
