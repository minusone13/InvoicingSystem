package presentation.userui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entrance.Frame;
import presentation.financialui.FinancialUI;
import presentation.saleui.JPmanageBills1;
import presentation.saleui.JPmanageBills2;

public class Admin extends JPanel{
		/*
		 * 成员变量注释参照Finance。java；
		 * */
		private JLabel bg= new JLabel();
		private JLabel title = new JLabel();
		private JLabel navigation = new JLabel();
		private JLabel sign = new JLabel();
		private JLabel modifyPasswords = new JLabel();
		private JLabel signout = new JLabel();
		//frame的引用
		private Frame frame;

		//用户管理
		private JPmanageUser manageUser=new JPmanageUser();
		public JPmanageUser getManageUser() {
			return manageUser;
		}

		public void setManageUser(JPmanageUser manageUser) {
			this.manageUser = manageUser;
		}

		public Admin(){

			//设置窗口大小
			this.setSize(960, 600);
			//设置布局
			this.setLayout(null);
			//背景
			bg.setIcon(new ImageIcon("src/image/managerUI/background.jpg"));
			bg.setBounds(0, 0, 960, 600);
			
			title.setIcon(new ImageIcon("src/image/navigation/titile.png") );
			title.setBounds(0, 0, 180, 32);
			
			sign.setIcon(new ImageIcon("src/image/navigation/administrator.png") );
			sign.setBounds(0, 32, 960, 123);
			
			navigation.setIcon(new ImageIcon("src/image/navigation/navigation0.png") );
			navigation.setBounds(0, 165, 960, 35);
			
			
			
			modifyPasswords.setIcon(new ImageIcon("src/image/modifyPassword0.png") );
			modifyPasswords.setBounds(720, 165,150, 32);
			modifyPasswords.addMouseListener(new MouseListenerOfButton(4));
			
			signout.setIcon(new ImageIcon("src/image/signout0.png") );
			signout.setBounds(870, 165, 90, 32);
			signout.addMouseListener(new MouseListenerOfButton(3));
			
			
			//用户管理
			manageUser.setLocation(55, 233);
			
			
			this.add(title,0);
			this.add(sign,1);
			this.add(navigation,2);
			this.add(modifyPasswords,3);
			this.add(signout,4);
			this.add(manageUser,5);
			this.add(bg,6);
		}

	    /*获取frame引用*/
	    public void getFrame( Frame f){
	    		frame=f;
	    		manageUser.getFrame(f);
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
				case 3:
					signout.setIcon(new ImageIcon("src/image/signout2.png"));
					break;
				case 4:
					modifyPasswords.setIcon(new ImageIcon("src/image/modifyPassword2.png"));
					break;
				}
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				switch(num){
				case 3:
					signout.setIcon(new ImageIcon("src/image/signout1.png"));
					//实现登出跳转
					frame.getLogin().setVisible(true);
					Admin.this.setVisible(false);
					//一下面板的编辑面板归位
					Admin.this.getManageUser().reHome();
					break;
				case 4:
					modifyPasswords.setIcon(new ImageIcon("src/image/modifyPassword1.png"));
					Admin.this.getManageUser().getJPedit().setAdmin(true);
					Admin.this.getManageUser().getJPedit().leftMove();
					break;
				}
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				switch(num){
				case 3:
					signout.setIcon(new ImageIcon("src/image/signout1.png"));
					break;
				case 4:
					modifyPasswords.setIcon(new ImageIcon("src/image/modifyPassword1.png"));
					break;
				}
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				switch(num){
				case 3:
					signout.setIcon(new ImageIcon("src/image/signout0.png"));
					break;
				case 4:
					modifyPasswords.setIcon(new ImageIcon("src/image/modifyPassword0.png"));
					break;
				}
			}
			
		}
	
		
}
