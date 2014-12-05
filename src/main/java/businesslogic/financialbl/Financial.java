package businesslogic.financialbl;

import java.util.ArrayList;

import po.AccountPO;
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
import businesslogic.accountbl.AccountList;
import businesslogic.financialbillbl.CashPaymentBill;
import businesslogic.financialbillbl.FinancialBillList;
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
		AccountList a = new AccountList();
		return a.addAccount(new StubAccount(name));	
	}
	
	public boolean deleteAccount(String name) {
		if(role != Role.FINANCIAL_MANAGER) return false;
		AccountList a = new AccountList();
		return a.deleteAccount(new StubAccount(name));
	}
	
	public AccountVO findAccount(String name) {
		if(role != Role.FINANCIAL_MANAGER) return null;
		AccountList a = new AccountList();
		return a.findAccount(new StubAccount(name));
	}
	
	public boolean updateAccount(String oldname, String newname) {
		if(role != Role.FINANCIAL_MANAGER) return false;
		AccountList a = new AccountList();
		return a.updateAccount(new StubAccount(oldname),newname);
	}
	//期初建账
	public void buildAccount() {
		AccountList a = new AccountList();
		a.buildAccount();
	}
	
	public ArrayList<AccountVO> getOldAccountsInfo(String version) {
		AccountList a = new AccountList();
		return a.getOldAccountsInfo(version);
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
		rv.setRole(role);
		FinancialBillList financialList = new FinancialBillList();
		return financialList.creatReceiptBill(rv);
	}
	
	public boolean creatPayment(PaymentVO pv){
		pv.setRole(role);
		FinancialBillList financialList = new FinancialBillList();
		return financialList.creatPaymentBill(pv);
	
	}
	
	//创建现金费用单
	public boolean creatCashPayment(CashPaymentVO cpv) {
		cpv.setRole(role);
		FinancialBillList financialList = new FinancialBillList();
		return financialList.creatCashPaymentBill(cpv);
		
	}
	
	/*需要从单据池筛选指定状态的所有收款单*/
	public ArrayList<ReceiptVO> getAllOfReceiptBills () {
		FinancialBillList financialList = new FinancialBillList();
		return financialList.getAllOfReceiptBills();
	}
	
	/*需要从单据池筛选指定状态的所有付款单*/
	public ArrayList<PaymentVO> getAllOfPaymentBills () {
		FinancialBillList financialList = new FinancialBillList();
		return financialList.getAllOfPaymentBills();
	}
	
	/*需要从单据池筛选指定状态的所有现金费用单*/
	public ArrayList<CashPaymentVO> getAllOfCashPaymentBills () {
		FinancialBillList financialList = new FinancialBillList();
		return financialList.getAllOfCashPaymentBills();
	}
}
