package businesslogic.commoditybillbl;

import java.util.Date;

import vo.*;
import vo.stockvo.CommodityVO;
import po.*;
import businesslogic.*;
import businesslogic.commoditybl.*;
import businesslogic.examinebl.Bill;

public class StubAlertBill extends Bill implements GetVOandPO
{//报警单对象，统一进入单据池管理和存储
	Date date;
	String ID;
	String operator;
	MockCommodity com;
	int shortage;
	BillStyle style=BillStyle.AlertBill;
	BillState state=BillState.DRAFT;
	public StubAlertBill()
	{
		date = new Date();
	}
	public StubAlertBill(String userID,MockCommodity com, int shortage)
	{
		date = new Date();
		this.operator=userID;
		this.com=com;
		this.shortage=shortage;
	}
	public AlertBillVO getVO()
	{
		return new AlertBillVO(date,operator,ID,new CommodityVO(),shortage,state);
	}
	public AlertBillPO getPO()
	{
		return new AlertBillPO(date,operator,ID,com.toPO(),shortage,state);
	}
	public void setPO(AlertBillPO po)
	{
		date=po.getDate();
		operator=po.getOperator();
		com=new MockCommodity(po.getCommodity());
		shortage=po.getshortage();
		ID=po.getID();
		style=po.getStyle();
		state=po.getState();
	}
	public void setVO(AlertBillVO vo)
	{
		date=vo.getDate();
		operator=vo.getOperator();
		com=new MockCommodity(vo.getCommodity());
		shortage=vo.getshortage();
		ID=vo.getID();
		style=vo.getBillstyle();
		state=vo.getState();
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
	public  Date getDate() {
		return date;
	}
	public  void setDate(Date date) {
		this.date = date;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String userID) {
		this.operator = userID;
	}
}
