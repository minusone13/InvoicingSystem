package po;

import po.stockpo.CommodityPO;


public class AlertBillPO extends PO{
	CommodityPO comPO;
	int shortage;
	public AlertBillPO(CommodityPO comPO,int shortage)
	{
		this.comPO=comPO;
		this.shortage=shortage;
	}
	public CommodityPO getCommodity()
	{
		return comPO;
	}
	public int getshortage()
	{
		return shortage;
	}
}
