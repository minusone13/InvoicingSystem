package dataservice.customerdataservice;

import java.util.ArrayList;

import po.CustomerPO;



public interface CustomerDataService {
	public boolean addCustomer(CustomerPO po);
	public CustomerPO findCustomer(String name);
	public boolean deleteCustomer(String name);
	public boolean updateCustomer(CustomerPO po);
	public ArrayList<CustomerPO> getAllCustomer(String address);
	public void saveAllCustomer(ArrayList<CustomerPO> listOfCustomerPO,String address);
	
}
