package presentation.commodityui;

import dataservice.commoditydataservice.*;
import vo.*;
import vo.stockvo.CommodityVO;
import businesslogicservice.commodityblservice.*;

public class StockManagerDriver {
	StubCommodityBlService combl;
	
	public void start(StubCommodityBlService combl,CommodityDataService comdata){
		this.combl=combl;
		combl.setdataobject(comdata);
	}
	
	public StubCommodityBlService getCombl()
	{
		return combl;
	}
}
