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

import entrance.Frame;
import presentation.PanelType;
import presentation.StringJudger;
import presentation.managerui.JPBillList;
import presentation.managerui.MouseListenerGetXY;
import vo.accountVO.AccountVO;
import vo.uservo.UserVO;
import businesslogic.financialbl.Financial;
import businesslogicservice.financialblservice.FinancialBlService;

public class JPmanageAccount extends JPanel {

	  //背景
			private JLabel bg=new JLabel();
			//向上
			private JLabel up=new JLabel();
			//向下
			private JLabel down=new JLabel();
			//单据列表
			private JPBillList billList=new JPBillList();
			//查询按钮
			private JLabel inquire=new JLabel();
			//删除按钮
			private JLabel delete=new JLabel();
			//编辑按钮
			private JLabel edit=new JLabel();
			//创建按钮
			private JLabel add=new JLabel();
			//期初建账按钮
			private JLabel build=new JLabel();
			//编辑面板
			private JPanelEdit JPedit;
			//查找面板
			private JPanelSearch JPsearch;
			public JPBillList getBillList() {
				return billList;
			}
			public void setBillList(JPBillList billList) {
				this.billList = billList;
			}
			//图片
			ImageIcon upIconW=new ImageIcon("src/image/upW.png");
			ImageIcon downIconW=new ImageIcon("src/image/downW.png");
			ImageIcon searchIconW=new ImageIcon("src/image/function/searchW.png");
			ImageIcon deleteIconW=new ImageIcon("src/image/function/deleteW.png");
			ImageIcon editIconW=new ImageIcon("src/image/function/editW.png");
			ImageIcon addIconW=new ImageIcon("src/image/function/addW.png");
			ImageIcon buildIconW=new ImageIcon("src/image/function/buildW.png");
			
			ImageIcon upIconR=new ImageIcon("src/image/upR.png");
			ImageIcon downIconR=new ImageIcon("src/image/downR.png");
			ImageIcon searchIconR=new ImageIcon("src/image/function/searchR.png");
			ImageIcon deleteIconR=new ImageIcon("src/image/function/deleteR.png");
			ImageIcon editIconR=new ImageIcon("src/image/function/editR.png");
			ImageIcon addIconR=new ImageIcon("src/image/function/addR.png");
			ImageIcon buildIconR=new ImageIcon("src/image/function/buildR.png");
			//frame的引用
		    Frame frame;
		    FinancialBlService fbl=new Financial();
		 	//字符串类型判断
		    StringJudger stringJg=new StringJudger();
		    public void reHome(){
		    	JPedit.reHome();
		    	JPsearch.reHome();
		    }
			public JPmanageAccount(){//参数决定编辑板的类型
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
				
				
				//向上按钮
				up.setIcon(upIconW);
				up.setBounds(281, 20, 32, 32);
				up.addMouseListener(new MouseListenerOfButton(1));
				//向下按钮
				down.setIcon(downIconW);
				down.setBounds(281, 289, 32, 32);
				down.addMouseListener(new MouseListenerOfButton(2));
				
				//创建功能按钮
				add.setIcon(addIconW);
				add.setBounds(720, 20, 50, 50);
				add.addMouseListener(new MouseListenerOfButton(7));
				//删除功能按钮
				delete.setIcon(deleteIconW);
				delete.setBounds(720, 85, 50, 50);
				delete.addMouseListener(new MouseListenerOfButton(4));
				//编辑功能按钮
				edit.setIcon(editIconW);
				edit.setBounds(720, 150, 50, 50);
				edit.addMouseListener(new MouseListenerOfButton(5));
				//查询功能按钮
				inquire.setIcon(searchIconW);
				inquire.setBounds(720, 215, 50, 50);
				inquire.addMouseListener(new MouseListenerOfButton(3));
				//期初建账
				build.setIcon(buildIconW);
				build.setBounds(720, 280, 55, 70);
				build.addMouseListener(new MouseListenerOfButton(6));
				//编辑面板
				JPedit=new JPanelEdit();
				JPedit.setLocation(905, 36);
				//查找面板
				JPsearch=new JPanelSearch();
				JPsearch.setLocation(905, 36);
				
				this.add(jp,0);
				this.add(up,1);
				this.add(down,2);
				this.add(JPedit,3);
				this.add(JPsearch,4);
				this.add(inquire,5);
				this.add(delete,6);
				this.add(edit,7);
				this.add(add,8);
				this.add(build,9);
				this.add(bg,10);
			}
			  /*获取frame引用*/
		    public void getFrame( Frame f){
		    		frame=f;
		    		billList.setFrame(frame);
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
						inquire.setIcon(searchIconR);
						
						break;
					case 4:
						delete.setIcon(deleteIconR);
						
						break;
					case 5:
						edit.setIcon(editIconR);
					
						break;
					case 6:
						build.setIcon(buildIconR);
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
						inquire.setIcon(searchIconW);
						JPsearch.leftMove();
						break;
					case 4:
						delete.setIcon(deleteIconW);
						billList.removeChosen();//删除选中的
						break;
					case 5:
						edit.setIcon(editIconW);
						if(billList.getChosenNum()==1){
							JPedit.setIsAdd(false);//不是加账户是修改账户
							JPedit.leftMove();//调出编辑板
						}
						else if(billList.getChosenNum()==0){
							frame.getWarning().showWarning("请选择要修改的账户");
						}
						else{
							frame.getWarning().showWarning("只能修改一个账户的信息");
						}
						break;			
					case 6:
						build.setIcon(buildIconW);
						//期初建账
						JPmanageAccount.this.setVisible(false);
						frame.getFinancial().getAccountBuild().setVisible(true);
						//标记当前面板，用于后退按钮
						frame.getFinancial().setPanelType(PanelType.AccountBuildIndexPanel);
					break;
					case 7:
						add.setIcon(addIconW);
						JPedit.setIsAdd(true);
						JPedit.leftMove();//调出编辑板
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
						inquire.setIcon(searchIconW);
						break;
					case 4:
						delete.setIcon(deleteIconW);
						break;
					case 5:
						edit.setIcon(editIconW);
						break;		
					case 6:
						build.setIcon(buildIconW);
					break;
					case 7:
						add.setIcon(addIconW);
						break;
					}
				}
				
			}
			/*编辑栏面板*/
			public class JPanelEdit extends JPanel{
				//判断是加账户还是编辑账户
				private boolean isAdd=true;//默认是加账户
				//背景
				private JLabel back=new JLabel();
				//右移按钮
				private JLabel right=new JLabel();
				//确认按钮
				private JLabel confirm=new JLabel();
				//图片
				private ImageIcon right0=new ImageIcon("src/image/function/rightW.png");
				private ImageIcon right1=new ImageIcon("src/image/function/rightR.png");
				private ImageIcon confirm0=new ImageIcon("src/image/function/confirmW.png");
				private ImageIcon confirm1=new ImageIcon("src/image/function/confirmR.png");
				
				//报溢报损单的附件
				private JLabel accountName=new JLabel("账户");
				private JLabel money=new JLabel("金额");
				private JTextField nameText=new JTextField(10);
				private JTextField moneyText=new JTextField(10);
				
				public void reHome(){
					this.RightMove();
				
				}
				public JPanelEdit(){
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
				
					//设置标签字体
					accountName.setFont(new Font("宋体",Font.BOLD,14));
					money.setFont(new Font("宋体",Font.BOLD,14));
					//设置字体颜色
					accountName.setForeground(Color.white);
					money.setForeground(Color.white);
					//设置标签大小位置
					accountName.setBounds(40, 30, 40, 20);
					money.setBounds(40,60, 40, 20);
					
					//账户名文本框
					nameText.setBounds(80,30, 150, 20);
					nameText.setOpaque(false);//文本框透明
					nameText.setForeground(Color.white);//前景色
					nameText.setCaretColor(Color.white);
					//余额文本框
					moneyText.setBounds(80,60, 150, 20);
					moneyText.setOpaque(false);//文本框透明
					moneyText.setForeground(Color.white);//前景色
					moneyText.setCaretColor(Color.white);
					
					this.add(right,0);
					this.add(confirm,1);
					this.add(accountName,2);
					this.add(money,3);
					this.add(nameText,4);
					this.add(moneyText,5);
					this.add(back,6);
				}
				public void leftMove(){
					Thread t=new Thread(new TreadOfLeft());
					t.start();
				}
				public void RightMove(){
					nameText.setText("");
					moneyText.setText("");
					Thread t=new Thread(new TreadOfRight());
					t.start();
				}
				public boolean getIsAdd() {
					return isAdd;
				}
				public void setIsAdd(boolean isAdd) {
					this.isAdd = isAdd;
					if(isAdd){
						money.setVisible(true);
						moneyText.setVisible(true);
					}
					else{
						money.setVisible(false);
						moneyText.setVisible(false);
					}
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
							break;
						case 3:
							confirm.setIcon(confirm0);
							if(isAdd){//如果是增加账户
								if(!nameText.getText().equals("")&&
										!moneyText.getText().equals("")){
									if(stringJg.judgestring(moneyText.getText())==3){
										AccountVO newAccount=new AccountVO();
										newAccount.setName(nameText.getText());
										newAccount.setBalance(Double.parseDouble(moneyText.getText()));
										billList.addAccount(newAccount);
									}
									else{
										frame.getWarning().showWarning("金额必须为数字");
									}
								}
								else{
									frame.getWarning().showWarning("请输入完整信息");
								}
							}
							else{//是修改
								if(billList.getChosenNum()==1){
									if(!nameText.getText().equals("")){
										AccountVO modifyAccount=billList.getChosen().getAccountVO();
										billList.changeChosen(modifyAccount.getName(), nameText.getText());
									}
									else{
										frame.getWarning().showWarning("请输入要修改的名称");
									}
								}
								else if(billList.getChosenNum()==0){
									frame.getWarning().showWarning("请选择要修改的账户");
								}
								else{
									frame.getWarning().showWarning("只能同时修改一个账户");
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
		

			}
			/*编辑栏面板*/
			public class JPanelSearch extends JPanel{
				//背景
				private JLabel back=new JLabel();
				//右移按钮
				private JLabel right=new JLabel();
				//确认按钮
				private JLabel searchButton=new JLabel();
				//图片
				private ImageIcon right0=new ImageIcon("src/image/function/rightW.png");
				private ImageIcon right1=new ImageIcon("src/image/function/rightR.png");
				private ImageIcon search0=new ImageIcon("src/image/function/littleScanW.png");
				private ImageIcon search1=new ImageIcon("src/image/function/littleScanR.png");
				
				//报溢报损单的附件
				private JLabel searchjl=new JLabel("查找 ");
				private JTextField searchTxt=new JTextField(10);
				
				public void reHome(){
					this.RightMove();
					
				}
				public JPanelSearch(){
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
					searchButton.setIcon(search0);
					searchButton.setBounds(120, 236, 24, 24);
					searchButton.addMouseListener(new MouseListenerOfButton(3));
				
					//设置标签字体
					searchjl.setFont(new Font("宋体",Font.BOLD,14));
					//设置字体颜色
					searchjl.setForeground(Color.white);
					//设置标签大小位置
					searchjl.setBounds(40, 30, 40, 20);
					//数量文本框
					searchTxt.setBounds(80,30, 140, 20);
					searchTxt.setOpaque(false);//文本框透明
					searchTxt.setForeground(Color.white);//前景色
					searchTxt.setCaretColor(Color.white);
					
					this.add(right,0);
					this.add(searchButton,1);
					this.add(searchjl,2);
					this.add(searchTxt,3);
					this.add(back,4);
				}
				public void leftMove(){
					Thread t=new Thread(new TreadOfLeft());
					t.start();
				}
				public void RightMove(){
					searchTxt.setText("");
					Thread t=new Thread(new TreadOfRight());
					t.start();
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
							break;
						case 3:
							searchButton.setIcon(search1);
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
							break;
						case 3:
							searchButton.setIcon(search0);
							//查找
							//查找
							if(!searchTxt.getText().equals("")){
								billList.getJPbillList().clear();
								billList.reHome();
								billList.addAccountList(fbl.fuzzyFindAccount(searchTxt.getText(), 1));
							}
							else{
								frame.getWarning().showWarning("请输入账户关键字");
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
							break;
						case 3:
							searchButton.setIcon(search0);
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
							JPanelSearch.this.setLocation(x, y);
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
							JPanelSearch.this.setLocation(x, y);
						}
					}
					
				}
		

			}
	
}
