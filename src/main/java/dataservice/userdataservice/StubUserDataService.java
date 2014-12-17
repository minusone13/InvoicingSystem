package dataservice.userdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.userpo.OperationRecordPO;
import po.userpo.UserPO;
import vo.RM;

public interface StubUserDataService extends Remote{
	public UserPO login(String account, String password);
	public boolean insert(UserPO po);
	public boolean delete(UserPO po);
	public UserPO find(String account);
	public boolean insert(OperationRecordPO po);
	public boolean update(UserPO po);
	public RM updatePassword(UserPO po);
	public int count(char c);
	public ArrayList<UserPO> getUsers();
	public ArrayList<OperationRecordPO> getRecords();
}
