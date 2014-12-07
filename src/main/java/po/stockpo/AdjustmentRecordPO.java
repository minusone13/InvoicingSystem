package po.stockpo;

import java.util.Date;

public class AdjustmentRecordPO {
	public AdjustmentRecordPO(double income)
	{
		Date date = new Date();
		this.income = income;
	}
	Date date = new Date();
	double income;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
}
