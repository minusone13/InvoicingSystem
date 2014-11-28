package businesslogic.userbl;

import java.util.ArrayList;

import businesslogic.Role;
import businesslogic.userservice.UserService;
import businesslogicservice.userblservice.StubUserBlService;
import po.userpo.*;
import vo.*;
import vo.uservo.OperationRecordVO;
import vo.uservo.UserVO;
import dataservice.userdataservice.*;

public class UserController implements StubUserBlService, UserService{
	static StubUserDataService data;
	UserList l=new UserList();
	public UserVO login(String account, String password)
	{
		return l.login(account, password);
	}
	public RM signUp(UserVO vo)
	{
		return l.signUp(vo);
	}
	
	public RM changePassword(UserVO vo)
	{
		return l.changePassword(vo);
	}
	
	public void setdataobject(StubUserDataService data)
	{
		this.data=data;
		l.setdataobject(data);
	}
	public static StubUserDataService getData() {
		return data;
	}
	public static void setData(StubUserDataService data) {
		UserController.data = data;
	}
	public UserList getUser() {
		return l;
	}
	public void setUser(UserList user) {
		this.l = user;
	}
	public boolean addRecord(OperationRecord op)
	{
		return l.addRecord(op);
	}
	public RM changeRole(UserVO vo,Role newRole)
	{
		return l.changeRole(vo, newRole);
	}
	public RM deleteUser(UserVO vo)
	{
		return l.deleteUser(vo);
	}
	public ArrayList<UserVO> showUsers()
	{
		return l.showUsers();
	}
	public ArrayList<OperationRecordVO> showRecords()
	{
		return l.showRecords();
	}
}
