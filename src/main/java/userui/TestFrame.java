package userui;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.financialui.JPfunctions;
import presentation.saleui.Sale;

public class TestFrame extends JFrame {

	public TestFrame(JPanel jp){
		// 取得屏幕的宽度
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		// 取得屏幕的高度
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		//设置窗口大小
		this.pack();
		// 将窗体的关闭方式设置为默认关闭后程序结束
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置布局
		this.setLayout(null);
		
		this.add(jp);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestFrame testJP=new TestFrame(new Sale());
	}

}
