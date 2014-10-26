package presentation.commodityui;

import vo.*;
import businesslogicservice.commodityblservice.*;

public class StockManagerDriver {
	public void start(StubCommodityBlService combl){
		CommodityVO vo = new CommodityVO("id","philips","s01",10,10);
		RM r= combl.addCommodity(vo);
	}
}
