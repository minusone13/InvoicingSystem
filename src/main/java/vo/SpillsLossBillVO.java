package vo;

import po.SpillsLossBillPO.Type;
import po.stockpo.CommodityPO;
import vo.stockvo.CommodityVO;
import businesslogic.BillStyle;

public class SpillsLossBillVO extends VO{
	private BillStyle billstyle=BillStyle.SpillsLossBill;
	String ID;
	Type t;
	CommodityVO com;
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
	public SpillsLossBillVO(String ID,Type t, CommodityVO com)
	{
		this.ID=ID;
		this.t=t;
		this.com=com;
	}
}
