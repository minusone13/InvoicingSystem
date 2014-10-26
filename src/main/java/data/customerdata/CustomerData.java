package data.customerdata;

import java.util.ArrayList;

import po.CustomerPO;
import dataservice.customerdataservice.CustomerDataService;

public class CustomerData implements CustomerDataService{

	public boolean addCustomer(CustomerPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public CustomerPO getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CustomerPO> findCommodity(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteCommodity(String name, String model) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateCommodity(CustomerPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addCategory(String parent, String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
