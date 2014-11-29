package businesslogic.financialbl;

import java.util.ArrayList;

import vo.*;
import vo.accountVO.AccountVO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import vo.inquiryVO.BusinessSituationVO;
import vo.inquiryVO.InquiryConditionVO;
import vo.inquiryVO.InquiryProcessVO;
import vo.inquiryVO.InquirySaleVO;
import businesslogic.Role;
import businesslogic.accountbl.StubAccount;
import businesslogic.accountbl.StubAccountList;
import businesslogic.financialbillbl.CashPaymentBill;
import businesslogic.financialbillbl.StubFinancialBillList;
import businesslogic.financialbillbl.PaymentBill;
import businesslogic.financialbillbl.ReceiptBill;
import businesslogic.iquirybl.Inquiry;
import businesslogic.userbl.UserList;
import businesslogicservice.financialblservice.StubFinancialBlService;

public class Financial implements StubFinancialBlService{
	String name;
	String password;
	Role role;
	public Financial() {
		this(null, null, null);
	}
	
	public Financial(String n, String pw, Role r) {
		name = n;
		password = pw;
		role = r;
	}
	
	public boolean addAccount(String name) {
		if(role != Role.FINANCIAL_MANAGER) return false;
		StubAccountList a = new StubAccountList();
		return a.addAccount(new StubAccount(name));	
	}
	
	public boolean deleteAccount(String name) {
		if(role != Role.FINANCIAL_MANAGER) return false;
		StubAccountList a = new StubAccountList();
		return a.deleteAccount(new StubAccount(name));
	}
	
	public AccountVO findAccount(String name) {
		if(role != Role.FINANCIAL_MANAGER) return null;
		StubAccountList a = new StubAccountList();
		return a.findAccount(new StubAccount(name));
	}
	
	public boolean updateAccount(String oldname, String newname) {
		if(role != Role.FINANCIAL_MANAGER) return false;
		StubAccountList a = new StubAccountList();
		return a.updateAccount(new StubAccount(oldname),newname);
	}
	//期初建账
	public void buildAccount() {
		StubAccountList a = new StubAccountList();
		a.buildAccount();
	}
	
	public ArrayList<VO> inquirySale(InquirySaleVO isv) {
		Inquiry i = new Inquiry();
		return i.inquirySale(isv);
	}
	
	public ArrayList<VO> inquiryProcess (InquiryProcessVO ipv) {
		Inquiry i = new Inquiry();
		return i.inquiryProcess(ipv);
	}
	
	public BusinessSituationVO inquiryCondition(InquiryConditionVO vo) {
		Inquiry i = new Inquiry();
		return i.inquiryCondition(vo);
	}
	
	public boolean creatReceipt(ReceiptVO rv) {
		rv.setOperator(role);
		StubFinancialBillList financialList = new StubFinancialBillList();
		return financialList.creatReceiptBill(rv);
	}
	
	public boolean creatPayment(PaymentVO pv){
		pv.setOperator(role);
		StubFinancialBillList financialList = new StubFinancialBillList();
		return financialList.creatPaymentBill(pv);
	
	}
	
	public boolean creatCashPayment(CashPaymentVO cpv) {
		cpv.setOperator(role);
		StubFinancialBillList financialList = new StubFinancialBillList();
		return financialList.creatCashPaymentBill(cpv);
		
	}
	
}
