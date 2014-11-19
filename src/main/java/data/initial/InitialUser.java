package data.initial;

import data.userdata.*;

public class InitialUser
{//初始化商品管理的文件
	public InitialUser()
	{
		UserDataController data=UserDataController.getInstance();
		data.initial();
	}
}
