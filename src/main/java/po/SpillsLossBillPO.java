package po;

import java.io.Serializable;
import java.util.Date;

import po.stockpo.CommodityPO;

public class SpillsLossBillPO extends PO implements Serializable
{
	public enum Type
	{
		Spills, Loss
	}

	private BillStyle style = BillStyle.SpillsLossBill;// 订单种类
	private Date date;
	String operator;
	private String ID;// 单据编号
	private Type t;// 溢出or损坏种类
	private CommodityPO comPO;// 报告的商品，商品中的数量为溢出损坏数量
	private BillState state = BillState.DRAFT;// 单据状态

	public Type getT()
	{
		return t;
	}

	public void setT(Type t)
	{
		this.t = t;
	}

	public CommodityPO getComPO()
	{
		return comPO;
	}

	public void setComPO(CommodityPO comPO)
	{
		this.comPO = comPO;
	}

	public SpillsLossBillPO(String userID, String ID, Type t, CommodityPO comPO)
	{
		this.operator = userID;
		this.ID = ID;
		this.t = t;
		this.comPO = comPO;
	}

	public SpillsLossBillPO(String userID, String ID, Type t,
			CommodityPO comPO, BillState state)
	{
		this.operator = userID;
		this.ID = ID;
		this.t = t;
		this.comPO = comPO;
		this.state = state;
	}

	public SpillsLossBillPO(Date date, String userID, String ID, Type t,
			CommodityPO comPO, BillState state)
	{
		this.date = date;
		this.operator = userID;
		this.ID = ID;
		this.t = t;
		this.comPO = comPO;
		this.state = state;
	}

	public SpillsLossBillPO()
	{}

	public BillStyle getStyle()
	{
		return style;
	}

	public void setStyle(BillStyle style)
	{
		this.style = style;
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
		this.state = state;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String userID)
	{
		this.operator = userID;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}
}
