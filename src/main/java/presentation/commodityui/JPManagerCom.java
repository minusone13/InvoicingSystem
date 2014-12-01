package presentation.commodityui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JPManagerCom extends JPanel{

	public JPManagerCom(){
		this.setSize(617, 370);
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		JPtreeContent content=new JPtreeContent();
		JPcommodityPack commodities=new JPcommodityPack();
		commodities.addCommodities();
		commodities.update();
		content.setLocation(0, 40);
		commodities.setLocation(150, 40);
		//head
		JPanel head=new JPanel();
		head.setBounds(0, 0, 617, 40);
		head.setLayout(null);
		head.setOpaque(false);

		//head的搜索框
	    JTextField findCom=new JTextField(16);
		findCom.setBounds(417, 5, 150, 30);
		findCom.setOpaque(false);//文本框透明
		findCom.setForeground(Color.white);//前景色
		//搜索标签
		JLabel find=new JLabel("查找：");
		find.setBounds(375, 5, 150, 30);
		find.setForeground(Color.white);
		find.setFont(new Font("宋体",Font.BOLD,14));
		//搜索按钮
		JLabel findIcon=new JLabel();
		findIcon.setIcon(new ImageIcon("src/image/ChooseCom/findIcon.png") );
		findIcon.setBounds(575, 8, 24, 24);
		//head背景
		JLabel bgOfHead=new JLabel();
		bgOfHead.setBounds(0, 0, 617, 40);
		bgOfHead.setIcon(new ImageIcon("src/image/ChooseCom/head.png") );
		//bottom
		JPanel bottom=new JPanel();
		bottom.setBounds(0, 340, 617, 30);
		bottom.setLayout(null);
		bottom.setOpaque(false);
		//bottom背景
		JLabel bgOfBottom=new JLabel();
		bgOfBottom.setBounds(0, 0, 617, 30);
		bgOfBottom.setIcon(new ImageIcon("src/image/ChooseCom/bottom.png") );
		//确认标签
		JLabel comfirm=new JLabel();
		comfirm.setBounds(575, 3, 24, 24);
		comfirm.setIcon(new ImageIcon("src/image/ChooseCom/confirm.png") );
		
		head.add(findCom,0);
		head.add(find,1);
		head.add(findIcon,2);
		head.add(bgOfHead,3);
		
		bottom.add(comfirm,0);
		bottom.add(bgOfBottom,1);
		
		this.add(commodities,0);
		this.add(content,1);
		this.add(head,2);
		this.add(bottom,3);
		
	}
	
}
