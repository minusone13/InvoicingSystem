package data.accountdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.AccountPO;
import data.Tool;
import data.commoditydata.StubStockDataController;
import data.stockservice.StockDataForFinancial;
import dataservice.accountdataservice.StubAccountDataService;

public class AccountBuild {
	//差客户信息
	String version;
	public AccountBuild() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		version = format.format(new Date());
	}
	public void saveAccount() {
		StubAccountDataService a = new AccountData();
		a.saveAccount("accountBuild\\accountInfo\\"+version+".ser");
		
	}
	
	public void saveCommodity() {
		StockDataForFinancial sd = StubStockDataController.getInstance();
		sd.save("accountBuild\\commodity\\"+version+".ser");		
	}
	
	public void saveVersion () {
		ArrayList<String> versions = getVersion();
		versions.add(version);
		String filename = "accountBuild.ser";
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
		File filename = Tool.Opendoc("accountBuild.ser");
		
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
