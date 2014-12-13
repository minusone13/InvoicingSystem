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
import businesslogic.accountbl.Account;
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
	Role role = Role.FINANCIAL_MANAGER;

	UserService userSer= new UserController();
	FinancialBillList financialList = new FinancialBillList();
	public Financial() {
		this(null, null, null);
	}
	
	public Financial(String n, String pw, Role r) {
		name = n;
		password = pw;
		role = r;
	}
	
	public boolean addAccount(String name, double iniMoney) {
		AccountList a = new AccountList();
		boolean result = a.addAccount(new Account(name, iniMoney));
		
		RM rm = RM.unknownerror;
		if(result) rm=RM.done;
		userSer.addRecord(new OperationRecord(new User(), "Add a account", rm));		
		return result;	
	}
	
	public boolean deleteAccount(String name) {
		
		AccountList a = new AccountList();
		boolean result = a.deleteAccount(new Account(name));
		RM rm = RM.unknownerror;
		if(result) rm=RM.done;
		userSer.addRecord(new OperationRecord(new User(), "Delete a account", rm));		
		return result;
	}
	
	//模糊搜索
	
	public ArrayList<AccountVO> fuzzyFindAccount(String s , int precision) {
		AccountList a = new AccountList();
		return a.fuzzyFindAccount(s, precision);
	}
	
	public AccountVO findAccount(String name) {
		AccountList a = new AccountList();
		AccountVO result = a.findAccount(new Account(name));
		RM rm = RM.unknownerror;
		if(result!=null) rm=RM.done;
		userSer.addRecord(new OperationRecord(new User(), "Find a account", rm));		
		return result;
	}
	
	public boolean updateAccount(String oldname, String newname) {
		if(role != Role.FINANCIAL_MANAGER) return false;
		AccountList a = new AccountList();
		boolean result = a.updateAccount(new Account(oldname),newname);
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
	
	
	
	public ArrayList<VO> inquiryProcess (InquiryProcessVO ipv) {
		Inquiry i = new Inquiry();
		return i.inquiryProcess(ipv);
	}
	
	
	public BusinessSituationVO inquiryCondition(InquiryConditionVO vo) {
		Inquiry i = new Inquiry();
		return i.inquiryCondition(vo);
	}
	
	//创建收款单
	public boolean creatReceipt(ReceiptVO rv) {
		
		boolean result = financialList.creatReceiptBill(rv);
		RM rm = RM.unknownerror;
		if(result) rm=RM.done;
		userSer.addRecord(new OperationRecord(new User(), "Creat a receipt", rm));		
		return result;
	}
	
	//修改收款单
	public void updateReceipt(ReceiptVO vo) {
		financialList.updateReceiptBill(vo);
	}
	
	//创建付款单
	public boolean creatPayment(PaymentVO pv){
		boolean result = financialList.creatPaymentBill(pv);
		RM rm = RM.unknownerror;
		if(result) rm=RM.done;
		userSer.addRecord(new OperationRecord(new User(), "Creat a payment", rm));		
		return result;
	}

	//修改付款单
	public void updatePayment(PaymentVO vo) {
		financialList.updatePaymentBill(vo);
	}
	
	//创建现金费用单
	public boolean creatCashPayment(CashPaymentVO cpv) {
		boolean result =financialList.creatCashPaymentBill(cpv);
		RM rm = RM.unknownerror;
		if(result) rm=RM.done;
		userSer.addRecord(new OperationRecord(new User(), "Creat a cashpayment", rm));		
		return result;		
	}
	
	//修改现金费用单
	public void updateCashPayment(CashPaymentVO vo) {
		financialList.updateCashPaymentBill(vo);
	}
	
	/*需要从单据池筛选指定状态的所有收款单*/
	public ArrayList<ReceiptVO> getAllOfReceiptBills () {
		return financialList.getAllOfReceiptBills();
	}
	
	/*需要从单据池筛选指定状态的所有付款单*/
	public ArrayList<PaymentVO> getAllOfPaymentBills () {
		return financialList.getAllOfPaymentBills();
	}
	
	/*需要从单据池筛选指定状态的所有现金费用单*/
	public ArrayList<CashPaymentVO> getAllOfCashPaymentBills () {
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
