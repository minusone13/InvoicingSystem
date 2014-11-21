package data.userdata;

import java.io.*;
import java.util.*;

import businesslogic.Role;
import po.*;
import po.userpo.OperationRecordPO;
import po.userpo.UserPO;

public class UserList implements Serializable{
	ArrayList<UserPO> users;
	ArrayList <OperationRecordPO> records;
	public void initial()
	{
		users=new ArrayList<UserPO>();
		users.add(new UserPO(Role.ADMINISTRATOR,"admin","21232f297a57a5a743894a0e4a801fc3","管理员"));
		//default has a administrator account, default name is admin, password is admin. details see 大作业.doc
		records=new ArrayList<OperationRecordPO>();
	}
	
	public UserPO login(String account, String password)
	{//登陆函数，若用户名账户和密码正确，返回UserPO,里面指示了用户类型Role。登陆失败则返回NULL
		UserPO user=find(account);
		if(user==null || !user.getPassword().equals(password))
			return null;
		else
			return user;
	}
	
	public boolean insert(UserPO po)
	{
		users.add(po);
		return true;
	}
	
	public UserPO find(String account)
	{
		for(int i=0;i<users.size();i++)
		{
			UserPO user=users.get(i);
			if(user.getAccount().equals(account))
				return user.clone();
		}
		return null;
	}
	
	public boolean insert(OperationRecordPO po)
	{
		records.add(po);
		return true;
	}
	
	public boolean updatePassword(UserPO po)
	{
		UserPO user = find(po.getAccount());
		if(user == null)
			return false;
		else
		{
			user.setPassword(po.getPassword());//whether it's true?
			return true;
		}
	}
	public boolean updateRole(UserPO po)
	{
		UserPO user = find(po.getAccount());
		if(user == null)
			return false;
		else
		{
			user.setR(po.getR());//whether it's true?
			return true;
		}
	}
	public boolean updateName(UserPO po)
	{
		UserPO user = find(po.getAccount());
		if(user == null)
			return false;
		else
		{
			user.setName(po.getName());//whether it's true?
			return true;
		}
	}
}
