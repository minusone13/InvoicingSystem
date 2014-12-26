package presentation.financialui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import presentation.commodityui.StockCheckPanel.JPeditForCheck;
import presentation.commodityui.StockCheckPanel.JPeditForCheck.MouseListenerOfButton;
import presentation.commodityui.StockCheckPanel.JPeditForCheck.TreadOfLeft;
import presentation.commodityui.StockCheckPanel.JPeditForCheck.TreadOfRight;
import tool.Export;
import vo.inquiryVO.BusinessSituationVO;
import vo.inquiryVO.InquiryConditionVO;
import businesslogic.financialbl.Financial;
import businesslogicservice.financialblservice.FinancialBlService;
import entrance.Frame;

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
	//查询面板
	private JPeditForSituation checkJP;
	//查询按钮
	private JLabel inquire=new JLabel();
	//导出按钮
	private JLabel download=new JLabel();
	//图片
	private ImageIcon searchIconW=new ImageIcon("src/image/function/searchW.png");
	private ImageIcon searchIconR=new ImageIcon("src/image/function/searchR.png");
	private ImageIcon downloadIconW=new ImageIcon("src/image/function/downLoadW.png");
	private ImageIcon downloadIconR=new ImageIcon("src/image/function/downLoadR.png");
	//frame的引用
    Frame frame;
	public BusinessConditionPanel() {
		initial();
	}
	 public void getFrame( Frame f){
	 		frame=f;
	 }
	public void initial() {
		this.setBounds(0, 0, 960,315);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景图
		JLabel jpbg1=new JLabel();
		jpbg1.setBounds(0,0, 400, 315);
		jpbg1.setIcon(new ImageIcon("src/image/block/blockForTable2.png"));
		
		paneOfEarn1 = new JScrollPane(tableOfEarn1);
		this.add(paneOfEarn1,0);
		paneOfEarn1.setBounds(0,55, 400, 50);
		tableOfEarn1.setOpaque(false);
		
		paneOfEarn2 = new JScrollPane(tableOfEarn2);
		this.add(paneOfEarn2,1);
		paneOfEarn2.setBounds(0,160, 400, 50);
		tableOfEarn2.setOpaque(false);
		
		paneOfPay = new JScrollPane(tableOfPay);
		this.add(paneOfPay,2);
		paneOfPay.setBounds(0,265, 300, 50);
		tableOfPay.setOpaque(false);
		
		paneOfProfit = new JScrollPane(tableOfProfit);
		this.add(paneOfProfit,3);
		paneOfProfit.setBounds(300,265, 100, 50);		
		tableOfProfit.setOpaque(false);
		//滚动面板透明
		paneOfEarn1.setOpaque(false);//设置透明
		paneOfEarn1.getViewport().setOpaque(false);//设置透明
		paneOfEarn1.setBorder(null);
		//滚动面板透明
		paneOfEarn2.setOpaque(false);//设置透明
		paneOfEarn2.getViewport().setOpaque(false);//设置透明
		paneOfEarn2.setBorder(null);
		//滚动面板透明
		paneOfPay.setOpaque(false);//设置透明
		paneOfPay.getViewport().setOpaque(false);//设置透明
		paneOfPay.setBorder(null);
		//滚动面板透明
		paneOfProfit.setOpaque(false);//设置透明
		paneOfProfit.getViewport().setOpaque(false);//设置透明
		paneOfProfit.setBorder(null);
		
		//表格透明
		tableOfEarn1.setOpaque(false);
        DefaultTableCellRenderer render1 = new DefaultTableCellRenderer();   
        render1.setOpaque(false); //将渲染器设置为透明  
        tableOfEarn1.setDefaultRenderer(Object.class,render1);  
        tableOfEarn1.setForeground(Color.white);
        tableOfEarn1.setBorder(null);
        tableOfEarn1.setShowVerticalLines(false);
		//表格透明
        tableOfEarn2.setOpaque(false);
        DefaultTableCellRenderer render2 = new DefaultTableCellRenderer();   
        render2.setOpaque(false); //将渲染器设置为透明  
        tableOfEarn2.setDefaultRenderer(Object.class,render2);  
        tableOfEarn2.setForeground(Color.white);
        tableOfEarn2.setBorder(null);
        tableOfEarn2.setShowVerticalLines(false);
		//表格透明
        tableOfPay.setOpaque(false);
        DefaultTableCellRenderer render3 = new DefaultTableCellRenderer();   
        render3.setOpaque(false); //将渲染器设置为透明  
        tableOfPay.setDefaultRenderer(Object.class,render3);  
        tableOfPay.setForeground(Color.white);
        tableOfPay.setBorder(null);
        tableOfPay.setShowVerticalLines(false);
		//表格透明
        tableOfProfit.setOpaque(false);
        DefaultTableCellRenderer render4 = new DefaultTableCellRenderer();   
        render4.setOpaque(false); //将渲染器设置为透明  
        tableOfProfit.setDefaultRenderer(Object.class,render4);  
        tableOfProfit.setForeground(Color.white);
        tableOfProfit.setBorder(null);
        tableOfProfit.setShowVerticalLines(false);
        
        //查询面板
        checkJP=new JPeditForSituation();
    	checkJP.setLocation(905, 36);
		//查询功能按钮
		inquire.setIcon(searchIconW);
		inquire.setBounds(820, 20, 50, 50);
		inquire.addMouseListener(new MouseListenerOfButton(1));
		//导出功能按钮
		download.setIcon(downloadIconW);
		download.setBounds(820, 85, 50, 50);
		download.addMouseListener(new MouseListenerOfButton(2));
		
		this.add(jpbg1,4);
		this.add(checkJP,5);
		this.add(inquire,6);
		this.add(download,7);
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
	//查找条件输入面板
	public class JPeditForSituation extends JPanel
	{
		private JTextField year1;
		private JTextField month1;
		private JTextField date1;
		private JTextField year2;
		private JTextField month2;
		private JTextField date2;
		//右移按钮
		private JLabel right=new JLabel();
		//确认按钮
		private JLabel confirm=new JLabel();
		//图片
		private ImageIcon right0=new ImageIcon("src/image/function/rightW.png");
		private ImageIcon right1=new ImageIcon("src/image/function/rightR.png");
		private ImageIcon confirm0=new ImageIcon("src/image/function/confirmW.png");
		private ImageIcon confirm1=new ImageIcon("src/image/function/confirmR.png");
		public JPeditForSituation(){
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
			ye1.setBounds(94, 60, 25, 21);
			add(ye1);
			
			JLabel m1 = new JLabel("月");
			m1.setForeground(Color.WHITE);
			m1.setFont(new Font("宋体", Font.BOLD, 14));
			m1.setBounds(160, 59, 25, 23);
			add(m1);
			
			JLabel d1 = new JLabel("日");
			d1.setForeground(Color.WHITE);
			d1.setFont(new Font("宋体", Font.BOLD, 14));
			d1.setBounds(220, 60, 16, 21);
			add(d1);
			
			year1 = new JTextField();
			year1.setOpaque(false);//文本框透明
			year1.setForeground(Color.white);//前景色
			year1.setBounds(40, 60, 50, 20);
			add(year1);
			year1.setColumns(10);
			
			month1 = new JTextField();
			month1.setOpaque(false);//文本框透明
			month1.setForeground(Color.white);//前景色
			month1.setColumns(10);
			month1.setBounds(113, 60, 43, 21);
			add(month1);
			
			date1 = new JTextField();
			date1.setOpaque(false);//文本框透明
			date1.setForeground(Color.white);//前景色
			date1.setColumns(10);
			date1.setBounds(178, 60, 36, 21);
			add(date1);
			
			JLabel start = new JLabel("起始时间");
			start.setForeground(Color.WHITE);
			start.setFont(new Font("宋体", Font.BOLD, 14));
			start.setBounds(94, 29, 72, 21);
			add(start);
			
			JLabel over = new JLabel("结束时间");
			over.setForeground(Color.WHITE);
			over.setFont(new Font("宋体", Font.BOLD, 14));
			over.setBounds(94, 91, 72, 21);
			add(over);
			
			year2 = new JTextField();
			year2.setOpaque(false);//文本框透明
			year2.setForeground(Color.white);//前景色
			year2.setColumns(10);
			year2.setBounds(40, 120, 50, 20);
			add(year2);
			
			month2 = new JTextField();
			month2.setOpaque(false);//文本框透明
			month2.setForeground(Color.white);//前景色
			month2.setColumns(10);
			month2.setBounds(113, 120, 43, 21);
			add(month2);
			
			date2 = new JTextField();
			date2.setOpaque(false);//文本框透明
			date2.setForeground(Color.white);//前景色
			date2.setColumns(10);
			date2.setBounds(178, 120, 36, 21);
			add(date2);
			
			JLabel ye2 = new JLabel("年");
			ye2.setForeground(Color.WHITE);
			ye2.setFont(new Font("宋体", Font.BOLD, 14));
			ye2.setBounds(94, 120, 25, 21);
			add(ye2);
			
			JLabel m2 = new JLabel("月");
			m2.setForeground(Color.WHITE);
			m2.setFont(new Font("宋体", Font.BOLD, 14));
			m2.setBounds(160, 120, 25, 23);
			add(m2);
			
			JLabel d2 = new JLabel("日");
			d2.setForeground(Color.WHITE);
			d2.setFont(new Font("宋体", Font.BOLD, 14));
			d2.setBounds(220, 120, 16, 21);
			add(d2);
			
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
					//右移
					RightMove();
					break;
				case 3:
					confirm.setIcon(confirm0);
					//点击查询
					String y1 = year1.getText();
					String m1 = month1.getText();
					String d1 = date1.getText();
					String y2 = year2.getText();
					String m2 = month2.getText();
					String d2 = date2.getText();
					String timeBefore = y1+"/"+m1+"/"+d1;
					String timeAfter = y2+"/"+m2+"/"+d2;
					BusinessConditionPanel.this.update(timeBefore, timeAfter);				
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
					JPeditForSituation.this.setLocation(x, y);
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
					JPeditForSituation.this.setLocation(x, y);
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
