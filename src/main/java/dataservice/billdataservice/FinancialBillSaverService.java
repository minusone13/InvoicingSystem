package dataservice.billdataservice;

import java.util.ArrayList;

import po.CashPaymentPO;
import po.PaymentPO;
import po.ReceiptPO;

public interface FinancialBillSaverService {

	/*保存付款单*/
	public void savePayment(ArrayList<PaymentPO> pb);
	/*保存收款单*/
	public void saveReceipt(ArrayList<ReceiptPO> rb);
	/*保存现金费用单*/
	public void saveCashPayment(ArrayList<CashPaymentPO> cpb);
	/*获取付款单*/
	public ArrayList<PaymentPO> getPayment();
	/*获取收款单*/
	public ArrayList<ReceiptPO> getReceipt();
	/*获取现金费用单*/
	public ArrayList<CashPaymentPO> getCashPayment();
}
