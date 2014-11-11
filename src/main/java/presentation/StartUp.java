package presentation;


import data.commoditydata.*;
import data.initial.Initial;
import presentation.commodityui.CommodityDriver;
import presentation.financialui.FinancialBLDriver;
import businesslogic.financialbl.StubFinancial;
import presentation.commodityui.*;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.financialblservice.StubFinancialBlService;

public class StartUp {

	public static void main(String args[])
	{
		//财务人员的驱动程序
		StubFinancialBlService financial = new StubFinancial();
		FinancialBLDriver driver = new FinancialBLDriver(financial);
		driver.drive();
		
		//库存管理人员的启动程序
		Initial initial= new Initial();
		initial.initialStock();
		StockManagerDriver smd=new StockManagerDriver();
		smd.start(new StubStockController(),new StubStockDataController());
		
	}
}
