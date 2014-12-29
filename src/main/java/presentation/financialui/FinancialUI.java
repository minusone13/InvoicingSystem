package presentation.financialui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entrance.Frame;
import presentation.PanelType;
import presentation.managerui.JPSystemRecord;
import presentation.managerui.ManagerUI;

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
	//经营历程表
	private BusinessProcessPanel businessProgress=new BusinessProcessPanel();
	//销售明细表
	private SaleDetailPanel saleDetail=new SaleDetailPanel();
	//经营情况表
	private BusinessConditionPanel businessCondition=new BusinessConditionPanel();
	//账户管理
	private JPmanageAccount account=new JPmanageAccount();
	//期初建账选择
	private AccountBuildIndexPanel accountBuildIndex=new AccountBuildIndexPanel();
	//期初建账信息
	private InitialInfoPanel accountInfomation=new InitialInfoPanel();
	//系统日志
	private JPSystemRecord systemRecord=new JPSystemRecord();
	//期初建账——商品
	private JPaccountOfComs accountOfComs=new JPaccountOfComs();
	//当前面板标记，用于后退跳转
	private PanelType panelType=PanelType.JPfunction;
	//frame的引用
	private Frame frame;
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
			//经营情况表
			businessCondition.setLocation(55, 233);
			businessCondition.setVisible(false);
			//经营历程表
			businessProgress.setLocation(55, 233);
			businessProgress.setVisible(false);
			//销售明细表
			saleDetail.setLocation(55, 233);
			saleDetail.setVisible(false);
			//期初建账选择
			accountBuildIndex.setLocation(0,50);
			accountBuildIndex.setVisible(false);
			//期初建账信息
			accountInfomation.setLocation(55, 233);
			accountInfomation.setVisible(false);
			//期初建账——商品
			accountOfComs.setLocation(150, 210);
			accountOfComs.setVisible(false);
			//系统日志
			systemRecord.setLocation(55, 233);
			systemRecord.setVisible(false);
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
			this.add(businessCondition,11);
			this.add(accountBuildIndex,12);
			this.add(accountInfomation,13);
			this.add(businessProgress,14);
			this.add(saleDetail,15);
			this.add(systemRecord,16);
			this.add(accountOfComs,17);
			this.add(bg,18);
			
		}
    
	/*获取frame引用*/
    public void getFrame( Frame f){
    		frame=f;
    		function.getFrame(frame);
    		manageBills1.getFrame(frame);
    		manageBills2.getFrame(frame);
    		inquire.getFrame(frame);
    		account.getFrame(frame);
    		businessCondition.getFrame(frame);
    		accountBuildIndex.getFrame(frame);
    		systemRecord.getFrame(f);
    		businessCondition.getFrame(f);
      		businessProgress.getFrame(f);
      		saleDetail.getFrame(f);
      		accountOfComs.getFrame(f);
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
				FinancialUI.this.getAccountBuild().setVisible(false);
				FinancialUI.this.getBusinessCondition().setVisible(false);
				FinancialUI.this.getBusinessProgress().setVisible(false);
				FinancialUI.this.getSaleDetail().setVisible(false);
				FinancialUI.this.getAccountInfomation().setVisible(false);
				FinancialUI.this.getSystemRecord().setVisible(false);
				FinancialUI.this.getAccountOfComs().setVisible(false);
				FinancialUI.this.getFunction().setVisible(true);
				//标记当前面板，用于后退按钮
				frame.getFinancial().setPanelType(PanelType.JPfunction);
				break;
			case 2:
				back.setIcon(new ImageIcon("src/image/back1.png"));
				switch(panelType){
				case JPfunction:
					//实现登出跳转
					frame.getLogin().setVisible(true);
					FinancialUI.this.setVisible(false);
					break;
				case JPmanageBills1:
					manageBills1.setVisible(false);
					function.setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getFinancial().setPanelType(PanelType.JPfunction);
					break;
				case JPmanageBills2:
					manageBills2.setVisible(false);
					manageBills1.setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getFinancial().setPanelType(PanelType.JPmanageBills1);
					break;
					
				case JPmanageAccount:
					account.setVisible(false);
					function.setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getFinancial().setPanelType(PanelType.JPfunction);
					break;
				case JPinquire:
					inquire.setVisible(false);
					function.setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getFinancial().setPanelType(PanelType.JPfunction);
					break;
				case AccountBuildIndexPanel:
					accountBuildIndex.setVisible(false);
					account.setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getFinancial().setPanelType(PanelType.JPmanageAccount);
					break;
				case BusinessConditionPanel:
					businessCondition.setVisible(false);
					inquire.setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getFinancial().setPanelType(PanelType.JPinquire);
					break;
				case BusinessProcessPanel:
					businessProgress.setVisible(false);
					inquire.setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getFinancial().setPanelType(PanelType.JPinquire);
					break;
				case SaleDetailPanel:
					saleDetail.setVisible(false);
					inquire.setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getFinancial().setPanelType(PanelType.JPinquire);
					break;
				case InitialInfoPanel:
					accountInfomation.setVisible(false);
					accountBuildIndex.setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getFinancial().setPanelType(PanelType.AccountBuildIndexPanel);
					break;
				case JPaccountOfComs:
					accountOfComs.setVisible(false);
					accountBuildIndex.setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getFinancial().setPanelType(PanelType.AccountBuildIndexPanel);
					break;
				case JPSystemRecord:
					systemRecord.setVisible(false);
					inquire.setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getFinancial().setPanelType(PanelType.JPinquire);
					
					break;
				}
				break;
			case 3:
				signout.setIcon(new ImageIcon("src/image/signout1.png"));
				//实现登出跳转
				frame.getLogin().setVisible(true);
				FinancialUI.this.setVisible(false);
				break;
			}
			//一下面板的编辑面板归位
			FinancialUI.this.getManageBills2().reHome();
			FinancialUI.this.getAccount().reHome();
			FinancialUI.this.getBusinessCondition().reHome();
			FinancialUI.this.getBusinessProgress().reHome();
			FinancialUI.this.getSaleDetail().reHome();
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
	public BusinessProcessPanel getBusinessProgress() {
		return businessProgress;
	}
	public void setBusinessProgress(BusinessProcessPanel businessProgress) {
		this.businessProgress = businessProgress;
	}
		public SaleDetailPanel getSaleDetail() {
		return saleDetail;
	}
	public void setSaleDetail(SaleDetailPanel saleDetail) {
		this.saleDetail = saleDetail;
	}
	public BusinessConditionPanel getBusinessCondition() {
		return businessCondition;
	}
	public void setBusinessCondition(BusinessConditionPanel businessCondition) {
		this.businessCondition = businessCondition;
	}
	public AccountBuildIndexPanel getAccountBuild() {
		return accountBuildIndex;
	}
	public void setAccountBuild(AccountBuildIndexPanel accountBuild) {
		this.accountBuildIndex = accountBuild;
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
	public InitialInfoPanel getAccountInfomation() {
		return accountInfomation;
	}
	public void setAccountInfomation(InitialInfoPanel accountInfomation) {
		this.accountInfomation = accountInfomation;
	}
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
	public PanelType getPanelType() {
		return panelType;
	}

	public void setPanelType(PanelType panelType) {
		this.panelType = panelType;
	}

	public JPSystemRecord getSystemRecord()
	{
		return systemRecord;
	}

	public void setSystemRecord(JPSystemRecord systemRecord)
	{
		this.systemRecord = systemRecord;
	}

	public JPaccountOfComs getAccountOfComs()
	{
		return accountOfComs;
	}

	public void setAccountOfComs(JPaccountOfComs accountOfComs)
	{
		this.accountOfComs = accountOfComs;
	}
}
	

