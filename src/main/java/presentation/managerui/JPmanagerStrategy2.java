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

import userui.Frame;
import vo.BarginStrategyVO;
import vo.LevelStrategyVO;
import vo.ReachStrategyVO;
import vo.stockvo.CommodityVO;
import businesslogic.LevelStrategyStyle;
import businesslogic.ReachStrategyStyle;
import businesslogic.StrategyStyle;

public class JPmanagerStrategy2 extends JPanel {
        public StrategyStyle getStyle() {
		return style;
	}
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
		//删除按钮
		private JLabel delete=new JLabel();
		//创建按钮
		private JLabel add=new JLabel();
		//编辑面板
		private JPanelEdit JPeditOfLevel;
		public JPanelEdit getJPeditOfLevel() {
			return JPeditOfLevel;
		}
		public void setJPeditOfLevel(JPanelEdit jPeditOfLevel) {
			JPeditOfLevel = jPeditOfLevel;
		}
		public JPanelEdit getJPeditOfBargin() {
			return JPeditOfBargin;
		}
		public void setJPeditOfBargin(JPanelEdit jPeditOfBargin) {
			JPeditOfBargin = jPeditOfBargin;
		}
		public JPanelEdit getJPeditOfReach() {
			return JPeditOfReach;
		}
		public void setJPeditOfReach(JPanelEdit jPeditOfReach) {
			JPeditOfReach = jPeditOfReach;
		}
		//编辑面板
		private JPanelEdit JPeditOfBargin;
		//编辑面板
		private JPanelEdit JPeditOfReach;
	
		public JPBillList getBillList() {
			return billList;
		}
		public void setBillList(JPBillList billList) {
			this.billList = billList;
		}
		//单据类型
		private StrategyStyle style;
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
		public JPmanagerStrategy2(){//参数决定编辑板的类型
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
			String[] temp1={"商品","型号","数量"};
			String[] items=temp1;
			table.setColumnNames(items);
			table.setList(new String[1][3]);
			table.updateShow();
			
			billList.getTable(table);//将引用传递
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
			add.addMouseListener(new MouseListenerOfButton(3));
			//删除功能按钮
			delete.setIcon(deleteIconW);
			delete.setBounds(720, 85, 50, 50);
			delete.addMouseListener(new MouseListenerOfButton(4));
		
			//编辑面板
			JPeditOfLevel=new JPanelEdit(StrategyStyle.LevelStrategy);
			JPeditOfBargin=new JPanelEdit(StrategyStyle.BarginStrategy);
			JPeditOfReach=new JPanelEdit(StrategyStyle.ReachStrategy);
			JPeditOfLevel.setLocation(905, 36);
			JPeditOfBargin.setLocation(905, 36);
			JPeditOfReach.setLocation(905, 36);
			
			this.add(jp,0);
			this.add(up,1);
			this.add(down,2);
			this.add(JPeditOfLevel,3);
			this.add(JPeditOfBargin,4);
			this.add(JPeditOfReach,5);
			this.add(delete,6);
			this.add(add,7);
			this.add(table,8);
			this.add(bg,9);
		}
		  /*获取frame引用*/
	    public void getFrame( Frame f){
	    		frame=f;
	    }
		/*重新设置类型*/
		public void setStyle( StrategyStyle s){
			style=s;
			switch(style){
			case LevelStrategy:
			case ReachStrategy:
				String[] temp1={"赠品","型号","数量"};
				String[] items1=temp1;
				table.setColumnNames(items1);
				table.setList(new String[1][3]);
				table.updateShow();
				break;
			case BarginStrategy:
				String[] temp2={"商品","型号","数量"};
				String[] items2=temp2;
				table.setColumnNames(items2);
				table.setList(new String[1][3]);
				table.updateShow();
				break;
			}
		}
		public JPBillList getBillsList(){
			return billList;
		}
		public class MouseListenerOfButton implements MouseListener{

			private int num;//1、创建策略 2、删除策略
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
					//向上
					billList.startUp();
					break;
				case 2:
					down.setIcon(downIconR);
					//向下
					billList.startDown();
					break;	
				case 3:
					add.setIcon(addIconR);
					switch(style){
					case LevelStrategy:
						JPeditOfLevel.leftMove();//调出编辑板
						break;
					case BarginStrategy:
						JPeditOfBargin.leftMove();//调出编辑板
						break;
					case ReachStrategy:
						JPeditOfReach.leftMove();//调出编辑板
						break;
					}
					
					break;
				case 4:
					delete.setIcon(deleteIconR);
					billList.removeChosen();//删除选中的
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
					add.setIcon(addIconW);
					break;
				case 4:
					delete.setIcon(deleteIconW);
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
					add.setIcon(addIconW);
					break;
				case 4:
					delete.setIcon(deleteIconW);
					break;
				
				}
			}
			
		}
		/*编辑栏面板*/
		public class JPanelEdit extends JPanel{
			public ArrayList<CommodityVO> getOutput() {
				return output;
			}
			public void setOutput(ArrayList<CommodityVO> output) {
				this.output = output;
			}

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
			//接收输出的商品
			private ArrayList<CommodityVO> output=new ArrayList<CommodityVO>();
			//编辑面板的附件
			private JLabel strategyType=new JLabel("策略种类");
			private JLabel level=new JLabel("客户等级");
			private JLabel limit=new JLabel("消费下限");
			private JLabel gift=new JLabel("赠品");
			private JLabel commodity=new JLabel("商品");
			private JLabel discount=new JLabel("打折比例");
			private JLabel coupon=new JLabel("代金券赠送比例");
			private JLabel start=new JLabel("起始时间");
			private JLabel last=new JLabel("持续时间（天）");
			private JLabel originalTotalPrice=new JLabel("原始总价");
			private JLabel decreasePrice=new JLabel("降价金额");
			private JLabel num=new JLabel("打包数量");
			private JLabel addButton=new JLabel();//增加条目按钮
			private JComboBox strategyTypeCombo;
			private JComboBox levelCombo;
			private JTextField limitText=new JTextField(10);
			private JTextField discountText=new JTextField(10);
			private JTextField couponText=new JTextField(10);
			private JTextField startText=new JTextField(10);
			private JTextField lastText=new JTextField(10);
			private JTextField originalTotalPriceText=new JTextField(10);
			public JTextField getOriginalTotalPriceText() {
				return originalTotalPriceText;
			}
			public void setOriginalTotalPriceText(JTextField originalTotalPriceText) {
				this.originalTotalPriceText = originalTotalPriceText;
			}

			private JTextField decreasePriceText=new JTextField(10);
			private JTextField numText=new JTextField(10);
			public JPanelEdit(StrategyStyle style){
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
				strategyType.setFont(new Font("宋体",Font.BOLD,14));
				level.setFont(new Font("宋体",Font.BOLD,14));
				limit.setFont(new Font("宋体",Font.BOLD,14));
				gift.setFont(new Font("宋体",Font.BOLD,14));
				commodity.setFont(new Font("宋体",Font.BOLD,14));
				discount.setFont(new Font("宋体",Font.BOLD,14));
				coupon.setFont(new Font("宋体",Font.BOLD,14));
				start.setFont(new Font("宋体",Font.BOLD,14));
				last.setFont(new Font("宋体",Font.BOLD,14));
				originalTotalPrice.setFont(new Font("宋体",Font.BOLD,14));
				decreasePrice.setFont(new Font("宋体",Font.BOLD,14));
				num.setFont(new Font("宋体",Font.BOLD,14));
				
				//设置字体颜色
				strategyType.setForeground(Color.white);
				level.setForeground(Color.white);
				limit.setForeground(Color.white);
				gift.setForeground(Color.white);
				commodity.setForeground(Color.white);
				discount.setForeground(Color.white);
				coupon.setForeground(Color.white);
				start.setForeground(Color.white);
				last.setForeground(Color.white);
				originalTotalPrice.setForeground(Color.white);
				decreasePrice.setForeground(Color.white);
				num.setForeground(Color.white);
				
				switch(style){
				case LevelStrategy:
					//设置标签大小位置
					strategyType.setBounds(40,20,60, 20);
					level.setBounds(40,45, 60, 20);
					limit.setBounds(40,70, 60, 20);
					gift.setBounds(40,95, 40, 20);
					discount.setBounds(40,120,60, 20);
					coupon.setBounds(40,145,110, 20);
					start.setBounds(40,170, 60, 20);
					last.setBounds(40,195,120, 20);
					
					
					//策略种类选择下拉框
					String[] StrategyTypeOfLevel={"赠送赠品","打折","赠送代金券"};
					strategyTypeCombo = new JComboBox(StrategyTypeOfLevel);
					strategyTypeCombo.setFont(new Font("宋体",Font.BOLD,14));
					strategyTypeCombo.setBounds(105,20, 130, 20);
					strategyTypeCombo.setBackground(Color.gray);
					strategyTypeCombo.setForeground(Color.white);
					//客户等级选择下拉框
					
					String[] levelcomb={"一级","二级","三级","四级","五级"};
					levelCombo = new JComboBox(levelcomb);
					levelCombo.setFont(new Font("宋体",Font.BOLD,14));
					levelCombo.setBounds(105,45, 130, 20);
					levelCombo.setBackground(Color.gray);
					levelCombo.setForeground(Color.white);
					//消费下限文本框
					limitText.setBounds(105,70, 130, 20);
					limitText.setOpaque(false);//文本框透明
					limitText.setForeground(Color.white);//前景色
					//浏览按钮
					addButton.setIcon(add0);
					addButton.setBounds(105,93, 24, 24);
					addButton.addMouseListener(new MouseListenerOfButton(2));
					//打折比例文本框
					discountText.setBounds(105,120, 130, 20);
					discountText.setOpaque(false);//文本框透明
					discountText.setForeground(Color.white);//前景色
					//代金券赠送比例文本框
					couponText.setBounds(150,145,85, 20);
					couponText.setOpaque(false);//文本框透明
					couponText.setForeground(Color.white);//前景色
					//起始时间文本框
					startText.setBounds(105,170, 130, 20);
					startText.setOpaque(false);//文本框透明
					startText.setForeground(Color.white);//前景色
					//持续时间文本框
					lastText.setBounds(145,195,90, 20);
					lastText.setOpaque(false);//文本框透明
					lastText.setForeground(Color.white);//前景色
					
					this.add(strategyType,0);
					this.add(level,1);
					this.add(limit,2);
					this.add(gift,3);
					this.add(coupon,4);
					this.add(discount,5);
					this.add(start,6);
					this.add(last,7);
					this.add(right,8);
					this.add(strategyTypeCombo,9);
					this.add(levelCombo,10);
					this.add(limitText,11);
					this.add(addButton,12);
					this.add(couponText,13);
					this.add(discountText,14);
					this.add(startText,15);
					this.add(lastText,16);
					this.add(confirm,17);
					this.add(back,18);
					break;
				case BarginStrategy:
					//设置标签大小位置
					commodity.setBounds(40, 30, 40, 20);
					originalTotalPrice.setBounds(40, 60,60, 20);
					decreasePrice.setBounds(40, 90, 60, 20);
					num.setBounds(40, 120,60, 20);
					start.setBounds(40, 150, 60, 20);
					last.setBounds(40, 180,120, 20);
					
					//浏览按钮
					addButton.setIcon(add0);
					addButton.setBounds(105,28, 24, 24);
					addButton.addMouseListener(new MouseListenerOfButton(2));
					//原始总价文本框
					originalTotalPriceText.setBounds(105,60, 130, 20);
					originalTotalPriceText.setOpaque(false);//文本框透明
					originalTotalPriceText.setForeground(Color.white);//前景色
					//降价金额文本框
					decreasePriceText.setBounds(105,90, 130, 20);
					decreasePriceText.setOpaque(false);//文本框透明
					decreasePriceText.setForeground(Color.white);//前景色
					//打包数量文本框
					numText.setBounds(105,120, 130, 20);
					numText.setOpaque(false);//文本框透明
					numText.setForeground(Color.white);//前景色
					//起始时间文本框
					startText.setBounds(105,150, 130, 20);
					startText.setOpaque(false);//文本框透明
					startText.setForeground(Color.white);//前景色
					//持续时间文本框
					lastText.setBounds(145,180, 90, 20);
					lastText.setOpaque(false);//文本框透明
					lastText.setForeground(Color.white);//前景色
					
					this.add(commodity,0);
					this.add(originalTotalPrice,1);
					this.add(decreasePrice,2);
					this.add(num,3);
					this.add(start,4);
					this.add(last,5);
					this.add(right,6);
					this.add(addButton,7);
					this.add(originalTotalPriceText,8);
					this.add(decreasePriceText,9);
					this.add(numText,10);
					this.add(startText,11);
					this.add(lastText,12);
					this.add(confirm,13);
					this.add(back,14);
					break;
				case ReachStrategy:
					//设置标签大小位置
					strategyType.setBounds(40, 30,60, 20);
					limit.setBounds(40, 60,60, 20);
					gift.setBounds(40, 90, 60, 20);
					coupon.setBounds(40, 120,110, 20);
					start.setBounds(40, 150, 60, 20);
					last.setBounds(40, 180,120, 20);
					
					//策略种类选择下拉框
					String[] StrategyTypeOfReach={"赠送赠品","赠送代金券"};
					strategyTypeCombo = new JComboBox(StrategyTypeOfReach);
					strategyTypeCombo.setFont(new Font("宋体",Font.BOLD,14));
					strategyTypeCombo.setBounds(105,30, 130, 20);
					strategyTypeCombo.setBackground(Color.gray);
					strategyTypeCombo.setForeground(Color.white);
					//消费下限文本框
					limitText.setBounds(105,60, 130, 20);
					limitText.setOpaque(false);//文本框透明
					limitText.setForeground(Color.white);//前景色
					//浏览按钮
					addButton.setIcon(add0);
					addButton.setBounds(105,88, 24, 24);
					addButton.addMouseListener(new MouseListenerOfButton(2));
					//代金券赠送比例文本框
					couponText.setBounds(150,120, 85, 20);
					couponText.setOpaque(false);//文本框透明
					couponText.setForeground(Color.white);//前景色
					//起始时间文本框
					startText.setBounds(105,150, 130, 20);
					startText.setOpaque(false);//文本框透明
					startText.setForeground(Color.white);//前景色
					//持续时间文本框
					lastText.setBounds(145,180, 90, 20);
					lastText.setOpaque(false);//文本框透明
					lastText.setForeground(Color.white);//前景色
					
					this.add(strategyType,0);
					this.add(limit,1);
					this.add(gift,2);
					this.add(coupon,3);
					this.add(start,4);
					this.add(last,5);
					this.add(right,6);
					this.add(strategyTypeCombo,7);
					this.add(limitText,8);
					this.add(addButton,9);
					this.add(couponText,10);
					this.add(startText,11);
					this.add(lastText,12);
					this.add(confirm,13);
					this.add(back,14);
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
						addButton.setIcon(add1);
						
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
						addButton.setIcon(add0);
						//调出商品选择面板
						frame.getManager().getCommodityChoose().setVisible(true);
						break;
					case 3:
						confirm.setIcon(confirm0);
						//分类生成策略
						switch(style){
						case LevelStrategy:
							if(strategyTypeCombo.getSelectedItem().toString().equals("赠送赠品")){
								boolean legal=false;
								if(
										!limitText.getText().equals("")&&
										!startText.getText().equals("")&&
										!lastText.getText().equals("")&&
										output.size()!=0){
									legal=true;
								}
								if(legal){
									LevelStrategyVO newLevel=new LevelStrategyVO();
									newLevel.setLevel_strategy_style(LevelStrategyStyle.Gift);
									int level=0;
									if(levelCombo.getSelectedItem().toString().equals("一级")){
										level=1;
									}
									if(levelCombo.getSelectedItem().toString().equals("二级")){
										level=2;
									}
									if(levelCombo.getSelectedItem().toString().equals("三级")){
										level=3;
									}
									if(levelCombo.getSelectedItem().toString().equals("四级")){
										level=4;
									}
									if(levelCombo.getSelectedItem().toString().equals("五级")){
										level=5;
									}
									newLevel.setLevel(level);
									newLevel.setLimit(Double.parseDouble(limitText.getText()));
									newLevel.setAlOfCommodity(output);
									newLevel.setStartTime(startText.getText());
									newLevel.setLastTime(Integer.parseInt(lastText.getText()));
									billList.addLevelStrategy(newLevel);
									
									//清空信息
									limitText.setText("");
									startText.setText("");
									lastText.setText("");
									output.clear();
								}
								else{
									System.out.println("请填写完整策略信息");
								}
										
							}
							else if(strategyTypeCombo.getSelectedItem().toString().equals("赠送代金券")){
								boolean legal=false;
								if(!limitText.getText().equals("")&&
										!startText.getText().equals("")&&
										!lastText.getText().equals("")&&
										!couponText.getText().equals("")){
									legal=true;
								}
								if(legal){
									LevelStrategyVO newLevel=new LevelStrategyVO();
									newLevel.setLevel_strategy_style(LevelStrategyStyle.Coupon);
									int level=0;
									if(levelCombo.getSelectedItem().toString().equals("一级")){
										level=1;
									}
									if(levelCombo.getSelectedItem().toString().equals("二级")){
										level=2;
									}
									if(levelCombo.getSelectedItem().toString().equals("三级")){
										level=3;
									}
									if(levelCombo.getSelectedItem().toString().equals("四级")){
										level=4;
									}
									if(levelCombo.getSelectedItem().toString().equals("五级")){
										level=5;
									}
									newLevel.setLevel(level);
									newLevel.setLimit(Double.parseDouble(limitText.getText()));
									newLevel.setCouponrate(Double.parseDouble(couponText.getText()));
									newLevel.setStartTime(startText.getText());
									newLevel.setLastTime(Integer.parseInt(lastText.getText()));
									billList.addLevelStrategy(newLevel);
									
									//清空信息
									limitText.setText("");
									startText.setText("");
									lastText.setText("");
									couponText.setText("");
								}
								else{
									System.out.println("请填写完整策略信息");
								}
										
							}
							else if(strategyTypeCombo.getSelectedItem().toString().equals("打折")){
								boolean legal=false;
								if(!limitText.getText().equals("")&&
										!startText.getText().equals("")&&
										!lastText.getText().equals("")&&
										!discountText.getText().equals("")){
									legal=true;
								}
								if(legal){
									LevelStrategyVO newLevel=new LevelStrategyVO();
									newLevel.setLevel_strategy_style(LevelStrategyStyle.Discount);
									int level=0;
									if(levelCombo.getSelectedItem().toString().equals("一级")){
										level=1;
									}
									if(levelCombo.getSelectedItem().toString().equals("二级")){
										level=2;
									}
									if(levelCombo.getSelectedItem().toString().equals("三级")){
										level=3;
									}
									if(levelCombo.getSelectedItem().toString().equals("四级")){
										level=4;
									}
									if(levelCombo.getSelectedItem().toString().equals("五级")){
										level=5;
									}
									newLevel.setLevel(level);
									newLevel.setLimit(Double.parseDouble(limitText.getText()));
									newLevel.setDiscountrate(Double.parseDouble(discountText.getText()));
									newLevel.setStartTime(startText.getText());
									newLevel.setLastTime(Integer.parseInt(lastText.getText()));
									billList.addLevelStrategy(newLevel);
									
									//清空信息
									limitText.setText("");
									startText.setText("");
									lastText.setText("");
									discountText.setText("");
								}
								else{
									System.out.println("请填写完整策略信息");
								}
										
							}
							break;
						case BarginStrategy:
							boolean Legal=false;
							if(
									!originalTotalPriceText.getText().equals("")&&
									!decreasePriceText.getText().equals("")&&
									!numText.getText().equals("")&&
									!startText.getText().equals("")&&
									!lastText.getText().equals("")&&
									output.size()!=0){
								Legal=true;
							}
							if(Legal){
								BarginStrategyVO newBargin=new BarginStrategyVO();
								newBargin.setNum(Integer.parseInt(numText.getText()));
								newBargin.setDiscount(Double.parseDouble(decreasePriceText.getText()));
								newBargin.setAlOfCommodity(output);
								newBargin.setStartTime(startText.getText());
								newBargin.setLastTime(Integer.parseInt(lastText.getText()));
								billList.addBarginStrategy(newBargin);
								
								//清空信息
								originalTotalPriceText.setText("");
								decreasePriceText.setText("");
								numText.setText("");
								startText.setText("");
								lastText.setText("");
								output.clear();
							}
							else{
								System.out.println("请填写完整策略信息");
							}
							break;
						case ReachStrategy:
							if(strategyTypeCombo.getSelectedItem().toString().equals("赠送赠品")){
								boolean legal=false;
								if(!limitText.getText().equals("")&&
										!startText.getText().equals("")&&
										!lastText.getText().equals("")&&
										output.size()!=0){
									legal=true;
								}
								if(legal){
									ReachStrategyVO newReach=new ReachStrategyVO();
									newReach.setReach_strategy_style(ReachStrategyStyle.Gift);
									newReach.setLimit(Double.parseDouble(limitText.getText()));
									newReach.setAlOfCommodity(output);
									newReach.setStartTime(startText.getText());
									newReach.setLastTime(Integer.parseInt(lastText.getText()));
									billList.addReachStrategy(newReach);
									
									//清空信息
									limitText.setText("");
									startText.setText("");
									lastText.setText("");
									output.clear();
								}
								else{
									System.out.println("请填写完整策略信息");
								}
										
							}
							else if(strategyTypeCombo.getSelectedItem().toString().equals("赠送代金券")){
								boolean legal=false;
								if(!limitText.getText().equals("")&&
										!startText.getText().equals("")&&
										!lastText.getText().equals("")&&
										!couponText.getText().equals("")){
									legal=true;
								}
								if(legal){
									ReachStrategyVO newReach=new ReachStrategyVO();
									newReach.setReach_strategy_style(ReachStrategyStyle.Coupon);
									newReach.setLimit(Double.parseDouble(limitText.getText()));
									newReach.setCouponrate(Double.parseDouble(couponText.getText()));
									newReach.setStartTime(startText.getText());
									newReach.setLastTime(Integer.parseInt(lastText.getText()));
									billList.addReachStrategy(newReach);
									
									//清空信息
									limitText.setText("");
									startText.setText("");
									lastText.setText("");
									couponText.setText("");
								}
								else{
									System.out.println("请填写完整策略信息");
								}
										
							}
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
						addButton.setIcon(add0);
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
}

