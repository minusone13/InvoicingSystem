package presentation.financialui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SaleDetailPanel extends JPanel{
	
	String[] names = {"时间","商品名","型号","数量","单价","总额"};
	
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	JScrollPane pane;
	
	public SaleDetailPanel() {
		
		
	}
	
	private void initial() {
		this.setBounds(0, 0, 750, 300);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		
	}
}
