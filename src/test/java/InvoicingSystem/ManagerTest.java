package InvoicingSystem;

import java.util.ArrayList;

import junit.framework.TestCase;
import vo.BarginStrategyVO;
import vo.BusinessSituationVO;
import vo.GiftBillVO;
import vo.LevelStrategyVO;
import vo.ReachStrategyVO;
import vo.VO;
import businesslogic.BillStyle;
import businesslogic.managerbl.StubManager;
import businesslogicservice.managerblservice.StubManagerBlService;

public class ManagerTest extends TestCase{

	StubManagerBlService mbl=new StubManager();
	
	/*需要查看已提交单据*/
	public void testgetHandedBill (){
		ArrayList<VO> result=mbl.getHandedBill();
		assertEquals(0,result.size());
	}
	/*修改密码*/
	public void testmodifyPassword (String newpassword){
		boolean result=mbl.modifyPassword("newpassword");
		assertTrue(result);
	}
    /*修改单据信息*/
	public void testchange(GiftBillVO gb){
		GiftBillVO vo=new GiftBillVO();
		boolean result=mbl.change(vo);
		assertTrue(result);
	}
	/*通过数组中对应的单据*/
	public void testPassBill(ArrayList<VO> billvo){
		boolean result=mbl.PassBill(null);
		assertTrue(result);
	}
	/*返回所有客户分层策略信息*/
	public void testShowLevelStrategy (){
		ArrayList<VO> result=mbl.ShowLevelStrategy();
		assertEquals(0,result.size());
	}
	/*返回所有特价包策略信息*/
	public void testShowBarginStrategy (){
		ArrayList<VO> result=mbl.ShowBarginStrategy();
		assertEquals(0,result.size());
	}
	/*返回所有满额促销策略信息*/
	public void testShowReachStrategy  (){
		ArrayList<VO> result=mbl.ShowReachStrategy();
		assertEquals(0,result.size());
	}
	/*需要删除一条客户分层策略*/
	public void testRemove (LevelStrategyVO ls){
		boolean result=mbl.Remove(new LevelStrategyVO());
		assertTrue(result);
	}
	/*需要删除一条特价包策略*/
	public void testRemove (BarginStrategyVO bs){
		boolean result=mbl.Remove(new BarginStrategyVO());
		assertTrue(result);
	}
	/*需要删除一条满额促销策略*/
	public void testRemove (ReachStrategyVO rs){
		boolean result=mbl.Remove(new ReachStrategyVO());
		assertTrue(result);
	}
	/*需要制定一个赠送赠品的客户分层策略*/
	public void testaddGiftLevelStrategy (LevelStrategyVO lsvo){
		boolean result=mbl.addGiftLevelStrategy(new LevelStrategyVO());
		assertTrue(result);
	}
	/*需要制定一个折让客户分层策略*/
	public void testaddDiscountLevelStrategy (LevelStrategyVO lsvo){
		boolean result=mbl.addDiscountLevelStrategy(new LevelStrategyVO());
		assertTrue(result);
	}
	/*需要制定一个赠送代金券客户分层策略*/
	public void testaddCouponLevelStrategy (LevelStrategyVO lsvo){
		boolean result=mbl.addCouponLevelStrategy(new LevelStrategyVO());
		assertTrue(result);
	}
	/*需要制定一条特价包促销策略*/
	public void testaddBarginStrategy (BarginStrategyVO bsvo){
		boolean result=mbl.addBarginStrategy(new BarginStrategyVO());
		assertTrue(result);
	}
	/*需要制定一条赠送赠品的满额促销策略*/
	public void testaddGiftReachStrategy (ReachStrategyVO rsvo){
		boolean result=mbl.addGiftReachStrategy(new ReachStrategyVO());
		assertTrue(result);
	}
	/*需要制定一条赠送代金券的满额促销策略*/
	public void testaddCouponReachStrategy (ReachStrategyVO rsvo){
		boolean result=mbl.addCouponReachStrategy(new ReachStrategyVO());
		assertTrue(result);
	}
	/*需要查看经营历程*/
	public void testshowBusinessProgress(String client,String operater,String warehouse,BillStyle billStyle, String StartTime,String LastTime){
		ArrayList<VO> result=mbl.showBusinessProgress("#clientnum","operaternum","warehousenum",null,"2014/6/4","2014/7/5");
		assertEquals(0,result.size());
	}
	/*需要查看销售明细*/
	public void testshowSaleDetail(String client,String operater,String warehouse,String commodity, String StartTime,String LastTime){
		ArrayList<VO> result=mbl.showSaleDetail("#clientnum","#operaternum","#warehousenum","#commoditynum","2014/6/4","2014/7/5");
		assertEquals(0,result.size());
	}
	/*需要查看经营情况*/
	public void testshowBusinessSituation (String StartTime,String LastTime){
		BusinessSituationVO result=mbl.showBusinessSituation("2014/6/4","2014/7/5");
		assertEquals(0,result.tempForTest);
	}

}
