package presentation.managerui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import po.BillState;
import po.BillStyle;
import po.Role;
import presentation.StringJudger;
import presentation.userui.Login;
import vo.CustomerVO;
import vo.GiftBillVO;
import vo.PurSheetVO;
import vo.financialBillVO.CashPaymentVO;
import vo.stockvo.CommodityVO;
import businesslogic.customerbl.CustomerList;
import businesslogicservice.customerblservice.CustomerBlService;
import entrance.Frame;

public class JPpassBill2 extends JPanel {

	//背景
	private JLabel bg=new JLabel();
	//向上
	private JLabel up=new JLabel();
	//向下
	private JLabel down=new JLabel();
	//单据列表
	private JPBillList billList=new JPBillList();
	public JPBillList getBillList() {
		return billList;
	}
	public void setBillList(JPBillList billList) {
		this.billList = billList;
	}
	//清单表格
	private JTableOfList table=new JTableOfList();
	//审查通过功能按钮
	private JLabel check=new JLabel();
	//删除按钮
	private JLabel delete=new JLabel();
	//编辑按钮
	private JLabel edit=new JLabel();
	//单据类型
	private BillStyle style;
	//编辑面板
	private JPanelEdit JPeditOfGift;
	private JPanelEdit JPeditOfPur;
	private JPanelEdit JPeditOfCash;
	//图片
	ImageIcon upIconW=new ImageIcon("src/image/upW.png");
	ImageIcon downIconW=new ImageIcon("src/image/downW.png");
	ImageIcon checkIconW=new ImageIcon("src/image/function/checkW.png");
	ImageIcon deleteIconW=new ImageIcon("src/image/function/deleteW.png");
	ImageIcon editIconW=new ImageIcon("src/image/function/editW.png");
	
	ImageIcon upIconR=new ImageIcon("src/image/upR.png");
	ImageIcon downIconR=new ImageIcon("src/image/downR.png");
	ImageIcon checkIconR=new ImageIcon("src/image/function/checkR.png");
	ImageIcon deleteIconR=new ImageIcon("src/image/function/deleteR.png");
	ImageIcon editIconR=new ImageIcon("src/image/function/editR.png");
	//frame的引用
    Frame frame;
    //调用逻辑层
    CustomerBlService customerbl=new CustomerList();
    public JPanelEdit getJPeditOfGift()
	{
		return JPeditOfGift;
	}
	public void setJPeditOfGift(JPanelEdit jPeditOfGift)
	{
		JPeditOfGift = jPeditOfGift;
	}
	public JPanelEdit getJPeditOfPur()
	{
		return JPeditOfPur;
	}
	public void setJPeditOfPur(JPanelEdit jPeditOfPur)
	{
		JPeditOfPur = jPeditOfPur;
	}
	public JPanelEdit getJPeditOfCash()
	{
		return JPeditOfCash;
	}
	public void setJPeditOfCash(JPanelEdit jPeditOfCash)
	{
		JPeditOfCash = jPeditOfCash;
	}
	public void reHome(){
    	JPeditOfGift.reHome();
    	JPeditOfPur.reHome();
    	JPeditOfCash.reHome();
    }
	public JPpassBill2(){
		//面板大小
		this.setSize(905, 342);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//该面板背景
		bg.setIcon(new ImageIcon("src/image/passBill/PassBillblock2.png"));
		bg.setBounds(0, 0, 345, 342);
		//底板
		JPanel jp=new JPanel();
		jp.setLayout(null);
		jp.setBounds(20,20,261, 93*3+22);
		jp.setOpaque(false);
		//底板的灰色背景
		JLabel jpbg=new JLabel();
		jpbg.setBounds(0, 0, 261, 301);
		jpbg.setIcon(new ImageIcon("src/image/passBill/Pb2.png"));
		
		//将单据vo数组加到单据面板列表
		billList.setLocation(0, 0);
		
		//将列表加在底板上
		jp.add(billList,0);
		jp.add(jpbg,1);
		
		//表格
		table.setLocation(375, 10);

		billList.getTable(table);//将引用传递
		//向上按钮
		up.setIcon(upIconW);
		up.setBounds(281, 20, 32, 32);
		up.addMouseListener(new MouseListenerOfButton(1));
		//向下按钮
		down.setIcon(downIconW);
		down.setBounds(281, 289, 32, 32);
		down.addMouseListener(new MouseListenerOfButton(2));
		
		//处理功能按钮
		check.setIcon(checkIconW);
		check.setBounds(720, 20, 50, 50);
		check.addMouseListener(new MouseListenerOfButton(3));
		//删除功能按钮
		delete.setIcon(deleteIconW);
		delete.setBounds(720, 85, 50, 50);
		delete.addMouseListener(new MouseListenerOfButton(4));
		//编辑功能按钮
		edit.setIcon(editIconW);
		edit.setBounds(720, 150, 50, 50);
		edit.addMouseListener(new MouseListenerOfButton(5));
		//编辑面板
		JPeditOfGift=new JPanelEdit(BillStyle.GiftBill);
		JPeditOfPur=new JPanelEdit(BillStyle.PurSheet);
		JPeditOfCash=new JPanelEdit(BillStyle.CashPaymentBill);
		
		JPeditOfGift.setLocation(905, 36);
		JPeditOfPur.setLocation(905, 36);
		JPeditOfCash.setLocation(905, 36);
		
		this.add(jp,0);
		this.add(up,1);
		this.add(down,2);
		this.add(JPeditOfGift,3);
		this.add(JPeditOfPur,4);
		this.add(JPeditOfCash,5);
		this.add(check,6);
		this.add(delete,7);
		this.add(edit,8);
		this.add(table,9);
		this.add(bg,10);
	}
	/*重新设置类型*/
	public void setStyle( BillStyle s){
		style=s;
		String[] items=null;
		switch(style){
		case GiftBill:
			String[] temp1={"赠品","型号","数量"};
			items=temp1;
			table.setColumnNames(items);
			table.setList(new String[1][3]);
			table.updateShow();
			table.setVisible(true);
			break;
		case SpillsLossBill:
			table.setVisible(false);
			break;
		case AlertBill:
			table.setVisible(false);
			break;
		case PurBackSheet:
			String[] temp2={"编号","名称","型号","数量","单价","金额","备注"};
			items=temp2;
			table.setColumnNames(items);
			table.setList(new String[1][7]);
			table.updateShow();
			table.setVisible(true);
			break;
		case SaleSheet:
			String[] temp3={"编号","名称","型号","数量","单价","金额","备注"};
			items=temp3;
			table.setColumnNames(items);
			table.setList(new String[1][7]);
			table.updateShow();
			table.setVisible(true);
			break;
		case SaleBackSheet:
			String[] temp4={"编号","名称","型号","数量","单价","金额","备注"};
			items=temp4;
			table.setColumnNames(items);
			table.setList(new String[1][7]);
			table.updateShow();
			table.setVisible(true);
			break;
		case ReceiptBill:
			String[] temp5={"银行账户","转账金额","备注"};
			items=temp5;
			table.setColumnNames(items);
			table.setList(new String[1][3]);
			table.updateShow();
			table.setVisible(true);
			break;
		case PaymentBill:
			String[] temp6={"银行账户","转账金额","备注"};
			items=temp6;
			table.setColumnNames(items);
			table.setList(new String[1][3]);
			table.updateShow();
			table.setVisible(true);
			break;
		case PurSheet:
			String[] temp7={"编号","名称","型号","数量","单价","金额","备注"};
			items=temp7;
			table.setColumnNames(items);
			table.setList(new String[1][7]);
			table.updateShow();
			table.setVisible(true);
			break;
		case CashPaymentBill:
			String[] temp8={"条目名","金额","备注"};
			items=temp8;
			table.setColumnNames(items);
			table.setList(new String[1][3]);
			table.updateShow();
			table.setVisible(true);
			break;
		}
		
	}
	/*获取frame的引用*/
	public void getFrame( Frame f){
  		frame=f;
  		billList.setFrame(frame);
    }
	/*按钮的监控*/
	public class MouseListenerOfButton implements MouseListener{

		private int num;
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
			up.setIcon(upIconR);
			//向下
			billList.startDown();
				break;
			case 2:
			down.setIcon(downIconR);
			//向上
			billList.startUp();
		
				break;	
			case 3:
				check.setIcon(checkIconR);
				billList.passChosen();
				break;
			case 4:
				delete.setIcon(deleteIconR);
				billList.removeChosen();
				break;
			case 5:
				edit.setIcon(editIconR);
				if(billList.getChosenNum()==1){
					if(billList.stateOfChosen()==BillState.SUBMITED){
						switch(style){
							case GiftBill:
								JPeditOfGift.leftMove();
								break;
							case PurSheet:
								JPeditOfPur.leftMove();
								break;
							case CashPaymentBill:
								JPeditOfCash.leftMove();
								break;
							default:
								frame.getWarning().showWarning("您无权修改此单据");
							}
					}
					else{
						frame.getWarning().showWarning("总经理只能修改提交状态的单据");
					}
					
				}
				else if(billList.getChosenNum()==0){
					frame.getWarning().showWarning("请选择要修改的单据");
				}
				else{
					frame.getWarning().showWarning("只能同时修改一张单据");
				}
				
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
			up.setIcon(upIconW);
			//向上停止
			billList.stop();
				break;
			case 2:
			down.setIcon(downIconW);
			//向上停止
			billList.stop();
				break;	
			case 3:
				check.setIcon(checkIconW);
				break;
			case 4:
				delete.setIcon(deleteIconW);
				break;
			case 5:
				edit.setIcon(editIconW);
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
				up.setIcon(upIconW);
				break;
			case 2:
				down.setIcon(downIconW);
				break;	
			case 3:
				check.setIcon(checkIconW);
				break;
			case 4:
				delete.setIcon(deleteIconW);
				break;
			case 5:
				edit.setIcon(editIconW);
				break;		
			}
		}
		
	}
	/*编辑栏面板*/
	public class JPanelEdit extends JPanel{
		//辨别单据类型
		private BillStyle billStyle;
		//背景
		private JLabel back=new JLabel();
		//右移按钮
		private JLabel right=new JLabel();
		//确认按钮
		private JLabel confirm=new JLabel();
		//图片
		private ImageIcon right0=new ImageIcon("src/image/function/rightW.png");
		private ImageIcon right1=new ImageIcon("src/image/function/rightR.png");
		private ImageIcon add0=new ImageIcon("src/image/function/littleAddW.png");
		private ImageIcon add1=new ImageIcon("src/image/function/littleAddR.png");
		private ImageIcon confirm0=new ImageIcon("src/image/function/confirmW.png");
		private ImageIcon confirm1=new ImageIcon("src/image/function/confirmR.png");
		
		//现金费用单的附件
		private JLabel total=new JLabel("总额");
		private JTextField totalText=new JTextField(10);


		//赠送单的附件
		private JLabel addList=new JLabel();//增加商品按钮
		private JLabel reason=new JLabel("赠送原因");
		private JTextField reasonTxt=new JTextField(10);
		//进货单的附件
		private JLabel customer=new JLabel("客户");
		private JLabel warehouse=new JLabel("仓库");
		private JLabel list=new JLabel("商品清单");
		private JLabel note=new JLabel("备注");
		private JComboBox customerCombo;
		private JComboBox warehouseCombo;
		private JTextField noteText=new JTextField(10);
		//接收输出的商品
		private ArrayList<CommodityVO> output=new ArrayList<CommodityVO>();
		//接收输出的备注
		private ArrayList<String> outputNotes;
		//字符串类型判断
	    StringJudger stringJg=new StringJudger();
		public void reHome(){
			this.RightMove();
			totalText.setText("");
			reasonTxt.setText("");
			noteText.setText("");
		}
		public JPanelEdit(BillStyle style){
			//确认种类
			billStyle=style;
			//面板大小
			this.setSize(240,270);
			//设置布局
			this.setLayout(null);
			//设置面板透明
			this.setOpaque(false);
			//监控
			this.addMouseListener(new MouseListenerGetXY());
			//背景
			back.setIcon(new ImageIcon("src/image/function/editBlock.png"));
			back.setBounds(0, 0, 240,270);
			//右移按钮
			right.setIcon(right0);
			right.setBounds(10, 123, 24, 24);
			right.addMouseListener(new MouseListenerOfButton(1));
			//确认按钮
			confirm.setIcon(confirm0);
			confirm.setBounds(120, 236, 24, 24);
			confirm.addMouseListener(new MouseListenerOfButton(3));
			//根据单据种类加上不同的附件
			switch(style){
			case GiftBill:
				//设置标签字体
				list.setFont(new Font("宋体",Font.BOLD,14));
				list.setText("赠品清单");
				reason.setFont(new Font("宋体",Font.BOLD,14));
				//设置字体颜色
				list.setForeground(Color.white);
				reason.setForeground(Color.white);
				//设置标签大小位置
				list.setBounds(40, 30, 60, 20);
				reason.setBounds(40,60, 60, 20);
				//增加条目按钮
				addList.setIcon(add0);
				addList.setBounds(105, 28, 24, 24);
				addList.addMouseListener(new MouseListenerOfButton(2));
				//赠送原因文本框
				reasonTxt.setBounds(110,60, 120, 20);
				reasonTxt.setOpaque(false);//文本框透明
				reasonTxt.setForeground(Color.white);//前景色
				reasonTxt.setCaretColor(Color.white);
				
				this.add(list,0);
				this.add(reason,1);
				this.add(addList,2);
				this.add(reasonTxt,3);
				this.add(right,4);
				this.add(confirm,5);
				this.add(back,6);
				break;
			case PurSheet:
				//设置标签字体
				customer.setFont(new Font("宋体",Font.BOLD,14));
				warehouse.setFont(new Font("宋体",Font.BOLD,14));
				list.setFont(new Font("宋体",Font.BOLD,14));
				total.setFont(new Font("宋体",Font.BOLD,14));
				note.setFont(new Font("宋体",Font.BOLD,14));
				//设置字体颜色
				customer.setForeground(Color.white);
				warehouse.setForeground(Color.white);
				list.setForeground(Color.white);
				total.setForeground(Color.white);
				note.setForeground(Color.white);
				//设置标签大小位置
				customer.setBounds(40, 30, 40, 20);
				warehouse.setBounds(40, 60, 40, 20);
				list.setBounds(40, 90, 60, 20);
				total.setBounds(40, 120, 40, 20);
				note.setBounds(40, 150, 40, 20);
				//客户选择下拉框
				ArrayList<CustomerVO> customers = null;
				customers = customerbl.getAllCustomer("Customer.txt");
				String[] customerS=new String[customers.size()];
				for(int i=0;i<customers.size();i++){
					customerS[i]=customers.get(i).getname()+":"+customers.get(i).getid();
				}
				customerCombo = new JComboBox(customerS);
				customerCombo.setFont(new Font("宋体",Font.BOLD,14));
				customerCombo.setBounds(80,30, 150, 20);
				customerCombo.setBackground(Color.gray);
				customerCombo.setForeground(Color.white);
				//仓库选择下拉框
				String[] warehouseS={"仓库1"};
				warehouseCombo = new JComboBox(warehouseS);
				warehouseCombo.setFont(new Font("宋体",Font.BOLD,14));
				warehouseCombo.setBounds(80,60, 150, 20);
				warehouseCombo.setBackground(Color.gray);
				warehouseCombo.setForeground(Color.white);
				//增加条目按钮
				addList.setIcon(add0);
				addList.setBounds(105, 88, 24, 24);
				addList.addMouseListener(new MouseListenerOfButton(2));
				//总额文本框
				totalText.setBounds(80,120, 150, 20);
				totalText.setOpaque(false);//文本框透明
				totalText.setForeground(Color.white);//前景色
				totalText.setCaretColor(Color.white);
				//备注文本框
				noteText.setBounds(80,150, 150, 20);
				noteText.setOpaque(false);//文本框透明
				noteText.setForeground(Color.white);//前景色
				noteText.setCaretColor(Color.white);
				
				this.add(customer,0);
				this.add(warehouse,1);
				this.add(list,2);
				this.add(total,3);
				this.add(note,4);
				this.add(right,5);
				this.add(customerCombo,6);
				this.add(warehouseCombo,7);
				this.add(addList,8);
				this.add(totalText,9);
				this.add(noteText,10);
				this.add(confirm,11);
				this.add(back,12);
				break;
			case CashPaymentBill:
				//设置标签字体
				total.setFont(new Font("宋体",Font.BOLD,14));
				//设置字体颜色
				total.setForeground(Color.white);
				//设置标签大小位置
				total.setBounds(40, 30, 40, 20);
				//总额文本框
				totalText.setBounds(80,30, 150, 20);
				totalText.setOpaque(false);//文本框透明
				totalText.setForeground(Color.white);//前景色
				totalText.setCaretColor(Color.white);
				
				this.add(total,0);
				this.add(totalText,1);
				this.add(right,2);
				this.add(confirm,3);
				this.add(back,4);
				break;
			}
		}
		/*返回收款付款单编辑栏的客户选择下拉框*/
		public void leftMove(){
			if(style==BillStyle.PurSheet){
				customerCombo.removeAllItems();
				
				ArrayList<CustomerVO> customers = null;
				customers = customerbl.getAllCustomer("Customer.txt");
				for(int i=0;i<customers.size();i++){
					customerCombo.addItem(customers.get(i).getname()+":"+customers.get(i).getid());
				}
			}
			Thread t=new Thread(new TreadOfLeft());
			t.start();
		}
		public void RightMove(){
			Thread t=new Thread(new TreadOfRight());
			t.start();
		}
		public ArrayList<CommodityVO> getOutput()
		{
			return output;
		}
		public void setOutput(ArrayList<CommodityVO> output)
		{
			this.output = output;
		}
		public ArrayList<String> getOutputNotes()
		{
			return outputNotes;
		}
		public void setOutputNotes(ArrayList<String> outputNotes)
		{
			this.outputNotes = outputNotes;
		}
		public class MouseListenerOfButton implements MouseListener{

			private int num;//1、右移 2、加号 3、确认
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
				case 2:
					addList.setIcon(add1);
					//显示编辑商品面板
					switch(billStyle){
					case GiftBill:
						frame.getManager().getCommodityChoose().getContent().innitial();
						frame.getManager().getCommodityChoose().setVisible(true);
						break;
					case PurSheet:
						frame.getManager().getCommodityChoose().setRole(Role.PURCHASE_SALE_STAFF);
						frame.getManager().getCommodityChoose().getContent().innitial();
						frame.getManager().getCommodityChoose().setVisible(true);
						break;
					case CashPaymentBill:
					}
					
					break;
				case 3:
					confirm.setIcon(confirm1);
					if(billList.getChosenNum()==1){
						switch(billStyle){
							case GiftBill:
								if(!reasonTxt.getText().equals("")||output!=null){
									GiftBillVO modifyGift=billList.getChosen().getGiftVO();
									if(!reasonTxt.getText().equals("")){
										String[] temp=modifyGift.getRemark();
										temp[0]=reasonTxt.getText();//修改赠送原因
										modifyGift.setRemark(temp);
									}
									if(output!=null){
										modifyGift.setComs(output);
									}
									billList.changeChosen(modifyGift);
									frame.getWarning().showWarning("修改成功");
								}
								else{
									frame.getWarning().showWarning("请输入修改信息");
								}
								break;
							case PurSheet:
								boolean legal=true;
								if(!customerCombo.getSelectedItem().toString().equals("")
										||!warehouseCombo.getSelectedItem().toString().equals("")
										||output!=null
										||!totalText.getText().equals("")
										||!noteText.getText().equals("")){
									if(!totalText.getText().equals("")&&stringJg.judgestring(totalText.getText())!=3){
										legal=false;
										frame.getWarning().showWarning("总额必须为数字");
									}
									if(legal){
										PurSheetVO modifyPur=billList.getChosen().getPurVO();
										if(!customerCombo.getSelectedItem().toString().equals("")){
											String[] temp=customerCombo.getSelectedItem().toString().split(":");
											modifyPur.setCustomer(customerbl.findCustomer(temp[1]));
										}
										if(!warehouseCombo.getSelectedItem().toString().equals("")){
											modifyPur.setstock(warehouseCombo.getSelectedItem().toString());
										}
										if(output!=null){
											modifyPur.setsheet(output);
											modifyPur.setcommoditywords(outputNotes);
										}
										if(!totalText.getText().equals("")){
											modifyPur.setmoney1(Double.parseDouble(totalText.getText()));
										}
										if(!noteText.getText().equals("")){
											modifyPur.setwords(noteText.getText());
										}
										modifyPur.setop(Login.user.getName()+":"+Login.user.getID());
										billList.changeChosen(modifyPur);
									}
								}
								else{
									frame.getWarning().showWarning("请输入修改信息");
								}
								break;
							case CashPaymentBill:
								if(!totalText.getText().equals("")){
									if(stringJg.judgestring(totalText.getText())!=3){
										frame.getWarning().showWarning("总额必须为数字");
									}
									else{
										CashPaymentVO modifyCash=billList.getChosen().getCashVO();
										modifyCash.setTotal(Double.parseDouble(totalText.getText()));
										billList.changeChosen(modifyCash);
										frame.getWarning().showWarning("修改成功");
									}
								}
								else{
									frame.getWarning().showWarning("请输入修改信息");
								}
								break;
						}
					}
					else if(billList.getChosenNum()==0){
						frame.getWarning().showWarning("请选择要修改的单据");
					}
					else{
						frame.getWarning().showWarning("只能同时修改一张单据");
					}
					
					break;
				}
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				switch(num){
				case 1:
					right.setIcon(right0);
					break;
				case 2:
					addList.setIcon(add0);
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
				case 2:
					addList.setIcon(add0);
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
					JPanelEdit.this.setLocation(x, y);
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
					JPanelEdit.this.setLocation(x, y);
				}
			}
			
		}
		public JTextField getTotalText()
		{
			return totalText;
		}
		public void setTotalText(JTextField totalText)
		{
			this.totalText = totalText;
		}
	}
	
}
