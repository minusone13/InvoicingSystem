package businesslogic.salebillServicec;

import java.util.Date;

public interface salebillForFinancial {
	public int getAllVoucher(Date start,Date end);//计算一段时间内发放了多少代金券；
	public double getAllVoucherBonus(Date start,Date end);//计算一段时间内实际收款差额；
	
	public double getAllSalesIncome(Date start,Date end);//计算一段时间内有多少折让后收入；
	public double getAllSalesDiscount(Date start,Date end);//计算一段时间内共计多少折让；
	
	public double getAllPurMoney(Date start,Date end);//计算一段时间内进货支出;
}
