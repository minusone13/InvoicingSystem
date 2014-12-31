import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.accountdata.AccountBuild;
import data.accountdata.AccountData;
import data.billdata.CommodityBillSaver;
import data.billdata.FinancialBillSaver;
import data.billdata.SaleBillSaver;
import data.commoditydata.StockDataController;
import data.customerdata.CustomerData;
import data.strategydata.StrategySaver;
import data.userdata.UserDataController;
import dataservice.accountdataservice.AccountBuildService;
import dataservice.accountdataservice.AccountDataService;
import dataservice.billdataservice.CommodityBillSaverService;
import dataservice.billdataservice.FinancialBillSaverService;
import dataservice.billdataservice.SaleBillSaverService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.customerdataservice.CustomerDataService;
import dataservice.strategydataservice.StrategySaverService;
import dataservice.userdataservice.UserDataService;


public class Server
{
	public static void main(String args[]){
		 try
		 {
			 
			 	String ip = "127.0.0.1:1099";
				CustomerDataService customerdataservice= new CustomerData();
				AccountDataService accountdataservice = new AccountData();
				CommodityBillSaverService commoditybillsaver = new CommodityBillSaver();
				FinancialBillSaverService financialbillsaver = new FinancialBillSaver();
				SaleBillSaverService salebillsaver = new SaleBillSaver();
				CommodityDataService commoditydata = StockDataController.getInstance();
				StrategySaverService strategysaver = new StrategySaver();
				UserDataService userdatacontroller = UserDataController.getInstance();
				AccountBuildService accountbuild = new AccountBuild();
				
				LocateRegistry.createRegistry(1099);
				Naming.bind("rmi://"+ip+"/CustomerData",customerdataservice);
				Naming.bind("rmi://"+ip+"/AccountData",accountdataservice);
				Naming.bind("rmi://"+ip+"/CommodityBillSaver",commoditybillsaver);
				Naming.bind("rmi://"+ip+"/FinancialBillSaver",financialbillsaver);
				Naming.bind("rmi://"+ip+"/SaleBillSaver",salebillsaver);
				Naming.bind("rmi://"+ip+"/StubStockDataController",commoditydata);
				Naming.bind("rmi://"+ip+"/StrategySaver",strategysaver);
				Naming.bind("rmi://"+ip+"/UserDataController",userdatacontroller);
				Naming.bind("rmi://"+ip+"/AccountBuild",accountbuild);
				System.out.println("本地服务器启动完成");
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (AlreadyBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
