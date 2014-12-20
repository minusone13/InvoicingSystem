package InvoicingSystem;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RM;
import po.Role;
import po.stockpo.CategoryPO;
import presentation.commodityui.StockManagerDriver;
import presentation.userui.UserDriver;
import vo.stockvo.CategoryVO;
import vo.stockvo.CommodityVO;
import vo.uservo.OperationRecordVO;
import vo.uservo.UserVO;

import org.junit.*;

import dataservice.commoditydataservice.StubCommodityDataService;
import dataservice.userdataservice.StubUserDataService;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogic.userbl.*;
import businesslogicservice.commodityblservice.StubCommodityBlService;
import businesslogicservice.userblservice.StubUserBlService;

public class UserTest{
	static UserDriver smd=new UserDriver();
	static StubUserBlService ubl=new UserController();
	static
	{
		StubUserDataService data = null;
		try
		{
			data = (StubUserDataService)Naming.lookup("rmi://127.0.0.1:1099/UserDataController");
		}
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NotBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		smd.start(ubl,data);
	}
	@Before
	public void initial()
	{
		//Initial initial=new Initial();
		//initial.initialUser();
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
	public void testadminLoginFail()
	{
		UserVO vo = ubl.login("admin", "admi");
		assertEquals(null,vo);
	}
	
	@Test
	public void testsignUp1()
	{
		UserController user=new UserController();
		UserVO vo = new UserVO(Role.STOCK_STAFF, "stock", "stock", "Helen");
		RM result = user.signUp(vo);
		assertEquals(RM.redundance,result);
	}
	
	@Test
	public void testsignUp2()
	{
		UserController user=new UserController();
		UserVO vo = new UserVO(Role.STOCK_STAFF, "stockxxx", "stock", "Helen");
		RM result = user.signUp(vo);
		assertEquals(RM.done,result);
	}
	
	@Test
	public void testAuthorize()
	{
		UserController user=new UserController();
		UserVO vo = user.find("stock");
		assertFalse(vo.isAuthorized());
		user.authorized("stock");
		vo = user.find("stock");
		assertTrue(vo.isAuthorized());
	}
	
	@Test
	public void testlogin()
	{
		UserController user=new UserController();
		UserVO vo = user.login("stock", "stock");
		assertTrue(vo.getR()==vo.getR().STOCK_STAFF);
	}
	
	@Test
	public void testdeleteUser()
	{
		RM result=ubl.deleteUser(new UserVO("A0001",Role.ADMINISTRATOR,"admin","admin","管理员",true));
		assertEquals(RM.done,result);
		UserVO vo = ubl.login("admin", "admin");
		assertEquals(null,vo);
	}
	
	@Test
	public void testdeleteNotFound()
	{
		RM result=ubl.deleteUser(new UserVO("A0002",Role.ADMINISTRATOR,"admind","admin","管理员",true));
		assertEquals(RM.notfound,result);
	}
	
	@Test
	public void testchangeRole()
	{
		UserVO vo = ubl.login("stock", "stock");
		RM result = ubl.changeRole(vo, Role.ADMINISTRATOR);
		assertEquals(RM.done,result);
		vo = ubl.login("stock", "stock");
		assertEquals("A0002",vo.getID());
	}
	
	@Test
	public void testchangePassword()
	{
		UserVO vo = ubl.login("stock", "stock");
		vo.setPassword("newStockPassword");
		RM result = ubl.changePassword(vo);
		assertEquals(RM.done,result);
		vo = ubl.login("stock", "stock");
		assertEquals(null,vo);//用原密码登录失败
		vo = ubl.login("stock", "newStockPassword");
		assertEquals("stock",vo.getAccount());
		assertEquals("Helen",vo.getName());
	}
	
	@Test
	public void testchangePassword2()
	{
		UserVO vo = ubl.login("stock", "stock");
		vo.setPassword("newStockPassword");
		RM result = ubl.changePassword(vo,"stock");
		assertEquals(RM.done,result);
		vo = ubl.login("stock", "stock");
		assertEquals(null,vo);//用原密码登录失败
		vo = ubl.login("stock", "newStockPassword");
		assertEquals("stock",vo.getAccount());
		assertEquals("Helen",vo.getName());
	}
	
	@Test
	public void testchangePassword3()
	{
		UserVO vo = ubl.login("stock", "stock");
		vo.setPassword("newStockPassword");
		RM result = ubl.changePassword(vo,"stock1");//原密码错误，修改密码失败
		assertEquals(RM.invalid,result);
		vo = ubl.login("stock", "stock");
		assertEquals("stock",vo.getAccount());
		assertEquals("Helen",vo.getName());
		vo = ubl.login("stock", "stock1");
		assertEquals(null,vo);//用新密码登录失败
	}
	
	@Ignore
	public void testkeyRecord()
	{
		StubCommodityBlService combl = new StubStockController();
		combl.addCategory(new CategoryVO("1\\灯","日光灯"));
		combl.addCategory(new CategoryVO("1\\灯","白炽灯"));
		ArrayList<OperationRecordVO> records = ubl.showRecords();
		assertEquals(2,records.size());
		assertEquals(RM.redundance,records.get(0).getResult());
		assertEquals(RM.done,records.get(1).getResult());
		assertEquals("I0000",records.get(0).getUser().getID());
	}
}
