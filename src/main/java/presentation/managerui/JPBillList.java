package presentation.managerui;

import java.util.ArrayList;

import javax.swing.JPanel;

import vo.GiftBillVO;

public class JPBillList extends JPanel {

	private int length=0;
	public JPBillList(){
		//面板大小
		this.setSize(261, 0);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);

	}
	public void addGiftBill(ArrayList<GiftBillVO> gb){

	
		//遍历数组把单据加上去
		for(int i=length;i<gb.size();i++){
			JPBill temp=new JPBill(gb.get(i));
			temp.setLocation(0, 93*i);
			this.add(temp,i);
		}
		length=length+gb.size()*93;
		//面板大小
		this.setSize(261, length);


	}


}
