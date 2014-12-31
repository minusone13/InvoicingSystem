package presentation;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.commoditydataservice.CommodityDataService;
import presentation.commodityui.StockManagerDriver;
import presentation.financialui.FinancialBLDriver;
import presentation.managerui.ManagerBLDriver;
import presentation.userui.Login;
import businesslogic.financialbl.Financial;
import businesslogic.managerbl.StubManager;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.financialblservice.FinancialBlService;
import businesslogicservice.managerblservice.StubManagerBlService;

public class StartUp {
	public static void main(String args[])
	{
		//Initial initial= new Initial();
		//initial.initialAll();
		//initial.initialTest();//向单据文件写入一些单据
		//总经理的驱动程序
		StubManagerBlService manager = new StubManager();
		ManagerBLDriver managerDriver = new ManagerBLDriver(manager);
		managerDriver.drive();
		//财务人员的驱动程序
		FinancialBlService financial = new Financial();
		FinancialBLDriver driver = new FinancialBLDriver(financial);
		driver.drive();
		
		//库存管理人员的启动程序
	//	initial.initialStock();
		StockManagerDriver smd=new StockManagerDriver();
			
	}
}
