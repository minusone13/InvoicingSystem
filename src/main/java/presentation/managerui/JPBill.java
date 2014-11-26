package presentation.managerui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.AlertBillVO;
import vo.CashPaymentVO;
import vo.GiftBillVO;
import vo.PaymentVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.ReceiptVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.SpillsLossBillVO;

public class JPBill extends JPanel implements MouseListener{

	//背景
	private JLabel bg=new JLabel();
	//向右按钮
	private JLabel right=new JLabel();
	//向左按钮
	private JLabel left=new JLabel();
	//选中标记
	private boolean choose=false;
	public JPBill(GiftBillVO gb){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		bg.setIcon(new ImageIcon("src/image/sample.jpg"));
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(this);
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(bg,2);
		
	}
	public JPBill(SpillsLossBillVO slb){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(AlertBillVO ab){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(PurSheetVO ps){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(PurBackSheetVO pbs){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(SaleSheetVO ss){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(SaleBackSheetVO sbs){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(ReceiptVO rb){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(PaymentVO pb){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(CashPaymentVO cb){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
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
	public class MouseListenerOfButton implements MouseListener{

		private int num;
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

	/*单据面板本身的监控*/
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		choose=!choose;
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
