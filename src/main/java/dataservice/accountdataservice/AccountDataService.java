package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;



public interface AccountDataService extends Remote{
	public AccountPO find(AccountPO a) throws RemoteException;
	
	public boolean add(AccountPO a) throws RemoteException;
	
	public boolean delete(AccountPO apo)throws RemoteException;
	
	public boolean update(AccountPO apo)throws RemoteException;
	
	public ArrayList<AccountPO> fuzzyFindAccount(String s, int precision)throws RemoteException;
	
	public ArrayList<AccountPO> getAllAcountInfo ()throws RemoteException;
	
	public void saveAccount(String filename)throws RemoteException;
	
	public void writer (ArrayList<AccountPO> accountList)throws RemoteException;
}
