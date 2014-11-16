package presentation.commodityui;

import dataservice.commoditydataservice.*;
import vo.*;
import vo.stockpo.MockCommodityVO;
import businesslogicservice.commodityblservice.*;

public class StockManagerDriver {
	StubCommodityBlService combl;
	
	public void start(StubCommodityBlService combl,StubCommodityDataService comdata){
		this.combl=combl;
		combl.setdataobject(comdata);
		MockCommodityVO vo = new MockCommodityVO("1\\id","philips","s01",10,10);
		RM r= combl.addCommodity(vo);
	}
	
	public StubCommodityBlService getCombl()
	{
		return combl;
	}
}
