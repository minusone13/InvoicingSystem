package data.accountdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.AccountPO;
import data.commoditydata.StubCommodityList;
import data.commoditydata.StubStockDataController;
import dataservice.accountdataservice.StubAccountDataService;

public class StubAccountData implements StubAccountDataService{
	
	
	public ArrayList<AccountPO> getAcountList () {
		return null;
	}

	public AccountPO find(String name) {
		
		return null;
	}

	public boolean add(AccountPO a) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!");
		ArrayList<AccountPO> accountList = reader();
		if(accountList == null) accountList = new ArrayList<AccountPO>();
		accountList.add(a);
		return writer(accountList);
	}

	public boolean delete(AccountPO apo) {
		
		return false;
	}

	public boolean update(AccountPO apo) {
		return false;
	}
	
	//读取以序列化存储的账户列表对象
	private ArrayList<AccountPO> reader() {
		File filename = StubStockDataController.Opendoc("account.txt");
		//initial
		/*
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        try {
			oos.writeObject(new ArrayList<AccountPO>());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			oos.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //end of initial
		*/
		System.out.println("before");
		
		System.out.println("after");
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
	
	//以序列化方式存储账户列表
	private boolean writer (ArrayList<AccountPO> accountList) {
		String filename = "account.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		try {
			oos.writeObject(accountList);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public ArrayList<AccountPO> getAllAcountInfo() {	
		return reader();
	}
}
