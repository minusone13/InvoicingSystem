package InvoicingSystem;

import vo.UserVO;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import businesslogic.userbl.*;

public class UserTest extends TestCase{
	public void testadminLogin()
	{
		UserController user=new UserController();
		user.setUser(new MockUser());
		UserVO vo = user.login("admin", "admin");
		assertTrue(vo.getR()==vo.getR().ADMINISTRATOR);
	}
}
