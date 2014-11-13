 package businesslogic.accountbl;

import java.util.ArrayList;

import data.accountdata.StubAccountData;
import dataservice.accountdataservice.StubAccountDataService;
import businesslogic.commoditybl.StubCommodityList;
import businesslogic.salebl.StubSale;
import businesslogic.stockmanagerbl.StubStockController;
import po.AccountPO;
import vo.AccountVO;

public class StubAccount {
	String name;//账户名
	double balance;//余额
	StubAccountDataService a = new StubAccountData();
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
		return a.add(apo);
	}
	
	public boolean deleteAccount(String name) {
		AccountPO apo = new AccountPO();
		apo.setName(name);
		return a.delete(apo);
	}
	
	public boolean updateAccount(String oldname, String newname) {
		AccountPO apo = new AccountPO();
		apo.setName(oldname);
		apo.setNewName(newname);
		return a.update(apo);
	}
	public AccountVO findAccount(String name) {
		AccountPO apo = new AccountPO();
		apo.setName(name);
		a.find(name);
		return null;
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
