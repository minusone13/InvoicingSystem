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
			ArrayList<CustomerVO> listOfCustomerVO = new ArrayList<CustomerVO>();
			ArrayList<CustomerPO> listOfCustomerPO = customerdata.getAllCustomer();
			for(CustomerPO po: listOfCustomerPO){
				Customer customer = new Customer();
				customer.setPO(po);
				CustomerVO vo = customer.getVO();
				listOfCustomerVO.add(vo);
			}
			return listOfCustomerVO;
		}
		
		//数据层的那个数据需要读入地址作为参数吗？
		//感觉是需要的啊。。
		//这边的命名和梅杰要商量一下；

		public ArrayList<CustomerVO> getCustomer(String address) {
			ArrayList<CustomerVO> listOfCustomerVO = this.getAllCustomer();
			return listOfCustomerVO;
		}
		
		/*
		 public void saveAllCustomer(ArrayList<CustomerPO> listOfCustomerPO){
		 	customerdata.saveAllCustomer(listOfCustomerPO);
		 } 
		 
		//这个方法是把现在ArrayList里的po序列化得保存到目标地址;
		 
		 * */
		public void saveCustomer(String address) {
			ArrayList<CustomerVO> listOfCustomerVO = this.getAllCustomer();
			ArrayList<CustomerPO> listOfCustomerPO = new ArrayList<CustomerPO>();
			for(CustomerVO vo:listOfCustomerVO){
				Customer customer = new Customer(vo);
				CustomerPO po = customer.getPO();
				listOfCustomerPO.add(po);
			}
			customerdata.saveAllCustomer(listOfCustomerPO);
			//这个方法是把已有的客户整体搬迁到另一个文档里;
		}
		
}
