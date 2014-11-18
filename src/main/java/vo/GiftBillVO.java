package vo;

import java.util.ArrayList;
import vo.stockvo.CommodityVO;
import businesslogic.BillStyle;

public class GiftBillVO extends VO{
	private BillStyle billstyle=BillStyle.GiftBill;
	String ID;
	String[] remark;
	ArrayList<CommodityVO> coms;
	public ArrayList<CommodityVO> getComs()
	{
		return coms;
	}
	public String getID() {
		return ID;
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
	public GiftBillVO(String ID, ArrayList<CommodityVO> coms, String[] remark)
	{
		this.ID=ID;
		this.coms=coms;
		this.remark=remark;
	}
}
