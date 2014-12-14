package presentation.financialui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import businesslogic.financialbl.Financial;
import businesslogicservice.financialblservice.FinancialBlService;

public class InitialInfoPanel extends JPanel{
	FinancialBlService financial = new Financial();
	String[] nameOfClent = {"姓名","编号","分类","级别","电话","地址","邮编","电子邮箱","应收额度","应收","应付","默认业务员"};
	String[] nameOfCommodity = {"商品名","编号","商品分类","型号","进价","售价","库存数量","最近进价","最近售价"};
	String[] nameOfAccount = {"姓名","金额"};
	
	DefaultTableModel model;
	JTable table = new JTable(model);
	JScrollPane pane;
	ArrayList<String> versions = financial.getVersions();
	JComboBox box;
	
	public InitialInfoPanel () {
		initial();
	}
	
	private void initial() {
		this.setBounds(0, 0, 750, 300);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		
		pane = new JScrollPane(table);
		box = new JComboBox();
		this.add(pane);
		pane.setBounds(0, 50, 750, 250);
		
		this.add(box);
		box.setBounds(0, 20, 120, 20);
		
		int size = versions.size();
		for(int i=0;i<size;i++){
			box.addItem(versions.get(i));
		}
		
		box.setEditable(false);
		box.addItemListener(new versionItemListener());
	}
	
//	public void update(int type, String version) {
//		if(type == 1) {
//			Object[][] data = getOldCustomersInfo(version);
//			model.setDataVector(data, nameOfClent);
//			table.updateUI();
//		}
//	}
//	private Object[][] getOldCustomersInfo(String version) {
//		
//		return financial.getOldCustomersInfo(version);
//	}
	
	public class versionItemListener implements ItemListener {

		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				String s = e.getItem().toString();
				
			}
		}
	
}
}


