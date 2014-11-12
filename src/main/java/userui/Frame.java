package userui;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame implements MouseListener{

	//基层jp
	JPanel mainJP=new JPanel();
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
		
		//测试用背景
		JLabel bg=new JLabel();
		bg.setIcon(new ImageIcon("src/image/passBillBG.jpg"));
		mainJP.add(bg);
		bg.setBounds(0, 0, 960, 600);
		//加上监听接口
		bg.addMouseListener(this);
		
		//设置窗口可见
		this.setVisible(true);
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
