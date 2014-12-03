package businesslogicservice.financialblservice;

import java.util.ArrayList;

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
	
	
	public boolean addAccount(String name) ;
	
	public boolean deleteAccount(String name) ;
	
	public AccountVO findAccount(String name);
	
	public boolean updateAccount(String oldname, String newname);
	//期初建账
	public void buildAccount() ;
	
	public ArrayList<VO> inquirySale(InquirySaleVO isv) ;
	
	public ArrayList<VO> inquiryProcess (InquiryProcessVO ipv);
	
	public BusinessSituationVO inquiryCondition(InquiryConditionVO vo);
	
	public boolean creatReceipt(ReceiptVO rv);
	
	public boolean creatPayment(PaymentVO pv);
	
	public boolean creatCashPayment(CashPaymentVO cpv);
	
	public ArrayList<CashPaymentVO> getAllOfCashPaymentBills ();
	
	public ArrayList<PaymentVO> getAllOfPaymentBills ();
	
	public ArrayList<ReceiptVO> getAllOfReceiptBills ();
		
}
