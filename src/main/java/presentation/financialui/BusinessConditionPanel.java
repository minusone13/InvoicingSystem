package presentation.financialui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import businesslogic.financialbl.Financial;
import businesslogicservice.financialblservice.FinancialBlService;
import presentation.financialui.InitialInfoPanel.versionItemListener;
import tool.Export;
import userui.Frame;
import vo.inquiryVO.BusinessSituationVO;
import vo.inquiryVO.InquiryConditionVO;

public class BusinessConditionPanel extends JPanel{
	FinancialBlService financial = new Financial();
	String[] earn1 = {"折让后总收入","折让","销售收入","商品报溢收入"};
	String[] earn2 = {"成本调价收入","代金券与实际收款差额收入"};
	String[] pay = {"总支出","销售成本","商品报损","商品赠出"};
	String[] profit = {"利润"};
	
	DefaultTableModel modelOfEarn1=new DefaultTableModel(new Object[][]{},earn1);
	JTable tableOfEarn1 = new JTable(modelOfEarn1);
	JScrollPane paneOfEarn1;
	
	DefaultTableModel modelOfEarn2=new DefaultTableModel(new Object[][]{},earn2);
	JTable tableOfEarn2 = new JTable(modelOfEarn2);
	JScrollPane paneOfEarn2;
	
	DefaultTableModel modelOfPay=new DefaultTableModel(new Object[][]{},pay);
	JTable tableOfPay = new JTable(modelOfPay);
	JScrollPane paneOfPay;
	
	DefaultTableModel modelOfProfit=new DefaultTableModel(new Object[][]{},profit);
	JTable tableOfProfit = new JTable(modelOfProfit);
	JScrollPane paneOfProfit;
	
	JTextField year, month, day, year2, month2, day2;
	JLabel ye, mo, da, ye2, mo2, da2;
	JLabel sure = new JLabel();
	ImageIcon sureIcon1=new ImageIcon("src\\image\\InquiryUI\\确定.png");
	ImageIcon sureIcon0=new ImageIcon("src\\image\\InquiryUI\\确定灰.png");
	
	//frame的引用
    Frame frame;
	public BusinessConditionPanel() {
		initial();
	}
	 public void getFrame( Frame f){
	 		frame=f;
	 }
	public void initial() {
		this.setBounds(0, 0, 960, 180);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		paneOfEarn1 = new JScrollPane(tableOfEarn1);
		this.add(paneOfEarn1);
		paneOfEarn1.setBounds(10, 30, 400, 50);
		tableOfEarn1.setOpaque(false);
		
		paneOfEarn2 = new JScrollPane(tableOfEarn2);
		this.add(paneOfEarn2);
		paneOfEarn2.setBounds(10, 80, 400, 50);
		tableOfEarn2.setOpaque(false);
		
		paneOfPay = new JScrollPane(tableOfPay);
		this.add(paneOfPay);
		paneOfPay.setBounds(10, 130, 300, 50);
		tableOfPay.setOpaque(false);
		
		paneOfProfit = new JScrollPane(tableOfProfit);
		this.add(paneOfProfit);
		paneOfProfit.setBounds(310, 130, 100, 50);		
		tableOfProfit.setOpaque(false);
		
		year = new JTextField(4);
		ye = new JLabel("年");
		month = new JTextField(2);
		mo = new JLabel("月");
		day = new JTextField(2);
		da = new JLabel("日     至");
		
		add(year);
		year.setBounds(10, 0, 35, 20);
		add(ye);
		ye.setBounds(46, -2, 25, 25);
		add(month);
		month.setBounds(75,	0, 35, 20);
		add(mo);
		mo.setBounds(111, -2, 25, 25);
		add(day);
		day.setBounds(140, 0, 35, 20);
		add(da);
		da.setBounds(176, -2, 50, 25);
		
		year2 = new JTextField(4);
		ye2 = new JLabel("年");
		month2 = new JTextField(2);
		mo2 = new JLabel("月");
		day2 = new JTextField(2);
		da2 = new JLabel("日");
		
		add(year2);
		year2.setBounds(220, 0, 35, 20);
		add(ye2);
		ye2.setBounds(256, -2, 25, 25);
		add(month2);
		month2.setBounds(285, 0, 35, 20);
		add(mo2);
		mo2.setBounds(321, -2, 25, 25);
		add(day2);
		day2.setBounds(350, 0, 35, 20);
		add(da2);
		da2.setBounds(386, -2, 25, 25);
		
		add(sure);
		sure.setBounds(420, 0, 20, 20);
		sure.setIcon(sureIcon0);
		sure.addMouseListener(new MouseListenOfButton(0));
	}
	
	public void update(String before, String after) {
		InquiryConditionVO icv = new InquiryConditionVO();
		icv.setTimeAfter(after);
		icv.setTimeBefore(before);
		BusinessSituationVO vo = financial.inquiryCondition(icv);
		Object[][] data0 = new Object[1][];
		Object[][] data1 = new Object[1][];
		Object[][] data2 = new Object[1][];
		Object[][] data3 = new Object[1][];
		
		Object[] temp0 = {vo.getTotalEarn(), vo.getDiscount(),vo.getSaleTotal(),vo.getSpillsTotal()};
		data0[0] = temp0;
				
		Object[] temp1 = { vo.getAdjustmentTotal(), vo.getBonusTotal()};
		data1[0] = temp1;
		
		Object[] temp2 = {vo.getTotalPay(), vo.getCost(), vo.getLossTotal(), vo.getGiftTotal()};
		data2[0] = temp2;
		
		Object[] temp3 ={vo.getProfit()};
		data3[0] = temp3;
		
		modelOfEarn1.setDataVector(data0, earn1);
		tableOfEarn1.updateUI();
		
		modelOfEarn2.setDataVector(data1, earn2);
		tableOfEarn2.updateUI();
		
		modelOfPay.setDataVector(data2, pay);
		tableOfPay.updateUI();
				
		modelOfProfit.setDataVector(data3, profit);
		tableOfProfit.updateUI();
	}
	
	public void export() {
		String[] names = {"折让后总收入","折让","销售收入","商品报溢收入","成本调价收入","代金券与实际收款差额收入","总支出","销售成本","商品报损","商品赠出","利润"};
		String[][] data = new String[2][];
		data[0] = names;
		String[] temp = {tableOfEarn1.getValueAt(0, 0).toString(),tableOfEarn1.getValueAt(0, 1).toString(), 
				tableOfEarn1.getValueAt(0, 2).toString(), tableOfEarn1.getValueAt(0, 3).toString(), 
				tableOfEarn2.getValueAt(0, 0).toString(), tableOfEarn2.getValueAt(0, 1).toString(),
				tableOfPay.getValueAt(0, 0).toString(), tableOfPay.getValueAt(0, 1).toString(),
				tableOfPay.getValueAt(0, 2).toString(), tableOfPay.getValueAt(0, 3).toString(),
				tableOfProfit.getValueAt(0, 0).toString()};
		data[1] = temp;
		new Export("经营情况表", data);
	} 
	public class MouseListenOfButton implements MouseListener{

		private int num;
		public MouseListenOfButton(int N){
			num=N;
		}
		public void mouseClicked(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			switch(num){
			case 0:sure.setIcon(sureIcon0);
			String y1 = year.getText();
			String m1 = month.getText();
			String d1 = day.getText();
			String y2 = year2.getText();
			String m2 = month2.getText();
			String d2 = day2.getText();
			String timeBefore = y1+"/"+m1+"/"+d1;
			String timeAfter = y2+"/"+m2+"/"+d2;
			update(timeBefore, timeAfter);				
			break;
				
			}
		}

		public void mouseReleased(MouseEvent e) {
			switch(num){
			case 0:sure.setIcon(sureIcon1); break;
					
			}
		}

		public void mouseEntered(MouseEvent e) {
			switch(num){
			case 0:sure.setIcon(sureIcon1);break;			
			
			}
		}

		public void mouseExited(MouseEvent e) {
			switch(num){
			case 0:sure.setIcon(sureIcon0); break;
			}
		}
		
	}
}
