package presentation.financialui;

import java.util.ArrayList;

import vo.VO;
import vo.accountVO.AccountVO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import vo.inquiryVO.BusinessSituationVO;
import vo.inquiryVO.InquiryProcessVO;
import vo.inquiryVO.InquirySaleVO;
import businesslogic.BillState;
import businesslogic.financialbillbl.CashPaymentBill;
import businesslogic.financialbillbl.PaymentBill;
import businesslogic.financialbillbl.ReceiptBill;
import businesslogicservice.financialblservice.StubFinancialBlService;

public class FinancialBLDriver {
	StubFinancialBlService fbs;
	public FinancialBLDriver (StubFinancialBlService fbs) {
		this.fbs = fbs;
	}
	
	public void drive() {
		
//		boolean result2 = fbs.addAccount("ICBC", 100);
//		if(result2==true) System.out.println("ADD SUCCESS!");
//		
//		
//		
//		boolean result3 = fbs.addAccount("BC", 100);
//		if(result2==true) System.out.println("ADD SUCCESS!");
		
		//boolean result5 = fbs.updateAccount("00001", "00100");
		//if(result5==true) System.out.println("UPDATE SUCCESS!");
		
		//fbs.buildAccount();
		
		
		//testcreatReceipt();
		///testcreatPayment("MAJOR") ;
		//testcreatPayment("M") ;
		
		//testcreatCashPayment();
		/*
		testgetReceipt();
		testgetPayment();
		testgetCashPayment();
		*/
		testInquiry01();
	}
	
	public void testInquiry01() {
		InquiryProcessVO ipv = new InquiryProcessVO();
		//ipv.setTimeBefore("2014/12/13");
		//ipv.setTimeAfter("2014/12/14");
		ipv.setCustomer("MAJOR");
		
		ArrayList<PaymentVO> cp = fbs.getProcessPayment(ipv);
		System.out.println("Inquiry-------------------------");
		System.out.println(cp.size());
		PaymentVO vo = cp.get(0);
		
		System.out.println("Payment:　"+vo.getID());
		System.out.println("Payment:　"+vo.getCustomer());
		System.out.println("Payment:　"+ vo.getOp());
				
		System.out.println("Payment:　"+vo.getTotal());
		System.out.println("Payment:　"+vo.getBillState());
	}
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
		boolean result5 = fbs.creatReceipt(vo);  
		
		
	}

	public void testgetReceipt() {
		ArrayList<ReceiptVO> receipts = fbs.getAllOfReceiptBills();
		ReceiptVO vo = receipts.get(0);
		System.out.println("Receipt: "+receipts.size());
		//assertEquals("SKD-20141209-00001", vo.getID());
		
		System.out.println("Receipt: "+vo.getCustomer());
		System.out.println("Receipt: "+vo.getOp());
		System.out.println("Receipt: "+vo.getTotal());
		System.out.println("Receipt: "+vo.getBillState());
	}
	
	
	public void testcreatPayment(String s) {
		PaymentVO vo = new PaymentVO();
		vo.setCustomer(s);
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
		boolean result6 = fbs.creatPayment(vo);  
		
	}
	
	public void testgetPayment() {
		ArrayList<PaymentVO> payments = fbs.getAllOfPaymentBills();	
		if(payments.size() == 0) return;
		PaymentVO vo = payments.get(0);
		
		
		//assertEquals(1,payments.size());
		System.out.println("Payment:　" +vo.getID());
		System.out.println("Payment:　"+payments.size());
		System.out.println("Payment:　"+vo.getID());
		System.out.println("Payment:　"+vo.getCustomer());
		System.out.println("Payment:　"+ vo.getOp());
				
		System.out.println("Payment:　"+vo.getTotal());
		System.out.println("Payment:　"+vo.getBillState());
		
	}
	
	public void testcreatCashPayment() {
		CashPaymentVO vo = new CashPaymentVO();
		
		ArrayList<Double> money = new ArrayList<Double>();//转账金额
		ArrayList<String> item = new ArrayList<String>();
		ArrayList<String> remark =new ArrayList<String>();
		
		item.add("dinner");  money.add(100.00);  remark.add("");
		
		vo.setItem(item);
		vo.setMoney(money);
		vo.setRemark(remark);
		vo.setAccount("ICBC");
		double total=0;
		for(int i=0;i<money.size();i++) total+=money.get(i);
		vo.setTotal(total);
		vo.setBillState(BillState.SUBMITED);
		boolean result6 = fbs.creatCashPayment(vo);  
		
	}
	
	public void testgetCashPayment() {
		ArrayList<CashPaymentVO> cashPayments = fbs.getAllOfCashPaymentBills();
		System.out.println(cashPayments.size());
		CashPaymentVO vo = cashPayments.get(0);
		//assertEquals(1,cashPayments.size());
	//	assertEquals("XJFYD-20141209-00001", vo.getID());
		
		System.out.println("CashPayment: "+vo.getID());
		System.out.println("CashPayment: "+vo.getAccount());
		System.out.println("CashPayment: "+vo.getItem());
		
		System.out.println("CashPayment: "+vo.getAccount());
		System.out.println("CashPayment: "+vo.getOp());
		//assertEquals(100.0,vo.getTotal());
		System.out.println("CashPayment: "+vo.getBillState());
	}
}
