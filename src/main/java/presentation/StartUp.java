package presentation;

import presentation.commodityui.CommodityDriver;
import presentation.financialui.FinancialBLDriver;
import businesslogic.financialbl.StubFinancial;
import businesslogic.stockmanagerbl.StubStockManager;
import businesslogicservice.financialblservice.StubFinancialBlService;

public class StartUp {

	public static void main(String args[])
	{
		StubFinancialBlService financial = new StubFinancial();
		FinancialBLDriver driver = new FinancialBLDriver(financial);
		driver.drive(financial);
		new CommodityDriver(new StubStockManager());
	}
}
