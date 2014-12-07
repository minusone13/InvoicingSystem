package businesslogic.customerbl;

import java.util.ArrayList;

import businesslogic.customerService.CustomerForFinancial;
import businesslogicservice.customerblservice.CustomerBlService;
import po.CustomerPO;
import vo.CustomerVO;
import vo.RM;
import data.customerdata.CustomerData;
import dataservice.customerdataservice.CustomerDataService;

public class CustomerList implements CustomerForFinancial, CustomerBlService{
		/*
		 * 这里面都是bCustomer。
		 * */
		
		CustomerDataService customerdata = new CustomerData();
		
		public boolean addCustomer(Customer newCustomer){
			CustomerPO po = new CustomerPO();
			po = newCustomer.getPO();
			return customerdata.addCustomer(po);
		}
		
		public boolean deleteCustomer(String name){
			return customerdata.deleteCustomer(name);
		}
		
		public CustomerVO findCustomer(String name){
			CustomerVO vo = new CustomerVO();
			Customer newCustomer = new Customer();
			newCustomer.setPO(customerdata.findCustomer(name));//判断下是否存在，到时候再说吧。。
			vo=newCustomer.getVO();
			return vo;
		}
		
		public boolean updateCustomer(Customer newCustomer){
			CustomerPO po = new CustomerPO();
			po = newCustomer.getPO();
			return customerdata.updateCustomer(po);
		}
		
		public ArrayList<CustomerVO> getAllCustomer(){
			
			return null;
		}

		public boolean addCustomer(String name) {
			// TODO Auto-generated method stub
			return false;
		}

		public RM updateCustomer(CustomerVO vo) {
			// TODO Auto-generated method stub
			return null;
		}

		public ArrayList<CustomerVO> getCustomer(String address) {
			// TODO Auto-generated method stub
			return null;
		}

		public void saveCustomer(String address) {
			// TODO Auto-generated method stub
			
		}
		
}
