package presentation.financialui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.managerui.ManagerUI;
import userui.Frame;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import businesslogic.BillState;
import businesslogic.BillStyle;

public class FinancialUI extends JPanel {
	//背景
	private JLabel bg=new JLabel();
	//标题栏
	private JLabel titile=new JLabel();
	//标识
	private JLabel sign=new JLabel();
	//导航
	private JLabel navigation=new JLabel();
	//功能板 
	private JPfunctions function=new JPfunctions();
	//home
	private JLabel home=new JLabel();
	//后退
	private JLabel back=new JLabel();
	//登出
	private JLabel signout=new JLabel();
	//管理单据选择面板
	private JPmanageBills1 manageBills1=new JPmanageBills1();
	//单据管理面板
	private JPmanageBills2 manageBills2=new JPmanageBills2();
	//查看各种报表
	private JPinquire inquire=new JPinquire();
	//账户管理
	private JPmanageAccount account=new JPmanageAccount();
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
	//frame的引用
    Frame frame;
	public FinancialUI(){

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
			sign.setIcon(new ImageIcon("src/image/navigation/financial.png") );
			sign.setBounds(0, 32, 960, 123);
			//导航
			navigation.setIcon(new ImageIcon("src/image/navigation/navigation0.png") );
			navigation.setBounds(0, 165, 960, 35);
			
			//test区域
			//功能板
			function.setLocation(55, 233);
			//单据管理板1
			
			manageBills1.setVisible(false);
			manageBills1.setLocation(55, 233);
			
			//单据管理板2
			manageBills2.setVisible(false);
			manageBills2.setLocation(55, 233);
			//查看报表
			inquire.setLocation(55, 233);
			inquire.setVisible(false);
			//账户管理
			account.setLocation(55, 233);
			account.setVisible(false);
			
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
			this.add(manageBills1,7);
			this.add(manageBills2,8);
			this.add(inquire,9);
			this.add(account,10);
			this.add(bg,11);
			
		}
    public JPinquire getInquire() {
		return inquire;
	}
	public void setInquire(JPinquire inquire) {
		this.inquire = inquire;
	}
	public JPmanageAccount getAccount() {
		return account;
	}
	public void setAccount(JPmanageAccount account) {
		this.account = account;
	}
	/*获取frame引用*/
    public void getFrame( Frame f){
    		frame=f;
    		function.getFrame(frame);
    		manageBills1.getFrame(frame);
    		manageBills2.getFrame(frame);
    		inquire.getFrame(frame);
    		account.getFrame(frame);
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
					FinancialUI.this.getManageBills1().setVisible(false);
					FinancialUI.this.getManageBills2().setVisible(false);
					FinancialUI.this.getInquire().setVisible(false);
					FinancialUI.this.getAccount().setVisible(false);
					FinancialUI.this.getFunction().setVisible(true);
					break;
				case 2:
					back.setIcon(new ImageIcon("src/image/back1.png"));
					break;
				case 3:
					signout.setIcon(new ImageIcon("src/image/signout1.png"));
					//实现登出跳转
					frame.getLogin().setVisible(true);
					FinancialUI.this.setVisible(false);
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
	

