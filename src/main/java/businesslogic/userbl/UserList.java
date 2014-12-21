package businesslogic.userbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.*;
import java.util.ArrayList;

import po.RM;
import po.Role;
import po.userpo.*;
import vo.uservo.OperationRecordVO;
import vo.uservo.UserVO;
import dataservice.userdataservice.*;

public class UserList
{
	static StubUserDataService data = null;// need
	static
	{
		try
		{
			data = (StubUserDataService) Naming.lookup("rmi://127.0.0.1:1099/UserDataController");
		}
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NotBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	String ID;// 自动生成
	Role r;// 职务
	String account;// 用于登陆的账号
	String password;// 经过MD5加密的密码
	String name;// 姓名

	public UserVO login(String account, String password)
	{
		UserPO po = null;
		try
		{
			po = data.login(account, string2MD5(password));
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null)
			return null;
		UserVO vo = new User(po).toVO();
		return vo;
	}

	public RM deleteUser(UserVO vo)
	{
		try
		{
			if (data.find(vo.getAccount()) == null)
				return RM.notfound;
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean result = false;
		try
		{
			result = data.delete(new User(vo).toPO());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == false)
			return RM.unknownerror;
		return RM.done;
	}

	public RM signUp(UserVO vo)
	{
		try
		{
			if (data.find(vo.getAccount()) != null)
				return RM.redundance;
			else
			{
				String result = generateID(vo);
				if (result == null)
					return RM.unknownerror;
				User user = new User(vo);
				user.setID(result);
				user.setAuthorized(false);
				user.setPassword(string2MD5(vo.getPassword()));
				data.insert(user.toPO());
				return RM.done;
			}
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return RM.RMIError;
	}

	public String generateID(UserVO vo)
	{//生成员工ID
		char c = 0;
		switch (vo.getR()) {// 自动生成ID，详见Data层的UserList类
			case MANAGER:
				c = 'M';
				break;
			case ADMINISTRATOR:
				c = 'A';
				break;
			case FINANCIAL_STAFF:
				;
			case FINANCIAL_MANAGER:
				c = 'F';
				break;
			case STOCK_STAFF:
				c = 'I';
				break;// 抱歉只能用I咯，S和下面的进货人员重了；
			case PURCHASE_SALE_MANAGER:
				;
			case PURCHASE_SALE_STAFF:
				c = 'S';
				break;
			default:
				return null;
		}
		int x=0;
		try
		{
			x = data.count(c);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x++;
		String result = String.format("%04d", x);
		result = c + result;
		return result;
	}

	public UserVO find(String account)
	{
		UserPO po = null;
		try
		{
			po = data.find(account);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null)
			return null;
		return new User(po).toVO();
	}

	public RM changePassword(UserVO vo)
	{
		User user = new User(vo);
		user.setPassword(string2MD5(vo.getPassword()));
		RM result = RM.RMIError;
		try
		{
			result = data.updatePassword(user.toPO());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public RM changePassword(UserVO vo, String oldPassword)
	{// 跟改密码，新密码位于UserVO中的password属性
		UserVO temp = login(vo.getAccount(), oldPassword);
		if (temp == null)
			return RM.invalid;
		return changePassword(vo);
	}

	public RM changeRole(UserVO vo, Role newRole)
	{
		RM result = deleteUser(vo);// delete old account,because stuff ID
									// relates to the kind of job
		if (result != RM.done)
			return result;
		vo.setR(newRole);// changeRole
		String s = generateID(vo);
		if (s == null)
			return RM.unknownerror;
		User user = new User(vo);
		user.setID(s);
		try
		{
			data.insert(user.toPO());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public RM authorized(String account)
	{
		UserPO po = null;
		try
		{
			po = data.find(account);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null)
			return RM.notfound;
		po.setAuthorized(true);
		boolean result = false;
		try
		{
			result = data.update(po);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result)
			return RM.done;
		else
			return RM.unknownerror;
	}

	public ArrayList<UserVO> showUsers()
	{
		ArrayList<UserPO> users;
		try
		{
			users = data.getUsers();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		ArrayList<UserVO> result = new ArrayList<UserVO>();
		for (int i = 0; i < users.size(); i++)
		{
			UserPO po = users.get(i);
			if (po.getR() != po.getR().ADMINISTRATOR)
				result.add(new User(po).toVO());
		}
		return result;
	}

	public ArrayList<OperationRecordVO> showRecords()
	{
		ArrayList<OperationRecordPO> records;
		try
		{
			records = data.getRecords();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		ArrayList<OperationRecordVO> result = new ArrayList<OperationRecordVO>();
		for (int i = 0; i < records.size(); i++)
		{
			OperationRecordPO po = records.get(i);
			result.add(new OperationRecord(po).toVO());
		}
		return result;
	}

	public boolean addRecord(OperationRecord op)
	{
		try
		{
			return data.insert(op.toPO());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void setPO(UserPO po)
	{
		ID = po.getID();
		r = po.getR();
		account = po.getAccount();
		password = po.getPassword();
		name = po.getName();
	}

	public static String string2MD5(String inStr)
	{//密码加密
		MessageDigest md5 = null;
		try
		{
			md5 = MessageDigest.getInstance("MD5");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++)
		{
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	public void setdataobject(StubUserDataService data)
	{
		this.data = data;
	}

	public static StubUserDataService getData()
	{
		return data;
	}

	public static void setData(StubUserDataService data)
	{
		UserList.data = data;
	}

	public String getID()
	{
		return ID;
	}

	public void setID(String iD)
	{
		ID = iD;
	}

	public Role getR()
	{
		return r;
	}

	public void setR(Role r)
	{
		this.r = r;
	}

	public String getAccount()
	{
		return account;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
