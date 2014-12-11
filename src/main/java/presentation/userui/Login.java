package presentation.userui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import userui.Frame;
import vo.RM;
import vo.uservo.UserVO;
import businesslogic.Role;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.StubUserBlService;


public class Login extends JPanel {

	//操作员信息
	public static UserVO user;
	//背景
	private JLabel bg=new JLabel();
	//隐藏的注册面板
	private JPregister jpRegister=new JPregister();
	//按钮
	private JLabel signIn=new JLabel();
	private JLabel register=new JLabel();
	//两个按钮的监控
	private MouseListenerOfButton m1=new MouseListenerOfButton(1);
	private MouseListenerOfButton m2=new MouseListenerOfButton(2);
	// 用户名输入框
	private JTextField username=new JTextField(16);  
	// 密码输入框
    private JPasswordField passwords=new JPasswordField(16); 
	//用户登录与注册接口
    StubUserBlService userService=new UserController();
    //frame的引用
    Frame frame;
    public Login(){

		//设置窗口大小
		this.setSize(960, 600);
		//设置布局
		this.setLayout(null);
		

		//背景
		bg.setIcon(new ImageIcon("src/image/userUi/login.png"));
		bg.setBounds(0, 0, 960, 600);
		

		//按钮
		signIn.setSize(129, 48);
		register.setSize(129, 48);
		signIn.setIcon(new ImageIcon("src/image/userUi/sign in.png") );
		register.setIcon(new ImageIcon("src/image/userUi/register.png") );
		signIn.setLocation(350, 470);
		register.setLocation(500, 470);
		
		signIn.addMouseListener(m1);
		register.addMouseListener(m2);
		//文本框

		username.setBounds(372, 346, 250, 30);
		username.setBorder(new EmptyBorder(0,0,0,0));//文本框无边框
		username.setOpaque(false);//文本框透明
		username.setForeground(Color.white);//前景色
		passwords.setBounds(372, 410, 250, 30);
		passwords.setBorder(new EmptyBorder(0,0,0,0));
		passwords.setOpaque(false);
		passwords.setForeground(Color.white);
		
		//注册面板
		jpRegister.setLocation(310, 220);
		jpRegister.setVisible(false);
		
		this.add(jpRegister,0);
		this.add(signIn,1);
		this.add(register,2);
		this.add(username,3);
		this.add(passwords,4);
		this.add(bg,5);
	}
    /*获取frame引用*/
    public void getFrame( Frame f){
    		frame=f;
    }
	public class MouseListenerOfButton implements MouseListener{

		private int num;
		private boolean work=true;
		public MouseListenerOfButton(int N){
			num=N;
		}
		public void setWork(boolean work){
			this.work=work;
		}
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if(work){
				if(num==1){
					
					signIn.setIcon(new ImageIcon("src/image/userUi/sign in2.png")  );
				
				}
				else if(num==2){
					register.setIcon(new ImageIcon("src/image/userUi/register2.png") );
					
				
				}
			}
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(work){
				if(num==1){
					
					signIn.setIcon(new ImageIcon("src/image/userUi/sign in.png")  );
					//登录
					String userName=username.getText();
					String passWords=new String(passwords.getPassword());
					boolean legal=false;
					//判断是否输入合法
					if(!userName.equals("")&&!passWords.equals("")){
						legal=true;
					}
					//如果合法就登录
					if(legal){
						UserVO userVO=userService.login(userName,passWords);
						if(userVO!=null){
							System.out.println("登录的是："+userVO.getR());
							//将当前操作员信息赋值给当前登录面板的静态变量
							user=userVO;
							//切换面板
							switch(userVO.getR()){
							case ADMINISTRATOR:
								break;
							case FINANCIAL_STAFF:
								Login.this.setVisible(false);
								frame.getFinancial().setVisible(true);
								break;
							case FINANCIAL_MANAGER:
								break;
							case MANAGER:
								Login.this.setVisible(false);
								frame.getManager().setVisible(true);
								break;
							case STOCK_STAFF:
								Login.this.setVisible(false);
								frame.getStock().setVisible(true);
								break;
							case PURCHASE_SALE_STAFF:
								Login.this.setVisible(false);
								frame.getSale().setVisible(true);
								break;
							}
							//清除文本框内容
							username.setText("");
							passwords.setText("");
						}
						else{
							System.out.println("用户名或密码错误，请重新输入");
						}
						
					}
					else{
						System.out.println("请输入用户名和密码");
					}
				}
				else if(num==2){
					register.setIcon(new ImageIcon("src/image/userUi/register.png") );
					//取消监控
				    m1.work=false;
				    m2.work=false;
					//清除文本框内容
					username.setText("");
					passwords.setText("");
					jpRegister.setVisible(true);//显示注册面板
				}
			}
		
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(work){
				if(num==1){
					
					signIn.setIcon(new ImageIcon("src/image/userUi/sign in.png")  );
					
				}
				else if(num==2){
					register.setIcon(new ImageIcon("src/image/userUi/register.png") );
				}
			}
		
		}
		
	}
	public class JPregister extends JPanel{
		//确认按钮
		private JLabel confirm=new JLabel();
		//取消按钮
		private JLabel cancel=new JLabel();
		
		//下拉框
		private JComboBox roleComboBox;
		// 姓名输入框
		private JTextField name=new JTextField(16); 
		// 用户名输入框
		private JTextField username=new JTextField(16); 
		// 密码输入框
		private JPasswordField passwords=new JPasswordField(16);
		
		public JPregister(){
			this.setSize(350, 300);
			//设置布局
			this.setLayout(null);
			//设置面板透明
			this.setOpaque(false);
			//背景
			JLabel back=new JLabel();
			back.setIcon(new ImageIcon("src/image/userUi/registerBG.png"));
			back.setBounds(0, 0, 350, 300);
			//确认按钮
			confirm.setIcon(new ImageIcon("src/image/ChooseCom/confirm.png") );
			confirm.setBounds(140, 250, 24, 24);
			MouseListenerOfButton m1=new MouseListenerOfButton(1);
			confirm.addMouseListener(m1);
			//取消按钮
			cancel.setIcon(new ImageIcon("src/image/userUi/cancel.png") );
			cancel.setBounds(186, 250, 24, 24);
			MouseListenerOfButton m2=new MouseListenerOfButton(2);
			cancel.addMouseListener(m2);
			//选择下拉框
			String[] role = { "总经理", "财务人员","进销人员", "库存管理人员","财务主管" };
			roleComboBox = new JComboBox(role);
			roleComboBox.setFont(new Font("隶书",Font.BOLD,20));
			roleComboBox.setBounds(75, 15, 240, 38);
			roleComboBox.setBackground(Color.gray);
			roleComboBox.setForeground(Color.white);
			//姓名输入框
			name.setBounds(75, 70, 240, 30);
			name.setBorder(new EmptyBorder(0,0,0,0));//文本框无边框
			name.setOpaque(false);//文本框透明
			name.setForeground(Color.white);//前景色
			//用户名输入框
			username.setBounds(75, 123, 240, 30);
			username.setBorder(new EmptyBorder(0,0,0,0));//文本框无边框
			username.setOpaque(false);//文本框透明
			username.setForeground(Color.white);//前景色
			//密码输入框
			passwords.setBounds(75, 177, 240, 30);
			passwords.setBorder(new EmptyBorder(0,0,0,0));//文本框无边框
			passwords.setOpaque(false);//文本框透明
			passwords.setForeground(Color.white);//前景色
			
			
			this.add(confirm,0);
			this.add(cancel,1);
			this.add(roleComboBox,2);
			this.add(name,3);
			this.add(username,4);
			this.add(passwords,5);
			this.add(back,6);
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
					
					confirm.setIcon(new ImageIcon("src/image/userUi/confirmR.png") );
				
					break;
				case 2:
					cancel.setIcon(new ImageIcon("src/image/userUi/cancelR.png") );
				
					break;
				}
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				switch(num){
				case 1:
					confirm.setIcon(new ImageIcon("src/image/userUi/confirmW.png") );
					//实现注册
					String s1=name.getText();
					String s2=username.getText();
					String s3=new String(passwords.getPassword());
					String r=roleComboBox.getSelectedItem().toString();
					Role role=null;
					//判断给role赋值
					if(r.equals("总经理")){
						role=Role.MANAGER;
					}
					else if(r.equals("财务人员")){
						role=Role.FINANCIAL_STAFF;
					}
					else if(r.equals("财务主管")){
						role=Role.FINANCIAL_MANAGER;
					}
					else if(r.equals("进销人员")){
						role=Role.PURCHASE_SALE_STAFF;
					}
					else if(r.equals("库存管理人员")){
						role=Role.STOCK_STAFF;
					}
					boolean legal=false;
					//判断输入是否合法
					if(!s1.equals("")&&!s2.equals("")&&!s3.equals("")){
						legal=true;
					}
					//如果合法就注册
					if(legal){
						//注册
						UserVO userVo=new UserVO(role,s2,s3,s1);
						RM rm=userService.signUp(userVo);
						System.out.println("注册结果是："+rm);
						//隐藏注册面板
						JPregister.this.setVisible(false);
						//恢复监控
					    m1.work=true;
					    m2.work=true;
					    //清除文本框信息
						//清除文本框内容
					    name.setText("");
						username.setText("");
						passwords.setText("");
					}
					else{
						System.out.println("输入不合法");
					}
				
					break;
				case 2:
					cancel.setIcon(new ImageIcon("src/image/userUi/cancelW.png") );
					//隐藏注册面板
					JPregister.this.setVisible(false);
					//恢复监控
				    m1.work=true;
				    m2.work=true;
					break;
				}
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				switch(num){
				case 1:
					confirm.setIcon(new ImageIcon("src/image/userUi/confirmW.png") );
					break;
				case 2:
					cancel.setIcon(new ImageIcon("src/image/userUi/cancelW.png") );
					break;
				}
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				switch(num){
				case 1:
					confirm.setIcon(new ImageIcon("src/image/userUi/confirm.png") );
					break;
				case 2:
					cancel.setIcon(new ImageIcon("src/image/userUi/cancel.png") );
					break;
				}
			}
			
		}
	}
}
