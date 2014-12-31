package businesslogic.salebillbl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po.BillStyle;
import po.LevelStrategyStyle;
import vo.BarginStrategyVO;
import vo.CustomerVO;
import vo.LevelStrategyVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.ReachStrategyVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.stockvo.CommodityVO;
import businesslogic.commoditybillbl.StubGiftBill;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.customerbl.CustomerList;
import businesslogic.examinebl.StubBillPool;
import businesslogic.managerbl.StubManager;
import businesslogic.salebillServicec.salebillForFinancial;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogic.stockservice.StockBlForSalesMen;
import businesslogicservice.customerblservice.CustomerBlService;
import businesslogicservice.managerblservice.StubManagerBlService;
import businesslogicservice.salebillblservice.SaleBillBlService;

public class salebillController implements SaleBillBlService,salebillForFinancial{
		
		// salebillsaversevvice中有getall的方法；
		public salebillController(){
			//System.out.println("salebillController success!");
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

		
		//等等这边有个逻辑上的问题，我怎么得到的是个boolean型...
		public boolean getPurSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<PurSheet> listOfPurSheet= new ArrayList<PurSheet>();
			listOfPurSheet=pool.getPurSheet();
			boolean hasFind = false;
			for(PurSheet pursheet:listOfPurSheet){
				if(pursheet.getid().equals(id)){
					hasFind=true;
					break;
				}
			}
			return hasFind;
		}

		public boolean getPurBackSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<PurBackSheet> listOfPurBackSheet= new ArrayList<PurBackSheet>();
			listOfPurBackSheet=pool.getPurBackSheet();
			boolean hasFind = false;
			for(PurBackSheet purbacksheet:listOfPurBackSheet){
				if(purbacksheet.getid().equals(id)){
					hasFind=true;
					break;
				}
			}
			return hasFind;
		}

		public boolean getSaleSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleSheet> listOfSaleSheet= new ArrayList<SaleSheet>();
			listOfSaleSheet=pool.getSaleSheet();
			boolean hasFind = false;
			for(SaleSheet salesheet:listOfSaleSheet){
				if(salesheet.getid().equals(id)){
					hasFind=true;
					break;
				}
			}
			return hasFind;
		}

		public boolean getSaleBackSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleBackSheet> listOfSaleBackSheet= new ArrayList<SaleBackSheet>();
			listOfSaleBackSheet=pool.getSaleBackSheet();
			boolean hasFind = false;
			for(SaleBackSheet salebacksheet:listOfSaleBackSheet){
				if(salebacksheet.getid().equals(id)){
					hasFind=true;
					break;
				}
			}
			return hasFind;
		}

		/*获取所有的进货单*/
		public ArrayList<PurSheetVO> getAllPurSheet (){
			StubBillPool billPool = new StubBillPool();
			ArrayList<PurSheetVO> result=new ArrayList<PurSheetVO>();
			ArrayList<PurSheet> billList=billPool.getPurSheet();
			for(PurSheet temp: billList){
				result.add(temp.getVO());
			}	
			return result;
		}
		
		/*获取所有的进货退货单*/
		public ArrayList<PurBackSheetVO> getAllPurBackSheet (){
			StubBillPool billPool = new StubBillPool();
			ArrayList<PurBackSheetVO> result=new ArrayList<PurBackSheetVO>();
			ArrayList<PurBackSheet> billList=billPool.getPurBackSheet();
			for(PurBackSheet temp: billList){
				result.add(temp.getVO());
			}	
			return result;
		}
		
		/*获取所有的销售单*/
		public ArrayList<SaleSheetVO> getAllSaleSheet (){
			StubBillPool billPool = new StubBillPool();
			ArrayList<SaleSheetVO> result=new ArrayList<SaleSheetVO>();
			ArrayList<SaleSheet> billList=billPool.getSaleSheet();
			for(SaleSheet temp: billList){
				result.add(temp.getVO());
			}	
			return result;
		}
		
		/*获取所有的销售退货单*/
		public ArrayList<SaleBackSheetVO> getAllSaleBackSheet (){
			StubBillPool billPool = new StubBillPool();
			ArrayList<SaleBackSheetVO> result=new ArrayList<SaleBackSheetVO>();
			ArrayList<SaleBackSheet> billList=billPool.getSaleBackSheet();
			for(SaleBackSheet temp: billList){
				result.add(temp.getVO());
			}	
			return result;
		}
		
		//是不是应该调用库存管理员的方法;
		public void changeState_PurSheet(String ID,BillState state) {
			StubBillPool pool = new StubBillPool();
			CustomerList list = new CustomerList();
			PurSheetVO vo = this.findPurSheet(ID);
			CustomerVO customervo = vo.getcustomer();
			System.out.println(customervo.getid());
			StockBlForSalesMen stockservice = new StubStockController(); 
			
			switch(state){
				case SUBMITED : 
					//那个返回的结果有什么用？
					for(CommodityVO tempvo:vo.getsheet()){
						stockservice.readyForIn(tempvo.getId(), tempvo.getName(), tempvo.getModel(), tempvo.getNumber(), tempvo.getIn());
					}
					break;
				case EXAMINED : 
					for(CommodityVO tempvo:vo.getsheet()){
						stockservice.checkIn(tempvo.getId(),  tempvo.getName(), tempvo.getModel(), tempvo.getNumber(), tempvo.getIn());
					}
					break;
				case OVER     : 
					list.changeShouldPay(customervo.getid(), -vo.getmoney1());
					//list.updateCustomer(customervo);
					break;
			}
			pool.transformState(BillStyle.PurSheet, ID, state);
		}

		public void changeState_PurBackSheet(String ID,BillState state) {
			StubBillPool pool = new StubBillPool();
			CustomerList list = new CustomerList();
			PurBackSheetVO vo = this.findPurBackSheet(ID);
			CustomerVO customervo = vo.getcustomer();
			StockBlForSalesMen stockservice = new StubStockController(); 
			switch(state){
				case SUBMITED : 
					for(CommodityVO tempvo:vo.getsheet()){
						stockservice.readyForOut(tempvo.getId(), tempvo.getName(), tempvo.getModel(), tempvo.getNumber(), tempvo.getOut());
					}
					break;
				case EXAMINED : 
					for(CommodityVO tempvo:vo.getsheet()){
						stockservice.undoCheckOut(tempvo.getId(),  tempvo.getName(), tempvo.getModel(), tempvo.getNumber(), tempvo.getOut());
					}
					break;
				case OVER     : 
					list.changeShouldTake(customervo.getid(), -vo.getmoney1());
					//list.updateCustomer(customervo);
					break;
				
			}
			pool.transformState(BillStyle.PurBackSheet, ID, state);
		}

		public void changeState_Salesheet(String ID,BillState state) {
			StubBillPool pool = new StubBillPool();
			CustomerList list = new CustomerList();
			SaleSheetVO vo = this.findSaleSheet(ID);
			CustomerVO customervo = vo.getcustomer();
			StockBlForSalesMen stockservice = new StubStockController(); 
			switch(state){
				case SUBMITED : 
					for(CommodityVO tempvo:vo.getsheet()){
						stockservice.readyForOut(tempvo.getId(), tempvo.getName(), tempvo.getModel(), tempvo.getNumber(), tempvo.getOut());
					}
					break;
				case EXAMINED : 
					for(CommodityVO tempvo:vo.getsheet()){
						stockservice.checkOut(tempvo.getId(),  tempvo.getName(), tempvo.getModel(), tempvo.getNumber(), tempvo.getOut());
					}
					break;
				case OVER     : 
					list.changeShouldTake(customervo.getid(), -vo.getmoney1());
					//list.updateCustomer(customervo);
					break;
				
			}
			pool.transformState(BillStyle.SaleSheet, ID, state);
		}

		public void changeState_SaleBackSheet(String ID,BillState state) {
			StubBillPool pool = new StubBillPool();
			CustomerList list = new CustomerList();
			SaleBackSheetVO vo = this.findSaleBackSheet(ID);
			CustomerVO customervo = vo.getcustomer();
			StockBlForSalesMen stockservice = new StubStockController(); 
			switch(state){
				case SUBMITED : 
					for(CommodityVO tempvo:vo.getsheet()){
						stockservice.readyForIn(tempvo.getId(), tempvo.getName(), tempvo.getModel(), tempvo.getNumber(), tempvo.getIn());
					}
					break;
				case EXAMINED : 
					for(CommodityVO tempvo:vo.getsheet()){
						stockservice.undoCheckIn(tempvo.getId(),  tempvo.getName(), tempvo.getModel(), tempvo.getNumber(), tempvo.getIn());
					}
					break;
				case OVER     : 
					list.changeShouldPay(customervo.getid(), -vo.getmoney1());
					//list.updateCustomer(customervo);
					break;
				
			}
			pool.transformState(BillStyle.SaleBackSheet, ID, state);
		}

		public void updatePurSheet(PurSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			pool.change(vo);
		}

		public void updatePurBackSheet(PurBackSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			pool.change(vo);
		}

		public void updateSaleSheet(SaleSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			pool.change(vo);
		}

		public void updateSaleBackSheet(SaleBackSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			pool.change(vo);
		}

		public PurSheetVO findPurSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<PurSheet> listOfPurSheet= new ArrayList<PurSheet>();
			listOfPurSheet=pool.getPurSheet();
			PurSheetVO result =null;
			for(PurSheet pursheet:listOfPurSheet){
				if(pursheet==null){
					System.out.println("sheet");
				}
				if(pursheet.getid()==null){
					System.out.println("id");
				}
				if(pursheet.getid().equals(id)){
					result=pursheet.getVO();
					break;
				}
			}
			return result;
		}

		public PurBackSheetVO findPurBackSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<PurBackSheet> listOfPurBackSheet= new ArrayList<PurBackSheet>();
			listOfPurBackSheet=pool.getPurBackSheet();
			PurBackSheetVO result = new PurBackSheetVO();
			for(PurBackSheet purbacksheet:listOfPurBackSheet){
				if(purbacksheet.getid().equals(id)){
					result=purbacksheet.getVO();
					break;
				}
			}
			return result;
		}

		public SaleSheetVO findSaleSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleSheet> listOfSaleSheet= new ArrayList<SaleSheet>();
			listOfSaleSheet=pool.getSaleSheet();
			SaleSheetVO result = new SaleSheetVO();
			for(SaleSheet salesheet:listOfSaleSheet){
				if(salesheet.getid().equals(id)){
					result=salesheet.getVO();
					break;
				}
			}
			return result;
		}

		public SaleBackSheetVO findSaleBackSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleBackSheet> listOfSaleBackSheet= new ArrayList<SaleBackSheet>();
			listOfSaleBackSheet=pool.getSaleBackSheet();
			SaleBackSheetVO result = new SaleBackSheetVO();
			for(SaleBackSheet salebacksheet:listOfSaleBackSheet){
				if(salebacksheet.getid().equals(id)){
					result=salebacksheet.getVO();
					break;
				}
			}
			return result;
		}

		
		//写下面四个函数时，注意要对时间进行判断，而且要筛选单据的状态；
		//
		public int getAllVoucher(Date start, Date end) {
			int number=0;
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleSheet> listOfSaleSheet= new ArrayList<SaleSheet>();
			listOfSaleSheet=pool.getSaleSheet();
			ArrayList<SaleBackSheet> listOfSaleBackSheet= new ArrayList<SaleBackSheet>();
			listOfSaleBackSheet=pool.getSaleBackSheet();
			for(SaleSheet salesheet:listOfSaleSheet){
				number += salesheet.getmoney2();
			}
			for(SaleBackSheet salebacksheet:listOfSaleBackSheet){
				number -= salebacksheet.getmoney2();
			}
			return number;
		}

		public double getAllVoucherBonus(Date start, Date end) {
			double number=0.0;
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleSheet> listOfSaleSheet= new ArrayList<SaleSheet>();
			listOfSaleSheet=pool.getSaleSheet();
			for(SaleSheet salesheet:listOfSaleSheet){
				if(salesheet.getmoney1()<=salesheet.getmoney2()){
					number += (salesheet.getmoney2()-salesheet.getmoney1());
				}
			}
			return number;
		}

		public double getAllSalesIncome(Date start,Date end) {
			double number=0.0;
			StubBillPool pool = new StubBillPool();
			System.out.println("决战2014!");
			ArrayList<SaleSheet> listOfSaleSheet= new ArrayList<SaleSheet>();
			listOfSaleSheet=pool.getSaleSheet();
			ArrayList<SaleBackSheet> listOfSaleBackSheet= new ArrayList<SaleBackSheet>();
			listOfSaleBackSheet=pool.getSaleBackSheet();
			for(SaleSheet salesheet:listOfSaleSheet){
				number += salesheet.getpmoney();
			}
			for(SaleBackSheet salebacksheet:listOfSaleBackSheet){
				number -= salebacksheet.getpmoney();
			}
			return number;
		}

		public double getAllSalesDiscount(Date start,Date end) {
			double number=0.0;
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleSheet> listOfSaleSheet= new ArrayList<SaleSheet>();
			listOfSaleSheet=pool.getSaleSheet();
			ArrayList<SaleBackSheet> listOfSaleBackSheet= new ArrayList<SaleBackSheet>();
			listOfSaleBackSheet=pool.getSaleBackSheet();
			for(SaleSheet salesheet:listOfSaleSheet){
				number += salesheet.getdiscount();
			}
			for(SaleBackSheet salebacksheet:listOfSaleBackSheet){
				number -= salebacksheet.getdiscount();
			}
			return number;
		}

		public double getAllPurMoney(Date start, Date end) {
			double number =0.0;
			StubBillPool pool = new StubBillPool();
			ArrayList<PurSheet> listOfPurSheet =new ArrayList<PurSheet>();
			listOfPurSheet=pool.getPurSheet();
			ArrayList<PurBackSheet> listOfPurBackSheet =new ArrayList<PurBackSheet>();
			listOfPurBackSheet=pool.getPurBackSheet();
			for(PurSheet pursheet:listOfPurSheet){
				number += pursheet.getmoney1();
			}
			for(PurBackSheet purbacksheet:listOfPurBackSheet){
				number -= purbacksheet.getmoney1();
			}
			return number;
		}
		
		public String sureLevelStrategy(int level,int money1,String operatorid,LevelStrategyStyle style){
			String words = new String();
			StubManagerBlService straController = new StubManager();
			ArrayList<LevelStrategyVO> lsvo = straController.ShowLevelStrategy();
			double discount = 0.0;
			double givemoney2 =0.0;
			double currentlimit=0.0;
			ArrayList<CommodityVO> givelist =new ArrayList<CommodityVO>();
			for(LevelStrategyVO tempvo:lsvo){
				if(level==tempvo.getLevel()){
					if(currentlimit<tempvo.getLimit()){
						if(money1>=tempvo.getLimit()){
							currentlimit=tempvo.getLimit();
							//根据传入的类型来决定促销策略;
							switch(style){
								case Gift	 :givelist=tempvo.getAlOfCommodity();
											 StubBillPool pool = new StubBillPool();
										      StubGiftBill giftbill = new StubGiftBill();
										      giftbill.setDate(new Date());
										      ArrayList<MockCommodity> coms = new ArrayList<MockCommodity>();
										      for(CommodityVO temp:givelist){
										    	  coms.add(new MockCommodity(temp));
										      }
										      giftbill.setComs(coms);
										      SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
										      String currentTime = format.format(new Date());
										      ArrayList<StubGiftBill> list=pool.getGiftBill();
										      giftbill.setID("XJFYD-"+currentTime+"-"+String.format("%05d", list.size()+1));
										      giftbill.setRemark(null);
										      giftbill.setOperator(operatorid);
										      pool.add(giftbill); 
										      words="具体赠品请查看赠品单";
										      break;
								case Discount:discount=tempvo.getDiscountrate()*money1;
											  words="折扣金额:"+String.valueOf(discount);
										      break;
								case Coupon  :givemoney2=((int)(Math.floor(money1*tempvo.getCouponrate())/10)*10);
											  words="赠送代金券:"+String.valueOf(givemoney2);
											  break;
								case Default :words="无促销";
											  break;
							}
						}
					}
				}
			}
			return words;
		}
		
		public String sureReachStrategy(String nameOfCustomer,double pmoney,String operatorid,LevelStrategyStyle style){
			String words = new String();
			CustomerBlService custController = new CustomerList();
			CustomerVO customervo = custController.findCustomer(nameOfCustomer);
			StubManagerBlService straController = new StubManager();;
			ArrayList<ReachStrategyVO> rsvo = straController.ShowReachStrategy();
			//满额策略能够提供些什么;
			double currentlimit=0.0;
			int givemoney2=0;
			ArrayList<CommodityVO> givelist =new ArrayList<CommodityVO>();
			for(ReachStrategyVO tempvo:rsvo){
				if(currentlimit<tempvo.getLimit()){
					if(pmoney>=tempvo.getLimit()){
						currentlimit=tempvo.getLimit();
						switch(style){
							case Gift    :givelist=tempvo.getAlOfCommodity();
										  StubBillPool pool = new StubBillPool();
										  StubGiftBill giftbill = new StubGiftBill();
										  giftbill.setDate(new Date());
										  ArrayList<MockCommodity> coms = new ArrayList<MockCommodity>();
										  for(CommodityVO temp:givelist){
											  coms.add(new MockCommodity(temp));
										  }
										  giftbill.setComs(coms);
										  SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
										  String currentTime = format.format(new Date());
										  ArrayList<StubGiftBill> list=pool.getGiftBill();
										  giftbill.setID("XJFYD-"+currentTime+"-"+String.format("%05d", list.size()+1));
										  giftbill.setRemark(null);
										  giftbill.setOperator(operatorid);
										  pool.add(giftbill);
										  words="具体赠品请查看赠品单";
									      break;
							case Coupon  :givemoney2=((int)(Math.floor(pmoney*tempvo.getCouponrate())/10)*10);
										  words="赠送代金券:"+String.valueOf(givemoney2);
										  break;
							case Default :words="无促销";
							  			  break;
						}
					}
				}
			}
			return words;
		}
		
		/*判断传入的a是否属于b*/
		public boolean isBelong(ArrayList<CommodityVO> a,ArrayList<CommodityVO> b){
			boolean hasFound = false;
			for(CommodityVO avo:a){
				for(CommodityVO bvo:b){
					if(avo.equals(bvo)){
						hasFound=true;
					}
				}
				if(!hasFound){
					return false;
				}
				hasFound=false;
			}
			return true;
		}

		public ArrayList<BarginStrategyVO> getSomeBarginStrategy(SaleSheetVO vo){
			ArrayList<BarginStrategyVO> result = new ArrayList<BarginStrategyVO>();
			StubManagerBlService straController = new StubManager();
			ArrayList<BarginStrategyVO> bsvo = straController.ShowBarginStrategy();//读取的所有策略;
			for(BarginStrategyVO tempvo:bsvo){
				if(this.isBelong(tempvo.getAlOfCommodity(), vo.getsheet())){
					result.add(tempvo);
				}
			}
			return result;
		}

		
		
		public ArrayList<ReachStrategyVO> getSomeReachStrategy(SaleSheetVO vo)
		{
			ArrayList<ReachStrategyVO> result = new ArrayList<ReachStrategyVO>();
			StubManagerBlService straController = new StubManager();
			ArrayList<ReachStrategyVO> rsvo = straController.ShowReachStrategy();//读取的所有策略;
			for(ReachStrategyVO tempvo:rsvo){
				if(tempvo.getLimit()<=vo.getmoney1()){
					//判断实践我暂时还没处理，先凑合一下;
					result.add(tempvo);
				}
			}
			return result;
		}

		public ArrayList<LevelStrategyVO> getSomeLevelStrategy(SaleSheetVO vo)
		{
			ArrayList<LevelStrategyVO> result = new ArrayList<LevelStrategyVO>();
			StubManagerBlService straController = new StubManager();
			ArrayList<LevelStrategyVO> lsvo = straController.ShowLevelStrategy();//读取的所有策略;
			for(LevelStrategyVO tempvo:lsvo){
				if(tempvo.getLevel_strategy_style()==LevelStrategyStyle.Gift){
					if(tempvo.getLimit()<=vo.getmoney1()&&(tempvo.getLevel()==vo.getcustomer().getlevel())){
					//判断实践我暂时还没处理，先凑合一下;
					result.add(tempvo);
					}
				}else{
					if(tempvo.getLevel()==vo.getcustomer().getlevel()){
						result.add(tempvo);
					}
				}
			}
			return result;
		}

		public SaleSheetVO getCompletedSaleSheet(SaleSheetVO salesheetvo,LevelStrategyVO lsvo)
		{
			switch(lsvo.getLevel_strategy_style()){
				case Gift:
					salesheetvo.setdiscount(0.0);
					salesheetvo.setpmoney(salesheetvo.getmoney1()-salesheetvo.getmoney2()-salesheetvo.getdiscount());
					ArrayList<CommodityVO> givelist =new ArrayList<CommodityVO>();
					givelist=lsvo.getAlOfCommodity();
					  StubBillPool pool = new StubBillPool();
					  StubGiftBill giftbill = new StubGiftBill();
					  giftbill.setDate(new Date());
					  ArrayList<MockCommodity> coms = new ArrayList<MockCommodity>();
					  for(CommodityVO temp:givelist){
						  coms.add(new MockCommodity(temp));
					  }
					  giftbill.setComs(coms);
					  SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
					  String currentTime = format.format(new Date());
					  ArrayList<StubGiftBill> list=pool.getGiftBill();
					  giftbill.setID("XJFYD-"+currentTime+"-"+String.format("%05d", list.size()+1));
					  giftbill.setRemark(null);
					  giftbill.setOperator(salesheetvo.getop());
					  pool.add(giftbill);
					salesheetvo.setwords("赠品单编号："+giftbill.getID());
					break;
				case Discount:
					salesheetvo.setdiscount((salesheetvo.getmoney1()-salesheetvo.getmoney2())*(1-lsvo.getDiscountrate()));
					salesheetvo.setpmoney(salesheetvo.getmoney1()-salesheetvo.getmoney2()-salesheetvo.getdiscount());
					salesheetvo.setwords("wu");
					break;
				case Coupon:
					salesheetvo.setdiscount(0.0);
					salesheetvo.setpmoney(salesheetvo.getmoney1()-salesheetvo.getmoney2()-salesheetvo.getdiscount());
					salesheetvo.setwords("赠送代金券:"+String.valueOf(salesheetvo.getpmoney()*lsvo.getCouponrate()-salesheetvo.getpmoney()*lsvo.getCouponrate()%10));
					//System.out.println(salesheetvo.getpmoney()*lsvo.getCouponrate());
					//System.out.println(salesheetvo.getpmoney()*lsvo.getCouponrate()%10);
					break;
			}
		
			return salesheetvo;
		}
		
		public SaleSheetVO getCompletedSaleSheet(SaleSheetVO salesheetvo,BarginStrategyVO bsvo){
			//允许有几个特价包？
			//按照我的理解特价包应该是优先级最高的优惠;
			salesheetvo.setmoney1(salesheetvo.getmoney1()-bsvo.getDiscount());
			salesheetvo.setwords("商品中存在特价包");
			return salesheetvo;
		}

		public SaleSheetVO getCompletedSaleSheet(SaleSheetVO salesheetvo,ReachStrategyVO rsvo)
		{
			switch(rsvo.getReach_strategy_style()){
				case Gift  :
					salesheetvo.setdiscount(0.0);
					salesheetvo.setpmoney(salesheetvo.getmoney1()-salesheetvo.getmoney2()-salesheetvo.getdiscount());
					ArrayList<CommodityVO> givelist =new ArrayList<CommodityVO>();
					givelist=rsvo.getAlOfCommodity();
					  StubBillPool pool = new StubBillPool();
					  StubGiftBill giftbill = new StubGiftBill();
					  giftbill.setDate(new Date());
					  ArrayList<MockCommodity> coms = new ArrayList<MockCommodity>();
					  for(CommodityVO temp:givelist){
						  coms.add(new MockCommodity(temp));
					  }
					 giftbill.setComs(coms);
					 SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
					 String currentTime = format.format(new Date());
					 ArrayList<StubGiftBill> list=pool.getGiftBill();
					 giftbill.setID("XJFYD-"+currentTime+"-"+String.format("%05d", list.size()+1));
					 String[] remark = new String[2];
					 remark[0]=salesheetvo.getid();
					 remark[1]=salesheetvo.getcustomer().getname();
					 giftbill.setRemark(remark);
					 giftbill.setOperator(salesheetvo.getop());
					 pool.add(giftbill);
					 salesheetvo.setwords("赠品单编号："+giftbill.getID());
					break;
				case Coupon:
					salesheetvo.setdiscount(0.0);
					salesheetvo.setpmoney(salesheetvo.getmoney1()-salesheetvo.getmoney2()-salesheetvo.getdiscount());
					salesheetvo.setwords("赠送代金券:"+String.valueOf(salesheetvo.getpmoney()*rsvo.getCouponrate()-salesheetvo.getpmoney()*rsvo.getCouponrate()%10));
					break;
				
			}
			salesheetvo.setdiscount(0.0);
			salesheetvo.setpmoney(salesheetvo.getmoney1()-salesheetvo.getmoney2()-salesheetvo.getdiscount());
			salesheetvo.setwords("赠送代金券:"+String.valueOf(salesheetvo.getpmoney()*rsvo.getCouponrate()-salesheetvo.getpmoney()*rsvo.getCouponrate()%10));
			return salesheetvo;
		}
}
