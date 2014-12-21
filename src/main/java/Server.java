import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.accountdata.AccountData;
import data.billdata.CommodityBillSaver;
import data.billdata.FinancialBillSaver;
import data.billdata.SaleBillSaver;
import data.commoditydata.StubStockDataController;
import data.customerdata.CustomerData;
import data.strategydata.StrategySaver;
import data.userdata.UserDataController;
import dataservice.accountdataservice.StubAccountDataService;
import dataservice.billdataservice.CommodityBillSaverService;
import dataservice.billdataservice.FinancialBillSaverService;
import dataservice.billdataservice.SaleBillSaverService;
import dataservice.commoditydataservice.StubCommodityDataService;
import dataservice.customerdataservice.CustomerDataService;
import dataservice.strategydataservice.StrategySaverService;
import dataservice.userdataservice.StubUserDataService;


public class Server
{
	public static void main(String args[]){
		 try
		{
			CustomerDataService customerdataservice= new CustomerData();
			StubAccountDataService accountdataservice = new AccountData();
			CommodityBillSaverService commoditybillsaver = new CommodityBillSaver();
			FinancialBillSaverService financialbillsaver = new FinancialBillSaver();
			SaleBillSaverService salebillsaver = new SaleBillSaver();
			StubCommodityDataService commoditydata = StubStockDataController.getInstance();
			StrategySaverService strategysaver = new StrategySaver();
			StubUserDataService userdatacontroller = UserDataController.getInstance();
			//这里我并没有理解单体模式;所以我擅自变动了user和Commodity方面的两个构造函数的可见性;
			LocateRegistry.createRegistry(1099);
			Naming.bind("rmi://127.0.0.1:1099/CustomerData",customerdataservice);
			Naming.bind("rmi://127.0.0.1:1099/AccountData",accountdataservice);
			Naming.bind("rmi://127.0.0.1:1099/CommodityBillSaver",commoditybillsaver);
			Naming.bind("rmi://127.0.0.1:1099/FinancialBillSaver",financialbillsaver);
			Naming.bind("rmi://127.0.0.1:1099/SaleBillSaver",salebillsaver);
			Naming.bind("rmi://127.0.0.1:1099/StubStockDataController",commoditydata);
			Naming.bind("rmi://127.0.0.1:1099/StrategySaver",strategysaver);
			Naming.bind("rmi://127.0.0.1:1099/UserDataController",userdatacontroller);
			
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
