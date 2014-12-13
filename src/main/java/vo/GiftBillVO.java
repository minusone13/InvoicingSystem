package vo;

import java.util.ArrayList;
import java.util.Date;

import vo.stockvo.CommodityVO;
import businesslogic.BillState;
import businesslogic.BillStyle;

public class GiftBillVO extends VO{
	private BillStyle billstyle=BillStyle.GiftBill;//订单种类
	private String ID;//订单编号
	private String operator;
	private Date date;
	private String[] remark;//赠送原因（销售单据编号或手动），赠送客户。分别位于remark[0],remark[1]
	private ArrayList<CommodityVO> coms;//一系列赠送商品，商品内的数量为
	private BillState state=BillState.DRAFT;//订单状态
	public GiftBillVO(){}
	public ArrayList<CommodityVO> getComs()
	{
		return coms;
	}
	public String getID() {
		return this.ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setComs(ArrayList<CommodityVO> coms) {
		this.coms = coms;
	}
	public String[] getRemark() {
		return remark;
	}
	public void setRemark(String[] remark) {
		this.remark = remark;
	}
	public GiftBillVO(String userID,String ID, ArrayList<CommodityVO> coms, String[] remark)
	{
		this.operator=userID;
		this.ID=ID;
		this.coms=coms;
		this.remark=remark;
	}
	public GiftBillVO(String userID,String ID, ArrayList<CommodityVO> coms, String[] remark,BillState state)
	{
		this.operator=userID;
		this.ID=ID;
		this.coms=coms;
		this.remark=remark;
		this.state=state;
	}
	public GiftBillVO(Date date,String userID,String ID, ArrayList<CommodityVO> coms, String[] remark,BillState state)
	{
		this.date=date;
		this.operator=userID;
		this.ID=ID;
		this.coms=coms;
		this.remark=remark;
		this.state=state;
	}
	public BillStyle getBillstyle() {
		return billstyle;
	}
	public void setBillstyle(BillStyle billstyle) {
		this.billstyle = billstyle;
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
