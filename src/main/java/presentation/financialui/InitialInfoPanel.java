package presentation.financialui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InitialInfoPanel extends JPanel{
	String[] nameOfClent = {"姓名","编号","分类","级别","电话","地址","邮编","电子邮箱","应收额度","应收","应付","默认业务员"};
	String[] nameOfCommodity = {"商品名","编号","商品分类","型号","进价","售价","库存数量","最近进价","最近售价"};
	String[] nameOfAccount = {"姓名","金额"};
	
	DefaultTableModel model=new DefaultTableModel(new Object[][]{},nameOfClent);
	JTable table = new JTable(model);
	JScrollPane pane;
	JComboBox box;
	
	public InitialInfoPanel () {
		initial();
	}
	
	public void initial() {
		this.setBounds(0, 0, 960, 600);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		pane = new JScrollPane(table);
		box = new JComboBox();
		this.add(pane);
		pane.setBounds(100, 300, 750, 250);
		
		this.add(box);
		box.setBounds(100, 270, 80, 20);
		
		box.addItem("aa");
		box.addItem("bb");
		box.addItem("cc");
		box.setEditable(false);
		box.addItemListener(new versionItemListener());
	}
	
	public void update(int type, String version) {
		if(type == 1) {
			Object[][] date = getDate(version);
			model.setDataVector(date, nameOfClent);
			table.updateUI();
		}
	}
	private Object[][] getDate(String version) {
		return null;
	}
	
	public class versionItemListener implements ItemListener {

		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				String s = e.getItem().toString();
				
			}
		}
	
}
}


