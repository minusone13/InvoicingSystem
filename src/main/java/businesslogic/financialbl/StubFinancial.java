package businesslogic.financialbl;

import java.util.ArrayList;

import vo.*;
import businesslogic.accountbl.StubAccount;
import businesslogic.financialbillbl.StubCashPaymentBill;
import businesslogic.financialbillbl.StubPaymentBill;
import businesslogic.financialbillbl.StubReceiptBill;
import businesslogic.iquirybl.StubInquiry;
import businesslogicservice.financialblservice.StubFinancialBlService;

public class StubFinancial implements StubFinancialBlService{
	String name;
	String password;
	public StubFinancial() {
		this(null, null);
	}
	
	public StubFinancial(String n, String pw) {
		name = n;
		password = pw;
	}
	//修改密码
	public boolean updatePassword(String newPassword) {
		//User u = new User();
		//return u.updatePassword(this ,newPassword);
		return true;
	}
	
	public boolean addAccount(String name) {
		StubAccount a = new StubAccount();
		return a.addAccount(name);	
	}
	
	public boolean deleteAccount(String name) {
		StubAccount a = new StubAccount();
		return a.deleteAccount(name);
	}
	
	public AccountVO findAccount(String name) {
		StubAccount a = new StubAccount();
		return a.findAccount(name);
	
	}
	
	public boolean updateAccount(String oldname, String newname) {
		StubAccount a = new StubAccount();
		return a.updateAccount(oldname,newname);
	}
	//期初建账
	public void buildAccount() {
		StubAccount a = new StubAccount();
		a.buildAccount();
		System.out.println("BUILD SUCCESS!");
	}
	
	public ArrayList<VO> inquirySale(InquirySaleVO isv) {
		StubInquiry i = new StubInquiry();
		return i.inquirySale(isv);
	}
	
	public ArrayList<VO> inquiryProcess (InquiryProcessVO ipv) {
		StubInquiry i = new StubInquiry();
		return i.inquiryProcess(ipv);
	}
	
	public BusinessSituationVO inquiryCondition(String time, String type) {
		StubInquiry i = new StubInquiry();
		return i.inquiryCondition(time, type);
	}
	
	public boolean creatReceipt(ReceiptVO rv) {
		StubReceiptBill r = new StubReceiptBill();
		return r.creatReceipt(rv);
	}
	
	public boolean creatPayment(PaymentVO pv){
		StubPaymentBill r = new StubPaymentBill();
		return r.creatPayment(pv);
	
	}
	
	public boolean creatCashPayment(CashPaymentVO cpv) {
		StubCashPaymentBill r = new StubCashPaymentBill();
		return r.creatCashPayment(cpv);
		
	}
}
