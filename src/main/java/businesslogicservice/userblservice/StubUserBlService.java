package businesslogicservice.userblservice;

import java.util.ArrayList;

import po.RM;
import po.Role;
import businesslogic.*;
import vo.*;
import vo.uservo.*;
import dataservice.userdataservice.*;

public interface StubUserBlService
{//由businesslogic/userbl/UserController.java
	public void setdataobject(UserDataService data);// 用于初始化程序传入实际实现对象

	public UserVO login(String account, String password);// 登陆，若用户名和密码，若登陆成功返回一个UserVO，若失败返回null

	public RM signUp(UserVO vo);// 注册，传入UserVO，在登陆时ID不用填写，在Bl层自动生成

	public RM changePassword(UserVO vo);// 跟改密码，新密码位于UserVO中的password属性

	public RM changePassword(UserVO vo, String oldPassword);// 跟改密码，新密码位于UserVO中的password属性

	public RM changeRole(UserVO vo, Role newRole);// 修改人员职务，UserVO直接从登陆或查看传过来的UserVO再返回回去，第二个参数是新的职务。这名员工的编号将同时更改

	public RM deleteUser(UserVO vo);// 删除人员，UserVO直接从登陆或查看传过来的UserVO再返回回去,以登陆的帐户名判断是否存在

	public ArrayList<UserVO> showUsers();// 显示人员

	public ArrayList<OperationRecordVO> showRecords();// 显示系统日志

	public UserVO find(String account);

	public RM authorized(String account);
}
