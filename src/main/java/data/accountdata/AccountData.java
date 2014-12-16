package data.accountdata;

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

import po.AccountPO;
import po.stockpo.CommodityPO;
import data.Tool;
import dataservice.accountdataservice.StubAccountDataService;

public class AccountData  implements StubAccountDataService{
	

	public AccountPO find(AccountPO a) {
		ArrayList<AccountPO> accountList = reader();	
		int index = traversal(accountList, a.getName());
		if(index==-1) return null;
		return accountList.get(index);
	}

	public ArrayList<AccountPO> fuzzyFindAccount(String s, int precision)
	{//precision 先默认给1，可以达到王雨城所说的算法。若取数字越高，精确度越高，搜索结果数量也就越少
		ArrayList<AccountPO> result = new ArrayList<AccountPO>();//CommodityPO is changeable
		ArrayList<AccountPO> accountList = reader();
		ArrayList<Boolean> h = new ArrayList<Boolean>();
		if(precision>s.length())
			precision = s.length();
		for(int i=0;i<accountList.size();i++)//accountList is changeable
			h.add(true);
		for(int i=0;i<accountList.size();i++)
			for(int j=0;j<=s.length()-precision;j++)
				if(!accountList.get(i).contents(s.substring(j, j+precision)))//the elements in the list must implement function: boolean contents(s)
					h.set(i, false);
		for(int i=0;i<h.size();i++)
			if(h.get(i)==true)
				result.add(accountList.get(i));//here can also be changed
		return result;
	}
	public boolean add(AccountPO apo) {
		ArrayList<AccountPO> accountList = reader();
		if(accountList == null) {
			
			accountList = new ArrayList<AccountPO>();
		}
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
	
	public void writer (ArrayList<AccountPO> accountList, String filename) {
		//String filename = "account.txt";
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
	
	public void saveAccount(String filename) {
		ArrayList<AccountPO> acc = reader();
		writer(acc, filename);	
	}
}
