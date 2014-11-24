package presentation.userui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Login extends JPanel {

	//背景
	JLabel bg=new JLabel();
	//按钮
	JLabel signIn=new JLabel();
	JLabel register=new JLabel();
	private JTextField username=new JTextField(16); ; // 用户名输入框
    private JPasswordField password=new JPasswordField(16); // 密码输入框
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
		signIn.addMouseListener(new MouseListenerOfButton(1));
		register.addMouseListener(new MouseListenerOfButton(2));
		//文本框

		username.setBounds(372, 346, 250, 30);
		username.setBorder(new EmptyBorder(0,0,0,0));//文本框无边框
		username.setOpaque(false);//文本框透明
		username.setForeground(Color.white);//前景色
		password.setBounds(372, 410, 250, 30);
		password.setBorder(new EmptyBorder(0,0,0,0));
		password.setOpaque(false);
		password.setForeground(Color.white);
		
		this.add(signIn,0);
		this.add(register,1);
		this.add(username,2);
		this.add(password,3);
		this.add(bg,4);
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
			
				signIn.setIcon(new ImageIcon("src/image/userUi/sign in2.png")  );
				
			}
			else if(num==2){
				register.setIcon(new ImageIcon("src/image/userUi/register2.png") );
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(num==1){
				
				signIn.setIcon(new ImageIcon("src/image/userUi/sign in.png")  );
				
			}
			else if(num==2){
				register.setIcon(new ImageIcon("src/image/userUi/register.png") );
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(num==1){
				
				signIn.setIcon(new ImageIcon("src/image/userUi/sign in.png")  );
				
			}
			else if(num==2){
				register.setIcon(new ImageIcon("src/image/userUi/register.png") );
			}
		}
		
	}
}
