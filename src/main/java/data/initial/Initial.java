package data.initial;

public class Initial {
	//负责初始化文件
	public void initialAll()
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
	public void initialStock()
	{
		new InitialStock();
	}
	public void initialUser()
	{
		new InitialUser();
	}
}
