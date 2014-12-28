package presentation.commodityui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entrance.Frame;
import po.BillState;
import po.BillStyle;
import po.SpillsLossBillPO.Type;
import presentation.managerui.JPBillList;
import presentation.managerui.JTableOfList;
import presentation.managerui.MouseListenerGetXY;
import vo.SpillsLossBillVO;
import vo.stockvo.CommodityVO;

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
		private JPanelEdit JPeditOfSpoil;
	
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
			edit.setBounds(720, 215, 50, 50);
			edit.addMouseListener(new MouseListenerOfButton(5));
			//提交功能按钮
			submit.setIcon(submitIconW);
			submit.setBounds(720, 150, 50, 50);
			submit.addMouseListener(new MouseListenerOfButton(6));
			//创建功能按钮
			add.setIcon(addIconW);
			add.setBounds(720, 280, 50, 50);
			add.addMouseListener(new MouseListenerOfButton(7));
			//编辑面板
			JPeditOfSpoil=new JPanelEdit(BillStyle.SpillsLossBill);
			
			JPeditOfSpoil.setLocation(905, 36);
			
			this.add(jp,0);
			this.add(up,1);
			this.add(down,2);
			this.add(JPeditOfSpoil,3);
			this.add(done,4);
			this.add(delete,5);
			this.add(edit,6);
			this.add(submit,7);
			this.add(add,8);
			this.add(table,9);
			this.add(bg,10);
		}
		public void reHome(){
			JPeditOfSpoil.reHome();
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
				add.setVisible(false);
				edit.setVisible(false);
				done.setVisible(true);
				break;
			case SpillsLossBill:
				table.setVisible(false);
				add.setVisible(true);
				edit.setVisible(true);
				done.setVisible(true);
				break;
			case AlertBill:
				table.setVisible(false);
				add.setVisible(false);
				edit.setVisible(false);
				done.setVisible(false);//库管人员无权完成报警单，进货人员进货后由进货人员处理，库管只负责上交
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
					
					break;
				case 4:
					delete.setIcon(deleteIconR);
				
					break;
				case 5:
					edit.setIcon(editIconR);
				
					break;
				case 6:
					submit.setIcon(submitIconR);
				
					break;
				case 7:
					add.setIcon(addIconR);
				
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
					billList.doneChosen();//处理选中的
					break;
				case 4:
					delete.setIcon(deleteIconW);
					billList.removeChosen();//删除选中的
					break;
				case 5:
					edit.setIcon(editIconW);
					if(billList.getChosenNum()==1&&billList.stateOfChosen()==BillState.DRAFT){
						JPeditOfSpoil.setIsAdd(false);//不是加单据是修改单据
						JPeditOfSpoil.leftMove();//调出编辑板
					}
					else{
						frame.getWarning().showWarning("只能修改一张草稿状态的单据");
					}
					break;				
				case 6:
					submit.setIcon(submitIconW);
					billList.submitChosen();//上交选中的
					break;
				case 7:
					add.setIcon(addIconW);
					JPeditOfSpoil.setIsAdd(true);//不是加单据是修改单据
					JPeditOfSpoil.leftMove();//调出编辑板
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
			private ImageIcon scan0=new ImageIcon("src/image/function/littleScanW.png");
			private ImageIcon scan1=new ImageIcon("src/image/function/littleScanR.png");
			private ImageIcon confirm0=new ImageIcon("src/image/function/confirmW.png");
			private ImageIcon confirm1=new ImageIcon("src/image/function/confirmR.png");
			
			//报溢报损单的附件
			private JComboBox typeCombo;
			private JLabel typelabel=new JLabel("类别");
			private JLabel commodity=new JLabel("商品");
			private JLabel type=new JLabel("型号");
			private JLabel num=new JLabel("数量");
			private JLabel scan=new JLabel("浏览");
			private JLabel scanButton=new JLabel();//增加条目按钮
			private JTextField commodityText=new JTextField(10);
		
			private JTextField typeText=new JTextField(10);
			private JTextField numText=new JTextField(10);
			//接收商品
			private CommodityVO chosenVO;
		
			/*归位并清空数据*/
			public void reHome(){
				this.setLocation(905, 36);
				chosenVO=null;
				commodityText.setText("");
				typeText.setText("");
				numText.setText("");
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
			
				String[] typeC={"报溢单","报损单"};
				typeCombo = new JComboBox(typeC);
				typeCombo.setFont(new Font("宋体",Font.BOLD,14));
				typeCombo.setBounds(80,30, 150, 20);
				typeCombo.setBackground(Color.gray);
				typeCombo.setForeground(Color.white);
				//设置标签字体
				typelabel.setFont(new Font("宋体",Font.BOLD,14));
				scan.setFont(new Font("宋体",Font.BOLD,14));
				commodity.setFont(new Font("宋体",Font.BOLD,14));
				type.setFont(new Font("宋体",Font.BOLD,14));
				num.setFont(new Font("宋体",Font.BOLD,14));
				//设置字体颜色
				typelabel.setForeground(Color.white);
				scan.setForeground(Color.white);
				commodity.setForeground(Color.white);
				type.setForeground(Color.white);
				num.setForeground(Color.white);
				//设置标签大小位置
				typelabel.setBounds(40, 30, 40, 20);
				scan.setBounds(40, 60, 40, 20);
				commodity.setBounds(40, 90, 40, 20);
				type.setBounds(40, 120, 40, 20);
				num.setBounds(40, 150, 40, 20);
				//浏览按钮
				scanButton.setIcon(scan0);
				scanButton.setBounds(100, 58, 24, 24);
				scanButton.addMouseListener(new MouseListenerOfButton(2));
				//商品名文本框
				commodityText.setBounds(80,90, 150, 20);
				commodityText.setOpaque(false);//文本框透明
				commodityText.setEditable(false);
				commodityText.setForeground(Color.white);//前景色
				//型号文本框
				typeText.setBounds(80,120, 150, 20);
				typeText.setOpaque(false);//文本框透明
				typeText.setEditable(false);
				typeText.setForeground(Color.white);//前景色
				//数量文本框
				numText.setBounds(80,150, 150, 20);
				numText.setOpaque(false);//文本框透明
				numText.setForeground(Color.white);//前景色
				
				this.add(right,0);
				this.add(confirm,1);
				this.add(scan,2);
				this.add(commodity,3);
				this.add(type,4);
				this.add(num,5);
				this.add(scanButton,6);
				this.add(commodityText,7);
				this.add(typeText,8);
				this.add(numText,9);
				this.add(typelabel,10);
				this.add(typeCombo,11);
				this.add(back,12);
			}
			public void leftMove(){
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

				private int num;//1、右移 2、浏览 3、确认
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
						scanButton.setIcon(scan1);
						
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
					case 2:
						scanButton.setIcon(scan0);
						//调出商品选择界面
						frame.getStock().getChoseComs().getContent().innitial();
						frame.getStock().getChoseComs().setVisible(true);
						break;
					case 3:
						confirm.setIcon(confirm0);
						if(isAdd){
							//生成报溢报损单
							if(chosenVO!=null&&!numText.getText().equals("")){
								chosenVO.setNumber(Integer.parseInt(numText.getText()));
								SpillsLossBillVO newSpills=new SpillsLossBillVO();
								frame.getWarning().showWarning(chosenVO.getName()+":"+chosenVO.getModel()+":"+chosenVO.getNumber());
								newSpills.setCom(chosenVO);
								if(typeCombo.getSelectedItem().toString().equals("报损单")){
									newSpills.setT(Type.Loss);
								}
								else if(typeCombo.getSelectedItem().toString().equals("报溢单")){
									newSpills.setT(Type.Spills);
								}
								billList.addSpillsLossBill(newSpills);
							}
							else{
								frame.getWarning().showWarning("请填写完整信息");
							}
						}
						else{//修改报溢单
							if(billList.getChosenNum()==1){
									SpillsLossBillVO modifyVO=billList.getChosen().getSpillsLossVO();
									CommodityVO temp=new CommodityVO();
									if(chosenVO!=null){
										temp.setName(chosenVO.getName());
										temp.setModel(chosenVO.getModel());
									}
									if(!numText.getText().equals("")){
										temp.setNumber(chosenVO.getNumber());
									}
									if(typeCombo.getSelectedItem().toString().equals("报损单")){
										modifyVO.setT(Type.Loss);
									}
									else if(typeCombo.getSelectedItem().toString().equals("报溢单")){
										modifyVO.setT(Type.Spills);
									}
									modifyVO.setCom(temp);
							}
							else if(billList.getChosenNum()==0){
								frame.getWarning().showWarning("请选择要修改的单据");
							}
							else{
								frame.getWarning().showWarning("只能同时修改一张单据");
							}
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
						scanButton.setIcon(scan0);
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
	
			public JTextField getCommodityText() {
				return commodityText;
			}
			public void setCommodityText(JTextField commodityText) {
				this.commodityText = commodityText;
			}
			public JTextField getTypeText() {
				return typeText;
			}
			public void setTypeText(JTextField typeText) {
				this.typeText = typeText;
			}
			public CommodityVO getChosenVO() {
				return chosenVO;
			}
			public void setChosenVO(CommodityVO chosenVO) {
				this.chosenVO = chosenVO;
			}
		}
		public JPanelEdit getJPeditOfSpoil() {
			return JPeditOfSpoil;
		}
		public void setJPeditOfSpoil(JPanelEdit jPeditOfSpoil) {
			JPeditOfSpoil = jPeditOfSpoil;
		}
		public JPBillList getBillList() {
			return billList;
		}
		public void setBillList(JPBillList billList) {
			this.billList = billList;
		}
}
