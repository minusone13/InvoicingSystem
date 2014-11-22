package businesslogic.commoditybillbl;

import vo.*;
import vo.stockvo.CommodityVO;
import po.*;
import businesslogic.*;
import businesslogic.commoditybl.*;
import businesslogic.examinebl.Bill;

public class StubAlertBill extends Bill implements GetVOandPO
{//报警单对象，统一进入单据池管理和存储
	String ID;
	MockCommodity com;
	int shortage;
	BillStyle style=BillStyle.AlertBill;
	BillState state=BillState.DRAFT;
	public StubAlertBill(){}
	public StubAlertBill(MockCommodity com, int shortage)
	{
		this.com=com;
		this.shortage=shortage;
	}
	public AlertBillVO getVO()
	{
		return new AlertBillVO(ID,new CommodityVO(),shortage);
	}
	public AlertBillPO getPO()
	{
		return new AlertBillPO(ID,com.toPO(),shortage,state);
	}
	public void setPO(AlertBillPO po)
	{
		com=new MockCommodity(po.getCommodity());
		shortage=po.getshortage();
		ID=po.getID();
		style=po.getStyle();
		state=po.getState();
	}
	public MockCommodity getCom() {
		return com;
	}
	public void setCom(MockCommodity com) {
		this.com = com;
	}
	public int getShortage() {
		return shortage;
	}
	public void setShortage(int shortage) {
		this.shortage = shortage;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public BillStyle getStyle() {
		return style;
	}
	public void setStyle(BillStyle style) {
		this.style = style;
	}
	public BillState getState() {
		return state;
	}
	public void setState(BillState state) {
		this.state = state;
	}
}
