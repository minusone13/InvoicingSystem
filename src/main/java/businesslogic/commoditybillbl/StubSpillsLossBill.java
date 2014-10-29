package businesslogic.commoditybillbl;

import po.PO;
import vo.VO;
import businesslogic.GetVOandPO;
import businesslogic.examinebl.Bill;

public class StubSpillsLossBill extends Bill implements GetVOandPO{
	public VO getVO()
	{
		return new VO();
	}
	public PO getPO()
	{
		return new PO();
	}
}
