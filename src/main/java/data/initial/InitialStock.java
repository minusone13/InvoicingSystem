package data.initial;

import data.commoditydata.StubStockDataController;

public class InitialStock 
{//初始化商品管理的文件 Stock.ser
	public InitialStock()
	{
		StubStockDataController data=StubStockDataController.getInstance();
		data.Initial();
	}
}
