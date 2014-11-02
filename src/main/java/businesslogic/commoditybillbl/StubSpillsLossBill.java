package businesslogic.commoditybillbl;

import po.PO;
import po.SpillsLossBillPO;
import vo.VO;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.examinebl.Bill;

public class StubSpillsLossBill extends Bill implements GetVOandPO
{//报溢报损单，统一进入单据池管理和存储
	private BillStyle style=BillStyle.SpillsLossBill;
	private String ID;
	public enum Type
	{
		Spills,
		Loss
	}
	Type t;
	public VO getVO()
	{
		return new VO();
	}
	public PO getPO()
	{
		return new PO();
	}
}
