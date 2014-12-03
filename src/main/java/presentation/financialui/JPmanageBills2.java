package presentation.financialui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.managerui.JPBillList;
import presentation.managerui.MouseListenerGetXY;
import vo.financialBillVO.CashPaymentVO;
import businesslogic.BillStyle;

public class JPmanageBills2 extends JPanel {
	//背景
		private JLabel bg=new JLabel();
		//向上
		private JLabel up=new JLabel();
		//向下
		private JLabel down=new JLabel();
		//单据列表
		JPBillList billList=new JPBillList();
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
		JPanelEdit JPedit;
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
		
		public JPmanageBills2(ArrayList<CashPaymentVO> cpbList){
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
			if(cpbList!=null){
				billList.addCashPaymentBillList(cpbList);
			}
			billList.setLocation(0, 0);
			
			//将列表加在底板上
			jp.add(billList,0);
			jp.add(jpbg,1);
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
			JPedit=new JPanelEdit(BillStyle.ReceiptBill);
			JPedit.setLocation(905, 36);
			
			this.add(jp,0);
			this.add(up,1);
			this.add(down,2);
			this.add(JPedit,3);
			this.add(done,4);
			this.add(delete,5);
			this.add(edit,6);
			this.add(submit,7);
			this.add(add,8);
			this.add(bg,9);
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
				//向上
				billList.startUp();
					break;
				case 2:
				down.setIcon(downIconR);
				//向下
				billList.startDown();
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
					JPedit.leftMove();
					break;
				case 6:
					submit.setIcon(submitIconR);
					break;
				case 7:
					add.setIcon(addIconR);
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
			//背景
			private JLabel back=new JLabel();
			//右移按钮
			private JLabel right=new JLabel();
			//图片
			private ImageIcon right0=new ImageIcon("src/image/function/rightW.png");
			private ImageIcon right1=new ImageIcon("src/image/function/rightR.png");
			private ImageIcon add0=new ImageIcon("src/image/function/littleAddW.png");
			private ImageIcon add1=new ImageIcon("src/image/function/littleAddR.png");
			private BillStyle billStyle;
			//现金费用单的附件
			private JLabel account=new JLabel("账户");
			private JLabel list=new JLabel("条目");
			private JLabel total=new JLabel("总额");
			private JLabel addList=new JLabel();//增加条目按钮
			private JTextField accountText=new JTextField(10);
			private JTextField totalText=new JTextField(10);
			private JPaddList ListEdit=new JPaddList(BillStyle.CashPaymentBill);//隐藏的条目编辑面板
			//付款收款单
			private JLabel customer=new JLabel("账户");
			private JLabel tranList=new JLabel("转账列表");
			private JLabel tranTotal=new JLabel("总额");
			private JTextField customerText=new JTextField(10);
			private JTextField tranTotalText=new JTextField(10);
			private JPaddList tranListEdit=new JPaddList(BillStyle.PaymentBill);//隐藏的条目编辑面板
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
				//根据单据种类加上不同的附件
				switch(style){
				case GiftBill:
					break;
				case SpillsLossBill:
					break;
				case AlertBill:
					break;
				case PurSheet:
					break;
				case PurBackSheet:
					break;
				case SaleSheet:
					break;
				case SaleBackSheet:
					break;
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
					//文本框
					customerText.setBounds(80,28, 150, 20);
					customerText.setOpaque(false);//文本框透明
					customerText.setForeground(Color.white);//前景色
					tranTotalText.setBounds(80,90, 150, 20);
					tranTotalText.setOpaque(false);//文本框透明
					tranTotalText.setForeground(Color.white);//前景色
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
					this.add(customerText,5);
					this.add(tranTotalText,6);
					this.add(addList,7);
					this.add(back,8);
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
					//文本框
					customerText.setBounds(80,28, 150, 20);
					customerText.setOpaque(false);//文本框透明
					customerText.setForeground(Color.white);//前景色
					tranTotalText.setBounds(80,90, 150, 20);
					tranTotalText.setOpaque(false);//文本框透明
					tranTotalText.setForeground(Color.white);//前景色
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
					this.add(customerText,5);
					this.add(tranTotalText,6);
					this.add(addList,7);
					this.add(back,8);
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
					totalText.setBounds(80,90, 150, 20);
					totalText.setOpaque(false);//文本框透明
					totalText.setForeground(Color.white);//前景色
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
					this.add(back,8);
					break;
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
						right.setIcon(right1);
						//右移
						RightMove();
						break;
					case 2:
						addList.setIcon(add1);
						//显示编辑条目面板
						switch(billStyle){
						case GiftBill:
							break;
						case SpillsLossBill:
							break;
						case AlertBill:
							break;
						case PurSheet:
							break;
						case PurBackSheet:
							break;
						case SaleSheet:
							break;
						case SaleBackSheet:
							break;
						case ReceiptBill:
							tranListEdit.setVisible(true);
							break;
						case PaymentBill:
							tranListEdit.setVisible(true);
							break;
						case CashPaymentBill:
							ListEdit.setVisible(true);
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
				private BillStyle billStyle;
				//文本框（现金费用单）
				private JTextField listTxt=new JTextField(10);
				private JTextField moneyTxt=new JTextField(10);
				private JTextField noteTxt=new JTextField(10);
				//文本框（付款收款单）
				private JTextField tranListTxt=new JTextField(10);
				private JTextField tranMoneyTxt=new JTextField(10);
				private JTextField tranNoteTxt=new JTextField(10);
				//图片
				private ImageIcon confirmW=new ImageIcon("src/image/function/confirmW.png");
				private ImageIcon confirmR=new ImageIcon("src/image/function/confirmR.png");
				
				public JPaddList(BillStyle style){
					//确认种类
					this.billStyle=style;
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
						//文本框
						tranListTxt.setBounds(70,30, 100, 20);
						tranListTxt.setOpaque(false);//文本框透明
						tranListTxt.setForeground(Color.white);//前景色
						tranMoneyTxt.setBounds(70,60, 100, 20);
						tranMoneyTxt.setOpaque(false);//文本框透明
						tranMoneyTxt.setForeground(Color.white);//前景色
						tranNoteTxt.setBounds(70,90, 100, 20);
						tranNoteTxt.setOpaque(false);//文本框透明
						tranNoteTxt.setForeground(Color.white);//前景色
						
						this.add(tranListName,0);
						this.add(tranMoney,1);
						this.add(tranNote,2);
						this.add(tranListTxt,3);
						this.add(tranMoneyTxt,4);
						this.add(tranNoteTxt,5);
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
						moneyTxt.setBounds(70,60, 100, 20);
						moneyTxt.setOpaque(false);//文本框透明
						moneyTxt.setForeground(Color.white);//前景色
						noteTxt.setBounds(70,90, 100, 20);
						noteTxt.setOpaque(false);//文本框透明
						noteTxt.setForeground(Color.white);//前景色
						
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
				public class MouseListenerOfButton implements MouseListener{

					
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						JPaddList.this.confirm.setIcon(confirmR);
						
					}

					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						JPaddList.this.confirm.setIcon(confirmW);
						JPaddList.this.setVisible(false);
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
}
