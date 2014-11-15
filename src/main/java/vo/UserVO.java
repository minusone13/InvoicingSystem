package vo;

import businesslogic.Role;

public class UserVO implements Cloneable{
	Role r;
	String account;
	String password;
	String name;
	public UserVO(){}
	public UserVO(Role r, String account, String password, String name)
	{
		this.r=r;
		this.account=account;
		this.password=password;
		this.name=name;
	}
	public UserVO(Role r, String account,  String name)
	{
		this.r=r;
		this.account=account;
		password="unknown";
		this.name=name;
	}
	public Role getR() {
		return r;
	}
	public void setR(Role r) {
		this.r = r;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserVO clone()
	{
		UserVO cloned = null;
		try {
			cloned=(UserVO)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cloned;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
