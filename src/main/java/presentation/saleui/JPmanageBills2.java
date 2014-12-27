package presentation.saleui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entrance.Frame;
import po.BillState;
import po.BillStyle;
import presentation.managerui.JPBillList;
import presentation.managerui.JTableOfList;
import presentation.managerui.MouseListenerGetXY;
import vo.CustomerVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.stockvo.CommodityVO;
import businesslogic.customerbl.CustomerList;
import businesslogic.salebillbl.salebillController;
import businesslogicservice.customerblservice.CustomerBlService;
import businesslogicservice.salebillblservice.SaleBillBlService;

public class JPmanageBills2 extends JPanel {
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
		//清单表格
		private JTableOfList table=new JTableOfList();
		//编辑面板
		private JPanelEdit JPeditOfPur;
		//编辑面板
		private JPanelEdit JPeditOfPurBack;
		//编辑面板
		private JPanelEdit JPeditOfSale;
		//编辑面板
		private JPanelEdit JPeditOfSaleBack;
		//单据类型
		private BillStyle style;
		public BillStyle getStyle() {
			return style;
		}
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
	    //调用逻辑层
	    CustomerBlService customerbl=new CustomerList();
	    SaleBillBlService sbl=new salebillController();
		public JPmanageBills2(){
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
			edit.setBounds(720, 215, 50, 50);
			edit.addMouseListener(new MouseListenerOfButton(5));
			//提交功能按钮
			submit.setIcon(submitIconW);
			submit.setBounds(720,150 , 50, 50);
			submit.addMouseListener(new MouseListenerOfButton(6));
			//创建功能按钮
			add.setIcon(addIconW);
			add.setBounds(720, 280, 50, 50);
			add.addMouseListener(new MouseListenerOfButton(7));
			//编辑面板
			JPeditOfPur=new JPanelEdit(BillStyle.PurSheet);
			JPeditOfPur.setLocation(905, 36);
			JPeditOfPurBack=new JPanelEdit(BillStyle.PurBackSheet);
			JPeditOfPurBack.setLocation(905, 36);
			JPeditOfSale=new JPanelEdit(BillStyle.SaleSheet);
			JPeditOfSale.setLocation(905, 36);
			JPeditOfSaleBack=new JPanelEdit(BillStyle.SaleBackSheet);
			JPeditOfSaleBack.setLocation(905, 36);
			
			this.add(jp,0);
			this.add(up,1);
			this.add(down,2);
			this.add(JPeditOfPur,3);
			this.add(JPeditOfPurBack,4);
			this.add(JPeditOfSale,5);
			this.add(JPeditOfSaleBack,6);
			this.add(done,7);
			this.add(delete,8);
			this.add(edit,9);
			this.add(submit,10);
			this.add(add,11);
			this.add(table,12);
			this.add(bg,13);
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
				table.setVisible(true);
				break;
			case SpillsLossBill:
				table.setVisible(false);
				break;
			case AlertBill:
				table.setVisible(false);
				edit.setVisible(false);
				add.setVisible(false);
				break;
			case PurBackSheet:
				String[] temp2={"编号","名称","型号","数量","单价","金额","备注"};
				items=temp2;
				table.setColumnNames(items);
				table.setList(new String[1][7]);
				table.updateShow();
				table.setVisible(true);
				edit.setVisible(true);
				add.setVisible(true);
				break;
			case SaleSheet:
				String[] temp3={"编号","名称","型号","数量","单价","金额","备注"};
				items=temp3;
				table.setColumnNames(items);
				table.setList(new String[1][7]);
				table.updateShow();
				table.setVisible(true);
				edit.setVisible(true);
				add.setVisible(true);
				break;
			case SaleBackSheet:
				String[] temp4={"编号","名称","型号","数量","单价","金额","备注"};
				items=temp4;
				table.setColumnNames(items);
				table.setList(new String[1][7]);
				table.updateShow();
				table.setVisible(true);
				edit.setVisible(true);
				add.setVisible(true);
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
				edit.setVisible(true);
				add.setVisible(true);
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
					break;
				case 4:
					delete.setIcon(deleteIconR);
					billList.removeChosen();
					break;
				case 5:
					edit.setIcon(editIconR);
					if(billList.getChosenNum()==1&&billList.stateOfChosen()==BillState.DRAFT){
						switch(style){
						case PurSheet:
							JPeditOfPur.setAdd(false);//不是加单据是修改单据
							JPeditOfPur.leftMove();//调出编辑板
							break;
						case PurBackSheet:
							JPeditOfPurBack.setAdd(false);//不是加单据是修改单据
							JPeditOfPurBack.leftMove();//调出编辑板
							break;
						case SaleSheet:
							JPeditOfSale.setAdd(false);//不是加单据是修改单据
							JPeditOfSale.leftMove();//调出编辑板
							break;
						case SaleBackSheet:
							JPeditOfSaleBack.setAdd(false);//不是加单据是修改单据
							JPeditOfSaleBack.leftMove();//调出编辑板
							break;
						}
					}
					break;
				case 6:
					submit.setIcon(submitIconR);
					break;
				case 7:
					add.setIcon(addIconR);
					switch(style){
					case PurSheet:
						JPeditOfPur.setAdd(true);//不是加单据是修改单据
						JPeditOfPur.leftMove();//调出编辑板
						break;
					case PurBackSheet:
						JPeditOfPurBack.setAdd(true);//不是加单据是修改单据
						JPeditOfPurBack.leftMove();//调出编辑板
						break;
					case SaleSheet:
						JPeditOfSale.setAdd(true);//不是加单据是修改单据
						JPeditOfSale.leftMove();//调出编辑板
						break;
					case SaleBackSheet:
						JPeditOfSaleBack.setAdd(true);//不是加单据是修改单据
						JPeditOfSaleBack.leftMove();//调出编辑板
						break;
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
			//进货与退货单的附件
			private JLabel customer=new JLabel("客户");
			private JLabel warehouse=new JLabel("仓库");
			private JLabel list=new JLabel("商品清单");
			private JLabel total=new JLabel("总额");
			private JLabel note=new JLabel("备注");
			private JComboBox customerCombo;
			private JComboBox warehouseCombo;
			private JTextField customerTxt=new JTextField(10);
			private JTextField warehouseTxt=new JTextField(10);
			private JLabel addList=new JLabel();//增加商品
			private JTextField totalText=new JTextField(10);
			private JTextField noteText=new JTextField(10);
			//销售与退货单的附件
			private JLabel coupon=new JLabel("使用代金券");
			private JLabel discount=new JLabel("折让金额");
			private JLabel finalTotal=new JLabel("最终总额");
			private JTextField couponText=new JTextField(10);
			private JTextField discountText=new JTextField(10);
			private JTextField finalTotalText=new JTextField(10);
			//单据编号输入框
			private JLabel billID=new JLabel("编号");
			private JTextField billIDTxt=new JTextField(10);
			private JLabel find=new JLabel();
			//策略选择列表
			private JLabel strategy=new JLabel("优惠");
			private JComboBox strategyCombo;
			//判断是加单据还是改单据
			private boolean isAdd=false;
			//接收输出商品
			private ArrayList<CommodityVO> output;
			//接收输出的备注
			private ArrayList<String> outputNotes;
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
				//查找单据按钮
				find.setIcon(confirm0);
				find.addMouseListener(new MouseListenerOfButton(4));
				//根据单据种类加上不同的附件
				switch(style){
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
					//备注文本框
					noteText.setBounds(80,150, 150, 20);
					noteText.setOpaque(false);//文本框透明
					noteText.setForeground(Color.white);//前景色
					
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
				case PurBackSheet:
					//设置标签字体
					billID.setFont(new Font("宋体",Font.BOLD,14));
					customer.setFont(new Font("宋体",Font.BOLD,14));
					warehouse.setFont(new Font("宋体",Font.BOLD,14));
					total.setFont(new Font("宋体",Font.BOLD,14));
					note.setFont(new Font("宋体",Font.BOLD,14));
					//设置字体颜色
					billID.setForeground(Color.white);
					customer.setForeground(Color.white);
					warehouse.setForeground(Color.white);
					total.setForeground(Color.white);
					note.setForeground(Color.white);
					//设置标签大小位置
					billID.setBounds(40, 30, 40, 20);
					customer.setBounds(40, 60, 40, 20);
					warehouse.setBounds(40, 90, 60, 20);
					total.setBounds(40, 120, 40, 20);
					note.setBounds(40, 150, 40, 20);
					find.setBounds(206, 28, 24, 24);
					//编号文本框
					billIDTxt.setBounds(80,30, 120, 20);
					billIDTxt.setOpaque(false);//文本框透明
					billIDTxt.setForeground(Color.white);//前景色
					//客户文本框
					customerTxt.setBounds(80,60, 150, 20);
					customerTxt.setEditable(false);
					customerTxt.setOpaque(false);//文本框透明
					customerTxt.setForeground(Color.white);//前景色
					//仓库文本框
					warehouseTxt.setBounds(80,90, 150, 20);
					warehouseTxt.setEditable(false);
					warehouseTxt.setOpaque(false);//文本框透明
					warehouseTxt.setForeground(Color.white);//前景色
				
					//总额文本框
					totalText.setBounds(80,120, 150, 20);
					totalText.setEditable(false);
					totalText.setOpaque(false);//文本框透明
					totalText.setForeground(Color.white);//前景色
					//备注文本框
					noteText.setBounds(80,150, 150, 20);
					noteText.setEditable(false);
					noteText.setOpaque(false);//文本框透明
					noteText.setForeground(Color.white);//前景色
					
					this.add(customer,0);
					this.add(warehouse,1);
					this.add(billID,2);
					this.add(total,3);
					this.add(note,4);
					this.add(right,5);
					this.add(customerTxt,6);
					this.add(warehouseTxt,7);
					this.add(billIDTxt,8);
					this.add(totalText,9);
					this.add(noteText,10);
					this.add(confirm,11);
					this.add(find,12);
					this.add(back,13);
					break;
				case SaleSheet:
					//设置标签字体
					customer.setFont(new Font("宋体",Font.BOLD,14));
					warehouse.setFont(new Font("宋体",Font.BOLD,14));
					list.setFont(new Font("宋体",Font.BOLD,14));
					strategy.setFont(new Font("宋体",Font.BOLD,14));
					total.setFont(new Font("宋体",Font.BOLD,14));
					note.setFont(new Font("宋体",Font.BOLD,14));
					coupon.setFont(new Font("宋体",Font.BOLD,14));
					discount.setFont(new Font("宋体",Font.BOLD,14));
					finalTotal.setFont(new Font("宋体",Font.BOLD,14));
					//设置字体颜色
					customer.setForeground(Color.white);
					warehouse.setForeground(Color.white);
					list.setForeground(Color.white);
					strategy.setForeground(Color.white);
					total.setForeground(Color.white);
					note.setForeground(Color.white);
					coupon.setForeground(Color.white);
					discount.setForeground(Color.white);
					finalTotal.setForeground(Color.white);
					//设置标签大小位置
					customer.setBounds(40,15, 40, 20);
					warehouse.setBounds(40,40, 40, 20);
					list.setBounds(40,65, 60, 20);
					strategy.setBounds(40,90, 60, 20);
					total.setBounds(40,115, 40, 20);
					coupon.setBounds(40,140, 75, 20);
					discount.setBounds(40,165, 60, 20);
					finalTotal.setBounds(40,190, 60, 20);
					note.setBounds(40,215, 40, 20);
					
					//客户选择下拉框
					ArrayList<CustomerVO> customers2 = null;
					customers2 = customerbl.getAllCustomer("Customer.txt");
					String[] customerS2=new String[customers2.size()];
					for(int i=0;i<customers2.size();i++){
						customerS2[i]=customers2.get(i).getname()+":"+customers2.get(i).getid();
					}
					customerCombo = new JComboBox(customerS2);
					customerCombo.setFont(new Font("宋体",Font.BOLD,14));
					customerCombo.setBounds(80,15, 150, 20);
					customerCombo.setBackground(Color.gray);
					customerCombo.setForeground(Color.white);
					//仓库选择下拉框
					String[] warehouseS2={"仓库1"};
					warehouseCombo = new JComboBox(warehouseS2);
					warehouseCombo.setFont(new Font("宋体",Font.BOLD,14));
					warehouseCombo.setBounds(80,40, 150, 20);
					warehouseCombo.setBackground(Color.gray);
					warehouseCombo.setForeground(Color.white);
					//增加条目按钮
					addList.setIcon(add0);
					addList.setBounds(105,63, 24, 24);
					addList.addMouseListener(new MouseListenerOfButton(2));
					//优惠策略选择下拉框
					strategyCombo = new JComboBox();
					strategyCombo.setFont(new Font("宋体",Font.BOLD,14));
					strategyCombo.setBounds(80,90, 150, 20);
					strategyCombo.setBackground(Color.gray);
					strategyCombo.setForeground(Color.white);
					//总额文本框
					totalText.setBounds(80,115, 150, 20);
					totalText.setOpaque(false);//文本框透明
					totalText.setForeground(Color.white);//前景色
					//使用代金券文本框
					couponText.setBounds(125,140, 105, 20);
					couponText.setOpaque(false);//文本框透明
					couponText.setForeground(Color.white);//前景色
					//折让文本框
					discountText.setBounds(110,165, 120, 20);
					discountText.setOpaque(false);//文本框透明
					discountText.setForeground(Color.white);//前景色
					//最终总额文本框
					finalTotalText.setBounds(110,190, 120, 20);
					finalTotalText.setOpaque(false);//文本框透明
					finalTotalText.setForeground(Color.white);//前景色
					//备注文本框
					noteText.setBounds(80,215, 150, 20);
					noteText.setOpaque(false);//文本框透明
					noteText.setForeground(Color.white);//前景色
					
					this.add(customer,0);
					this.add(warehouse,1);
					this.add(list,2);
					this.add(total,3);
					this.add(coupon,4);
					this.add(discount,5);
					this.add(finalTotal,6);
					this.add(note,7);
					this.add(right,8);
					this.add(customerCombo,9);
					this.add(warehouseCombo,10);
					this.add(addList,11);
					this.add(totalText,12);
					this.add(couponText,13);
					this.add(discountText,14);
					this.add(finalTotalText,15);
					this.add(noteText,16);
					this.add(confirm,17);
					this.add(strategy,18);
					this.add(strategyCombo,19);
					this.add(back,20);
					break;
				case SaleBackSheet:
					//设置标签字体
					billID.setFont(new Font("宋体",Font.BOLD,14));
					customer.setFont(new Font("宋体",Font.BOLD,14));
					warehouse.setFont(new Font("宋体",Font.BOLD,14));
					total.setFont(new Font("宋体",Font.BOLD,14));
					note.setFont(new Font("宋体",Font.BOLD,14));
					coupon.setFont(new Font("宋体",Font.BOLD,14));
					discount.setFont(new Font("宋体",Font.BOLD,14));
					finalTotal.setFont(new Font("宋体",Font.BOLD,14));
					//设置字体颜色
					billID.setForeground(Color.white);
					customer.setForeground(Color.white);
					warehouse.setForeground(Color.white);
					total.setForeground(Color.white);
					note.setForeground(Color.white);
					coupon.setForeground(Color.white);
					discount.setForeground(Color.white);
					finalTotal.setForeground(Color.white);
					//设置标签大小位置
					
					billID.setBounds(40, 20, 40, 20);
					customer.setBounds(40, 45, 40, 20);
					warehouse.setBounds(40, 70, 60, 20);
					total.setBounds(40, 95, 40, 20);
					coupon.setBounds(40,120, 75, 20);
					discount.setBounds(40,145, 60, 20);
					finalTotal.setBounds(40,170, 60, 20);
					note.setBounds(40, 195, 40, 20);
					find.setBounds(206, 18, 24, 24);
					
					//编号文本框
					billIDTxt.setBounds(80,20, 120, 20);
					billIDTxt.setOpaque(false);//文本框透明
					billIDTxt.setForeground(Color.white);//前景色
					//客户文本框
					customerTxt.setBounds(80,45, 150, 20);
					customerTxt.setEditable(false);
					customerTxt.setOpaque(false);//文本框透明
					customerTxt.setForeground(Color.white);//前景色
					//仓库文本框
					warehouseTxt.setBounds(80,70, 150, 20);
					warehouseTxt.setEditable(false);
					warehouseTxt.setOpaque(false);//文本框透明
					warehouseTxt.setForeground(Color.white);//前景色
					//总额文本框
					totalText.setBounds(80,95, 150, 20);
					totalText.setEditable(false);
					totalText.setOpaque(false);//文本框透明
					totalText.setForeground(Color.white);//前景色
					//使用代金券文本框
					couponText.setBounds(125,120, 105, 20);
					couponText.setEditable(false);
					couponText.setOpaque(false);//文本框透明
					couponText.setForeground(Color.white);//前景色
					//折让文本框
					discountText.setBounds(110,145, 120, 20);
					discountText.setEditable(false);
					discountText.setOpaque(false);//文本框透明
					discountText.setForeground(Color.white);//前景色
					//最终总额文本框
					finalTotalText.setBounds(110,170, 120, 20);
					finalTotalText.setEditable(false);
					finalTotalText.setOpaque(false);//文本框透明
					finalTotalText.setForeground(Color.white);//前景色
					//备注文本框
					noteText.setBounds(80,195, 150, 20);
					noteText.setEditable(false);
					noteText.setOpaque(false);//文本框透明
					noteText.setForeground(Color.white);//前景色
					
					this.add(customer,0);
					this.add(warehouse,1);
					this.add(billID,2);
					this.add(total,3);
					this.add(coupon,4);
					this.add(discount,5);
					this.add(finalTotal,6);
					this.add(note,7);
					this.add(right,8);
					this.add(customerTxt,9);
					this.add(warehouseTxt,10);
					this.add(billIDTxt,11);
					this.add(totalText,12);
					this.add(couponText,13);
					this.add(discountText,14);
					this.add(finalTotalText,15);
					this.add(noteText,16);
					this.add(confirm,17);
					this.add(find,18);
					this.add(back,19);
					break;
				}
			}
			/*返回收款付款单编辑栏的客户选择下拉框*/
			public JComboBox getCustomerCombo(){
				return customerCombo;
			}
		
			public class MouseListenerOfButton implements MouseListener{

				private int num;//1、右移 2、加号 3、确认4、查找
				
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
						
						break;
					case 3:
						confirm.setIcon(confirm1);
						break;
					case 4:
						find.setIcon(confirm1);
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
						//显示商品选择面板
						frame.getSale().getChoseComs().getContent().innitial();
						frame.getSale().getChoseComs().setVisible(true);
						break;
					case 3:
						confirm.setIcon(confirm0);
						if(isAdd){
							switch(style){
							case PurSheet:
								if(output!=null
								&&!totalText.getText().equals("")
								&&!noteText.getText().equals("")){
							
									PurSheetVO newPur=new PurSheetVO();
									String[] temp=customerCombo.getSelectedItem().toString().split(":");
									newPur.setCustomer(customerbl.findCustomer(temp[1]));
									if(customerbl.findCustomer(temp[1])==null){
										System.out.println("查找客户空指针");
									}
									else{
										System.out.println("新进货单客户是"+customerbl.findCustomer(temp[1]).getname());
									}
									newPur.setstock(warehouseCombo.getSelectedItem().toString());
									newPur.setsheet(output);
									newPur.setcommoditywords(outputNotes);
									newPur.setmoney1(Double.parseDouble(totalText.getText()));
									newPur.setwords(noteText.getText());
									
									billList.addPurSheet(newPur);
								}
								else{
									frame.getWarning().showWarning("请输入完整信息");
								}
								break;
							case PurBackSheet:
								if(output!=null
								&&!customerTxt.getText().equals("")
								&&!warehouseTxt.getText().equals("")
								&&!totalText.getText().equals("")
								&&!noteText.getText().equals("")){
							
									PurBackSheetVO newPurBack=new PurBackSheetVO();

									String[] temp=customerTxt.getText().split(":");
									newPurBack.setCustomer(customerbl.findCustomer(temp[1]));
									newPurBack.setstock(warehouseTxt.getText());
									newPurBack.setsheet(output);
									newPurBack.setcommoditywords(outputNotes);
									newPurBack.setmoney1(Double.parseDouble(totalText.getText()));
									newPurBack.setwords(noteText.getText());
									
									billList.addPurBackSheet(newPurBack);
								}
								else{
									frame.getWarning().showWarning("请填写对应进货单编号进行搜索");
								}
							break;
							case SaleSheet:
							case SaleBackSheet:
								break;
							}
						}
						else{//修改单据
							
						}
						
						break;
					case 4:
						find.setIcon(confirm0);
						switch(style){
						case PurBackSheet:
							if(!billID.getText().equals("")){
								PurSheetVO pursheet=sbl.findPurSheet(billIDTxt.getText());
								if(pursheet.getcustomer()==null){
									System.out.println("返回的进货单客户空指针");
								}
							
								customerTxt.setText(pursheet.getcustomer().getname()+":"+pursheet.getcustomer().getid());
								warehouseTxt.setText(pursheet.getstock());
								output=pursheet.getsheet();
								outputNotes=pursheet.getcommoditywords();
								totalText.setText(String.valueOf(pursheet.getmoney1()));
								noteText.setText(pursheet.getwords());
							}
							else{
								frame.getWarning().showWarning("请填写对应进货单编号进行搜索");
							}
							break;
						case SaleBackSheet:
							break;
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
					case 2:
						addList.setIcon(add0);
						break;
					case 3:
						confirm.setIcon(confirm0);
						break;
					case 4:
						find.setIcon(confirm0);
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

			public JTextField getTotalText() {
				return totalText;
			}
			public void setTotalText(JTextField totalText) {
				this.totalText = totalText;
			}
			public JTextField getCouponText() {
				return couponText;
			}
			public void setCouponText(JTextField couponText) {
				this.couponText = couponText;
			}
			public JTextField getDiscountText() {
				return discountText;
			}
			public void setDiscountText(JTextField discountText) {
				this.discountText = discountText;
			}
			public JTextField getFinalTotalText() {
				return finalTotalText;
			}
			public void setFinalTotalText(JTextField finalTotalText) {
				this.finalTotalText = finalTotalText;
			}
			public void leftMove(){
				Thread t=new Thread(new TreadOfLeft());
				t.start();
			}
			public void RightMove(){
				Thread t=new Thread(new TreadOfRight());
				t.start();
			}
			public boolean isAdd() {
				return isAdd;
			}
			public void setAdd(boolean isAdd) {
				this.isAdd = isAdd;
			}
			public ArrayList<CommodityVO> getOutput() {
				return output;
			}
			public void setOutput(ArrayList<CommodityVO> output) {
				this.output = output;
			}
			public ArrayList<String> getOutputNotes() {
				return outputNotes;
			}
			public void setOutputNotes(ArrayList<String> outputNotes) {
				this.outputNotes = outputNotes;
			}
			public JLabel getBillID() {
				return billID;
			}
			public void setBillID(JLabel billID) {
				this.billID = billID;
			}
			public JTextField getBillIDTxt() {
				return billIDTxt;
			}
			public void setBillIDTxt(JTextField billIDTxt) {
				this.billIDTxt = billIDTxt;
			}
			public JTextField getCustomerTxt() {
				return customerTxt;
			}
			public void setCustomerTxt(JTextField customerTxt) {
				this.customerTxt = customerTxt;
			}
			public JTextField getWarehouseTxt() {
				return warehouseTxt;
			}
			public void setWarehouseTxt(JTextField warehouseTxt) {
				this.warehouseTxt = warehouseTxt;
			}
			public JLabel getStrategy() {
				return strategy;
			}
			public void setStrategy(JLabel strategy) {
				this.strategy = strategy;
			}
			public JComboBox getStrategyCombo() {
				return strategyCombo;
			}
			public void setStrategyCombo(JComboBox strategyCombo) {
				this.strategyCombo = strategyCombo;
			}
		}
		public JPanelEdit getJPeditOfPur() {
			return JPeditOfPur;
		}
		public void setJPeditOfPur(JPanelEdit jPeditOfPur) {
			JPeditOfPur = jPeditOfPur;
		}
		public JPanelEdit getJPeditOfPurBack() {
			return JPeditOfPurBack;
		}
		public void setJPeditOfPurBack(JPanelEdit jPeditOfPurBack) {
			JPeditOfPurBack = jPeditOfPurBack;
		}
		public JPanelEdit getJPeditOfSale() {
			return JPeditOfSale;
		}
		public void setJPeditOfSale(JPanelEdit jPeditOfSale) {
			JPeditOfSale = jPeditOfSale;
		}
		public JPanelEdit getJPeditOfSaleBack() {
			return JPeditOfSaleBack;
		}
		public void setJPeditOfSaleBack(JPanelEdit jPeditOfSaleBack) {
			JPeditOfSaleBack = jPeditOfSaleBack;
		}
		
}
