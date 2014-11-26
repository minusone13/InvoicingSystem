package presentation.financialui;

import java.util.ArrayList;

import vo.AccountVO;
import vo.BusinessSituationVO;
import vo.CashPaymentVO;
import vo.InquiryProcessVO;
import vo.InquirySaleVO;
import vo.PaymentVO;
import vo.ReceiptVO;
import vo.VO;
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
		
		boolean result2 = fbs.addAccount("00001");
		if(result2==true) System.out.println("ADD SUCCESS!");
		
		boolean result3 = fbs.deleteAccount("00001");
		if(result3==true) System.out.println("DELETE SUCCESS!");
		
		AccountVO result4 = fbs.findAccount("00001");
		if(result4!=null) System.out.println("FIND SUCCESS!");
		
		boolean result5 = fbs.updateAccount("00001", "00100");
		if(result5==true) System.out.println("UPDATE SUCCESS!");
		
		fbs.buildAccount();
		
		ArrayList<VO> list1 = fbs.inquirySale(new InquirySaleVO());
		if(list1 != null) System.out.println("INQUIRY SUCCESS!");
		else System.out.println("INQUIRY FAILE!");
		
		ArrayList<VO> list2 = fbs.inquiryProcess(new InquiryProcessVO());
		if(list2 != null) System.out.println("INQUIRY SUCCESS!");
		else System.out.println("INQUIRY FAILE!");
		
		BusinessSituationVO bsv = fbs.inquiryCondition("12", "income");
		if(bsv !=null) System.out.println("INQUIRY SUCCESS");
		else System.out.println("INQUIRY FAILE!");
		/*
		boolean result6 = fbs.creatReceipt(new ReceiptVO());
		if(result6==true) System.out.println("creat SUCCESS!");
		else System.out.println("FAILE!");
			
		boolean result7 = fbs.creatPayment(new PaymentVO());
		if(result7==true) System.out.println("creat SUCCESS!");
		else System.out.println("FAILE!");
		
		boolean result8 = fbs.creatCashPayment(new CashPaymentVO());
		if(result8==true) System.out.println("creat SUCCESS!");
		else System.out.println("FAILE!");
		*/
			
	}
}
