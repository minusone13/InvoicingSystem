package presentation.commodityui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.Role;
import presentation.commodityui.JPmanageBills2.JPanelEdit;
import presentation.commodityui.JPmanageBills2.MouseListenerOfButton;
import presentation.commodityui.JPmanageBills2.JPanelEdit.TreadOfLeft;
import presentation.commodityui.JPmanageBills2.JPanelEdit.TreadOfRight;
import presentation.managerui.MouseListenerGetXY;

public class JPManagerComOfStock extends JPanel {

	//商品选择面板
	private JPManagerCom manageCom=new JPManagerCom();
	//处理按钮
	private JLabel addFolder=new JLabel();
	//删除按钮
	private JLabel deleteFolder=new JLabel();
	//编辑按钮
	private JLabel addCom=new JLabel();
	//提交按钮
	private JLabel deleteCom=new JLabel();
	//创建按钮
	private JLabel editCom=new JLabel();
	//商品编辑面板
	JPanelEdit JPeditOfCom=new JPanelEdit();
	//图片
	ImageIcon addFolderW=new ImageIcon("src/image/function/addFolder.png");
	ImageIcon deleteFolderW=new ImageIcon("src/image/function/deleteFolder.png");
	ImageIcon addComW=new ImageIcon("src/image/function/addW.png");
	ImageIcon deleteComW=new ImageIcon("src/image/function/deleteW.png");
	ImageIcon editComW=new ImageIcon("src/image/function/editW.png");
	
	ImageIcon addFolderR=new ImageIcon("src/image/function/addFolderR.png");
	ImageIcon deleteFolderR=new ImageIcon("src/image/function/deleteFolderR.png");
	ImageIcon addComR=new ImageIcon("src/image/function/addR.png");
	ImageIcon deleteComR=new ImageIcon("src/image/function/deleteR.png");
	ImageIcon editComR=new ImageIcon("src/image/function/editR.png");
	public JPManagerComOfStock(){
		//面板大小
		this.setSize(905, 370);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//商品选择面板
		manageCom.setLocation(0, 0);
		manageCom.setRole(Role.STOCK_STAFF);
		manageCom.getComfirm().setVisible(false);
		
		//增加分类功能按钮
		addFolder.setIcon(addFolderW);
		addFolder.setBounds(720, 20, 50, 50);
		addFolder.addMouseListener(new MouseListenerOfButton(1));
		//删除分类功能按钮
		deleteFolder.setIcon(deleteFolderW);
		deleteFolder.setBounds(720, 85, 50, 50);
		deleteFolder.addMouseListener(new MouseListenerOfButton(2));
		//增加商品功能按钮
		addCom.setIcon(addComW);
		addCom.setBounds(720, 150, 50, 50);
		addCom.addMouseListener(new MouseListenerOfButton(3));
		//删除商品功能按钮
		deleteCom.setIcon(deleteComW);
		deleteCom.setBounds(720, 215, 50, 50);
		deleteCom.addMouseListener(new MouseListenerOfButton(4));
		//修改商品功能按钮
		editCom.setIcon(editComW);
		editCom.setBounds(720, 280, 50, 50);
		editCom.addMouseListener(new MouseListenerOfButton(5));
		//编辑面板
		JPeditOfCom.setLocation(905, 36);
		
		this.add(JPeditOfCom,0);
		this.add(manageCom,1);
		this.add(addFolder,2);
		this.add(deleteFolder,3);
		this.add(addCom,4);
		this.add(deleteCom,5);
		this.add(editCom,6);
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
				addFolder.setIcon(addFolderR);
				manageCom.getContent().addTreeNodeToChosen();
				break;
			case 2:
				deleteFolder.setIcon(deleteFolderR);
				manageCom.getContent().removeChosen();
				break;	
			case 3:
				addCom.setIcon(addComR);
				JPeditOfCom.leftMove();
				JPeditOfCom.isAdd=true;
				break;
			case 4:
				deleteCom.setIcon(deleteComR);
				manageCom.getCommodities().removeChosen();
				break;
			case 5:
				editCom.setIcon(editComR);
				if(manageCom.getCommodities().getChosenNum()==1){
					JPeditOfCom.leftMove();
					JPeditOfCom.isAdd=false;
				}
				else if(manageCom.getCommodities().getChosenNum()==0){
					
					System.out.println("请选择要修改的商品");
				}
				else{
					System.out.println("只能同时修改一个商品");
				}
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				addFolder.setIcon(addFolderW);
				break;
			case 2:
				deleteFolder.setIcon(deleteFolderW);
				break;	
			case 3:
				addCom.setIcon(addComW);
				break;
			case 4:
				deleteCom.setIcon(deleteComW);
				break;
			case 5:
				editCom.setIcon(editComW);
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
				addFolder.setIcon(addFolderW);
				break;
			case 2:
				deleteFolder.setIcon(deleteFolderW);
				break;	
			case 3:
				addCom.setIcon(addComW);
				break;
			case 4:
				deleteCom.setIcon(deleteComW);
				break;
			case 5:
				editCom.setIcon(editComW);
				break;
			}
		}
		
	}
	/*编辑栏面板*/
	public class JPanelEdit extends JPanel{
		//判断是加商品还是编辑商品
		private boolean isAdd=true;//默认是加商品
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
		
		//商品编辑栏的附件
		private JLabel name=new JLabel("名称");
		private JLabel type=new JLabel("型号");
		private JLabel num=new JLabel("数量");
		private JLabel inprice=new JLabel("进价");
		private JLabel outprice=new JLabel("售价");
		
		private JTextField nameText=new JTextField(10);
		private JTextField typeText=new JTextField(10);
		private JTextField numText=new JTextField(10);
		private JTextField inpriceText=new JTextField(10);
		private JTextField outpriceText=new JTextField(10);
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
			name.setFont(new Font("宋体",Font.BOLD,14));
			type.setFont(new Font("宋体",Font.BOLD,14));
			num.setFont(new Font("宋体",Font.BOLD,14));
			inprice.setFont(new Font("宋体",Font.BOLD,14));
			outprice.setFont(new Font("宋体",Font.BOLD,14));
			//设置字体颜色
			name.setForeground(Color.white);
			type.setForeground(Color.white);
			num.setForeground(Color.white);
			inprice.setForeground(Color.white);
			outprice.setForeground(Color.white);
			//设置标签大小位置
			name.setBounds(40, 30, 40, 20);
			type.setBounds(40, 60, 40, 20);
			num.setBounds(40, 90, 40, 20);
			inprice.setBounds(40, 120, 40, 20);
			outprice.setBounds(40, 150, 40, 20);
			//商品名文本框
			nameText.setBounds(80,30, 150, 20);
			nameText.setOpaque(false);//文本框透明
			nameText.setForeground(Color.white);//前景色
			//型号文本框
			typeText.setBounds(80,60, 150, 20);
			typeText.setOpaque(false);//文本框透明
			typeText.setForeground(Color.white);//前景色
			//数量文本框
			numText.setBounds(80,90, 150, 20);
			numText.setOpaque(false);//文本框透明
			numText.setForeground(Color.white);//前景色
			//进价文本框
			inpriceText.setBounds(80,120, 150, 20);
			inpriceText.setOpaque(false);//文本框透明
			inpriceText.setForeground(Color.white);//前景色
			//售价文本框
			outpriceText.setBounds(80,150, 150, 20);
			outpriceText.setOpaque(false);//文本框透明
			outpriceText.setForeground(Color.white);//前景色
			
			this.add(right,0);
			this.add(confirm,1);
			this.add(name,2);
			this.add(inprice,3);
			this.add(type,4);
			this.add(num,5);
			this.add(outprice,6);
			this.add(nameText,7);
			this.add(typeText,8);
			this.add(numText,9);
			this.add(inpriceText,10);
			this.add(outpriceText,11);
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
					
					break;
				case 3:
					confirm.setIcon(confirm1);
					//生成商品
					
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
	
}
