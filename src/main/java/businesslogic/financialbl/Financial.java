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
import businesslogic.userbl.OperationRecord;
import businesslogic.userbl.User;
import businesslogic.userbl.UserController;
import businesslogic.userbl.UserList;
import businesslogic.userservice.UserService;
import businesslogicservice.financialblservice.StubFinancialBlService;

public class Financial implements StubFinancialBlService{
	String name;
	String password;
	Role role;

	UserService userSer= new UserController();
	
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
		boolean result = a.addAccount(new StubAccount(name));
		RM rm = RM.unknownerror;
		if(result) rm=RM.done;
		userSer.addRecord(new OperationRecord(new User(), "Add a account", rm));		
		return result;	
	}
	
	public boolean deleteAccount(String name) {
		if(role != Role.FINANCIAL_MANAGER) return false;
		AccountList a = new AccountList();
		boolean result = a.deleteAccount(new StubAccount(name));
		RM rm = RM.unknownerror;
		if(result) rm=RM.done;
		userSer.addRecord(new OperationRecord(new User(), "Delete a account", rm));		
		return result;
	}
	
	//模糊搜索
	public AccountVO findAccount(String name) {
		if(role != Role.FINANCIAL_MANAGER) return null;
		AccountList a = new AccountList();
		AccountVO result = a.findAccount(new StubAccount(name));
		RM rm = RM.unknownerror;
		if(result!=null) rm=RM.done;
		userSer.addRecord(new OperationRecord(new User(), "Find a account", rm));		
		return result;
	}
	
	public boolean updateAccount(String oldname, String newname) {
		if(role != Role.FINANCIAL_MANAGER) return false;
		AccountList a = new AccountList();
		boolean result = a.updateAccount(new StubAccount(oldname),newname);
		RM rm = RM.unknownerror;
		if(result) rm=RM.done;
		userSer.addRecord(new OperationRecord(new User(), "Update a account", rm));		
		return result;
	}
	
	//期初建账
	public void buildAccount() {
		AccountList a = new AccountList();
		a.buildAccount();
		userSer.addRecord(new OperationRecord(new User(), "Build a account at the beginning", RM.done));		
	}
	
	public ArrayList<CustomerVO> getOldCustomersInfo(String version) {
		AccountList a = new AccountList();
		return a.getOldCustomersInfo(version);
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
		FinancialBillList financialList = new FinancialBillList();
		boolean result = financialList.creatReceiptBill(rv);
		RM rm = RM.unknownerror;
		if(result) rm=RM.done;
		userSer.addRecord(new OperationRecord(new User(), "Creat a receipt", rm));		
		return result;
	}
	
	//修改收款单
	public void updateReceipt(ReceiptVO vo) {
		FinancialBillList financialList = new FinancialBillList();
		financialList.updateReceiptBill(vo);
	}
	
	//创建付款单
	public boolean creatPayment(PaymentVO pv){
		FinancialBillList financialList = new FinancialBillList();
		boolean result = financialList.creatPaymentBill(pv);
		RM rm = RM.unknownerror;
		if(result) rm=RM.done;
		userSer.addRecord(new OperationRecord(new User(), "Creat a payment", rm));		
		return result;
	}

	//修改付款单
	public void updatePayment(PaymentVO vo) {
		FinancialBillList financialList = new FinancialBillList();
		financialList.updatePaymentBill(vo);
	}
	
	//创建现金费用单
	public boolean creatCashPayment(CashPaymentVO cpv) {
		FinancialBillList financialList = new FinancialBillList();
		boolean result =financialList.creatCashPaymentBill(cpv);
		RM rm = RM.unknownerror;
		if(result) rm=RM.done;
		userSer.addRecord(new OperationRecord(new User(), "Creat a cashpayment", rm));		
		return result;		
	}
	
	public void updateCashPayment(CashPaymentVO vo) {
		FinancialBillList financialList = new FinancialBillList();
		financialList.updateCashPaymentBill(vo);
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
