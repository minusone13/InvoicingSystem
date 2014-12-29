package presentation.managerui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JPanel;

import po.BillState;
import po.BillStyle;
import po.RM;
import po.Role;
import presentation.commodityui.StockManagerDriver;
import presentation.commodityui.WarningText;
import presentation.managerui.JPBill.JPbillType;
import vo.AlertBillVO;
import vo.BarginStrategyVO;
import vo.CustomerVO;
import vo.GiftBillVO;
import vo.LevelStrategyVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.ReachStrategyVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.SpillsLossBillVO;
import vo.accountVO.AccountVO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import vo.uservo.UserVO;
import businesslogic.customerbl.CustomerList;
import businesslogic.financialbl.Financial;
import businesslogic.managerbl.StubManager;
import businesslogic.salebillbl.salebillController;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogic.userbl.UserController;
import businesslogicservice.commodityblservice.StubCommodityBlService;
import businesslogicservice.customerblservice.CustomerBlService;
import businesslogicservice.financialblservice.FinancialBlService;
import businesslogicservice.managerblservice.StubManagerBlService;
import businesslogicservice.salebillblservice.SaleBillBlService;
import businesslogicservice.userblservice.StubUserBlService;
import data.commoditydata.StubStockDataController;
import dataservice.commoditydataservice.StubCommodityDataService;
import entrance.Frame;

public class JPBillList extends JPanel {

	//板块的长度，单位个（单据）
	private int length=0;
	//控制移动
	private boolean stop=true;

	//板块移动的纵坐标
	private int y=0;
	//单据面板数组
	private ArrayList<JPBill> JPbillList=new ArrayList<JPBill>();
	public ArrayList<JPBill> getJPbillList() {
		return JPbillList;
	}
	public void setJPbillList(ArrayList<JPBill> jPbillList) {
		JPbillList = jPbillList;
	}
	//更新板
	JPanel JPupdate=null;
	//清单表格
	JTableOfList table;//表格的引用
	//逻辑层接口
	StubManagerBlService mbl=new StubManager();
	FinancialBlService fbl=new Financial();
	 SaleBillBlService sbl=new salebillController();
	 StubCommodityBlService stockbl=new StubStockController();
	 CustomerBlService customerbl=new CustomerList();
	 StubUserBlService userbl=new UserController();
	 Frame frame;//主窗口引用
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	public JPBillList(){
		//逻辑层接口
		StockManagerDriver smd=new StockManagerDriver();
		try
		{
			smd.start(stockbl,(StubCommodityDataService)Naming.lookup("rmi://127.0.0.1:1099/StubStockDataController"));
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (NotBoundException e)
		{
			e.printStackTrace();
		}
		//面板大小
		this.setSize(261, 0);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	

	}
	/*归位*/
	public void reHome(){
		this.setLocation(0, 0);
	}
	/*单据面板数组根据状态重新排序*/
	public ArrayList<JPBill> sortBillList(ArrayList<JPBill> bl){
		ArrayList<JPBill> result=new ArrayList<JPBill>();
		for(int i=0;i<bl.size();i++){
			if(bl.get(i).getState()==BillState.DRAFT){
				result.add(bl.get(i));
			}
		}
		for(int i=0;i<bl.size();i++){
			if(bl.get(i).getState()==BillState.SUBMITED){
				result.add(bl.get(i));
			}
		}
		for(int i=0;i<bl.size();i++){
			if(bl.get(i).getState()==BillState.EXAMINED){
				result.add(bl.get(i));
			}
		}
		for(int i=0;i<bl.size();i++){
			if(bl.get(i).getState()==BillState.OVER){
				result.add(bl.get(i));
			}
		}
		return result;
	}
	
	/*更新板根据数组更新*/
	public void updateJP(){
		if(JPupdate==null){
			JPupdate=new JPanel();
			//面板大小
			JPupdate.setSize(261, JPbillList.size()*93);
			//设置布局
			JPupdate.setLayout(null);
			//设置面板透明
			JPupdate.setOpaque(false);
		}
		else{
			this.remove(JPupdate);
			
			JPupdate=new JPanel();
			//面板大小
			JPupdate.setSize(261, JPbillList.size()*93);
			//设置布局
			JPupdate.setLayout(null);
			//设置面板透明
			JPupdate.setOpaque(false);
		}
		//如果是单据数据需要根据状态重新排序
		if(JPbillList.size()!=0){
			if(JPbillList.get(0).getType()==JPbillType.Bill){
				//重新排序
				JPbillList=sortBillList(JPbillList);
			}
		}
		
		//将table引用传给每个单据
		giveTableToBill();
		//循环加到更新面板上
		for(int i=0;i<JPbillList.size();i++){
			JPbillList.get(i).setLocation(0, 93*i);
			JPupdate.add(JPbillList.get(i),i);
		}
		//面板大小
		this.setSize(261, JPbillList.size()*93);
		//把更新板加到底板上
		this.add(JPupdate);
		this.repaint();
	}
	/*增加客户策略VO数组*/
	public void addLevelStrategyList(ArrayList<LevelStrategyVO> ls){

	
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<ls.size();i++){
			JPbillList.add(new JPBill(ls.get(i)));
		}
		//更新面板
		updateJP();
	}
	/*增加客户策略*/
	public void addLevelStrategy(LevelStrategyVO ls){
		//调用逻辑层
		switch(ls.getLevel_strategy_style()){
		case Gift:
			mbl.addGiftLevelStrategy(ls);
			break;
		case Discount:
			mbl.addDiscountLevelStrategy(ls);
			break;
		case Coupon:
			mbl.addCouponLevelStrategy(ls);
			break;
		}
		
		//从逻辑层读取数据更新界面
		JPbillList.clear();
		this.addLevelStrategyList(mbl.ShowLevelStrategy());
	}
	/*增加特价包策略VO数组*/
	public void addBarginStrategyList(ArrayList<BarginStrategyVO> bs){

	
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<bs.size();i++){
			JPbillList.add(new JPBill(bs.get(i)));
		}
		//更新面板
		updateJP();
	}
	/*增加特价包策略*/
	public void addBarginStrategy(BarginStrategyVO bs){
		//调用逻辑层
		mbl.addBarginStrategy(bs);
		//从逻辑层读取数据更新界面
		JPbillList.clear();
		this.addBarginStrategyList(mbl.ShowBarginStrategy());
	}
	/*增加满额策略VO数组*/
	public void addReachStrategyList(ArrayList<ReachStrategyVO> rs){

	
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<rs.size();i++){
			JPbillList.add(new JPBill(rs.get(i)));
		}
		//更新面板
		updateJP();
	}
	/*增加满额策略*/
	public void addReachStrategy(ReachStrategyVO rs){
		//调用逻辑层
		switch(rs.getReach_strategy_style()){
		case Gift:
			mbl.addGiftReachStrategy(rs);
			break;
		case Coupon:
			mbl.addCouponReachStrategy(rs);
			break;
		}
		//从逻辑层读取数据更新界面
		JPbillList.clear();
		this.addReachStrategyList(mbl.ShowReachStrategy());
	}
	/*增加账户VO数组*/
	public void addAccountList(ArrayList<AccountVO> ac){

	
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<ac.size();i++){
			JPbillList.add(new JPBill(ac.get(i)));
		}
		//更新面板
		updateJP();
	}
	/*增加账户*/
	public void addAccount(AccountVO ac){
		//调用逻辑层
		boolean result=fbl.addAccount(ac.getName(), ac.getBalance());
		if(result){
			//从逻辑层读取数据更新界面
			JPbillList.clear();
			this.addAccountList(fbl.getAllAccountInfo());
		}
		else{
			frame.getWarning().showWarning("已存在该账户");
		}
	
	}
	/*增加客户VO数组*/
	public void addCustomerList(ArrayList<CustomerVO> cs){

	
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<cs.size();i++){
			JPbillList.add(new JPBill(cs.get(i)));
		}
		//更新面板
		updateJP();
	}
	/*增加客户*/
	public void addCustomer(CustomerVO cs){
		//调用逻辑层
		boolean result = false;
		result = customerbl.addCustomer(cs);
		if(result){
			//从逻辑层读取数据更新界面
			JPbillList.clear();
			this.addCustomerList(customerbl.getAllCustomer("Customer.txt"));
		}
		else{
			frame.getWarning().showWarning("增加客户失败");
		}
	}
	/*增加用户VO数组*/
	public void addUserList(ArrayList<UserVO> us){

	
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<us.size();i++){
			JPbillList.add(new JPBill(us.get(i)));
		}
		//更新面板
		updateJP();
	}
	/*授权用户*/
	public void authorizeCustomer(UserVO us){
		//调用逻辑层

		userbl.authorized(us.getAccount());
		//从逻辑层读取数据更新界面
		JPbillList.clear();

		this.addUserList(userbl.showUsers());
	}
	/*增加赠送单VO数组*/
	public void addGiftBillList(ArrayList<GiftBillVO> gb){

	
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<gb.size();i++){
			JPbillList.add(new JPBill(gb.get(i)));
		}
		//更新面板
		updateJP();
	}
	/*增加赠送单*/
	public void addGiftBill(GiftBillVO gb){
		//调用逻辑层
		stockbl.creat(gb);
		//从逻辑层读取数据更新界面
		JPbillList.clear();
		this.addGiftBillList(stockbl.showGiftBills());
	}
	/*增加报警单VO数组*/
	public void addAlertBillList(ArrayList<AlertBillVO> ab){

		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<ab.size();i++){
			JPbillList.add(new JPBill(ab.get(i)));
		}
		//更新到面板上
		updateJP();

	}
	/*增加报警单*/
	public void addAlertBill(AlertBillVO ab){
//		//调用逻辑层
//		stockbl.
//		//从逻辑层读取数据更新界面
//		JPbillList.clear();
//		this.addPurSheetList(sbl.getAllPurSheet());
	}
	/*增加进货单VO数组*/
	public void addPurSheetList(ArrayList<PurSheetVO> ps){
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<ps.size();i++){
			JPbillList.add(new JPBill(ps.get(i)));
		}
		//更新到面板上
		updateJP();
	}
	/*增加进货单*/
	public void addPurSheet(PurSheetVO ps){
		//调用逻辑层
		sbl.createPurSheet(ps);
		//从逻辑层读取数据更新界面
		JPbillList.clear();
		this.addPurSheetList(sbl.getAllPurSheet());
	}
	/*增加进货退货单VO数组*/
	public void addPurBackSheetList(ArrayList<PurBackSheetVO> pbs){

		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<pbs.size();i++){
			JPbillList.add(new JPBill(pbs.get(i)));
		}
		//更新到面板上
		updateJP();

	}
	/*增加进货退货单*/
	public void addPurBackSheet(PurBackSheetVO pbs){
		//调用逻辑层
		sbl.createPurBackSheet(pbs);
		//从逻辑层读取数据更新界面
		JPbillList.clear();
		this.addPurBackSheetList(sbl.getAllPurBackSheet());
	}
	/*增加销售单VO数组*/
	public void addSaleSheetList(ArrayList<SaleSheetVO> ss){
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<ss.size();i++){
			JPbillList.add(new JPBill(ss.get(i)));
		}
		//更新到面板上
		updateJP();
	}
	/*增加销售单*/
	public void addSaleSheet(SaleSheetVO ss){
		//调用逻辑层
		sbl.createSaleSheet(ss);
		//从逻辑层读取数据更新界面
		JPbillList.clear();
		this.addSaleSheetList(sbl.getAllSaleSheet());
	}
	/*增加销售退货单VO数组*/
	public void addSaleBackSheetList(ArrayList<SaleBackSheetVO> sbs){

		
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<sbs.size();i++){
			JPbillList.add(new JPBill(sbs.get(i)));
		}
		//更新到面板上
		updateJP();

	}
	/*增加销售退货单*/
	public void addSaleBackSheet(SaleBackSheetVO sbs){
		//调用逻辑层
		sbl.createSaleBackSheet(sbs);
		//从逻辑层读取数据更新界面
		JPbillList.clear();
		this.addSaleBackSheetList(sbl.getAllSaleBackSheet());
	}
	/*增加收款单VO数组*/
	public void addReceiptBillList(ArrayList<ReceiptVO> rb){

		
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<rb.size();i++){
			JPbillList.add(new JPBill(rb.get(i)));
		}
		//更新到面板上
		updateJP();

	}
	/*增加收款单*/
	public void addReceiptBill(ReceiptVO rb){
		//调用逻辑层
		fbl.creatReceipt(rb);
		//从逻辑层读取数据更新界面
		JPbillList.clear();
		this.addReceiptBillList(fbl.getAllOfReceiptBills());
	}
	/*增加付款单VO数组*/
	public void addPaymentBillList(ArrayList<PaymentVO> pb){

		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<pb.size();i++){
			JPbillList.add(new JPBill(pb.get(i)));
		}
		//更新到面板上
		updateJP();


	}
	/*增加付款单*/
	public void addPaymentBill(PaymentVO pb){
		//调用逻辑层
		fbl.creatPayment(pb);
		//从逻辑层读取数据更新界面
		JPbillList.clear();
		this.addPaymentBillList(fbl.getAllOfPaymentBills());
	}
	/*增加现金费用单VO数组*/
	public void addCashPaymentBillList(ArrayList<CashPaymentVO> spb){

		
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<spb.size();i++){
			JPbillList.add(new JPBill(spb.get(i)));
		}
		//更新到面板上
		updateJP();
	}
	/*增加现金费用单*/
	public void addCashPaymentBill(CashPaymentVO spb){
		//调用逻辑层
		fbl.creatCashPayment(spb);
		//从逻辑层读取数据更新界面
		JPbillList.clear();
		this.addCashPaymentBillList(fbl.getAllOfCashPaymentBills());
	}
	/*增加报溢报损单VO数组*/
	public void addSpillsLossBillList(ArrayList<SpillsLossBillVO> slb){

		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<slb.size();i++){
			JPbillList.add(new JPBill(slb.get(i)));
		}
		//更新到面板上
		updateJP();
	}
	/*增加报溢报损单*/
	public void addSpillsLossBill(SpillsLossBillVO slb){
		//调用逻辑层
		stockbl.creat(slb);
		//从逻辑层读取数据更新界面
		JPbillList.clear();
		this.addSpillsLossBillList(stockbl.showSpillsLossBills());
	}
	
	/*修改选中的账户*/
	public void changeChosen(String oldname,String newName){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				boolean result=JPbillList.get(i).change(oldname,newName);
				if(result){
					//从逻辑层读取数据更新界面
					JPbillList.clear();
					this.addAccountList(fbl.getAllAccountInfo());
				}
				else{
					frame.getWarning().showWarning("已存在该账户");
				}
				break;
			}
		}
	}
	/*修改选中的用户*/
	public void changeChosen(UserVO us,Role r){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(us);//先改密码，ID没变
				JPbillList.get(i).changeRole(userbl.find(us.getAccount()),r);//修改职务，ID可能变化
				//从逻辑层读取数据更新界面
				JPbillList.clear();
				this.addUserList(userbl.showUsers());
				break;
			}
		}
	}
	/*修改选择的客户*/
	public void changeChosen(CustomerVO cus){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				boolean result=JPbillList.get(i).change(cus);
				if(result){
					//从逻辑层读取数据更新界面
					JPbillList.clear();
					this.addCustomerList(customerbl.getAllCustomer("Customer.txt"));
				}
				else{
					
				}
			
			
				break;
			}
		}
	}
	/*修改选中的*/
	public void changeChosen(GiftBillVO gb){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(gb);
				//从逻辑层读取数据更新界面
				JPbillList.clear();
				this.addGiftBillList(stockbl.showGiftBills());
				break;
			}
		}
	}
	public void changeChosen(SpillsLossBillVO slb){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(slb);
				//从逻辑层读取数据更新界面
				JPbillList.clear();
				this.addSpillsLossBillList(stockbl.showSpillsLossBills());
				break;
			}
		}
	}
	public void changeChosen(AlertBillVO ab){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(ab);
				//从逻辑层读取数据更新界面
				JPbillList.clear();
				this.addAlertBillList(stockbl.showAlertBills());
				break;
			}
		}
	}
	public void changeChosen(PurSheetVO ps){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(ps);
				//从逻辑层读取数据更新界面
				JPbillList.clear();
				this.addPurSheetList(sbl.getAllPurSheet());
				break;
			}
		}
	}
	public void changeChosen(PurBackSheetVO pbs){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(pbs);
				//从逻辑层读取数据更新界面
				JPbillList.clear();
				this.addPurBackSheetList(sbl.getAllPurBackSheet());
				break;
			}
		}
	}
	public void changeChosen(SaleSheetVO ss){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(ss);
				//从逻辑层读取数据更新界面
				JPbillList.clear();
				this.addSaleSheetList(sbl.getAllSaleSheet());
				break;
			}
		}
	}
	public void changeChosen(SaleBackSheetVO sbs){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(sbs);
				//从逻辑层读取数据更新界面
				JPbillList.clear();
				this.addSaleBackSheetList(sbl.getAllSaleBackSheet());
				break;
			}
		}
	}
	public void changeChosen(ReceiptVO rb){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(rb);
				//从逻辑层读取数据更新界面
				JPbillList.clear();
				this.addReceiptBillList(fbl.getAllOfReceiptBills());
				break;
			}
		}
	}
	public void changeChosen(PaymentVO pb){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(pb);
				//从逻辑层读取数据更新界面
				JPbillList.clear();
				this.addPaymentBillList(fbl.getAllOfPaymentBills());
				break;
			}
		}
	}
	public void changeChosen(CashPaymentVO cb){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(cb);
				//从逻辑层读取数据更新界面
				JPbillList.clear();
				this.addCashPaymentBillList(fbl.getAllOfCashPaymentBills());
				break;
			}
		}
	}
	/*传递清单表格的引用给单据面板*/
	public void giveTableToBill(){
		for(int i=0;i<JPbillList.size();i++){
			JPbillList.get(i).getTable(table);
		}
	}
	public void getTable(JTableOfList t){
		table=t;
	}

	/*返回选中的单据*/
	public JPBill getChosen(){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				return JPbillList.get(i);
			}
		}
		return null;
	}
	/*通过选中的*/
	public void passChosen(){
		if(getChosenNum()>=1&&isTheSameState()&&stateOfChosen()==BillState.SUBMITED){
			for(int i=0;i<JPbillList.size();i++){
				if(JPbillList.get(i).getChoose()){
					JPbillList.get(i).transformState(BillState.EXAMINED);
				}
			}
			//更新面板
			updateJP();
		}
		else{
			frame.getWarning().showWarning("只有提交状态的单据能够通过审批");
		}
	}
	/*提交选中的*/
	public void submitChosen(){
		if(getChosenNum()>=1&&isTheSameState()&&stateOfChosen()==BillState.DRAFT){
			for(int i=0;i<JPbillList.size();i++){
				if(JPbillList.get(i).getChoose()){
					JPBill jpt = JPbillList.get(i);
					BillStyle bst = jpt.getStyle();
					if(bst!=BillStyle.GiftBill && bst!=BillStyle.SpillsLossBill)//added by lhw
						JPbillList.get(i).transformState(BillState.SUBMITED);
					else
					{
						RM result=RM.done;
						if(bst == BillStyle.GiftBill)
							result = stockbl.submit(jpt.getGiftVO());
						else
							result = stockbl.submit(jpt.getSpillsLossVO());
						if(result == RM.insufficient)
							frame.getWarning().showWarning(WarningText.insufficient);
						else if(result == RM.RMIError)
							frame.getWarning().showWarning(WarningText.RMIError);
						else if(result != RM.done)
							frame.getWarning().showWarning(WarningText.unknownerror);
					}
				}
			}
			//更新面板
			updateJP();
		}
		else{
			frame.getWarning().showWarning("只有草稿状态的单据能够提交");
		}
	}
	/*处理选中的*/
	public void doneChosen(){
		if(getChosenNum()>=1&&isTheSameState()&&stateOfChosen()==BillState.EXAMINED){
			for(int i=0;i<JPbillList.size();i++){
				if(JPbillList.get(i).getChoose()){
					JPbillList.get(i).transformState(BillState.OVER);
				}
			}
			//更新面板
			updateJP();
		}
		else{
			frame.getWarning().showWarning("只有已经通过审批的单据能够处理");
		}
	}
	/*授权选中的用户*/
	public void authorizeChosen(){
		if(getChosenNum()!=0){
			for(int i=0;i<JPbillList.size();i++){
				if(JPbillList.get(i).getChoose()){
					JPbillList.get(i).authorize();
				}
			}
			//从数据层重新读取更新面板
			JPbillList.clear();
			this.addUserList(userbl.showUsers());
		}
	
		else{
			frame.getWarning().showWarning("请选择要授权的用户");
		}
	}
	/*删除选中的*/
	public void removeChosen(){

		if(getChosenNum()!=0){
			if(getChosen().getType()==JPbillType.Bill){
				if(isTheSameState()&&stateOfChosen()==BillState.OVER){//如果是同一个状态且是已处理状态
					for(int i=0;i<JPbillList.size();i++){
						if(JPbillList.get(i).getChoose()){
							JPbillList.remove(i);
							i--;
						}
					}
					//重新加到底板上
					updateJP();
				}
			
				else{
					frame.getWarning().showWarning("只有已处理单据能够移除");
				}
			}
			else{//不是单据
				for(int i=0;i<JPbillList.size();i++){
					if(JPbillList.get(i).getChoose()){
						//如果是策略，要从数据库中删除
						if(JPbillList.get(i).getLevelStrategyVO()!=null){
							mbl.Remove(JPbillList.get(i).getLevelStrategyVO());
							JPbillList.remove(i);
							i--;
						}
						if(JPbillList.get(i).getBarginStrategyVO()!=null){
							mbl.Remove(JPbillList.get(i).getBarginStrategyVO());
							JPbillList.remove(i);
							i--;
						}
						if(JPbillList.get(i).getReachStrategyVO()!=null){
							mbl.Remove(JPbillList.get(i).getReachStrategyVO());
							JPbillList.remove(i);
							i--;
						}
						//如果是用户
						if(JPbillList.get(i).getUserVO()!=null){
							userbl.deleteUser(JPbillList.get(i).getUserVO());
							JPbillList.remove(i);
							i--;
						}
						//如果是客户
						if(JPbillList.get(i).getCustomerVO()!=null){
							boolean result = false;
							result = customerbl.deleteCustomer(JPbillList.get(i).getCustomerVO().getid());
						
							if(result){
								JPbillList.remove(i);
								i--;
							}
							else{
								frame.getWarning().showWarning("删除失败");
							}
						}
						//如果是账户
						if(JPbillList.get(i).getAccountVO()!=null){
							boolean result=fbl.deleteAccount(JPbillList.get(i).getAccountVO().getName());
						
							if(result){
								JPbillList.remove(i);
								i--;
							}
							else{
								frame.getWarning().showWarning("只能删除余额为0的账户");
							}
							
						}
						
					}
				}
				//重新加到底板上
				updateJP();
			}
		}
		else{
			frame.getWarning().showWarning("请选择要删除的选项");
		}
		
		
	}
	
	/*返回被选中的个数*/
	public int getChosenNum(){
		int chosenNum=0;
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				chosenNum++;
			}
		}
		return chosenNum;
	}
	/*选中的单据是否是同一个状态*/
	public boolean isTheSameState(){
		BillState state=null;
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				if(state!=null&&JPbillList.get(i).getState()!=state){
					return false;
				}
				state=JPbillList.get(i).getState();
			}
		}
		return true;
	}
	/*返回选中单据的状态*/
	public BillState stateOfChosen(){
		if(isTheSameState()){//如果选中的单据都是同一个状态
			for(int i=0;i<JPbillList.size();i++){
				if(JPbillList.get(i).getChoose()){
					return JPbillList.get(i).getState();
				}
			}
		}
		return null;
		
	}
	/*面板向上移动*/
	public void startUp(){
		stop=false;
		//线程
		Thread t=new Thread(new TreadOfUp());
		//开启线程
		t.start();
	}
	/*面板向下移动*/
	public void startDown(){
		stop=false;
		//线程
		Thread t=new Thread(new TreadOfDown());
		//开启线程
		t.start();
	}
	/*面板停止移动*/
	public void stop(){
		stop=true;
	}

	/*向上移动线程*/
	public class TreadOfUp implements Runnable{

		public void run() {
			
			while(!stop){
				y-=10;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				JPBillList.this.setLocation(0, y);
			}
		}

		
	}
	/*向下移动线程*/
	public class TreadOfDown implements Runnable{

		public void run() {
			
			while(!stop){
				y+=10;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				JPBillList.this.setLocation(0, y);
			}
		}

		
	}

}
