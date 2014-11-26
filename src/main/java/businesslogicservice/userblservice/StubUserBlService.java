package businesslogicservice.userblservice;

import java.util.ArrayList;
import businesslogic.*;
import vo.*;
import dataservice.userdataservice.*;

public interface StubUserBlService {
	public void setdataobject(StubUserDataService data);
	public UserVO login(String account, String password);
	public RM signUp(UserVO vo);
	public RM changePassword(UserVO vo);
	public RM changeRole(UserVO vo,Role newRole);
	public RM deleteUser(UserVO vo);
	public ArrayList<UserVO> show();
}
