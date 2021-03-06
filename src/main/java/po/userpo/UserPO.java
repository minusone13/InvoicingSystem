package po.userpo;

import java.io.*;

import po.Role;

public class UserPO implements Serializable, Cloneable
{
	String ID;// 自动生成
	Role r;// 职务
	String account;// 用于登陆的账号
	String password;// 经过MD5加密的密码
	String name;// 姓名
	boolean authorized;// 是否已授权

	public UserPO()
	{}

	public UserPO(String ID, Role r, String account, String password,
			String name, boolean authorized)
	{
		this.ID = ID;
		this.r = r;
		this.account = account;
		this.password = password;
		this.name = name;
		this.authorized = authorized;
	}

	@Override
	public UserPO clone()
	{
		UserPO cloned = null;
		try
		{
			cloned = (UserPO) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cloned;
	}

	public String getAccount()
	{
		return account;
	}

	public String getID()
	{
		return ID;
	}

	public String getName()
	{
		return name;
	}

	public String getPassword()
	{
		return password;
	}

	public Role getR()
	{
		return r;
	}

	public boolean isAuthorized()
	{
		return authorized;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	public void setAuthorized(boolean authorized)
	{
		this.authorized = authorized;
	}

	public void setID(String iD)
	{
		ID = iD;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public void setR(Role r)
	{
		this.r = r;
	}
}
