package businesslogic.iquirybl;

import java.util.ArrayList;

import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.commoditybillbl.StubAlertBill;
import businesslogic.commoditybillbl.StubSpillsLossBill;
import businesslogic.examinebl.Bill;
import businesslogic.examinebl.StubBillPool;
import businesslogic.financialbillbl.CashPaymentBill;
import businesslogic.financialbillbl.PaymentBill;
import businesslogic.financialbillbl.ReceiptBill;
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
			//根据条件筛选单据
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
			if(isv.getOperator()!=null) {
				//if()
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
		ArrayList<ReceiptBill> receipt = bp.getReceiptBill();
		ArrayList<PaymentBill> payment = bp.getPaymentBill();
		ArrayList<CashPaymentBill> cashPayment =bp.getCashPaymentBill();
		
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
		
		//收款单screen======================================
		int size7 = receipt.size();
		for(int i=0;i<size7;i++) {
			ReceiptBill re = receipt.get(i);
			if(ipv.getTimeBefore()!=null) {
				
				if(re.getDate().compareTo(ipv.getTimeBefore())>=0&&
					re.getDate().compareTo(ipv.getTimeAfter())<=0){}
				else continue;
			}
			
			if(ipv.getBillstyle()!=null) {
				if(re.getBillstyle() == ipv.getBillstyle()){}
				else continue;
			}
			
			if(ipv.getCustomer()!=null) {
				if(re.getCustomer().equals(ipv.getCustomer())){}
				else continue;
			}
			
			if(ipv.getOperator()!=null) {
				if(re.getOperator().equals(ipv.getOperator())){}
				else continue;
			}
			
			list.add(re.getVO());
		}
		
		//付款单screen===================================
		int size8 = payment.size();
		for(int i=0;i<size8;i++) {
			PaymentBill pa = payment.get(i);
			if(ipv.getTimeBefore()!=null) {
				
				if(pa.getDate().compareTo(ipv.getTimeBefore())>=0&&
					pa.getDate().compareTo(ipv.getTimeAfter())<=0){}
				else continue;
			}
			
			if(ipv.getBillstyle()!=null) {
				if(pa.getBillStyle() == ipv.getBillstyle()){}
				else continue;
			}
			
			if(ipv.getCustomer()!=null) {
				if(pa.getCustomer().equals(ipv.getCustomer())){}
				else continue;
			}
			
			if(ipv.getOperator()!=null) {
				if(pa.getOperator().equals(ipv.getOperator())){}
				else continue;
			}
			list.add(pa.getVO());
		}
		
		//现金费用单==========================================
		int size9 = cashPayment.size();
		for(int i=0;i<size9;i++) {
			CashPaymentBill ca = cashPayment.get(i);
			
			if(ipv.getTimeBefore()!=null) {			
				if(ca.getDate().compareTo(ipv.getTimeBefore())>=0&&
					ca.getDate().compareTo(ipv.getTimeAfter())<=0){}
				else continue;
			}
			
			if(ipv.getBillstyle()!=null) {
				if(ca.getBillStyle() == ipv.getBillstyle()){}
				else continue;
			}
			
			if(ipv.getOperator()!=null) {
				if(ca.getOperator().equals(ipv.getOperator())){}
				else continue;
			}
			list.add(ca.getVO());
		}
		return list;
	}
	
	
	public BusinessSituationVO inquiryCondition(String time, String type) {
		return null;
	}
	
	
}
