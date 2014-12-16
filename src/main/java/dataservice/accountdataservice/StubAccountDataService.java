package dataservice.accountdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.AccountPO;



public interface StubAccountDataService extends Remote{
	public AccountPO find(AccountPO a);
	
	public boolean add(AccountPO a) ;
	
	public boolean delete(AccountPO apo);
	
	public boolean update(AccountPO apo);
	
	public ArrayList<AccountPO> fuzzyFindAccount(String s, int precision);
	
	public ArrayList<AccountPO> getAllAcountInfo ();
	
	public void saveAccount(String filename);
}
