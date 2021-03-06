package businesslogic.iquirybl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import businesslogic.commoditybillbl.StubAlertBill;
import businesslogic.commoditybillbl.StubGiftBill;
import businesslogic.commoditybillbl.StubSpillsLossBill;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.examinebl.StubBillPool;
import businesslogic.financialbillbl.CashPaymentBill;
import businesslogic.financialbillbl.PaymentBill;
import businesslogic.financialbillbl.ReceiptBill;
import businesslogic.salebillServicec.salebillForFinancial;
import businesslogic.salebillbl.SaleBackSheet;
import businesslogic.salebillbl.PurBackSheet;
import businesslogic.salebillbl.PurSheet;
import businesslogic.salebillbl.SaleSheet;
import businesslogic.salebillbl.salebillController;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogic.stockservice.StockBlForFinancial;
import vo.*;
import vo.financialBillVO.*;
import vo.inquiryVO.*;

public class Inquiry {
	StubBillPool bp = new StubBillPool();
	
	//得到销售明细表中的销售单
	public ArrayList<SaleSheetVO> getSaleSaleSheet(InquirySaleVO isv) {
		ArrayList<SaleSheet> saleSheet = bp.getSaleSheet(BillState.OVER);
		ArrayList<SaleSheetVO> saleSheetVO = new ArrayList<SaleSheetVO>();
		
		
		int size1 = saleSheet.size();
		for(int i=0;i<size1;i++) {		
			SaleSheet sale = saleSheet.get(i);
			//根据条件筛选单据
			//时间区间
			if((isv.getTimeBefore()!=null)&&(isv.getTimeAfter()!=null)) {
				Date dateBefore=null;
				Date dateAfter=null;
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				
				try {
					dateBefore = format.parse(isv.getTimeBefore());
					dateAfter = format.parse(isv.getTimeAfter());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(sale.getDate().compareTo(dateBefore)>=0&&
						sale.getDate().compareTo(dateAfter)<=0){}
				else continue;
			}
			
			//商品名，商品清单包含多个商品
			if(isv.getCommodityName()!=null) {
				ArrayList<MockCommodity> sheet = sale.getsheet();
				int size = sheet.size();
				int j=0,tag=0;//tag表示遍历完以后没有符合的就置为1
				for(;j<size;j++) {//遍历商品清单
					MockCommodity temp = sheet.get(j);
					String comName = temp.getName();
					if(comName.equals(isv.getCommodityName())) {break;}//如果有满足条件的商品，跳出内循环
					if(j==size-1) tag=1;
				}
				if(tag==1) continue;//如果遍历完商品后后没有符合的，换下一个单据
			}
			
			//客户
			if(isv.getCustomer()!=null) {
				String[] temp2 = isv.getCustomer().split(":");
				if(sale.getcustomer().getid().equals(temp2[1])){} 
				else continue;
			}
			
            //业务员
			if(isv.getDeSaler()!=null) {
				if(sale.getcustomer().getdeSaler().equals(isv.getDeSaler())){}
				else continue;				
			}
			saleSheetVO.add(sale.getVO());
		}
		return saleSheetVO;
	}
	
	//销售明细表的销售退货单
	public ArrayList<SaleBackSheetVO> getSaleSaleBackSheet(InquirySaleVO isv) {
		ArrayList<SaleBackSheet> saleBackSheet = bp.getSaleBackSheet(BillState.OVER);
		ArrayList<SaleBackSheetVO> saleBackSheetVO = new ArrayList<SaleBackSheetVO>();
		
		
		int size2 = saleBackSheet.size();
		for(int i=0;i<size2;i++) {
			SaleBackSheet saleback = saleBackSheet.get(i);
			//时间区间
			if((isv.getTimeBefore()!=null)&&(isv.getTimeAfter()!=null)) {
				Date dateBefore=null;
				Date dateAfter=null;
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				
				try {
					dateBefore = format.parse(isv.getTimeBefore());
					dateAfter = format.parse(isv.getTimeAfter());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(saleback.getDate().compareTo(dateBefore)>=0&&
						saleback.getDate().compareTo(dateAfter)<=0){}
				else continue;
			}
			
			
			//商品名，商品清单包含多个商品
			if(isv.getCommodityName()!=null) {
				ArrayList<MockCommodity> sheet = saleback.getsheet();
				int size = sheet.size();
				int j=0,tag=0;//tag表示遍历完以后没有符合的就置为1
				for(;j<size;j++) {//遍历商品清单
					MockCommodity temp = sheet.get(j);
					String comName = temp.getName();
					if(comName.equals(isv.getCommodityName())) {break;}//如果有满足条件的商品，跳出内循环
					if(j==size-1) tag=1;
				}
				if(tag==1) continue;//如果遍历完商品后后没有符合的，换下一个单据
			}
			
			//客户
			if(isv.getCustomer()!=null) {
				String[] temp2 = isv.getCustomer().split(":");
				if(saleback.getcustomer().getid().equals(temp2[1])){} 
				else continue;
			}
			//业务员
			if(isv.getDeSaler()!=null) {
				if(saleback.getcustomer().getdeSaler().equals(isv.getDeSaler())){}
				else continue;				
			}
			saleBackSheetVO.add(saleback.getVO());
		}
		return saleBackSheetVO;
	}
	
	//得到经营历程表的赠送单
	public ArrayList<GiftBillVO> getProcessGift(InquiryProcessVO ipv) {
		ArrayList<StubGiftBill> gift = bp.getGiftBill();
		ArrayList<GiftBillVO> giftVO = new ArrayList<GiftBillVO>();
		
		int size = gift.size();
		
		for(int i=0;i<size;i++) {
			StubGiftBill g = gift.get(i);
			
			if((ipv.getTimeBefore()!=null)&&(ipv.getTimeAfter()!=null)) {
				Date dateBefore=null;
				Date dateAfter=null;
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				
				try {
					dateBefore = format.parse(ipv.getTimeBefore());
					dateAfter = format.parse(ipv.getTimeAfter());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(g.getDate().compareTo(dateBefore)>=0&&
						g.getDate().compareTo(dateAfter)<=0){}
				else continue;
			}
			
			
			giftVO.add(g.getVO());
		}
		return giftVO;
	}
	
	//得到经营历程表的报溢报损单
		public ArrayList<SpillsLossBillVO> getProcessSpillLoss(InquiryProcessVO ipv) {
			ArrayList<StubSpillsLossBill> spillsLoss = bp.getSpillsLossBill();
			ArrayList<SpillsLossBillVO> spillsLossVO = new ArrayList<SpillsLossBillVO>();
			
			int size = spillsLoss.size();
			
			for(int i=0;i<size;i++) {
				StubSpillsLossBill sl = spillsLoss.get(i);
				
				if((ipv.getTimeBefore()!=null)&&(ipv.getTimeAfter()!=null)) {
					Date dateBefore=null;
					Date dateAfter=null;
					SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
					
					try {
						dateBefore = format.parse(ipv.getTimeBefore());
						dateAfter = format.parse(ipv.getTimeAfter());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if(sl.getDate().compareTo(dateBefore)>=0&&
							sl.getDate().compareTo(dateAfter)<=0){}
					else continue;
				}
				
				
				spillsLossVO.add(sl.getVO());
			}
			return spillsLossVO;
		}
		
		//得到经营历程表的报警单
		public ArrayList<AlertBillVO> getProcessAlert(InquiryProcessVO ipv) {
			ArrayList<StubAlertBill> alert  =bp.getAlertBill();	
			ArrayList<AlertBillVO> alertVO = new ArrayList<AlertBillVO>();
			int size = alert.size();
			
			for(int i=0;i<size;i++) {
				StubAlertBill a = alert.get(i);
				
				if((ipv.getTimeBefore()!=null)&&(ipv.getTimeAfter()!=null)) {
					Date dateBefore=null;
					Date dateAfter=null;
					SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
					
					try {
						dateBefore = format.parse(ipv.getTimeBefore());
						dateAfter = format.parse(ipv.getTimeAfter());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if(a.getDate().compareTo(dateBefore)>=0&&
							a.getDate().compareTo(dateAfter)<=0){}
					else continue;
				}
				
				
				alertVO.add(a.getVO());
			}
			return alertVO;
		}
				
	//得到经营历程表的销售单
	public ArrayList<SaleSheetVO> getProcessSaleSheet(InquiryProcessVO ipv) {
		ArrayList<SaleSheet> saleSheet = bp.getSaleSheet();
		ArrayList<SaleSheetVO> saleSheetVO = new ArrayList<SaleSheetVO>();
		
		int size = saleSheet.size();			
		for(int i=0;i<size;i++) {
			SaleSheet sale = saleSheet.get(i);
			
			if((ipv.getTimeBefore()!=null)&&(ipv.getTimeAfter()!=null)) {
				Date dateBefore=null;
				Date dateAfter=null;
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				
				try {
					dateBefore = format.parse(ipv.getTimeBefore());
					dateAfter = format.parse(ipv.getTimeAfter());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(sale.getDate().compareTo(dateBefore)>=0&&
						sale.getDate().compareTo(dateAfter)<=0){}
				else continue;
			}
			
			//客户
			if(ipv.getCustomer()!=null) {
				String[] temp2 = ipv.getCustomer().split(":");
				if(sale.getcustomer().getid().equals(temp2[1])){} 
				else continue;
			}
			
			if(ipv.getDeSaler()!=null) {
				if(sale.getcustomer().getdeSaler().equals(ipv.getDeSaler())){}
				else continue;				
			}
			
			saleSheetVO.add(sale.getVO());
		}
		
		return saleSheetVO;
		
	}
		
		//得到经营历程表的销售退货单
		public ArrayList<SaleBackSheetVO> getProcessSaleBackSheet(InquiryProcessVO ipv) {
			ArrayList<SaleBackSheet> saleBackSheet = bp.getSaleBackSheet();
			ArrayList<SaleBackSheetVO> saleBackSheetVO = new ArrayList<SaleBackSheetVO>();
			
			int size = saleBackSheet.size();			
			for(int i=0;i<size;i++) {
				SaleBackSheet saleBack = saleBackSheet.get(i);
				
				if((ipv.getTimeBefore()!=null)&&(ipv.getTimeAfter()!=null)) {
					Date dateBefore=null;
					Date dateAfter=null;
					SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
					
					try {
						dateBefore = format.parse(ipv.getTimeBefore());
						dateAfter = format.parse(ipv.getTimeAfter());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if(saleBack.getDate().compareTo(dateBefore)>=0&&
							saleBack.getDate().compareTo(dateAfter)<=0){}
					else continue;
				}
				
				//客户
				if(ipv.getCustomer()!=null) {
					String[] temp2 = ipv.getCustomer().split(":");
					if(saleBack.getcustomer().getid().equals(temp2[1])){} 
					else continue;
				}
				
				if(ipv.getDeSaler()!=null) {
					if(saleBack.getcustomer().getdeSaler().equals(ipv.getDeSaler())){}
					else continue;				
				}
				
				saleBackSheetVO.add(saleBack.getVO());
			}
			
			return saleBackSheetVO;
			
		}
		
		//得到经营历程表的进货单
		public ArrayList<PurSheetVO> getProcessPurSheet(InquiryProcessVO ipv) {
			ArrayList<PurSheet> purSheet = bp.getPurSheet();
			ArrayList<PurSheetVO> purSheetVO = new ArrayList<PurSheetVO>();
			
			int size = purSheet.size();	
			for(int i=0;i<size;i++) {
				PurSheet pur = purSheet.get(i);
				
				if((ipv.getTimeBefore()!=null)&&(ipv.getTimeAfter()!=null)) {
					Date dateBefore=null;
					Date dateAfter=null;
					SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
					
					try {
						dateBefore = format.parse(ipv.getTimeBefore());
						dateAfter = format.parse(ipv.getTimeAfter());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if(pur.getDate().compareTo(dateBefore)>=0&&
							pur.getDate().compareTo(dateAfter)<=0){}
					else continue;
				}
				
				//客户
				if(ipv.getCustomer()!=null) {
					String[] temp2 = ipv.getCustomer().split(":");
					if(pur.getcustomer().getid().equals(temp2[1])){} 
					else continue;
				}
				
				
				purSheetVO.add(pur.getVO());
			}
			
			return purSheetVO;
			
		}
		//得到经营历程表的进货退货单
		public ArrayList<PurBackSheetVO> getProcessPurBackSheet(InquiryProcessVO ipv) {
			ArrayList<PurBackSheet> purBackSheet = bp.getPurBackSheet();
			ArrayList<PurBackSheetVO> purBackSheetVO = new ArrayList<PurBackSheetVO>();
			
			int size = purBackSheet.size();			
			for(int i=0;i<size;i++) {
				PurBackSheet purBack = purBackSheet.get(i);
				
				if((ipv.getTimeBefore()!=null)&&(ipv.getTimeAfter()!=null)) {
					Date dateBefore=null;
					Date dateAfter=null;
					SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
					
					try {
						dateBefore = format.parse(ipv.getTimeBefore());
						dateAfter = format.parse(ipv.getTimeAfter());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if(purBack.getDate().compareTo(dateBefore)>=0&&
							purBack.getDate().compareTo(dateAfter)<=0){}
					else continue;
				}
				
				//客户
				if(ipv.getCustomer()!=null) {
					String[] temp2 = ipv.getCustomer().split(":");
					if(purBack.getcustomer().getid().equals(temp2[1])){} 
					else continue;
				}
				
				purBackSheetVO.add(purBack.getVO());
			}
			
			return purBackSheetVO;
			
		}	
	//得到经营历程表的收款单
	public ArrayList<ReceiptVO> getProcessReceipt(InquiryProcessVO ipv) {
		ArrayList<ReceiptBill> receipt = bp.getReceiptBill();
		ArrayList<ReceiptVO> receiptVO = new ArrayList<ReceiptVO>();
		
		int size = receipt.size();
		for(int i=0;i<size;i++) {
			ReceiptBill re = receipt.get(i);
			
			if((ipv.getTimeBefore()!=null)&&(ipv.getTimeAfter()!=null)) {
				Date dateBefore=null;
				Date dateAfter=null;
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				
				try {
					dateBefore = format.parse(ipv.getTimeBefore());
					dateAfter = format.parse(ipv.getTimeAfter());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(re.getDate().compareTo(dateBefore)>=0&&
						re.getDate().compareTo(dateAfter)<=0){}
				else continue;
			}
			
			if(ipv.getCustomer()!=null) {
				
				if(re.getCustomer().equals(ipv.getCustomer())){}
				else continue;
			}
			
			receiptVO.add(re.getVO());
		}
		return receiptVO;
	}
	
	//得到经营历程表的付款单
	public ArrayList<PaymentVO> getProcessPayment(InquiryProcessVO ipv) {
		ArrayList<PaymentBill> payment = bp.getPaymentBill();
		ArrayList<PaymentVO> paymentVO = new ArrayList<PaymentVO>();
			
		int size = payment.size();
		for(int i=0;i<size;i++) {
			PaymentBill pa = payment.get(i);
			
			if((ipv.getTimeBefore()!=null)&&(ipv.getTimeAfter()!=null)) {
				Date dateBefore=null;
				Date dateAfter=null;
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				
				try {
					dateBefore = format.parse(ipv.getTimeBefore());
					dateAfter = format.parse(ipv.getTimeAfter());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(pa.getDate().compareTo(dateBefore)>=0&&
						pa.getDate().compareTo(dateAfter)<=0){}
				else continue;
			}
			
			if(ipv.getCustomer()!=null) {
				if(pa.getCustomer().equals(ipv.getCustomer())){}
				else continue;
			}
			
		
			paymentVO.add(pa.getVO());
		}
		return paymentVO;
	}
	
	//得到经营历程表的现金费用单
		public ArrayList<CashPaymentVO> getProcessCashPayment(InquiryProcessVO ipv) {
			ArrayList<CashPaymentBill> cashPayment = bp.getCashPaymentBill();
			ArrayList<CashPaymentVO> cashPaymentVO = new ArrayList<CashPaymentVO>();
			
			int size = cashPayment.size();
			for(int i=0;i<size;i++) {
				CashPaymentBill ca = cashPayment.get(i);
				
				if((ipv.getTimeBefore()!=null)&&(ipv.getTimeAfter()!=null)) {
					Date dateBefore=null;
					Date dateAfter=null;
					SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
					
					try {
						dateBefore = format.parse(ipv.getTimeBefore());
						dateAfter = format.parse(ipv.getTimeAfter());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if(ca.getDate().compareTo(dateBefore)>=0&&
							ca.getDate().compareTo(dateAfter)<=0){}
					else continue;
				}
				
				
				cashPaymentVO.add(ca.getVO());
			}
			return cashPaymentVO;
		}
	
	
	public BusinessSituationVO inquiryCondition(InquiryConditionVO vo) {
		BusinessSituationVO bsVO = new BusinessSituationVO();
		Date dateBefore=null;
		Date dateAfter=null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			dateBefore = format.parse(vo.getTimeBefore());
			dateAfter = format.parse(vo.getTimeAfter());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		StockBlForFinancial stock = new StubStockController();
		salebillForFinancial sale = new salebillController();
		//商品调价收入
		double adjustmentTotal = stock.getAdjustmentTotal(dateBefore, dateAfter);
		bsVO.setAdjustmentTotal(adjustmentTotal);
		
		//商品报溢收入
		double spillsTotal = stock.getSpillsTotal(dateBefore, dateAfter);
		bsVO.setSpillsTotal(spillsTotal);
		
		//商品赠出
		double giftTotal = stock.getGiftBillTotal(dateBefore, dateAfter);
		bsVO.setGiftTotal(giftTotal);
		
		//商品报损
		double lossTotal = stock.getLossTotal(dateBefore, dateAfter);
		bsVO.setLossTotal(lossTotal);
		
		//代金券与实际收款差额收入
		double bonusTotal = sale.getAllVoucherBonus(dateBefore, dateAfter);
		bsVO.setBonusTotal(bonusTotal);
		
		//销售收入
		double saleTotal = sale.getAllSalesIncome(dateBefore, dateAfter);
		bsVO.setSaleTotal(saleTotal);
		
		//折让
		double discount = sale.getAllSalesDiscount(dateBefore, dateAfter);
		bsVO.setDiscount(discount);
		
		//销售成本
		double cost = sale.getAllPurMoney(dateBefore, dateAfter);
		bsVO.setCost(cost);
		
		//总收入
		double totalEarn =   adjustmentTotal + spillsTotal+bonusTotal+saleTotal;
		bsVO.setTotalEarn(totalEarn);
		//总支出
		double totalPay = giftTotal +cost+lossTotal;
		bsVO.setTotalPay(totalPay);
		//利润
		double profit = totalEarn-totalPay;
		bsVO.setProfit(profit);
		return bsVO;
	}
	
	
}
