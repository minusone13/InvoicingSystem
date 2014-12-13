package businesslogic.commoditybillbl;

import java.util.ArrayList;
import java.util.Date;

import po.*;
import po.SpillsLossBillPO.Type;
import po.stockpo.CommodityPO;
import vo.GiftBillVO;
import vo.VO;
import vo.stockvo.CommodityVO;
import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.commoditybl.StubCommodityList;
import businesslogic.examinebl.Bill;

public class StubGiftBill extends Bill implements GetVOandPO
{//赠送单类，统一进入单据池管理和存储
	Date date;
	private BillStyle billstyle=BillStyle.GiftBill;
	String operator;
	private String ID;
	ArrayList<MockCommodity> coms=new ArrayList<MockCommodity>();//王雨城加
	BillState state=BillState.DRAFT;
	String remark[];
	public GiftBillVO getVO()
	{
		ArrayList<CommodityVO> result=new ArrayList<CommodityVO>();
		for(int i=0;i<coms.size();i++)
			result.add(coms.get(i).toVO());
		return new GiftBillVO(date,operator,ID,result,remark,state);
	}
	public GiftBillPO getPO()
	{
		ArrayList<CommodityPO> result=new ArrayList<CommodityPO>();
		for(int i=0;i<coms.size();i++)
			result.add(coms.get(i).toPO());
		return new GiftBillPO(date,operator,ID,result,remark,state);//bug may appear
	}
	public boolean setPO(GiftBillPO po)
	{
		if(po==null)
		{
			System.out.println("赠送单PO为NULL");
			return false;
		}
		for(int i=0;i<po.getComs().size();i++)
			coms.add(new MockCommodity(po.getComs().get(i)));
		ID=po.getID();
		state=po.getState();
		remark=po.getRemark();
		date=po.getDate();
		billstyle=BillStyle.GiftBill;
		operator=po.getOperator();
		ID=po.getID();
		remark=po.getRemark();
		return true;
	}
	public boolean setVO(GiftBillVO vo)
	{
		if(vo==null)
		{
			System.out.println("赠送单VO为NULL");
			return false;
		}
		for(int i=0;i<vo.getComs().size();i++)
			coms.add(new MockCommodity(vo.getComs().get(i)));
		ID=vo.getID();
		state=vo.getState();
		remark=vo.getRemark();
		date=vo.getDate();
		billstyle=BillStyle.GiftBill;
		operator=vo.getOperator();
		ID=vo.getID();
		remark=vo.getRemark();
		return true;
	}
	
	public BillStyle getBillstyle() {
		return billstyle;
	}
	public void setBillstyle(BillStyle billstyle) {
		this.billstyle = billstyle;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public ArrayList<MockCommodity> getComs() {
		return coms;
	}
	public void setComs(ArrayList<MockCommodity> coms) {
		this.coms = coms;
	}
	public String[] getRemark() {
		return remark;
	}
	public void setRemark(String[] remark) {
		this.remark = remark;
	}
	public BillState getState() {
		return state;
	}
	public void setState(BillState state) {
		StubCommodityList l= new StubCommodityList();
		if(this.state==BillState.DRAFT &&  state==BillState.SUBMITED)
		{
			for(int i=0; i<coms.size(); i++)
			{
				MockCommodity com = coms.get(i);
				l.readyForOut(ID, com.getName(), com.getModel(), com.getNumber(), 0);
			}
		}
		if(this.state==BillState.EXAMINED && state==BillState.OVER)
		{//当审批订单后，实现系统中的库存数量修改
			for(int i=0; i<coms.size(); i++)
			{
				MockCommodity com = coms.get(i);
				l.checkOut(ID, com.getName(), com.getModel(), com.getNumber(), 0);
			}
		}
		this.state = state;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String userID) {
		this.operator = userID;
	}
}
