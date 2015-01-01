package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RM;
import po.userpo.OperationRecordPO;
import po.userpo.UserPO;

public interface StubUserDataService extends Remote
{
	public UserPO login(String account, String password)throws RemoteException;

	public boolean insert(UserPO po)throws RemoteException;

	public boolean delete(UserPO po)throws RemoteException;

	public UserPO find(String account)throws RemoteException;

	public boolean insert(OperationRecordPO po)throws RemoteException;

	public boolean update(UserPO po)throws RemoteException;

	public RM updatePassword(UserPO po)throws RemoteException;

	public int count(char c) throws RemoteException;

	public ArrayList<UserPO> getUsers()throws RemoteException;

	public ArrayList<OperationRecordPO> getRecords()throws RemoteException;
}
