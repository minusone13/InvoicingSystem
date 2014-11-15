package presentation;


import data.commoditydata.*;
import data.initial.Initial;
import presentation.financialui.FinancialBLDriver;
import businesslogic.financialbl.StubFinancial;
import presentation.commodityui.*;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogic.userbl.User;
import businesslogicservice.financialblservice.StubFinancialBlService;

public class StartUp {

	public static void main(String args[])
	{
		Initial initial= new Initial();
		initial.initialAll();
		//财务人员的驱动程序
		StubFinancialBlService financial = new StubFinancial();
		FinancialBLDriver driver = new FinancialBLDriver(financial);
		driver.drive();
		
		//库存管理人员的启动程序
		initial.initialStock();
		StockManagerDriver smd=new StockManagerDriver();
		smd.start(new StubStockController(),new StubStockDataController());
	}
}
