 package businesslogic.accountbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.accountdataservice.AccountBuildService;
import dataservice.accountdataservice.AccountDataService;
import businesslogic.commoditybl.StubCommodityList;
import businesslogic.customerService.CustomerForFinancial;
import businesslogic.customerbl.CustomerList;
import businesslogic.stockmanagerbl.StubStockController;
import po.AccountPO;
import vo.CustomerVO;
import vo.accountVO.AccountVO;

public class AccountList {
	
	

	public boolean addAccount(Account account) {
		AccountDataService a = null;
		try {
			try
			{
				a = (AccountDataService)Naming.lookup("rmi://127.0.0.1:1099/AccountData");
			}
			catch (MalformedURLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		AccountPO apo = new AccountPO();
		apo.setName(account.name);
		apo.setBalance(account.balance);	
		try {
			return a.add(apo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteAccount(Account account) {
		AccountDataService a = null;
		try {
			try
			{
				a = (AccountDataService)Naming.lookup("rmi://127.0.0.1:1099/AccountData");
			}
			catch (MalformedURLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		AccountPO apo = new AccountPO();
		apo.setName(account.name);
		try {
			return a.delete(apo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateAccount(Account account, String newname) {
		AccountDataService a = null;
		try {
			try
			{
				a = (AccountDataService)Naming.lookup("rmi://127.0.0.1:1099/AccountData");
			}
			catch (MalformedURLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		AccountPO apo = new AccountPO();
		apo.setName(account.name);
		apo.setNewName(newname);
		try {
			return a.update(apo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<AccountVO> fuzzyFindAccount(String s, int precision) {
		AccountDataService a = null;
		try {
			try
			{
				a = (AccountDataService)Naming.lookup("rmi://127.0.0.1:1099/AccountData");
			}
			catch (MalformedURLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<AccountPO> accountPOList = null;
		try {
			accountPOList = a.fuzzyFindAccount(s, precision);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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
		AccountDataService a = null;
		try {
			try
			{
				a = (AccountDataService)Naming.lookup("rmi://127.0.0.1:1099/AccountData");
			}
			catch (MalformedURLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		AccountPO apo = new AccountPO();
		apo.setName(account.name);
		try {
			apo = a.find(apo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(apo == null) return null;
		AccountVO avo = new AccountVO();
		
		avo.setBalance(apo.getBalance());
		avo.setName(apo.getName());
		return avo;
	}
	
	public void buildAccount() throws RemoteException {		
		AccountBuildService build = null;
		try
		{
			build = (AccountBuildService)Naming.lookup("rmi://127.0.0.1:1099/AccountBuild");
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (NotBoundException e)
		{
			e.printStackTrace();
		}
		build.saveCommodity();
		build.saveAccount();
		build.saveCustomer();
		build.saveVersion();
	}
	
	public ArrayList<String> getVersions() {
		AccountBuildService build = null;
		try
		{
			build = (AccountBuildService)Naming.lookup("rmi://127.0.0.1:1099/AccountBuild");
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (NotBoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			return build.getVersion();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<CustomerVO> getOldCustomersInfo(String version) {
		CustomerForFinancial cff = new CustomerList();
		return cff.getCustomer(version);
	}
	public ArrayList<AccountVO> getOldAccountsInfo(String version) {
		AccountBuildService build = null;
		try
		{
			build = (AccountBuildService)Naming.lookup("rmi://127.0.0.1:1099/AccountBuild");
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (NotBoundException e)
		{
			e.printStackTrace();
		}
		ArrayList<AccountPO> accountsPO = null;
		try
		{
			accountsPO = build.getAccount(version);
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		ArrayList<AccountVO> accountsVO = new ArrayList<AccountVO>();
		int size = accountsPO.size();
		for(int i=0;i<size;i++) {
			accountsVO.add(new AccountVO(accountsPO.get(i).getName(), 
					accountsPO.get(i).getBalance()));
			
		}
		return accountsVO;
	}
	public ArrayList<Account> getAllAccountInfo() {
		AccountDataService a = null;
		try {
			try
			{
				a = (AccountDataService)Naming.lookup("rmi://127.0.0.1:1099/AccountData");
			}
			catch (MalformedURLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<AccountPO> accList = null;
		try {
			accList = a.getAllAcountInfo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Account> accounts = new ArrayList<Account>();
		int size = accList.size();
		for(int i=0;i<size;i++) {
			AccountPO temp = accList.get(i);
			Account account = new Account();
			account.fromPOtoAccount(temp);
			accounts.add(account);
		}
		return accounts;
	}
	
	public void saveAccounts(ArrayList<Account> accounts) {
		AccountDataService a = null;
		try {
			try
			{
				a = (AccountDataService)Naming.lookup("rmi://127.0.0.1:1099/AccountData");
			}
			catch (MalformedURLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<AccountPO> poList = new ArrayList<AccountPO>();
		int size = accounts.size();
		for(int i=0;i<size;i++) {
			poList.add(accounts.get(i).toPO());			
		}
		try {
			a.writer(poList);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
