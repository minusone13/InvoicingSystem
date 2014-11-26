package InvoicingSystem;

import presentation.financialui.FinancialBLDriver;
import vo.AccountVO;
import businesslogic.financialbl.Financial;
import businesslogicservice.financialblservice.StubFinancialBlService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FinancialTest extends TestCase{
	StubFinancialBlService financial = new Financial();

	public void testaddAccount() {		
		boolean result2 = financial.addAccount("周润发");
		assertFalse(result2);			
	}
	
	public void testdeleteAccount() {
		boolean result3 = financial.deleteAccount("0001");
		assertFalse(result3);
	}
	
	public void testupdateAccount() {
		boolean result5 = financial.updateAccount("周润发", "周星驰");
		assertFalse(result5);
	}
	
	
}
