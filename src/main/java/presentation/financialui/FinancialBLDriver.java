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
		
		ArrayList<AccountVO> volist= fbs.fuzzyFindAccount("BC", 1);
		System.out.println(volist.size());
		
//		ArrayList<VO> list1 = fbs.inquirySale(new InquirySaleVO());
//		if(list1 != null) System.out.println("INQUIRY SUCCESS!");
//		else System.out.println("INQUIRY FAILE!");
//		
//		ArrayList<VO> list2 = fbs.inquiryProcess(new InquiryProcessVO());
//		if(list2 != null) System.out.println("INQUIRY SUCCESS!");
//		else System.out.println("INQUIRY FAILE!");
//		
//		BusinessSituationVO bsv = fbs.inquiryCondition("12", "income");
//		if(bsv !=null) System.out.println("INQUIRY SUCCESS");
//		else System.out.println("INQUIRY FAILE!");
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
		
		ArrayList<PaymentVO> payments = fbs.getAllOfPaymentBills();
		if(!payments.isEmpty()){
			PaymentVO vo = payments.get(0);
			
			
			
			System.out.println(payments.size());
			System.out.println(vo.getID());
			System.out.println( vo.getCustomer());
			System.out.println( vo.getOp());
					
			System.out.println(vo.getTotal());
		}
		
	
		
	}
}
