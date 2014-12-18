package presentation.commodityui;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import po.BillStyle;
import userui.Frame;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.commodityblservice.StubCommodityBlService;


@SuppressWarnings("serial")
public class JPmanageBills1 extends JPanel {

	
	//单据标签
	private JLabel giftBill = new JLabel("New label");
	private JLabel alertBill = new JLabel("New label");
	private JLabel spoilbill = new JLabel("New label");
	//图片
	ImageIcon giftBillIcon0=new ImageIcon("src\\image\\bill\\giftBill0.png");
	ImageIcon alertBillIcon0=new ImageIcon("src\\image\\bill\\alertBill0.png");
	ImageIcon spoilbillIcon0=new ImageIcon("src\\image\\bill\\spoilbill0.png");
	
	ImageIcon giftBillIcon=new ImageIcon("src\\image\\bill\\giftBill.png");
	ImageIcon alertBillIcon=new ImageIcon("src\\image\\bill\\alertBill.png");
	ImageIcon spoilbillIcon=new ImageIcon("src\\image\\bill\\spoilbill.png");
	
	ImageIcon giftBillIcon1=new ImageIcon("src\\image\\bill\\giftBill1.png");
	ImageIcon alertBillIcon1=new ImageIcon("src\\image\\bill\\alertBill1.png");
	ImageIcon spoilbillIcon1=new ImageIcon("src\\image\\bill\\spoilbill1.png");
	//frame的引用
    Frame frame;
    //逻辑层的库管人员接口
    StubCommodityBlService stcokbl=new StubStockController();
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
	
		
		giftBill.setIcon(giftBillIcon0);
		giftBill.setBounds(10, 15, 100, 100);
		giftBill.addMouseListener(new MouseListenOfButton(11));
		add(giftBill,0);
		
		
		alertBill.setIcon(alertBillIcon0);
		alertBill.setBounds(115, 15, 100, 100);
		alertBill.addMouseListener(new MouseListenOfButton(12));
		add(alertBill,1);
		
		
		spoilbill.setIcon(spoilbillIcon0);
		spoilbill.setBounds(220, 15, 100, 100);
		spoilbill.addMouseListener(new MouseListenOfButton(13));
		add(spoilbill,2);
		
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
			case 11:
				giftBill.setIcon(giftBillIcon1);
				break;
			case 12:alertBill.setIcon(alertBillIcon1);
				break;
			case 13:spoilbill.setIcon(spoilbillIcon1);
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 11:giftBill.setIcon(giftBillIcon);
				//切换
				JPmanageBills1.this.setVisible(false);
				//设置单据类型
				frame.getStock().getManageBills2().setStyle(BillStyle.GiftBill);
				//从逻辑层读取单据信息填充单据列表
				frame.getStock().getManageBills2().getBillList().getJPbillList().clear();
				frame.getStock().getManageBills2().getBillList().reHome();
				frame.getStock().getManageBills2().getBillList().addGiftBillList(stcokbl.showGiftBills());
				//切换
				frame.getStock().getManageBills2().setVisible(true);
				break;
			case 12:alertBill.setIcon(alertBillIcon);
				//切换
				JPmanageBills1.this.setVisible(false);
				//设置单据类型
				frame.getStock().getManageBills2().setStyle(BillStyle.AlertBill);
				//从逻辑层读取单据信息填充单据列表
				frame.getStock().getManageBills2().getBillList().getJPbillList().clear();
				frame.getStock().getManageBills2().getBillList().reHome();
				frame.getStock().getManageBills2().getBillList().addAlertBillList(stcokbl.showAlertBills());
				//切换
				frame.getStock().getManageBills2().setVisible(true);
				break;
			case 13:spoilbill.setIcon(spoilbillIcon);
				//切换
				JPmanageBills1.this.setVisible(false);
				//设置单据类型
				frame.getStock().getManageBills2().setStyle(BillStyle.SpillsLossBill);
				//从逻辑层读取单据信息填充单据列表
				frame.getStock().getManageBills2().getBillList().getJPbillList().clear();
				frame.getStock().getManageBills2().getBillList().reHome();
				frame.getStock().getManageBills2().getBillList().addSpillsLossBillList(stcokbl.showSpillsLossBills());
				//切换
				frame.getStock().getManageBills2().setVisible(true);
				break;
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 11:
				giftBill.setIcon(giftBillIcon);
				break;
			case 12:alertBill.setIcon(alertBillIcon);
				break;
			case 13:spoilbill.setIcon(spoilbillIcon);
				break;
			}
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 11:
				giftBill.setIcon(giftBillIcon0);
				break;
			case 12:alertBill.setIcon(alertBillIcon0);
				break;
			case 13:spoilbill.setIcon(spoilbillIcon0);
				break;
			}
		}
		
	}
}
