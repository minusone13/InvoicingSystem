package businesslogic.commoditybillbl;

// import java.nio.file.attribute.PosixFilePermission; what is it?

import java.util.Date;

import po.*;
import po.SpillsLossBillPO.*;
import vo.*;
import vo.stockvo.CommodityVO;
import businesslogic.*;
import businesslogic.commoditybl.*;
import businesslogic.examinebl.Bill;

public class StubSpillsLossBill extends Bill implements GetVOandPO
{// 报溢报损单，统一进入单据池管理和存储
	//参见大作业要求
	Date date;
	String operator;
	private BillStyle style = BillStyle.SpillsLossBill;
	private MockCommodity com;
	String ID;
	Type t;
	BillState state = BillState.DRAFT;

	public SpillsLossBillVO getVO()
	{
		return new SpillsLossBillVO(operator, ID, t, com.toVO(), state);
	}

	public SpillsLossBillPO getPO()
	{
		return new SpillsLossBillPO(operator, ID, t, com.toPO().clone(), state);
	}

	public boolean setPO(SpillsLossBillPO po)
	{
		if (po == null)
		{
			System.out.println("溢损单PO为NULL");
			return false;
		}
		date = po.getDate();
		operator = po.getOperator();
		com = new MockCommodity(po.getComPO());
		style = BillStyle.SpillsLossBill;
		t = po.getT();
		ID = po.getID();
		state = po.getState();
		t = po.getT();
		return true;
	}

	public boolean setVO(SpillsLossBillVO vo)
	{
		if (vo == null)
		{
			System.out.println("溢损单VO为NULL");
			return false;
		}
		date = vo.getDate();
		operator = vo.getOperator();
		com = new MockCommodity(vo.getCom());
		style = BillStyle.SpillsLossBill;
		t = vo.getT();
		ID = vo.getID();
		state = vo.getState();
		t = vo.getT();
		return true;
	}

	public BillStyle getStyle()
	{
		return style;
	}

	public void setStyle(BillStyle style)
	{
		this.style = style;
	}

	public MockCommodity getCom()
	{
		return com;
	}

	public void setCom(MockCommodity com)
	{
		this.com = com;
	}

	public po.SpillsLossBillPO.Type getT()
	{
		return t;
	}

	public void setT(po.SpillsLossBillPO.Type t)
	{
		this.t = t;
	}

	public String getID()
	{
		return ID;
	}

	public void setID(String iD)
	{
		ID = iD;
	}

	public BillState getState()
	{
		return state;
	}

	public void setState(BillState state)
	{
		StubCommodityList l = new StubCommodityList();
		if (this.state == BillState.DRAFT && state == BillState.SUBMITED)
		{
			if (t == Type.Loss)
				l.readyForOut(ID, com.getName(), com.getModel(),
						com.getNumber(), 0);
			else
				l.readyForIn(ID, com.getName(), com.getModel(),
						com.getNumber(), 0);
		}
		if (this.state == BillState.EXAMINED && state == BillState.OVER)
		{// 当审批订单后，实现系统中的库存数量修改
			if (t == Type.Loss)
				l.checkOut(ID, com.getName(), com.getModel(), com.getNumber(),
						0);// 最后一个参数是价格，报溢报损为无费用的
			else
				l.checkIn(ID, com.getName(), com.getModel(), com.getNumber(), 0);
		}
		this.state = state;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String userID)
	{
		this.operator = userID;
	}
}
