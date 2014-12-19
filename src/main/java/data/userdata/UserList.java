package data.userdata;

import java.io.*;
import java.util.*;

import po.*;
import po.userpo.OperationRecordPO;
import po.userpo.UserPO;

public class UserList implements Serializable
{
	ArrayList<UserPO> users;
	ArrayList<OperationRecordPO> records;
	ArrayList<UserPO> deleted;

	int numOfAdmin = 0;
	int numOfManager = 0;
	int numOfFinancial = 0;
	int numOfSales = 0;
	int numOfStock = 0;

	public int count(char c)// 参数代表职务 A为管理员 M为总经理 S为进货销售人员 F为才我人员 I为库存管理人员
	{// 因为人员有员工编号如 总经理为M0001等等，在生成编号时，要自动查找已有人员数量
		switch (c) {
			case 'A':
				return numOfAdmin;
			case 'M':
				return numOfManager;
			case 'S':
				return numOfSales;
			case 'F':
				return numOfFinancial;
			case 'I':
				return numOfStock;
			default:
				return 0;
		}
	}

	public boolean delete(UserPO po)
	{
		int i = search(po.getAccount());
		if (i == -1)// not found
			return false;
		else
		{
			deleted.add(users.get(i));
			users.remove(i);
			return true;
		}
	}

	public UserPO find(String account)
	{// 通过账号查找一个用和
		int i = search(account);
		if (i != -1)
		{
			UserPO user = users.get(i);
			return user;
		}
		else
			return null;
	}

	public ArrayList<UserPO> getDeleted()
	{
		return deleted;
	}

	public ArrayList<OperationRecordPO> getRecords()
	{
		ArrayList<OperationRecordPO> result = new ArrayList<OperationRecordPO>();
		for (int i = 0; i < records.size(); i++)
			result.add(records.get(i).clone());
		return result;
	}

	public ArrayList<UserPO> getUsers()
	{
		ArrayList<UserPO> result = new ArrayList<UserPO>();
		for (int i = 0; i < users.size(); i++)
			result.add(users.get(i).clone());
		return result;
	}

	public void initial()
	{
		users = new ArrayList<UserPO>();
		users.add(new UserPO("A0001", Role.ADMINISTRATOR, "admin",
				"21232f297a57a5a743894a0e4a801fc3", "管理员", true));
		numOfAdmin++;
		// default has a administrator account, default name is admin, password
		// is admin. details see 大作业.doc
		records = new ArrayList<OperationRecordPO>();
		deleted = new ArrayList<UserPO>();
	}

	public boolean insert(OperationRecordPO po)
	{// 插入关键操作记录
		records.add(po);
		return true;
	}

	public boolean insert(UserPO po)
	{// 插入一个用户（对应于增加用户）
		users.add(po);
		char c = po.getID().charAt(0);
		switch (c) {
			case 'A':
				numOfAdmin++;
				break;
			case 'M':
				numOfManager++;
				break;
			case 'S':
				numOfSales++;
				break;
			case 'F':
				numOfFinancial++;
				break;
			case 'I':
				numOfStock++;
				break;
			default:
				return false;
		}
		return true;
	}

	public UserPO login(String account, String password)
	{// 登陆函数，若用户名账户和密码正确，返回UserPO,里面指示了用户类型Role。登陆失败则返回NULL
		UserPO user = find(account);
		if (user == null || !user.getPassword().equals(password))
			return null;
		else
			return user;
	}

	private int search(String account)
	{// 通过账号查找一个用和
		for (int i = 0; i < users.size(); i++)
		{
			UserPO user = users.get(i);
			if (user.getAccount().equals(account))
				return i;
		}
		return -1;
	}

	public void setDeleted(ArrayList<UserPO> deleted)
	{
		this.deleted = deleted;
	}

	public void setRecords(ArrayList<OperationRecordPO> records)
	{
		this.records = records;
	}

	public void setUsers(ArrayList<UserPO> users)
	{
		this.users = users;
	}

	public boolean update(UserPO po)
	{
		int i = 0;
		for (i = 0; i < users.size(); i++)
		{
			if (users.get(i).getAccount().equals(po.getAccount()))
			{
				users.remove(i);
				users.add(i, po);
				return true;
			}
		}
		return false;
	}

	public boolean updateName(UserPO po)
	{
		UserPO user = find(po.getAccount());
		if (user == null)
			return false;
		else
		{
			user.setName(po.getName());// whether it's true?
			return true;
		}
	}

	public RM updatePassword(UserPO po)
	{// 更改密码
		UserPO user = find(po.getAccount());
		if (user == null)
			return RM.notfound;
		else
		{
			user.setPassword(po.getPassword());// whether it's true?
			return RM.done;
		}
	}

	public boolean updateRole(UserPO po)
	{
		UserPO user = find(po.getAccount());
		if (user == null)
			return false;
		else
		{
			user.setR(po.getR());// whether it's true?
			return true;
		}
	}
}
