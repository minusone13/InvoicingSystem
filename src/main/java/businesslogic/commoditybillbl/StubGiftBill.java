package businesslogic.commoditybillbl;

import po.PO;
import vo.VO;
import businesslogic.GetVOandPO;

public class StubGiftBill implements GetVOandPO{
	public VO getVO()
	{
		return new VO();
	}
	public PO getPO()
	{
		return new PO();
	}
}
