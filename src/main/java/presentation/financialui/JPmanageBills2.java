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
import javax.swing.JTextField;

import po.BillState;
import po.BillStyle;
import presentation.StringJudger;
import presentation.managerui.JPBillList;
import presentation.managerui.JTableOfList;
import presentation.managerui.MouseListenerGetXY;
import presentation.userui.Login;
import vo.CustomerVO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import businesslogic.customerbl.CustomerList;
import businesslogic.financialbl.Financial;
import businesslogic.salebillbl.salebillController;
import businesslogicservice.customerblservice.CustomerBlService;
import businesslogicservice.financialblservice.FinancialBlService;
import businesslogicservice.salebillblservice.SaleBillBlService;
import entrance.Frame;

public class JPmanageBills2 extends JPanel {
	    //背景
		private JLabel bg=new JLabel();
		//向上
		private JLabel up=new JLabel();
		//向下
		private JLabel down=new JLabel();
		//单据列表
		private JPBillList billList=new JPBillList();
		//清单表格
		private JTableOfList table=new JTableOfList();
		//处理按钮
		private JLabel done=new JLabel();
		//删除按钮
		private JLabel delete=new JLabel();
		//编辑按钮
		private JLabel edit=new JLabel();
		//提交按钮
		private JLabel submit=new JLabel();
		//创建按钮
		private JLabel add=new JLabel();
		//编辑面板
		private JPanelEdit JPeditOfCash;
		//编辑面板
		private JPanelEdit JPeditOfPay;
		//编辑面板
		private JPanelEdit JPeditOfRec;

		//单据类型
		private BillStyle style;
		//图片
		ImageIcon upIconW=new ImageIcon("src/image/upW.png");
		ImageIcon downIconW=new ImageIcon("src/image/downW.png");
		ImageIcon checkIconW=new ImageIcon("src/image/function/checkW.png");
		ImageIcon deleteIconW=new ImageIcon("src/image/function/deleteW.png");
		ImageIcon editIconW=new ImageIcon("src/image/function/editW.png");
		ImageIcon submitIconW=new ImageIcon("src/image/function/uploadW.png");
		ImageIcon addIconW=new ImageIcon("src/image/function/addW.png");
		
		ImageIcon upIconR=new ImageIcon("src/image/upR.png");
		ImageIcon downIconR=new ImageIcon("src/image/downR.png");
		ImageIcon checkIconR=new ImageIcon("src/image/function/checkR.png");
		ImageIcon deleteIconR=new ImageIcon("src/image/function/deleteR.png");
		ImageIcon editIconR=new ImageIcon("src/image/function/editR.png");
		ImageIcon submitIconR=new ImageIcon("src/image/function/uploadR.png");
		ImageIcon addIconR=new ImageIcon("src/image/function/addR.png");
		//frame的引用
	    Frame frame;
	 	//字符串类型判断
	    StringJudger stringJg=new StringJudger();
	    CustomerBlService customerbl=new CustomerList();
	    public void reHome(){
	    	JPeditOfCash.reHome();
	    	JPeditOfPay.reHome();
	    	JPeditOfRec.reHome();
	    }
		public JPmanageBills2(){//参数决定编辑板的类型
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
			done.setIcon(checkIconW);
			done.setBounds(720, 20, 50, 50);
			done.addMouseListener(new MouseListenerOfButton(3));
			//删除功能按钮
			delete.setIcon(deleteIconW);
			delete.setBounds(720, 85, 50, 50);
			delete.addMouseListener(new MouseListenerOfButton(4));
			//编辑功能按钮
			edit.setIcon(editIconW);
			edit.setBounds(720, 150, 50, 50);
			edit.addMouseListener(new MouseListenerOfButton(5));
			//提交功能按钮
			submit.setIcon(submitIconW);
			submit.setBounds(720, 215, 50, 50);
			submit.addMouseListener(new MouseListenerOfButton(6));
			//创建功能按钮
			add.setIcon(addIconW);
			add.setBounds(720, 280, 50, 50);
			add.addMouseListener(new MouseListenerOfButton(7));
			//编辑面板
			JPeditOfCash=new JPanelEdit(BillStyle.CashPaymentBill);
			JPeditOfRec=new JPanelEdit(BillStyle.ReceiptBill);
			JPeditOfPay=new JPanelEdit(BillStyle.PaymentBill);
			
			JPeditOfCash.setLocation(905, 36);
			JPeditOfRec.setLocation(905, 36);
			JPeditOfPay.setLocation(905, 36);
			
			this.add(jp,0);
			this.add(up,1);
			this.add(down,2);
			this.add(JPeditOfCash,3);
			this.add(JPeditOfRec,4);
			this.add(JPeditOfPay,5);
			this.add(done,6);
			this.add(delete,7);
			this.add(edit,8);
			this.add(submit,9);
			this.add(add,10);
			this.add(table,11);
			this.add(bg,12);
		}
		  /*获取frame引用*/
	    public void getFrame( Frame f){
	    		frame=f;
	    		billList.setFrame(frame);
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
				break;
			case SpillsLossBill:
				table.setVisible(false);
				break;
			case AlertBill:
				table.setVisible(false);
				break;
			case PurBackSheet:
				String[] temp2={"商品","型号","数量"};
				items=temp2;
				table.setColumnNames(items);
				table.setList(new String[1][3]);
				table.updateShow();
				break;
			case SaleSheet:
				String[] temp3={"商品","型号","数量"};
				items=temp3;
				table.setColumnNames(items);
				table.setList(new String[1][3]);
				table.updateShow();
				break;
			case SaleBackSheet:
				String[] temp4={"商品","型号","数量"};
				items=temp4;
				table.setColumnNames(items);
				table.setList(new String[1][3]);
				table.updateShow();
				break;
			case ReceiptBill:
				String[] temp5={"银行账户","转账金额","备注"};
				items=temp5;
				table.setColumnNames(items);
				table.setList(new String[1][3]);
				table.updateShow();
				break;
			case PaymentBill:
				String[] temp6={"银行账户","转账金额","备注"};
				items=temp6;
				table.setColumnNames(items);
				table.setList(new String[1][3]);
				table.updateShow();
				break;
			case PurSheet:
				String[] temp7={"商品","型号","数量"};
				items=temp7;
				table.setColumnNames(items);
				table.setList(new String[1][3]);
				table.updateShow();
				break;
			case CashPaymentBill:
				String[] temp8={"条目名","金额","备注"};
				items=temp8;
				table.setColumnNames(items);
				table.setList(new String[1][3]);
				table.updateShow();
				break;
			}
			
		}
		public JPBillList getBillsList(){
			return billList;
		}
		public class MouseListenerOfButton implements MouseListener{

			private int num;
			public MouseListenerOfButton(int N){
				num=N;
			}
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			//点击功能按键
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
					done.setIcon(checkIconR);
					billList.doneChosen();//处理选中的
					break;
				case 4:
					delete.setIcon(deleteIconR);
					billList.removeChosen();//删除选中的
					break;
				case 5:
					edit.setIcon(editIconR);
					if(billList.getChosenNum()==1){
						if(billList.stateOfChosen()==BillState.DRAFT){
							switch(style){
								case CashPaymentBill:
									JPeditOfCash.setIsAdd(false);//不是加单据是修改单据
									JPeditOfCash.leftMove();//调出编辑板
									break;
								case PaymentBill:
									JPeditOfPay.setIsAdd(false);//不是加单据是修改单据
									JPeditOfPay.leftMove();//调出编辑板
									break;
								case ReceiptBill:
									JPeditOfRec.setIsAdd(false);//不是加单据是修改单据
									JPeditOfRec.leftMove();//调出编辑板
									break;
							}
						
						}
						else{
							frame.getWarning().showWarning("只能修改草稿状态的单据");
						}
						
					}
					else if(billList.getChosenNum()==0){
						frame.getWarning().showWarning("请选择要修改的单据");
					}
					else{
						frame.getWarning().showWarning("只能修改一张单据");
					}
					break;
				case 6:
					submit.setIcon(submitIconR);
					billList.submitChosen();//上交选中的
					break;
				case 7:
					add.setIcon(addIconR);
					switch(style){
					case CashPaymentBill:
						JPeditOfCash.setIsAdd(true);//不是加单据是修改单据
						JPeditOfCash.leftMove();//调出编辑板
						break;
					case PaymentBill:
						JPeditOfPay.setIsAdd(true);//不是加单据是修改单据
						JPeditOfPay.leftMove();//调出编辑板
						break;
					case ReceiptBill:
						JPeditOfRec.setIsAdd(true);//不是加单据是修改单据
						JPeditOfRec.leftMove();//调出编辑板
						break;
					}
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
					done.setIcon(checkIconW);
					break;
				case 4:
					delete.setIcon(deleteIconW);
					break;
				case 5:
					edit.setIcon(editIconW);
					break;				
				case 6:
					submit.setIcon(submitIconW);
					break;
				case 7:
					add.setIcon(addIconW);
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
					done.setIcon(checkIconW);
					break;
				case 4:
					delete.setIcon(deleteIconW);
					break;
				case 5:
					edit.setIcon(editIconW);
					break;		
				case 6:
					submit.setIcon(submitIconW);
					break;
				case 7:
					add.setIcon(addIconW);
					break;
				}
			}
			
		}
		/*编辑栏面板*/
		public class JPanelEdit extends JPanel{
			//辨别单据类型
			private BillStyle billStyle;
			//判断是加单据还是编辑单据
			private boolean isAdd=true;//默认是加单据
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
			private JLabel account=new JLabel("账户");
			private JLabel list=new JLabel("条目");
			private JLabel total=new JLabel("总额");
			private JLabel addList=new JLabel();//增加条目按钮
			private JTextField accountText=new JTextField(10);
			private JTextField totalText=new JTextField(10);
			private JPaddList ListEdit=new JPaddList(BillStyle.CashPaymentBill);//隐藏的条目编辑面板
			//付款收款单
			private JLabel customer=new JLabel("客户");
			private JLabel tranList=new JLabel("转账列表");
			private JLabel tranTotal=new JLabel("总额");
			private JComboBox customerCombo;
			private JTextField tranTotalText=new JTextField(10);
			private JPaddList tranListEdit=new JPaddList(BillStyle.PaymentBill);//隐藏的条目编辑面板
			//逻辑层接口
			private SaleBillBlService sbl=new salebillController();
			private FinancialBlService fbl=new Financial();
			public void reHome(){
				this.RightMove();
				accountText.setText("");
				totalText.setText("");
				tranTotalText.setText("");
				
				tranListEdit.reHome();
				tranListEdit.setVisible(false);
				ListEdit.reHome();
				ListEdit.setVisible(false);
				
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
				case ReceiptBill:
					//设置标签字体
					customer.setFont(new Font("宋体",Font.BOLD,14));
					tranList.setFont(new Font("宋体",Font.BOLD,14));
					tranTotal.setFont(new Font("宋体",Font.BOLD,14));
					//设置字体颜色
					customer.setForeground(Color.white);
					tranList.setForeground(Color.white);
					tranTotal.setForeground(Color.white);
					//设置标签大小位置
					customer.setBounds(40, 30, 40, 20);
					tranList.setBounds(40, 60, 60, 20);
					tranTotal.setBounds(40, 90, 40, 20);
					//客户选择下拉框
					ArrayList<CustomerVO> customers = null;
					customers = customerbl.getAllCustomer("Customer.txt");
					String[] customerS=new String[customers.size()];
					for(int i=0;i<customers.size();i++){
						customerS[i]=customers.get(i).getname()+":"+customers.get(i).getid();
					}
					customerCombo = new JComboBox(customerS);
					customerCombo.setFont(new Font("宋体",Font.BOLD,14));
					customerCombo.setBounds(80,28, 150, 20);
					customerCombo.setBackground(Color.gray);
					customerCombo.setForeground(Color.white);
					//总额文本框
					tranTotalText.setBounds(80,90, 150, 20);
					tranTotalText.setOpaque(false);//文本框透明
					tranTotalText.setForeground(Color.white);//前景色
					tranTotalText.setCaretColor(Color.white);
					//增加条目按钮
					addList.setIcon(add0);
					addList.setBounds(100, 58, 24, 24);
					addList.addMouseListener(new MouseListenerOfButton(2));
					//隐藏的条目编辑面板
					tranListEdit.setLocation(59, 56);
					tranListEdit.setVisible(false);
					
					this.add(tranListEdit,0);
					this.add(customer,1);
					this.add(tranList,2);
					this.add(tranTotal,3);
					this.add(right,4);
					this.add(customerCombo,5);
					this.add(tranTotalText,6);
					this.add(addList,7);
					this.add(confirm,8);
					this.add(back,9);
					break;
				case PaymentBill:
					//设置标签字体
					customer.setFont(new Font("宋体",Font.BOLD,14));
					tranList.setFont(new Font("宋体",Font.BOLD,14));
					tranTotal.setFont(new Font("宋体",Font.BOLD,14));
					//设置字体颜色
					customer.setForeground(Color.white);
					tranList.setForeground(Color.white);
					tranTotal.setForeground(Color.white);
					//设置标签大小位置
					customer.setBounds(40, 30, 40, 20);
					tranList.setBounds(40, 60, 60, 20);
					tranTotal.setBounds(40, 90, 40, 20);
					//客户选择下拉框
					ArrayList<CustomerVO> customers1 = null;
					customers1 = customerbl.getAllCustomer("Customer.txt");
					String[] customerS1=new String[customers1.size()];
					for(int i=0;i<customers1.size();i++){
						customerS1[i]=customers1.get(i).getname()+":"+customers1.get(i).getid();
					}
					customerCombo = new JComboBox(customerS1);
					customerCombo.setFont(new Font("宋体",Font.BOLD,14));
					customerCombo.setBounds(80,28, 150, 20);
					customerCombo.setBackground(Color.gray);
					customerCombo.setForeground(Color.white);
					//总额文本框
					tranTotalText.setBounds(80,90, 150, 20);
					tranTotalText.setOpaque(false);//文本框透明
					tranTotalText.setForeground(Color.white);//前景色
					tranTotalText.setCaretColor(Color.white);
					//增加条目按钮
					addList.setIcon(add0);
					addList.setBounds(100, 58, 24, 24);
					addList.addMouseListener(new MouseListenerOfButton(2));
					//隐藏的条目编辑面板
					tranListEdit.setLocation(59, 56);
					tranListEdit.setVisible(false);
					
					this.add(tranListEdit,0);
					this.add(customer,1);
					this.add(tranList,2);
					this.add(tranTotal,3);
					this.add(right,4);
					this.add(customerCombo,5);
					this.add(tranTotalText,6);
					this.add(addList,7);
					this.add(confirm,8);
					this.add(back,9);
					break;
				case CashPaymentBill:
					//设置标签字体
					account.setFont(new Font("宋体",Font.BOLD,14));
					list.setFont(new Font("宋体",Font.BOLD,14));
					total.setFont(new Font("宋体",Font.BOLD,14));
					//设置字体颜色
					account.setForeground(Color.white);
					list.setForeground(Color.white);
					total.setForeground(Color.white);
					//设置标签大小位置
					account.setBounds(40, 30, 40, 20);
					list.setBounds(40, 60, 40, 20);
					total.setBounds(40, 90, 40, 20);
					//文本框
					accountText.setBounds(80,28, 150, 20);
					accountText.setOpaque(false);//文本框透明
					accountText.setForeground(Color.white);//前景色
					accountText.setCaretColor(Color.white);
					
					totalText.setBounds(80,90, 150, 20);
					totalText.setOpaque(false);//文本框透明
					totalText.setForeground(Color.white);//前景色
					tranTotalText.setCaretColor(Color.white);
					//增加条目按钮
					addList.setIcon(add0);
					addList.setBounds(80, 58, 24, 24);
					addList.addMouseListener(new MouseListenerOfButton(2));
					//隐藏的条目编辑面板
					ListEdit.setLocation(59, 56);
					ListEdit.setVisible(false);
					
					this.add(ListEdit,0);
					this.add(account,1);
					this.add(list,2);
					this.add(total,3);
					this.add(right,4);
					this.add(accountText,5);
					this.add(totalText,6);
					this.add(addList,7);
					this.add(confirm,8);
					this.add(back,9);
					break;
				}
			}
			/*返回收款付款单编辑栏的客户选择下拉框*/
			public JComboBox getCustomerCombo(){
				return customerCombo;
			}
			public void leftMove(){
				if(style==BillStyle.PaymentBill||style==BillStyle.ReceiptBill){
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
			public boolean getIsAdd() {
				return isAdd;
			}
			public void setIsAdd(boolean isAdd) {
				this.isAdd = isAdd;
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
						//显示编辑条目面板
						switch(billStyle){
						case ReceiptBill:
						case PaymentBill:
							//初始化账户下拉框
							tranListEdit.getAccount().removeAllItems();
							for(int i=0;i<fbl.getAllAccountInfo().size();i++){
								tranListEdit.getAccount().addItem(fbl.getAllAccountInfo().get(i).getName());
							}
							//显示
							tranListEdit.setVisible(true);
							tranListEdit.getNoteTxt().setText("无");
							break;
						case CashPaymentBill:
							ListEdit.setVisible(true);
							ListEdit.getNoteTxt().setText("无");
						}
						
						break;
					case 3:
						confirm.setIcon(confirm1);
						//判断是加单据还是修改单据
						if(isAdd){//如果是加单据
							switch(billStyle){
							case ReceiptBill:
								if(customerCombo.getSelectedItem()==null){
									frame.getWarning().showWarning("没有客户，不能创建单据");
								}
								else{
									boolean legal=false;
									boolean customerIsEmpty=customerCombo.getSelectedItem().toString().equals("");
									boolean totalIsEmpty=tranTotalText.getText().equals("");
									boolean listIsEmpty=tranListEdit.getListArray().isEmpty();
									
									if(!customerIsEmpty&&!totalIsEmpty&&!listIsEmpty){
										legal=true;
										if(stringJg.judgestring(tranTotalText.getText())!=3){
											legal=false;
											frame.getWarning().showWarning("总额必须为数字");
										}
				
									}
									else{
										frame.getWarning().showWarning("单据信息不完整，请检查是否填写了转账列表");
									}
									if(legal){
										//生成新的单据加入到billList
										frame.getWarning().showWarning("生成了一张收款单");
										ReceiptVO newRec=new ReceiptVO();
										//传入单据数据
										newRec.setCustomer(customerCombo.getSelectedItem().toString());
										newRec.setTotal(Double.parseDouble(tranTotalText.getText()));
										newRec.setAccounts(tranListEdit.getListArray());
										newRec.setMoney(tranListEdit.getMoneyArray());
										newRec.setRemark(tranListEdit.getNoteArray());
										newRec.setOp(Login.user.getName()+":"+Login.user.getID());
										//将设置好数据的单据VO加到billList
										billList.addReceiptBill(newRec);
										//清空信息
										tranTotalText.setText("");
										tranListEdit.getListArray().clear();//清空三个数组
										tranListEdit.getMoneyArray().clear();
										tranListEdit.getNoteArray().clear();
									}
								
								}
								break;
							case PaymentBill:
								if(customerCombo.getSelectedItem()==null){
									frame.getWarning().showWarning("没有客户，不能创建单据");
								}
								else{
									boolean legal2=false;
									boolean customerIsEmpty2=customerCombo.getSelectedItem().toString().equals("");
									boolean totalIsEmpty2=tranTotalText.getText().equals("");
									boolean listIsEmpty2=tranListEdit.getListArray().isEmpty();
									
									if(!customerIsEmpty2&&!totalIsEmpty2&&!listIsEmpty2){
										legal2=true;
										if(stringJg.judgestring(tranTotalText.getText())!=3){
											legal2=false;
											frame.getWarning().showWarning("总额必须为数字");
										}
									}
									else{
										frame.getWarning().showWarning("单据信息不完整，请检查是否填写了转账列表");
									}
									if(legal2){
										//生成新的单据加入到billList
										frame.getWarning().showWarning("生成了一张付款单");
										PaymentVO newPay=new PaymentVO();
										//传入单据数据
										newPay.setCustomer(customerCombo.getSelectedItem().toString());
										newPay.setTotal(Double.parseDouble(tranTotalText.getText()));
										newPay.setAccounts(tranListEdit.getListArray());
										newPay.setMoney(tranListEdit.getMoneyArray());
										newPay.setRemark(tranListEdit.getNoteArray());
										newPay.setOp(Login.user.getName()+":"+Login.user.getID());
										//将设置好数据的单据VO加到billList
										billList.addPaymentBill(newPay);
										//清空信息
										tranTotalText.setText("");
										tranListEdit.getListArray().clear();//清空三个数组
										tranListEdit.getMoneyArray().clear();
										tranListEdit.getNoteArray().clear();
									}
									
								}
								break;
							case CashPaymentBill:
								boolean legal3=false;
								boolean accountIsEmpty=accountText.getText().equals("");
								boolean totalIsEmpty3=totalText.getText().equals("");
								boolean listIsEmpty3=ListEdit.getListArray().isEmpty();
								
								if(!accountIsEmpty&&!totalIsEmpty3&&!listIsEmpty3){
									legal3=true;
									if(stringJg.judgestring(totalText.getText())!=3){
										legal3=false;
										frame.getWarning().showWarning("总额必须为数字");
									}
								}
								else{
									frame.getWarning().showWarning("单据信息不完整，请检查是否填写了转账列表");
								}
								if(legal3){
									//生成新的单据加入到billList
									//设置单据数据
									frame.getWarning().showWarning("生成了一张现金费用单");
									CashPaymentVO newCash=new CashPaymentVO();
									
									frame.getWarning().showWarning("银行账户是："+accountText.getText());
									newCash.setAccount(accountText.getText());
									
									for(int i=0;i<ListEdit.getListArray().size();i++){
										frame.getWarning().showWarning("条目名"+(i+1)+":"+ListEdit.getListArray().get(i));
										newCash.getItem().add(ListEdit.getListArray().get(i));
										
										frame.getWarning().showWarning("金额"+(i+1)+":"+ListEdit.getMoneyArray().get(i));
										newCash.getMoney().add(ListEdit.getMoneyArray().get(i));
										
										frame.getWarning().showWarning("备注"+(i+1)+":"+ListEdit.getNoteArray().get(i));
										newCash.getRemark().add(ListEdit.getNoteArray().get(i));
									}
									frame.getWarning().showWarning("总额是："+totalText.getText());
									newCash.setTotal(Double.parseDouble(totalText.getText()));
									
									//操作员
									newCash.setOp(Login.user.getName()+":"+Login.user.getID());
									//将设置好数据的单据VO加到billList
									billList.addCashPaymentBill(newCash);
									//清空信息
									accountText.setText("");
									totalText.setText("");
									ListEdit.getListArray().clear();//清空三个数组
									ListEdit.getMoneyArray().clear();
									ListEdit.getNoteArray().clear();
								}
								
								break;
							}
						}
						else{//是修改单据
							switch(billStyle){
							case ReceiptBill:
								if(customerCombo.getSelectedItem()==null){
									frame.getWarning().showWarning("没有客户，不能修改单据");
								}
								else{
									boolean legal=false;
									boolean customerIsEmpty=customerCombo.getSelectedItem().toString().equals("");
									boolean totalIsEmpty=tranTotalText.getText().equals("");
									boolean listIsEmpty=tranListEdit.getListArray().isEmpty();
									ReceiptVO newRec=billList.getChosen().getReceiptVO();
									
									if(!customerIsEmpty||!totalIsEmpty||!listIsEmpty){
										legal=true;
										if(!totalIsEmpty){
											if(stringJg.judgestring(tranTotalText.getText())!=3){
												legal=false;
												frame.getWarning().showWarning("总额必须为数字");
											}
										}
				
									}
									else{
										frame.getWarning().showWarning("请输入修改数据");
									}
									if(legal){
										if(!listIsEmpty){
											newRec.setAccounts(tranListEdit.getListArray());
											newRec.setMoney(tranListEdit.getMoneyArray());
											newRec.setRemark(tranListEdit.getNoteArray());
										}
										if(!customerIsEmpty){
											//传入单据数据
											newRec.setCustomer(customerCombo.getSelectedItem().toString());
										}
										if(!totalIsEmpty){
											newRec.setTotal(Double.parseDouble(tranTotalText.getText()));
										}
										newRec.setOp(Login.user.getName()+":"+Login.user.getID());//修改操作员
										//修改billList中被选中的单据
										billList.changeChosen(newRec);
										//清空信息
										tranTotalText.setText("");
										tranListEdit.getListArray().clear();//清空三个数组
										tranListEdit.getMoneyArray().clear();
										tranListEdit.getNoteArray().clear();
									}
								
								}
								break;
							case PaymentBill:
								if(customerCombo.getSelectedItem()==null){
									frame.getWarning().showWarning("没有客户，不能创建单据");
								}
								else{
									boolean legal2=false;
									boolean customerIsEmpty2=customerCombo.getSelectedItem().toString().equals("");
									boolean totalIsEmpty2=tranTotalText.getText().equals("");
									boolean listIsEmpty2=tranListEdit.getListArray().isEmpty();
									
									if(!customerIsEmpty2||!totalIsEmpty2||!listIsEmpty2){
										legal2=true;
										if(!totalIsEmpty2){
											if(stringJg.judgestring(tranTotalText.getText())!=3){
												legal2=false;
												frame.getWarning().showWarning("总额必须为数字");
											}
										}
									}
									else{
										frame.getWarning().showWarning("请输入修改数据");
									}
									if(legal2){
										//生成新的单据加入到billList
										PaymentVO newPay=billList.getChosen().getPayVO();
										//传入单据数据
										if(!customerIsEmpty2){
											newPay.setCustomer(customerCombo.getSelectedItem().toString());
										}
										if(!totalIsEmpty2){
											newPay.setTotal(Double.parseDouble(tranTotalText.getText()));
										}
										if(!listIsEmpty2){
											newPay.setAccounts(tranListEdit.getListArray());
											newPay.setMoney(tranListEdit.getMoneyArray());
											newPay.setRemark(tranListEdit.getNoteArray());
										}
										newPay.setOp(Login.user.getName()+":"+Login.user.getID());//修改操作员
										//修改billList中被选中的单据
										billList.changeChosen(newPay);
										//清空信息
										tranTotalText.setText("");
										tranListEdit.getListArray().clear();//清空三个数组
										tranListEdit.getMoneyArray().clear();
										tranListEdit.getNoteArray().clear();
									}
								
								}
								break;
							case CashPaymentBill:
								boolean legal3=false;
								boolean accountIsEmpty=accountText.getText().equals("");
								boolean totalIsEmpty3=totalText.getText().equals("");
								boolean listIsEmpty3=ListEdit.getListArray().isEmpty();
								
								if(!accountIsEmpty||!totalIsEmpty3||!listIsEmpty3){
									legal3=true;
									if(!totalIsEmpty3){
										if(stringJg.judgestring(totalText.getText())!=3){
											legal3=false;
											frame.getWarning().showWarning("总额必须为数字");
										}
									}
								}
								else{
									frame.getWarning().showWarning("请输入修改数据");
								}
								if(legal3){
									//生成新的单据加入到billList
									//设置单据数据
									CashPaymentVO newCash=billList.getChosen().getCashVO();
									
									if(!accountIsEmpty){
										newCash.setAccount(accountText.getText());
									}
									if(!totalIsEmpty3){
										newCash.setTotal(Double.parseDouble(totalText.getText()));
									}
									if(!listIsEmpty3){
										for(int i=0;i<ListEdit.getListArray().size();i++){
											newCash.getItem().add(ListEdit.getListArray().get(i));
											
											newCash.getMoney().add(ListEdit.getMoneyArray().get(i));
											
											newCash.getRemark().add(ListEdit.getNoteArray().get(i));
										}
									}
									
									newCash.setOp(Login.user.getName()+":"+Login.user.getID());//修改操作员
									//修改billList中被选中的单据
									billList.changeChosen(newCash);
									frame.getWarning().showWarning("修改cash");
									//清空信息
									accountText.setText("");
									totalText.setText("");
									ListEdit.getListArray().clear();//清空三个数组
									ListEdit.getMoneyArray().clear();
									ListEdit.getNoteArray().clear();
								}
								
								break;
							}
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
			public class JPaddList extends JPanel{
				//背景
				private JLabel bg=new JLabel();
				//确认按钮
				private JLabel confirm=new JLabel();
				//文本框（现金费用单）
				private JTextField listTxt=new JTextField(10);
				private JTextField moneyTxt=new JTextField(10);
				private JTextField noteTxt=new JTextField(10);
				//账户下拉框
				private JComboBox account;
				//图片
				private ImageIcon confirmW=new ImageIcon("src/image/function/confirmW.png");
				private ImageIcon confirmR=new ImageIcon("src/image/function/confirmR.png");
				//储存信息的数组
				private ArrayList<String> listArray=new ArrayList<String>();
				private ArrayList<Double> moneyArray=new ArrayList<Double>();
				private ArrayList<String> noteArray=new ArrayList<String>();
				
				public void reHome(){
					listTxt.setText("");
					moneyTxt.setText("");
					noteTxt.setText("");
					listArray.clear();
					moneyArray.clear();
					noteArray.clear();
				}
				/*条目编辑面板*/
				public JPaddList(BillStyle style){
					//面板大小
					this.setSize(181,157);
					//设置布局
					this.setLayout(null);
					//设置面板透明
					this.setOpaque(false);
					//监控
					this.addMouseListener(new MouseListenerGetXY());
					//背景
					this.bg.setIcon(new ImageIcon("src/image/function/editList.png"));
					this.bg.setBounds(0, 0, 181,157);
					//确认按钮
					this.confirm.setIcon(confirmW);
					this.confirm.setBounds(78, 123, 24,24);
					this.confirm.addMouseListener(new MouseListenerOfButton());
					//根据单据种类加上不同的附件
					
					switch(style){
					case ReceiptBill:
					case PaymentBill:
						//现金费用单的附件
						JLabel tranListName=new JLabel("账户");
						JLabel tranMoney=new JLabel("金额");
						JLabel tranNote=new JLabel("备注");
						//设置标签字体
						tranListName.setFont(new Font("宋体",Font.BOLD,14));
						tranMoney.setFont(new Font("宋体",Font.BOLD,14));
						tranNote.setFont(new Font("宋体",Font.BOLD,14));
						//设置字体颜色
						tranListName.setForeground(Color.white);
						tranMoney.setForeground(Color.white);
						tranNote.setForeground(Color.white);
						//设置标签大小位置
						tranListName.setBounds(25, 30, 40, 20);
						tranMoney.setBounds(25, 60, 40, 20);
						tranNote.setBounds(25, 90, 40, 20);
						
						account = new JComboBox();
						account.setFont(new Font("宋体",Font.BOLD,14));
						account.setBounds(70,30, 100, 20);
						account.setBackground(Color.gray);
						account.setForeground(Color.white);
						//文本框
						moneyTxt.setBounds(70,60, 100, 20);
						moneyTxt.setOpaque(false);//文本框透明
						moneyTxt.setForeground(Color.white);//前景色
						moneyTxt.setCaretColor(Color.white);
						noteTxt.setBounds(70,90, 100, 20);
						noteTxt.setOpaque(false);//文本框透明
						noteTxt.setForeground(Color.white);//前景色
						noteTxt.setCaretColor(Color.white);
						
						this.add(tranListName,0);
						this.add(tranMoney,1);
						this.add(tranNote,2);
						this.add(account,3);
						this.add(moneyTxt,4);
						this.add(noteTxt,5);
						this.add(confirm,6);
						this.add(bg,7);
						break;
					case CashPaymentBill:
						//现金费用单的附件
						JLabel listName=new JLabel("条目");
						JLabel money=new JLabel("金额");
						JLabel note=new JLabel("备注");
						//设置标签字体
						listName.setFont(new Font("宋体",Font.BOLD,14));
						money.setFont(new Font("宋体",Font.BOLD,14));
						note.setFont(new Font("宋体",Font.BOLD,14));
						//设置字体颜色
						listName.setForeground(Color.white);
						money.setForeground(Color.white);
						note.setForeground(Color.white);
						//设置标签大小位置
						listName.setBounds(25, 30, 40, 20);
						money.setBounds(25, 60, 40, 20);
						note.setBounds(25, 90, 40, 20);
						//文本框
						listTxt.setBounds(70,30, 100, 20);
						listTxt.setOpaque(false);//文本框透明
						listTxt.setForeground(Color.white);//前景色
						listTxt.setCaretColor(Color.white);
						moneyTxt.setBounds(70,60, 100, 20);
						moneyTxt.setOpaque(false);//文本框透明
						moneyTxt.setForeground(Color.white);//前景色
						moneyTxt.setCaretColor(Color.white);
						noteTxt.setBounds(70,90, 100, 20);
						noteTxt.setOpaque(false);//文本框透明
						noteTxt.setForeground(Color.white);//前景色
						noteTxt.setCaretColor(Color.white);
						
						this.add(listName,0);
						this.add(money,1);
						this.add(note,2);
						this.add(listTxt,3);
						this.add(moneyTxt,4);
						this.add(noteTxt,5);
						this.add(confirm,6);
						this.add(bg,7);
						break;
					}
					
					
				}
				public JComboBox getAccount()
				{
					return account;
				}
				public void setAccount(JComboBox account)
				{
					this.account = account;
				}
				public JTextField getNoteTxt()
				{
					return noteTxt;
				}
				public void setNoteTxt(JTextField noteTxt)
				{
					this.noteTxt = noteTxt;
				}
				//返回信息数组
				public ArrayList<String> getListArray(){
					return listArray;
				}
				//返回信息数组
				public ArrayList<Double> getMoneyArray(){
					return moneyArray;
				}
				//返回信息数组
				public ArrayList<String> getNoteArray(){
					return noteArray;
				}
				public class MouseListenerOfButton implements MouseListener{

					
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						//图片变化
						JPaddList.this.confirm.setIcon(confirmR);
					
					}

					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						JPaddList.this.confirm.setIcon(confirmW);
						//功能
						String list="";
						switch(billStyle){
							case ReceiptBill:
							case PaymentBill:
								list=account.getSelectedItem().toString();
								break;
							case CashPaymentBill:
								list=listTxt.getText();
								break;
						}
						String money=moneyTxt.getText();
						String note=noteTxt.getText();
						boolean legal=false;
						//填写完整
						if(!list.equals("")&&!money.equals("")&&!note.equals("")){
							legal=true;
							if(stringJg.judgestring(money)!=3){
								legal=false;
								frame.getWarning().showWarning("金额必须为数字");
							}
						}
						//一个都不填默认用户取消编辑
						else if(money.equals("")&&note.equals("")){
							switch(billStyle){
								case ReceiptBill:
								case PaymentBill:
									//隐藏板块
									JPaddList.this.setVisible(false);
									break;
								case CashPaymentBill:
									if(list.equals("")){
										//隐藏板块
										JPaddList.this.setVisible(false);
									}
									break;
							}
						}
						//填入部分信息默认用户没有填写完整
						else{
							frame.getWarning().showWarning("请输入完整信息");
						}
						if(legal){
							//合法则将信息加入到数组
							double mon=Double.parseDouble(money);
							listArray.add(list);
							moneyArray.add(mon);
							noteArray.add(note);
							//清空文本框
							listTxt.setText("");
							moneyTxt.setText("");
							noteTxt.setText("");
							//计算总额
							double totalMoney=0;
							for(int i=0;i<moneyArray.size();i++){
								totalMoney+=moneyArray.get(i);
							}
							switch(billStyle){
							case ReceiptBill:
							case PaymentBill:
								tranTotalText.setText(String.valueOf(totalMoney));
								break;
							case CashPaymentBill:
								totalText.setText(String.valueOf(totalMoney));
								break;
							}
							//合法操作才隐藏板块
							JPaddList.this.setVisible(false);
						}
					
						
						
					}

					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						JPaddList.this.confirm.setIcon(confirmW);
					}
					
				}
			}

		}
		public JPBillList getBillList() {
			return billList;
		}
		public void setBillList(JPBillList billList) {
			this.billList = billList;
		}
		
}
