package businesslogic.userbl;

import dataservice.userdataservice.*;

public class UserController {
	static StubUserDataService data;
	User user=new User();
	public void setdataobject(StubUserDataService data)
	{
		this.data=data;
		user.setdataobject(data);
	}
}
