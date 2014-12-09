package data.customerdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.CustomerPO;
import po.SaleBackSheetPO;
import dataservice.customerdataservice.CustomerDataService;

public class CustomerData implements CustomerDataService{

	public CustomerData(){}
	
	public boolean addCustomer(CustomerPO po) {
		String address = "Customer.txt";
		ArrayList<CustomerPO> listOfCustomerPO = new ArrayList<CustomerPO>();
		listOfCustomerPO = this.getAllCustomer(address); 
		listOfCustomerPO.add(po);
		this.saveAllCustomer(listOfCustomerPO, address);
		return true;
	}

	public boolean deleteCustomer(String name) {
		String address = "Customer.txt";
		ArrayList<CustomerPO> listOfCustomerPO = new ArrayList<CustomerPO>();
		listOfCustomerPO = this.getAllCustomer(address); 
		for(CustomerPO po:listOfCustomerPO){
			if(po.getname().equals(name)){
				listOfCustomerPO.remove(po);
				this.saveAllCustomer(listOfCustomerPO, address);
				return true;
			}
		}
		return false;
	}

	public boolean updateCustomer(CustomerPO po) {
		String address = "Customer.txt";
		ArrayList<CustomerPO> listOfCustomerPO = new ArrayList<CustomerPO>();
		listOfCustomerPO = this.getAllCustomer(address); 
		for(CustomerPO temppo:listOfCustomerPO){
			if(temppo.getname().equals(po.getname())){
				listOfCustomerPO.remove(temppo);
				listOfCustomerPO.add(po);
				this.saveAllCustomer(listOfCustomerPO, address);
				return true;
			}
		}
		return false;
	}

	public CustomerPO findCustomer(String name) {
		String address = "Customer.txt";
		ArrayList<CustomerPO> listOfCustomerPO = new ArrayList<CustomerPO>();
		listOfCustomerPO = this.getAllCustomer(address); 
		for(CustomerPO po:listOfCustomerPO){
			if(po.getname().equals(name)){
				return po;
			}
		}
		return null;
	}

	public ArrayList<CustomerPO> getAllCustomer(String address) {
		ArrayList<CustomerPO> listOfCustomerPO = new ArrayList<CustomerPO>();
		ObjectInputStream ois=null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(address));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			listOfCustomerPO = (ArrayList<CustomerPO>) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(listOfCustomerPO!=null) return listOfCustomerPO;
		else return null;
	}

	public void saveAllCustomer(ArrayList<CustomerPO> listOfCustomerPO,String address) {
		// TODO Auto-generated method stub
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(address));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		try {
			oos.writeObject(listOfCustomerPO);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}




}
