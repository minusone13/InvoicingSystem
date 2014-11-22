package po.userpo;

import java.io.*;

import businesslogic.Role;

public class UserPO implements Serializable, Cloneable{
	String ID;//自动生成
	Role r;//职务
	String account;//用于登陆的账号
	String password;//经过MD5加密的密码
	String name;//姓名
	public UserPO(){}
	public UserPO(String ID,Role r, String account, String password, String name)
	{
		this.r=r;
		this.account=account;
		this.password=password;
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
	public UserPO clone()
	{
		UserPO cloned = null;
		try {
			cloned=(UserPO)super.clone();
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
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
}
