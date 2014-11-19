package businesslogic.commoditybillbl;

import java.util.ArrayList;

import po.*;
import po.stockpo.CommodityPO;
import vo.GiftBillVO;
import vo.VO;
import vo.stockvo.CommodityVO;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.examinebl.Bill;

public class StubGiftBill extends Bill implements GetVOandPO
{//赠送单类，统一进入单据池管理和存储
	private BillStyle style=BillStyle.GiftBill;
	private String ID;
	ArrayList<MockCommodity> coms;
	String remark[];
	public GiftBillVO getVO()
	{
		return new GiftBillVO(ID,new ArrayList<CommodityVO>(),remark);
	}
	public GiftBillPO getPO()
	{
		ArrayList<CommodityPO> result=new ArrayList<CommodityPO>();
		for(int i=0;i<coms.size();i++)
			result.add(coms.get(i).toPO());
		return new GiftBillPO(ID,result,remark);//bug may appear
	}
	public void setPO(GiftBillPO po)
	{
		for(int i=0;i<po.getComs().size();i++)
			coms.add(new MockCommodity(po.getComs().get(i)));
		ID=po.getID();
	}
	public BillStyle getStyle() {
		return style;
	}
	public void setStyle(BillStyle style) {
		this.style = style;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public ArrayList<MockCommodity> getComs() {
		return coms;
	}
	public void setComs(ArrayList<MockCommodity> coms) {
		this.coms = coms;
	}
	public String[] getRemark() {
		return remark;
	}
	public void setRemark(String[] remark) {
		this.remark = remark;
	}
}
