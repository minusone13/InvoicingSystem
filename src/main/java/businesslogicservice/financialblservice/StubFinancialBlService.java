package businesslogicservice.financialblservice;

import java.util.ArrayList;

import vo.CustomerVO;
import vo.VO;
import vo.accountVO.AccountVO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import vo.inquiryVO.BusinessSituationVO;
import vo.inquiryVO.InquiryConditionVO;
import vo.inquiryVO.InquiryProcessVO;
import vo.inquiryVO.InquirySaleVO;


public interface StubFinancialBlService {
	
	
	public boolean addAccount(String name, double iniMoney) ;
	
	public boolean deleteAccount(String name) ;
	
	public ArrayList<AccountVO> fuzzyFindAccount(String s , int precision);
	
	public AccountVO findAccount(String s);
	
	public boolean updateAccount(String oldname, String newname);
	//期初建账
	public void buildAccount() ;
	
	//得到期初建账保存的账户信息
	public ArrayList<AccountVO> getOldAccountsInfo(String version);
	
	//得到期初建账保存的客户信息
	public ArrayList<CustomerVO> getOldCustomersInfo(String version);
	
	
	
	public ArrayList<VO> inquiryProcess (InquiryProcessVO ipv);
	
	public BusinessSituationVO inquiryCondition(InquiryConditionVO vo);
	
	//创建收款单
	public boolean creatReceipt(ReceiptVO rv);
	
	//修改收款单
	public void updateReceipt(ReceiptVO vo);
	
	//创建付款单
	public boolean creatPayment(PaymentVO pv);
	
	//修改付款单
	public void updatePayment(PaymentVO vo);
	
	//创建现金费用单
	public boolean creatCashPayment(CashPaymentVO cpv);
	
	//修改现金费用单
	public void updateCashPayment(CashPaymentVO vo);
	
	public ArrayList<CashPaymentVO> getAllOfCashPaymentBills ();
	
	public ArrayList<PaymentVO> getAllOfPaymentBills ();
	
	public ArrayList<ReceiptVO> getAllOfReceiptBills ();
		
}
