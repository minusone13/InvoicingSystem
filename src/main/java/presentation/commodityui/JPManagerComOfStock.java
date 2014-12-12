package presentation.commodityui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogic.BillState;
import businesslogic.Role;
import presentation.commodityui.JPmanageBills2.MouseListenerOfButton;

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
		
		this.add(manageCom,0);
		this.add(addFolder,1);
		this.add(deleteFolder,2);
		this.add(addCom,3);
		this.add(deleteCom,4);
		this.add(editCom,5);
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
				break;
			case 2:
				deleteFolder.setIcon(deleteFolderR);
				manageCom.getContent().removeChosen();
				break;	
			case 3:
				addCom.setIcon(addComR);
				break;
			case 4:
				deleteCom.setIcon(deleteComR);
				manageCom.getCommodities().removeChosen();
				break;
			case 5:
				editCom.setIcon(editComR);
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
	
}
