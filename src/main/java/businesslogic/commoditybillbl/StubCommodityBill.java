package businesslogic.commoditybillbl;

import java.util.ArrayList;

import vo.*;

public class StubCommodityBill 
{//统一管理了库存单据，相当于一个对内的Controller
	ArrayList<StubAlertBill> alerts;
	ArrayList<StubGiftBill> gifts;
	ArrayList<StubSpillsLossBill> sls;
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
}

