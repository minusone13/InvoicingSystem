package businesslogic.commoditybillbl;

//import java.nio.file.attribute.PosixFilePermission; what is it?

import po.*;
import vo.SpillsLossBillVO;
import vo.VO;
import vo.stockvo.CommodityVO;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.examinebl.Bill;

public class StubSpillsLossBill extends Bill implements GetVOandPO
{//报溢报损单，统一进入单据池管理和存储
	private BillStyle style=BillStyle.SpillsLossBill;
	private MockCommodity com;
	String ID;
	po.SpillsLossBillPO.Type t;
	public SpillsLossBillVO getVO()
	{
		return new SpillsLossBillVO(ID,t,new CommodityVO());
	}
	public SpillsLossBillPO getPO()
	{
		return new SpillsLossBillPO(ID,t,com.toPO().clone());
	}
	public void setPO(SpillsLossBillPO po)
	{
		com=new MockCommodity(po.getComPO());
		t=po.getT();
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
}
