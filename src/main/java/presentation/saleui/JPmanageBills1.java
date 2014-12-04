package presentation.saleui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.financialui.JPmanageBills1.MouseListenOfButton;

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
			break;
			case 22:PurBackSheet.setIcon(PurBackSheetIcon);
			break;
			case 23:SaleSheet.setIcon(SaleSheetIcon);
			break;
			case 24:SaleBackSheet.setIcon(SaleBackSheetIcon);
			break;
			}
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
