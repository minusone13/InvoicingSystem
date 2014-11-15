package businesslogicservice.userblservice;

import vo.UserVO;
import dataservice.userdataservice.*;

public interface StubUserBlService {
	public void setdataobject(StubUserDataService data);
	public UserVO login(String account, String password);
	public boolean signUp(UserVO vo);
	public boolean changePassword(UserVO vo);
}
