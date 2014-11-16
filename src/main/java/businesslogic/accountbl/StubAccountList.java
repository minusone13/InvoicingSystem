 package businesslogic.accountbl;

import java.util.ArrayList;

import data.accountdata.StubAccountData;
import dataservice.accountdataservice.StubAccountDataService;
import businesslogic.commoditybl.StubCommodityList;
import businesslogic.salebillbl.StubSale;
import businesslogic.stockmanagerbl.StubStockController;
import po.AccountPO;
import vo.AccountVO;

public class StubAccountList {
	
	StubAccountDataService a = new StubAccountData();

	public boolean addAccount(StubAccount account) {
		AccountPO apo = new AccountPO();
		apo.setName(account.name);
		apo.setBalance(account.balance);	
		return a.add(apo);
	}
	
	public boolean deleteAccount(StubAccount account) {
		AccountPO apo = new AccountPO();
		apo.setName(account.name);
		return a.delete(apo);
	}
	
	public boolean updateAccount(StubAccount account, String newname) {
		AccountPO apo = new AccountPO();
		apo.setName(account.name);
		apo.setNewName(newname);
		return a.update(apo);
	}
	
	public AccountVO findAccount(StubAccount account) {
		AccountPO apo = new AccountPO();
		apo.setName(account.name);
		apo = a.find(apo);
		if(apo == null) return null;
		AccountVO avo = new AccountVO();
		
		avo.setBalance(apo.getBalance());
		avo.setName(apo.getName());
		return avo;
	}
	
	public void buildAccount() {
		String str="";
		StubCommodityList scl = new StubStockController().getCommodityList();//调用商品信息
		new StubSale().findCustomer(str); //调用客户信息
		ArrayList<AccountPO> acc= getAllAccountInfo();//调用账户信息
	}
	
	public ArrayList<AccountPO> getAllAccountInfo() {
		ArrayList<AccountPO> accList = a.getAllAcountInfo();
		return accList;
	}
}
