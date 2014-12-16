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
import businesslogicservice.financialblservice.FinancialBlService;

public class Financial implements FinancialBlService{
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
	
	//得到版本编号
	public ArrayList<String> getVersions() {
		AccountList a = new AccountList();
		return a.getVersions();
	}
	
	//得到过去版本的期初客户信息
	public ArrayList<CustomerVO> getOldCustomersInfo(String version) {
		AccountList a = new AccountList();
		return a.getOldCustomersInfo(version);
	}
	
	//得到过去版本的期初账户信息
	public ArrayList<AccountVO> getOldAccountsInfo(String version) {
		AccountList a = new AccountList();
		return a.getOldAccountsInfo(version);
	}
	//得到销售明细表中的销售单
	public ArrayList<SaleSheetVO> getSaleSaleSheet(InquirySaleVO isv) {
		Inquiry i = new Inquiry();
		return i.getSaleSaleSheet(isv);
	}
		
	//销售明细表的销售退货单
	public ArrayList<SaleBackSheetVO> getSaleSaleBackSheet(InquirySaleVO isv) {
		Inquiry i = new Inquiry();
		return i.getSaleSaleBackSheet(isv);
	}
		
	//得到经营历程表的赠送单
	public ArrayList<GiftBillVO> getProcessGift(InquiryProcessVO ipv) {
		Inquiry i = new Inquiry();
		return i.getProcessGift(ipv);
	}
		
	//得到经营历程表的报溢报损单
	public ArrayList<SpillsLossBillVO> getProcessSpillLoss(InquiryProcessVO ipv) {
		Inquiry i = new Inquiry();
		return i.getProcessSpillLoss(ipv);
	}
	
	//得到经营历程表的报警单
	public ArrayList<AlertBillVO> getProcessAlert(InquiryProcessVO ipv) {
		Inquiry i = new Inquiry();
		return i.getProcessAlert(ipv);
	}
	
	//得到经营历程表的销售单
	public ArrayList<SaleSheetVO> getProcessSaleSheet(InquiryProcessVO ipv) {
		Inquiry i = new Inquiry();
		return i.getProcessSaleSheet(ipv);
	}
		
	//得到经营历程表的销售退货单
	public ArrayList<SaleBackSheetVO> getProcessSaleBackSheet(InquiryProcessVO ipv) {
		Inquiry i = new Inquiry();
		return i.getProcessSaleBackSheet(ipv);
	}
		
	//得到经营历程表的进货单
	public ArrayList<PurSheetVO> getProcessPurSheet(InquiryProcessVO ipv) {
		Inquiry i = new Inquiry();
		return i.getProcessPurSheet(ipv);
	}
		
	//得到经营历程表的进货退货单
	public ArrayList<PurBackSheetVO> getProcessPurBackSheet(InquiryProcessVO ipv) {
		Inquiry i = new Inquiry();
		return i.getProcessPurBackSheet(ipv);
	}
				
				
	//得到经营历程表的收款单
	public ArrayList<ReceiptVO> getProcessReceipt(InquiryProcessVO ipv) {
		Inquiry i = new Inquiry();
		return i.getProcessReceipt(ipv);
	}
	
	//得到经营历程表的付款单
	public ArrayList<PaymentVO> getProcessPayment(InquiryProcessVO ipv) {
		Inquiry i = new Inquiry();
		return i.getProcessPayment(ipv);
	}
	
	//得到经营历程表的现金费用单
	public ArrayList<CashPaymentVO> getProcessCashPayment(InquiryProcessVO ipv) {
		Inquiry i = new Inquiry();
		return i.getProcessCashPayment(ipv);
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
	
	//收款单修改金额
	public void updateReceiptMoney(String customer, String account, double money) {
		AccountList a = new AccountList();
		ArrayList<Account> accounts = a.getAllAccountInfo();
		int size = accounts.size();
		for(int i=0;i<size;i++) {
			Account temp = accounts.get(i);
			if(temp.getName().equals(account)) {
				double balance = accounts.get(i).getBalance();
				accounts.get(i).setBalance(balance+money);
				break;
			}
		}
		a.saveAccounts(accounts);
	}
	
	//付款单修改金额
	public void updatePaymentMoney(String customer, String account, double money) {
		AccountList a = new AccountList();
		ArrayList<Account> accounts = a.getAllAccountInfo();
		int size = accounts.size();
		for(int i=0;i<size;i++) {
			Account temp = accounts.get(i);
			if(temp.getName().equals(account)) {
				double balance = accounts.get(i).getBalance();
				accounts.get(i).setBalance(balance-money);
				break;
			}
		}
		a.saveAccounts(accounts);
	}
	//现金费用单修改账户
	public void updateCashPaymentMoney(String account, double money) {
		AccountList a = new AccountList();
		ArrayList<Account> accounts = a.getAllAccountInfo();
		int size = accounts.size();
		for(int i=0;i<size;i++) {
			Account temp = accounts.get(i);
			if(temp.getName().equals(account)) {
				double balance = accounts.get(i).getBalance();
				accounts.get(i).setBalance(balance-money);
				break;
			}
		}
		a.saveAccounts(accounts);
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
