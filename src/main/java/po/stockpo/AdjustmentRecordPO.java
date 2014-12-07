package po.stockpo;

import java.io.Serializable;
import java.util.Date;

public class AdjustmentRecordPO implements Serializable, Cloneable{
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
	public AdjustmentRecordPO clone()
	{
		AdjustmentRecordPO cloned = null;
		try {
			cloned=(AdjustmentRecordPO)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cloned.setDate((Date) date.clone());
		return cloned;
	}
}
