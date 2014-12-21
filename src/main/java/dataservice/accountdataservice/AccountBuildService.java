package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;

public interface AccountBuildService extends Remote {
	
	public void saveAccount();

	public void saveCommodity();
	
	public void saveCustomer() throws RemoteException;
	
	public void saveVersion();
	
	public ArrayList<String> getVersion();
	
	public ArrayList<AccountPO> getAccount(String version);
}
