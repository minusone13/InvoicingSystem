package data.accountdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.AccountPO;
import data.Tool;
import data.commoditydata.StubStockDataController;
import data.customerServiceForFinancial.customerServiceForFinancial;
import data.customerdata.CustomerData;
import data.stockservice.StockDataForFinancial;
import dataservice.accountdataservice.StubAccountDataService;

public class AccountBuild{
	String version=null;
	public AccountBuild() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//change yyyy/MM/dd to this by lhw
		version = format.format(new Date());
	}
	public void saveAccount() {
		StubAccountDataService a = null;
		try {
			a = new AccountData();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		try {
			a.saveAccount("accountBuild\\accountInfo\\"+version+".ser");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	public void saveCommodity() {
		StockDataForFinancial sd = StubStockDataController.getInstance();
		sd.saveAndBuild("accountBuild\\commodity\\"+version+".ser");		
	}
	
	public void saveCustomer() throws RemoteException {
		customerServiceForFinancial cff = new CustomerData();
		cff.saveCustomer("accountBuild\\customerInfo\\"+version+".ser");
	}
	
	public void saveVersion() {
		ArrayList<String> versions = getVersion();
		if(versions==null) versions = new ArrayList<String>();
		int size = versions.size();
		String temp="";
		if(size!=0) {
			temp = versions.get(size-1);
		} 
		if(!temp.equals(version))
			versions.add(version);
		String filename = "version.ser";
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();			
		}
		try {
			oos.writeObject(versions);
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
	
	public ArrayList<String> getVersion() {
		File filename = Tool.Opendoc("version.ser");
		
		ArrayList<String> versions = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			versions = (ArrayList<String>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(versions!=null) return versions;
		else return null;
	}
	
	public ArrayList<AccountPO> getAccount(String version) {
		File filename = Tool.Opendoc("accountBuild\\accountInfo\\"+version+".ser");
		
		ArrayList<AccountPO> accountList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
				accountList = (ArrayList<AccountPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(accountList!=null) return accountList;
		else return null;
	}
	
	
}
