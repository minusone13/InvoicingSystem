package presentation.userui;

import dataservice.userdataservice.*;
import businesslogicservice.userblservice.*;

public class UserDriver {
	StubUserBlService userbl;
	
	public void start(StubUserBlService userbl,StubUserDataService data){
		this.userbl=userbl;
		userbl.setdataobject(data);
	}
}
