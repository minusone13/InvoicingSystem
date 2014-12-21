package presentation.financialui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import businesslogic.financialbl.Financial;
import businesslogicservice.financialblservice.FinancialBlService;
import tool.Export;
import vo.CustomerVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.inquiryVO.InquirySaleVO;
import vo.stockvo.CommodityVO;

public class SaleDetailPanel extends JPanel{
	FinancialBlService financial = new Financial();
	String[] names = {"时间","商品名","型号","数量","单价","总额"};
	
	DefaultTableModel model = new DefaultTableModel(new Object[][]{}, names );
	JTable table = new JTable(model);
	JScrollPane pane = new JScrollPane(table);
	
	public SaleDetailPanel(){
		initial();
	}
	
	private void initial() {
		this.setBounds(0, 0, 450, 315);
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
				
		this.add(pane,0);
		this.add(jpbg1,1);
	}
	
	public void update(InquirySaleVO isv) {
		Object[][] data;
		
		data = getSaleDetail(isv);
		model.setDataVector(data, names);
		table.updateUI();
	}
	
	private Object[][] getSaleDetail(InquirySaleVO isv) {
		ArrayList<SaleSheetVO> saleSheet = financial.getSaleSaleSheet(isv);
		ArrayList<SaleBackSheetVO> saleBackSheet = financial.getSaleSaleBackSheet(isv);
		 
		int size1 = saleSheet.size();
		int size2 = saleBackSheet.size();
		int size = size1 + size2;
		 Object[][] data = new Object[size][];
		 for(int i=0;i<size1;i++) {
			 SaleSheetVO vo = saleSheet.get(i);
			 ArrayList<CommodityVO> list = vo.getsheet();
			 int sizeOfList = list.size();
			 CommodityVO commodity=null;
			 for(int j=0;j<sizeOfList;j++) {
				 commodity = list.get(j);
				 if(commodity.getName().equals(isv.getCommodityName())) break;
			 }
			 double total = commodity.getOut()*commodity.getNumber();
			 Object[] temp ={vo.getdate(), commodity.getName(), commodity.getModel(), 
					 commodity.getNumber(), commodity.getOut(), total};
			 data[i] = temp;
		 }
		 for(int i=size1;i<size;i++) {
			 SaleBackSheetVO vo = saleBackSheet.get(i);
			 ArrayList<CommodityVO> list = vo.getsheet();
			 int sizeOfList = list.size();
			 CommodityVO commodity=null;
			 for(int j=0;j<sizeOfList;j++) {
				 commodity = list.get(j);
				 if(commodity.getName().equals(isv.getCommodityName())) break;
			 }
			 double total =0 - commodity.getOut()*commodity.getNumber();
			 Object[] temp ={vo.getdate(), commodity.getName(), commodity.getModel(), 
					 0-commodity.getNumber(), commodity.getOut(), total};
			 data[i] = temp;
		 }
		return data;
	}
	
	public String[][] getSaleDetailExport() {
		
		int size = table.getRowCount();
		String[][] data = new String[size+1][];
		data[0] = names;	
		for(int i=0;i<size;i++) {
			 String[] temp = {table.getValueAt(i, 0).toString(), table.getValueAt(i, 1).toString(),
					 table.getValueAt(i, 2).toString(),table.getValueAt(i, 3).toString(), 
					 table.getValueAt(i, 4).toString(), table.getValueAt(i, 5).toString()};
			
			 data[i+1] = temp;
		 }
		return data;
	}
	
	public void export() {
		String[][] data = getSaleDetailExport();
		new Export("销售明细表",data);
	}
}
