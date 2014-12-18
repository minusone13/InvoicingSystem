package dataservice.customerdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CustomerPO;



public interface CustomerDataService extends Remote{
	public boolean addCustomer(CustomerPO po) throws RemoteException;
	public CustomerPO findCustomer(String name) throws RemoteException;
	public boolean deleteCustomer(String name) throws RemoteException;
	public boolean updateCustomer(CustomerPO po) throws RemoteException;
	public ArrayList<CustomerPO> getAllCustomer(String address) throws RemoteException;
	public void saveAllCustomer(ArrayList<CustomerPO> listOfCustomerPO,String address) throws RemoteException;
	
}
