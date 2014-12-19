package businesslogic.userbl;

import po.Role;
import po.userpo.UserPO;
import vo.uservo.UserVO;

public class User implements Cloneable
{
	String ID;// 自动生成
	Role r;// 职务
	String account;// 用于登陆的账号
	String password;// 经过MD5加密的密码
	String name;// 姓名
	boolean authorized;

	public User()
	{}

	public User(String ID, Role r, String account, String password, String name)
	{
		this.ID = ID;
		this.r = r;
		this.account = account;
		this.password = password;
		this.name = name;
	}

	public User(UserVO vo)
	{
		this.ID = vo.getID();
		this.r = vo.getR();
		this.account = vo.getAccount();
		this.password = vo.getPassword();
		this.name = vo.getName();
		this.authorized = vo.isAuthorized();
	}

	public User(UserPO po)
	{
		this.ID = po.getID();
		this.r = po.getR();
		this.account = po.getAccount();
		this.password = po.getPassword();
		this.name = po.getName();
		this.authorized = po.isAuthorized();
	}

	public UserPO toPO()
	{
		return new UserPO(ID, r, account, password, name, authorized);
	}

	public UserVO toVO()
	{
		return new UserVO(ID, r, account, password, name, authorized);
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

	public User clone()
	{
		User cloned = null;
		try
		{
			cloned = (User) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cloned;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getID()
	{
		return ID;
	}

	public void setID(String iD)
	{
		ID = iD;
	}

	public boolean isAuthorized()
	{
		return authorized;
	}

	public void setAuthorized(boolean authorized)
	{
		this.authorized = authorized;
	}
}
