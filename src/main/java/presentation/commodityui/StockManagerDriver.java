package presentation.commodityui;

import dataservice.commoditydataservice.*;
import vo.*;
import businesslogicservice.commodityblservice.*;

public class StockManagerDriver {
	public void start(StubCommodityBlService combl,StubCommodityDataService comdata){
		combl.setdataobject(comdata);
		CommodityVO vo = new CommodityVO("id","philips","s01",10,10);
		RM r= combl.addCommodity(vo);
	}
}
