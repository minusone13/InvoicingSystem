package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;

public interface AccountBuildService extends Remote {
	
	public void saveAccount()throws RemoteException;

	public void saveCommodity()throws RemoteException;
	
	public void saveCustomer() throws RemoteException;
	
	public void saveVersion()throws RemoteException;
	
	public ArrayList<String> getVersion() throws RemoteException;
	
	public ArrayList<AccountPO> getAccount(String version) throws RemoteException;
}
