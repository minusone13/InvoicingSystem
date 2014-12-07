package businesslogic.commoditybillbl;

import java.text.SimpleDateFormat;
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
	public RM add(StubSpillsLossBill bill)
	{
		sls=pool.getSpillsLossBill();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		if(sls.size()==0)
			bill.setID("YSD-"+currentTime+"-00001");
		else
		{
			String s = sls.get(sls.size()-1).getID();
			String a[]=s.split("-");
			if(currentTime.equals(a[1]))//日期相同，继续编号
			{
				int count=Integer.parseInt(a[2]);
				count++;
				bill.setID("YSD-"+currentTime+"-"+String.format("%05d", Integer.toString(count)));
			}
			else
				bill.setID("YSD-"+currentTime+"-00001");
		}
		pool.add(bill);
		return RM.done;
	}
	public RM add(StubGiftBill bill)
	{
		gifts=pool.getGiftBill();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		if(sls.size()==0)
			bill.setID("ZSD-"+currentTime+"-00001");
		else
		{
			String s = sls.get(sls.size()-1).getID();
			String a[]=s.split("-");
			if(currentTime.equals(a[1]))//日期相同，继续编号
			{
				int count=Integer.parseInt(a[2]);
				count++;
				bill.setID("ZSD-"+currentTime+"-"+String.format("%05d", Integer.toString(count)));
			}
			else
				bill.setID("ZSD-"+currentTime+"-00001");
		}
		pool.add(bill);
		return RM.done;
	}
	public RM add(StubAlertBill bill)
	{
		sls=pool.getSpillsLossBill();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		if(sls.size()==0)
			bill.setID("BJD-"+currentTime+"-00001");
		else
		{
			String s = sls.get(sls.size()-1).getID();
			String a[]=s.split("-");
			if(currentTime.equals(a[1]))//日期相同，继续编号
			{
				int count=Integer.parseInt(a[2]);
				count++;
				bill.setID("BJD-"+currentTime+"-"+String.format("%05d", Integer.toString(count)));
			}
			else
				bill.setID("BJD-"+currentTime+"-00001");
		}
		pool.add(bill);
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

