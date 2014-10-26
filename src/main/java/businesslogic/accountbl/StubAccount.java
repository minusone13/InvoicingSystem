 package businesslogic.accountbl;

import java.util.ArrayList;

import businesslogic.commoditybl.StubCommodityList;
import businesslogic.stockmanagerbl.StubStockManager;
import po.AccountPO;
import vo.AccountVO;

public class StubAccount {
	String name;//账户名
	double balance;//余额
	
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
		//调用数据层
		return true;
	}
	
	public boolean deleteAccount(String name) {
		//调用数据层
		return true;
	}
	
	public boolean updateAccount(String oldname, String newname) {
		//调用数据层
		return true;
	}
	public AccountVO findAccount(String name) {
		//调用数据层
		return null;
	}
	
	public void buildAccount() {
		StubCommodityList scl = new StubStockManager().getCommodityList();//调用商品信息
		 //调用客户信息
		ArrayList<AccountPO> acc= getAllAccountInfo();//调用账户信息
	}
	
	public ArrayList<AccountPO> getAllAccountInfo() {
		//调用数据层
		return null;
	}
}
