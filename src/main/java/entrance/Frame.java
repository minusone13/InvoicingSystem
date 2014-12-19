package entrance;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.WarningPanel;
import presentation.commodityui.Stock;
import presentation.financialui.FinancialUI;
import presentation.managerui.ManagerUI;
import presentation.saleui.Sale;
import presentation.userui.Admin;
import presentation.userui.Login;

public class Frame extends JFrame implements MouseListener{

	//基层jp
	private JPanel mainJP=new JPanel();
	//关闭与小化
	private JLabel close=new JLabel();
	private JLabel minus=new JLabel();
	//登录面板
	private Login login;
	//总经理面板
	private ManagerUI manager;
	//财务
	private FinancialUI financial;
	//进销人员
	private Sale sale;
	//库管
	private Stock stock;
	//管理员
	private Admin admin;
	private WarningPanel warning;
	public WarningPanel getWarning() {
		return warning;
	}
	public void setWarning(WarningPanel warning) {
		this.warning = warning;
	}
	public JPanel getMainJP() {
		return mainJP;
	}
	public void setMainJP(JPanel mainJP) {
		this.mainJP = mainJP;
	}
	public JLabel getClose() {
		return close;
	}
	public void setClose(JLabel close) {
		this.close = close;
	}
	public JLabel getMinus() {
		return minus;
	}
	public void setMinus(JLabel minus) {
		this.minus = minus;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public ManagerUI getManager() {
		return manager;
	}
	public void setManager(ManagerUI manager) {
		this.manager = manager;
	}
	public FinancialUI getFinancial() {
		return financial;
	}
	public void setFinancial(FinancialUI financial) {
		this.financial = financial;
	}
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
		//提示信息框
		warning=new WarningPanel();
		//关闭与小化
		close.setIcon(new ImageIcon("src/image/cancel.png"));
		minus.setIcon(new ImageIcon("src/image/minus.png"));
		close.setBounds(936, 1, 24, 24);
		minus.setBounds(910, 1, 24, 24);
		close.addMouseListener(new MouseListenerOfButton(1));
		minus.addMouseListener(new MouseListenerOfButton(2));
		mainJP.add(warning,0);
		mainJP.add(close,1);
		mainJP.add(minus,2);
		
		
		//登录面板
		login=new Login();
		login.getFrame(this);
		mainJP.add(login,3);
		login.setBounds(0, 0, 960, 600);
		
		manager=new ManagerUI();
		manager.getFrame(this);
		mainJP.add(manager,4);
		manager.setVisible(false);
		manager.setBounds(0, 0, 960, 600);
		
		financial=new FinancialUI();
		financial.getFrame(this);
		mainJP.add(financial,5);
		financial.setVisible(false);
		financial.setBounds(0, 0, 960, 600);
		
		sale=new Sale();
		sale.getFrame(this);
		mainJP.add(sale,6);
		sale.setVisible(false);
		sale.setBounds(0, 0, 960, 600);
		
		stock=new Stock();
		stock.getFrame(this);
		mainJP.add(stock,7);
		stock.setVisible(false);
		stock.setBounds(0, 0, 960, 600);
		
		admin=new Admin();
		admin.getFrame(this);
		mainJP.add(admin,8);
		admin.setVisible(false);
		admin.setBounds(0, 0, 960, 600);
		
		//加上监听接口
//		financial.addMouseListener(this);
		//设置窗口可见
		this.setVisible(true);
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
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
