package businesslogic.commoditybillbl;

import po.PO;
import vo.VO;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.examinebl.Bill;

public class StubSpillsLossBill extends Bill implements GetVOandPO{
	private BillStyle style=BillStyle.SpillsLossBill;
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
