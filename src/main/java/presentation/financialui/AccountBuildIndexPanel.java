package presentation.financialui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import presentation.PanelType;
import entrance.Frame;

public class AccountBuildIndexPanel extends JPanel{
	private JLabel clientInfo = new JLabel("New label");
	private JLabel commodityInfo = new JLabel("New label");
	private JLabel accountInfo = new JLabel("New label");
	private JLabel buildButton = new JLabel("New label");
	//图片
	ImageIcon clientInfoIcon0=new ImageIcon("src\\image\\accountUI\\客户信息图标0.png");
	ImageIcon commodityInfoIcon0=new ImageIcon("src\\image\\accountUI\\商品信息图标0.png");
	ImageIcon accountInfoIcon0=new ImageIcon("src\\image\\accountUI\\账户信息图标0.png");
	ImageIcon buildIcon0 = new ImageIcon("src\\image\\accountUI\\建账图标灰.png");
	
	ImageIcon clientInfoIcon=new ImageIcon("src\\image\\accountUI\\客户信息图标.png");
	ImageIcon commodityInfoIcon=new ImageIcon("src\\image\\accountUI\\商品信息图标.png");
	ImageIcon accountInfoIcon=new ImageIcon("src\\image\\accountUI\\账户信息图标.png");
	ImageIcon buildIcon = new ImageIcon("src\\image\\accountUI\\建账图标.png");
	
	ImageIcon clientInfoIcon1=new ImageIcon("src\\image\\accountUI\\客户信息图标1.png");
	ImageIcon commodityInfoIcon1=new ImageIcon("src\\image\\accountUI\\商品信息图标1.png");
	ImageIcon accountInfoIcon1=new ImageIcon("src\\image\\accountUI\\账户信息图标1.png");
	
	//frame的引用
    Frame frame;
	public AccountBuildIndexPanel() {
		initial();
	}
	//初始化
	 public void getFrame( Frame f){
 		frame=f;
	 }
	private void initial() {
		//panel初始化
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, 960, 600);
		//背景
		JLabel bg = new JLabel("New label");
		bg.setIcon(new ImageIcon("src\\image\\passBill\\passBillBlock1.png"));
		bg.setBounds(55, 233, 445, 330);
		//label初始化
		this.add(clientInfo,0);
		clientInfo.setBounds(65, 248, 100, 100);
		clientInfo.setIcon(clientInfoIcon0);
		clientInfo.addMouseListener(new MouseListenOfButton(21));
		//label初始化
		this.add(commodityInfo,1);
		commodityInfo.setBounds(170, 248, 100, 100);
		commodityInfo.setIcon(commodityInfoIcon0);
		commodityInfo.addMouseListener(new MouseListenOfButton(22));
		//label初始化
		this.add(accountInfo,2);
		accountInfo.setBounds(275, 248, 100, 100);
		accountInfo.setIcon(accountInfoIcon0);
		accountInfo.addMouseListener(new MouseListenOfButton(23));
		
		this.add(buildButton,3);
		buildButton.setBounds(800, 450, 50, 50);
		buildButton.setIcon(buildIcon0);
		buildButton.addMouseListener(new MouseListenOfButton(24));
		
		this.add(bg,4);
	}
	
	public class MouseListenOfButton implements MouseListener{

		private int num;
		public MouseListenOfButton(int N){
			num=N;
		}
		public void mouseClicked(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			switch(num){
			case 21:clientInfo.setIcon(clientInfoIcon1);
				break;
			case 22:commodityInfo.setIcon(commodityInfoIcon1);
				break;
			case 23:accountInfo.setIcon(accountInfoIcon1);
				break;
			case 24:buildButton.setLocation(803,450);
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			switch(num){
			case 21:
				clientInfo.setIcon(clientInfoIcon);
				AccountBuildIndexPanel.this.setVisible(false);
				frame.getFinancial().getAccountInfomation().update(1);
				frame.getFinancial().getAccountInfomation().setVisible(true);
				//标记当前面板，用于后退按钮
				frame.getFinancial().setPanelType(PanelType.InitialInfoPanel);
				break;
			case 22:commodityInfo.setIcon(commodityInfoIcon);
				//标记当前面板，用于后退按钮
				frame.getFinancial().setPanelType(PanelType.InitialInfoPanel);
				break;
			case 23:accountInfo.setIcon(accountInfoIcon);
				AccountBuildIndexPanel.this.setVisible(false);
				frame.getFinancial().getAccountInfomation().update(2);
				frame.getFinancial().getAccountInfomation().setVisible(true);
				//标记当前面板，用于后退按钮
				frame.getFinancial().setPanelType(PanelType.InitialInfoPanel);
				break;
			case 24:buildButton.setLocation(800,450);
					//buildButton.setIcon(buildIcon);	
					break;
			}
		}

		public void mouseEntered(MouseEvent e) {
			switch(num){
			case 21:clientInfo.setIcon(clientInfoIcon);
				break;
			case 22:commodityInfo.setIcon(commodityInfoIcon);
				break;
			case 23:accountInfo.setIcon(accountInfoIcon);
				break;
			case 24:
					buildButton.setIcon(buildIcon);
				break;
			}
		}

		public void mouseExited(MouseEvent e) {
			switch(num){
			case 21:clientInfo.setIcon(clientInfoIcon0);
				break;
			case 22:commodityInfo.setIcon(commodityInfoIcon0);
				break;
			case 23:accountInfo.setIcon(accountInfoIcon0);
				break;
			case 24:buildButton.setLocation(800,450);
					buildButton.setIcon(buildIcon0);
				break;
			}
		}
		
	}
}
