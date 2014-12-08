package businesslogicservice.salebillblservice;

import java.util.ArrayList;
import java.util.Date;

import vo.CustomerVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
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
		
		/*public boolean changeState_PurSheet();
		public boolean changeState_PurBackSheet();
		public boolean changeState_Salesheet();
		public boolean changeState_SaleBackSheet();*/
		
		//更新的具体实现我还没有想好；
		public boolean updatePurSheet();
		public boolean updatePurBackSheet();
		public boolean updateSaleSheet();
		public boolean updateSaleBackSheet();
		
		//删除的实现我也没有想好；
		public boolean deletePurSheet();
		public boolean deletePurBackSheet();
		public boolean deleteSaleSheet();
		public boolean deleteSaleBackSheet();
		
		public ArrayList<PurSheetVO> getAllPurSheet();
		public ArrayList<PurBackSheetVO> getAllPurBackSheet();
		public ArrayList<SaleSheetVO> getAllSaleSheet();
		public ArrayList<SaleBackSheetVO> getAllSaleBackSheet();
		
		public PurSheetVO findPurSheet(String id);
		public PurBackSheetVO findPurBackSheet(String id);
		public SaleSheetVO findSaleSheet(String id);
		public SaleBackSheetVO findSaleBackSheet(String id);
		
		public int getAllVoucher(Date start,Date end);//计算一段时间内发放了多少代金券；
		public double getAllVoucherBonus(Date start,Date end);//计算一段时间内实际收款差额；
		
		
}
