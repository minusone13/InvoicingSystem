package data.initial;

import java.rmi.RemoteException;

import po.Tool;
import data.userdata.*;

public class InitialUser
{//初始化商品管理的文件
	public InitialUser()
	{
		Tool.Clean(Tool.user);
		UserDataController data = null;
		try
		{
			data = UserDataController.getInstance();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data.initial();
	}
}
