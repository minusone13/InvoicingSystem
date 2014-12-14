package presentation.financialui;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import userui.Frame;
import businesslogic.BillStyle;
import businesslogic.financialbl.Financial;
import businesslogicservice.financialblservice.FinancialBlService;


@SuppressWarnings("serial")
public class JPmanageBills1 extends JPanel {

	
	//单据标签
	private JLabel receivebill = new JLabel("New label");
	private JLabel paymentbill = new JLabel("New label");
	private JLabel crashbill = new JLabel("New label");
	//图片
	ImageIcon receivebillIcon0=new ImageIcon("src\\image\\bill\\receivebill0.png");
	ImageIcon paymentbillIcon0=new ImageIcon("src\\image\\bill\\paymentbill0.png");
	ImageIcon crashbillIcon0=new ImageIcon("src\\image\\bill\\crashbill0.png");
	ImageIcon receivebillIcon=new ImageIcon("src\\image\\bill\\receivebill.png");
	ImageIcon paymentbillIcon=new ImageIcon("src\\image\\bill\\paymentbill.png");
	ImageIcon crashbillIcon=new ImageIcon("src\\image\\bill\\crashbill.png");
	ImageIcon receivebillIcon1=new ImageIcon("src\\image\\bill\\receivebill1.png");
	ImageIcon paymentbillIcon1=new ImageIcon("src\\image\\bill\\paymentbill1.png");
	ImageIcon crashbillIcon1=new ImageIcon("src\\image\\bill\\crashbill1.png");
	//frame的引用
    Frame frame;
    //逻辑层的财务人员接口
    FinancialBlService fbl=new Financial();
	public JPmanageBills1(){
		//设置窗口大小
		this.setSize(445, 330);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		JLabel bg = new JLabel("New label");
		bg.setIcon(new ImageIcon("src\\image\\passBill\\passBillBlock1.png"));
		bg.setBounds(0, 0, 445, 330);
	
		receivebill.setIcon(receivebillIcon0);
		receivebill.setBounds(10, 15, 100, 100);
		receivebill.addMouseListener(new MouseListenOfButton(21));
		add(receivebill,0);
		
		
		paymentbill.setIcon(paymentbillIcon0);
		paymentbill.setBounds(115, 15, 100, 100);
		paymentbill.addMouseListener(new MouseListenOfButton(22));
		add(paymentbill,1);
		
		
		crashbill.setIcon(crashbillIcon0);
		crashbill.setBounds(220, 15, 100, 100);
		crashbill.addMouseListener(new MouseListenOfButton(23));
		add(crashbill,2);
		
		add(bg,3);
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
			case 21:receivebill.setIcon(receivebillIcon1);
				break;
			case 22:paymentbill.setIcon(paymentbillIcon1);
				break;
			case 23:crashbill.setIcon(crashbillIcon1);
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 21:receivebill.setIcon(receivebillIcon);
				//切换
				JPmanageBills1.this.setVisible(false);
				//设置单据类型
				frame.getFinancial().getManageBills2().setStyle(BillStyle.ReceiptBill);
				//从逻辑层读取单据信息填充单据列表
				frame.getFinancial().getManageBills2().getBillList().getJPbillList().clear();
				frame.getFinancial().getManageBills2().getBillList().reHome();
				frame.getFinancial().getManageBills2().getBillList().addReceiptBillList(fbl.getAllOfReceiptBills());
				//切换
				frame.getFinancial().getManageBills2().setVisible(true);
				break;
			case 22:paymentbill.setIcon(paymentbillIcon);
				//切换
				JPmanageBills1.this.setVisible(false);
				//设置单据类型
				frame.getFinancial().getManageBills2().setStyle(BillStyle.PaymentBill);
				//从逻辑层读取单据信息填充单据列表
				frame.getFinancial().getManageBills2().getBillList().getJPbillList().clear();
				frame.getFinancial().getManageBills2().getBillList().reHome();
				frame.getFinancial().getManageBills2().getBillList().addPaymentBillList(fbl.getAllOfPaymentBills());
				//切换
				frame.getFinancial().getManageBills2().setVisible(true);
				break;
			case 23:crashbill.setIcon(crashbillIcon);
				//切换
				JPmanageBills1.this.setVisible(false);
				//设置单据类型
				frame.getFinancial().getManageBills2().setStyle(BillStyle.CashPaymentBill);
				//从逻辑层读取单据信息填充单据列表
				frame.getFinancial().getManageBills2().getBillList().getJPbillList().clear();
				frame.getFinancial().getManageBills2().getBillList().reHome();
				frame.getFinancial().getManageBills2().getBillList().addCashPaymentBillList(fbl.getAllOfCashPaymentBills());
				//切换
				frame.getFinancial().getManageBills2().setVisible(true);
				break;
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 21:receivebill.setIcon(receivebillIcon);
				break;
			case 22:paymentbill.setIcon(paymentbillIcon);
				break;
			case 23:crashbill.setIcon(crashbillIcon);
				break;
			}
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 21:receivebill.setIcon(receivebillIcon0);
				break;
			case 22:paymentbill.setIcon(paymentbillIcon0);
				break;
			case 23:crashbill.setIcon(crashbillIcon0);
				break;
			}
		}
		
	}
}
