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
		users.add(new UserPO("A0001",Role.ADMINISTRATOR,"admin","21232f297a57a5a743894a0e4a801fc3","管理员"));
		//default has a administrator account, default name is admin, password is admin. details see 大作业.doc
		records=new ArrayList<OperationRecordPO>();
	}
	
	public int count(char c)//参数代表职务 A为管理员  M为总经理 S为进货销售人员 F为才我人员 I为库存管理人员
	{//因为人员有员工编号如 总经理为M0001等等，在生成编号时，要自动查找已有人员数量
		for(int i=users.size()-1;i>=0;i--)
		{//用户信息按照顺序存储，从后往前查找，查到的一定是编号最大的
			String ID=users.get(i).getID();
			if(ID.charAt(0)==c)
				return Integer.parseInt(ID.substring(1));
		}
		return 0;
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
	{//插入一个用户（对应于增加用户）
		users.add(po);
		return true;
	}
	
	public UserPO find(String account)
	{//通过账号查找一个用和
		for(int i=0;i<users.size();i++)
		{
			UserPO user=users.get(i);
			if(user.getAccount().equals(account))
				return user.clone();
		}
		return null;
	}
	
	public boolean insert(OperationRecordPO po)
	{//插入关键操作记录
		records.add(po);
		return true;
	}
	
	public boolean updatePassword(UserPO po)
	{//更改密码
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
