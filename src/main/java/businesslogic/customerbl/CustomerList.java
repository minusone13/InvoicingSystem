package businesslogic.customerbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.customerService.CustomerForFinancial;
import businesslogicservice.customerblservice.CustomerBlService;
import po.CustomerPO;
import po.RM;
import vo.CustomerVO;
import data.customerdata.CustomerData;
import dataservice.customerdataservice.CustomerDataService;

public class CustomerList implements CustomerForFinancial, CustomerBlService{
		/*
		 * 这里面都是bCustomer。
		 * */
	
	
		public boolean addCustomer(CustomerVO newCustomer){
			Customer customer = new Customer(newCustomer);
			CustomerPO po = customer.getPO();
			try{
				CustomerDataService customerdata = new CustomerData();
				return customerdata.addCustomer(po);}
			catch(Exception e){
				System.out.println("addCustomer 异常"+e);
			}
			return false;
		}
		
		public boolean deleteCustomer(String id){
			try{
				CustomerDataService customerdata = new CustomerData();
				return customerdata.deleteCustomer(id);}
			catch(Exception e){
				System.out.println("deteleCustomer 异常");
			}
			return false;
		}
		
		public CustomerVO findCustomer(String id){
			CustomerVO vo = new CustomerVO();
			Customer newCustomer = new Customer();
			
				CustomerDataService customerdata = null;
				try
				{
					customerdata = new CustomerData();
				}
				catch (RemoteException e)
				{

					e.printStackTrace();
				}
				try
				{
					newCustomer.setPO(customerdata.findCustomer(id));
				}
				catch (RemoteException e)
				{
					e.printStackTrace();
				}//判断下是否存在，到时候再说吧。。
				vo=newCustomer.getVO();
			return vo;
		}
		
		public boolean updateCustomer(CustomerVO newCustomerVO){
			Customer newCustomer = new Customer(newCustomerVO);
			CustomerPO po = new CustomerPO();
			po = newCustomer.getPO();
			try{
				CustomerDataService customerdata = new CustomerData();
				return customerdata.updateCustomer(po);}
			catch(Exception e){
				System.out.println("updateCustomer 异常");
			}
			return false;
		}
		
		public ArrayList<CustomerVO> getAllCustomer(String address){
			ArrayList<CustomerVO> listOfCustomerVO = new ArrayList<CustomerVO>();
			try{
				CustomerDataService customerdata = new CustomerData();
				ArrayList<CustomerPO> listOfCustomerPO = customerdata.getAllCustomer(address);
				if(listOfCustomerPO==null) return new ArrayList<CustomerVO>();
				for(CustomerPO po: listOfCustomerPO){
					Customer customer = new Customer();
					customer.setPO(po);
					CustomerVO vo = customer.getVO();
					listOfCustomerVO.add(vo);
				}
			}catch(Exception e){
				System.out.println("getAllCustomer 异常222"+e);
			}
			return listOfCustomerVO;
		}

		public ArrayList<CustomerVO> getCustomer(String address) {
			ArrayList<CustomerVO> listOfCustomerVO = this.getAllCustomer(address);
			return listOfCustomerVO;
		}
		
		public void saveCustomer(String address) {
			String Address ="Customer.txt";//保存的是一个默认的地址;
			ArrayList<CustomerVO> listOfCustomerVO = this.getCustomer(Address);
			ArrayList<CustomerPO> listOfCustomerPO = new ArrayList<CustomerPO>();
			if(listOfCustomerVO !=null) {
				for(CustomerVO vo:listOfCustomerVO){
					Customer customer = new Customer(vo);
					CustomerPO po = customer.getPO();
					listOfCustomerPO.add(po);
				}
				try{
					CustomerDataService customerdata = new CustomerData();
					customerdata.saveAllCustomer(listOfCustomerPO,address);
				}catch(Exception e){
					System.out.println("saveAllCustomer 异常1");
				}
			}
			else {
				try{
					CustomerDataService customerdata = new CustomerData();
					customerdata.saveAllCustomer(null,address);
				}catch(Exception e){
					System.out.println("saveAllCustomer 异常2");
				}
				
			}
			//这个方法是把已有的客户整体搬迁到另一个文档里;
		}

		public void changeShouldPay(String id, double hadPay) {
			CustomerVO vo = null;
			vo = this.findCustomer(id);
			vo.setShouldPay(vo.getShouldPay()-hadPay);
			this.updateCustomer(vo);
			
		}//修改应付;对应于收款单;hadpay公司给了客户多少，对应于付款单;

		public void changeShouldTake(String id, double hadGive) {
			CustomerVO vo = null;
			vo = this.findCustomer(id);
			vo.setShouldTake(vo.getShouldTake()-hadGive);
			this.updateCustomer(vo);
			
		}//修改应收;对应于收款单;hadtake公司收了客户多少，对应于收款单;
		
}
