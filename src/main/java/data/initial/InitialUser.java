package data.initial;

import data.Tool;
import data.userdata.*;

public class InitialUser
{//初始化商品管理的文件
	public InitialUser()
	{
		Tool.Clean(Tool.user);
		UserDataController data=UserDataController.getInstance();
		data.initial();
	}
}
