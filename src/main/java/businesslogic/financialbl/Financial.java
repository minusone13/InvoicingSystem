package businesslogic.financialbl;

import vo.*;
import businesslogic.accountbl.Account;
import businesslogic.financialbillbl.StubCashPaymentBill;
import businesslogic.financialbillbl.StubPaymentBill;
import businesslogic.financialbillbl.StubReceiptBill;
import businesslogic.iquirybl.Inquiry;

public class Financial {
	String name;
	String password;
	public Financial() {
		this(null,null);
	}
	
	public Financial(String n, String pw) {
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
		Account a = new Account();
		return a.addAccount(name);	
	}
	
	public boolean deleteAccount(String name) {
		Account a = new Account();
		return a.deleteAccount(name);
	}
	
	public AccountVO findAccount(String name) {
		Account a = new Account();
		return a.findAccount(name);
	
	}
	
	public boolean updateAccount(String oldname, String newname) {
		Account a = new Account();
		return a.updateAccount(oldname,newname);
	}
	//期初建账
	public void buildAccount() {
		Account a = new Account();
		a.buildAccount();
	}
	
	//public ArrayList<SaleBillVO> inquirySale(InquirySaleVO isv) {
		//Inquiry i = new Inquiry();
		//i.inquirySale(isv);
	//}
	
	//public ArrayList<BillVO> inquiryProcess (InquiryProcessVO ipv) {
			//Inquiry i = new Inquiry();
				//i.inquirySale(ipv);
//	}
	
	//public MoneyVO inquiryCondition(String time, String type) {
		//Inquiry i = new Inquiry();
		//i.inquiryCondition(time, type);
	//}
	
	public boolean creatReceipt(ReceiptVO rv) {
		StubReceiptBill r = new StubReceiptBill();
		return r.creatReceipt(rv);
	}
	
	public boolean creatPayment(PaymentVO pv){
		StubPaymentBill r = new StubPaymentBill();
		return r.creatPayment(pv);
	
	}
	
	public boolean creatCrashPayment(CrashPaymentVO cpv) {
		StubCashPaymentBill r = new StubCashPaymentBill();
		return r.creatCrashPayment(cpv);
		
	}
}
