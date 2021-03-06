package entrance;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.commodityui.StockCheckPanel;
import presentation.commodityui.StockInventoryPanel;
import presentation.financialui.BusinessConditionPanel;
import presentation.financialui.BusinessProcessPanel;
import presentation.financialui.SaleDetailPanel;
import presentation.managerui.MouseListenerGetXY;
import presentation.userui.JPmanageUser;



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
		this.setBounds(100, 100, 960, 600);
		this.add(jp);
		this.setVisible(true);
		this.addMouseListener(new MouseListenerGetXY());
	}
	public static void main(String[] args) {
//		JPManagerCom test=new JPManagerCom();
//		test.setRole(Role.STOCK_STAFF);
	
//		InitialInfoPanel t = new InitialInfoPanel();
//		t.update(2);
		TestFrame testJP=new TestFrame(new StockCheckPanel());
//		JPmanagerStrategy2 test=new JPmanagerStrategy2();
//		test.setStyle(StrategyStyle.ReachStrategy);
		
	}

}
