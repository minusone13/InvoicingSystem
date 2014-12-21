package presentation.commodityui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import vo.stockvo.CommodityVO;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.commodityblservice.StubCommodityBlService;
import dataservice.commoditydataservice.StubCommodityDataService;
import entrance.Frame;

public class StockCheckPanel extends JPanel{
	
	String[] names = {"商品","型号","出库数量","入库数量","出库金额","入库金额","销售数量","进货数量","销售金额","进货金额","库存数量"};
	DefaultTableModel model=new DefaultTableModel(new Object[][]{},names);
	JTable table = new JTable(model);
	JScrollPane pane = new JScrollPane(table);
	//frame的引用
    Frame frame;
    //逻辑层接口
  	 StubCommodityBlService stockbl=new StubStockController();
	public StockCheckPanel() {
		initial();
	}
	
	public void initial() {
		//逻辑层接口
		StockManagerDriver smd=new StockManagerDriver();
		try
		{
			smd.start(stockbl,(StubCommodityDataService)Naming.lookup("rmi://127.0.0.1:1099/StubStockDataController"));
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (NotBoundException e)
		{
			e.printStackTrace();
		}
		this.setBounds(0, 0,800, 315);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景图
		JLabel jpbg1=new JLabel();
		jpbg1.setBounds(0, 0,800, 315);
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
		pane.setBounds(0, 0, 800,315);
		
		add(pane,0);
		add(jpbg1,1);
		
	}
	public void update(Date date1,Date date2){
		//获取商品列表
		ArrayList<CommodityVO> commodities=stockbl.getRecords(date1, date2);
		//填充表格数据
		Object[][] data=new Object[commodities.size()][];
		for(int i=0;i<commodities.size();i++){
			Object[] temp={commodities.get(i).getName(),
					commodities.get(i).getModel(),
					commodities.get(i).getRecord().get(0).getOutquantity(),
					commodities.get(i).getRecord().get(0).getInquantity(),
					commodities.get(i).getRecord().get(0).getOutamount(),
					commodities.get(i).getRecord().get(0).getInamount(),
					commodities.get(i).getRecord().get(0).getSalequantity(),
					commodities.get(i).getRecord().get(0).getImportquantity(),
					commodities.get(i).getRecord().get(0).getSaleamount(),
					commodities.get(i).getRecord().get(0).getImportamount(),
					commodities.get(i).getNumber()
					
			};
			data[i]=temp;
		}
		model.setDataVector(data, names);
		table.updateUI();
	}
	/*获取frame的引用*/
	public void getFrame( Frame f){
  		frame=f;
    }
	//查找条件输入面板
	public class JPeditForCheck extends JPanel
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
		public JPeditForCheck(){
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
			year1.setBounds(40, 60, 50, 20);
			add(year1);
			year1.setColumns(10);
			
			month1 = new JTextField();
			month1.setColumns(10);
			month1.setBounds(113, 60, 43, 21);
			add(month1);
			
			date1 = new JTextField();
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
			year2.setColumns(10);
			year2.setBounds(40, 120, 50, 20);
			add(year2);
			
			month2 = new JTextField();
			month2.setColumns(10);
			month2.setBounds(113, 120, 43, 21);
			add(month2);
			
			date2 = new JTextField();
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
					JPeditForCheck.this.setLocation(x, y);
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
					JPeditForCheck.this.setLocation(x, y);
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
