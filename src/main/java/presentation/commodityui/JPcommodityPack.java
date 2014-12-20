package presentation.commodityui;

import java.awt.Dimension;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import po.RM;
import vo.stockvo.CommodityVO;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.commodityblservice.StubCommodityBlService;
import data.commoditydata.StubStockDataController;
/**
 * 显示子节点商品的板块
 * @author wyc
 *
 */
public class JPcommodityPack extends JPanel {

	private JScrollPane SCR;
	private JPanel pack=null;
	private ArrayList<JPcommodity> commodities=new ArrayList<JPcommodity>();
	private JPManagerCom JPmanagerCom;
	private ArrayList<CommodityVO> output=new ArrayList<CommodityVO>();
	private ArrayList<String> outputNotes=new ArrayList<String>();
	//逻辑层接口
	private StubCommodityBlService stockbl=new StubStockController();
	public JPcommodityPack(){
		//逻辑层接口
		StockManagerDriver smd=new StockManagerDriver();
		try
		{
			smd.start(stockbl,StubStockDataController.getInstance());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setSize(467, 300);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		JLabel back=new JLabel();
		back.setIcon(new ImageIcon("src/image/ChooseCom/back.png"));
		back.setBounds(0, 0, 467, 300);
		
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
		
		pack.setSize(450,20+lines*110);
		//scrollPane是根据里面的子控件的preferredSize来确定滚动条的
		pack.setPreferredSize(new Dimension(450,20+lines*110));
		int num=0;
		for(int i=0;i<lines;i++){
			for(int j=0;j<5;j++){
				//传递引用
				commodities.get(num).setJPmanagerCom(JPmanagerCom);
				commodities.get(num).setLocation(j*90, 20+i*110);
				pack.add(commodities.get(num),num);
				num++;
				if(num==commodities.size()){
					break;
				}
			}
		}
		SCR.setViewportView(pack);
	}
	/*增加一系列商品*/
	public void addCommodities(ArrayList<CommodityVO> coms){
		for(CommodityVO temp:coms){
			commodities.add(new JPcommodity(temp));
		}
		update();
		
	}
	/*增加商品*/
	public void addCommodity(CommodityVO com){
		//用接口过逻辑层一遍
		
		commodities.add(new JPcommodity(com));
		//增加商品
		JPmanagerCom.getFrame().getWarning().showWarning("增加商品");
		update();
	}
	/*返回唯一选中的商品的VO*/
	public CommodityVO getChosen(){
		if(getChosenNum()==1){
			for(JPcommodity temp:commodities){
				if(temp.isChosen()){
					return temp.getCommodity();
				}
			}
		}
		return null;
		
	}
	/*将选中的商品加到输出数组中*/
	public void addToOutput(){
		ArrayList<CommodityVO> temp1=getAllChosen();
		ArrayList<String> temp2=getAllChosenNotes();
		if(temp1!=null){
			for(int i=0;i<temp1.size();i++){
				output.add(temp1.get(i));//商品输出
				outputNotes.add(temp2.get(i));//备注输出
			}
		}
	}
	public ArrayList<CommodityVO> getOutput() {
		return output;
	}
	public void setOutput(ArrayList<CommodityVO> output) {
		this.output = output;
	}
	/*返回选中的商品的备注*/
	public ArrayList<String> getAllChosenNotes(){
		if(getChosenNum()>=1){
			ArrayList<String> result=new ArrayList<String>();
			for(JPcommodity temp:commodities){
				if(temp.isChosen()){
					result.add(temp.getNote());
				}
			}
			return result;
		}
		else{
			JPmanagerCom.getFrame().getWarning().showWarning("没有选择任何商品");
		}
		return null;
	}
	/*返回选中的商品*/
	public ArrayList<CommodityVO> getAllChosen(){
		if(getChosenNum()>=1){
			ArrayList<CommodityVO> result=new ArrayList<CommodityVO>();
			for(JPcommodity temp:commodities){
				if(temp.isChosen()){
					result.add(temp.getCommodity());
				}
			}
			return result;
		}
		else{
			JPmanagerCom.getFrame().getWarning().showWarning("没有选择任何商品");
		}
		return null;
	}
	/*删除选中的商品*/
	public void removeChosen(){
		if(getChosenNum()>=1){
			for(int i=0;i<commodities.size();i++){
				if(commodities.get(i).isChosen()){
					//删除逻辑层
					RM rm=stockbl.deleteCommodity(commodities.get(i).getCommodity().getName(), commodities.get(i).getCommodity().getModel());
					if(rm==RM.done){
						JPmanagerCom.getFrame().getWarning().showWarning("已成功删除");
						//删除界面层
						commodities.remove(commodities.get(i));
					}
					else{
						JPmanagerCom.getFrame().getWarning().showWarning("删除失败，已有进出记录");
					}
					
				
					i--;
				}
			}
			update();
		}
		else{
			JPmanagerCom.getFrame().getWarning().showWarning("请选择你要删除的商品");
		}
	
	}
	
	/*返回选中商品的数量*/
	public int getChosenNum(){
		int i=0;
		for(JPcommodity temp:commodities){
			if(temp.isChosen()){
				i++;
			}
		}
		return i;
	}
	/*修改选中的商品*/
	public void changeChosen(CommodityVO vo){
		if(getChosenNum()==1){//如果只选中了一个商品
			for(JPcommodity temp:commodities){
				if(temp.isChosen()){
					temp.change(vo);
				}
			}
		}
		else if(getChosenNum()==0){
			JPmanagerCom.getFrame().getWarning().showWarning("请选择你要修改的商品");
		}
		else{
			JPmanagerCom.getFrame().getWarning().showWarning("只能同时修改一个商品");
		}
		
	}
	public ArrayList<JPcommodity> getCommodities() {
		return commodities;
	}
	public void setCommodities(ArrayList<JPcommodity> commodities) {
		this.commodities = commodities;
	}

	public static void main(String[] args) {
	}
	public JPManagerCom getJPmanagerCom() {
		return JPmanagerCom;
	}
	public void setJPmanagerCom(JPManagerCom jPmanagerCom) {
		JPmanagerCom = jPmanagerCom;
	}
	public ArrayList<String> getOutputNotes() {
		return outputNotes;
	}
	public void setOutputNotes(ArrayList<String> outputNotes) {
		this.outputNotes = outputNotes;
	}
}
