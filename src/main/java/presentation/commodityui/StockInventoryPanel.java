package presentation.commodityui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entrance.Frame;

/*
 * 库存盘点面板
 * 
 * */
public class StockInventoryPanel extends JPanel{

	String[] names = {"行号","商品名","型号","库存数量","库存均价","批次","批号"};
	DefaultTableModel model=new DefaultTableModel(new Object[][]{},names);
	JTable table = new JTable(model);
	JScrollPane pane = new JScrollPane(table);
	//frame的引用
    Frame frame;
	public StockInventoryPanel() {
		initial();
	}
	
	public void initial() {
		this.setBounds(0, 0, 400, 315);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景图
		JLabel jpbg1=new JLabel();
		jpbg1.setBounds(0, 0, 400, 315);
		jpbg1.setIcon(new ImageIcon("src/image/block/blockForTable.png"));
		//表格透明
		table.setOpaque(false);
        DefaultTableCellRenderer render1 = new DefaultTableCellRenderer();   
        render1.setOpaque(false); //将渲染器设置为透明  
        table.setDefaultRenderer(Object.class,render1);  
        table.setForeground(Color.white);
        table.setBorder(null);
        table.setShowVerticalLines(false);
		//滚动面板透明
        pane.setOpaque(false);//设置透明
		pane.getViewport().setOpaque(false);//设置透明
		pane.setBorder(null);
		pane.setBounds(0, 0, 400, 315);
		
		add(pane,0);
		add(jpbg1,1);
		
	}
	/*获取frame的引用*/
	public void getFrame( Frame f){
  		frame=f;
    }
}
