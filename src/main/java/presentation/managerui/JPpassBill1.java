package presentation.managerui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import po.BillStyle;
import userui.Frame;
import businesslogic.managerbl.StubManager;
import businesslogicservice.managerblservice.StubManagerBlService;

public class JPpassBill1 extends JPanel {

	private JLabel giftBill = new JLabel("New label");
	private JLabel alertBill = new JLabel("New label");
	private JLabel spoilbill = new JLabel("New label");
	
	private JLabel receivebill = new JLabel("New label");
	private JLabel paymentbill = new JLabel("New label");
	private JLabel crashbill = new JLabel("New label");
	
	private JLabel purchasebill = new JLabel("New label");
	private JLabel purchasebackbill = new JLabel("New label");
	private JLabel salebill = new JLabel("New label");
	private JLabel salebackbill = new JLabel("New label");
	//frame的引用
    Frame frame;
    //逻辑层接口
    StubManagerBlService mbl=new StubManager();
	public JPpassBill1(){
		//设置窗口大小
		this.setSize(445, 330);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		JLabel bg = new JLabel("New label");
		bg.setIcon(new ImageIcon("src\\image\\passBill\\passBillBlock1.png"));
		bg.setBounds(0, 0, 445, 330);
	
		
		
		giftBill.setIcon(new ImageIcon("src\\image\\bill\\giftbill0.png"));
		giftBill.setBounds(10, 15, 100, 100);
		giftBill.addMouseListener(new MouseListenOfButton(11));
		add(giftBill,0);
		
		
		alertBill.setIcon(new ImageIcon("src\\image\\bill\\alertbill0.png"));
		alertBill.setBounds(115, 15, 100, 100);
		alertBill.addMouseListener(new MouseListenOfButton(12));
		add(alertBill,1);
		
		
		spoilbill.setIcon(new ImageIcon("src\\image\\bill\\spoilbill0.png"));
		spoilbill.setBounds(220, 15, 100, 100);
		spoilbill.addMouseListener(new MouseListenOfButton(13));
		add(spoilbill,2);
		
		
		receivebill.setIcon(new ImageIcon("src\\image\\bill\\receivebill0.png"));
		receivebill.setBounds(10, 115, 100, 100);
		receivebill.addMouseListener(new MouseListenOfButton(21));
		add(receivebill,3);
		
		
		paymentbill.setIcon(new ImageIcon("src\\image\\bill\\paymentbill0.png"));
		paymentbill.setBounds(115, 115, 100, 100);
		paymentbill.addMouseListener(new MouseListenOfButton(22));
		add(paymentbill,4);
		
		
		crashbill.setIcon(new ImageIcon("src\\image\\bill\\crashbill0.png"));
		crashbill.setBounds(220, 115, 100, 100);
		crashbill.addMouseListener(new MouseListenOfButton(23));
		add(crashbill,5);
		
		
		purchasebill.setIcon(new ImageIcon("src\\image\\bill\\purchasebill0.png"));
		purchasebill.setBounds(10, 215, 100, 100);
		purchasebill.addMouseListener(new MouseListenOfButton(31));
		add(purchasebill,6);
		
		
		purchasebackbill.setIcon(new ImageIcon("src\\image\\bill\\purchasebackbill0.png"));
		purchasebackbill.setBounds(115, 215, 100, 100);
		purchasebackbill.addMouseListener(new MouseListenOfButton(32));
		add(purchasebackbill,7);
		
		
		salebill.setIcon(new ImageIcon("src\\image\\bill\\salebill0.png"));
		salebill.setBounds(220, 215, 100, 100);
		salebill.addMouseListener(new MouseListenOfButton(33));
		add(salebill,8);
		
		
		salebackbill.setIcon(new ImageIcon("src\\image\\bill\\salebackbill0.png"));
		salebackbill.setBounds(325, 215, 100, 100);
		salebackbill.addMouseListener(new MouseListenOfButton(34));
		add(salebackbill,9);
		
		add(bg,10);
	}
	/*获取frame的引用*/
	public void getFrame( Frame f){
  		frame=f;
    }
	public class MouseListenOfButton implements MouseListener{

		private int num;
		public MouseListenOfButton(int N){
			num=N;
		}
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 11:
				giftBill.setIcon(new ImageIcon("src\\image\\bill\\giftbill1.png"));
				break;
			case 12:alertBill.setIcon(new ImageIcon("src\\image\\bill\\alertbill1.png"));
				break;
			case 13:spoilbill.setIcon(new ImageIcon("src\\image\\bill\\spoilbill1.png"));
				break;
			case 21:receivebill.setIcon(new ImageIcon("src\\image\\bill\\receivebill1.png"));
				break;
			case 22:paymentbill.setIcon(new ImageIcon("src\\image\\bill\\paymentbill1.png"));
				break;
			case 23:crashbill.setIcon(new ImageIcon("src\\image\\bill\\crashbill1.png"));
				break;
			case 31:purchasebill.setIcon(new ImageIcon("src\\image\\bill\\purchasebill1.png"));
				break;
			case 32:purchasebackbill.setIcon(new ImageIcon("src\\image\\bill\\purchasebackbill1.png"));
				break;
			case 33:salebill.setIcon(new ImageIcon("src\\image\\bill\\salebill1.png"));
				break;
			case 34:salebackbill.setIcon(new ImageIcon("src\\image\\bill\\salebackbill1.png"));
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 11:
				giftBill.setIcon(new ImageIcon("src\\image\\bill\\giftbill.png"));
				//切换
				JPpassBill1.this.setVisible(false);
				//设置单据类型
				frame.getManager().getPassbill2().setStyle(BillStyle.GiftBill);
				//从逻辑层读取单据信息填充单据列表
				frame.getManager().getPassbill2().getBillList().getJPbillList().clear();
				frame.getManager().getPassbill2().getBillList().reHome();
				frame.getManager().getPassbill2().getBillList().addGiftBillList(mbl.getGiftBill());
				//切换
				frame.getManager().getPassbill2().setVisible(true);
				break;
			case 12:
				alertBill.setIcon(new ImageIcon("src\\image\\bill\\alertbill.png"));
				//切换
				JPpassBill1.this.setVisible(false);
				//设置单据类型
				frame.getManager().getPassbill2().setStyle(BillStyle.AlertBill);
				//从逻辑层读取单据信息填充单据列表
				frame.getManager().getPassbill2().getBillList().getJPbillList().clear();
				frame.getManager().getPassbill2().getBillList().reHome();
				frame.getManager().getPassbill2().getBillList().addAlertBillList(mbl.getAlertBill());
				//切换
				frame.getManager().getPassbill2().setVisible(true);
				break;
			case 13:spoilbill.setIcon(new ImageIcon("src\\image\\bill\\spoilbill.png"));
				//切换
				JPpassBill1.this.setVisible(false);
				//设置单据类型
				frame.getManager().getPassbill2().setStyle(BillStyle.SpillsLossBill);
				//从逻辑层读取单据信息填充单据列表
				frame.getManager().getPassbill2().getBillList().getJPbillList().clear();
				frame.getManager().getPassbill2().getBillList().reHome();
				frame.getManager().getPassbill2().getBillList().addSpillsLossBillList(mbl.getSpillsLossBill());
				//切换
				frame.getManager().getPassbill2().setVisible(true);
				break;
			case 21:receivebill.setIcon(new ImageIcon("src\\image\\bill\\receivebill.png"));
				//切换
				JPpassBill1.this.setVisible(false);
				//设置单据类型
				frame.getManager().getPassbill2().setStyle(BillStyle.ReceiptBill);
				//从逻辑层读取单据信息填充单据列表
				frame.getManager().getPassbill2().getBillList().getJPbillList().clear();
				frame.getManager().getPassbill2().getBillList().reHome();
				frame.getManager().getPassbill2().getBillList().addReceiptBillList(mbl.getReceiptBill());
				//切换
				frame.getManager().getPassbill2().setVisible(true);
				break;
			case 22:paymentbill.setIcon(new ImageIcon("src\\image\\bill\\paymentbill.png"));
				//切换
				JPpassBill1.this.setVisible(false);
				//设置单据类型
				frame.getManager().getPassbill2().setStyle(BillStyle.PaymentBill);
				//从逻辑层读取单据信息填充单据列表
				frame.getManager().getPassbill2().getBillList().getJPbillList().clear();
				frame.getManager().getPassbill2().getBillList().reHome();
				frame.getManager().getPassbill2().getBillList().addPaymentBillList(mbl.getPaymentBill());
				//切换
				frame.getManager().getPassbill2().setVisible(true);
				break;
			case 23:crashbill.setIcon(new ImageIcon("src\\image\\bill\\crashbill.png"));
				//切换
				JPpassBill1.this.setVisible(false);
				//设置单据类型
				frame.getManager().getPassbill2().setStyle(BillStyle.CashPaymentBill);
				//从逻辑层读取单据信息填充单据列表
				frame.getManager().getPassbill2().getBillList().getJPbillList().clear();
				frame.getManager().getPassbill2().getBillList().reHome();
				frame.getManager().getPassbill2().getBillList().addCashPaymentBillList(mbl.getCashPaymentBill());
				//切换
				frame.getManager().getPassbill2().setVisible(true);
				break;
			case 31:purchasebill.setIcon(new ImageIcon("src\\image\\bill\\purchasebill.png"));
				//切换
				JPpassBill1.this.setVisible(false);
				//设置单据类型
				frame.getManager().getPassbill2().setStyle(BillStyle.PurSheet);
				//从逻辑层读取单据信息填充单据列表
				frame.getManager().getPassbill2().getBillList().getJPbillList().clear();
				frame.getManager().getPassbill2().getBillList().reHome();
				frame.getManager().getPassbill2().getBillList().addPurSheetList(mbl.getPurSheet());
				//切换
				frame.getManager().getPassbill2().setVisible(true);
				break;
			case 32:purchasebackbill.setIcon(new ImageIcon("src\\image\\bill\\purchasebackbill.png"));
				//切换
				JPpassBill1.this.setVisible(false);
				//设置单据类型
				frame.getManager().getPassbill2().setStyle(BillStyle.PurBackSheet);
				//从逻辑层读取单据信息填充单据列表
				frame.getManager().getPassbill2().getBillList().getJPbillList().clear();
				frame.getManager().getPassbill2().getBillList().reHome();
				frame.getManager().getPassbill2().getBillList().addPurBackSheetList(mbl.getPurBackSheet());
				//切换
				frame.getManager().getPassbill2().setVisible(true);
				break;
			case 33:salebill.setIcon(new ImageIcon("src\\image\\bill\\salebill.png"));
				//切换
				JPpassBill1.this.setVisible(false);
				//设置单据类型
				frame.getManager().getPassbill2().setStyle(BillStyle.SaleSheet);
				//从逻辑层读取单据信息填充单据列表
				frame.getManager().getPassbill2().getBillList().getJPbillList().clear();
				frame.getManager().getPassbill2().getBillList().reHome();
				frame.getManager().getPassbill2().getBillList().addSaleSheetList(mbl.getSaleSheet());
				//切换
				frame.getManager().getPassbill2().setVisible(true);
				break;
			case 34:salebackbill.setIcon(new ImageIcon("src\\image\\bill\\salebackbill.png"));
				//切换
				JPpassBill1.this.setVisible(false);
				//设置单据类型
				frame.getManager().getPassbill2().setStyle(BillStyle.SaleBackSheet);
				//从逻辑层读取单据信息填充单据列表
				frame.getManager().getPassbill2().getBillList().getJPbillList().clear();
				frame.getManager().getPassbill2().getBillList().reHome();
				frame.getManager().getPassbill2().getBillList().addSaleBackSheetList(mbl.getSaleBackSheet());
				//切换
				frame.getManager().getPassbill2().setVisible(true);
				break;
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 11:
				giftBill.setIcon(new ImageIcon("src\\image\\bill\\giftbill.png"));
				break;
			case 12:alertBill.setIcon(new ImageIcon("src\\image\\bill\\alertbill.png"));
				break;
			case 13:spoilbill.setIcon(new ImageIcon("src\\image\\bill\\spoilbill.png"));
				break;
			case 21:receivebill.setIcon(new ImageIcon("src\\image\\bill\\receivebill.png"));
				break;
			case 22:paymentbill.setIcon(new ImageIcon("src\\image\\bill\\paymentbill.png"));
				break;
			case 23:crashbill.setIcon(new ImageIcon("src\\image\\bill\\crashbill.png"));
				break;
			case 31:purchasebill.setIcon(new ImageIcon("src\\image\\bill\\purchasebill.png"));
				break;
			case 32:purchasebackbill.setIcon(new ImageIcon("src\\image\\bill\\purchasebackbill.png"));
				break;
			case 33:salebill.setIcon(new ImageIcon("src\\image\\bill\\salebill.png"));
				break;
			case 34:salebackbill.setIcon(new ImageIcon("src\\image\\bill\\salebackbill.png"));
				break;
			}
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 11:
				giftBill.setIcon(new ImageIcon("src\\image\\bill\\giftbill0.png"));
				break;
			case 12:alertBill.setIcon(new ImageIcon("src\\image\\bill\\alertbill0.png"));
				break;
			case 13:spoilbill.setIcon(new ImageIcon("src\\image\\bill\\spoilbill0.png"));
				break;
			case 21:receivebill.setIcon(new ImageIcon("src\\image\\bill\\receivebill0.png"));
				break;
			case 22:paymentbill.setIcon(new ImageIcon("src\\image\\bill\\paymentbill0.png"));
				break;
			case 23:crashbill.setIcon(new ImageIcon("src\\image\\bill\\crashbill0.png"));
				break;
			case 31:purchasebill.setIcon(new ImageIcon("src\\image\\bill\\purchasebill0.png"));
				break;
			case 32:purchasebackbill.setIcon(new ImageIcon("src\\image\\bill\\purchasebackbill0.png"));
				break;
			case 33:salebill.setIcon(new ImageIcon("src\\image\\bill\\salebill0.png"));
				break;
			case 34:salebackbill.setIcon(new ImageIcon("src\\image\\bill\\salebackbill0.png"));
				break;
			}
		}
		
	}
}
