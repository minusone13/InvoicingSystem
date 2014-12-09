package presentation.managerui;

import java.util.ArrayList;

import vo.BarginStrategyVO;
import vo.GiftBillVO;
import vo.LevelStrategyVO;
import vo.ReachStrategyVO;
import vo.VO;
import businesslogicservice.managerblservice.StubManagerBlService;

public class ManagerBLDriver {

	StubManagerBlService mbs;
	public ManagerBLDriver (StubManagerBlService mbs) {
		this.mbs = mbs;
	}
	
	public void drive(){
	mbs.modifyPassword("wwweee");	
	
	LevelStrategyVO DiscountLevelStrategyTest=new LevelStrategyVO();
	DiscountLevelStrategyTest.setLevel(4);
	DiscountLevelStrategyTest.setDiscountrate(0.8);
	DiscountLevelStrategyTest.setStartTime("2014/12/9");
	DiscountLevelStrategyTest.setLastTime(30);
	ReachStrategyVO CouponReachStrategyTest=new ReachStrategyVO();
	CouponReachStrategyTest.setLimit(1000);
	CouponReachStrategyTest.setCouponrate(0.1);
	CouponReachStrategyTest.setStartTime("2014/12/9");
	CouponReachStrategyTest.setLastTime(30);
	
	mbs.addDiscountLevelStrategy(DiscountLevelStrategyTest);
	mbs.addCouponReachStrategy(CouponReachStrategyTest);
	
	if(mbs.ShowLevelStrategy()!=null){
		
		System.out.println("ShowLevelStrategy SUCCESS!");
		//by lhw
		ArrayList<LevelStrategyVO> temp = mbs.ShowLevelStrategy();
		for(int i=0;i<temp.size();i++){
			if(temp.get(i)==null)
				System.out.println("null");
			System.out.println(temp.get(i).getID());
		}
	}
	else System.out.println("FAILE!");
	
	if(mbs.ShowBarginStrategy()!=null){
		System.out.println("ShowBarginStrategy SUCCESS!");
		//lhw
		ArrayList<BarginStrategyVO> temp = mbs.ShowBarginStrategy();
		for(int i=0;i<temp.size();i++){
					System.out.println(temp.get(i).getID());
				}//lhw
		//for(int i=0;i<mbs.ShowBarginStrategy().size();i++){
		//	System.out.println(mbs.ShowBarginStrategy().get(i).getID());
		//}
	}
	else System.out.println("FAILE!");
	
	if(mbs.ShowReachStrategy()!=null){
		System.out.println("ShowReachStrategy SUCCESS!");
		for(int i=0;i<mbs.ShowReachStrategy().size();i++){
			System.out.println(mbs.ShowReachStrategy().get(i).getID());
		}
	}
	else System.out.println("FAILE!");
	
	mbs.Remove(new LevelStrategyVO());
	
	mbs.Remove(new BarginStrategyVO());
	
	mbs.Remove(new ReachStrategyVO());
	
	}
}
