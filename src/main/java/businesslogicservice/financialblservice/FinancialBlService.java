package businesslogicservice.financialblservice;

import java.util.ArrayList;

import vo.AlertBillVO;
import vo.CustomerVO;
import vo.GiftBillVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.SpillsLossBillVO;
import vo.VO;
import vo.accountVO.AccountVO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import vo.inquiryVO.BusinessSituationVO;
import vo.inquiryVO.InquiryConditionVO;
import vo.inquiryVO.InquiryProcessVO;
import vo.inquiryVO.InquirySaleVO;


public interface FinancialBlService {
	
	
	public boolean addAccount(String name, double iniMoney) ;
	
	public boolean deleteAccount(String name) ;
	
	public ArrayList<AccountVO> fuzzyFindAccount(String s , int precision);
	
	public AccountVO findAccount(String s);
	
	public boolean updateAccount(String oldname, String newname);
	//期初建账
	public void buildAccount() ;
	
	//得到版本编号
	public ArrayList<String> getVersions();
		
	//得到期初建账保存的账户信息
	public ArrayList<AccountVO> getOldAccountsInfo(String version);
	
	//得到期初建账保存的客户信息
	public ArrayList<CustomerVO> getOldCustomersInfo(String version);
	
	//得到销售明细表中的销售单
	public ArrayList<SaleSheetVO> getSaleSaleSheet(InquirySaleVO isv);
	
	//销售明细表的销售退货单
	public ArrayList<SaleBackSheetVO> getSaleSaleBackSheet(InquirySaleVO isv);
	
	//得到经营历程表的赠送单
	public ArrayList<GiftBillVO> getProcessGift(InquiryProcessVO ipv);
	
	//得到经营历程表的报溢报损单
	public ArrayList<SpillsLossBillVO> getProcessSpillLoss(InquiryProcessVO ipv);
	
	//得到经营历程表的报警单
	public ArrayList<AlertBillVO> getProcessAlert(InquiryProcessVO ipv);
	
	//得到经营历程表的销售单
	public ArrayList<SaleSheetVO> getProcessSaleSheet(InquiryProcessVO ipv);
	
	//得到经营历程表的销售退货单
	public ArrayList<SaleBackSheetVO> getProcessSaleBackSheet(InquiryProcessVO ipv);
			
	//得到经营历程表的进货单
	public ArrayList<PurSheetVO> getProcessPurSheet(InquiryProcessVO ipv);
	
	//得到经营历程表的进货退货单
	public ArrayList<PurBackSheetVO> getProcessPurBackSheet(InquiryProcessVO ipv);
				
	//得到经营历程表的收款单
	public ArrayList<ReceiptVO> getProcessReceipt(InquiryProcessVO ipv) ;
	
	//得到经营历程表的付款单
	public ArrayList<PaymentVO> getProcessPayment(InquiryProcessVO ipv);
	
	//得到经营历程表的现金费用单
	public ArrayList<CashPaymentVO> getProcessCashPayment(InquiryProcessVO ipv);
	
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
