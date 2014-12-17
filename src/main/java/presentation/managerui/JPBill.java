package presentation.managerui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.commodityui.StockManagerDriver;
import data.commoditydata.StubStockDataController;
import vo.AlertBillVO;
import vo.BarginStrategyVO;
import vo.GiftBillVO;
import vo.LevelStrategyVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.ReachStrategyVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.SpillsLossBillVO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.StrategyStyle;
import businesslogic.financialbl.Financial;
import businesslogic.managerbl.StubManager;
import businesslogic.salebillbl.salebillController;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.commodityblservice.StubCommodityBlService;
import businesslogicservice.financialblservice.FinancialBlService;
import businesslogicservice.managerblservice.StubManagerBlService;
import businesslogicservice.salebillblservice.SaleBillBlService;

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

	//逻辑层的接口
	StubManagerBlService mbl=new StubManager();
	FinancialBlService fbl=new Financial();
	 SaleBillBlService sbl=new salebillController();
	 StubCommodityBlService stockbl=new StubStockController();
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
		System.out.println("构造一条客户策略");
		//逻辑层接口
		StockManagerDriver smd=new StockManagerDriver();
		smd.start(stockbl,StubStockDataController.getInstance());
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
		bg.addMouseListener(new MLofStartegy(1));
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JLabel ID=new JLabel("ID:"+ls.getID(),JLabel.CENTER);
		ID.setBounds(31,5, 200, 20);
		
		JLabel level=new JLabel();
		JLabel limit=new JLabel();
		JLabel discount=new JLabel();
		JLabel coupon=new JLabel();
		JLabel start=new JLabel();
		JLabel last=new JLabel();
		
		JLabel levelTxt=new JLabel(String.valueOf(ls.getLevel()));
		JLabel startTxt=new JLabel(ls.getStartTime());
		JLabel lastTxt=new JLabel(String.valueOf(ls.getLastTime()));
		
		//设置标签字体
		level.setFont(new Font("宋体",Font.BOLD,14));
		limit.setFont(new Font("宋体",Font.BOLD,14));
		discount.setFont(new Font("宋体",Font.BOLD,14));
		coupon.setFont(new Font("宋体",Font.BOLD,14));
		start.setFont(new Font("宋体",Font.BOLD,14));
		last.setFont(new Font("宋体",Font.BOLD,14));
		
		
		//设置字体颜色
		level.setForeground(Color.white);
		limit.setForeground(Color.white);
		discount.setForeground(Color.white);
		coupon.setForeground(Color.white);
		start.setForeground(Color.white);
		last.setForeground(Color.white);
		
		//单据信息未完
		switch(ls.getLevel_strategy_style()){
		case Gift:
			JLabel limitTxt=new JLabel(String.valueOf(ls.getLimit()));
			break;
		case Discount://打折
			JLabel discountTxt=new JLabel(String.valueOf(ls.getDiscountrate()));
			break;
		case Coupon://代金券
			JLabel couponTxt=new JLabel(String.valueOf(ls.getCouponrate()));
			break;
		}
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(BarginStrategyVO bs){
		//区分面板种类
		setType(JPbillType.Strategy);
		System.out.println("构造一条特价包策略");
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
		bg.addMouseListener(new MLofStartegy(2));
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JLabel ID=new JLabel("ID:"+bs.getID(),JLabel.CENTER);
		ID.setBounds(31,5, 200, 20);
		
		//单据信息未完
		JLabel originalTotalPrice=new JLabel();
		JLabel decreasePrice=new JLabel();
		JLabel num=new JLabel();
		JLabel start=new JLabel();
		JLabel last=new JLabel();
		
		int originalTotal=0;
		for(int i=0;i<bs.getAlOfCommodity().size();i++){
			originalTotal+=bs.getAlOfCommodity().get(i).getOut();
		}
		//单据信息未完
		JLabel originalTotalPriceTxt=new JLabel(String.valueOf(originalTotal));
		JLabel decreasePriceTxt=new JLabel(String.valueOf(bs.getDiscount()));
		JLabel numTxt=new JLabel(String.valueOf(bs.getNum()));
		JLabel startTxt=new JLabel(bs.getStartTime());
		JLabel lastTxt=new JLabel(String.valueOf(bs.getLastTime()));
		//字体
		originalTotalPrice.setFont(new Font("宋体",Font.BOLD,14));
		decreasePrice.setFont(new Font("宋体",Font.BOLD,14));
		num.setFont(new Font("宋体",Font.BOLD,14));
		start.setFont(new Font("宋体",Font.BOLD,14));
		last.setFont(new Font("宋体",Font.BOLD,14));
		//字体颜色
		originalTotalPrice.setForeground(Color.white);
		decreasePrice.setForeground(Color.white);
		num.setForeground(Color.white);
		start.setForeground(Color.white);
		last.setForeground(Color.white);
		
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(ReachStrategyVO rs){
		//区分面板种类
		setType(JPbillType.Strategy);
		System.out.println("构造一条满额策略");
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
		bg.addMouseListener(new MLofStartegy(3));
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//单据信息
		JLabel ID=new JLabel("ID:"+rs.getID(),JLabel.CENTER);
		ID.setBounds(31,5, 200, 20);
		
		//单据信息未完
		JLabel limit=new JLabel();
		JLabel coupon=new JLabel();
		JLabel start=new JLabel();
		JLabel last=new JLabel();
		
		JLabel limitTxt=new JLabel(String.valueOf(rs.getLimit()));
		
		JLabel startTxt=new JLabel(rs.getStartTime());
		JLabel lastTxt=new JLabel(String.valueOf(rs.getLastTime()));
		//设置标签字体
		limit.setFont(new Font("宋体",Font.BOLD,14));
		coupon.setFont(new Font("宋体",Font.BOLD,14));
		start.setFont(new Font("宋体",Font.BOLD,14));
		last.setFont(new Font("宋体",Font.BOLD,14));
		
		//设置字体颜色
		limit.setForeground(Color.white);
		coupon.setForeground(Color.white);
		start.setForeground(Color.white);
		last.setForeground(Color.white);
		
		switch(rs.getReach_strategy_style()){
		case Gift://赠品
			
			break;
		case Coupon://代金券
			JLabel couponTxt=new JLabel(String.valueOf(rs.getCouponrate()));
			break;
		}
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
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
	public class MLofStartegy implements MouseListener{

		private int num;//1、客户策略2、特价包策略3、满额策略
		public MLofStartegy(int N){
			num=N;
		}
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
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
				}
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
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
				}
			}
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
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
		JLabel ID=new JLabel("ID:"+gb.getID(),JLabel.CENTER);
		ID.setBounds(31,5, 200, 20);
		
		//单据信息未完
		String[] remark=gb.getRemark();
		JLabel reason=new JLabel(remark[0]);
		JLabel customer=new JLabel(remark[1]);
		
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(SpillsLossBillVO slb){
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=slb.getState();
		style=slb.getBillStyle();
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
		JLabel ID=new JLabel("ID:"+slb.getID(),JLabel.CENTER);
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
		
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(AlertBillVO ab){
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=ab.getState();
		style=ab.getBillStyle();
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
		JLabel ID=new JLabel("ID:"+ab.getID(),JLabel.CENTER);
		ID.setBounds(31,5, 200, 20);
		
		JLabel commodity=new JLabel(ab.getCom().getName());
		JLabel model=new JLabel(ab.getCom().getModel());
		JLabel num=new JLabel(String.valueOf(ab.getCom().getNumber()));
		
		
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(PurSheetVO ps){
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=ps.getState();
		style=ps.getBillStyle();
		ID=ps.getID();
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
		JLabel ID=new JLabel("ID:"+ps.getID(),JLabel.CENTER);
		ID.setBounds(31,5, 200, 20);
		
		JLabel customer=new JLabel(ps.getcustomer().getname());
		JLabel warehouse=new JLabel(ps.getstock());
		JLabel totalMoney=new JLabel(String.valueOf(ps.getmoney1()));
		JLabel note=new JLabel(ps.getwords());
		JLabel operator=new JLabel(ps.getop());
		
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(PurBackSheetVO pbs){
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=pbs.getState();
		style=pbs.getBillStyle();
		ID=pbs.getID();
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
		JLabel ID=new JLabel("ID:"+pbs.getID(),JLabel.CENTER);
		ID.setBounds(31,5, 200, 20);
		
		JLabel customer=new JLabel(pbs.getcustomer().getname());
		JLabel warehouse=new JLabel(pbs.getstock());
		JLabel totalMoney=new JLabel(String.valueOf(pbs.getmoney1()));
		JLabel note=new JLabel(pbs.getwords());
		JLabel operator=new JLabel(pbs.getop());
		
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(SaleSheetVO ss){
		
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=ss.getState();
		style=ss.getBillStyle();
		ID=ss.getID();
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
		JLabel ID=new JLabel("ID:"+ss.getID(),JLabel.CENTER);
		ID.setBounds(31,5, 200, 20);
		
		JLabel customer=new JLabel(ss.getcustomer().getname());
		JLabel totalMoney=new JLabel(String.valueOf(ss.getmoney1()));
		JLabel discount=new JLabel(String.valueOf(ss.getdiscount()));
		JLabel warehouse=new JLabel(ss.getstock());
		JLabel note=new JLabel(ss.getwords());
		JLabel operator=new JLabel(ss.getop());
		JLabel coupon=new JLabel(String.valueOf(ss.getmoney2()));
		JLabel finalMoney=new JLabel(String.valueOf(ss.getpmoney()));
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(SaleBackSheetVO sbs){
		//区分面板种类
		setType(JPbillType.Bill);
		//设置单据编号，状态，种类
		state=sbs.getState();
		style=sbs.getBillStyle();
		ID=sbs.getID();
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
		JLabel ID=new JLabel("ID:"+sbs.getID(),JLabel.CENTER);
		ID.setBounds(31,5, 200, 20);
		
		JLabel customer=new JLabel(sbs.getcustomer().getname());
		JLabel totalMoney=new JLabel(String.valueOf(sbs.getmoney1()));
		JLabel discount=new JLabel(String.valueOf(sbs.getdiscount()));
		JLabel warehouse=new JLabel(sbs.getstock());
		JLabel note=new JLabel(sbs.getwords());
		JLabel operator=new JLabel(sbs.getop());
		JLabel coupon=new JLabel(String.valueOf(sbs.getmoney2()));
		JLabel finalMoney=new JLabel(String.valueOf(sbs.getpmoney()));
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
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
		operatorOfPR.setBounds(345, 15, 50, 16);
		customerOfPR.setBounds(330, 33, 50, 16);
		moneyOfPR.setBounds(330, 49, 50, 16);
		
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
		this.add(bg,5);
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
		operatorOfPR.setBounds(345, 15, 50, 16);
		customerOfPR.setBounds(330, 33, 50, 16);
		moneyOfPR.setBounds(330, 49, 50, 16);
		
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
		this.add(bg,5);
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
		JLabel ID=new JLabel("ID:"+cb.getID(),JLabel.CENTER);
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
		System.out.println("修改后状态"+state);
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
	public class MouseListenerOfButton implements MouseListener{

		private int num;//1、右 2、左 
		public MouseListenerOfButton(int N){
			num=N;
		}
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
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
			// TODO Auto-generated method stub
			
			switch(num){
			case 1:
				right.setIcon(new ImageIcon("src/image/right.png"));
				break;
			case 2:left.setIcon(new ImageIcon("src/image/left.png"));
				break;
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
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
			// TODO Auto-generated method stub
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JPBill.this.setLocation(x, y);
			}
		}
		
	}
	
	public class TreadOfLeft  implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
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
					// TODO Auto-generated catch block
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
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			choose=!choose;//选中与取消选中
			System.out.println(state);
			if(choose){
				setBillBg(st,state,3);
			}
			else{
				setBillBg(st,state,1);
			}
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
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
//					list2[i][6]=purVO.getsheet().get(i);
				}
				table.setList(list2);
				table.updateShow();
				break;
			case PurBackSheet:
				String[] temp3={"编号","名称","型号","数量","单价","金额","备注"};
				table.setColumnNames(temp3);
				String[][] list3=new String[purbackVO.getsheet().size()][7];
				for(int i=0;i<purVO.getsheet().size();i++){
					list3[i][0]=purVO.getsheet().get(i).getId();
					list3[i][1]=purVO.getsheet().get(i).getName();
					list3[i][2]=purVO.getsheet().get(i).getModel();
					list3[i][3]=String.valueOf(purVO.getsheet().get(i).getNumber());
					list3[i][4]=String.valueOf(purVO.getsheet().get(i).getIn());
					list3[i][5]=String.valueOf(purVO.getsheet().get(i).getIn()*purVO.getsheet().get(i).getNumber());
//					list3[i][6]=purVO.getsheet().get(i);
				}
				table.setList(list3);
				table.updateShow();
				break;
			case SaleSheet:
				String[] temp4={"编号","名称","型号","数量","单价","金额","备注"};
				table.setColumnNames(temp4);
				String[][] list4=new String[saleVO.getsheet().size()][7];
				for(int i=0;i<purVO.getsheet().size();i++){
					list4[i][0]=purVO.getsheet().get(i).getId();
					list4[i][1]=purVO.getsheet().get(i).getName();
					list4[i][2]=purVO.getsheet().get(i).getModel();
					list4[i][3]=String.valueOf(purVO.getsheet().get(i).getNumber());
					list4[i][4]=String.valueOf(purVO.getsheet().get(i).getOut());
					list4[i][5]=String.valueOf(purVO.getsheet().get(i).getOut()*purVO.getsheet().get(i).getNumber());
//					list4[i][6]=purVO.getsheet().get(i);
				}
				table.setList(list4);
				table.updateShow();
				break;
			case SaleBackSheet:
				String[] temp5={"编号","名称","型号","数量","单价","金额","备注"};
				table.setColumnNames(temp5);
				String[][] list5=new String[salebackVO.getsheet().size()][7];
				for(int i=0;i<purVO.getsheet().size();i++){
					list5[i][0]=purVO.getsheet().get(i).getId();
					list5[i][1]=purVO.getsheet().get(i).getName();
					list5[i][2]=purVO.getsheet().get(i).getModel();
					list5[i][3]=String.valueOf(purVO.getsheet().get(i).getNumber());
					list5[i][4]=String.valueOf(purVO.getsheet().get(i).getOut());
					list5[i][5]=String.valueOf(purVO.getsheet().get(i).getOut()*purVO.getsheet().get(i).getNumber());
//					list5[i][6]=purVO.getsheet().get(i);
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
			// TODO Auto-generated method stub
			if(choose){
				setBillBg(st,state,2);
			}
			else{
				setBillBg(st,state,0);
			}
		}
		
	}
}
