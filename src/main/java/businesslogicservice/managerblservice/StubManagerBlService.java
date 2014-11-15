package businesslogicservice.managerblservice;

import java.util.ArrayList;

import vo.BarginStrategyVO;
import vo.BusinessSituationVO;
import vo.LevelStrategyVO;
import vo.ReachStrategyVO;
import vo.VO;
import businesslogic.BillStyle;

public interface StubManagerBlService {
	/*需要查看已提交单据*/
	public ArrayList<VO> getHandedBill ();
	/*修改密码*/
	public boolean modifyPassword (String newpassword);
    /*修改单据信息*/
	public boolean changeImformationOfBill(VO billvo);
	/*通过数组中对应的单据*/
	public boolean PassBill(ArrayList<VO> billvo);
	/*返回所有客户分层策略信息*/
	public ArrayList<VO> ShowLevelStrategy ();
	/*返回所有特价包策略信息*/
	public ArrayList<VO> ShowBarginStrategy ();
	/*返回所有满额促销策略信息*/
	public ArrayList<VO> ShowReachStrategy  ();
	/*需要删除一条客户分层策略*/
	public boolean Remove (LevelStrategyVO ls);
	/*需要删除一条特价包策略*/
	public boolean Remove (BarginStrategyVO bs);
	/*需要删除一条满额促销策略*/
	public boolean Remove (ReachStrategyVO rs);
	/*需要制定一个赠送赠品的客户分层策略*/
	public boolean addGiftLevelStrategy (LevelStrategyVO lsvo);
	/*需要制定一个折让客户分层策略*/
	public boolean addDiscountLevelStrategy (LevelStrategyVO lsvo);
	/*需要制定一个赠送代金券客户分层策略*/
	public boolean addCouponLevelStrategy (LevelStrategyVO lsvo);
	/*需要制定一条特价包促销策略*/
	public boolean addBarginStrategy (BarginStrategyVO bsvo);
	/*需要制定一条赠送赠品的满额促销策略*/
	public boolean addGiftReachStrategy (ReachStrategyVO rsvo);
	/*需要制定一条赠送代金券的满额促销策略*/
	public boolean addCouponReachStrategy (ReachStrategyVO rsvo);
	/*需要查看经营历程*/
	public ArrayList<VO> showBusinessProgress(String client,String operater,String warehouse,BillStyle billStyle, String StartTime,String LastTime);
	/*需要查看销售明细*/
	public ArrayList<VO> showSaleDetail(String client,String operater,String warehouse,String commodity, String StartTime,String LastTime);
	/*需要查看经营情况*/
	public BusinessSituationVO showBusinessSituation (String StartTime,String LastTime);

}
