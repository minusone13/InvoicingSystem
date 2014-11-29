package businesslogic.commoditybillbl;

//import java.nio.file.attribute.PosixFilePermission; what is it?

import java.util.Date;

import po.*;
import po.SpillsLossBillPO.*;
import vo.*;
import vo.stockvo.CommodityVO;
import businesslogic.*;
import businesslogic.commoditybl.*;
import businesslogic.examinebl.Bill;

public class StubSpillsLossBill extends Bill implements GetVOandPO
{//报溢报损单，统一进入单据池管理和存储
	Date date;
	String userID;
	private BillStyle style=BillStyle.SpillsLossBill;
	private MockCommodity com;
	String ID;
	Type t;
	BillState state=BillState.DRAFT;
	public SpillsLossBillVO getVO()
	{
		return new SpillsLossBillVO(ID,t,new CommodityVO());
	}
	public SpillsLossBillPO getPO()
	{
		return new SpillsLossBillPO(ID,t,com.toPO().clone(),state);
	}
	public void setPO(SpillsLossBillPO po)
	{
		com=new MockCommodity(po.getComPO());
		t=po.getT();
		ID=po.getID();
		state=po.getState();
	}
	public BillStyle getStyle() {
		return style;
	}
	public void setStyle(BillStyle style) {
		this.style = style;
	}
	public MockCommodity getCom() {
		return com;
	}
	public void setCom(MockCommodity com) {
		this.com = com;
	}
	public po.SpillsLossBillPO.Type getT() {
		return t;
	}
	public void setT(po.SpillsLossBillPO.Type t) {
		this.t = t;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public BillState getState() {
		return state;
	}
	public void setState(BillState state) {
		if(this.state==BillState.SUBMITED && state==BillState.EXAMINED)
		{//当审批订单后，实现系统中的库存数量修改
			StubCommodityList l= new StubCommodityList();
			if(t==Type.Loss)
				l.checkOut(ID, com.getName(), com.getModel(), com.getNumber(), 0);//最后一个参数是价格，报溢报损为无费用的
			else
				l.checkIn(ID, com.getName(), com.getModel(), com.getNumber(), 0);
		}
		this.state = state;
	}
	public synchronized Date getDate() {
		return date;
	}
	public synchronized void setDate(Date date) {
		this.date = date;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
}
