package presentation.saleui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import po.Role;
import presentation.commodityui.JPManagerCom;
import presentation.financialui.FinancialUI;
import presentation.saleui.JPmanageBills1;
import presentation.saleui.JPmanageBills2;
import userui.Frame;

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
		//frame的引用
		private Frame frame;
		
	 	public JPfunctions getFunction() {
			return function;
		}

		public void setFunction(JPfunctions function) {
			this.function = function;
		}

		public JPmanageBills1 getManageBills1() {
			return manageBills1;
		}

		public void setManageBills1(JPmanageBills1 manageBills1) {
			this.manageBills1 = manageBills1;
		}

		public JPmanageBills2 getManageBills2() {
			return manageBills2;
		}

		public void setManageBills2(JPmanageBills2 manageBills2) {
			this.manageBills2 = manageBills2;
		}
		//管理单据选择面板
		private JPmanageBills1 manageBills1=new JPmanageBills1();
		//单据管理面板
		private JPmanageBills2 manageBills2=new JPmanageBills2();
		//客户管理
		private JPmanageCustomer customerManage=new JPmanageCustomer();
		//选择商品
		JPManagerCom choseComs=new JPManagerCom();
		public JPManagerCom getChoseComs() {
			return choseComs;
		}

		public void setChoseComs(JPManagerCom choseComs) {
			this.choseComs = choseComs;
		}

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
			//单据管理板1
			
			manageBills1.setVisible(false);
			manageBills1.setLocation(55, 233);
			
			//单据管理板2
			
			manageBills2.setVisible(false);
			manageBills2.setLocation(55, 233);
			//客户管理
			customerManage.setVisible(false);
			customerManage.setLocation(55, 233);
			//选择商品
			choseComs.setLocation(55, 210);
			choseComs.setRole(Role.PURCHASE_SALE_STAFF);
			choseComs.setVisible(false);
			
			this.add(title,0);
			this.add(sign,1);
			this.add(navigation,2);
			this.add(home,3);
			this.add(back,4);
			this.add(signout,5);
			this.add(choseComs,6);
			this.add(function,7);
			this.add(manageBills1,8);
			this.add(manageBills2,9);
			this.add(customerManage,10);
			this.add(bg,11);
		}

	    /*获取frame引用*/
	    public void getFrame( Frame f){
	    		frame=f;
	    		function.getFrame(frame);
	    		manageBills1.getFrame(frame);
	    		manageBills2.getFrame(frame);
	    		customerManage.getFrame(frame);
	    		choseComs.getFrame(frame);
	    }
		public JPmanageCustomer getCustomerManage() {
			return customerManage;
		}

		public void setCustomerManage(JPmanageCustomer customerManage) {
			this.customerManage = customerManage;
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
					Sale.this.getManageBills1().setVisible(false);
					Sale.this.getManageBills2().setVisible(false);
					Sale.this.getCustomerManage().setVisible(false);
					Sale.this.getChoseComs().setVisible(false);
					Sale.this.getFunction().setVisible(true);
					break;
				case 2:
					back.setIcon(new ImageIcon("src/image/back1.png"));
					break;
				case 3:
					signout.setIcon(new ImageIcon("src/image/signout1.png"));
					//实现登出跳转
					frame.getLogin().setVisible(true);
					Sale.this.setVisible(false);
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
