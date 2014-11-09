package businesslogic.commoditybillbl;

import po.PO;
import vo.VO;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.examinebl.Bill;

public class StubGiftBill extends Bill implements GetVOandPO
{//赠送单类，统一进入单据池管理和存储
	private BillStyle style=BillStyle.GiftBill;
	private String ID;
	MockCommodity com;
	public VO getVO()
	{
		return new VO();
	}
	public PO getPO()
	{
		return new PO();
	}
}
