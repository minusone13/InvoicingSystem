package dataservice.customerdataservice;

import java.util.ArrayList;

import po.CustomerPO;



public interface CustomerDataService {
	public boolean addCustomer(CustomerPO po);
	public CustomerPO getAll();
	public ArrayList<CustomerPO> findCommodity(String name);
	public boolean deleteCommodity(String name, String model);
	public boolean updateCommodity(CustomerPO po);
	public boolean addCategory(String parent, String name);
}
