package businesslogic.iquirybl;

import java.util.ArrayList;

import businesslogic.BillState;
import businesslogic.commoditybillbl.StubAlertBill;
import businesslogic.commoditybillbl.StubSpillsLossBill;
import businesslogic.examinebl.StubBillPool;
import businesslogic.financialbillbl.StubCashPaymentBill;
import businesslogic.financialbillbl.StubPaymentBill;
import businesslogic.financialbillbl.StubReceiptBill;
import businesslogic.salebillbl.StubPurBackSheet;
import businesslogic.salebillbl.StubPurSheet;
import businesslogic.salebillbl.StubSaleBackSheet;
import businesslogic.salebillbl.StubSaleSheet;
import vo.*;

public class StubInquiry {
	StubBillPool bp = new StubBillPool();
	public ArrayList<VO> inquirySale(InquirySaleVO isv) {
		ArrayList<VO> list = new ArrayList<VO>();
		ArrayList<StubSaleSheet> saleSheet = bp.getSaleSheet();
		ArrayList<StubSaleBackSheet> saleBackSheet = bp.getSaleBackSheet();
		int size1 = saleSheet.size();
		for(int i=0;i<size1;i++) {		
			StubSaleSheet sale = saleSheet.get(i);
			
			if(isv.getTimeBefore()!=null) {
				
			
				//if(sale.date.compareTo(isv.getTimeBefore())>=0&&
				//	sale.date.compareTo(isv.getTimeAfter())<=0)
					//list.add(saleSheet.get(i).getVO());
					//else continue;
				//}
			}
			if(isv.getCommodityName()!=null) {
				//if(sale.(isv.getCommodityName())){}
				//else continue;
			}
			if(isv.getCustomer()!=null) {
				if(sale.getCustomer().name.equals(isv.getCustomer())){} 
				else continue;
			}
		}
		int size2 = saleBackSheet.size();
		for(int i=0;i<size2;i++) {
			list.add(saleBackSheet.get(i).getVO());
		}
		return list;
	}
	
	public ArrayList<VO> inquiryProcess(InquiryProcessVO ipv) {
		ArrayList<VO> list = new ArrayList<VO>();
		ArrayList<StubSaleSheet> saleSheet = bp.getSaleSheet();
		ArrayList<StubSaleBackSheet> saleBackSheet = bp.getSaleBackSheet();
		ArrayList<StubSpillsLossBill> spillsLoss = bp.getSpillsLossBill();
		ArrayList<StubAlertBill> alert  =bp.getAlertBill();
		ArrayList<StubPurSheet> purSheet = bp.getPurSheet();
		ArrayList<StubPurBackSheet> purBackSheet = bp.getPurBackSheet();
		ArrayList<StubReceiptBill> receipt = bp.getReceiptBill();
		ArrayList<StubPaymentBill> payment = bp.getPaymentBill();
		ArrayList<StubCashPaymentBill> cashPayment =bp.getCashPaymentBill();
		
		int size1 = saleSheet.size();
		for(int i=0;i<size1;i++) {
			list.add(saleSheet.get(i).getVO());
		}
		int size2 = saleBackSheet.size();
		for(int i=0;i<size2;i++) {
			list.add(saleBackSheet.get(i).getVO());
		}
		int size3 = spillsLoss.size();
		for(int i=0;i<size3;i++) {
			list.add(spillsLoss.get(i).getVO());
		}
		int size4 = alert.size();
		for(int i=0;i<size4;i++) {
			list.add(alert.get(i).getVO());
		}
		int size5 = purSheet.size();
		for(int i=0;i<size5;i++) {
			list.add(purSheet.get(i).getVO());
		}
		int size6 = purBackSheet.size();
		for(int i=0;i<size6;i++) {
			list.add(purBackSheet.get(i).getVO());
		}
		int size7 = receipt.size();
		for(int i=0;i<size7;i++) {
			list.add(receipt.get(i).getVO());
		}
		int size8 = payment.size();
		for(int i=0;i<size8;i++) {
			list.add(payment.get(i).getVO());
		}
		int size9 = cashPayment.size();
		for(int i=0;i<size9;i++) {
			list.add(cashPayment.get(i).getVO());
		}
		return list;
	}
	
	
	public BusinessSituationVO inquiryCondition(String time, String type) {
		return null;
	}
	
	
}
