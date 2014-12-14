package presentation.managerui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		//单据信息未完
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(BarginStrategyVO bs){
		
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
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(ReachStrategyVO rs){
		
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
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(SpillsLossBillVO slb){
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
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(AlertBillVO ab){
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
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(PurSheetVO ps){
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
		
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(PurBackSheetVO pbs){
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
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(SaleSheetVO ss){
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
		
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	public JPBill(SaleBackSheetVO sbs){
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
		
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(ID,2);
		this.add(bg,3);
	}
	/*收款单构造界面*/
	public JPBill(ReceiptVO rb){
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
		mbl.change(gb);
	}
	public void change(SpillsLossBillVO slb){
		//调用逻辑层修改对应单据的数据
		mbl.change(slb);
	}
	public void change(AlertBillVO ab){
		//调用逻辑层修改对应单据的数据
		mbl.change(ab);
	}
	public void change(PurSheetVO ps){
		//调用逻辑层修改对应单据的数据
		mbl.change(ps);
	}
	public void change(PurBackSheetVO pbs){
		//调用逻辑层修改对应单据的数据
		mbl.change(pbs);
	}
	public void change(SaleSheetVO ss){
		//调用逻辑层修改对应单据的数据
		mbl.change(ss);
	}
	public void change(SaleBackSheetVO sbs){
		//调用逻辑层修改对应单据的数据
		mbl.change(sbs);
	}
	public void change(ReceiptVO rb){
		//调用逻辑层修改对应单据的数据
		mbl.change(rb);
//		if(!rb.getOp().equals("")){
//			 operatorOfPR.setText(rb.getOp());
//		}
//		 if(!rb.getCustomer().equals("")){//如果vo对象里的账户属性不为空
//			 customerOfPR.setText(rb.getCustomer());
//		 }
//		 if(rb.getTotal()!=0){//如果vo对象里的账户属性不为空
//			 moneyOfPR.setText(String.valueOf(rb.getTotal()));
//		 }
	}
	public void change(PaymentVO pb){
		//调用逻辑层修改对应单据的数据
		mbl.change(pb);
		//根据内存中单据的数据重新设置面板界面
//		if(!pb.getOp().equals("")){
//			 operatorOfPR.setText(pb.getOp());
//		}
//		 if(!pb.getCustomer().equals("")){//如果vo对象里的账户属性不为空
//			 customerOfPR.setText(pb.getCustomer());
//		 }
//		 if(pb.getTotal()!=0){//如果vo对象里的账户属性不为空
//			 moneyOfPR.setText(String.valueOf(pb.getTotal()));
//		 }
	}
	public void change(CashPaymentVO cb){
		//调用逻辑层修改对应单据的数据
		mbl.change(cb);
		//根据内存中单据的数据重新设置面板界面
		
//		if(!cb.getOp().equals("")){
//			 operatorOfCas.setText(cb.getOp());
//		}
//		 if(!cb.getAccount().equals("")){//如果vo对象里的账户属性不为空
//			 accountOfCas.setText(cb.getAccount());
//		 }
//		 if(cb.getTotal()!=0){//如果vo对象里的账户属性不为空
//			 moneyOfCas.setText(String.valueOf(cb.getTotal()));
//		 }
		 
		 
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
