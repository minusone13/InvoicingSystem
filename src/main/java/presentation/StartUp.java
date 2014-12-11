package presentation;


import presentation.commodityui.StockManagerDriver;
import presentation.financialui.FinancialBLDriver;
import presentation.managerui.ManagerBLDriver;
import presentation.userui.Login;
import businesslogic.financialbl.Financial;
import businesslogic.managerbl.StubManager;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.financialblservice.StubFinancialBlService;
import businesslogicservice.managerblservice.StubManagerBlService;
import data.commoditydata.StubStockDataController;
import data.initial.Initial;

public class StartUp {

	public static void main(String args[])
	{
		Initial initial= new Initial();
		initial.initialAll();
		initial.initialTest();//向单据文件写入一些单据
		//总经理的驱动程序
//		StubManagerBlService manager = new StubManager();
//		ManagerBLDriver managerDriver = new ManagerBLDriver(manager);
//		managerDriver.drive();
		//财务人员的驱动程序
		StubFinancialBlService financial = new Financial();
		FinancialBLDriver driver = new FinancialBLDriver(financial);
		driver.drive();
		
		//库存管理人员的启动程序
		initial.initialStock();
		StockManagerDriver smd=new StockManagerDriver();
		smd.start(new StubStockController(),StubStockDataController.getInstance());
			
	}
}
