package businesslogic.userbl;

import businesslogic.Role;
import po.userpo.UserPO;
import vo.UserVO;

public class MockUser extends User{
	public UserVO login(String account, String password)
	{
		if(account.equals("admin") && password.equals("admin"))
		{
			UserVO vo = new UserVO(Role.ADMINISTRATOR,"admin","管理员");
			return vo;
		}
		else
			return null;
	}
}
