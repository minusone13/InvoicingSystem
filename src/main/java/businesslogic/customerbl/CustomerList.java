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
		
		public boolean updateCustomer(CustomerVO newCustomerVO){
			Customer newCustomer = new Customer(newCustomerVO);
			CustomerPO po = new CustomerPO();
			po = newCustomer.getPO();
			return customerdata.updateCustomer(po);
		}
		
		public ArrayList<CustomerVO> getAllCustomer(){
			//读取地址是固定的ma?
			return null;
		}
		//这边的命名和梅杰要商量一下；

		public ArrayList<CustomerVO> getCustomer(String address) {
			ArrayList<CustomerVO> listOfCustomer = this.getAllCustomer();
			return listOfCustomer;
		}
		
		/*
		 public void saveAllCustomer(ArrayList<CustomerPO> listOfCustomerPO){
		 	customerdata.saveAllCustomer(listOfCustomerPO);
		 } 
		 
		 * */
		public void saveCustomer(String address) {
			// TODO Auto-generated method stub
			
		}
		
}
