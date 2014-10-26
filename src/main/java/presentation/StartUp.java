package presentation;

import presentation.commodityui.*;
import businesslogic.stockmanagerbl.StubStockManager;

public class StartUp {

	public static void main(String args[])
	{
		StockManagerDriver smd=new StockManagerDriver();
		smd.start(new StubStockManager());
	}
}
