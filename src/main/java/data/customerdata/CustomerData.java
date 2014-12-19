package data.customerdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.CustomerPO;
import po.Tool;
import data.customerServiceForFinancial.customerServiceForFinancial;
import dataservice.customerdataservice.CustomerDataService;

public class CustomerData extends UnicastRemoteObject implements CustomerDataService,customerServiceForFinancial{

	public CustomerData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean addCustomer(CustomerPO po) throws RemoteException {
		String address = "Customer.txt";
		ArrayList<CustomerPO> listOfCustomerPO = new ArrayList<CustomerPO>();
		listOfCustomerPO = this.getAllCustomer(address); 
		listOfCustomerPO.add(po);
		this.saveAllCustomer(listOfCustomerPO, address);
		return true;
	}

	public boolean deleteCustomer(String name) throws RemoteException {
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

	public boolean updateCustomer(CustomerPO po)throws RemoteException {
		String address = "Customer.txt";
		ArrayList<CustomerPO> listOfCustomerPO = new ArrayList<CustomerPO>();
		listOfCustomerPO = this.getAllCustomer(address); 
		for(CustomerPO temppo:listOfCustomerPO){
			if(temppo.getid().equals(po.getid())){
				listOfCustomerPO.remove(temppo);
				listOfCustomerPO.add(po);
				this.saveAllCustomer(listOfCustomerPO, address);
				return true;
			}
		}
		return false;
	}

	public CustomerPO findCustomer(String id) throws RemoteException{
		String address = "Customer.txt";
		ArrayList<CustomerPO> listOfCustomerPO = new ArrayList<CustomerPO>();
		listOfCustomerPO = this.getAllCustomer(address); 
		for(CustomerPO po:listOfCustomerPO){
			if(po.getid().equals(id)){
				return po;
			}
		}
		return new CustomerPO("娌′汉");
	}

	public ArrayList<CustomerPO> getAllCustomer(String addre) throws RemoteException{
		ArrayList<CustomerPO> listOfCustomerPO = new ArrayList<CustomerPO>();
		ObjectInputStream ois=null;
		File address = Tool.Opendoc(addre);
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
		else return new ArrayList<CustomerPO>();
	}

	public void saveAllCustomer(ArrayList<CustomerPO> listOfCustomerPO,String address) throws RemoteException{
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



	public void saveCustomer(String address) throws RemoteException {
		ArrayList<CustomerPO> listOfPO = null;
		try {
			listOfPO = this.getAllCustomer("Customer.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.saveAllCustomer(listOfPO, address);
	}




}
