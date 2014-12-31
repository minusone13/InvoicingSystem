package presentation.financialui;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import vo.CustomerVO;
import vo.accountVO.AccountVO;
import businesslogic.financialbl.Financial;
import businesslogicservice.financialblservice.FinancialBlService;

//显示期初建账信息
public class InitialInfoPanel extends JPanel{
	FinancialBlService financial = new Financial();
	String[] nameOfClent = {"姓名","编号","分类","级别","电话","地址","邮编","电子邮箱","应收额度","应收","应付","默认业务员"};
	String[] nameOfAccount = {"姓名","金额"};
	
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	JScrollPane pane;
	ArrayList<String> versions = financial.getVersions();
	JComboBox box;
	int type;
	
	ImageIcon bgIcon=new ImageIcon("src\\image\\accountUI\\期初信息背景.png");
	ImageIcon bgIcon1=new ImageIcon("src\\image\\accountUI\\期初信息背景1.png");
	
	JLabel bg = new JLabel(bgIcon);
	JLabel bg1 = new JLabel(bgIcon1);
	public InitialInfoPanel () {
		initial();		
	}
	
	private void initial() {
		this.setBounds(0, 0, 750, 300);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		bg.setBounds(0, 0, 750, 300);
		bg1.setBounds(0, 15, 750, 30);
		
		//设置表格透明
		table.setEnabled(false);
		table.setOpaque(false);
		DefaultTableCellRenderer render1 = new DefaultTableCellRenderer();   
        render1.setOpaque(false); //将渲染器设置为透明  
        table.setDefaultRenderer(Object.class,render1);  
        table.setForeground(Color.white);
        table.setBorder(null);
        table.setShowVerticalLines(false);
        
      //滚动面板透明
        
        pane = new JScrollPane(table);
        pane.setOpaque(false);//设置透明
		pane.getViewport().setOpaque(false);//设置透明
		pane.setBorder(null);
		
		box = new JComboBox();
		this.add(pane,0);
		pane.setBounds(0, 50, 750, 250);
		
		this.add(box,1);
		box.setBounds(0, 20, 120, 20);
		box.setForeground(Color.white);
		box.setBackground(Color.black);
		
		if(versions==null) versions = new ArrayList<String>();
		int size = versions.size();
		for(int i=0;i<size;i++){
			box.addItem(versions.get(i));
		}
		this.add(bg,2);
		this.add(bg1,3);
		box.setEditable(false);
		box.addItemListener(new versionItemListener());
	}
	
	public void update(int t) {
		this.type = t;
		versions = financial.getVersions();
		if(versions==null) versions = new ArrayList<String>();
		int size = versions.size();
		int num = box.getItemCount();
		for(int i=0;i<num;i++) box.removeItemAt(0);
		for(int i=0;i<size;i++){
			box.addItem(versions.get(i));
		}
		Object[][] data;
		switch(type) {
			
		case 1: 
			if(size!=0) update(versions.get(size-1));
			else {
				model.setDataVector(new Object[][]{}, nameOfClent);
				table.updateUI();
			}
		pane.setBounds(0, 50, 750, 250);	
		break;
		case 2: 
			if(size!=0) update(versions.get(size-1));
			else {
				model.setDataVector(new Object[][]{}, nameOfAccount);
				table.updateUI();
			}
		pane.setBounds(0, 50, 250, 250);
				break;
		}
	}
	
	public void update(String version) {
		
		Object[][] data;
		switch(type) {
		case 1: data = getOldCustomersInfo(version);
				model.setDataVector(data, nameOfClent);
				table.updateUI();
				break;
		case 2: data = getOldAccountsInfo(version);
				model.setDataVector(data, nameOfAccount);
				table.updateUI();
				break;
		}
	}
	private Object[][] getOldCustomersInfo(String version) {
		 ArrayList<CustomerVO> customer = financial.getOldCustomersInfo(version);
		 int size = customer.size();
		
		 Object[][] data = new Object[size][];
		 for(int i=0;i<size;i++) {
			 CustomerVO vo = customer.get(i);
			 Object[] temp ={vo.getname(), vo.getid(), vo.gettype(), vo.getlevel(),
					 vo.getphonenumber(), vo.getaddress(),vo.getpostcode(), vo.getemail(),
					 vo.getmaxOwe(), vo.getShouldTake(), vo.getShouldPay(), vo.getdeSaler()};
			 data[i] = temp;
		 }
		return data;
	}
	
	private Object[][] getOldAccountsInfo(String version) {
		 ArrayList<AccountVO> account = financial.getOldAccountsInfo(version);
		 int size = account.size();
		 Object[][] data = new Object[size][];
		 for(int i=0;i<size;i++) {
			 AccountVO vo = account.get(i);
			 Object[] temp ={vo.getName(), vo.getBalance()};
			 data[i] = temp;
		 }
		return data;
	}
	public class versionItemListener implements ItemListener {

		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				String s = e.getItem().toString();
				update(s);
			}
		}
	
}
}


