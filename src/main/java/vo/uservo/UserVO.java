package vo.uservo;

import businesslogic.Role;

public class UserVO implements Cloneable{
	String ID;//人员ID 示例：总经理为“M0001” 管理员为“A0001” 财务为“F0001” 销售“S0001” 库存“I0001”
	//另外注意，为了保证不产生冲突，人员编号是一次性的，及时删除用户，这个ID就在重置系统前永久作废了
	Role r;//职务
	String account;//账户，用于登陆
	String password;//密码，用于登陆
	String name;//姓名
	public UserVO(){}
	public UserVO(String ID,Role r, String account, String password, String name)
	{
		this.ID=ID;
		this.r=r;
		this.account=account;
		this.password=password;
		this.name=name;
	}
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
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
}
