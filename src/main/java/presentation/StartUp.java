package presentation;

import presentation.commodityui.CommodityDriver;
import businesslogic.stockmanagerbl.StubStockManager;

public class StartUp {

	public static void main(String args[])
	{
		new CommodityDriver(new StubStockManager());
	}
}
