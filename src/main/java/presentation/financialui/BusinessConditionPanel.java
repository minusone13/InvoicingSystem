package presentation.financialui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import presentation.financialui.InitialInfoPanel.versionItemListener;

public class BusinessConditionPanel extends JPanel{
	String[] earn = {"折让后总收入","折让","商品报溢收入","成本调价收入","代金券与实际收款差额收入"};
	String[] pay = {"销售成本","商品报损","商品赠出"};
	String[] profit = {"利润"};
	
	DefaultTableModel modelOfEarn=new DefaultTableModel(new Object[][]{},earn);
	JTable tableOfEarn = new JTable(modelOfEarn);
	JScrollPane paneOfEarn;
	
	DefaultTableModel modelOfPay=new DefaultTableModel(new Object[][]{},pay);
	JTable tableOfPay = new JTable(modelOfPay);
	JScrollPane paneOfPay;
	
	DefaultTableModel modelOfProfit=new DefaultTableModel(new Object[][]{},profit);
	JTable tableOfProfit = new JTable(modelOfProfit);
	JScrollPane paneOfProfit;
	
	JTextField year, month, day;
	JLabel ye, mo, da;
	public BusinessConditionPanel() {
		initial();
	}
	
	public void initial() {
		this.setBounds(0, 0, 960, 600);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		paneOfEarn = new JScrollPane(tableOfEarn);
		this.add(paneOfEarn);
		paneOfEarn.setBounds(100, 230, 700, 100);
		
		paneOfPay = new JScrollPane(tableOfPay);
		this.add(paneOfPay);
		paneOfPay.setBounds(100, 360, 300, 100);
		
		paneOfProfit = new JScrollPane(tableOfProfit);
		this.add(paneOfProfit);
		paneOfProfit.setBounds(430, 360, 60, 100);		
		
		year = new JTextField(4);
		ye = new JLabel("年");
		month = new JTextField(2);
		mo = new JLabel("月");
		day = new JTextField(2);
		da = new JLabel("日");
		
		add(year);
		year.setBounds(0, 0, 5, 10);
	}
}
