package presentation.managerui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPfunction extends JPanel {

	//背景
	JLabel bg=new JLabel();
	//功能1
	JLabel function1=new JLabel();
	//功能2
	JLabel function2=new JLabel();
	//功能3
	JLabel function3=new JLabel();
	public JPfunction(){
		//设置窗口大小
		this.setSize(522, 325);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		bg.setIcon(new ImageIcon("src/image/managerUI/block.png"));
		bg.setBounds(0, 0, 522, 325);
		//功能1
		function1.setIcon(new ImageIcon("src/image/managerUI/makeStrategy.jpg"));
		function1.setBounds(21, 22, 160, 277);
		//功能2
		function2.setIcon(new ImageIcon("src/image/managerUI/passBill.jpg"));
		function2.setBounds(181, 22, 160, 277);
		//功能3
		function3.setIcon(new ImageIcon("src/image/managerUI/read.jpg"));
		function3.setBounds(341, 22, 160, 277);
		this.add(function1,0);
		this.add(function2,1);
		this.add(function3,2);
		this.add(bg,3);

	}
}
