package InvoicingSystem;

import static org.junit.Assert.*;
import po.stockpo.CategoryPO;
import presentation.commodityui.StockManagerDriver;
import presentation.userui.UserDriver;
import data.commoditydata.StubStockDataController;
import data.initial.Initial;
import data.userdata.UserDataController;
import vo.UserVO;
import vo.stockvo.CommodityVO;

import org.junit.*;

import businesslogic.Role;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogic.userbl.*;
import businesslogicservice.commodityblservice.StubCommodityBlService;

public class UserTest{
	static UserDriver smd=new UserDriver();
	static UserDataController data=UserDataController.getInstance();
	static
	{
		smd.start(new UserController(),data);
	}
	@Before
	public void initial()
	{
		Initial initial=new Initial();
		initial.initialUser();
		UserController user=new UserController();
		UserVO vo = new UserVO(Role.STOCK_STAFF, "stock", "stock", "Helen");
		user.signUp(vo);
	}
	
	@Test
	public void testadminLogin()
	{
		UserController user=new UserController();
		UserVO vo = user.login("admin", "admin");
		assertTrue(vo.getR()==vo.getR().ADMINISTRATOR);
	}
	
	@Test
	public void testsignUp1()
	{
		UserController user=new UserController();
		UserVO vo = new UserVO(Role.STOCK_STAFF, "stock", "stock", "Helen");
		boolean result = user.signUp(vo);
		assertTrue(!result);
	}
	
	@Test
	public void testsignUp2()
	{
		UserController user=new UserController();
		UserVO vo = new UserVO(Role.STOCK_STAFF, "stockxxx", "stock", "Helen");
		boolean result = user.signUp(vo);
		assertTrue(result);
	}
	
	@Test
	public void testlogin()
	{
		UserController user=new UserController();
		UserVO vo = user.login("stock", "stock");
		assertTrue(vo.getR()==vo.getR().STOCK_STAFF);
	}
}
