package presentation.managerui;

import java.util.ArrayList;

import javax.swing.JPanel;

import vo.AlertBillVO;
import vo.GiftBillVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.SpillsLossBillVO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import businesslogic.BillState;

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
	/*更新板根据数组更新*/
	public void updateJP(){
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
	/*增加赠送单VO数组*/
	public void addGiftBillList(ArrayList<GiftBillVO> gb){

	
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<gb.size();i++){
			JPbillList.add(new JPBill(gb.get(i)));
		}
		//更新到面板上
		updateJP();
	}
	/*增加赠送单*/
	public void addGiftBill(GiftBillVO gb){
		JPbillList.add(new JPBill(gb));
		//更新到面板上
		updateJP();
	}
	/*增加报警单VO数组*/
	public void addAlertBillList(ArrayList<AlertBillVO> ab){

		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<ab.size();i++){
			JPbillList.add(new JPBill(ab.get(i)));
		}
		//更新到面板上
		updateJP();

	}
	/*增加报警单*/
	public void addAlertBill(AlertBillVO ab){
		JPbillList.add(new JPBill(ab));
		//更新到面板上
		updateJP();
	}
	/*增加进货单VO数组*/
	public void addPurSheetList(ArrayList<PurSheetVO> ps){
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<ps.size();i++){
			JPbillList.add(new JPBill(ps.get(i)));
		}
		//更新到面板上
		updateJP();
	}
	/*增加进货单*/
	public void addPurSheet(PurSheetVO ps){
		JPbillList.add(new JPBill(ps));
		//更新到面板上
		updateJP();
	}
	/*增加进货退货单VO数组*/
	public void addPurBackSheetList(ArrayList<PurBackSheetVO> pbs){

		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<pbs.size();i++){
			JPbillList.add(new JPBill(pbs.get(i)));
		}
		//更新到面板上
		updateJP();

	}
	/*增加进货退货单*/
	public void addPurBackSheet(PurBackSheetVO pbs){
		JPbillList.add(new JPBill(pbs));
		//更新到面板上
		updateJP();
	}
	/*增加销售单VO数组*/
	public void addSaleSheetList(ArrayList<SaleSheetVO> ss){
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<ss.size();i++){
			JPbillList.add(new JPBill(ss.get(i)));
		}
		//更新到面板上
		updateJP();
	}
	/*增加销售单*/
	public void addSaleSheet(SaleSheetVO ss){
		JPbillList.add(new JPBill(ss));
		//更新到面板上
		updateJP();
	}
	/*增加销售退货单VO数组*/
	public void addSaleBackSheetList(ArrayList<SaleBackSheetVO> sbs){

		
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<sbs.size();i++){
			JPbillList.add(new JPBill(sbs.get(i)));
		}
		//更新到面板上
		updateJP();

	}
	/*增加销售退货单*/
	public void addSaleBackSheet(SaleBackSheetVO sbs){
		JPbillList.add(new JPBill(sbs));
		//更新到面板上
		updateJP();
	}
	/*增加收款单VO数组*/
	public void addReceiptBillList(ArrayList<ReceiptVO> rb){

		
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<rb.size();i++){
			JPbillList.add(new JPBill(rb.get(i)));
		}
		//更新到面板上
		updateJP();

	}
	/*增加收款单*/
	public void addReceiptBill(ReceiptVO rb){
		JPbillList.add(new JPBill(rb));
		//更新到面板上
		updateJP();
	}
	/*增加付款单VO数组*/
	public void addPaymentBillList(ArrayList<PaymentVO> pb){

		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<pb.size();i++){
			JPbillList.add(new JPBill(pb.get(i)));
		}
		//更新到面板上
		updateJP();


	}
	/*增加付款单*/
	public void addPaymentBill(PaymentVO pb){
		JPbillList.add(new JPBill(pb));
		//更新到面板上
		updateJP();
	}
	/*增加现金费用单VO数组*/
	public void addCashPaymentBillList(ArrayList<CashPaymentVO> spb){

		
		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<spb.size();i++){
			JPbillList.add(new JPBill(spb.get(i)));
		}
		//更新到面板上
		updateJP();
	}
	/*增加现金费用单*/
	public void addCashPaymentBill(CashPaymentVO spb){
		JPbillList.add(new JPBill(spb));
		//更新到面板上
		updateJP();
	}
	/*增加报溢报损单VO数组*/
	public void addSpillsLossBillList(ArrayList<SpillsLossBillVO> slb){

		//遍历单据vo数组把单据加到单据面板数组
		for(int i=0;i<slb.size();i++){
			JPbillList.add(new JPBill(slb.get(i)));
		}
		//更新到面板上
		updateJP();
	}
	/*增加报溢报损单*/
	public void addSpillsLossBill(SpillsLossBillVO slb){
		JPbillList.add(new JPBill(slb));
		//更新到面板上
		updateJP();
	}
	/*删除选中的*/
	public void removeChosen(){

		if(isTheSameState()&&stateOfChosen()==BillState.OVER){//如果是同一个状态且是已处理状态
			for(int i=0;i<JPbillList.size();i++){
				if(JPbillList.get(i).getChoose()){
					JPbillList.remove(i);
					i--;
				}
			}
			//重新加到底板上
			updateJP();
		}
	
		else{
			System.out.println("只有已处理单据能够移除");
		}
	}
	/*修改选中的*/
	public void changeChosen(GiftBillVO gb){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(gb);
				break;
			}
		}
	}
	public void changeChosen(SpillsLossBillVO slb){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(slb);
				break;
			}
		}
	}
	public void changeChosen(AlertBillVO ab){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(ab);
				break;
			}
		}
	}
	public void changeChosen(PurSheetVO ps){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(ps);
				break;
			}
		}
	}
	public void changeChosen(PurBackSheetVO pbs){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(pbs);
				break;
			}
		}
	}
	public void changeChosen(SaleSheetVO ss){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(ss);
				break;
			}
		}
	}
	public void changeChosen(SaleBackSheetVO sbs){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(sbs);
				break;
			}
		}
	}
	public void changeChosen(ReceiptVO rb){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(rb);
				break;
			}
		}
	}
	public void changeChosen(PaymentVO pb){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(pb);
				break;
			}
		}
	}
	public void changeChosen(CashPaymentVO cb){
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				JPbillList.get(i).change(cb);
				break;
			}
		}
	}
	/*通过选中的*/
	public void passChosen(){
		if(getChosenNum()>=1&&isTheSameState()&&stateOfChosen()==BillState.SUBMITED){
			for(int i=0;i<JPbillList.size();i++){
				if(JPbillList.get(i).getChoose()){
					JPbillList.get(i).transformState(BillState.EXAMINED);
				}
			}
		}
		else{
			System.out.println("只有提交状态的单据能够通过审批");
		}
	}
	/*提交选中的*/
	public void submitChosen(){
		if(getChosenNum()>=1&&isTheSameState()&&stateOfChosen()==BillState.DRAFT){
			for(int i=0;i<JPbillList.size();i++){
				if(JPbillList.get(i).getChoose()){
					JPbillList.get(i).transformState(BillState.SUBMITED);
				}
			}
		}
		else{
			System.out.println("只有草稿状态的单据能够提交");
		}
	}
	/*返回被选中的个数*/
	public int getChosenNum(){
		int chosenNum=0;
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				chosenNum++;
			}
		}
		return chosenNum;
	}
	/*选中的单据是否是同一个状态*/
	public boolean isTheSameState(){
		BillState state=null;
		for(int i=0;i<JPbillList.size();i++){
			if(JPbillList.get(i).getChoose()){
				if(state!=null&&JPbillList.get(i).getState()!=state){
					return false;
				}
				state=JPbillList.get(i).getState();
			}
		}
		return true;
	}
	/*返回选中单据的状态*/
	public BillState stateOfChosen(){
		if(isTheSameState()){//如果选中的单据都是同一个状态
			for(int i=0;i<JPbillList.size();i++){
				if(JPbillList.get(i).getChoose()){
					return JPbillList.get(i).getState();
				}
			}
		}
		return null;
		
	}
	/*面板向上移动*/
	public void startUp(){
		stop=false;
		//线程
		Thread t=new Thread(new TreadOfUp());
		//开启线程
		t.start();
	}
	/*面板向下移动*/
	public void startDown(){
		stop=false;
		//线程
		Thread t=new Thread(new TreadOfDown());
		//开启线程
		t.start();
	}
	/*面板停止移动*/
	public void stop(){
		stop=true;
	}

	/*向上移动线程*/
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
	/*向下移动线程*/
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
