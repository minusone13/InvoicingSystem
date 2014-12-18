package dataservice.customerdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.CustomerPO;



public interface CustomerDataService extends Remote{
	public boolean addCustomer(CustomerPO po);
	public CustomerPO findCustomer(String id);
	public boolean deleteCustomer(String id);
	public boolean updateCustomer(CustomerPO po);
	public ArrayList<CustomerPO> getAllCustomer(String address);
	public void saveAllCustomer(ArrayList<CustomerPO> listOfCustomerPO,String address);
}
