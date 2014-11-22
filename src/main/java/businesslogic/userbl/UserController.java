package businesslogic.userbl;

import businesslogic.userservice.UserService;
import businesslogicservice.userblservice.StubUserBlService;
import po.userpo.OperationRecordPO;
import po.userpo.UserPO;
import vo.UserVO;
import dataservice.userdataservice.*;

public class UserController implements StubUserBlService, UserService{
	static StubUserDataService data;
	User user=new User();
	public UserVO login(String account, String password)
	{
		return user.login(account, password);
	}
	public boolean signUp(UserVO vo)
	{
		return user.signUp(vo);
	}
	
	public boolean changePassword(UserVO vo)
	{
		return user.changePassword(vo);
	}
	
	public void setdataobject(StubUserDataService data)
	{
		this.data=data;
		user.setdataobject(data);
	}
	public static StubUserDataService getData() {
		return data;
	}
	public static void setData(StubUserDataService data) {
		UserController.data = data;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean addRecord(OperationRecordPO po)
	{
		return user.addRecord(po);
	}
}
