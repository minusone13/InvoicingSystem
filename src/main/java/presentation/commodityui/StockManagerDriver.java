package presentation.commodityui;

import dataservice.commoditydataservice.*;
import vo.*;
import vo.stockvo.CommodityVO;
import businesslogicservice.commodityblservice.*;

public class StockManagerDriver {
	StubCommodityBlService combl;
	
	public void start(StubCommodityBlService combl,StubCommodityDataService comdata){
		this.combl=combl;
		combl.setdataobject(comdata);
		CommodityVO vo = new CommodityVO("1\\id","philips","s01",10,10);
		RM r= combl.addCommodity(vo);
	}
	
	public StubCommodityBlService getCombl()
	{
		return combl;
	}
}
