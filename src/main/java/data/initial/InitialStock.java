package data.initial;

import java.rmi.RemoteException;

import po.Tool;
import data.commoditydata.StubStockDataController;

public class InitialStock 
{//初始化商品管理的文件 Stock.ser
	public InitialStock() throws RemoteException
	{
		Tool.Clean(Tool.stock);
		StubStockDataController data=StubStockDataController.getInstance();
		data.Initial();
	}
}
