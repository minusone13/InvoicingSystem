package presentation.commodityui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 * 显示子节点商品的板块
 * @author wyc
 *
 */
public class JPcommodityPack extends JPanel {

	private JScrollPane SCR;
	private JPanel pack=null;
	private ArrayList<JPcommodity> commodities=new ArrayList<JPcommodity>();
	public JPcommodityPack(){
		this.setSize(467, 300);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		JLabel back=new JLabel();
		back.setIcon(new ImageIcon("src/image/ChooseCom/back.png"));
		back.setBounds(0, 0, 450, 300);
		
		SCR = new JScrollPane();
		SCR.setBounds(0, 0, 467, 300);
		SCR.setOpaque(false);//设置透明
		SCR.getViewport().setOpaque(false);//设置透明
		SCR.setBorder(null);
		add(SCR,0);
		add(back,1);
	}
	/*刷新面板*/
	public void update(){
		
		if(pack!=null){
			SCR.remove(pack);
		}
		pack=new JPanel();
		pack.setLayout(null);
		pack.setOpaque(false);
		
		int lines=(int)Math.ceil(commodities.size()/5.0);//行数
		
		pack.setSize(450,20+lines*125);
		//scrollPane是根据里面的子控件的preferredSize来确定滚动条的
		pack.setPreferredSize(new Dimension(450,20+lines*125));
		int num=0;
		for(int i=0;i<lines;i++){
			for(int j=0;j<5;j++){
				commodities.get(num).setLocation(j*90, 20+i*125);
				pack.add(commodities.get(num),num);
				num++;
				if(num==commodities.size()){
					break;
				}
			}
		}
		SCR.setViewportView(pack);
	}
	public void addCommodities(){
		JPcommodity com1=new JPcommodity("公牛日光灯","dsfsd",10);
		JPcommodity com2=new JPcommodity("母牛日光灯","dsfsd",10);
		JPcommodity com3=new JPcommodity("母猪日光灯","dsfsd",10);
		JPcommodity com4=new JPcommodity("光灯日母猪","dsfsd",10);
		JPcommodity com5=new JPcommodity("公牛日母猪","dsfsd",10);
		JPcommodity com6=new JPcommodity("我去你妈的","dsfsd",10);
		JPcommodity com7=new JPcommodity("公牛日光灯","dsfsd",10);
		JPcommodity com8=new JPcommodity("母牛日光灯","dsfsd",10);
		JPcommodity com9=new JPcommodity("母猪日光灯","dsfsd",10);
		JPcommodity com10=new JPcommodity("光灯日母猪","dsfsd",10);
		JPcommodity com11=new JPcommodity("公牛日母猪","dsfsd",10);
		JPcommodity com12=new JPcommodity("我去你妈的","dsfsd",10);
		JPcommodity com13=new JPcommodity("公牛日光灯","dsfsd",10);
		JPcommodity com14=new JPcommodity("母牛日光灯","dsfsd",10);
		JPcommodity com15=new JPcommodity("母猪日光灯","dsfsd",10);
		JPcommodity com16=new JPcommodity("光灯日母猪","dsfsd",10);
		JPcommodity com17=new JPcommodity("公牛日母猪","dsfsd",10);
		JPcommodity com18=new JPcommodity("我去你妈的","dsfsd",10);
		JPcommodity com19=new JPcommodity("公牛日光灯","dsfsd",10);
		JPcommodity com20=new JPcommodity("母牛日光灯","dsfsd",10);
		JPcommodity com21=new JPcommodity("母猪日光灯","dsfsd",10);
		JPcommodity com22=new JPcommodity("光灯日母猪","dsfsd",10);
		JPcommodity com23=new JPcommodity("公牛日母猪","dsfsd",10);
		JPcommodity com24=new JPcommodity("我去你妈的","dsfsd",10);
		
		commodities.add(com1);
		commodities.add(com2);
		commodities.add(com3);
		commodities.add(com4);
		commodities.add(com5);
		commodities.add(com6);
		commodities.add(com7);
		commodities.add(com8);
		commodities.add(com9);
		commodities.add(com10);
		commodities.add(com11);
		commodities.add(com12);
		commodities.add(com13);
		commodities.add(com14);
		commodities.add(com15);
		commodities.add(com16);
		commodities.add(com17);
		commodities.add(com18);
		commodities.add(com19);
		commodities.add(com20);
		commodities.add(com21);
		commodities.add(com22);
		commodities.add(com23);
		commodities.add(com24);
		
	}
	public void addCommodity(){
		
	}
	public static void main(String[] args) {
	}
}
