package businesslogic.commoditybillbl;

import vo.*;
import po.*;
import businesslogic.*;
import businesslogic.commoditybl.*;
import businesslogic.examinebl.Bill;

public class StubAlertBill extends Bill implements GetVOandPO
{//报警单对象，统一进入单据池管理和存储
	MockCommodity com;
	int shortage;
	public StubAlertBill(MockCommodity com, int shortage)
	{
		this.com=com;
		this.shortage=shortage;
	}
	public VO getVO()
	{
		return new VO();
	}
	public PO getPO()
	{
		return new PO();
	}
	public void setPO(AlertBillPO po)
	{
		com=new MockCommodity(po.getCommodity());
		shortage=po.getshortage();
	}
}
