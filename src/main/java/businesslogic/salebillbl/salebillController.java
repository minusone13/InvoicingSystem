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
		salebillController(){
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

		public PurSheetVO getPurSheet(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		public PurBackSheetVO getPurBackSheet(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		public SaleSheetVO getSaleSheet(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		public SaleBackSheetVO getSaleBackSheet(String id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		

	
}
