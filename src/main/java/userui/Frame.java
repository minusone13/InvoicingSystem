package userui;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.financialui.Financial;

public class Frame extends JFrame implements MouseListener{

	//基层jp
	JPanel mainJP=new JPanel();
	//关闭与小化
	JLabel close=new JLabel();
	JLabel minus=new JLabel();
	
	public Frame(){
	
		// 取得屏幕的宽度
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		// 取得屏幕的高度
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		//设置窗口大小
		this.setSize(960, 600);
		//设置无边框
		setUndecorated(true);
		// 设置窗体出现位置
		this.setLocation((width - 960) / 2, (height - 600) / 2);
		// 将窗体的关闭方式设置为默认关闭后程序结束
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置布局
		this.setLayout(null);
		//加上基层JP
		this.add(mainJP);
		//设置jp大小
		mainJP.setBounds(0, 0, 960, 600);
		mainJP.setLayout(null);
		
//		//加上监听接口
//		bg.addMouseListener(this);
		//关闭与小化
		close.setIcon(new ImageIcon("src/image/cancel.png"));
		minus.setIcon(new ImageIcon("src/image/minus.png"));
		close.setBounds(936, 1, 24, 24);
		minus.setBounds(910, 1, 24, 24);
		close.addMouseListener(new MouseListenerOfButton(1));
		minus.addMouseListener(new MouseListenerOfButton(2));
		mainJP.add(close,0);
		mainJP.add(minus,1);
		
		
//		//登录面板
//		Login login=new Login();
//		mainJP.add(login,2);
//		login.setBounds(0, 0, 960, 600);
		
//		ManagerUI manager=new ManagerUI();
//		mainJP.add(manager,2);
//		manager.setBounds(0, 0, 960, 600);
		
		Financial financial=new Financial();
		mainJP.add(financial,2);
		financial.setBounds(0, 0, 960, 600);
		//加上监听接口
		financial.addMouseListener(this);
		//设置窗口可见
		this.setVisible(true);
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
			if(num==1){
				close.setIcon(new ImageIcon("src/image/cancelR.png"));
			}
			else if(num==2){
				minus.setIcon(new ImageIcon("src/image/minusR.png"));
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(num==1){
				close.setIcon(new ImageIcon("src/image/cancel.png"));
				System.exit(0);
			}
			else if(num==2){
				minus.setIcon(new ImageIcon("src/image/minus.png"));
				Frame.this.setExtendedState(JFrame.ICONIFIED);
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(num==1){
				close.setIcon(new ImageIcon("src/image/cancel.png"));
			}
			else if(num==2){
				minus.setIcon(new ImageIcon("src/image/minus.png"));
			}
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX()+","+e.getY());
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
