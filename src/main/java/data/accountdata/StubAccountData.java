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
import data.Tool;
import data.commoditydata.StubCommodityList;
import dataservice.accountdataservice.StubAccountDataService;

public class StubAccountData implements StubAccountDataService{
	

	public AccountPO find(String name) {
		ArrayList<AccountPO> accountList = reader();	
		int index = traversal(accountList, name);
		if(index==-1) return null;
		return accountList.get(index);
	}

	public boolean add(AccountPO apo) {
		ArrayList<AccountPO> accountList = reader();
		if(accountList == null) accountList = new ArrayList<AccountPO>();
		int index = traversal(accountList, apo.getName());
		if(index != -1) return false;
		else accountList.add(apo);
		writer(accountList);
		return true;
	}

	public boolean delete(AccountPO apo) {
		ArrayList<AccountPO> accountList = reader();
		int index = traversal(accountList, apo.getName());
		AccountPO tempPO = null;
		if(index == -1) return false;
		tempPO = accountList.get(index);
		if(tempPO.getBalance() == 0) {
			accountList.remove(index);
			writer(accountList);
			return true;
		}
		return false;//可能因为不存在或者余额不为0;考虑用enum
	}


	public boolean update(AccountPO apo) {
		ArrayList<AccountPO> accountList = reader();
		int index1 = traversal(accountList, apo.getName());
		int index2 = traversal(accountList, apo.getNewName());
		AccountPO tempPO = null;
		if(index1 == -1||index2 != -1) return false;//可能老账户不存在，或者新账户已存在，考虑enum
		tempPO = accountList.get(index1);
		tempPO.setName(apo.getNewName());
		writer(accountList);
		return true;
	}
	
	//遍历账户列表,返回结果的下标，如果为-1说明不存在
	private int traversal (ArrayList<AccountPO> accountList, String name) {
		if(accountList == null)	return -1;
		int size = accountList.size();
		for(int i=0;i<size;i++) {//遍历所有账户
			AccountPO temp = accountList.get(i);
			String accName = temp.getName();
			if(accName.equals(name))  {//如果名称相同，并且余额为0才能删除				
					return i;				
			}
		}
		return -1;
	}
	//读取以序列化存储的账户列表对象
	private ArrayList<AccountPO> reader() {
		File filename = Tool.Opendoc("account.txt");
		
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
	private void writer (ArrayList<AccountPO> accountList) {
		String filename = "account.txt";
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} 
		try {
			oos.writeObject(accountList);
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
	
	public ArrayList<AccountPO> getAllAcountInfo() {	
		return reader();
	}
}
