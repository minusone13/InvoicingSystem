package dataservice;

import java.net.MalformedURLException;
import java.nio.channels.AlreadyBoundException;
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

public class Server {
		public static void main(String args[]){
			try { 
	            //创建一些远程对象; 
	            StubAccountDataService accountdataservice = new AccountData();
	            CommodityBillSaverService commoditybillsaverservice = new CommodityBillSaver();
	            FinancialBillSaverService financialbillsaverservice = new FinancialBillSaver();
	            SaleBillSaverService salebillsaver = new SaleBillSaver();
	            CustomerDataService customerdataservice= new CustomerData();
	            StrategySaverService strategysaverservice = new StrategySaver();
	            
	            //StubCommodityDataService commoditydataservice = new StubStockDataController();
	            //StubUserDataService userdataservice = new UserDataController();
	            //楼上两个的朋友构造方法是有权限的，我无法访问;
	           
	            //本地主机上的远程对象注册表Registry的实例，并指定端口为8888，这一步必不可少（Java默认端口是1099），必不可缺的一步，缺少注册表创建，则无法绑定对象到远程注册表上 
	            LocateRegistry.createRegistry(8888); 

	            
					Naming.bind("rmi://localhost:8888/RHello",accountdataservice);
					Naming.bind("rmi://localhost:8888/RHello",commoditybillsaverservice);
					Naming.bind("rmi://localhost:8888/RHello",financialbillsaverservice);
					Naming.bind("rmi://localhost:8888/RHello",salebillsaver);
					Naming.bind("rmi://localhost:8888/RHello",customerdataservice);
					Naming.bind("rmi://localhost:8888/RHello",strategysaverservice);
					//Naming.bind("rmi://localhost:8888/RHello",commoditydataservice);
					//Naming.bind("rmi://localhost:8888/RHello",userdataservice);
	        } catch (RemoteException e) { 
	            System.out.println("创建远程对象发生异常！"); 
	            e.printStackTrace(); 
	        } catch (AlreadyBoundException e) { 
	            System.out.println("发生重复绑定对象异常！"); 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            System.out.println("发生URL畸形异常！"); 
	            e.printStackTrace(); 
	        } catch (java.rmi.AlreadyBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
}
