package businesslogic.financialbl;

import java.util.ArrayList;

import vo.*;
import businesslogic.accountbl.StubAccount;
import businesslogic.accountbl.StubAccountList;
import businesslogic.financialbillbl.StubCashPaymentBill;
import businesslogic.financialbillbl.StubFinancialBillList;
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
		StubAccountList a = new StubAccountList();
		return a.addAccount(new StubAccount(name));	
	}
	
	public boolean deleteAccount(String name) {
		StubAccountList a = new StubAccountList();
		return a.deleteAccount(new StubAccount(name));
	}
	
	public AccountVO findAccount(String name) {
		StubAccountList a = new StubAccountList();
		return a.findAccount(new StubAccount(name));
	}
	
	public boolean updateAccount(String oldname, String newname) {
		StubAccountList a = new StubAccountList();
		return a.updateAccount(new StubAccount(oldname),newname);
	}
	//期初建账
	public void buildAccount() {
		StubAccountList a = new StubAccountList();
		a.buildAccount();
		//System.out.println("BUILD SUCCESS!");
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
		StubFinancialBillList financialList = new StubFinancialBillList();
		return financialList.creatReceiptBill(rv);
	}
	
	public boolean creatPayment(PaymentVO pv){
		StubFinancialBillList financialList = new StubFinancialBillList();
		return financialList.creatPaymentBill(pv);
	
	}
	
	public boolean creatCashPayment(CashPaymentVO cpv) {
		StubFinancialBillList financialList = new StubFinancialBillList();
		return financialList.creatCashPaymentBill(cpv);
		
	}
	
}
