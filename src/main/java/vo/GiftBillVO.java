package vo;

import java.util.ArrayList;

import vo.stockpo.MockCommodityVO;
import businesslogic.BillStyle;

public class GiftBillVO extends VO{
	private BillStyle billstyle=BillStyle.GiftBill;
	String ID;
	String[] remark;
	ArrayList<MockCommodityVO> coms;
	public ArrayList<MockCommodityVO> getComs()
	{
		return coms;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setComs(ArrayList<MockCommodityVO> coms) {
		this.coms = coms;
	}
	public String[] getRemark() {
		return remark;
	}
	public void setRemark(String[] remark) {
		this.remark = remark;
	}
}
