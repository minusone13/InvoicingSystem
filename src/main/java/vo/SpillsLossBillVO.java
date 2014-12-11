package vo;

import java.util.ArrayList;
import java.util.Date;

import po.SpillsLossBillPO.Type;
import po.stockpo.CommodityPO;
import vo.stockvo.CommodityVO;
import businesslogic.BillState;
import businesslogic.BillStyle;

public class SpillsLossBillVO extends VO{
	private BillStyle billstyle=BillStyle.SpillsLossBill;//订单种类
	private String operator;
	private String ID;//单据编号
	private Date date;
	private Type t;//溢出、损坏种类
	private CommodityVO com;//报告的商品，其中的数量属性为溢出损坏数量
	private BillState state=BillState.DRAFT;//单据状态
	public BillStyle getBillstyle() {
		return billstyle;
	}
	public void setBillstyle(BillStyle billstyle) {
		this.billstyle = billstyle;
	}
	public Type getT() {
		return t;
	}
	public void setT(Type t) {
		this.t = t;
	}
	public CommodityVO getCom() {
		return com;
	}
	public void setCom(CommodityVO com) {
		this.com = com;
	}
	public SpillsLossBillVO(String userID,String ID,Type t, CommodityVO com)
	{
		this.operator=userID;
		this.ID=ID;
		this.t=t;
		this.com=com;
	}
	public SpillsLossBillVO(String userID,String ID,Type t, CommodityVO com,BillState state)
	{
		this.operator=userID;
		this.ID=ID;
		this.t=t;
		this.com=com;
		this.state=state;
	}
	public SpillsLossBillVO(Date date,String userID,String ID,Type t, CommodityVO com,BillState state)
	{
		this.date=date;
		this.operator=userID;
		this.ID=ID;
		this.t=t;
		this.com=com;
		this.state=state;
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
		this.state = state;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String userID) {
		this.operator = userID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
