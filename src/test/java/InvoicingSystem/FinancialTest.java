package InvoicingSystem;

import presentation.financialui.FinancialBLDriver;
import businesslogic.financialbl.StubFinancial;
import businesslogicservice.financialblservice.StubFinancialBlService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FinancialTest extends TestCase{
	static StubFinancialBlService financial = new StubFinancial();
	static {
		FinancialBLDriver driver = new FinancialBLDriver(financial);
		
	}
	public void testaddAccount() {
		boolean result2 = financial.addAccount("00001");
		assertTrue(result2);
	}
}
