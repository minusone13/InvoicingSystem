package po;

import java.io.Serializable;
import java.util.*;

import businesslogic.BillState;
import businesslogic.BillStyle;
import po.stockpo.CommodityPO;

public class GiftBillPO extends PO implements Serializable{
	private BillStyle style = BillStyle.GiftBill;
	private String ID;//订单编号
	private String[] remark;//赠送原因（销售单据编号或手动），赠送客户。分别位于remark[0],remark[1]
	private ArrayList<CommodityPO> coms;//一系列赠送商品，商品内的数量为
	private BillState state=BillState.DRAFT;//订单状态
	public ArrayList<CommodityPO> getComs()
	{
		return coms;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setComs(ArrayList<CommodityPO> coms) {
		this.coms = coms;
	}
	public String[] getRemark() {
		return remark;
	}
	public void setRemark(String[] remark) {
		this.remark = remark;
	}
	public GiftBillPO(){}
	public GiftBillPO(String ID, ArrayList<CommodityPO> coms, String[] remark)
	{
		this.ID=ID;
		this.coms=coms;
		this.remark=remark;
	}
	public GiftBillPO(String ID, ArrayList<CommodityPO> coms, String[] remark,BillState state)
	{
		this.ID=ID;
		this.coms=coms;
		this.remark=remark;
		this.state=state;
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
