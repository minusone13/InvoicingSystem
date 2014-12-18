 package businesslogic.accountbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.accountdata.AccountBuild;
import data.accountdata.AccountData;
import data.commoditydata.StubStockDataController;
import data.stockservice.StockDataForFinancial;
import dataservice.accountdataservice.StubAccountDataService;
import businesslogic.commoditybl.StubCommodityList;
import businesslogic.customerService.CustomerForFinancial;
import businesslogic.customerbl.CustomerList;
import businesslogic.stockmanagerbl.StubStockController;
import po.AccountPO;
import vo.CustomerVO;
import vo.accountVO.AccountVO;

public class AccountList {
	
	StubAccountDataService a = new AccountData();

	public boolean addAccount(Account account) {
		AccountPO apo = new AccountPO();
		apo.setName(account.name);
		apo.setBalance(account.balance);	
		return a.add(apo);
	}
	
	public boolean deleteAccount(Account account) {
		AccountPO apo = new AccountPO();
		apo.setName(account.name);
		return a.delete(apo);
	}
	
	public boolean updateAccount(Account account, String newname) {
		AccountPO apo = new AccountPO();
		apo.setName(account.name);
		apo.setNewName(newname);
		return a.update(apo);
	}
	
	public ArrayList<AccountVO> fuzzyFindAccount(String s, int precision) {
		ArrayList<AccountPO> accountPOList = a.fuzzyFindAccount(s, precision);
		ArrayList<AccountVO> accountVOList = new ArrayList<AccountVO>();
		int size = accountPOList.size();
		for(int i=0;i<size;i++) {
			AccountVO avo = new AccountVO();
			AccountPO apo = accountPOList.get(i);
			avo.setBalance(apo.getBalance());
			avo.setName(apo.getName());
			accountVOList.add(avo);
		}
		return accountVOList;
	}
	public AccountVO findAccount(Account account) {
		AccountPO apo = new AccountPO();
		apo.setName(account.name);
		apo = a.find(apo);
		if(apo == null) return null;
		AccountVO avo = new AccountVO();
		
		avo.setBalance(apo.getBalance());
		avo.setName(apo.getName());
		return avo;
	}
	
	public void buildAccount() throws RemoteException {
		String str="";		
		//new CustomerController().findCustomer(str); //调用客户信息
		AccountBuild build = new AccountBuild();
		build.saveCommodity();
		build.saveAccount();
		build.saveCustomer();
		build.saveVersion();
	}
	
	public ArrayList<String> getVersions() {
		AccountBuild build = new AccountBuild();
		return build.getVersion();
	}
	public ArrayList<CustomerVO> getOldCustomersInfo(String version) {
		CustomerForFinancial cff = new CustomerList();
		return cff.getCustomer(version);
	}
	public ArrayList<AccountVO> getOldAccountsInfo(String version) {
		AccountBuild build = new AccountBuild();
		ArrayList<AccountPO> accountsPO = build.getAccount(version);
		ArrayList<AccountVO> accountsVO = new ArrayList<AccountVO>();
		int size = accountsPO.size();
		for(int i=0;i<size;i++) {
			accountsVO.add(new AccountVO(accountsPO.get(i).getName(), 
					accountsPO.get(i).getBalance()));
			
		}
		return accountsVO;
	}
	public ArrayList<Account> getAllAccountInfo() {
		ArrayList<AccountPO> accList = a.getAllAcountInfo();
		ArrayList<Account> accounts = new ArrayList<Account>();
		int size = accList.size();
		for(int i=0;i<size;i++) {
			AccountPO temp = accList.get(i);
			Account a = new Account();
			a.fromPOtoAccount(temp);
			accounts.add(a);
		}
		return accounts;
	}
	
	public void saveAccounts(ArrayList<Account> accounts) {
		ArrayList<AccountPO> poList = new ArrayList<AccountPO>();
		int size = accounts.size();
		for(int i=0;i<size;i++) {
			poList.add(accounts.get(i).toPO());			
		}
		a.writer(poList);
	}
}
