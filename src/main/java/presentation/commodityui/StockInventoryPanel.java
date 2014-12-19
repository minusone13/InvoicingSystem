package presentation.commodityui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * 库存盘点面板
 * 
 * */
public class StockInventoryPanel extends JPanel{

	String[] names = {"行号","商品名","型号","库存数量","库存均价","批次","批号"};
	DefaultTableModel model=new DefaultTableModel(new Object[][]{},names);
	JTable table = new JTable(model);
	JScrollPane pane = new JScrollPane(table);
	public StockInventoryPanel() {
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
