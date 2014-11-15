package dataservice.userdataservice;

import po.OperationRecordPO;
import po.UserPO;

public interface StubUserDataService {
	public UserPO login(String account, String password);
	
	public boolean insert(UserPO po);
	
	public UserPO find(String account);
	
	public boolean insert(OperationRecordPO po);
}
