 package businesslogic.accountbl;

import java.util.ArrayList;

import data.accountdata.AccountData;
import dataservice.accountdataservice.AccountDataService;
import businesslogic.commoditybl.StubCommodityList;
import businesslogic.salebl.StubSale;
import businesslogic.stockmanagerbl.StubStockManager;
import po.AccountPO;
import vo.AccountVO;

public class StubAccount {
	String name;//账户名
	double balance;//余额
	AccountDataService a = new AccountData();
	public StubAccount() {
		this(null, 0);
	}
	
	public StubAccount(String n) {
		this(n,0);
	}
	
	public StubAccount(String n, double b) {
		name = n;
		balance = b;
	}
	
	public boolean addAccount(String name) {
		AccountPO apo = new AccountPO();
		apo.setName(name);
		apo.setBalance(0);
		a.add(apo);
		return true;
	}
	
	public boolean deleteAccount(String name) {
		AccountPO apo = new AccountPO();
		apo.setName(name);
		a.delete(apo);
		return true;
	}
	
	public boolean updateAccount(String oldname, String newname) {
		AccountPO apo = new AccountPO();
		apo.setName(oldname);
		apo.setNewName(newname);
		return true;
	}
	public AccountVO findAccount(String name) {
		AccountPO apo = new AccountPO();
		apo.setName(name);
		a.find(name);
		return null;
	}
	
	public void buildAccount() {
		String str="";
		StubCommodityList scl = new StubStockManager().getCommodityList();//调用商品信息
		new StubSale().findCustomer(str); //调用客户信息
		ArrayList<AccountPO> acc= getAllAccountInfo();//调用账户信息
	}
	
	public ArrayList<AccountPO> getAllAccountInfo() {
		ArrayList<AccountPO> accList = a.getAllAcountInfo();
		return accList;
	}
}
