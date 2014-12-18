package data.userdata;

import java.io.*;
import java.util.ArrayList;

import data.Tool;
import dataservice.userdataservice.*;
import po.*;
import po.userpo.OperationRecordPO;
import po.userpo.UserPO;

public class UserDataController implements StubUserDataService{
	private static UserDataController instance=null;
	UserList l;
	File f;
	public static UserDataController getInstance()
	{//单体模式
		if(instance==null)
			instance = new UserDataController();
		return instance;
	}
	private UserDataController()
	{
		read();
	}
	
    public void initial()
    {
        f = Tool.Opendoc(Tool.user);
        
        //some initial under;
        ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        try {
			oos.writeObject(new UserList());
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
        
        
        read();
        //some initial procedure under;
        l.initial();
        save();
    }
    
	public UserPO login(String account, String password)
	{//登陆函数，若用户名账户和密码正确，返回UserPO,里面指示了用户类型Role。登陆失败则返回NULL
		read();
		return l.login(account, password);
	}
	
	public boolean insert(UserPO po)
	{//插入一个用户（对应于增加用户）
		read();
		boolean result=l.insert(po);
		save();
		return result;
	}
	
	public UserPO find(String account)
	{//通过账号查找一个用和
		read();
		UserPO po = l.find(account);
		if(po==null)
			return null;
		return po.clone();
	}
	
	public boolean insert(OperationRecordPO po)
	{//插入关键操作记录
		read();
		boolean result=l.insert(po);
		save();
		return result;
	}
	public boolean delete(UserPO po)
	{
		read();
		boolean result=l.delete(po);
		save();
		return result;
	}
	public boolean update(UserPO po)
	{
		read();
		boolean result = l.update(po);
		save();
		return result;
	}
	public RM updatePassword(UserPO po)
	{//更改密码
		read();
		RM result=l.updatePassword(po);
		save();
		return result;
	}
	public int count(char c)
	{//用于计算指定职务已有员工数量，便于逻辑层对新的员工生成ID
		read();
		return l.count(c);
	}
	public ArrayList<UserPO> getUsers()
	{
		read();
		ArrayList<UserPO> users=l.getUsers();
		for(int i=0;i<users.size();i++)
		{
			UserPO po = users.get(i);
			users.set(i, po.clone());
		}
		return users;
	}
	public ArrayList<OperationRecordPO> getRecords() {
		read();
		return l.getRecords();
	}
	
	public void save()
	{
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        try {
			oos.writeObject(l);
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
	}
	
	public void read()
	{
		f = Tool.Opendoc(Tool.user);   
        
        ObjectInputStream ois=null;
        	try {
				ois=new ObjectInputStream(new FileInputStream(f));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	UserList temp=null;
			try {
				temp = (UserList) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	if (temp!=null)
        		l=temp;
        	else
        		System.out.println("UserList读取为NULL，可能在初始化时出现");
        	try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       	
	}
}
