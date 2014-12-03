package businesslogic.salebillbl;

import java.util.ArrayList;

import vo.CustomerVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import businesslogicservice.salebillblservice.StubSaleBillBlService;

public class salebillController implements StubSaleBillBlService{
		salebillList salebilllist;
		
		// salebillsaversevvice中有getall的方法；
		public salebillController(){
			System.out.println("salebillController success!");
		}

		public void createPurSheet() {
			// TODO Auto-generated method stub
			
		}

		public void createPurBackSheet() {
			// TODO Auto-generated method stub
			
		}

		public void createSaleSheet() {
			// TODO Auto-generated method stub
			
		}

		public void createSaleBackSheet() {
			// TODO Auto-generated method stub
			
		}

		public void changeState() {
			// TODO Auto-generated method stub
			
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
