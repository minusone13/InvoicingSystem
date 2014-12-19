package presentation.commodityui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StockCheckPanel extends JPanel{
	
	String[] names = {"商品","出/入库","数量","金额","库存数量"};
	DefaultTableModel model=new DefaultTableModel(new Object[][]{},names);
	JTable table = new JTable(model);
	JScrollPane pane = new JScrollPane(table);
	public StockCheckPanel() {
		initial();
	}
	
	public void initial() {
		this.setBounds(0, 0, 400, 150);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		add(pane);
		pane.setBounds(0, 0, 400, 150);
	}
}
