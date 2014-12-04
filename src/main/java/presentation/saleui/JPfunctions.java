package presentation.saleui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPfunctions extends JPanel{
	//background
	JLabel bg = new JLabel();
	//function1&function2
	JLabel function1 = new JLabel();
	JLabel function2 = new JLabel();
	
	ImageIcon Imagefun1 = new ImageIcon("src/image/saleUI/customerIndex.png");
	ImageIcon Imagefun2 = new ImageIcon("src/image/saleUI/salebillIndex.png");
	ImageIcon Imagefun10 = new ImageIcon("src/image/saleUI/customerIndex0.png");
	ImageIcon Imagefun20 = new ImageIcon("src/image/saleUI/salebillIndex0.png");
	ImageIcon Imagefun11 = new ImageIcon("src/image/saleUI/customerIndex1.png");
	ImageIcon Imagefun21 = new ImageIcon("src/image/saleUI/salebillIndex1.png");
	
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
		this.add(function1,0);
		this.add(function2,1);
		this.add(bg,2);
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
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				function1.setIcon(Imagefun1);
				break;
			case 2:
				function2.setIcon(Imagefun2);
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
			}
		}
		
	}

}
