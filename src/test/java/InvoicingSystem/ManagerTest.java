package InvoicingSystem;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;
import vo.BarginStrategyVO;
import vo.GiftBillVO;
import vo.LevelStrategyVO;
import vo.ReachStrategyVO;
import vo.VO;
import vo.inquiryVO.BusinessSituationVO;
import businesslogic.BillStyle;
import businesslogic.managerbl.StubManager;
import businesslogicservice.managerblservice.StubManagerBlService;

public class ManagerTest extends TestCase{

	StubManagerBlService mbl=new StubManager();
	

	/*修改密码*/
	@Test
	public void testmodifyPassword (String newpassword){
		boolean result=mbl.modifyPassword("newpassword");
		assertTrue(result);
	}


	

//	/*需要制定一个赠送赠品的客户分层策略*/
//	public void testaddGiftLevelStrategy (LevelStrategyVO lsvo){
//		boolean result=mbl.addGiftLevelStrategy(new LevelStrategyVO());
//		assertTrue(result);
//	}
	/*需要制定一个折让客户分层策略*/
	@Test
	public void testaddDiscountLevelStrategy (LevelStrategyVO lsvo){
		System.out.println("oooo");
		LevelStrategyVO DiscountLevelStrategyTest=new LevelStrategyVO();
		DiscountLevelStrategyTest.setLevel(4);
		DiscountLevelStrategyTest.setDiscountrate(0.8);
		DiscountLevelStrategyTest.setStartTime("2014/12/9");
		DiscountLevelStrategyTest.setLastTime(30);
		boolean result=mbl.addDiscountLevelStrategy(DiscountLevelStrategyTest);
		System.out.println("sizeOfLevel"+mbl.ShowLevelStrategy().size());
		assertTrue(result);
	}
//	/*需要制定一个赠送代金券客户分层策略*/
//	public void testaddCouponLevelStrategy (LevelStrategyVO lsvo){
//		boolean result=mbl.addCouponLevelStrategy(new LevelStrategyVO());
//		assertTrue(result);
//	}
//	/*需要制定一条特价包促销策略*/
//	public void testaddBarginStrategy (BarginStrategyVO bsvo){
//		boolean result=mbl.addBarginStrategy(new BarginStrategyVO());
//		assertTrue(result);
//	}
//	/*需要制定一条赠送赠品的满额促销策略*/
//	public void testaddGiftReachStrategy (ReachStrategyVO rsvo){
//		boolean result=mbl.addGiftReachStrategy(new ReachStrategyVO());
//		assertTrue(result);
//	}
	/*需要制定一条赠送代金券的满额促销策略*/
	@Test
	public void testaddCouponReachStrategy (ReachStrategyVO rsvo){
		ReachStrategyVO CouponReachStrategyTest=new ReachStrategyVO();
		CouponReachStrategyTest.setLimit(1000);
		CouponReachStrategyTest.setCouponrate(0.1);
		CouponReachStrategyTest.setStartTime("2014/12/9");
		CouponReachStrategyTest.setLastTime(30);
		boolean result=mbl.addCouponReachStrategy(CouponReachStrategyTest);
		System.out.println("sizeOfReach"+mbl.ShowReachStrategy().size());
		assertTrue(result);
	}
	/*返回所有客户分层策略信息*/
	@Test
	public void testShowLevelStrategy (){
		ArrayList<LevelStrategyVO> result=mbl.ShowLevelStrategy();
		if(result!=null){
			System.out.println("sizeOfLevel"+result.size());
//			assertEquals(4,result.get(0).getLevel());
		}
		else{
			System.out.println("null");
		}
	}
	/*返回所有特价包策略信息*/
	@Test
	public void testShowBarginStrategy (){
		ArrayList<BarginStrategyVO> result=mbl.ShowBarginStrategy();
		if(result!=null){
			System.out.println("sizeOfBargin"+result.size());
			assertEquals(0,result.size());
		}
		else{
			System.out.println("null");
		}
	}
	/*返回所有满额促销策略信息*/
	@Test
	public void testShowReachStrategy  (){
		ArrayList<ReachStrategyVO> result=mbl.ShowReachStrategy();
		if(result!=null){
			System.out.println("sizeOfReach"+result.size());
//			assertEquals(0.1,result.get(0).getCouponrate());
		}
		else{
			System.out.println("null");
		}
	}
	/*需要删除一条客户分层策略*/
	@Test
	public void testRemove (LevelStrategyVO ls){
		boolean result=mbl.Remove(new LevelStrategyVO());
		assertTrue(result);
	}
	/*需要删除一条特价包策略*/
	@Test
	public void testRemove (BarginStrategyVO bs){
		boolean result=mbl.Remove(new BarginStrategyVO());
		assertTrue(result);
	}
	/*需要删除一条满额促销策略*/
	@Test
	public void testRemove (ReachStrategyVO rs){
		boolean result=mbl.Remove(new ReachStrategyVO());
		assertTrue(result);
	}

}
