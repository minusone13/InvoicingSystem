package presentation.managerui;

import java.util.ArrayList;

import javax.swing.JPanel;

import vo.AlertBillVO;
import vo.CashPaymentVO;
import vo.GiftBillVO;
import vo.PaymentVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.ReceiptVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.SpillsLossBillVO;

public class JPBillList extends JPanel {

	//板块的长度，单位个（单据）
	private int length=0;
	//控制移动
	private boolean stop=true;

	//板块移动的纵坐标
	private int y=0;
	//单据面板数组
	ArrayList<JPBill> JPbillList=new ArrayList<JPBill>();
	//更新板
	JPanel JPupdate=null;
	public JPBillList(){
		//面板大小
		this.setSize(261, 0);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	

	}
	/*将数组中的面板加到底板上*/
	public void addJPbillList(){
		if(JPupdate==null){
			JPupdate=new JPanel();
			//面板大小
			JPupdate.setSize(261, JPbillList.size()*93);
			//设置布局
			JPupdate.setLayout(null);
			//设置面板透明
			JPupdate.setOpaque(false);
		}
		else{
			this.remove(JPupdate);
			
			JPupdate=new JPanel();
			//面板大小
			JPupdate.setSize(261, JPbillList.size()*93);
			//设置布局
			JPupdate.setLayout(null);
			//设置面板透明
			JPupdate.setOpaque(false);
		}
		for(int i=0;i<JPbillList.size();i++){
			JPbillList.get(i).setLocation(0, 93*i);
			JPupdate.add(JPbillList.get(i),i);
		}
		//面板大小
		this.setSize(261, JPbillList.size()*93);
		//把更新板加到底板上
		this.add(JPupdate);
	}
	/*增加赠送单*/
	public void addGiftBill(ArrayList<GiftBillVO> gb){

	
		//遍历单据vo数组把单据加到单据面板数组
		System.out.println("gb:"+gb.size());
		for(int i=0;i<gb.size();i++){
			JPbillList.add(new JPBill(gb.get(i)));
		}
		addJPbillList();
	
	

	}
	/*增加报警单*/
	public void addAlertBill(ArrayList<AlertBillVO> ab){

		
		//遍历数组把单据加上去
		for(int i=length;i<ab.size();i++){
			JPBill temp=new JPBill(ab.get(i));
			temp.setLocation(0, 93*i);
			this.add(temp,i);
		}
		length=length+ab.size()*93;
		//面板大小
		this.setSize(261, length);


	}
	/*增加进货单*/
	public void addPurSheet(ArrayList<PurSheetVO> ps){

		
		//遍历数组把单据加上去
		for(int i=length;i<ps.size();i++){
			JPBill temp=new JPBill(ps.get(i));
			temp.setLocation(0, 93*i);
			this.add(temp,i);
		}
		length=length+ps.size()*93;
		//面板大小
		this.setSize(261, length);


	}
	/*增加进货退货单*/
	public void addPurBackSheet(ArrayList<PurBackSheetVO> pbs){

		
		//遍历数组把单据加上去
		for(int i=length;i<pbs.size();i++){
			JPBill temp=new JPBill(pbs.get(i));
			temp.setLocation(0, 93*i);
			this.add(temp,i);
		}
		length=length+pbs.size()*93;
		//面板大小
		this.setSize(261, length);


	}
	/*增加销售单*/
	public void addSaleSheet(ArrayList<SaleSheetVO> ss){

		
		//遍历数组把单据加上去
		for(int i=length;i<ss.size();i++){
			JPBill temp=new JPBill(ss.get(i));
			temp.setLocation(0, 93*i);
			this.add(temp,i);
		}
		length=length+ss.size()*93;
		//面板大小
		this.setSize(261, length);


	}
	/*增加销售退货单*/
	public void addSaleBackSheet(ArrayList<SaleBackSheetVO> sbs){

		
		//遍历数组把单据加上去
		for(int i=length;i<sbs.size();i++){
			JPBill temp=new JPBill(sbs.get(i));
			temp.setLocation(0, 93*i);
			this.add(temp,i);
		}
		length=length+sbs.size()*93;
		//面板大小
		this.setSize(261, length);


	}
	/*增加收款单*/
	public void addReceiptBill(ArrayList<ReceiptVO> rb){

		
		//遍历数组把单据加上去
		for(int i=length;i<rb.size();i++){
			JPBill temp=new JPBill(rb.get(i));
			temp.setLocation(0, 93*i);
			this.add(temp,i);
		}
		length=length+rb.size()*93;
		//面板大小
		this.setSize(261, length);


	}
	/*增加报溢报损单*/
	public void addPaymentBill(ArrayList<PaymentVO> pb){

		
		//遍历数组把单据加上去
		for(int i=length;i<pb.size();i++){
			JPBill temp=new JPBill(pb.get(i));
			temp.setLocation(0, 93*i);
			this.add(temp,i);
		}
		length=length+pb.size()*93;
		//面板大小
		this.setSize(261, length);


	}
	/*增加报溢报损单*/
	public void addCashPaymentBill(ArrayList<CashPaymentVO> spb){

		
		//遍历数组把单据加上去
		for(int i=length;i<spb.size();i++){
			JPBill temp=new JPBill(spb.get(i));
			temp.setLocation(0, 93*i);
			this.add(temp,i);
		}
		length=length+spb.size()*93;
		//面板大小
		this.setSize(261, length);


	}
	/*增加报溢报损单*/
	public void addSpillsLossBill(ArrayList<SpillsLossBillVO> slb){

		
		//遍历数组把单据加上去
		for(int i=length;i<slb.size();i++){
			JPBill temp=new JPBill(slb.get(i));
			temp.setLocation(0, 93*i);
			this.add(temp,i);
		}
		length=length+slb.size()*93;
		//面板大小
		this.setSize(261, length);


	}
	/*删除选中的*/
	public void removeChosen(){

		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.remove(i);
				i--;
			}
		}
		//重新加到底板上
		addJPbillList();
	}
	public void startUp(){
		stop=false;
		//线程
		Thread t=new Thread(new TreadOfUp());
		//开启线程
		t.start();
	}
	public void startDown(){
		stop=false;
		//线程
		Thread t=new Thread(new TreadOfDown());
		//开启线程
		t.start();
	}
	public void stop(){
		stop=true;
	}

	public class TreadOfUp implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			
			while(!stop){
				y-=10;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JPBillList.this.setLocation(0, y);
			}
		}

		
	}
	public class TreadOfDown implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			
			while(!stop){
				y+=10;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JPBillList.this.setLocation(0, y);
			}
		}

		
	}

}
