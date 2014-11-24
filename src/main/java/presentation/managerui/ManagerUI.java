package presentation.managerui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	//home
	private JLabel home=new JLabel();
	//后退
	private JLabel back=new JLabel();
	//登出
	private JLabel signout=new JLabel();
	public ManagerUI(){
		//设置窗口大小
		this.setSize(960, 600);
		//设置布局
		this.setLayout(null);
		//背景
		bg.setIcon(new ImageIcon("src/image/managerUI/background.jpg"));
		bg.setBounds(0, 0, 960, 600);

		//标题栏
		titile.setIcon(new ImageIcon("src/image/managerUI/titile.png") );
		titile.setBounds(0, 0, 180, 32);
		//标识栏
		sign.setIcon(new ImageIcon("src/image/managerUI/sign.png") );
		sign.setBounds(0, 32, 960, 123);
		//导航
		navigation.setIcon(new ImageIcon("src/image/managerUI/navigation0.png") );
		navigation.setBounds(0, 165, 960, 35);
		//功能板
		function.setLocation(55, 233);
		//home
		home.setIcon(new ImageIcon("src/image/home.png") );
		home.setBounds(690, 165, 90, 32);
		//后退
		back.setIcon(new ImageIcon("src/image/back0.png") );
		back.setBounds(780, 165, 90, 32);
		//登出
		signout.setIcon(new ImageIcon("src/image/signout0.png") );
		signout.setBounds(870, 165, 90, 32);
		this.add(titile,0);
		this.add(sign,1);
		this.add(navigation,2);
		this.add(function,3);
		this.add(home,4);
		this.add(back,5);
		this.add(signout,6);
		this.add(bg,7);
		
	}
}
