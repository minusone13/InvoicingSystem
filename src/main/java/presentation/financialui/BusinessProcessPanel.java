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

import entrance.Frame;
import presentation.StringJudger;
import tool.Export;
import vo.AlertBillVO;
import vo.CustomerVO;
import vo.GiftBillVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.SpillsLossBillVO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import vo.inquiryVO.InquiryProcessVO;
import vo.inquiryVO.InquirySaleVO;
import vo.stockvo.CommodityVO;
import businesslogic.customerbl.CustomerList;
import businesslogic.financialbl.Financial;
import businesslogicservice.customerblservice.CustomerBlService;
import businesslogicservice.financialblservice.FinancialBlService;

//经营历程表面板
public class BusinessProcessPanel extends JPanel{
	FinancialBlService financial = new Financial();
	//数字与choose对应
	String[] columnNames1 = {"单据编号","客户","操作员","总额汇总","单据状态"};
    String[] columnNames2 = {"单据编号","银行账户","操作员","总额汇总","单据状态"};
    String[] columnNames3 = {"单据编号","供应商","仓库","操作员","备注","总额合计","单据状态"};
    String[] columnNames4 = {"单据编号","客户","业务员","操作员","仓库","折让前总额","折让","代金券","折让后总额","备注","单据状态"};
    String[] columnNames5 = {"单据编号","操作员","单据状态"};
    String[] columnNames6 = {"单据编号","商品名","类型","数量"};
   
    String[] columnNames1s = {"银行账户","金额","备注"};
    String[] columnNames2s = {"条目名","金额","备注"};
    String[] columnNames3s = {"商品编号","名称","型号","数量","单价","金额","备注"}; 
    String[] columnNames4s = {"商品编号","名称","型号","数量","单价","金额","备注"};
    String[] columnNames5s = {"商品名","类型","数量"};
    String[] columnNames6s = {};
    
    //单据类型
    int choose = 1;//1：付款收款单；2：现金费用单；3：进货单据；4：销售单据；5：赠送单；6：报警单和报溢报损
    
    ArrayList<GiftBillVO> gift;
    ArrayList<SpillsLossBillVO> spillsLoss; 
    ArrayList<AlertBillVO> alert;
    ArrayList<SaleSheetVO> saleSheet;
    ArrayList<SaleBackSheetVO> saleBackSheet;
    ArrayList<PurSheetVO> purSheet;
    ArrayList<PurBackSheetVO> purBackSheet;
    ArrayList<ReceiptVO> receipt;
    ArrayList<PaymentVO> payment;
    ArrayList<CashPaymentVO> cashPayment;
	JTable table1, table2;
	JScrollPane pane1,pane2;
	DefaultTableModel model1, model2;
	
	
    String timeBefore;
    String timeAfter;
	//查询面板
	private JPeditForBusinessProgress checkJP;
	//查询按钮
	private JLabel inquire=new JLabel();
	//导出按钮
	private JLabel download=new JLabel();
	//图片
	private ImageIcon searchIconW=new ImageIcon("src/image/function/searchW.png");
	private ImageIcon searchIconR=new ImageIcon("src/image/function/searchR.png");
	private ImageIcon downloadIconW=new ImageIcon("src/image/function/downLoadW.png");
	private ImageIcon downloadIconR=new ImageIcon("src/image/function/downLoadR.png");
	 //字符串类型判断
    StringJudger stringJg=new StringJudger();
	//frame的引用
    Frame frame;
    public BusinessProcessPanel() {
    	initial();
	}
	 public void getFrame( Frame f){
	 		frame=f;
	 }
	public void reHome(){
		checkJP.reHome();
	}
	public void initial() {
		this.setBounds(0, 0,905, 320);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景图
		JLabel jpbg1=new JLabel();
		jpbg1.setBounds(0, 0, 700, 150);
		jpbg1.setIcon(new ImageIcon("src/image/block/blockForTable(long).png"));
		JLabel jpbg2=new JLabel();
		jpbg2.setBounds(0, 170, 700, 150);
		jpbg2.setIcon(new ImageIcon("src/image/block/blockForTable(long).png"));
		
		model1 = new DefaultTableModel(new Object[][]{}, columnNames4);
		model2 = new DefaultTableModel(new Object[][]{}, columnNames4s);
		
		table1 = new JTable(model1);
		table2 = new JTable(model2);
		
		table1.setOpaque(false);
        DefaultTableCellRenderer render1 = new DefaultTableCellRenderer();   
        render1.setOpaque(false); //将渲染器设置为透明  
        table1.setDefaultRenderer(Object.class,render1);  
        table1.setForeground(Color.white);
        table1.setBorder(null);
        table1.setShowVerticalLines(false);
        table1.addMouseListener(new MouseListener(){

			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				updateTable2(choose,table1.getSelectedRow());
			}

			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
        
        });
        
        table2.setOpaque(false);
        DefaultTableCellRenderer render2 = new DefaultTableCellRenderer();   
        render2.setOpaque(false); //将渲染器设置为透明  
        table2.setDefaultRenderer(Object.class,render2);  
        table2.setForeground(Color.white);
        table2.setBorder(null);
        table2.setShowVerticalLines(false);
		
		pane1 = new JScrollPane(table1);
		pane2 = new JScrollPane(table2);
		
		pane1.setOpaque(false);//设置透明
		pane1.getViewport().setOpaque(false);//设置透明
		pane1.setBorder(null);
		pane1.setBounds(0, 0, 700, 150);
		
		pane2.setOpaque(false);//设置透明
		pane2.getViewport().setOpaque(false);//设置透明
		pane2.setBorder(null);
		pane2.setBounds(0, 170, 700, 150);
		
	    //查询面板
        checkJP=new JPeditForBusinessProgress();
    	checkJP.setLocation(905, 36);
		//查询功能按钮
		inquire.setIcon(searchIconW);
		inquire.setBounds(820, 20, 50, 50);
		inquire.addMouseListener(new MouseListenerOfButton(1));
		//导出功能按钮
		download.setIcon(downloadIconW);
		download.setBounds(820, 85, 50, 50);
		download.addMouseListener(new MouseListenerOfButton(2));
		
		this.add(checkJP,0);
		this.add(inquire,1);
		this.add(download,2);
		this.add(pane1,3);
		this.add(pane2,4);
		this.add(jpbg1,5);
		this.add(jpbg2,6);
		
		
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
					export();
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
	public void export() {
		if(choose==1) {
			int size = table1.getRowCount();
			int size1 = receipt.size();
			
			String[][] data = new String[size+1][];
			String[] names = {"单据编号","客户","操作员","总额汇总","单据状态","转账列表"};
			data[0] = names;	
			
			for(int i=0;i<size1;i++) {
				ReceiptVO vo = receipt.get(i);
    			ArrayList<String> accounts = vo.getAccounts();
    			ArrayList<Double> money = vo.getMoney();
    			ArrayList<String> remark = vo.getRemark();
				
    			String acc = "";
    			int sizeOfacc = accounts.size();
    			for(int j=0;j<sizeOfacc;j++) {
    				acc = acc+accounts.get(j)+"，";
    				acc = acc+money.get(j).toString()+"，";
    				acc = acc+remark.get(j)+"；";
    			}
    			String[] temp = {table1.getValueAt(i, 0).toString(), table1.getValueAt(i, 1).toString(),
						 table1.getValueAt(i, 2).toString(),table1.getValueAt(i, 3).toString(), 
						 table1.getValueAt(i, 4).toString(), acc};
				
				 data[i+1] = temp;
			 }
			for(int i=size1;i<size;i++) {
				PaymentVO vo = payment.get(i);
    			ArrayList<String> accounts = vo.getAccounts();
    			ArrayList<Double> money = vo.getMoney();
    			ArrayList<String> remark = vo.getRemark();
    			String acc = "";
    			int sizeOfacc = accounts.size();
    			for(int j=0;j<sizeOfacc;j++) {
    				acc = acc+accounts.get(j)+"，";
    				acc = acc+money.get(j).toString()+"，";
    				acc = acc+remark.get(j)+"；";
    			}
    			String[] temp = {table1.getValueAt(i, 0).toString(), table1.getValueAt(i, 1).toString(),
						 table1.getValueAt(i, 2).toString(),table1.getValueAt(i, 3).toString(), 
						 table1.getValueAt(i, 4).toString(), acc};
				
				 data[i+1] = temp;
			 }
			new Export("经营历程表--付款收款单",data);
		} else if(choose == 2) {
			int size = table1.getRowCount();
			String[][] data = new String[size+1][];
			String[] names = {"单据编号","银行账户","操作员","总额汇总","单据状态","条目清单"};
			data[0] = names;
			
			
			for(int i=0;i<size;i++) {
				CashPaymentVO vo = cashPayment.get(i);
    			ArrayList<String> item = vo.getItem();
    			ArrayList<Double> money = vo.getMoney();
    			ArrayList<String> remark = vo.getRemark();
    			String ite = "";
    			int sizeOfitem = item.size();
    			for(int j=0;j<sizeOfitem;j++) {
    				ite = ite+item.get(j)+"，";
    				ite = ite+money.get(j).toString()+"，";
    				ite = ite+remark.get(j)+"；";
    			}
				String[] temp = {table1.getValueAt(i, 0).toString(), table1.getValueAt(i, 1).toString(),
						 table1.getValueAt(i, 2).toString(),table1.getValueAt(i, 3).toString(), 
						 table1.getValueAt(i, 4).toString(), ite};
				
				 data[i+1] = temp;
			 }
			new Export("经营历程表--现金费用单",data);
		} else if(choose == 3) {
			int size = table1.getRowCount();
			int size1 = purSheet.size();
			String[][] data = new String[size+1][];
			String[] names = {"单据编号","供应商","仓库","操作员","备注","总额合计","单据状态","商品清单"};
			data[0] = names;
			
			for(int i=0;i<size1;i++) {
				PurSheetVO vo = purSheet.get(i);
				
				ArrayList<CommodityVO> com = vo.getsheet();
				ArrayList<String> commoditywords = vo.getcommoditywords();
				int sizeOfcom = com.size();
				String comList = "";
				for(int j=0;j<sizeOfcom;j++) {
					
					CommodityVO comVO = com.get(j);
					comList = comList+ comVO.getId()+"，";
					comList = comList+ comVO.getName()+"，";
					comList = comList+ comVO.getModel()+"，";
					comList = comList+ comVO.getNumber()+"，";
					comList = comList+ comVO.getNumber()*comVO.getLastin()+"，";
					comList = comList+ commoditywords.get(j)+"；";
				}
				 
				String[] temp = {table1.getValueAt(i, 0).toString(), table1.getValueAt(i, 1).toString(),
						 table1.getValueAt(i, 2).toString(),table1.getValueAt(i, 3).toString(), 
						 table1.getValueAt(i, 4).toString(), table1.getValueAt(i, 5).toString(),
						 table1.getValueAt(i, 6).toString(), comList};
				
				 data[i+1] = temp;
			 }
			
			for(int i=size1;i<size;i++) {
				PurBackSheetVO vo = purBackSheet.get(i);
				
				ArrayList<CommodityVO> com = vo.getsheet();
				ArrayList<String> commoditywords = vo.getcommoditywords();
				int sizeOfcom = com.size();
				String comList = "";
				for(int j=0;j<sizeOfcom;j++) {
					
					CommodityVO comVO = com.get(j);
					comList = comList+ comVO.getId()+"，";
					comList = comList+ comVO.getName()+"，";
					comList = comList+ comVO.getModel()+"，";
					comList = comList+ comVO.getNumber()+"，";
					comList = comList+ comVO.getNumber()*comVO.getLastin()+"，";
					comList = comList+ commoditywords.get(j)+"；";
				}
				 
				String[] temp = {table1.getValueAt(i, 0).toString(), table1.getValueAt(i, 1).toString(),
						 table1.getValueAt(i, 2).toString(),table1.getValueAt(i, 3).toString(), 
						 table1.getValueAt(i, 4).toString(), table1.getValueAt(i, 5).toString(),
						 table1.getValueAt(i, 6).toString(), comList};
				
				 data[i+1] = temp;
			 }
			new Export("经营历程表--进货类单据",data);
		} else if(choose == 4) {
			
			int size = table1.getRowCount();
			int size1 = saleSheet.size();
			String[][] data = new String[size+1][];
			String[] names = {"单据编号","客户","业务员","操作员","仓库","折让前总额","折让","代金券",
					"折让后总额","备注","单据状态","商品清单"};
			data[0] = names;
			for(int i=0;i<size1;i++) {
				SaleSheetVO vo = saleSheet.get(i);
				
				ArrayList<CommodityVO> com = vo.getsheet();
				ArrayList<String> commoditywords = vo.getcommoditywords();
				int sizeOfcom = com.size();
				String comList = "";
				for(int j=0;j<sizeOfcom;j++) {
					
					CommodityVO comVO = com.get(j);
					comList = comList+ comVO.getId()+"，";
					comList = comList+ comVO.getName()+"，";
					comList = comList+ comVO.getModel()+"，";
					comList = comList+ comVO.getNumber()+"，";
					comList = comList+ comVO.getNumber()*comVO.getLastin()+"，";
					comList = comList+ commoditywords.get(j)+"；";
				}
				 
				String[] temp = {table1.getValueAt(i, 0).toString(), table1.getValueAt(i, 1).toString(),
						 table1.getValueAt(i, 2).toString(),table1.getValueAt(i, 3).toString(), 
						 table1.getValueAt(i, 4).toString(), table1.getValueAt(i, 5).toString(),
						 table1.getValueAt(i, 6).toString(), table1.getValueAt(i, 7).toString(),
						 table1.getValueAt(i, 8).toString(),table1.getValueAt(i, 9).toString(),
						 table1.getValueAt(i, 10).toString(),comList};
				
				 data[i+1] = temp;
			 }
			
			for(int i=size1;i<size;i++) {
				PurBackSheetVO vo = purBackSheet.get(i);
				
				ArrayList<CommodityVO> com = vo.getsheet();
				ArrayList<String> commoditywords = vo.getcommoditywords();
				int sizeOfcom = com.size();
				String comList = "";
				for(int j=0;j<sizeOfcom;j++) {
					
					CommodityVO comVO = com.get(j);
					comList = comList+ comVO.getId()+"，";
					comList = comList+ comVO.getName()+"，";
					comList = comList+ comVO.getModel()+"，";
					comList = comList+ comVO.getNumber()+"，";
					comList = comList+ comVO.getNumber()*comVO.getLastin()+"，";
					comList = comList+ commoditywords.get(j)+"；";
				}
				 
				String[] temp = {table1.getValueAt(i, 0).toString(), table1.getValueAt(i, 1).toString(),
						 table1.getValueAt(i, 2).toString(),table1.getValueAt(i, 3).toString(), 
						 table1.getValueAt(i, 4).toString(), table1.getValueAt(i, 5).toString(),
						 table1.getValueAt(i, 6).toString(), table1.getValueAt(i, 7).toString(),
						 table1.getValueAt(i, 8).toString(),table1.getValueAt(i, 9).toString(),
						 table1.getValueAt(i, 10).toString(),comList};
				
				 data[i+1] = temp;
			 }
			new Export("经营历程表--销售类单据",data);
		} else if(choose == 5) {
			int size = table1.getRowCount();		
			String[][] data = new String[size+1][];
			String[] names = {"单据编号","操作员","单据状态","商品组合"};
			data[0] = names;
			for(int i=0;i<size;i++) {
				GiftBillVO vo = gift.get(i);
				ArrayList<CommodityVO> com = vo.getComs();
				int sizeOfcom = com.size();
				String comList = "";
				for(int j=0;j<sizeOfcom;j++) {
					
					CommodityVO comVO = com.get(j);				
					comList = comList+ comVO.getName()+"，";
					comList = comList+ comVO.getModel()+"，";
					comList = comList+ comVO.getNumber()+"；";
						
				}
				 
				String[] temp = {table1.getValueAt(i, 0).toString(), table1.getValueAt(i, 1).toString(),
						 table1.getValueAt(i, 2).toString(), comList};
				
				 data[i+1] = temp;
			 }
			new Export("经营历程表--赠送单",data);
		} else if(choose == 6) {
			int size = table1.getRowCount();
			String[][] data = new String[size+1][];
			String[] names = {"单据编号","商品名","类型","数量"};
			data[0] = names;
			
			for(int i=0;i<size;i++) {
				GiftBillVO vo = gift.get(i);
				ArrayList<CommodityVO> com = vo.getComs();
				int sizeOfcom = com.size();
			
				 
				String[] temp = {table1.getValueAt(i, 0).toString(), table1.getValueAt(i, 1).toString(),
						 table1.getValueAt(i, 2).toString(),table1.getValueAt(i, 3).toString()};
				
				 data[i+1] = temp;
			 }
			new Export("经营历程表--库存类单据",data);
		}
	}
	public void updateTable1(int choose, InquiryProcessVO ipv){
		switch(choose){
		
		case 1: receipt = financial.getProcessReceipt(ipv);
				payment = financial.getProcessPayment(ipv);
				int size1 = receipt.size();
				int size2 = payment.size();
				int size = size1+size2;
	        Object[][] dataOfReAndPay = new Object[size][];
	        
	        for(int i=0;i<size1;i++){
	        	ReceiptVO tempReceipt = receipt.get(i);
	        	Object[] temp ={tempReceipt.getID(),tempReceipt.getCustomer(), 
	        			tempReceipt.getOp(), tempReceipt.getTotal(), 
	        			tempReceipt.getBillState()};
	        	dataOfReAndPay[i] = temp;
	        }
	        
	        for(int i=size1;i<size;i++){
	        	PaymentVO tempPayment = payment.get(i);
	        	Object[] temp ={tempPayment.getID(),tempPayment.getCustomer(), 
	        			tempPayment.getOp(), tempPayment.getTotal(), 
	        			tempPayment.getBillState()};
	        	dataOfReAndPay[i] = temp;
	        }
	        
			 model1.setDataVector(dataOfReAndPay, columnNames1);
			 table1.updateUI();
			 model2.setDataVector(new Object[][]{}, columnNames1s);
			 table2.updateUI();
			 break;
		case 2:
			cashPayment = financial.getProcessCashPayment(ipv);
			int sizeOfCashPayment = cashPayment.size();
	        Object[][] dataOfCashPayment = new Object[sizeOfCashPayment][];
	        for(int i=0;i<sizeOfCashPayment;i++){
	        	CashPaymentVO tempCashPayment = cashPayment.get(i);
	        	Object[] temp ={tempCashPayment.getID(),tempCashPayment.getAccount(),
	        			tempCashPayment.getOp(),tempCashPayment.getTotal(),
	        			tempCashPayment.getBillState()};
	        	dataOfCashPayment[i] = temp;
	        }
			
	        model1.setDataVector(dataOfCashPayment, columnNames2);     
			table1.updateUI();
			model2.setDataVector(new Object[][]{}, columnNames2s);
			table2.updateUI();
			break;
		case 3:
			purSheet = financial.getProcessPurSheet(ipv);
			purBackSheet = financial.getProcessPurBackSheet(ipv);
			int sizeOfPurSheet = purSheet.size();
			int sizeOfPurBackSheet = purBackSheet.size();
			int sizeOfPurAndBackSheet = sizeOfPurSheet+sizeOfPurBackSheet;
			Object[][] dataOfPurAndBackSheet = new Object[sizeOfPurAndBackSheet][];
	        for(int i=0;i<sizeOfPurSheet;i++){
	        	PurSheetVO tempPurSheet= purSheet.get(i);
	        	Object[] temp ={tempPurSheet.getid(),tempPurSheet.getcustomer(),
	        			tempPurSheet.getstock(),tempPurSheet.getop(),
	        			tempPurSheet.getwords(),tempPurSheet.getmoney1(),
	        			tempPurSheet.getState()};
	        	dataOfPurAndBackSheet[i] = temp;
	        }
	        for(int i=sizeOfPurSheet;i<sizeOfPurAndBackSheet;i++){
	        	PurBackSheetVO tempPurBackSheet= purBackSheet.get(i);
	        	Object[] temp ={tempPurBackSheet.getid(),tempPurBackSheet.getcustomer(),
	        			tempPurBackSheet.getstock(),tempPurBackSheet.getop(),
	        			tempPurBackSheet.getwords(),tempPurBackSheet.getmoney1(),
	        			tempPurBackSheet.getState()};
	        	dataOfPurAndBackSheet[i] = temp;
	        }
			  
	        model1.setDataVector(dataOfPurAndBackSheet, columnNames3);
			table1.updateUI();
			model2.setDataVector(new Object[][]{}, columnNames3s);
			table2.updateUI();
			break;
//有问题，业务员=========================================
		case 4:
	    	saleSheet = financial.getProcessSaleSheet(ipv);
	    	saleBackSheet = financial.getProcessSaleBackSheet(ipv);
	    	
	    	int sizeOfSale = saleSheet.size();
	    	int sizeOfSaleBack = saleBackSheet.size();
	    	int sizeOfSaleAndBack = sizeOfSale+sizeOfSaleBack;
	        Object[][] dataOfSaleAndBack = new Object[sizeOfSaleAndBack][];
	        for(int i=0;i<sizeOfSale;i++){
	        	SaleSheetVO saleVO = saleSheet.get(i);
	        	Object[] temp ={saleVO.getid(),saleVO.getcustomer(),
	        			saleVO.getop(), 
	        			saleVO.getstock(),saleVO.getmoney1(),saleVO.getdiscount(),
	        			saleVO.getmoney2(),saleVO.getpmoney(),saleVO.getwords(),
	        			saleVO.getState()};
	        	
	        	dataOfSaleAndBack[i] = temp;
	        }
	        for(int i=sizeOfSale;i<sizeOfSaleAndBack;i++){
	        	SaleBackSheetVO saleBackVO = saleBackSheet.get(i);
	        	Object[] temp ={saleBackVO.getid(),saleBackVO.getcustomer(),
	        			saleBackVO.getop(), 
	        			saleBackVO.getstock(),saleBackVO.getmoney1(),saleBackVO.getdiscount(),
	        			saleBackVO.getmoney2(),saleBackVO.getpmoney(),saleBackVO.getwords(),
	        			saleBackVO.getState()};
	        	
	        	dataOfSaleAndBack[i] = temp;
	        }
	        
	        model1.setDataVector(dataOfSaleAndBack, columnNames4);
		   	table1.updateUI();
			model2.setDataVector(new Object[][]{}, columnNames4s);
			table2.updateUI();
			break;
		case 5:
			
			gift = financial.getProcessGift(ipv);	
			int sizeOfGift = gift.size();
			
			Object[][] dataOfGift = new Object[sizeOfGift][];
	    	for(int i = 0;i<sizeOfGift;i++){
	    		GiftBillVO giftVO = gift.get(i);
	    		Object[] temp ={giftVO.getID(), giftVO.getOperator(), 
	    				giftVO.getState()};
	    		dataOfGift[i] = temp;
	    	}
	    	
			 model1.setDataVector(dataOfGift, columnNames5);		  
			 table1.updateUI();
			 model2.setDataVector(new Object[][]{}, columnNames5s);
			 table2.updateUI();
			 break;
		case 6:
			spillsLoss = financial.getProcessSpillLoss(ipv);
			alert = financial.getProcessAlert(ipv);
			
			int sizeOfSpillLoss = spillsLoss.size();
			int sizeOfAlert = alert.size();
			int sizeOfSpillLossAndAlert = sizeOfSpillLoss+sizeOfAlert;
			Object[][] dataOfSpillLossAndAlert = new Object[sizeOfSpillLossAndAlert][];
			for(int i=0;i<sizeOfSpillLoss;i++) {
				SpillsLossBillVO spillLossVO = spillsLoss.get(i);
				Object[] temp ={spillLossVO.getID(), spillLossVO.getCom().getName(),
						spillLossVO.getCom().getModel(), spillLossVO.getCom().getNumber()};
				dataOfSpillLossAndAlert[i] = temp;
			}
			for(int i=sizeOfSpillLoss;i<sizeOfSpillLossAndAlert;i++) {
				AlertBillVO alertVO = alert.get(i);
				Object[] temp ={alertVO.getID(), alertVO.getCom().getName(),
						alertVO.getCom().getModel(), alertVO.getCom().getNumber()};
				dataOfSpillLossAndAlert[i] = temp;
			}
			 model1.setDataVector(dataOfSpillLossAndAlert, columnNames6);		  
			 table1.updateUI();
			 model2.setDataVector(new Object[][]{}, columnNames6s);
			 table2.updateUI();
			 break;
		}
	}
    public void updateTable2(int choose,int index){
    	if(choose == 1){
    		int size1 = receipt.size();
    		int size2 = payment.size();
    		
    		if(index<size1) {
    			ReceiptVO vo = receipt.get(index);
    			ArrayList<String> accounts = vo.getAccounts();
    			ArrayList<Double> money = vo.getMoney();
    			ArrayList<String> remark = vo.getRemark();
    			int size = accounts.size();
    			Object[][] data = new Object[size][];
    			
    			for(int i = 0;i<size;i++){
    				
    				Object[] temp  = {accounts.get(i),money.get(i),remark.get(i)};
    				data[i] = temp;
    			}
    			model2.setDataVector(data, columnNames1s);
    			table2.updateUI();
    		} else {
    			index = index-size1;
    			PaymentVO vo = payment.get(index);
    			ArrayList<String> accounts = vo.getAccounts();
    			ArrayList<Double> money = vo.getMoney();
    			ArrayList<String> remark = vo.getRemark();
    			int size = accounts.size();
    			Object[][] data = new Object[size][];
    			
    			for(int i = 0;i<size;i++){
    				
    				Object[] temp  = {accounts.get(i),money.get(i),remark.get(i)};
    				data[i] = temp;
    			}
    			model2.setDataVector(data, columnNames1s);
    			table2.updateUI();
    		}
			
    	}
    	else if(choose == 2){
    		CashPaymentVO vo = cashPayment.get(index);
			ArrayList<String> items = vo.getItem();
			ArrayList<Double> money = vo.getMoney();
			ArrayList<String> remark = vo.getRemark();
			int size = items.size();
			Object[][] data = new Object[size][];
			
			for(int i = 0;i<size;i++){				
				Object[] temp  = {items.get(i),money.get(i),remark.get(i)};
				data[i] = temp;
			}
			
			model2.setDataVector(data, columnNames2s);
			table2.updateUI();
    	}
 //有问题=============================================
    	else if(choose == 3){
    		int size1 = purSheet.size();
    		int size2 = purBackSheet.size();
    		
    		if(index<size1) {
    			PurSheetVO vo = purSheet.get(index);
    			ArrayList<CommodityVO> sheet = vo.getsheet();
    			ArrayList<String> commoditywords = vo.getcommoditywords();
    			int size = sheet.size();
    			Object[][] data = new Object[size][];
    			for(int i = 0;i<size;i++) {
    				CommodityVO tempCom = sheet.get(i);
    				Object[] temp  = {tempCom.getId(), tempCom.getName(), 
    						tempCom.getModel(), tempCom.getNumber(), 
    						tempCom.getLastin(), tempCom.getLastin()*tempCom.getNumber() ,
    						commoditywords.get(i)};
    				data[i] = temp;
    			} 
    			model2.setDataVector(data, columnNames3s);
   			 	table2.updateUI();
    		}else {
    			index = index-size1;
    			PurBackSheetVO vo = purBackSheet.get(index);
    			ArrayList<CommodityVO> sheet = vo.getsheet();
    			ArrayList<String> commoditywords = vo.getcommoditywords();
    			int size = sheet.size();
    			Object[][] data = new Object[size][];
    			
    			for(int i = 0;i<size;i++) {
    				CommodityVO tempCom = sheet.get(i);
    				Object[] temp  = {tempCom.getId(), tempCom.getName(), 
    						tempCom.getModel(), tempCom.getNumber(), 
    						tempCom.getLastin(), tempCom.getLastin()*tempCom.getNumber() ,
    						commoditywords.get(i)};
    				data[i] = temp;
    			}
    			model2.setDataVector(data, columnNames3s);
   			 	table2.updateUI();
    		}
			 
    	}
    	else if(choose == 4){
    		int size1 = saleSheet.size();
    		int size2 = saleBackSheet.size();
    		
    		if(index<size1) {
    			SaleSheetVO vo = saleSheet.get(index);
    			ArrayList<CommodityVO> sheet = vo.getsheet();
    			ArrayList<String> commoditywords = vo.getcommoditywords();
    			int size = sheet.size();
    			Object[][] data = new Object[size][];
    			
    			for(int i = 0;i<size;i++) {
    				CommodityVO tempCom = sheet.get(i);
    				Object[] temp  = {tempCom.getId(), tempCom.getName(), 
    						tempCom.getModel(), tempCom.getNumber(), 
    						tempCom.getLastout(), tempCom.getNumber()*tempCom.getLastout() ,
    						commoditywords.get(i)};
    				data[i] = temp;
    			} 
    			model2.setDataVector(data, columnNames4s);
   			 	table2.updateUI();
    		}else {
    			index = index-size1;
    			SaleBackSheetVO vo = saleBackSheet.get(index);
    			ArrayList<CommodityVO> sheet = vo.getsheet();
    			ArrayList<String> commoditywords = vo.getcommoditywords();
    			int size = sheet.size();
    			Object[][] data = new Object[size][];
    			
    			for(int i = 0;i<size;i++) {
    				CommodityVO tempCom = sheet.get(i);
    				Object[] temp  = {tempCom.getId(), tempCom.getName(), 
    						tempCom.getModel(), tempCom.getNumber(), 
    						tempCom.getLastout(), tempCom.getNumber()*tempCom.getLastout() , 
    						commoditywords.get(i)};
    				data[i] = temp;
    			}
    			model2.setDataVector(data, columnNames4s);
   			 	table2.updateUI();
    		}
			 
    	}
    	else if(choose == 5){
    		GiftBillVO giftVO = gift.get(index);
			ArrayList<CommodityVO> coms = giftVO.getComs();
		
			int size = coms.size();
			Object[][] data = new Object[size][];
		
			for(int i = 0;i<size;i++){				
				CommodityVO vo = coms.get(i);
				Object[] temp  = {vo.getName(), vo.getModel(), vo.getNumber()};
				data[i] = temp;
			}
			
			model2.setDataVector(data, columnNames5s);
			table2.updateUI();
    	}
    	else if(choose == 6) {
    		
    	}
    }
    public class JPeditForBusinessProgress extends JPanel
    {
    	private JTextField year1;
    	private JTextField month1;
    	private JTextField date1;
    	private JTextField year2;
    	private JTextField month2;
    	private JTextField date2;
    	private JTextField salemanTxt;
    	private JComboBox customerCombo;
    	private JComboBox warehouseCombo;
    	private JComboBox billTypeCombo;
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
        
        public void reHome(){
        	this.RightMove();
        	year1.setText("");
        	month1.setText("");
        	date1.setText("");
        	year2.setText("");
        	month2.setText("");
        	date2.setText("");
        	salemanTxt.setText("");
        }
    	public JPeditForBusinessProgress(){
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
    		ye1.setBounds(94, 33, 25, 21);
    		add(ye1);
    		
    		JLabel m1 = new JLabel("月");
    		m1.setForeground(Color.WHITE);
    		m1.setFont(new Font("宋体", Font.BOLD, 14));
    		m1.setBounds(160, 32, 25, 23);
    		add(m1);
    		
    		JLabel d1 = new JLabel("日");
    		d1.setForeground(Color.WHITE);
    		d1.setFont(new Font("宋体", Font.BOLD, 14));
    		d1.setBounds(220, 33, 16, 21);
    		add(d1);
    		
    		year1 = new JTextField();
    		year1.setBounds(40, 33, 50, 20);
    		year1.setOpaque(false);//文本框透明
    		year1.setForeground(Color.white);//前景色
    		year1.setCaretColor(Color.white);
    		add(year1);
    		year1.setColumns(10);
    		
    		month1 = new JTextField();
    		month1.setOpaque(false);//文本框透明
    		month1.setForeground(Color.white);//前景色
    		month1.setCaretColor(Color.white);
    		month1.setColumns(10);
    		month1.setBounds(113, 33, 43, 21);
    		add(month1);
    		
    		date1 = new JTextField();
    		date1.setOpaque(false);//文本框透明
    		date1.setForeground(Color.white);//前景色
    		date1.setCaretColor(Color.white);
    		date1.setColumns(10);
    		date1.setBounds(178, 33, 36, 21);
    		add(date1);
    		
    		JLabel start = new JLabel("起始时间");
    		start.setForeground(Color.WHITE);
    		start.setFont(new Font("宋体", Font.BOLD, 14));
    		start.setBounds(94, 10, 72, 21);
    		add(start);
    		
    		JLabel over = new JLabel("结束时间");
    		over.setForeground(Color.WHITE);
    		over.setFont(new Font("宋体", Font.BOLD, 14));
    		over.setBounds(94, 64, 72, 21);
    		add(over);
    		
    		year2 = new JTextField();
    		year2.setOpaque(false);//文本框透明
    		year2.setForeground(Color.white);//前景色
    		year2.setCaretColor(Color.white);
    		year2.setColumns(10);
    		year2.setBounds(40, 90, 50, 20);
    		add(year2);
    		
    		month2 = new JTextField();
    		month2.setOpaque(false);//文本框透明
    		month2.setForeground(Color.white);//前景色
    		month2.setCaretColor(Color.white);
    		month2.setColumns(10);
    		month2.setBounds(113, 90, 43, 21);
    		add(month2);
    		
    		date2 = new JTextField();
    		date2.setOpaque(false);//文本框透明
			date2.setForeground(Color.white);//前景色
			date2.setCaretColor(Color.white);
    		date2.setColumns(10);
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
    		
    		JLabel label = new JLabel("单据类型");
    		label.setForeground(Color.WHITE);
    		label.setFont(new Font("宋体", Font.BOLD, 14));
    		label.setBounds(40, 120, 60, 21);
    		add(label);
    		
    		String[] billTypeStr={"付款收款单","现金费用单","进货类单据","销售类单据","赠送单","报警单和报溢报损单"};
    		billTypeCombo= new JComboBox(billTypeStr);
    		billTypeCombo.setBounds(104, 120, 126, 20);
    		billTypeCombo.setBackground(Color.gray);
    		billTypeCombo.setForeground(Color.white);
    		add(billTypeCombo);
    		
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
    		customerCombo= new JComboBox(customerS2);
    		customerCombo.setBounds(74, 145, 156, 20);
    		customerCombo.setBackground(Color.gray);
    		customerCombo.setForeground(Color.white);
    		add(customerCombo);
    		
    		JLabel label_2 = new JLabel("业务员");
    		label_2.setForeground(Color.WHITE);
    		label_2.setFont(new Font("宋体", Font.BOLD, 14));
    		label_2.setBounds(40, 168, 50, 21);
    		add(label_2);
    		
    		JLabel label_3 = new JLabel("仓库");
    		label_3.setForeground(Color.WHITE);
    		label_3.setFont(new Font("宋体", Font.BOLD, 14));
    		label_3.setBounds(40, 192, 36, 21);
    		add(label_3);
    		
    		salemanTxt = new JTextField();
    		salemanTxt.setOpaque(false);//文本框透明
    		salemanTxt.setForeground(Color.white);//前景色
    		salemanTxt.setCaretColor(Color.white);
    		salemanTxt.setColumns(10);
    		salemanTxt.setBounds(90, 168, 140, 20);
    		add(salemanTxt);
    		
    		String[] warehouseStr={"仓库1"};
    		warehouseCombo = new JComboBox(warehouseStr);
    		warehouseCombo.setBounds(74, 192, 156, 20);
    		warehouseCombo.setBackground(Color.gray);
    		warehouseCombo.setForeground(Color.white);
    		add(warehouseCombo);
    		
    		JLabel bg = new JLabel("bg");
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
    				boolean legal=true;
    				int type=0;
    				if(billTypeCombo.getSelectedItem().toString().equals("付款收款单")){
    					  //单据类型
    					type = 1;//1：付款收款单；2：现金费用单；3：进货单据；4：销售单据；5：赠送单；6：报警单和报溢报损
    				}
    				else if(billTypeCombo.getSelectedItem().toString().equals("现金费用单")){
    					type = 2;
    				}
    				else if(billTypeCombo.getSelectedItem().toString().equals("进货类单据")){
    					type = 3;
    				}
    				else if(billTypeCombo.getSelectedItem().toString().equals("销售类单据")){
    					type = 4;
    				}
    				else if(billTypeCombo.getSelectedItem().toString().equals("赠送单")){
    					type = 5;
    				}
    				else if(billTypeCombo.getSelectedItem().toString().equals("报警单和报溢报损单")){
    					type = 6;
    				}
    				
    				//查找
					String startTime=null;
					String lastTime=null;
					String customer=null;
					String stock=null;
					String deSaler=null;//业务员
					if(!year1.getText().equals("")
							&&!month1.getText().equals("")
							&&!date1.getText().equals("")
							&&!year2.getText().equals("")
							&&!month2.getText().equals("")
							&&!date2.getText().equals("")){
						startTime=year1.getText()+"/"+month1.getText()+"/"+date1.getText();
						lastTime=year2.getText()+"/"+month2.getText()+"/"+date2.getText();
						if(stringJg.judgestring(year1.getText())!=3
								||stringJg.judgestring(month1.getText())!=3
								||stringJg.judgestring(date1.getText())!=3
								||stringJg.judgestring(year2.getText())!=3
								||stringJg.judgestring(month2.getText())!=3
								||stringJg.judgestring(date2.getText())!=3){
							legal=false;
							frame.getWarning().showWarning("时间必须为数字");
						}
					}
					if(!customerCombo.getSelectedItem().toString().equals("")){
						customer=customerCombo.getSelectedItem().toString();
					}
					if(!warehouseCombo.getSelectedItem().toString().equals("")){
						stock=warehouseCombo.getSelectedItem().toString();
					}
					if(!salemanTxt.getText().equals("")){
						deSaler=salemanTxt.getText();
					}
					if(legal){
						InquiryProcessVO vo=new InquiryProcessVO();
						vo.setCustomer(customer);
						vo.setDeSaler(deSaler);
						vo.setStock(stock);
						vo.setTimeBefore(startTime);
						vo.setTimeAfter(lastTime);
	    				updateTable1(type,vo);
	    				choose=type;
					}
				
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
    				JPeditForBusinessProgress.this.setLocation(x, y);
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
    				JPeditForBusinessProgress.this.setLocation(x, y);
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
