package presentation.managerui;

import java.util.ArrayList;

import vo.BarginStrategyVO;
import vo.LevelStrategyVO;
import vo.PaymentVO;
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
	 
	//初始化一个假的单据vo
	VO tempVO=new PaymentVO();
	mbs.changeImformationOfBill(tempVO);
	
	mbs.PassBill(new ArrayList<VO>());
	
	
	if(mbs.ShowLevelStrategy()!=null)System.out.println("ShowLevelStrategy SUCCESS!");
	else System.out.println("FAILE!");
	
	if(mbs.ShowBarginStrategy()!=null)System.out.println("ShowBarginStrategy SUCCESS!");
	else System.out.println("FAILE!");
	
	if(mbs.ShowReachStrategy()!=null)System.out.println("ShowReachStrategy SUCCESS!");
	else System.out.println("FAILE!");
	
	mbs.Remove(new LevelStrategyVO());
	
	mbs.Remove(new BarginStrategyVO());
	
	mbs.Remove(new ReachStrategyVO());
	
	mbs.addGiftLevelStrategy(new LevelStrategyVO());
	
	mbs.addDiscountLevelStrategy(new LevelStrategyVO());
	
	mbs.addCouponLevelStrategy(new LevelStrategyVO());
	
	mbs.addBarginStrategy(new BarginStrategyVO());
	
	mbs.addGiftReachStrategy(new ReachStrategyVO());
	
	mbs.addCouponReachStrategy(new ReachStrategyVO());
	
	if(mbs.showBusinessProgress("#clientnum","operaternum","warehousenum",null,"2014/6/4","2014/7/5")!=null)System.out.println("showBusinessProgress SUCCESS!");
	else System.out.println("FAILE!");
	
	if(mbs.showSaleDetail("#clientnum","#operaternum","#warehousenum","#commoditynum","2014/6/4","2014/7/5")!=null)System.out.println("showSaleDetail SUCCESS!");
	else System.out.println("FAILE!");
	
	if(mbs.showBusinessSituation("2014/6/4","2014/7/5")!=null)System.out.println("showBusinessSituation SUCCESS!");
	else System.out.println("FAILE!");
	
	}
}
