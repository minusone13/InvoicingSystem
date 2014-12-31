package businesslogicservice.salebillblservice;

import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import vo.BarginStrategyVO;
import vo.CustomerVO;
import vo.LevelStrategyVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.ReachStrategyVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;

public interface SaleBillBlService {
		/*
		 *这个接口包含了进货销售人员的任务
		 *分别是进货和销售单据的增删改查
		 * */
	
		/*
		 *客户管理部分交给了Customer部分；
		 * */
	
		/*
		 * 这个类里面只有对单据的操作；
		 * */
		public boolean createPurSheet(PurSheetVO vo);
		public boolean createPurBackSheet(PurBackSheetVO vo);
		public boolean createSaleSheet(SaleSheetVO vo);
		public boolean createSaleBackSheet(SaleBackSheetVO vo);
		
		public boolean getPurSheet(String id);
		public boolean getPurBackSheet(String id);
		public boolean getSaleSheet(String id);
		public boolean getSaleBackSheet(String id);
		
		public void changeState_PurSheet(String ID,BillState state);
		public void changeState_PurBackSheet(String ID,BillState state);
		public void changeState_Salesheet(String ID,BillState state);
		public void changeState_SaleBackSheet(String ID,BillState state);
		
		//更新的具体实现我还没有想好；
		public void updatePurSheet(PurSheetVO vo);
		public void updatePurBackSheet(PurBackSheetVO vo);
		public void updateSaleSheet(SaleSheetVO vo);
		public void updateSaleBackSheet(SaleBackSheetVO vo);
		
		public PurSheetVO findPurSheet(String id);
		public PurBackSheetVO findPurBackSheet(String id);
		public SaleSheetVO findSaleSheet(String id);
		public SaleBackSheetVO findSaleBackSheet(String id);
		
		//删除的实现我也没有想好；
		/*public boolean deletePurSheet();
		public boolean deletePurBackSheet();
		public boolean deleteSaleSheet();
		public boolean deleteSaleBackSheet();*/
		
		public ArrayList<PurSheetVO> getAllPurSheet();
		public ArrayList<PurBackSheetVO> getAllPurBackSheet();
		public ArrayList<SaleSheetVO> getAllSaleSheet();
		public ArrayList<SaleBackSheetVO> getAllSaleBackSheet();
		
		public ArrayList<ReachStrategyVO> getSomeReachStrategy(SaleSheetVO vo);
		public ArrayList<LevelStrategyVO> getSomeLevelStrategy(SaleSheetVO vo);
		public ArrayList<BarginStrategyVO> getSomeBarginStrategy(SaleSheetVO vo);
		public SaleSheetVO getCompletedSaleSheet(SaleSheetVO salesheetvo,LevelStrategyVO lsvo);
		public SaleSheetVO getCompletedSaleSheet(SaleSheetVO salesheetvo,ReachStrategyVO rsvo);
		public SaleSheetVO getCompletedSaleSheet(SaleSheetVO salesheetvo,BarginStrategyVO bsvo);
		
}
