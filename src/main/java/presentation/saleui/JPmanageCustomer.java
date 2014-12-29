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
import po.Role;
import presentation.StringJudger;
import presentation.managerui.JPBillList;
import presentation.managerui.MouseListenerGetXY;
import presentation.userui.Login;
import vo.CustomerVO;
import businesslogic.customerbl.CustomerList;
import businesslogicservice.customerblservice.CustomerBlService;

public class JPmanageCustomer extends JPanel {

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
			//编辑面板
			private JPanelEdit JPedit;
			//查找面板
			private JPanelSearch JPsearch;
			//图片
			ImageIcon upIconW=new ImageIcon("src/image/upW.png");
			ImageIcon downIconW=new ImageIcon("src/image/downW.png");
			ImageIcon searchIconW=new ImageIcon("src/image/function/searchW.png");
			ImageIcon deleteIconW=new ImageIcon("src/image/function/deleteW.png");
			ImageIcon editIconW=new ImageIcon("src/image/function/editW.png");
			ImageIcon addIconW=new ImageIcon("src/image/function/addW.png");
			
			ImageIcon upIconR=new ImageIcon("src/image/upR.png");
			ImageIcon downIconR=new ImageIcon("src/image/downR.png");
			ImageIcon searchIconR=new ImageIcon("src/image/function/searchR.png");
			ImageIcon deleteIconR=new ImageIcon("src/image/function/deleteR.png");
			ImageIcon editIconR=new ImageIcon("src/image/function/editR.png");
			ImageIcon addIconR=new ImageIcon("src/image/function/addR.png");
			//frame的引用
		    Frame frame;
		    //客户管理逻辑层接口
		    CustomerBlService customerbl=new CustomerList();
		 	//字符串类型判断
		    StringJudger stringJg=new StringJudger();
		    public void reHome(){
		    	JPedit.reHome();
		    	JPsearch.reHome();
		    }
			public JPmanageCustomer(){//参数决定编辑板的类型
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
				this.add(bg,9);
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
							JPedit.setIsAdd(false);//不是加客户是修改客户
							JPedit.leftMove();//调出编辑板
						}
						else if(billList.getChosenNum()==0){
							frame.getWarning().showWarning("请选择要修改的客户");
						}
						else{
							frame.getWarning().showWarning("只能修改一个客户的信息");
						}
						break;				
					case 7:
						add.setIcon(addIconW);
						JPedit.setIsAdd(true);//不是加客户是修改客户
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
					case 7:
						add.setIcon(addIconW);
						break;
					}
				}
				
			}
			/*编辑栏面板*/
			public class JPanelEdit extends JPanel{
				//判断是加客户还是编辑客户
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
				private JLabel category=new JLabel("分类");
				private JLabel rank=new JLabel("级别");
				private JLabel name=new JLabel("姓名");
				private JLabel phoneNumber=new JLabel("电话");
				private JLabel address=new JLabel("地址");
				private JLabel email=new JLabel("邮箱");
				private JLabel postcode=new JLabel("邮编");
				private JLabel saleman=new JLabel("默认业务员");
				private JLabel maxOwe=new JLabel("应收额度");
				private JComboBox  categoryCombo;
				private JComboBox  rankCombo;
				private JTextField nameText=new JTextField(10);
				private JTextField phoneNumberText=new JTextField(10);
				private JTextField addressText=new JTextField(10);
				private JTextField emailText=new JTextField(10);
				private JTextField postcodeText=new JTextField(10);
				private JTextField salemanText=new JTextField(10);
				private JTextField maxOweText=new JTextField(10);
				
				public void reHome(){
					this.RightMove();
					nameText.setText("");
					phoneNumberText.setText("");
					addressText.setText("");
					emailText.setText("");
					postcodeText.setText("");
					salemanText.setText("");
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
					phoneNumber.setFont(new Font("宋体",Font.BOLD,14));
					category.setFont(new Font("宋体",Font.BOLD,14));
					rank.setFont(new Font("宋体",Font.BOLD,14));
					name.setFont(new Font("宋体",Font.BOLD,14));
					address.setFont(new Font("宋体",Font.BOLD,14));
					email.setFont(new Font("宋体",Font.BOLD,14));
					postcode.setFont(new Font("宋体",Font.BOLD,14));
					saleman.setFont(new Font("宋体",Font.BOLD,14));
					maxOwe.setFont(new Font("宋体",Font.BOLD,14));
					//设置字体颜色
					phoneNumber.setForeground(Color.white);
					category.setForeground(Color.white);
					rank.setForeground(Color.white);
					name.setForeground(Color.white);
					address.setForeground(Color.white);
					email.setForeground(Color.white);
					postcode.setForeground(Color.white);
					saleman.setForeground(Color.white);
					maxOwe.setForeground(Color.white);
					//设置标签大小位置
					category.setBounds(40, 10, 40, 20);
					rank.setBounds(40, 35, 40, 20);
					name.setBounds(40, 60, 40, 20);
					saleman.setBounds(40, 85,120, 20);
					phoneNumber.setBounds(40,110, 40, 20);
					email.setBounds(40,135, 40, 20);
					postcode.setBounds(40,160, 40, 20);
					address.setBounds(40,185, 40, 20);
					maxOwe.setBounds(40,210, 100, 20);
					
					
					//客户等级选择下拉框
					String[] categorycomb={"销售商","进货商"};
					categoryCombo = new JComboBox(categorycomb);
					categoryCombo.setFont(new Font("宋体",Font.BOLD,14));
					categoryCombo.setBounds(80,10, 150, 20);
					categoryCombo.setBackground(Color.gray);
					categoryCombo.setForeground(Color.white);
					
					//客户等级选择下拉框
					String[] levelcomb={"一级","二级","三级","四级","五级"};
					rankCombo = new JComboBox(levelcomb);
					rankCombo.setFont(new Font("宋体",Font.BOLD,14));
					rankCombo.setBounds(80,35, 150, 20);
					rankCombo.setBackground(Color.gray);
					rankCombo.setForeground(Color.white);
					
					//姓名文本框
					nameText.setBounds(80,60, 150, 20);
					nameText.setOpaque(false);//文本框透明
					nameText.setForeground(Color.white);//前景色
					nameText.setCaretColor(Color.white);
					//业务员文本框
					salemanText.setBounds(125,85,105, 20);
					salemanText.setOpaque(false);//文本框透明
					salemanText.setForeground(Color.white);//前景色
					salemanText.setCaretColor(Color.white);
					//电话文本框
					phoneNumberText.setBounds(80,110, 150, 20);
					phoneNumberText.setOpaque(false);//文本框透明
					phoneNumberText.setForeground(Color.white);//前景色
					phoneNumberText.setCaretColor(Color.white);
					//邮箱文本框
					emailText.setBounds(80,135, 150, 20);
					emailText.setOpaque(false);//文本框透明
					emailText.setForeground(Color.white);//前景色
					emailText.setCaretColor(Color.white);
					//邮编文本框
					postcodeText.setBounds(80,160, 150, 20);
					postcodeText.setOpaque(false);//文本框透明
					postcodeText.setForeground(Color.white);//前景色
					postcodeText.setCaretColor(Color.white);
					//地址文本框
					addressText.setBounds(80,185, 150, 20);
					addressText.setOpaque(false);//文本框透明
					addressText.setForeground(Color.white);//前景色
					addressText.setCaretColor(Color.white);
					//应收额度文本框
					maxOweText.setBounds(105,210, 125, 20);
					maxOweText.setOpaque(false);//文本框透明
					maxOweText.setForeground(Color.white);//前景色
					maxOweText.setCaretColor(Color.white);
					//默认不可见，确认为经理且修改才可见
					maxOwe.setVisible(false);
					maxOweText.setVisible(false);
					this.add(right,0);
					this.add(confirm,1);
					this.add(phoneNumber,2);
					this.add(category,3);
					this.add(rank,4);
					this.add(name,5);
					this.add(saleman,6);
					this.add(email,7);
					this.add(postcode,8);
					this.add(address,9);
					this.add(categoryCombo,10);
					this.add(rankCombo,11);
					this.add(nameText,12);
					this.add(salemanText,13);
					this.add(phoneNumberText,14);
					this.add(emailText,15);
					this.add(postcodeText,16);
					this.add(addressText,17);
					this.add(maxOwe,18);
					this.add(maxOweText,19);
					this.add(back,20);
				}
				public void leftMove(){
					if(Login.user.getR()==Role.PURCHASE_SALE_STAFF){
						maxOwe.setVisible(false);
						maxOweText.setVisible(false);
					}
					else if(Login.user.getR()==Role.PURCHASE_SALE_MANAGER&&!isAdd){
						maxOwe.setVisible(true);
						maxOweText.setVisible(true);
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
							if(isAdd){
								if(!nameText.getText().equals("")
										&&!salemanText.getText().equals("")
										&&!phoneNumberText.getText().equals("")
										&&!emailText.getText().equals("")
										&&!postcodeText.getText().equals("")
										&&!addressText.getText().equals("")
									){
									if(stringJg.judgestring(phoneNumberText.getText())==3&&
											phoneNumberText.getText().toCharArray().length==11
											){
										if(stringJg.judgestring(postcodeText.getText())==3&&
												postcodeText.getText().toCharArray().length==6){
											if(stringJg.judgestring(emailText.getText())==1){
												int level=0;
												if(rankCombo.getSelectedItem().toString().equals("一级")){
													level=1;
												}
												else if(rankCombo.getSelectedItem().toString().equals("二级")){
													level=2;
												}
												else if(rankCombo.getSelectedItem().toString().equals("三级")){
													level=3;
												}
												else if(rankCombo.getSelectedItem().toString().equals("四级")){
													level=4;
												}
												else if(rankCombo.getSelectedItem().toString().equals("五级")){
													level=5;
												}
												int type=0;
												if(categoryCombo.getSelectedItem().toString().equals("进货商")){
													type=0;
												}
												else if(categoryCombo.getSelectedItem().toString().equals("销售商")){
													type=1;
												}
												CustomerVO newCus=new CustomerVO();
												newCus.settype(type);
												newCus.setlevel(level);
												newCus.setname(nameText.getText());
												newCus.setdeSaler(salemanText.getText());
												newCus.setphonenumber(phoneNumberText.getText());
												newCus.setemail(emailText.getText());
												newCus.setpostcode(postcodeText.getText());
												newCus.setaddress(addressText.getText());
												billList.addCustomer(newCus);
											}
											else{
												frame.getWarning().showWarning("邮箱格式错误");
											}
										}
										else{
											frame.getWarning().showWarning("邮编输入有误");
										}
									}
									else{
										frame.getWarning().showWarning("电话号码输入有误");
									}
								}
								else{
									frame.getWarning().showWarning("请输入完整信息");
								}
							}
							else{//修改
								if(billList.getChosenNum()==1){
									int level=0;
									if(rankCombo.getSelectedItem().toString().equals("一级")){
										level=1;
									}
									else if(rankCombo.getSelectedItem().toString().equals("二级")){
										level=2;
									}
									else if(rankCombo.getSelectedItem().toString().equals("三级")){
										level=3;
									}
									else if(rankCombo.getSelectedItem().toString().equals("四级")){
										level=4;
									}
									else if(rankCombo.getSelectedItem().toString().equals("五级")){
										level=5;
									}
									int type=0;
									if(categoryCombo.getSelectedItem().toString().equals("进货商")){
										type=0;
									}
									else if(categoryCombo.getSelectedItem().toString().equals("销售商")){
										type=1;
									}
									boolean legal=true;
									if(!phoneNumberText.getText().equals("")){
										if(stringJg.judgestring(phoneNumberText.getText())!=3||
												phoneNumberText.getText().toCharArray().length!=11
												){
											legal=false;
											frame.getWarning().showWarning("电话号码输入有误");
										}
									}
									if(!emailText.getText().equals("")){
										if(stringJg.judgestring(emailText.getText())!=1
												){
											legal=false;
											frame.getWarning().showWarning("邮箱格式错误");
										}
									}
									if(!postcodeText.getText().equals("")){
										if(stringJg.judgestring(postcodeText.getText())!=3||
												postcodeText.getText().toCharArray().length!=6){
											legal=false;
											frame.getWarning().showWarning("邮编输入有误");
										}
									}
									if(!maxOweText.getText().equals("")&&stringJg.judgestring(maxOweText.getText())!=3){
										legal=false;
										frame.getWarning().showWarning("应收额度必须为数字");
									}
					
									if(legal){
										CustomerVO modifyCus=billList.getChosen().getCustomerVO();
										modifyCus.settype(type);
										modifyCus.setlevel(level);
										if(!nameText.getText().equals("")
												){
											modifyCus.setname(nameText.getText());
										}
										if(!salemanText.getText().equals("")){
											modifyCus.setdeSaler(salemanText.getText());
										}
										if(!phoneNumberText.getText().equals("")){
											modifyCus.setphonenumber(phoneNumberText.getText());
										}
										if(!emailText.getText().equals("")){
											modifyCus.setemail(emailText.getText());
										}
										if(!postcodeText.getText().equals("")){
											modifyCus.setpostcode(postcodeText.getText());
										}
										if(!addressText.getText().equals("")){
											modifyCus.setaddress(addressText.getText());
										}
										if(!maxOweText.getText().equals("")){
											modifyCus.setmaxOwe(Double.parseDouble(maxOweText.getText()));
										}
											
										//进行修改
										billList.changeChosen(modifyCus);
									}
									
								}
								else if(billList.getChosenNum()==0){
									frame.getWarning().showWarning("请选择要修改的客户");
								}
								else{
									frame.getWarning().showWarning("只能同时修改一个客户");
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
					searchTxt.setText("");
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
							if(!searchTxt.getText().equals("")){
								billList.getJPbillList().clear();
								billList.reHome();
								ArrayList<CustomerVO> cus=new ArrayList<CustomerVO>();
								cus.add(customerbl.findCustomer(searchTxt.getText()));
								billList.addCustomerList(cus);
								
							}
							else{
								frame.getWarning().showWarning("请输入客户ID");
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
			public JPBillList getBillList() {
				return billList;
			}
			public void setBillList(JPBillList billList) {
				this.billList = billList;
			}
	
}
