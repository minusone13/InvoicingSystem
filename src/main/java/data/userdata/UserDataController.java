package data.userdata;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.userdataservice.*;
import po.*;
import po.userpo.OperationRecordPO;
import po.userpo.UserPO;

public class UserDataController extends UnicastRemoteObject implements StubUserDataService
{
	public static UserDataController getInstance()throws RemoteException
	{// 单体模式
		if (instance == null)
			try
			{
				instance = new UserDataController();
			}
			catch (RemoteException e)
			{
				e.printStackTrace();
			}
		return instance;
	}

	private static UserDataController instance = null;
	UserList l;
	File f;

	private UserDataController()throws RemoteException
	{
		read();
	}

	public int count(char c)throws RemoteException
	{// 用于计算指定职务已有员工数量，便于逻辑层对新的员工生成ID
		read();
		return l.count(c);
	}

	public boolean delete(UserPO po)throws RemoteException
	{
		read();
		boolean result = l.delete(po);
		save();
		return result;
	}

	public UserPO find(String account)throws RemoteException
	{// 通过账号查找一个用和
		read();
		UserPO po = l.find(account);
		if (po == null)
			return null;
		return po.clone();
	}

	public ArrayList<OperationRecordPO> getRecords()throws RemoteException
	{
		read();
		return l.getRecords();
	}

	public ArrayList<UserPO> getUsers()throws RemoteException
	{
		read();
		ArrayList<UserPO> users = l.getUsers();
		for (int i = 0; i < users.size(); i++)
		{
			UserPO po = users.get(i);
			users.set(i, po.clone());
		}
		return users;
	}

	public void initial()
	{
		f = Tool.Opendoc(Tool.user);

		// some initial under;
		ObjectOutputStream oos = null;
		try
		{
			oos = new ObjectOutputStream(new FileOutputStream(f));
		}
		catch (FileNotFoundException e2)
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		catch (IOException e2)
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try
		{
			oos.writeObject(new UserList());
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{
			oos.close();
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		read();
		// some initial procedure under;
		l.initial();
		save();
	}

	public boolean insert(OperationRecordPO po)throws RemoteException
	{// 插入关键操作记录
		read();
		boolean result = l.insert(po);
		save();
		return result;
	}

	public boolean insert(UserPO po)throws RemoteException
	{// 插入一个用户（对应于增加用户）
		read();
		boolean result = l.insert(po);
		save();
		return result;
	}

	public UserPO login(String account, String password)throws RemoteException
	{// 登陆函数，若用户名账户和密码正确，返回UserPO,里面指示了用户类型Role。登陆失败则返回NULL
		read();
		return l.login(account, password);
	}

	public void read()
	{
		f = Tool.Opendoc(Tool.user);

		ObjectInputStream ois = null;
		try
		{
			ois = new ObjectInputStream(new FileInputStream(f));
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserList temp = null;
		try
		{
			temp = (UserList) ois.readObject();
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (temp != null)
			l = temp;
		else
			System.out.println("UserList读取为NULL，可能在初始化时出现");
		try
		{
			ois.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void save()
	{
		ObjectOutputStream oos = null;
		try
		{
			oos = new ObjectOutputStream(new FileOutputStream(f));
		}
		catch (FileNotFoundException e2)
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		catch (IOException e2)
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try
		{
			oos.writeObject(l);
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{
			oos.close();
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public boolean update(UserPO po)throws RemoteException
	{//简单的替换，也就是删除后增加
		read();
		boolean result = l.update(po);
		save();
		return result;
	}

	public RM updatePassword(UserPO po)throws RemoteException
	{// 更改密码
		read();
		RM result = l.updatePassword(po);
		save();
		return result;
	}
}
