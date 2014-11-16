package businesslogic.commoditybillbl;

import java.nio.file.attribute.PosixFilePermission;

import po.*;
import vo.VO;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.examinebl.Bill;

public class StubSpillsLossBill extends Bill implements GetVOandPO
{//报溢报损单，统一进入单据池管理和存储
	private BillStyle style=BillStyle.SpillsLossBill;
	private MockCommodity com;
	po.SpillsLossBillPO.Type t;
	public VO getVO()
	{
		return new VO();
	}
	public PO getPO()
	{
		return new PO();
	}
	public void setPO(SpillsLossBillPO po)
	{
		com=new MockCommodity(po.getComPO());
		t=po.getT();
	}
}
