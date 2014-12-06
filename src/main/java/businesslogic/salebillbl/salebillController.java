package businesslogic.salebillbl;

import java.util.ArrayList;

import vo.CustomerVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import businesslogic.examinebl.StubBillPool;
import businesslogicservice.salebillblservice.SaleBillBlService;

public class salebillController implements SaleBillBlService{
		salebillList salebilllist;
		
		// salebillsaversevvice中有getall的方法；
		public salebillController(){
			System.out.println("salebillController success!");
		}

		public boolean createPurSheet(PurSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			if(vo==null) return false;
			PurSheet pursheet = new PurSheet(vo);
			pool.add(pursheet);
			return true;
		}

		public boolean createPurBackSheet(PurBackSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			if(vo==null) return false;
			PurBackSheet purbacksheet = new PurBackSheet(vo);
			pool.add(purbacksheet);
			return true;
		}

		public boolean createSaleSheet(SaleSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			if(vo==null) return false;
			SaleSheet salesheet = new SaleSheet(vo);
			pool.add(salesheet);
			return true;
		}

		public boolean createSaleBackSheet(SaleBackSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			if(vo==null) return false;
			SaleBackSheet salebacksheet = new SaleBackSheet(vo);
			pool.add(salebacksheet);
			return true;
		}

		public boolean getPurSheet(String id) {
			// TODO Auto-generated method stub
			if(id=="131")
				return true;
			else
				return false;
		}

		public boolean getPurBackSheet(String id) {
			// TODO Auto-generated method stub
			if(id=="131")
				return true;
			else
				return false;
		}

		public boolean getSaleSheet(String id) {
			// TODO Auto-generated method stub
			if(id=="131")
				return true;
			else
				return false;
		}

		public boolean getSaleBackSheet(String id) {
			// TODO Auto-generated method stub
			if(id=="131")
				return true;
			else
				return false;
		}

		
		
		public boolean changeState_PurSheet() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean changeState_PurBackSheet() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean changeState_Salesheet() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean changeState_SaleBackSheet() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean updatePurSheet() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean updatePurBackSheet() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean updateSaleSheet() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean updateSaleBackSheet() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean deletePurSheet() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean deletePurBackSheet() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean deleteSaleSheet() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean deleteSaleBackSheet() {
			// TODO Auto-generated method stub
			return false;
		}

		public ArrayList<PurSheetVO> getAllPurSheet() {
			// TODO Auto-generated method stub
			return null;
		}

		public ArrayList<PurBackSheetVO> getAllPurBackSheet() {
			// TODO Auto-generated method stub
			return null;
		}

		public ArrayList<SaleSheetVO> getAllSaleSheet() {
			// TODO Auto-generated method stub
			return null;
		}

		public ArrayList<SaleBackSheetVO> getAllSaleBackSheet() {
			// TODO Auto-generated method stub
			return null;
		}

		public PurSheetVO findPurSheet(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		public PurBackSheetVO findPurBackSheet(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		public SaleSheetVO findSaleSheet(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		public SaleBackSheetVO findSaleBackSheet(String id) {
			// TODO Auto-generated method stub
			return null;
		}
	
}
