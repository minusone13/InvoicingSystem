package data.initial;

import java.rmi.RemoteException;

public class Initial {
	//负责初始化文件
	public void initialAll() throws RemoteException
	{
		new InitialStock();
		new InitialUser();
		new InitialStockBill();
		//new InitialTestStock();
	}
	public void initialTest()
	{
		new InitialTestStock();
	}
	public void initialStock() throws RemoteException
	{
		new InitialStock();
	}
	public void initialUser()
	{
		new InitialUser();
	}
}
