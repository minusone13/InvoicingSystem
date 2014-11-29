package businesslogic.iquirybl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.commoditybillbl.StubAlertBill;
import businesslogic.commoditybillbl.StubGiftBill;
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
			StubSaleBackSheet saleback = saleBackSheet.get(i);
			list.add(saleback.getVO());
		}
		return list;
	}
	
	public ArrayList<VO> inquiryProcess(InquiryProcessVO ipv) {
		ArrayList<VO> list = new ArrayList<VO>();
		ArrayList<StubGiftBill> gift = bp.getGiftBill();
		ArrayList<StubSaleSheet> saleSheet = bp.getSaleSheet();
		ArrayList<StubSaleBackSheet> saleBackSheet = bp.getSaleBackSheet();
		ArrayList<StubSpillsLossBill> spillsLoss = bp.getSpillsLossBill();
		ArrayList<StubAlertBill> alert  =bp.getAlertBill();
		ArrayList<StubPurSheet> purSheet = bp.getPurSheet();
		ArrayList<StubPurBackSheet> purBackSheet = bp.getPurBackSheet();
		ArrayList<ReceiptBill> receipt = bp.getReceiptBill();
		ArrayList<PaymentBill> payment = bp.getPaymentBill();
		ArrayList<CashPaymentBill> cashPayment =bp.getCashPaymentBill();
		Date dateBefore=null;
		Date dateAfter=null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			dateBefore = format.parse(ipv.getTimeBefore());
			dateAfter = format.parse(ipv.getTimeAfter());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int size0 = gift.size();
		for(int i=0;i<size0;i++) {
			StubGiftBill g = gift.get(i);
			
			if(dateBefore!=null) {
				if(g.getDate().compareTo(dateBefore)>=0&&
						g.getDate().compareTo(dateAfter)<=0){}
				else continue;
			}
			
			if(ipv.getBillstyle()!=null) {
				if(g.getBillstyle().equals(ipv.getBillstyle())){}
				else continue;
			}
			
			
		}
		//销售单===============================
		int size1 = saleSheet.size();
		for(int i=0;i<size1;i++) {
			StubSaleSheet sale = saleSheet.get(i);
			
			if(dateBefore!=null) {
				if(sale.getDate().compareTo(dateBefore)>=0&&
						sale.getDate().compareTo(dateAfter)<=0){}
				else continue;
			}
			
			if(ipv.getBillstyle()!=null) {
				if(sale.getBillstyle() == ipv.getBillstyle()){}
				else continue;
			}
			list.add(sale.getVO());
		}
		
		//销售退货单===================================
		int size2 = saleBackSheet.size();
		for(int i=0;i<size2;i++) {
			StubSaleBackSheet saleback = saleBackSheet.get(i);
			
			if(dateBefore!=null) {
				if(saleback.getDate().compareTo(dateBefore)>=0&&
						saleback.getDate().compareTo(dateAfter)<=0){}
				else continue;
			}
			
			if(ipv.getBillstyle()!=null) {
				if(saleback.getBillstyle() == ipv.getBillstyle()){}
				else continue;
			}
			list.add(saleback.getVO());
		}
		
		//报溢报损=========================================
		int size3 = spillsLoss.size();
		for(int i=0;i<size3;i++) {
			StubSpillsLossBill spillLossBill = spillsLoss.get(i);
			
			if(dateBefore!=null) {
				if(spillLossBill.getDate().compareTo(dateBefore)>=0&&
						spillLossBill.getDate().compareTo(dateAfter)<=0){}
				else continue;
			}
			
			if(ipv.getBillstyle()!=null) {
				if(spillLossBill.getBillstyle() == ipv.getBillstyle()){}
				else continue;
			}
			
			list.add(spillLossBill.getVO());
		}
		
		//报警单==========================================
		int size4 = alert.size();
		for(int i=0;i<size4;i++) {
			StubAlertBill alertBill = alert.get(i);
			
			if(dateBefore!=null) {
				if(alertBill.getDate().compareTo(dateBefore)>=0&&
						alertBill.getDate().compareTo(dateAfter)<=0){}
				else continue;
			}
			
			if(ipv.getBillstyle()!=null) {
				if(alertBill.getBillstyle() == ipv.getBillstyle()){}
				else continue;
			}
			list.add(alertBill.getVO());
		}
		
		//进货单
		int size5 = purSheet.size();
		for(int i=0;i<size5;i++) {
			StubPurSheet pur = purSheet.get(i);
			
			if(dateBefore!=null) {
				if(pur.getDate().compareTo(dateBefore)>=0&&
						pur.getDate().compareTo(dateAfter)<=0){}
				else continue;
			}
			
			if(ipv.getBillstyle()!=null) {
				if(pur.getBillstyle()== ipv.getBillstyle()){}
				else continue;
			}
			
			list.add(pur.getVO());
		}
		
		//进货退货单
		int size6 = purBackSheet.size();
		for(int i=0;i<size6;i++) {
			StubPurBackSheet back = purBackSheet.get(i);
			
			if(dateBefore!=null) {
				if(back.getDate().compareTo(dateBefore)>=0&&
						back.getDate().compareTo(dateAfter)<=0){}
				else continue;
			}
			
			if(ipv.getBillstyle()!=null) {
				if(back.getBillstyle() == ipv.getBillstyle()){}
				else continue;
			}
			list.add(back.getVO());
		}
		
		//收款单screen======================================
		int size7 = receipt.size();
		for(int i=0;i<size7;i++) {
			ReceiptBill re = receipt.get(i);
			
			if(dateBefore!=null) {
				if(re.getDate().compareTo(dateBefore)>=0&&
						re.getDate().compareTo(dateAfter)<=0){}
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
			if(dateBefore!=null) {
				if(pa.getDate().compareTo(dateBefore)>=0&&
						pa.getDate().compareTo(dateAfter)<=0){}
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
			
			if(dateBefore!=null) {
				if(ca.getDate().compareTo(dateBefore)>=0&&
						ca.getDate().compareTo(dateAfter)<=0){}
				else continue;
			}
			
			if(ipv.getBillstyle()!=null) {

				if(ca.getBillstyle() == ipv.getBillstyle()){}
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
