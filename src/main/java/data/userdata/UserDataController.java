package data.userdata;

import java.io.*;

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
	{
		if(instance==null)
			instance = new UserDataController();
		return instance;
	}
	private UserDataController()
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
        		System.out.println("UserList对象序列化错误");
        	try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       	
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
        		System.out.println("UserList对象序列化错误");
        	try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	//some initial procedure under;
        	l.initial();
        	//ObjectOutputStream oos=null;
        	oos=null;
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
    
	public UserPO login(String account, String password)
	{//登陆函数，若用户名账户和密码正确，返回UserPO,里面指示了用户类型Role。登陆失败则返回NULL
		return l.login(account, password);
	}
	
	public boolean insert(UserPO po)
	{//插入一个用户（对应于增加用户）
		return l.insert(po);
	}
	
	public UserPO find(String account)
	{//通过账号查找一个用和
		return l.find(account);
	}
	
	public boolean insert(OperationRecordPO po)
	{//插入关键操作记录
		return l.insert(po);
	}
	public boolean updatePassword(UserPO po)
	{//更改密码
		return l.updatePassword(po);
	}
	public int count(char c)
	{//用于计算指定职务已有员工数量，便于逻辑层对新的员工生成ID
		return l.count(c);
	}
}
