package presentation.commodityui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import po.Role;
import userui.Frame;

public class Stock extends JPanel {
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
	//管理单据选择面板
	private JPmanageBills1 manageBills1=new JPmanageBills1();
	//单据管理面板
	private JPmanageBills2 manageBills2=new JPmanageBills2();
	//商品管理
	JPManagerComOfStock managerComs=new JPManagerComOfStock();
	//选择商品
	JPManagerCom choseComs=new JPManagerCom();
	public JPManagerCom getChoseComs() {
		return choseComs;
	}
	public void setChoseComs(JPManagerCom choseComs) {
		this.choseComs = choseComs;
	}
	//home
	private JLabel home=new JLabel();
	public JPfunction getFunction() {
		return function;
	}
	public void setFunction(JPfunction function) {
		this.function = function;
	}
	public JPmanageBills1 getManageBills() {
		return manageBills1;
	}
	public void setManageBills(JPmanageBills1 manageBills) {
		this.manageBills1 = manageBills;
	}
	public JPmanageBills2 getManageBills2() {
		return manageBills2;
	}
	public void setManageBills2(JPmanageBills2 manageBills2) {
		this.manageBills2 = manageBills2;
	}
	//后退
	private JLabel back=new JLabel();
	//登出
	private JLabel signout=new JLabel();
	//frame的引用
    Frame frame;
	public Stock(){

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
			sign.setIcon(new ImageIcon("src/image/navigation/commodity.png") );
			sign.setBounds(0, 32, 960, 123);
			//导航
			navigation.setIcon(new ImageIcon("src/image/navigation/navigation0.png") );
			navigation.setBounds(0, 165, 960, 35);
			
			//test区域
			//功能板
			function.setLocation(55, 233);
			//单据管理板1
			manageBills1.setLocation(55, 233);
			manageBills1.setVisible(false);

			//单据管理板2
			manageBills2.setLocation(55, 233);
			manageBills2.setVisible(false);
			
			//商品管理
			managerComs.setLocation(55, 210);
			managerComs.setVisible(false);
			
			//选择商品
			choseComs.setLocation(55, 210);
			choseComs.setRole(Role.STOCK_STAFF);
			choseComs.setVisible(false);
			choseComs.getAddIcon().setVisible(false);
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
			this.add(choseComs,6);
			this.add(function,7);
			this.add(manageBills1,8);
			this.add(manageBills2,9);
			this.add(managerComs,10);
			this.add(bg,11);
			
		}
    public JPManagerComOfStock getManagerComs() {
		return managerComs;
	}
	public void setManagerComs(JPManagerComOfStock managerComs) {
		this.managerComs = managerComs;
	}
	/*获取frame引用*/
    public void getFrame( Frame f){
    		frame=f;
    		function.getFrame(frame);
    		manageBills1.getFrame(frame);
    		manageBills2.getFrame(frame);
    		choseComs.getFrame(frame);
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
					Stock.this.getManageBills().setVisible(false);
					Stock.this.getManageBills2().setVisible(false);
					Stock.this.getManagerComs().setVisible(false);
					Stock.this.getChoseComs().setVisible(false);
					Stock.this.getFunction().setVisible(true);
					break;
				case 2:
					back.setIcon(new ImageIcon("src/image/back1.png"));
					break;
				case 3:
					signout.setIcon(new ImageIcon("src/image/signout1.png"));
					//实现登出跳转
					frame.getLogin().setVisible(true);
					Stock.this.setVisible(false);
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
	
