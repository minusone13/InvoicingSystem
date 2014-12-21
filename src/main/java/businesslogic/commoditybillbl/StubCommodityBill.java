package businesslogic.commoditybillbl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po.RM;
import po.Role;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.examinebl.StubBillPool;
import businesslogic.userbl.User;
import vo.*;
import vo.uservo.UserVO;

public class StubCommodityBill
{// 统一管理了库存单据，相当于一个对内的Controller
	ArrayList<StubAlertBill> alerts;//这三个事实上是省去了下面的变量定义，实际的List从单据Pool里面取出来
	ArrayList<StubGiftBill> gifts;
	ArrayList<StubSpillsLossBill> sls;
	static StubBillPool pool = new StubBillPool();
	User user = new User("I0000", Role.STOCK_STAFF, "stockdefault", "default",
			"Liu");

	public RM add(StubSpillsLossBill bill)
	{
		sls = pool.getSpillsLossBill();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		if (sls.size() == 0 || sls.get(sls.size() - 1).getID() == null)// 后面的一个表达式是为了增加程序的坚固性
			bill.setID("YSD-" + currentTime + "-00001");
		else
		{
			String s = sls.get(sls.size() - 1).getID();
			String a[] = s.split("-");
			if (currentTime.equals(a[1]))// 日期相同，继续编号
			{
				int count = Integer.parseInt(a[2]);
				count++;
				bill.setID("YSD-" + currentTime + "-"
						+ String.format("%05d", count));
			}
			else
				bill.setID("YSD-" + currentTime + "-00001");
		}
		bill.setDate(new Date());
		bill.setOperator(user.getID() + user.getName());
		pool.add(bill);
		return RM.done;
	}

	public RM add(StubGiftBill bill)
	{
		gifts = pool.getGiftBill();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		if (gifts.size() == 0 || gifts.get(gifts.size() - 1).getID() == null)// 后面的一个表达式是为了增加程序的坚固性
			bill.setID("ZSD-" + currentTime + "-00001");
		else
		{
			String s = gifts.get(gifts.size() - 1).getID();
			String a[] = s.split("-");
			if (currentTime.equals(a[1]))// 日期相同，继续编号
			{
				int count = Integer.parseInt(a[2]);
				count++;
				bill.setID("ZSD-" + currentTime + "-"
						+ String.format("%05d", count));
			}
			else
				bill.setID("ZSD-" + currentTime + "-00001");
		}
		bill.setDate(new Date());
		bill.setOperator(user.getID() + user.getName());
		pool.add(bill);
		return RM.done;
	}

	public RM add(StubAlertBill bill)
	{
		alerts = pool.getAlertBill();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		if (alerts.size() == 0 || alerts.get(alerts.size() - 1).getID() == null)// 后面的一个表达式是为了增加程序的坚固性
			bill.setID("BJD-" + currentTime + "-00001");
		else
		{
			String s = alerts.get(alerts.size() - 1).getID();
			if (s == null)
				return RM.outsideStockError;
			String a[] = s.split("-");
			if (currentTime.equals(a[1]))// 日期相同，继续编号
			{
				int count = Integer.parseInt(a[2]);
				count++;
				bill.setID("BJD-" + currentTime + "-"
						+ String.format("%05d", count));
			}
			else
				bill.setID("BJD-" + currentTime + "-00001");
		}
		bill.setDate(new Date());
		bill.setOperator(user.getID() + user.getName());
		pool.add(bill);
		return RM.done;
	}

	public double getSpillsTotal(Date d1, Date d2)
	{// including d1 and d2
		sls = pool.getSpillsLossBill(BillState.OVER);
		double sum = 0;
		for (int i = 0; i < sls.size(); i++)
		{
			StubSpillsLossBill temp = sls.get(i);
			Date d = temp.getDate();
			if (temp.t == temp.t.Spills && d.after(d1) && d.before(d2))
				sum += temp.getCom().getIn() * temp.getCom().getNumber();
		}
		return sum;
	}

	public double getLossTotal(Date d1, Date d2)
	{// see above
		sls = pool.getSpillsLossBill(BillState.OVER);
		double sum = 0;
		for (int i = 0; i < sls.size(); i++)
		{
			StubSpillsLossBill temp = sls.get(i);
			Date d = temp.getDate();
			if (temp.t == temp.t.Loss && d.after(d1) && d.before(d2))
				sum += temp.getCom().getIn() * temp.getCom().getNumber();
		}
		return sum;
	}

	public double getGiftBillTotal(Date d1, Date d2)
	{// 赠送单支出。这个返回值可能为非负
		gifts = pool.getGiftBill(BillState.OVER);
		double sum = 0;
		for (int i = 0; i < gifts.size(); i++)
		{
			StubGiftBill temp = gifts.get(i);
			Date d = temp.getDate();
			if (d.after(d1) && d.before(d2))
			{
				for (int j = 0; j < temp.getComs().size(); i++)
				{
					MockCommodity com = temp.getComs().get(j);
					sum += com.getIn() * com.getNumber();
				}
			}
		}
		return sum;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public StubBillPool getPool()
	{
		return pool;
	}

	public void setPool(StubBillPool pool)
	{
		this.pool = pool;
	}
}
