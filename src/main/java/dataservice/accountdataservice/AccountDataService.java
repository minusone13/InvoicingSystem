package dataservice.accountdataservice;

import java.util.ArrayList;

import po.AccountPO;



public interface AccountDataService {
	public AccountPO find(String name);
	
	public boolean add(AccountPO a) ;
	
	public boolean delete(AccountPO apo);
	
	public boolean update(AccountPO apo);
	public ArrayList<AccountPO> getAllAcountInfo ();
}
