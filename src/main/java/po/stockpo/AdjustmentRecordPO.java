package po.stockpo;

import java.io.Serializable;
import java.util.Date;

public class AdjustmentRecordPO implements Serializable, Cloneable
{
	Date date = new Date();

	double income;
	public AdjustmentRecordPO(double income)
	{
		new Date();
		this.income = income;
	}

	@Override
	public AdjustmentRecordPO clone()
	{
		AdjustmentRecordPO cloned = null;
		try
		{
			cloned = (AdjustmentRecordPO) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cloned.setDate((Date) date.clone());
		return cloned;
	}

	public Date getDate()
	{
		return date;
	}

	public double getIncome()
	{
		return income;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public void setIncome(double income)
	{
		this.income = income;
	}
}
