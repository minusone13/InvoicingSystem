package InvoicingSystem;

import presentation.commodityui.StockManagerDriver;
import presentation.userui.UserDriver;
import data.commoditydata.StubStockDataController;
import data.userdata.UserDataController;
import vo.UserVO;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogic.userbl.*;

public class UserTest extends TestCase{
	static UserDriver smd=new UserDriver();
	static UserDataController data=UserDataController.getInstance();
	static
	{
		smd.start(new UserController(),data);
	}
	public void testadminLogin()
	{
		UserController user=new UserController();
		UserVO vo = user.login("admin", "admin");
		assertTrue(vo.getR()==vo.getR().ADMINISTRATOR);
	}
}
