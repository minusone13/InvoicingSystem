package presentation.saleui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sale extends JPanel{
		/*
		 * 成员变量注释参照Finance。java；
		 * */
		private JLabel bg= new JLabel();
		private JLabel title = new JLabel();
		private JLabel navigation = new JLabel();
		private JLabel sign = new JLabel();
		private JPfunctions function=new JPfunctions();
		private JLabel home = new JLabel();
		private JLabel back = new JLabel();
		private JLabel signout = new JLabel();
		
		public Sale(){

			//设置窗口大小
			this.setSize(960, 600);
			//设置布局
			this.setLayout(null);
			//背景
			bg.setIcon(new ImageIcon("src/image/managerUI/background.jpg"));
			bg.setBounds(0, 0, 960, 600);
			
			title.setIcon(new ImageIcon("src/image/navigation/titile.png") );
			title.setBounds(0, 0, 180, 32);
			
			sign.setIcon(new ImageIcon("src/image/navigation/Sale.png") );
			sign.setBounds(0, 32, 960, 123);
			
			navigation.setIcon(new ImageIcon("src/image/navigation/navigation0.png") );
			navigation.setBounds(0, 165, 960, 35);
			
			home.setIcon(new ImageIcon("src/image/home.png") );
			home.setBounds(690, 165, 90, 32);
			home.addMouseListener(new MouseListenerOfButton(1));
			
			back.setIcon(new ImageIcon("src/image/back0.png") );
			back.setBounds(780, 165, 90, 32);
			back.addMouseListener(new MouseListenerOfButton(2));
			
			signout.setIcon(new ImageIcon("src/image/signout0.png") );
			signout.setBounds(870, 165, 90, 32);
			signout.addMouseListener(new MouseListenerOfButton(3));
			
			function.setLocation(55, 233);//测试其他版时可以直接注释掉这一行
			
			this.add(title,0);
			this.add(sign,1);
			this.add(navigation,2);
			this.add(home,3);
			this.add(back,4);
			this.add(signout,5);
			this.add(function,6);
			this.add(bg,7);
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
					break;
				case 2:
					back.setIcon(new ImageIcon("src/image/back1.png"));
					break;
				case 3:
					signout.setIcon(new ImageIcon("src/image/signout1.png"));
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
