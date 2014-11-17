package InvoicingSystem;

//import static org.junit.Assert.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

//import org.junit.*;

import po.stockpo.*;
import presentation.commodityui.StockManagerDriver;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.commodityblservice.StubCommodityBlService;
import data.commoditydata.*;
import data.initial.Initial;
import dataservice.commoditydataservice.StubCommodityDataService;
import vo.*;
import vo.stockpo.*;


public class StockTest extends TestCase{
	static StockManagerDriver smd=new StockManagerDriver();
	static StubStockDataController data=new StubStockDataController();
	static
	{
		smd.start(new StubStockController(),data);
		data.setL(new MockCommodityList());
	}
	
	public void testaddCommodity()
	{
		MockCommodityVO mockvo=new MockCommodityVO("1\\灯","飞利浦日光灯","SR01",20,30);
		StubCommodityBlService combl=smd.getCombl();
		assertNotSame(RM.unknownerror,combl.addCommodity(mockvo));
		//if unknown error happended,it fails. details are in enum RM
	}
	
	public void testaddCategory()
	{
		Initial initial=new Initial();
		initial.initialStock();
		assertNotSame(RM.unknownerror,data.insert(new CategoryPO("1", "日光灯")));
	}
}
