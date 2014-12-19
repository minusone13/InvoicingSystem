package presentation.managerui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.PanelType;
import entrance.Frame;

public class JPfunction extends JPanel {

	//背景
	JLabel bg=new JLabel();
	//功能1
	JLabel function1=new JLabel();
	//功能2
	JLabel function2=new JLabel();
	//功能3
	JLabel function3=new JLabel();
	//frame的引用
    Frame frame;
	public JPfunction(){
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
		function1.setIcon(new ImageIcon("src/image/managerUI/makeStrategy0.jpg"));
		function1.setBounds(21, 22, 160, 277);
		function1.addMouseListener(new MouseListenerOfButton(1));
		//功能2
		function2.setIcon(new ImageIcon("src/image/managerUI/passBill0.jpg"));
		function2.setBounds(181, 22, 160, 277);
		function2.addMouseListener(new MouseListenerOfButton(2));
		//功能3
		function3.setIcon(new ImageIcon("src/image/managerUI/read0.jpg"));
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
				function1.setIcon(new ImageIcon("src/image/managerUI/makeStrategy1.jpg"));
				break;
			case 2:
				function2.setIcon(new ImageIcon("src/image/managerUI/passBill1.jpg"));
				break;
			case 3:
				function3.setIcon(new ImageIcon("src/image/managerUI/read1.jpg"));
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				function1.setIcon(new ImageIcon("src/image/managerUI/makeStrategy.jpg"));
				JPfunction.this.setVisible(false);
				frame.getManager().getManagerStrategy1().setVisible(true);
				//标记当前面板，用于后退按钮
				frame.getManager().setPanelType(PanelType.JPmanagerStrategy1);
				break;
			case 2:
				function2.setIcon(new ImageIcon("src/image/managerUI/passBill.jpg"));
				JPfunction.this.setVisible(false);
				frame.getManager().getPassbill1().setVisible(true);
				//标记当前面板，用于后退按钮
				frame.getManager().setPanelType(PanelType.JPpassBill1);
				break;
			case 3:
				function3.setIcon(new ImageIcon("src/image/managerUI/read.jpg"));
				JPfunction.this.setVisible(false);
				frame.getManager().getInquire().setVisible(true);
				//标记当前面板，用于后退按钮
				frame.getManager().setPanelType(PanelType.JPinquire);
				break;
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				function1.setIcon(new ImageIcon("src/image/managerUI/makeStrategy.jpg"));
				break;
			case 2:
				function2.setIcon(new ImageIcon("src/image/managerUI/passBill.jpg"));
				break;
			case 3:
				function3.setIcon(new ImageIcon("src/image/managerUI/read.jpg"));
				break;
			}
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				function1.setIcon(new ImageIcon("src/image/managerUI/makeStrategy0.jpg"));
				break;
			case 2:
				function2.setIcon(new ImageIcon("src/image/managerUI/passBill0.jpg"));
				break;
			case 3:
				function3.setIcon(new ImageIcon("src/image/managerUI/read0.jpg"));
				break;
			}
		}
		
	}
}
