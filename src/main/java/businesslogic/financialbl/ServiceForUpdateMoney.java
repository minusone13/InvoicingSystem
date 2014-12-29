package businesslogic.financialbl;

public interface ServiceForUpdateMoney
{
	public void updateReceiptMoney(String customer, String account, double money);
	public boolean updatePaymentMoney(String customer, String account, double money);
	public boolean updateCashPaymentMoney(String account, double money) ;
}
