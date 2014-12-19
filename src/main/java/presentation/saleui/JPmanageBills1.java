package presentation.saleui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entrance.Frame;
import po.BillStyle;
import presentation.PanelType;
import businesslogic.salebillbl.salebillController;
import businesslogicservice.salebillblservice.SaleBillBlService;

public class JPmanageBills1  extends JPanel {
	//单据标签
	private JLabel PurSheet = new JLabel("New label");
	private JLabel PurBackSheet = new JLabel("New label");
	private JLabel SaleSheet = new JLabel("New label");
	private JLabel SaleBackSheet = new JLabel("New label");
	//图标
	ImageIcon PurSheetIcon=new ImageIcon("src\\image\\bill\\purchasebill.png");
	ImageIcon PurSheetIcon0=new ImageIcon("src\\image\\bill\\purchasebill0.png");
	ImageIcon PurSheetIcon1=new ImageIcon("src\\image\\bill\\purchasebill1.png");
	ImageIcon PurBackSheetIcon=new ImageIcon("src\\image\\bill\\purchasebackbill.png");
	ImageIcon PurBackSheetIcon0=new ImageIcon("src\\image\\bill\\purchasebackbill0.png");
	ImageIcon PurBackSheetIcon1=new ImageIcon("src\\image\\bill\\purchasebackbill1.png");
	ImageIcon SaleSheetIcon=new ImageIcon("src\\image\\bill\\salebill.png");
	ImageIcon SaleSheetIcon0=new ImageIcon("src\\image\\bill\\salebill0.png");
	ImageIcon SaleSheetIcon1=new ImageIcon("src\\image\\bill\\salebill1.png");
	ImageIcon SaleBackSheetIcon=new ImageIcon("src\\image\\bill\\salebackbill.png");
	ImageIcon SaleBackSheetIcon0=new ImageIcon("src\\image\\bill\\salebackbill0.png");
	ImageIcon SaleBackSheetIcon1=new ImageIcon("src\\image\\bill\\salebackbill1.png");
	//frame的引用
    Frame frame;
    //逻辑层进销人员的接口
    SaleBillBlService sbl=new salebillController();
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
	
		PurSheet.setIcon(PurSheetIcon);
		PurSheet.setBounds(10, 15, 100, 100);
		PurSheet.addMouseListener(new MouseListenOfButton(21));
		add(PurSheet,0);
		
		PurBackSheet.setIcon(PurBackSheetIcon);
		PurBackSheet.setBounds(115, 15, 100, 100);
		PurBackSheet.addMouseListener(new MouseListenOfButton(22));
		add(PurBackSheet,1);
		
		SaleSheet.setIcon(SaleSheetIcon);
		SaleSheet.setBounds(220, 15, 100, 100);
		SaleSheet.addMouseListener(new MouseListenOfButton(23));
		add(SaleSheet,2);
		
		SaleBackSheet.setIcon(SaleBackSheetIcon);
		SaleBackSheet.setBounds(325, 15, 100, 100);
		SaleBackSheet.addMouseListener(new MouseListenOfButton(24));
		add(SaleBackSheet,3);
		
		add(bg,4);
	}
	  /*获取frame引用*/
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
			case 21:PurSheet.setIcon(PurSheetIcon1);
				break;
			case 22:PurBackSheet.setIcon(PurBackSheetIcon1);
				break;
			case 23:SaleSheet.setIcon(SaleSheetIcon1);
				break;
			case 24:SaleBackSheet.setIcon(SaleBackSheetIcon1);
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 21:PurSheet.setIcon(PurSheetIcon);
				//切换
				JPmanageBills1.this.setVisible(false);
				//设置单据类型
				frame.getSale().getManageBills2().setStyle(BillStyle.PurSheet);
				//从逻辑层读取单据信息填充单据列表
				frame.getSale().getManageBills2().getBillList().getJPbillList().clear();
				frame.getSale().getManageBills2().getBillList().reHome();
				frame.getSale().getManageBills2().getBillList().addPurSheetList(sbl.getAllPurSheet());
				//切换
				frame.getSale().getManageBills2().setVisible(true);
			break;
			case 22:PurBackSheet.setIcon(PurBackSheetIcon);
				//切换
				JPmanageBills1.this.setVisible(false);
				//设置单据类型
				frame.getSale().getManageBills2().setStyle(BillStyle.PurBackSheet);
				//从逻辑层读取单据信息填充单据列表
				frame.getSale().getManageBills2().getBillList().getJPbillList().clear();
				frame.getSale().getManageBills2().getBillList().reHome();
				frame.getSale().getManageBills2().getBillList().addPurBackSheetList(sbl.getAllPurBackSheet());
				//切换
				frame.getSale().getManageBills2().setVisible(true);
			break;
			case 23:SaleSheet.setIcon(SaleSheetIcon);
				//切换
				JPmanageBills1.this.setVisible(false);
				//设置单据类型
				frame.getSale().getManageBills2().setStyle(BillStyle.SaleSheet);
				//从逻辑层读取单据信息填充单据列表
				frame.getSale().getManageBills2().getBillList().getJPbillList().clear();
				frame.getSale().getManageBills2().getBillList().reHome();
				frame.getSale().getManageBills2().getBillList().addSaleSheetList(sbl.getAllSaleSheet());
				//切换
				frame.getSale().getManageBills2().setVisible(true);
			break;
			case 24:SaleBackSheet.setIcon(SaleBackSheetIcon);
				//切换
				JPmanageBills1.this.setVisible(false);
				//设置单据类型
				frame.getSale().getManageBills2().setStyle(BillStyle.SaleBackSheet);
				//从逻辑层读取单据信息填充单据列表
				frame.getSale().getManageBills2().getBillList().getJPbillList().clear();
				frame.getSale().getManageBills2().getBillList().reHome();
				frame.getSale().getManageBills2().getBillList().addSaleBackSheetList(sbl.getAllSaleBackSheet());
				//切换
				frame.getSale().getManageBills2().setVisible(true);
			break;
			}
			//标记当前面板，用于后退按钮
			frame.getSale().setPanelType(PanelType.JPmanageBills2);
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 21:PurSheet.setIcon(PurSheetIcon);
			break;
			case 22:PurBackSheet.setIcon(PurBackSheetIcon);
			break;
			case 23:SaleSheet.setIcon(SaleSheetIcon);
			break;
			case 24:SaleBackSheet.setIcon(SaleBackSheetIcon);
			break;
			}
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 21:PurSheet.setIcon(PurSheetIcon0);
			break;
			case 22:PurBackSheet.setIcon(PurBackSheetIcon0);
			break;
			case 23:SaleSheet.setIcon(SaleSheetIcon0);
			break;
			case 24:SaleBackSheet.setIcon(SaleBackSheetIcon0);
			break;
			}
		}
		
	}
	
}
