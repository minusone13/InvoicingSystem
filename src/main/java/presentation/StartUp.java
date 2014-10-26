package presentation;


import presentation.commodityui.CommodityDriver;
import presentation.financialui.FinancialBLDriver;
import businesslogic.financialbl.StubFinancial;

import presentation.commodityui.*;

import businesslogic.stockmanagerbl.StubStockManager;
import businesslogicservice.financialblservice.StubFinancialBlService;

public class StartUp {

	public static void main(String args[])
	{
		//财务人员的驱动程序
		StubFinancialBlService financial = new StubFinancial();
		FinancialBLDriver driver = new FinancialBLDriver(financial);
		driver.drive(financial);
		
		new CommodityDriver(new StubStockManager());
		StockManagerDriver smd=new StockManagerDriver();
		smd.start(new StubStockManager());

	}
}
