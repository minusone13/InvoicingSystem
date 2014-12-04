package presentation.financialui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClientInfoPanel extends JPanel{
	String[] nameOfClent = {"姓名","编号","分类","级别","电话","地址","邮编","电子邮箱","应收额度","应收","应付","默认业务员"};
	String[] nameOfCommodity = {"商品名","编号","商品分类","型号","进价","售价","库存数量","最近进价","最近售价"};
	String[] nameOfAccount = {"姓名","金额"};
	
	DefaultTableModel model=new DefaultTableModel(new Object[][]{},nameOfClent);
	JTable table = new JTable(model);
	JScrollPane pane ;
	public ClientInfoPanel () {
		initial();
	}
	
	public void initial() {
		this.setBounds(0, 0, 960, 600);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		pane = new JScrollPane(table);
		this.add(pane);
		pane.setBounds(100, 100, 700, 400);
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
	
	
}
