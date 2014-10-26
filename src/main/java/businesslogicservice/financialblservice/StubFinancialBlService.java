package businesslogicservice.financialblservice;

import java.util.ArrayList;

import vo.AccountVO;
import vo.BusinessSituationVO;
import vo.CashPaymentVO;
import vo.InquiryProcessVO;
import vo.InquirySaleVO;
import vo.PaymentVO;
import vo.ReceiptVO;
import vo.VO;


public interface StubFinancialBlService {
	public boolean updatePassword(String newPassword) ;
	
	public boolean addAccount(String name) ;
	
	public boolean deleteAccount(String name) ;
	
	public AccountVO findAccount(String name);
	
	public boolean updateAccount(String oldname, String newname);
	//期初建账
	public void buildAccount() ;
	
	public ArrayList<VO> inquirySale(InquirySaleVO isv) ;
	
	public ArrayList<VO> inquiryProcess (InquiryProcessVO ipv);
	
	public BusinessSituationVO inquiryCondition(String time, String type) ;
	
	public boolean creatReceipt(ReceiptVO rv);
	
	public boolean creatPayment(PaymentVO pv);
	
	public boolean creatCashPayment(CashPaymentVO cpv) ;
		
}
