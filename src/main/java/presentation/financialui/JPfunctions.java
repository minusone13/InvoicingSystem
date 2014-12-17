package presentation.financialui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.managerui.JPfunction;
import presentation.managerui.JPfunction.MouseListenerOfButton;
import userui.Frame;

public class JPfunctions extends JPanel {

	//背景
	JLabel bg=new JLabel();
	//功能1
	JLabel function1=new JLabel();
	//功能2
	JLabel function2=new JLabel();
	//功能3
	JLabel function3=new JLabel();
	//图片
	ImageIcon Imagefun1=new ImageIcon("src/image/financialUI/accountIndex.png");
	ImageIcon Imagefun2=new ImageIcon("src/image/financialUI/billIndex.png");
	ImageIcon Imagefun3=new ImageIcon("src/image/financialUI/inquiryIndex.png");
	ImageIcon Imagefun10=new ImageIcon("src/image/financialUI/accountIndex0.png");
	ImageIcon Imagefun20=new ImageIcon("src/image/financialUI/billIndex0.png");
	ImageIcon Imagefun30=new ImageIcon("src/image/financialUI/inquiryIndex0.png");
	ImageIcon Imagefun11=new ImageIcon("src/image/financialUI/accountIndex1.png");
	ImageIcon Imagefun21=new ImageIcon("src/image/financialUI/billIndex1.png");
	ImageIcon Imagefun31=new ImageIcon("src/image/financialUI/inquiryIndex1.png");
	//frame的引用
    Frame frame;
	public JPfunctions(){
		//设置窗口大小
		this.setSize(522, 325);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		bg.setIcon(new ImageIcon("src/image/block/blockForFunctions.png"));
		bg.setBounds(0, 0, 522, 325);
		//功能1
		function1.setIcon(Imagefun10);
		function1.setBounds(21, 22, 160, 277);
		function1.addMouseListener(new MouseListenerOfButton(1));
		//功能2
		function2.setIcon(Imagefun20);
		function2.setBounds(181, 22, 160, 277);
		function2.addMouseListener(new MouseListenerOfButton(2));
		//功能3
		function3.setIcon(Imagefun30);
		function3.setBounds(341, 22, 160, 277);
		function3.addMouseListener(new MouseListenerOfButton(3));
		this.add(function1,0);
		this.add(function2,1);
		this.add(function3,2);
		this.add(bg,3);

	}
	/*获取frame的引用*/
	public void getFrame( Frame f){
  		frame=f;
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
				function1.setIcon(Imagefun11);
				break;
			case 2:
				function2.setIcon(Imagefun21);
				break;
			case 3:
				function3.setIcon(Imagefun31);
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				function1.setIcon(Imagefun1);
				JPfunctions.this.setVisible(false);
				frame.getFinancial().getAccount().setVisible(true);
				break;
			case 2:
				function2.setIcon(Imagefun2);
				
				JPfunctions.this.setVisible(false);
				frame.getFinancial().getManageBills1().setVisible(true);
				break;
			case 3:
				function3.setIcon(Imagefun3);
				JPfunctions.this.setVisible(false);
				frame.getFinancial().getInquire().setVisible(true);
				break;
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				function1.setIcon(Imagefun1);
				break;
			case 2:
				function2.setIcon(Imagefun2);
				break;
			case 3:
				function3.setIcon(Imagefun3);
				break;
			}
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				function1.setIcon(Imagefun10);
				break;
			case 2:
				function2.setIcon(Imagefun20);
				break;
			case 3:
				function3.setIcon(Imagefun30);
				break;
			}
		}
		
	}
}
