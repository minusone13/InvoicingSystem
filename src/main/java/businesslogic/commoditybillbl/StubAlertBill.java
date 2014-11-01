package businesslogic.commoditybillbl;

import vo.*;
import po.*;
import businesslogic.*;
import businesslogic.examinebl.Bill;

public class StubAlertBill extends Bill implements GetVOandPO{
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
