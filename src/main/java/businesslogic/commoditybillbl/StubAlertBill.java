package businesslogic.commoditybillbl;

import vo.*;
import po.*;
import businesslogic.*;
import businesslogic.examinebl.Bill;

public class StubAlertBill extends Bill implements GetVOandPO{
	public VO getVO()
	{
		return new VO();
	}
	public PO getPO()
	{
		return new PO();
	}
}
