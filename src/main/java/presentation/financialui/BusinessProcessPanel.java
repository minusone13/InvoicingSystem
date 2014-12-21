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
import vo.AlertBillVO;
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
import vo.stockvo.CommodityVO;

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
    public BusinessProcessPanel() {
    	initial();
	}
	
	public void initial() {
		this.setBounds(0, 0, 700, 320);
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
		
		add(pane1);
		add(pane2);
		add(jpbg1);
		add(jpbg2);
		
	}
	
	public void export(int choose) {
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
}
