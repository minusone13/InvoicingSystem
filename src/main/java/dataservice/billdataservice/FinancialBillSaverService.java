package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CashPaymentPO;
import po.PaymentPO;
import po.ReceiptPO;

public interface FinancialBillSaverService extends Remote{

	/*保存付款单*/
	public void savePayment(ArrayList<PaymentPO> pb)throws RemoteException;
	/*保存收款单*/
	public void saveReceipt(ArrayList<ReceiptPO> rb)throws RemoteException;
	/*保存现金费用单*/
	public void saveCashPayment(ArrayList<CashPaymentPO> cpb)throws RemoteException;
	/*获取付款单*/
	public ArrayList<PaymentPO> getPayment()throws RemoteException;
	/*获取收款单*/
	public ArrayList<ReceiptPO> getReceipt()throws RemoteException;
	/*获取现金费用单*/
	public ArrayList<CashPaymentPO> getCashPayment()throws RemoteException;
}
