package presentation.commodityui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import presentation.commodityui.StockCheckPanel.MouseListenerOfButton;
import vo.stockvo.CommodityVO;
import vo.stockvo.CountVO;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.commodityblservice.StubCommodityBlService;
//import dataservice.commoditydataservice.StubCommodityDataService;
import entrance.Frame;

/*
 * 库存盘点面板
 * 
 * */
public class StockInventoryPanel extends JPanel{

	String[] names = {"行号","商品名","型号","库存数量","库存均价","批次","批号"};
	DefaultTableModel model=new DefaultTableModel(new Object[][]{},names);
	JTable table = new JTable(model);
	JScrollPane pane = new JScrollPane(table);
	//导出按钮
	private JLabel download=new JLabel();
	//图片
	private ImageIcon downloadIconW=new ImageIcon("src/image/function/downLoadW.png");
	private ImageIcon downloadIconR=new ImageIcon("src/image/function/downLoadR.png");
	//frame的引用
	private Frame frame;
    //逻辑层接口
	 StubCommodityBlService stockbl=new StubStockController();
	public StockInventoryPanel() {
		initial();
	}
	
	public void initial() {
		//逻辑层接口
		StockManagerDriver smd=new StockManagerDriver();
		/*try
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
		}*/
		this.setBounds(0, 0, 800, 315);
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
		table.setEnabled(false);
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
		//导出功能按钮
		download.setIcon(downloadIconW);
		download.setBounds(720,20, 50, 50);
		download.addMouseListener(new MouseListenerOfButton(2));
		
		add(pane,0);
		add(jpbg1,1);
		add(download,2);
		
	}
	CountVO count;
	public class MouseListenerOfButton implements MouseListener{

		private int num;
		public MouseListenerOfButton(int N){
			num=N;
		}
		public void mouseClicked(MouseEvent e)
		{
	
			
		}

		public void mousePressed(MouseEvent e)
		{
	
			switch(num){
				case 2:
					download.setIcon(downloadIconR);
					break;
			}
			
		}

		public void mouseReleased(MouseEvent e)
		{
			// TODO Auto-generated method stub
			switch(num){
				case 2:
					download.setIcon(downloadIconW);
					//导出
					JFileChooser c = new JFileChooser();
					FileFilter filter = new FileNameExtensionFilter("Excel文件(*.xls)", "xls");
					c.addChoosableFileFilter(filter);
					c.setFileFilter(filter);
					c.setDialogTitle("保存文件");
					int result = c.showSaveDialog(getParent());
					if (result == JFileChooser.APPROVE_OPTION) {
						stockbl.ExportCount(c.getSelectedFile().getAbsolutePath()+".xls", count);
					}
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
				case 2:
					download.setIcon(downloadIconW);
					break;
			}
			
		}
		
	}
	public void update(){
		count = stockbl.count();
		Date date=count.getDate();
	    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	    //获取批次和批号
		String currentTime = format.format(date);
		int no=count.getNo();
		//获取商品列表
		ArrayList<CommodityVO> commodities=count.getList();
		//填充表格数据
		Object[][] data=new Object[count.getList().size()][];
		for(int i=0;i<commodities.size();i++){
			Object[] temp={i+1,
					commodities.get(i).getName(),
					commodities.get(i).getModel(),
					commodities.get(i).getNumber(),
					commodities.get(i).getIn(),
					currentTime,
					no};
			data[i]=temp;
		}
		model.setDataVector(data, names);
		table.updateUI();
	}
	/*获取frame的引用*/
	public void getFrame( Frame f){
  		frame=f;
    }
}
