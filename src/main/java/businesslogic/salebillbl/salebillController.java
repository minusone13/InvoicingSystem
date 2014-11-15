package businesslogic.salebillbl;

import businesslogicservice.saleblservice.StubSaleBlService;

public class salebillController implements StubSaleBlService{
		salebillList salebilllist;
		
		salebillController(){
			System.out.println("salebillController success!");
		}
}
