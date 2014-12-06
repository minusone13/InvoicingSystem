package businesslogic.stockservice;

import java.util.Date;

public interface StockBlForFinancial {
	public double getSpillsTotal(Date d1, Date d2);//including d1 and d2
	public double getLossTotal(Date d1, Date d2);//see above
	public double getAdjustmentTotal(Date d1, Date d2);//商品调价。这个返回值可能为正，也可能为负
	public double getGiftBillTotal(Date d1, Date d2);//赠送单支出。这个返回值可能为非负
}
