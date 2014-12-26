package presentation.financialui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import presentation.financialui.BusinessConditionPanel.JPeditForSituation;
import presentation.financialui.BusinessConditionPanel.MouseListenerOfButton;
import tool.Export;
import vo.CustomerVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.inquiryVO.InquirySaleVO;
import vo.stockvo.CommodityVO;
import businesslogic.customerbl.CustomerList;
import businesslogic.financialbl.Financial;
import businesslogicservice.customerblservice.CustomerBlService;
import businesslogicservice.financialblservice.FinancialBlService;

public class SaleDetailPanel extends JPanel{
	FinancialBlService financial = new Financial();
	String[] names = {"时间","商品名","型号","数量","单价","总额"};
	
	DefaultTableModel model = new DefaultTableModel(new Object[][]{}, names );
	JTable table = new JTable(model);
	JScrollPane pane = new JScrollPane(table);
	//查询面板
	private JPeditForSaleDetail checkJP;
	//查询按钮
	private JLabel inquire=new JLabel();
	//导出按钮
	private JLabel download=new JLabel();
	//图片
	private ImageIcon searchIconW=new ImageIcon("src/image/function/searchW.png");
	private ImageIcon searchIconR=new ImageIcon("src/image/function/searchR.png");
	private ImageIcon downloadIconW=new ImageIcon("src/image/function/downLoadW.png");
	private ImageIcon downloadIconR=new ImageIcon("src/image/function/downLoadR.png");
	public SaleDetailPanel(){
		initial();
	}
	
	private void initial() {
		this.setBounds(0, 0, 905, 315);
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
		
	       //查询面板
        checkJP=new JPeditForSaleDetail();
    	checkJP.setLocation(905, 36);
		//查询功能按钮
		inquire.setIcon(searchIconW);
		inquire.setBounds(720, 20, 50, 50);
		inquire.addMouseListener(new MouseListenerOfButton(1));
		//导出功能按钮
		download.setIcon(downloadIconW);
		download.setBounds(720, 85, 50, 50);
		download.addMouseListener(new MouseListenerOfButton(2));
				
		this.add(checkJP,0);
		this.add(inquire,1);
		this.add(download,2);
		this.add(pane,3);
		this.add(jpbg1,4);
	}
	
	public void update(InquirySaleVO isv) {
		Object[][] data;
		
		data = getSaleDetail(isv);
		model.setDataVector(data, names);
		table.updateUI();
	}
	public class MouseListenerOfButton implements MouseListener{

		private int num;
		public MouseListenerOfButton(int N){
			num=N;
		}
		public void mouseClicked(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e)
		{
			// TODO Auto-generated method stub
			switch(num){
				case 1:
					inquire.setIcon(searchIconR);
					break;
				case 2:
					download.setIcon(downloadIconR);
					break;
			}
			
		}

		public void mouseReleased(MouseEvent e)
		{
			// TODO Auto-generated method stub
			switch(num){
				case 1:
					inquire.setIcon(searchIconW);
					//调出查询面板
					checkJP.leftMove();
					break;
				case 2:
					download.setIcon(downloadIconW);
					break;
			}
			
		}

		public void mouseEntered(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e)
		{
			// TODO Auto-generated method stub
			switch(num){
				case 1:
					inquire.setIcon(searchIconW);
					break;
				case 2:
					download.setIcon(downloadIconW);
					break;
			}
			
		}
		
	}
	private Object[][] getSaleDetail(InquirySaleVO isv) {
		ArrayList<SaleSheetVO> saleSheet = financial.getSaleSaleSheet(isv);
		ArrayList<SaleBackSheetVO> saleBackSheet = financial.getSaleSaleBackSheet(isv);
		 
		int size1 = saleSheet.size();
		int size2 = saleBackSheet.size();
		int size = size1 + size2;
		if(isv.getCommodityName()!=null) { 
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
		}	else {//如果没选商品名
			int len=0;
			for(int i=0;i<size1;i++) {
				SaleSheetVO vo = saleSheet.get(i);
				 ArrayList<CommodityVO> list = vo.getsheet();
				 int sizeOfList = list.size();
				 len += sizeOfList;
				 
			}//for
			
			for(int i=size1;i<size;i++) {
				SaleBackSheetVO vo = saleBackSheet.get(i);
				 ArrayList<CommodityVO> list = vo.getsheet();
				 int sizeOfList = list.size();
				 len += sizeOfList;
				 
			}//for
			 Object[][] data = new Object[len][];
			 for(int i=0;i<size1;i++) {
				 SaleSheetVO vo = saleSheet.get(i);
				 ArrayList<CommodityVO> list = vo.getsheet();
				 int sizeOfList = list.size();
				 CommodityVO commodity=null;
				 
			 	for(int j=0;j<sizeOfList;j++) {
					 commodity = list.get(j);
					 double total = commodity.getOut()*commodity.getNumber();
					 Object[] temp ={vo.getdate(), commodity.getName(), commodity.getModel(), 
							 commodity.getNumber(), commodity.getOut(), total};
					 data[i] = temp;
				 }
				 
			 }
			 for(int i=size1;i<size;i++) {
				 SaleBackSheetVO vo = saleBackSheet.get(i);
				 ArrayList<CommodityVO> list = vo.getsheet();
				 int sizeOfList = list.size();
				 CommodityVO commodity=null;
				 for(int j=0;j<sizeOfList;j++) {
					 commodity = list.get(j);
					 double total =0 - commodity.getOut()*commodity.getNumber();
					 Object[] temp ={vo.getdate(), commodity.getName(), commodity.getModel(), 
							 0-commodity.getNumber(), commodity.getOut(), total};
					 data[i] = temp;
				 }
				 
			 }
			 return data;
			
		}//else
		
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
	
	public void export(String pathName) {
		String[][] data = getSaleDetailExport();
		new Export(pathName,data);
	}
	public class JPeditForSaleDetail extends JPanel
	{
		private JTextField year1;
		private JTextField month1;
		private JTextField date1;
		private JTextField year2;
		private JTextField month2;
		private JTextField date2;
		private JTextField commodityName;
		private JTextField salemanTxt;
		private JComboBox customerCombo;
		private JComboBox warehouseCombo;
		//右移按钮
		private JLabel right=new JLabel();
		//确认按钮
		private JLabel confirm=new JLabel();
		//图片
		private ImageIcon right0=new ImageIcon("src/image/function/rightW.png");
		private ImageIcon right1=new ImageIcon("src/image/function/rightR.png");
		private ImageIcon confirm0=new ImageIcon("src/image/function/confirmW.png");
		private ImageIcon confirm1=new ImageIcon("src/image/function/confirmR.png");
	    //调用逻辑层
	    CustomerBlService customerbl=new CustomerList();
		public JPeditForSaleDetail(){
			//面板大小
			this.setSize(240,270);
			//设置布局
			this.setLayout(null);
			//设置面板透明
			this.setOpaque(false);
			//右移按钮
			right.setIcon(right0);
			right.setBounds(10, 123, 24, 24);
			right.addMouseListener(new MouseListenerOfButton(1));
			//确认按钮
			confirm.setIcon(confirm0);
			confirm.setBounds(120, 236, 24, 24);
			confirm.addMouseListener(new MouseListenerOfButton(3));
			add(right);
			add(confirm);
			JLabel ye1 = new JLabel("年");
			ye1.setForeground(Color.WHITE);
			ye1.setFont(new Font("宋体", Font.BOLD, 14));
			ye1.setBounds(94, 37, 25, 21);
			add(ye1);
			
			JLabel m1 = new JLabel("月");
			m1.setForeground(Color.WHITE);
			m1.setFont(new Font("宋体", Font.BOLD, 14));
			m1.setBounds(160, 36, 25, 23);
			add(m1);
			
			JLabel d1 = new JLabel("日");
			d1.setForeground(Color.WHITE);
			d1.setFont(new Font("宋体", Font.BOLD, 14));
			d1.setBounds(220, 37, 16, 21);
			add(d1);
			
			year1 = new JTextField();
			year1.setBounds(40, 37, 50, 20);
			year1.setOpaque(false);
			year1.setForeground(Color.white);
			add(year1);
			year1.setColumns(10);
			
			month1 = new JTextField();
			month1.setColumns(10);
			month1.setOpaque(false);
			month1.setForeground(Color.white);
			month1.setBounds(113, 37, 43, 21);
			add(month1);
			
			date1 = new JTextField();
			date1.setColumns(10);
			date1.setOpaque(false);
			date1.setForeground(Color.white);
			date1.setBounds(178, 37, 36, 21);
			add(date1);
			
			JLabel start = new JLabel("起始时间");
			start.setForeground(Color.WHITE);
			start.setFont(new Font("宋体", Font.BOLD, 14));
			start.setBounds(94, 10, 72, 21);
			add(start);
			
			JLabel over = new JLabel("结束时间");
			over.setForeground(Color.WHITE);
			over.setFont(new Font("宋体", Font.BOLD, 14));
			over.setBounds(94, 68, 72, 21);
			add(over);
			
			year2 = new JTextField();
			year2.setColumns(10);
			year2.setOpaque(false);
			year2.setForeground(Color.white);
			year2.setBounds(40, 90, 50, 20);
			add(year2);
			
			month2 = new JTextField();
			month2.setColumns(10);
			month2.setOpaque(false);
			month2.setForeground(Color.white);
			month2.setBounds(113, 90, 43, 21);
			add(month2);
			
			date2 = new JTextField();
			date2.setColumns(10);
			date2.setOpaque(false);
			date2.setForeground(Color.white);
			date2.setBounds(178, 90, 36, 21);
			add(date2);
			
			JLabel ye2 = new JLabel("年");
			ye2.setForeground(Color.WHITE);
			ye2.setFont(new Font("宋体", Font.BOLD, 14));
			ye2.setBounds(94, 90, 25, 21);
			add(ye2);
			
			JLabel m2 = new JLabel("月");
			m2.setForeground(Color.WHITE);
			m2.setFont(new Font("宋体", Font.BOLD, 14));
			m2.setBounds(160, 89, 25, 23);
			add(m2);
			
			JLabel d2 = new JLabel("日");
			d2.setForeground(Color.WHITE);
			d2.setFont(new Font("宋体", Font.BOLD, 14));
			d2.setBounds(220, 90, 16, 21);
			add(d2);
			
			JLabel label = new JLabel("商品名称");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("宋体", Font.BOLD, 14));
			label.setBounds(40, 120, 60, 21);
			add(label);
			
			commodityName = new JTextField();
			commodityName.setColumns(10);
			commodityName.setOpaque(false);
			commodityName.setForeground(Color.white);
			commodityName.setBounds(104, 121, 126, 20);
			add(commodityName);
			
			JLabel label_1 = new JLabel("客户");
			label_1.setForeground(Color.WHITE);
			label_1.setFont(new Font("宋体", Font.BOLD, 14));
			label_1.setBounds(40, 145, 36, 21);
			add(label_1);
			
			//客户下拉框
			ArrayList<CustomerVO> customers2 = null;
			customers2 = customerbl.getAllCustomer("Customer.txt");
			String[] customerS2=new String[customers2.size()];
			for(int i=0;i<customers2.size();i++){
				customerS2[i]=customers2.get(i).getname()+":"+customers2.get(i).getid();
			}
			customerCombo = new JComboBox(customerS2);
			customerCombo.setBounds(74, 145, 156, 20);
			customerCombo.setBackground(Color.gray);
			customerCombo.setForeground(Color.white);
			add(customerCombo);
			
			JLabel label_2 = new JLabel("业务员");
			label_2.setForeground(Color.WHITE);
			label_2.setFont(new Font("宋体", Font.BOLD, 14));
			label_2.setBounds(40, 171, 50, 21);
			add(label_2);
			
			JLabel label_3 = new JLabel("仓库");
			label_3.setForeground(Color.WHITE);
			label_3.setFont(new Font("宋体", Font.BOLD, 14));
			label_3.setBounds(40, 196, 36, 21);
			add(label_3);
			
			salemanTxt = new JTextField();
			salemanTxt.setColumns(10);
			salemanTxt.setOpaque(false);
			salemanTxt.setForeground(Color.white);
			salemanTxt.setBounds(90, 171, 140, 20);
			add(salemanTxt);
			
			String[] warehouseStr={"仓库1"};
			warehouseCombo = new JComboBox(warehouseStr);
			warehouseCombo.setBounds(74, 196, 156, 20);
	   		warehouseCombo.setBackground(Color.gray);
    		warehouseCombo.setForeground(Color.white);
			add(warehouseCombo);
			
			JLabel bg = new JLabel("New label");
			bg.setIcon(new ImageIcon("C:\\Users\\wyc\\git\\git\\InvoicingSystem\\src\\image\\function\\editBlock.PNG"));
			bg.setBounds(0, 0, 240, 270);
			add(bg);
		}
		public class MouseListenerOfButton implements MouseListener{

			private int num;//1、右移  3、确认
			public MouseListenerOfButton(int N){
				num=N;
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				switch(num){
				case 1:
					right.setIcon(right1);
					//右移
					RightMove();
					break;
				case 3:
					confirm.setIcon(confirm1);
					break;
				}
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				switch(num){
				case 1:
					right.setIcon(right0);
					break;
				case 3:
					confirm.setIcon(confirm0);
					break;
				}
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				switch(num){
				case 1:
					right.setIcon(right0);
					break;
				case 3:
					confirm.setIcon(confirm0);
					break;
				}
			}
			
		}
		public class TreadOfLeft  implements Runnable{

			public void run() {
				// TODO Auto-generated method stub
				int x=905;
				int y=36;
				while(x!=665){
					if((x-665)>10){
						x-=10;
					}
					else{
						x=665;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JPeditForSaleDetail.this.setLocation(x, y);
				}
			}
			
		}
		
		public class TreadOfRight  implements Runnable{

			public void run() {
				// TODO Auto-generated method stub
				int x=665;
				int y=36;
				while(x!=905){
					if((905-x)>10){
						x+=10;
					}
					else{
						x=905;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JPeditForSaleDetail.this.setLocation(x, y);
				}
			}
			
		}
		public void leftMove(){
			Thread t=new Thread(new TreadOfLeft());
			t.start();
		}
		public void RightMove(){
			Thread t=new Thread(new TreadOfRight());
			t.start();
		}
	}
}
