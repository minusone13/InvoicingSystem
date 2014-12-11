package presentation.commodityui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.financialui.JPfunctions;
import userui.Frame;

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
		function1.setIcon(new ImageIcon("src/image/stockUI/Commodity0.png"));
		function1.setBounds(21, 22, 160, 277);
		function1.addMouseListener(new MouseListenerOfButton(1));
		//功能2
		function2.setIcon(new ImageIcon("src/image/stockUI/Bill0.png"));
		function2.setBounds(181, 22, 160, 277);
		function2.addMouseListener(new MouseListenerOfButton(2));
		//功能3
		function3.setIcon(new ImageIcon("src/image/stockUI/Read0.png"));
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
				function1.setIcon(new ImageIcon("src/image/stockUI/Commodity1.png"));
				break;
			case 2:
				function2.setIcon(new ImageIcon("src/image/stockUI/Bill1.png"));
				break;
			case 3:
				function3.setIcon(new ImageIcon("src/image/stockUI/Read1.png"));
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				function1.setIcon(new ImageIcon("src/image/stockUI/Commodity.png"));
				break;
			case 2:
				function2.setIcon(new ImageIcon("src/image/stockUI/Bill.png"));
				JPfunction.this.setVisible(false);
				frame.getStock().getManageBills().setVisible(true);
				break;
			case 3:
				function3.setIcon(new ImageIcon("src/image/stockUI/Read.png"));
				break;
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				function1.setIcon(new ImageIcon("src/image/stockUI/Commodity.png"));
				break;
			case 2:
				function2.setIcon(new ImageIcon("src/image/stockUI/Bill.png"));
				break;
			case 3:
				function3.setIcon(new ImageIcon("src/image/stockUI/Read.png"));
				break;
			}
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				function1.setIcon(new ImageIcon("src/image/stockUI/Commodity0.png"));
				break;
			case 2:
				function2.setIcon(new ImageIcon("src/image/stockUI/Bill0.png"));
				break;
			case 3:
				function3.setIcon(new ImageIcon("src/image/stockUI/Read0.png"));
				break;
			}
		}
		
	}
}

