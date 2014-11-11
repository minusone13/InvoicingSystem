package InvoicingSystem;

import presentation.commodityui.StockManagerDriver;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.commodityblservice.StubCommodityBlService;
import data.commoditydata.StubStockDataController;
import vo.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class StockTest extends TestCase{
	static StockManagerDriver smd=new StockManagerDriver();
	static
	{
		smd.start(new StubStockController(),new StubStockDataController());
	}
	public void testaddCommodity()
	{
		MockCommodityVO mockvo=new MockCommodityVO("1\\灯","飞利浦日光灯","SR01",20,30);
		StubCommodityBlService combl=smd.getCombl();
		assertNotSame(RM.unknownerror,combl.addCommodity(mockvo));
		//if unknown error happended,it fails. details are in enum RM
	}
}
