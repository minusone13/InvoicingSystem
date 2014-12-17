package presentation.managerui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.financialui.JPinquire;
import userui.Frame;

public class ManagerUI extends JPanel {

	//背景
	private JLabel bg=new JLabel();
	//标题栏
	private JLabel titile=new JLabel();
	//标识
	private JLabel sign=new JLabel();
	//导航
	private JLabel navigation=new JLabel();
	//功能板 
	private JPfunction function=new JPfunction();
	//审批单据1
	private JPpassBill1 passbill1=new JPpassBill1();
	//审批单据2
	private JPpassBill2 passbill2=new JPpassBill2();
	//制定策略1
	private JPmanagerStrategy1 managerStrategy1=new JPmanagerStrategy1();
	//制定策略2
	private JPmanagerStrategy2 managerStrategy2=new JPmanagerStrategy2();
	//查看各种报表
	private JPinquire inquire=new JPinquire();
	public JPinquire getInquire() {
		return inquire;
	}
	public void setInquire(JPinquire inquire) {
		this.inquire = inquire;
	}
	public JPmanagerStrategy1 getManagerStrategy1() {
		return managerStrategy1;
	}
	public void setManagerStrategy1(JPmanagerStrategy1 managerStrategy1) {
		this.managerStrategy1 = managerStrategy1;
	}
	public JPmanagerStrategy2 getManagerStrategy2() {
		return managerStrategy2;
	}
	public void setManagerStrategy2(JPmanagerStrategy2 managerStrategy2) {
		this.managerStrategy2 = managerStrategy2;
	}
	//home
	private JLabel home=new JLabel();
	//后退
	private JLabel back=new JLabel();
	//登出
	private JLabel signout=new JLabel();
	public JPfunction getFunction() {
		return function;
	}
	public void setFunction(JPfunction function) {
		this.function = function;
	}
	public JPpassBill1 getPassbill1() {
		return passbill1;
	}
	public void setPassbill1(JPpassBill1 passbill1) {
		this.passbill1 = passbill1;
	}
	public JPpassBill2 getPassbill2() {
		return passbill2;
	}
	public void setPassbill2(JPpassBill2 passbill2) {
		this.passbill2 = passbill2;
	}
	//frame的引用
    Frame frame;
	public ManagerUI(){
		//设置窗口大小
		this.setSize(960, 600);
		//设置布局
		this.setLayout(null);
		//背景
		bg.setIcon(new ImageIcon("src/image/managerUI/background.jpg"));
		bg.setBounds(0, 0, 960, 600);

		//标题栏
		titile.setIcon(new ImageIcon("src/image/navigation/titile.png") );
		titile.setBounds(0, 0, 180, 32);
		//标识栏
		sign.setIcon(new ImageIcon("src/image/navigation/manager.png") );
		sign.setBounds(0, 32, 960, 123);
		//导航
		navigation.setIcon(new ImageIcon("src/image/navigation/navigation0.png") );
		navigation.setBounds(0, 165, 960, 35);
		//功能板
		function.setLocation(55, 233);
		
		//审批单据1
		passbill1.setLocation(55, 233);
		passbill1.setVisible(false);
		
		//审批单据2
		passbill2.setLocation(55, 233);
		passbill2.setVisible(false);
	
		//制定促销策略1
		managerStrategy1.setLocation(55, 233);
		managerStrategy1.setVisible(false);
		//制定促销策略2
		managerStrategy2.setLocation(55, 233);
		managerStrategy2.setVisible(false);
		//查看报表
		inquire.setLocation(55, 233);
		inquire.setVisible(false);
		
		//home
		home.setIcon(new ImageIcon("src/image/home.png") );
		home.setBounds(690, 165, 90, 32);
		home.addMouseListener(new MouseListenerOfButton(1));
		//后退
		back.setIcon(new ImageIcon("src/image/back0.png") );
		back.setBounds(780, 165, 90, 32);
		back.addMouseListener(new MouseListenerOfButton(2));
		//登出
		signout.setIcon(new ImageIcon("src/image/signout0.png") );
		signout.setBounds(870, 165, 90, 32);
		signout.addMouseListener(new MouseListenerOfButton(3));
		
		this.add(titile,0);
		this.add(sign,1);
		this.add(navigation,2);
		this.add(home,3);
		this.add(back,4);
		this.add(signout,5);
		this.add(function,6);
		this.add(passbill1,7);
		this.add(passbill2,8);
		this.add(managerStrategy1,9);
		this.add(managerStrategy2,10);
		this.add(inquire,11);
		this.add(bg,12);
		
	}
	/*获取frame的引用*/
	public void getFrame( Frame f){
  		frame=f;
  		function.getFrame(frame);
  		passbill1.getFrame(frame);
  		passbill2.getFrame(frame);
  		managerStrategy1.getFrame(frame);
  		managerStrategy2.getFrame(frame);
  		inquire.getFrame(frame);
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
				home.setIcon(new ImageIcon("src/image/home2.png"));
				break;
			case 2:
				back.setIcon(new ImageIcon("src/image/back2.png"));
				break;
			case 3:
				signout.setIcon(new ImageIcon("src/image/signout2.png"));
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				home.setIcon(new ImageIcon("src/image/home1.png"));
				ManagerUI.this.getPassbill1().setVisible(false);
				ManagerUI.this.getPassbill2().setVisible(false);
				ManagerUI.this.getManagerStrategy1().setVisible(false);
				ManagerUI.this.getManagerStrategy2().setVisible(false);
				ManagerUI.this.getInquire().setVisible(false);
				ManagerUI.this.getFunction().setVisible(true);
				break;
			case 2:
				back.setIcon(new ImageIcon("src/image/back1.png"));
				break;
			case 3:
				signout.setIcon(new ImageIcon("src/image/signout1.png"));
				//实现登出跳转
				frame.getLogin().setVisible(true);
				ManagerUI.this.setVisible(false);
				break;
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				home.setIcon(new ImageIcon("src/image/home1.png"));
				break;
			case 2:
				back.setIcon(new ImageIcon("src/image/back1.png"));
				break;
			case 3:
				signout.setIcon(new ImageIcon("src/image/signout1.png"));
				break;
			}
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				home.setIcon(new ImageIcon("src/image/home.png"));
				break;
			case 2:
				back.setIcon(new ImageIcon("src/image/back0.png"));
				break;
			case 3:
				signout.setIcon(new ImageIcon("src/image/signout0.png"));
				break;
			}
		}
		
	}
}
