package InvoicingSystem;

import java.util.ArrayList;

import presentation.financialui.FinancialBLDriver;
import vo.accountVO.AccountVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import businesslogic.BillState;
import businesslogic.financialbl.Financial;
import businesslogicservice.financialblservice.StubFinancialBlService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FinancialTest extends TestCase{
	StubFinancialBlService financial = new Financial();
/*
	public void testaddAccount() {		
		boolean result1 = financial.addAccount("周润发");
		assertFalse(result1);			
	}
	
	public void testdeleteAccount() {
		boolean result2 = financial.deleteAccount("0001");
		assertFalse(result2);
	}
	
	public void testfindAccount() {
		AccountVO result3 = financial.findAccount("周润发");
		assertEquals("周润发",result3.getName());
	}
	
	public void testupdateAccount() {
		boolean result4 = financial.updateAccount("周润发", "周星驰");
		assertFalse(result4);
	}
	*/
	
	public void testcreatReceipt() {
		ReceiptVO vo = new ReceiptVO();
		vo.setCustomer("MAJOR");
		ArrayList<Double> money = new ArrayList<Double>();//转账金额
		ArrayList<String> accounts = new ArrayList<String>();
		ArrayList<String> remark =new ArrayList<String>();
		
		accounts.add("ICBC");  money.add(100.00);  remark.add("");
		accounts.add("BC");  money.add(500.00);  remark.add("dinner");
		vo.setAccounts(accounts);
		vo.setMoney(money);
		vo.setRemark(remark);
		double total=0;
		for(int i=0;i<money.size();i++) total+=money.get(i);
		vo.setTotal(total);
		vo.setBillState(BillState.SUBMITED);
		boolean result5 = financial.creatReceipt(vo);  
		
		assertTrue(result5);
	}
	
	public void testgetReceipt() {
		ArrayList<ReceiptVO> receipts = financial.getAllOfReceiptBills();
		ReceiptVO vo = receipts.get(0);
		assertEquals(1,receipts.size());
		assertEquals("SKD-20141209-00001", vo.getID());
		
		assertEquals("MAJOR", vo.getCustomer());
		assertEquals("梅杰 001", vo.getOp());
		assertEquals(600,vo.getTotal());
		assertEquals(BillState.EXAMINED,vo.getBillState());
	}
	
	/*
	public void testcreatPayment() {
		PaymentVO vo = new PaymentVO();
		vo.setCustomer("MAJOR");
		ArrayList<Double> money = new ArrayList<Double>();//转账金额
		ArrayList<String> accounts = new ArrayList<String>();
		ArrayList<String> remark =new ArrayList<String>();
		
		accounts.add("ICBC");  money.add(100.00);  remark.add("");
		accounts.add("BC");  money.add(100.00);  remark.add("dinner");
		vo.setAccounts(accounts);
		vo.setMoney(money);
		vo.setRemark(remark);
		double total=0;
		for(int i=0;i<money.size();i++) total+=money.get(i);
		vo.setTotal(total);
		vo.setBillState(BillState.DRAFT);
		boolean result6 = financial.creatPayment(vo);  
		
		assertTrue(result6);
	}
	*/
}
