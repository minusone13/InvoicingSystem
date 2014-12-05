 package businesslogic.accountbl;

import java.util.ArrayList;

import data.accountdata.AccountBuild;
import data.accountdata.AccountData;
import dataservice.accountdataservice.StubAccountDataService;
import businesslogic.commoditybl.StubCommodityList;
import businesslogic.stockmanagerbl.StubStockController;
import po.AccountPO;
import vo.accountVO.AccountVO;

public class AccountList {
	
	StubAccountDataService a = new AccountData();

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
		//new CustomerController().findCustomer(str); //调用客户信息
		AccountBuild build = new AccountBuild();
		build.saveCommodity();
		build.saveAccount();
		build.saveVersion();
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
	public ArrayList<AccountPO> getAllAccountInfo() {
		ArrayList<AccountPO> accList = a.getAllAcountInfo();
		return accList;
	}
}
