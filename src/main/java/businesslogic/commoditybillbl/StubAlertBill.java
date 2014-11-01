package businesslogic.commoditybillbl;

import vo.*;
import po.*;
import businesslogic.*;
import businesslogic.examinebl.Bill;

public class StubAlertBill extends Bill implements GetVOandPO
{//报警单对象，统一进入单据池管理和存储
	private BillStyle style=BillStyle.AlertBill;
	private String ID;
	public VO getVO()
	{
		return new VO();
	}
	public PO getPO()
	{
		return new PO();
	}
}
