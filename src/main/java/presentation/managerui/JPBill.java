package presentation.managerui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import po.BillState;
import po.BillStyle;
import po.RM;
import po.Role;
import po.StrategyStyle;
import presentation.commodityui.StockManagerDriver;
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
import data.commoditydata.StockDataController;
import dataservice.commoditydataservice.CommodityDataService;

public class JPBill extends JPanel {

	//区分面板种类
	private JPbillType Type=JPbillType.Default;
	//单据编号
	private String ID;
	//单据类型
	private BillStyle style;
	//单据类型
	private StrategyStyle strategyStyle;
	//单据状态
	private BillState state;
	//背景
	private JLabel bg=new JLabel();
	//向右按钮
	private JLabel right=new JLabel();
	//向左按钮
	private JLabel left=new JLabel();
	//选中标记
	private boolean choose=false;
	//对应的单据VO
	private GiftBillVO giftVO;
	private AlertBillVO alertVO;
	private SpillsLossBillVO spillsLossVO;
	private PurSheetVO purVO;
	private PurBackSheetVO purbackVO;
	private SaleSheetVO saleVO;
	private CashPaymentVO cashVO;
	private PaymentVO payVO;
	private ReceiptVO receiptVO;
	private SaleBackSheetVO salebackVO;
	
	private LevelStrategyVO levelStrategyVO;
	private BarginStrategyVO barginStrategyVO;
	private ReachStrategyVO reachStrategyVO;
	
	private CustomerVO customerVO;
	private UserVO userVO;
	private AccountVO accountVO;
	
	//逻辑层的接口
	StubManagerBlService mbl=new StubManager();
	FinancialBlService fbl=new Financial();
	 SaleBillBlService sbl=new salebillController();
	 StubCommodityBlService stockbl=new StubStockController();
	 CustomerBlService customerbl=new CustomerList();
	 StubUserBlService userbl=new UserController();
	//现金费用单的标签
	JLabel operatorOfCas=new JLabel("操作员");
	JLabel accountOfCas=new JLabel("帐户");
	JLabel moneyOfCas=new JLabel("总额");
	String[] itemOfCas={"条目名","金额","备注"};
	String[][] listOfCas;
	
	//收款付款单的标签
	JLabel operatorOfPR=new JLabel("操作员");
	JLabel customerOfPR=new JLabel("客户");
	JLabel moneyOfPR=new JLabel("总额");
	String[] itemOfPR={"银行账户","转账金额","备注"};
	String[][] listOfPR;
	//清单表格的引用
	JTableOfList table;
	public JPBill(LevelStrategyVO ls){
		//区分面板种类
		setType(JPbillType.Strategy);
		//逻辑层接口
		StockManagerDriver smd=new StockManagerDriver();
		try
		{
			smd.start(stockbl,(CommodityDataService)Naming.lookup("rmi://127.0.0.1:1099/StubStockDataController"));
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
		//传递VO
		levelStrategyVO=ls;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		bg.setIcon(new ImageIcon("src/image/strategy/LevelStrategy1.png"));
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MLofOther(1));
		bg.addMouseListener(new MouseListenerGetXY());
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JTextField ID=new JTextField("ID:"+ls.getID(),JTextField.CENTER);
		ID.setOpaque(false);
		ID.setBorder(null);
		ID.setFont(new Font("",Font.BOLD,14));
		ID.setBounds(31,5, 200, 20);
		
		JLabel level=new JLabel("客户等级：");
		JLabel limit=new JLabel("消费下限：");
		JLabel discount=new JLabel("打折比例：");
		JLabel coupon=new JLabel("赠送代金券比例：");
		JLabel start=new JLabel("起始时间：");
		JLabel last=new JLabel("持续时间：");
		
		JLabel levelTxt=new JLabel(String.valueOf(ls.getLevel()));
		JLabel startTxt=new JLabel(ls.getStartTime());
		JLabel lastTxt=new JLabel(String.valueOf(ls.getLastTime()));
		
		//设置标签字体
		level.setFont(new Font("楷体",Font.BOLD,18));
		limit.setFont(new Font("楷体",Font.BOLD,18));
		discount.setFont(new Font("楷体",Font.BOLD,18));
		coupon.setFont(new Font("楷体",Font.BOLD,18));
		start.setFont(new Font("楷体",Font.BOLD,18));
		last.setFont(new Font("楷体",Font.BOLD,18));
		
		
		//设置字体颜色
		level.setForeground(Color.white);
		limit.setForeground(Color.white);
		discount.setForeground(Color.white);
		coupon.setForeground(Color.white);
		start.setForeground(Color.white);
		last.setForeground(Color.white);
		
		level.setBounds(280, 6, 100, 20);
		limit.setBounds(280, 26, 100, 20);
		discount.setBounds(280, 26, 100, 20);
		coupon.setBounds(280, 26, 160, 20);
		start.setBounds(280, 46, 100, 20);
		last.setBounds(280, 66, 100, 20);
		
		levelTxt.setBounds(370, 6, 100, 20);
		startTxt.setBounds(370, 48, 100, 20);
		lastTxt.setBounds(370, 69, 100, 20);
		
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		//单据信息未完
		switch(ls.getLevel_strategy_style()){
		case Gift:
			JLabel limitTxt=new JLabel(String.valueOf(ls.getLimit()));
			limitTxt.setBounds(370, 27, 100, 20);
			this.add(level,3);
			this.add(limit,4);
			this.add(start,5);
			this.add(last,6);
			this.add(levelTxt,7);
			this.add(limitTxt,8);
			this.add(startTxt,9);
			this.add(lastTxt,10);
			break;
		case Discount://打折
			JLabel discountTxt=new JLabel(String.valueOf(ls.getDiscountrate()));
			discountTxt.setBounds(370, 27, 100, 20);
			this.add(level,3);
			this.add(discount,4);
			this.add(start,5);
			this.add(last,6);
			this.add(levelTxt,7);
			this.add(discountTxt,8);
			this.add(startTxt,9);
			this.add(lastTxt,10);
			break;
		case Coupon://代金券
			JLabel couponTxt=new JLabel(String.valueOf(ls.getCouponrate()));
			couponTxt.setBounds(425, 27, 100, 20);
			this.add(level,3);
			this.add(coupon,4);
			this.add(start,5);
			this.add(last,6);
			this.add(levelTxt,7);
			this.add(couponTxt,8);
			this.add(startTxt,9);
			this.add(lastTxt,10);
			break;
		}
		//将组件加到面板上
		this.add(bg,11);
		
	}
	public JPBill(BarginStrategyVO bs){
		//区分面板种类
		setType(JPbillType.Strategy);
		//传递VO
		barginStrategyVO=bs;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		bg.setIcon(new ImageIcon("src/image/strategy/BarginStrategy1.png"));
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MLofOther(2));
		bg.addMouseListener(new MouseListenerGetXY());
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JTextField ID=new JTextField("ID:"+bs.getID(),JTextField.CENTER);
		ID.setOpaque(false);
		ID.setBorder(null);
		ID.setFont(new Font("",Font.BOLD,14));
		ID.setBounds(31,5, 200, 20);
		//单据信息未完
		JLabel originalTotalPrice=new JLabel("原始总价");
		JLabel decreasePrice=new JLabel("降价金额");
		JLabel start=new JLabel("起始时间");
		JLabel last=new JLabel("持续时间");
		
		Double originalTotal=0.0;
		for(int i=0;i<bs.getAlOfCommodity().size();i++){
			originalTotal+=bs.getAlOfCommodity().get(i).getOut()*bs.getAlOfCommodity().get(i).getNumber();
		}
		//单据信息未完
		JLabel originalTotalPriceTxt=new JLabel(String.valueOf(originalTotal));
		JLabel decreasePriceTxt=new JLabel(String.valueOf(bs.getDiscount()));
		JLabel startTxt=new JLabel(bs.getStartTime());
		JLabel lastTxt=new JLabel(String.valueOf(bs.getLastTime()));
		//字体
		originalTotalPrice.setFont(new Font("楷体",Font.BOLD,15));
		decreasePrice.setFont(new Font("楷体",Font.BOLD,15));
		start.setFont(new Font("楷体",Font.BOLD,15));
		last.setFont(new Font("楷体",Font.BOLD,15));
		
		//字体颜色
		originalTotalPrice.setForeground(Color.white);
		decreasePrice.setForeground(Color.white);
		start.setForeground(Color.white);
		last.setForeground(Color.white);
		
		originalTotalPrice.setBounds(280, 4, 100, 17);
		decreasePrice.setBounds(280, 21, 100, 17);
		start.setBounds(280,38, 160, 17);
		last.setBounds(280,55, 100, 17);
		
		originalTotalPriceTxt.setBounds(370, 4, 100, 17);
		decreasePriceTxt.setBounds(370, 21, 100, 17);
		startTxt.setBounds(370,38, 160, 17);
		lastTxt.setBounds(370,55, 100, 17);
		
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(originalTotalPrice,3);
		this.add(decreasePrice,4);
		this.add(start,5);
		this.add(last,6);
		this.add(originalTotalPriceTxt,7);
		this.add(decreasePriceTxt,8);
		this.add(startTxt,9);
		this.add(lastTxt,10);
		this.add(bg,11);
	}
	public JPBill(ReachStrategyVO rs){
		//区分面板种类
		setType(JPbillType.Strategy);
		//传递VO
		reachStrategyVO=rs;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		bg.setIcon(new ImageIcon("src/image/strategy/ReachStrategy1.png"));
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MLofOther(3));
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JTextField ID=new JTextField("ID:"+rs.getID(),JTextField.CENTER);
		ID.setOpaque(false);
		ID.setBorder(null);
		ID.setFont(new Font("",Font.BOLD,14));
		ID.setBounds(31,5, 200, 20);
		//单据信息未完
		JLabel limit=new JLabel("消费下限：");
		JLabel coupon=new JLabel("代金券赠送比例：");
		JLabel start=new JLabel("起始时间：");
		JLabel last=new JLabel("持续时间：");
		
		JLabel limitTxt=new JLabel(String.valueOf(rs.getLimit()));
		
		JLabel startTxt=new JLabel(rs.getStartTime());
		JLabel lastTxt=new JLabel(String.valueOf(rs.getLastTime()));
		//设置标签字体
		limit.setFont(new Font("楷体",Font.BOLD,18));
		coupon.setFont(new Font("楷体",Font.BOLD,18));
		start.setFont(new Font("楷体",Font.BOLD,18));
		last.setFont(new Font("楷体",Font.BOLD,18));
		
		//设置字体颜色
		limit.setForeground(Color.white);
		coupon.setForeground(Color.white);
		start.setForeground(Color.white);
		last.setForeground(Color.white);
		
		limit.setBounds(280, 6, 100, 20);
		coupon.setBounds(280, 26, 160, 20);
	
		
		limitTxt.setBounds(370, 6, 100, 20);
		
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		switch(rs.getReach_strategy_style()){
		case Gift://赠品
			startTxt.setBounds(370, 27, 100, 20);
			lastTxt.setBounds(370, 48, 100, 20);
			start.setBounds(280, 26, 100, 20);
			last.setBounds(280, 46, 100, 20);
			this.add(limit,3);
			this.add(start,4);
			this.add(last,5);
			this.add(limitTxt,6);
			this.add(startTxt,7);
			this.add(lastTxt,8);
			this.add(bg,9);
			break;
		case Coupon://代金券
			JLabel couponTxt=new JLabel(String.valueOf(rs.getCouponrate()));
			couponTxt.setBounds(425, 27, 100, 20);
			startTxt.setBounds(370, 48, 100, 20);
			lastTxt.setBounds(370, 69, 100, 20);
			start.setBounds(280, 46, 100, 20);
			last.setBounds(280, 66, 100, 20);
			
			this.add(limit,3);
			this.add(coupon,4);
			this.add(start,5);
			this.add(last,6);
			this.add(limitTxt,7);
			this.add(couponTxt,8);
			this.add(startTxt,9);
			this.add(lastTxt,10);
			this.add(bg,11);
			break;
		}
		//将组件加到面板上
	
		
	}
	public JPBill(CustomerVO customer){
		//区分面板种类
		setType(JPbillType.Customer);
		//传递VO
		customerVO=customer;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		bg.setIcon(new ImageIcon("src/image/customer/customer1.png"));
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MLofOther(4));
		bg.addMouseListener(new MouseListenerGetXY());
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JTextField ID=new JTextField("ID:"+customer.getid(),JTextField.CENTER);
		ID.setOpaque(false);
		ID.setBorder(null);
		ID.setFont(new Font("",Font.BOLD,14));
		ID.setBounds(31,5, 200, 20);		
		//单据信息未完
		String t="";
		if(customer.gettype()==0){
			t="进货商:";
		}
		else{
			t="销售商:";
		}
		JLabel name=new JLabel(t+customer.getname());
		JLabel saleman=new JLabel(customer.getdeSaler());
		JLabel level=new JLabel(String.valueOf(customer.getlevel()));
		JLabel pay=new JLabel(String.valueOf(customer.getShouldPay()));
		
		JLabel receive=new JLabel(String.valueOf(customer.getShouldTake()));
		
		JLabel phoneNum=new JLabel(String.valueOf(customer.getphonenumber()));
		JLabel address=new JLabel(customer.getaddress());

		JLabel email=new JLabel(customer.getemail());
		
		JLabel postcode=new JLabel(customer.getpostcode());
		JLabel maxowe=new JLabel(String.valueOf(customer.getmaxOwe()));
	
		name.setFont(new Font("楷体",Font.PLAIN,16));
		saleman.setFont(new Font("楷体",Font.PLAIN,16));
		name.setForeground(Color.white);
		saleman.setForeground(Color.white);
		name.setBounds(80, 28,150, 20);
		saleman.setBounds(143,47,150, 20);
		level.setBounds(315,4, 100, 17);
		receive.setBounds(315,21, 100, 17);
		pay.setBounds(315,38, 100, 17);
		phoneNum.setBounds(315,55, 100, 17);
		address.setBounds(315,72,250, 17);
		
		email.setBounds(400,3,200, 17);
		maxowe.setBounds(424,20, 100, 17);
		postcode.setBounds(400,38, 100, 17);
		
		
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(name,3);
		this.add(saleman,4);
		this.add(level,5);
		this.add(receive,6);
		this.add(pay,7);
		this.add(phoneNum,8);
		this.add(address,9);
		this.add(email,10);
		this.add(maxowe,11);
		this.add(postcode,12);
		this.add(bg,13);
	}
	public JPBill(UserVO user){
		//区分面板种类
		setType(JPbillType.User);
		//传递VO
		userVO=user;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		bg.setIcon(new ImageIcon("src/image/user/user1.png"));
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MLofOther(5));
		bg.addMouseListener(new MouseListenerGetXY());
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JTextField ID=new JTextField("ID:"+user.getID(),JTextField.CENTER);
		ID.setOpaque(false);
		ID.setBorder(null);
		ID.setFont(new Font("",Font.BOLD,14));
		ID.setBounds(31,5, 200, 20);	
		//单据信息未完
		String authorize="";
		if(user.isAuthorized()){
			authorize="（已授权）";
		}
		else{
			authorize="（未授权）";
		}
		JLabel name=new JLabel(user.getName(),JLabel.CENTER);
		JLabel authority=new JLabel(authorize,JLabel.CENTER);
		String ro="";
		switch(user.getR()){
		case ADMINISTRATOR:ro="管理员";
			break;
		case FINANCIAL_STAFF:ro="财务人员";
			break;
		case FINANCIAL_MANAGER:ro="财务经理";
			break;
		case MANAGER:ro="总经理";
			break;
		case STOCK_STAFF:ro="库存管理人员";
			break;
		case PURCHASE_SALE_STAFF:ro="进货销售人员";
			break;
		case PURCHASE_SALE_MANAGER:ro="进销经理";
			break;
		}
		JLabel role=new JLabel(ro);
		JLabel account=new JLabel(user.getAccount());
		JLabel passcode=new JLabel(user.getPassword());
		authority.setBounds(85,55,100, 20);
		name.setBounds(85, 30,100, 20);
		name.setFont(new Font("宋体",Font.BOLD,16));
		name.setForeground(Color.white);
		authority.setFont(new Font("宋体",Font.BOLD,16));
		authority.setForeground(Color.white);
		role.setBounds(338, 10,120, 20);
		account.setBounds(338, 35, 100, 20);
		passcode.setBounds(338, 60, 100, 20);
		
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(name,3);
		this.add(role,4);
		this.add(account,5);
		this.add(passcode,6);
		this.add(authority,7);
		this.add(bg,8);
	}
	public JPBill(AccountVO account){
		//区分面板种类
		setType(JPbillType.Account);
		//传递VO
		accountVO=account;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		bg.setIcon(new ImageIcon("src/image/account/account1.png"));
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MLofOther(6));
		bg.addMouseListener(new MouseListenerGetXY());
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		
		//单据信息未完
		JLabel name=new JLabel(account.getName());
		JLabel balance=new JLabel(String.valueOf(account.getBalance()));
		
		name.setBounds(147, 34, 100, 20);
		balance.setBounds(350, 34, 100, 20);
		
		this.add(right,0);
		this.add(left,1);
		this.add(name,2);
		this.add(balance,3);
		this.add(bg,4);
	}
	public LevelStrategyVO getLevelStrategyVO() {
		return levelStrategyVO;
	}
	public void setLevelStrategyVO(LevelStrategyVO levelStrategyVO) {
		this.levelStrategyVO = levelStrategyVO;
	}
	public BarginStrategyVO getBarginStrategyVO() {
		return barginStrategyVO;
	}
	public void setBarginStrategyVO(BarginStrategyVO barginStrategyVO) {
		this.barginStrategyVO = barginStrategyVO;
	}
	public ReachStrategyVO getReachStrategyVO() {
		return reachStrategyVO;
	}
	public void setReachStrategyVO(ReachStrategyVO reachStrategyVO) {
		this.reachStrategyVO = reachStrategyVO;
	}
	public class MLofOther implements MouseListener{

		private int num;//1、客户策略2、特价包策略3、满额策略4、客户
		public MLofOther(int N){
			num=N;
		}
		public void mouseClicked(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			choose=!choose;
			if(choose){
				switch(num){
				case 1:
					bg.setIcon(new ImageIcon("src/image/strategy/LevelStrategy4.png"));
					break;
				case 2:
					bg.setIcon(new ImageIcon("src/image/strategy/BarginStrategy4.png"));
					break;
				case 3:
					bg.setIcon(new ImageIcon("src/image/strategy/ReachStrategy4.png"));
					break;
				case 4:
					bg.setIcon(new ImageIcon("src/image/customer/customer4.png"));
					break;
				case 5:
					bg.setIcon(new ImageIcon("src/image/user/user4.png"));
					break;
				case 6:
					bg.setIcon(new ImageIcon("src/image/account/account4.png"));
					break;
				}
			}
			else{
				switch(num){
				case 1:
					bg.setIcon(new ImageIcon("src/image/strategy/LevelStrategy3.png"));
					break;
				case 2:
					bg.setIcon(new ImageIcon("src/image/strategy/BarginStrategy3.png"));
					break;
				case 3:
					bg.setIcon(new ImageIcon("src/image/strategy/ReachStrategy3.png"));
					break;
				case 4:
					bg.setIcon(new ImageIcon("src/image/customer/customer3.png"));
					break;
				case 5:
					bg.setIcon(new ImageIcon("src/image/user/user3.png"));
					break;
				case 6:
					bg.setIcon(new ImageIcon("src/image/account/account3.png"));
					break;
				}
			}
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			if(choose){
				switch(num){
				case 1:
					bg.setIcon(new ImageIcon("src/image/strategy/LevelStrategy4.png"));
					break;
				case 2:
					bg.setIcon(new ImageIcon("src/image/strategy/BarginStrategy4.png"));
					break;
				case 3:
					bg.setIcon(new ImageIcon("src/image/strategy/ReachStrategy4.png"));
					break;
				case 4:
					bg.setIcon(new ImageIcon("src/image/customer/customer4.png"));
					break;
				case 5:
					bg.setIcon(new ImageIcon("src/image/user/user4.png"));
					break;
				case 6:
					bg.setIcon(new ImageIcon("src/image/account/account4.png"));
					break;
				}
			}
			else{
				switch(num){
				case 1:
					bg.setIcon(new ImageIcon("src/image/strategy/LevelStrategy3.png"));
					break;
				case 2:
					bg.setIcon(new ImageIcon("src/image/strategy/BarginStrategy3.png"));
					break;
				case 3:
					bg.setIcon(new ImageIcon("src/image/strategy/ReachStrategy3.png"));
					break;
				case 4:
					bg.setIcon(new ImageIcon("src/image/customer/customer3.png"));
					break;
				case 5:
					bg.setIcon(new ImageIcon("src/image/user/user3.png"));
					break;
				case 6:
					bg.setIcon(new ImageIcon("src/image/account/account3.png"));
					break;
				}
			}
		}

		public void mouseExited(MouseEvent e) {
			if(choose){
				switch(num){
				case 1:
					bg.setIcon(new ImageIcon("src/image/strategy/LevelStrategy2.png"));
					break;
				case 2:
					bg.setIcon(new ImageIcon("src/image/strategy/BarginStrategy2.png"));
					break;
				case 3:
					bg.setIcon(new ImageIcon("src/image/strategy/ReachStrategy2.png"));
					break;
				case 4:
					bg.setIcon(new ImageIcon("src/image/customer/customer2.png"));
					break;
				case 5:
					bg.setIcon(new ImageIcon("src/image/user/user2.png"));
					break;
				case 6:
					bg.setIcon(new ImageIcon("src/image/account/account2.png"));
					break;
				}
			}
			else{
				switch(num){
				case 1:
					bg.setIcon(new ImageIcon("src/image/strategy/LevelStrategy1.png"));
					break;
				case 2:
					bg.setIcon(new ImageIcon("src/image/strategy/BarginStrategy1.png"));
					break;
				case 3:
					bg.setIcon(new ImageIcon("src/image/strategy/ReachStrategy1.png"));
					break;
				case 4:
					bg.setIcon(new ImageIcon("src/image/customer/customer1.png"));
					break;
				case 5:
					bg.setIcon(new ImageIcon("src/image/user/user1.png"));
					break;
				case 6:
					bg.setIcon(new ImageIcon("src/image/account/account1.png"));
					break;
				}
			}
		}
		
	}
	public JPBill(GiftBillVO gb){
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=gb.getState();
		style=gb.getBillStyle();
		ID=gb.getID();
		//传递VO
		giftVO=gb;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		setBillBg(BillStyle.GiftBill,gb.getState(),0);
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MouseListenerOfBill(BillStyle.GiftBill));
		bg.addMouseListener(new MouseListenerGetXY());
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JTextField ID=new JTextField("ID:"+gb.getID(),JTextField.CENTER);
		ID.setOpaque(false);
		ID.setBorder(null);
		ID.setFont(new Font("",Font.BOLD,14));
		ID.setBounds(31,5, 200, 20);
		//单据信息未完
		String[] remark=gb.getRemark();
		JLabel reason=new JLabel(remark[0]);
		JLabel customer=new JLabel(remark[1]);
		reason.setBounds(356, 10, 150, 20);
		customer.setBounds(356, 30, 150, 20);
		
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(reason,3);
		this.add(customer,4);
		this.add(bg,5);
	}
	public JPBill(SpillsLossBillVO slb){
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=slb.getState();
		style=slb.getBillstyle();
		ID=slb.getID();
		//传递VO
		spillsLossVO=slb;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		setBillBg(BillStyle.SpillsLossBill,slb.getState(),0);
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MouseListenerOfBill(BillStyle.SpillsLossBill));
		bg.addMouseListener(new MouseListenerGetXY());
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JTextField ID=new JTextField("ID:"+slb.getID(),JTextField.CENTER);
		ID.setOpaque(false);
		ID.setBorder(null);
		ID.setFont(new Font("",Font.BOLD,14));
		ID.setBounds(31,5, 200, 20);
		
		String Type="";
		switch(slb.getT()){
		case Spills:Type="报溢单";
			break;
		case Loss:Type="报损单";
			break;
		}
		JLabel type=new JLabel(Type);
		JLabel commodity=new JLabel(slb.getCom().getName());
		JLabel model=new JLabel(slb.getCom().getModel());
		JLabel num=new JLabel(String.valueOf(slb.getCom().getNumber()));
		
		type.setBounds(330, 7, 100, 20);
		commodity.setBounds(330, 27, 100, 20);
		model.setBounds(330, 47, 100, 20);
		num.setBounds(330, 67, 100, 20);
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(type,3);
		this.add(commodity,4);
		this.add(model,5);
		this.add(num,6);
		this.add(bg,7);
	}
	public JPBill(AlertBillVO ab){
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=ab.getState();
		style=ab.getBillstyle();
		ID=ab.getID();
		//传递VO
		alertVO=ab;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		setBillBg(BillStyle.AlertBill,ab.getState(),0);
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MouseListenerOfBill(BillStyle.AlertBill));
		bg.addMouseListener(new MouseListenerGetXY());
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JTextField ID=new JTextField("ID:"+ab.getID(),JTextField.CENTER);
		ID.setOpaque(false);
		ID.setBorder(null);
		ID.setFont(new Font("",Font.BOLD,14));
		ID.setBounds(31,5, 200, 20);
		JLabel commodity=new JLabel(ab.getCom().getName());
		JLabel model=new JLabel(ab.getCom().getModel());
		JLabel num=new JLabel(String.valueOf(ab.getCom().getNumber()));
		commodity.setBounds(318, 20, 150, 20);
		model.setBounds(318, 40, 150, 20);
		num.setBounds(356, 63, 150, 20);
		
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(commodity,3);
		this.add(model,4);
		this.add(num,5);
		this.add(bg,6);
	}
	public JPBill(PurSheetVO ps){
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=ps.getState();
		style=ps.getStyle();
		ID=ps.getid();
		//传递VO
		purVO=ps;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		setBillBg(BillStyle.PurSheet,ps.getState(),0);
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MouseListenerOfBill(BillStyle.PurSheet));
		bg.addMouseListener(new MouseListenerGetXY());
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JTextField ID=new JTextField("ID:"+ps.getid(),JTextField.CENTER);
		ID.setOpaque(false);
		ID.setBorder(null);
		ID.setFont(new Font("",Font.BOLD,14));
		ID.setBounds(31,5, 200, 20);
		
		JLabel customer=new JLabel(ps.getcustomer().getname()+":"+ps.getcustomer().getid());
		JLabel warehouse=new JLabel(ps.getstock());
		JLabel totalMoney=new JLabel(String.valueOf(ps.getmoney1()));
		JLabel note=new JLabel(ps.getwords());
		JLabel operator=new JLabel(ps.getop());
		
		customer.setBounds(337, 2, 100, 20);
		warehouse.setBounds(337, 21, 100, 20);
		totalMoney.setBounds(354, 38, 100, 20);
		note.setBounds(337, 54, 100, 20);
		operator.setBounds(354, 72, 100, 20);
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(customer,3);
		this.add(warehouse,4);
		this.add(totalMoney,5);
		this.add(note,6);
		this.add(operator,7);
		this.add(bg,8);
	}
	public JPBill(PurBackSheetVO pbs){
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=pbs.getState();
		style=pbs.getStyle();
		ID=pbs.getid();
		//传递VO
		purbackVO=pbs;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		setBillBg(BillStyle.PurBackSheet,pbs.getState(),0);
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MouseListenerOfBill(BillStyle.PurBackSheet));
		bg.addMouseListener(new MouseListenerGetXY());
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JTextField ID=new JTextField("ID:"+pbs.getid(),JTextField.CENTER);
		ID.setOpaque(false);
		ID.setBorder(null);
		ID.setFont(new Font("",Font.BOLD,14));
		ID.setBounds(31,5, 200, 20);
		
		JLabel customer=new JLabel(pbs.getcustomer().getname());
		JLabel warehouse=new JLabel(pbs.getstock());
		JLabel totalMoney=new JLabel(String.valueOf(pbs.getmoney1()));
		JLabel note=new JLabel(pbs.getwords());
		JLabel operator=new JLabel(pbs.getop());
		
		customer.setBounds(337, 2, 100, 20);
		warehouse.setBounds(337, 21, 100, 20);
		totalMoney.setBounds(354, 38, 100, 20);
		note.setBounds(337, 54, 100, 20);
		operator.setBounds(354, 72, 100, 20);
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(customer,3);
		this.add(warehouse,4);
		this.add(totalMoney,5);
		this.add(note,6);
		this.add(operator,7);
		this.add(bg,8);
	}
	public JPBill(SaleSheetVO ss){
		
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=ss.getState();
		style=ss.getStyle();
		ID=ss.getid();
		//传递VO
		saleVO=ss;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		setBillBg(BillStyle.SaleSheet,ss.getState(),0);
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MouseListenerOfBill(BillStyle.SaleSheet));
		bg.addMouseListener(new MouseListenerGetXY());
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JTextField ID=new JTextField("ID:"+ss.getid(),JTextField.CENTER);
		ID.setOpaque(false);
		ID.setBorder(null);
		ID.setFont(new Font("",Font.BOLD,14));
		ID.setBounds(31,5, 200, 20);
		
		JLabel customer=new JLabel(ss.getcustomer().getname());
		JLabel totalMoney=new JLabel(String.valueOf(ss.getmoney1()));
		JLabel discount=new JLabel(String.valueOf(ss.getdiscount()));
		JLabel warehouse=new JLabel(ss.getstock());
		JLabel note=new JLabel(ss.getwords());
		JLabel operator=new JLabel(ss.getop());
		JLabel coupon=new JLabel(String.valueOf(ss.getmoney2()));
		JLabel finalMoney=new JLabel(String.valueOf(ss.getpmoney()));
		customer.setBounds(324,2, 100, 20);
		totalMoney.setBounds(341,21, 100, 20);
		discount.setBounds(324, 38, 100, 20);
		warehouse.setBounds(324, 55, 100, 20);
		note.setBounds(324,72, 100, 20);
		operator.setBounds(460, 4, 100, 20);
		coupon.setBounds(460, 21, 100, 20);
		finalMoney.setBounds(475,58, 100, 20);
		
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(customer,3);
		this.add(totalMoney,4);
		this.add(discount,5);
		this.add(warehouse,6);
		this.add(note,7);
		this.add(operator,8);
		this.add(coupon,9);
		this.add(finalMoney,10);
		this.add(bg,11);
	}
	public JPBill(SaleBackSheetVO sbs){
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=sbs.getState();
		style=sbs.getStyle();
		ID=sbs.getid();
		//传递VO
		salebackVO=sbs;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		setBillBg(BillStyle.SaleBackSheet,sbs.getState(),0);
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MouseListenerOfBill(BillStyle.SaleBackSheet));
		bg.addMouseListener(new MouseListenerGetXY());
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JTextField ID=new JTextField("ID:"+sbs.getid(),JTextField.CENTER);
		ID.setOpaque(false);
		ID.setBorder(null);
		ID.setFont(new Font("",Font.BOLD,14));
		ID.setBounds(31,5, 200, 20);
		
		JLabel customer=new JLabel(sbs.getcustomer().getname());
		JLabel totalMoney=new JLabel(String.valueOf(sbs.getmoney1()));
		JLabel discount=new JLabel(String.valueOf(sbs.getdiscount()));
		JLabel warehouse=new JLabel(sbs.getstock());
		JLabel note=new JLabel(sbs.getwords());
		JLabel operator=new JLabel(sbs.getop());
		JLabel coupon=new JLabel(String.valueOf(sbs.getmoney2()));
		JLabel finalMoney=new JLabel(String.valueOf(sbs.getpmoney()));
		
		customer.setBounds(324,2, 100, 20);
		totalMoney.setBounds(341,21, 100, 20);
		discount.setBounds(324, 38, 100, 20);
		warehouse.setBounds(324, 55, 100, 20);
		note.setBounds(324,72, 100, 20);
		operator.setBounds(460, 4, 100, 20);
		coupon.setBounds(460, 21, 100, 20);
		finalMoney.setBounds(475,58, 100, 20);
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(customer,3);
		this.add(totalMoney,4);
		this.add(discount,5);
		this.add(warehouse,6);
		this.add(note,7);
		this.add(operator,8);
		this.add(coupon,9);
		this.add(finalMoney,10);
		this.add(bg,11);
	}
	/*收款单构造界面*/
	public JPBill(ReceiptVO rb){
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=rb.getBillState();
		style=rb.getBillStyle();
		ID=rb.getID();
		//传递VO
		receiptVO=rb;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		setBillBg(BillStyle.ReceiptBill,rb.getBillState(),0);
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MouseListenerOfBill(BillStyle.ReceiptBill));
		bg.addMouseListener(new MouseListenerGetXY());
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JTextField ID=new JTextField("ID:"+rb.getID(),JTextField.CENTER);
		ID.setOpaque(false);
		ID.setBorder(null);
		ID.setFont(new Font("",Font.BOLD,14));
		ID.setBounds(31,5, 200, 20);
		//单据信息
		operatorOfPR.setBounds(345, 15, 150, 16);
		customerOfPR.setBounds(330, 33, 150, 16);
		moneyOfPR.setBounds(330, 49, 150, 16);
		
		operatorOfPR.setText(rb.getOp());
		customerOfPR.setText(rb.getCustomer());
		moneyOfPR.setText(String.valueOf(rb.getTotal()));
		listOfPR=new String[rb.getAccounts().size()][3];
		for(int i=0;i<rb.getAccounts().size();i++){
			listOfPR[i][0]=rb.getAccounts().get(i);
			listOfPR[i][1]=String.valueOf(rb.getMoney().get(i));
			listOfPR[i][2]=rb.getRemark().get(i);
		}
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(operatorOfPR,2);
		this.add(customerOfPR,3);
		this.add(moneyOfPR,4);
		this.add(ID,5);
		this.add(bg,6);
	}
	/*付款单构造界面*/
	public JPBill(PaymentVO pb){
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=pb.getBillState();
		style=pb.getBillStyle();
		ID=pb.getID();
		//传递VO
		payVO=pb;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		setBillBg(BillStyle.PaymentBill,pb.getBillState(),0);
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MouseListenerOfBill(BillStyle.PaymentBill));
		bg.addMouseListener(new MouseListenerGetXY());
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JTextField ID=new JTextField("ID:"+pb.getID(),JTextField.CENTER);
		ID.setOpaque(false);
		ID.setBorder(null);
		ID.setFont(new Font("",Font.BOLD,14));
		ID.setBounds(31,5, 200, 20);
		//单据信息
		operatorOfPR.setBounds(345, 15, 150, 16);
		customerOfPR.setBounds(330, 33, 150, 16);
		moneyOfPR.setBounds(330, 49,150, 16);
		
		operatorOfPR.setText(pb.getOp());
		customerOfPR.setText(pb.getCustomer());
		moneyOfPR.setText(String.valueOf(pb.getTotal()));
		listOfPR=new String[pb.getAccounts().size()][3];
		for(int i=0;i<pb.getAccounts().size();i++){
			listOfPR[i][0]=pb.getAccounts().get(i);
			listOfPR[i][1]=String.valueOf(pb.getMoney().get(i));
			listOfPR[i][2]=pb.getRemark().get(i);
		}
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(operatorOfPR,2);
		this.add(customerOfPR,3);
		this.add(moneyOfPR,4);
		this.add(ID,5);
		this.add(bg,6);
	}
	/*现金费用单构造界面*/
	public JPBill(CashPaymentVO cb){
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=cb.getBillState();
		style=cb.getBillStyle();
		ID=cb.getID();
		//传递VO
		cashVO=cb;
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		setBillBg(BillStyle.CashPaymentBill,cb.getBillState(),0);
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MouseListenerOfBill(BillStyle.CashPaymentBill));
		bg.addMouseListener(new MouseListenerGetXY());
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JTextField ID=new JTextField("ID:"+cb.getID(),JTextField.CENTER);
		ID.setOpaque(false);
		ID.setBorder(null);
		ID.setFont(new Font("",Font.BOLD,14));
		ID.setBounds(31,5, 200, 20);
		
		operatorOfCas.setBounds(345, 15, 150, 16);
		accountOfCas.setBounds(360, 33, 150, 16);
		moneyOfCas.setBounds(330, 49, 150, 16);
		
		operatorOfCas.setText(cb.getOp());
		accountOfCas.setText(cb.getAccount());
		moneyOfCas.setText(String.valueOf(cb.getTotal()));
		listOfCas=new String[cb.getItem().size()][3];
		for(int i=0;i<cb.getItem().size();i++){
			listOfCas[i][0]=cb.getItem().get(i);
			listOfCas[i][1]=String.valueOf(cb.getMoney().get(i));
			listOfCas[i][2]=cb.getRemark().get(i);
		}
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(operatorOfCas,2);
		this.add(accountOfCas,3);
		this.add(moneyOfCas,4);
		this.add(ID,5);
		this.add(bg,6);
	}
	//授权用户
	public void authorize(){
		userbl.authorized(userVO.getAccount());
	}
	//修改账户名
	public boolean change(String oldname, String newname){
		
		//调用逻辑层修改对应单据的数据
		boolean result=fbl.updateAccount(oldname, newname);
		return result;
	}
	//修改用户密码
	public boolean change(CustomerVO cus){
		
		//调用逻辑层修改对应单据的数据
		boolean result = false;
		result = customerbl.updateCustomer(cus);
		return result;
	}
	//修改用户密码
	public boolean change(UserVO us){
		
		//调用逻辑层修改对应单据的数据
		RM rm=userbl.changePassword(us);//修改密码
		if(rm==RM.done){
			return true;
		}
		return false;
	}
	//修改用户职务
	public boolean changeRole(UserVO us,Role r){
		
		//调用逻辑层修改对应单据的数据
		RM rm=userbl.changeRole(us, r);
		if(rm==RM.done){
			return true;
		}
		return false;
	}
	public void change(GiftBillVO gb){
	
		//调用逻辑层修改对应单据的数据
		stockbl.update(gb);
	}
	public void change(SpillsLossBillVO slb){
		//调用逻辑层修改对应单据的数据
		stockbl.update(slb);
	}
	public void change(AlertBillVO ab){
		//调用逻辑层修改对应单据的数据
		mbl.change(ab);
	}
	public void change(PurSheetVO ps){
		//调用逻辑层修改对应单据的数据
		sbl.updatePurSheet(ps);
	}
	public void change(PurBackSheetVO pbs){
		//调用逻辑层修改对应单据的数据
		sbl.updatePurBackSheet(pbs);
	}
	public void change(SaleSheetVO ss){
		//调用逻辑层修改对应单据的数据
		sbl.updateSaleSheet(ss);
	}
	public void change(SaleBackSheetVO sbs){
		//调用逻辑层修改对应单据的数据
		sbl.updateSaleBackSheet(sbs);
	}
	public void change(ReceiptVO rb){
		//调用逻辑层修改对应单据的数据
		fbl.updateReceipt(rb);
	}
	public void change(PaymentVO pb){
		//调用逻辑层修改对应单据的数据
		fbl.updatePayment(pb);
	}
	public void change(CashPaymentVO cb){
		//调用逻辑层修改对应单据的数据
		fbl.updateCashPayment(cb);
	}
	/*修改状态*/
	public void transformState(BillState st){
		//修改逻辑层的数据
		mbl.transformState(style, ID, st);
		//界面层
		state=st;
		//修改背景
		setBillBg(style,state,2);
	}
	/*根据条件生成地址给单据上背景*/
	public void setBillBg(BillStyle style,BillState state,int num){
		String s1="";
		String s2="";
		switch(style){
		case GiftBill:s1="GiftBill";
			break;
		case SpillsLossBill:s1="SpillsLossBill";
			break;
		case AlertBill:s1="AlertBill";
			break;
		case PurSheet:s1="PurSheet";
			break;
		case PurBackSheet:s1="PurBackSheet";
			break;
		case SaleSheet:s1="SaleSheet";
			break;
		case SaleBackSheet:s1="SaleBackSheet";
			break;
		case ReceiptBill:s1="Receiptbill";
			break;
		case PaymentBill:s1="Paymentbill";
			break;
		case CashPaymentBill:s1="CashPayment";
			break;
		}
		switch(state){
		case DRAFT:s2="1";
			break;
		case SUBMITED:s2="2";
			break;
		case EXAMINED:s2="3";
			break;
		case OVER:s2="4";
			break;
		}
		bg.setIcon(new ImageIcon("src/image/JPbill/"+s1+"/"+s1+s2+String.valueOf(num)+".png"));

		
	}
	/*看详细信息*/
	public void showDetail(){

		Thread t=new Thread(new TreadOfRight());
		t.start();
	}
	/*看简要信息*/
	public void showBrief(){
		Thread t=new Thread(new TreadOfLeft());
		t.start();
	}
	/*返回选中状态*/
	public boolean getChoose(){
		return choose;
	}
	/*获取清单表格的引用*/
	public void getTable(JTableOfList t){
		table=t;
	}
	public BillStyle getStyle() {
		return style;
	}
	public BillState getState() {
		return state;
	}
	public String getID() {
		return ID;
	}
	public JPbillType getType() {
		return Type;
	}
	public void setType(JPbillType type) {
		Type = type;
	}
	public AccountVO getAccountVO() {
		return accountVO;
	}
	public void setAccountVO(AccountVO accountVO) {
		this.accountVO = accountVO;
	}
	public class MouseListenerOfButton implements MouseListener{

		private int num;//1、右 2、左 
		public MouseListenerOfButton(int N){
			num=N;
		}
		public void mouseClicked(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			switch(num){
			case 1:
				right.setIcon(new ImageIcon("src/image/rightR.png"));
				//显示详细
				showDetail();
				break;
			case 2:left.setIcon(new ImageIcon("src/image/leftR.png"));
			    //显示简
			    showBrief();
				break;
			}
	
		}

		public void mouseReleased(MouseEvent e) {
			
			switch(num){
			case 1:
				right.setIcon(new ImageIcon("src/image/right.png"));
				break;
			case 2:left.setIcon(new ImageIcon("src/image/left.png"));
				break;
			}
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			switch(num){
			case 1:
				right.setIcon(new ImageIcon("src/image/right.png"));
				break;
			case 2:left.setIcon(new ImageIcon("src/image/left.png"));
				break;
			}
			
		}
		
	}

	public class TreadOfRight  implements Runnable{

		public void run() {
			int x=0;
			int y=(int)JPBill.this.getLocation().getY();
			while(x!=-261){
				if((x+261)>10){
					x-=10;
				}
				else{
					x=-261;
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				JPBill.this.setLocation(x, y);
			}
		}
		
	}
	
	public class TreadOfLeft  implements Runnable{

		public void run() {
			int x=-261;
			int y=(int)JPBill.this.getLocation().getY();
			while(x!=0){
				if((0-x)>10){
					x+=10;
				}
				else{
					x=0;
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				JPBill.this.setLocation(x, y);
			}
		}
		
	}

	public class MouseListenerOfBill implements MouseListener{

		private BillStyle st;
		
		public MouseListenerOfBill(BillStyle s){
			st=s;
			
		}
		public void mouseClicked(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			choose=!choose;//选中与取消选中
			if(choose){
				setBillBg(st,state,3);
			}
			else{
				setBillBg(st,state,1);
			}
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			if(choose){
				setBillBg(st,state,3);
			}
			else{
				setBillBg(st,state,1);
			}
			//悬停显示单据清单数据
			switch(style){
			case GiftBill:
				String[] temp1={"赠品","型号","数量"};
				table.setColumnNames(temp1);
				String[][] list1=new String[giftVO.getComs().size()][3];
				for(int i=0;i<giftVO.getComs().size();i++){
					list1[i][0]=giftVO.getComs().get(i).getName();
					list1[i][1]=giftVO.getComs().get(i).getModel();
					list1[i][2]=String.valueOf(giftVO.getComs().get(i).getNumber());
				}
				table.setList(list1);
				table.updateShow();
				break;
			case SpillsLossBill:
				break;
			case AlertBill:
				break;
			case PurSheet:
				String[] temp2={"编号","名称","型号","数量","单价","金额","备注"};
				table.setColumnNames(temp2);
				String[][] list2=new String[purVO.getsheet().size()][7];
				for(int i=0;i<purVO.getsheet().size();i++){
					list2[i][0]=purVO.getsheet().get(i).getId();
					list2[i][1]=purVO.getsheet().get(i).getName();
					list2[i][2]=purVO.getsheet().get(i).getModel();
					list2[i][3]=String.valueOf(purVO.getsheet().get(i).getNumber());
					list2[i][4]=String.valueOf(purVO.getsheet().get(i).getIn());
					list2[i][5]=String.valueOf(purVO.getsheet().get(i).getIn()*purVO.getsheet().get(i).getNumber());
					list2[i][6]=purVO.getcommoditywords().get(i);
				}
				table.setList(list2);
				table.updateShow();
				break;
			case PurBackSheet:
				String[] temp3={"编号","名称","型号","数量","单价","金额","备注"};
				table.setColumnNames(temp3);
				String[][] list3=new String[purbackVO.getsheet().size()][7];
				for(int i=0;i<purbackVO.getsheet().size();i++){
					list3[i][0]=purbackVO.getsheet().get(i).getId();
					list3[i][1]=purbackVO.getsheet().get(i).getName();
					list3[i][2]=purbackVO.getsheet().get(i).getModel();
					list3[i][3]=String.valueOf(purbackVO.getsheet().get(i).getNumber());
					list3[i][4]=String.valueOf(purbackVO.getsheet().get(i).getIn());
					list3[i][5]=String.valueOf(purbackVO.getsheet().get(i).getIn()*purbackVO.getsheet().get(i).getNumber());
					list3[i][6]=purbackVO.getcommoditywords().get(i);
				}
				table.setList(list3);
				table.updateShow();
				break;
			case SaleSheet:
				String[] temp4={"编号","名称","型号","数量","单价","金额","备注"};
				table.setColumnNames(temp4);
				String[][] list4=new String[saleVO.getsheet().size()][7];
				for(int i=0;i<saleVO.getsheet().size();i++){
					list4[i][0]=saleVO.getsheet().get(i).getId();
					list4[i][1]=saleVO.getsheet().get(i).getName();
					list4[i][2]=saleVO.getsheet().get(i).getModel();
					list4[i][3]=String.valueOf(saleVO.getsheet().get(i).getNumber());
					list4[i][4]=String.valueOf(saleVO.getsheet().get(i).getOut());
					list4[i][5]=String.valueOf(saleVO.getsheet().get(i).getOut()*saleVO.getsheet().get(i).getNumber());
					list4[i][6]=saleVO.getcommoditywords().get(i);
				}
				table.setList(list4);
				table.updateShow();
				break;
			case SaleBackSheet:
				String[] temp5={"编号","名称","型号","数量","单价","金额","备注"};
				table.setColumnNames(temp5);
				String[][] list5=new String[salebackVO.getsheet().size()][7];
				for(int i=0;i<salebackVO.getsheet().size();i++){
					list5[i][0]=salebackVO.getsheet().get(i).getId();
					list5[i][1]=salebackVO.getsheet().get(i).getName();
					list5[i][2]=salebackVO.getsheet().get(i).getModel();
					list5[i][3]=String.valueOf(salebackVO.getsheet().get(i).getNumber());
					list5[i][4]=String.valueOf(salebackVO.getsheet().get(i).getOut());
					list5[i][5]=String.valueOf(salebackVO.getsheet().get(i).getOut()*salebackVO.getsheet().get(i).getNumber());
					list5[i][6]=salebackVO.getcommoditywords().get(i);
				}
				table.setList(list5);
				table.updateShow();
				break;
			case ReceiptBill:
				String[] temp6={"银行账户","转账金额","备注"};
				table.setColumnNames(temp6);
				table.setList(listOfPR);
				table.updateShow();
				break;
			case PaymentBill:
				String[] temp7={"银行账户","转账金额","备注"};
				table.setColumnNames(temp7);
				table.setList(listOfPR);
				table.updateShow();
				break;
			case CashPaymentBill:
				String[] temp8={"条目名","金额","备注"};
				table.setColumnNames(temp8);
				table.setList(listOfCas);
				table.updateShow();
				break;
			}
		}

		public void mouseExited(MouseEvent e) {
			if(choose){
				setBillBg(st,state,2);
			}
			else{
				setBillBg(st,state,0);
			}
		}
		
	}
	public CustomerVO getCustomerVO() {
		return customerVO;
	}
	public void setCustomerVO(CustomerVO customerVO) {
		this.customerVO = customerVO;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	public enum JPbillType {

		Bill,
		Strategy,
		Account,
		Customer,
		User,
		Default
	}
	public JLabel getRight() {
		return right;
	}
	public void setRight(JLabel right) {
		this.right = right;
	}
	public GiftBillVO getGiftVO() {
		return giftVO;
	}
	public void setGiftVO(GiftBillVO giftVO) {
		this.giftVO = giftVO;
	}
	public AlertBillVO getAlertVO() {
		return alertVO;
	}
	public void setAlertVO(AlertBillVO alertVO) {
		this.alertVO = alertVO;
	}
	public SpillsLossBillVO getSpillsLossVO() {
		return spillsLossVO;
	}
	public void setSpillsLossVO(SpillsLossBillVO spillsLossVO) {
		this.spillsLossVO = spillsLossVO;
	}
	public PurSheetVO getPurVO() {
		return purVO;
	}
	public void setPurVO(PurSheetVO purVO) {
		this.purVO = purVO;
	}
	public PurBackSheetVO getPurbackVO() {
		return purbackVO;
	}
	public void setPurbackVO(PurBackSheetVO purbackVO) {
		this.purbackVO = purbackVO;
	}
	public SaleSheetVO getSaleVO() {
		return saleVO;
	}
	public void setSaleVO(SaleSheetVO saleVO) {
		this.saleVO = saleVO;
	}
	public CashPaymentVO getCashVO() {
		return cashVO;
	}
	public void setCashVO(CashPaymentVO cashVO) {
		this.cashVO = cashVO;
	}
	public PaymentVO getPayVO() {
		return payVO;
	}
	public void setPayVO(PaymentVO payVO) {
		this.payVO = payVO;
	}
	public ReceiptVO getReceiptVO() {
		return receiptVO;
	}
	public void setReceiptVO(ReceiptVO receiptVO) {
		this.receiptVO = receiptVO;
	}
	public SaleBackSheetVO getSalebackVO() {
		return salebackVO;
	}
	public void setSalebackVO(SaleBackSheetVO salebackVO) {
		this.salebackVO = salebackVO;
	}
	public void setState(BillState state)
	{
		this.state = state;
	}

}
