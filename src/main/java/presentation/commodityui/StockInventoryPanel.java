package presentation.commodityui;

import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import vo.stockvo.CommodityVO;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.commodityblservice.StubCommodityBlService;
import dataservice.commoditydataservice.StubCommodityDataService;
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
	//frame的引用
    Frame frame;
    //逻辑层接口
	 StubCommodityBlService stockbl=new StubStockController();
	public StockInventoryPanel() {
		initial();
	}
	
	public void initial() {
		//逻辑层接口
		StockManagerDriver smd=new StockManagerDriver();
		try
		{
			smd.start(stockbl,(StubCommodityDataService)Naming.lookup("rmi://127.0.0.1:1099/StubStockDataController.getInstance()"));
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
		this.setBounds(0, 0, 400, 315);
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
		
		add(pane,0);
		add(jpbg1,1);
		
	}
	public void update(){
		Date date=stockbl.count().getDate();
	    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	    //获取批次和批号
		String currentTime = format.format(date);
		int no=stockbl.count().getNo();
		//获取商品列表
		ArrayList<CommodityVO> commodities=stockbl.count().getList();
		//填充表格数据
		Object[][] data=new Object[stockbl.count().getList().size()][];
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
