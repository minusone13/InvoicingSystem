package presentation.managerui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.financialui.JPmanageBills1.MouseListenOfButton;
import userui.Frame;
import businesslogic.BillStyle;
import businesslogic.financialbl.Financial;
import businesslogicservice.financialblservice.StubFinancialBlService;

public class JPmanagerStrategy1 extends JPanel {

	
	//单据标签
	private JLabel customer = new JLabel("New label");
	private JLabel bargin = new JLabel("New label");
	private JLabel reach = new JLabel("New label");
	//图片
	ImageIcon customerIcon0=new ImageIcon("src\\image\\strategy\\customer0.png");
	ImageIcon barginIcon0=new ImageIcon("src\\image\\strategy\\bargin0.png");
	ImageIcon reachIcon0=new ImageIcon("src\\image\\strategy\\reach0.png");
	ImageIcon customerIcon=new ImageIcon("src\\image\\strategy\\customer.png");
	ImageIcon barginIcon=new ImageIcon("src\\image\\strategy\\bargin.png");
	ImageIcon reachIcon=new ImageIcon("src\\image\\strategy\\reach.png");
	ImageIcon customerIcon1=new ImageIcon("src\\image\\strategy\\customer1.png");
	ImageIcon barginIcon1=new ImageIcon("src\\image\\strategy\\bargin1.png");
	ImageIcon reachIcon1=new ImageIcon("src\\image\\strategy\\reach1.png");
	//frame的引用
    Frame frame;
    //逻辑层的财务人员接口
    StubFinancialBlService fbl=new Financial();
	public JPmanagerStrategy1(){
		//设置窗口大小
		this.setSize(445, 330);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		JLabel bg = new JLabel("New label");
		bg.setIcon(new ImageIcon("src\\image\\passBill\\passBillBlock1.png"));
		bg.setBounds(0, 0, 445, 330);
	
		customer.setIcon(customerIcon0);
		customer.setBounds(10, 15, 100, 100);
		customer.addMouseListener(new MouseListenOfButton(21));
		add(customer,0);
		
		
		bargin.setIcon(barginIcon0);
		bargin.setBounds(115, 15, 100, 100);
		bargin.addMouseListener(new MouseListenOfButton(22));
		add(bargin,1);
		
		
		reach.setIcon(reachIcon0);
		reach.setBounds(220, 15, 100, 100);
		reach.addMouseListener(new MouseListenOfButton(23));
		add(reach,2);
		
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
			case 21:customer.setIcon(customerIcon1);
				break;
			case 22:bargin.setIcon(barginIcon1);
				break;
			case 23:reach.setIcon(reachIcon1);
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 21:customer.setIcon(customerIcon);
				//切换
				JPmanagerStrategy1.this.setVisible(false);
				//设置单据类型
				frame.getFinancial().getManageBills2().setStyle(BillStyle.ReceiptBill);
				//从逻辑层读取单据信息填充单据列表
				frame.getFinancial().getManageBills2().getBillList().getJPbillList().clear();
				frame.getFinancial().getManageBills2().getBillList().reHome();
				frame.getFinancial().getManageBills2().getBillList().addReceiptBillList(fbl.getAllOfReceiptBills());
				//切换
				frame.getFinancial().getManageBills2().setVisible(true);
				break;
			case 22:bargin.setIcon(barginIcon);
				//切换
				JPmanagerStrategy1.this.setVisible(false);
				//设置单据类型
				frame.getFinancial().getManageBills2().setStyle(BillStyle.PaymentBill);
				//从逻辑层读取单据信息填充单据列表
				frame.getFinancial().getManageBills2().getBillList().getJPbillList().clear();
				frame.getFinancial().getManageBills2().getBillList().reHome();
				frame.getFinancial().getManageBills2().getBillList().addPaymentBillList(fbl.getAllOfPaymentBills());
				//切换
				frame.getFinancial().getManageBills2().setVisible(true);
				break;
			case 23:reach.setIcon(reachIcon);
				//切换
				JPmanagerStrategy1.this.setVisible(false);
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
			case 21:customer.setIcon(customerIcon);
				break;
			case 22:bargin.setIcon(barginIcon);
				break;
			case 23:reach.setIcon(reachIcon);
				break;
			}
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 21:customer.setIcon(customerIcon0);
				break;
			case 22:bargin.setIcon(barginIcon0);
				break;
			case 23:reach.setIcon(reachIcon0);
				break;
			}
		}
		
	}
}