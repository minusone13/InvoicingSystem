package businesslogic.commoditybillbl;

import java.util.ArrayList;

import po.*;
import vo.VO;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.examinebl.Bill;

public class StubGiftBill extends Bill implements GetVOandPO
{//赠送单类，统一进入单据池管理和存储
	private BillStyle style=BillStyle.GiftBill;
	private String ID;
	ArrayList<MockCommodity> coms;
	public VO getVO()
	{
		return new VO();
	}
	public GiftBillPO getPO()
	{
		return new GiftBillPO();
	}
	public void setPO(GiftBillPO po)
	{
		for(int i=0;i<po.getComs().size();i++)
			coms.add(new MockCommodity(po.getComs().get(i)));
		ID=po.getID();
	}
}
