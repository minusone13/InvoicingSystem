package data.accountdata;

import java.util.ArrayList;

import po.AccountPO;
import data.commoditydata.StubStockDataController;
import data.stockservice.StockDataForFinancial;
import dataservice.accountdataservice.StubAccountDataService;

public class AccountBuild {
	//未完成分版本功能，差客户信息
	public void saveAccount() {
		StubAccountDataService a = new AccountData();
		a.saveAccount("accountBuild\\accountInfo.ser");
	}
	
	public void saveCommodity() {
		StockDataForFinancial sd = StubStockDataController.getInstance();
		sd.save("accountBuild\\commodityInfo.ser");		
	}
}
