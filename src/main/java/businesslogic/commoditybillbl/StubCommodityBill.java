package businesslogic.commoditybillbl;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.BillState;
import businesslogic.examinebl.StubBillPool;
import vo.*;

public class StubCommodityBill 
{//统一管理了库存单据，相当于一个对内的Controller
	ArrayList<StubAlertBill> alerts;
	ArrayList<StubGiftBill> gifts;
	ArrayList<StubSpillsLossBill> sls;
	StubBillPool pool=new StubBillPool();
	public RM addSpillsLossBill()
	{
		return RM.done;
	}
	public RM addGiftBill()
	{
		return RM.done;
	}
	public RM addAlertBill()
	{
		return RM.done;
	}
	public double getSpillsTotal(Date d1, Date d2)
	{//including d1 and d2
		sls=pool.getSpillsLossBill(BillState.OVER);
		double sum=0;
		for (int i=0;i<sls.size();i++)
		{
			StubSpillsLossBill temp=sls.get(i);
			if(temp.t==temp.t.Spills)
				sum+=temp.getCom().getIn()*temp.getCom().getNumber();
		}
		return sum;
	}
	public double getLossTotal(Date d1, Date d2)
	{//see above
		sls=pool.getSpillsLossBill(BillState.OVER);
		double sum=0;
		for (int i=0;i<sls.size();i++)
		{
			StubSpillsLossBill temp=sls.get(i);
			if(temp.t==temp.t.Loss)
				sum+=temp.getCom().getIn()*temp.getCom().getNumber();
		}
		return sum;
	}
}

