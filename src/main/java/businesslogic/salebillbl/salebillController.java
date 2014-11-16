package businesslogic.salebillbl;

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
		
		

	
}
