package presentation.commodityui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;







import businesslogic.commoditybl.CommodityListbl;
import businesslogic.financialbl.Financial;
//import dataservice.commoditydataservice.StubCommodityDataService;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.commodityblservice.StubCommodityBlService;
import businesslogicservice.financialblservice.FinancialBlService;
import entrance.Frame;
import po.Role;
import presentation.PanelType;
import presentation.financialui.InitialInfoPanel.versionItemListener;
import presentation.managerui.MouseListenerGetXY;
import vo.stockvo.CommodityVO;

public class JPManagerCom extends JPanel{

	//树状结果目录
	private JPtreeContent content=new JPtreeContent();
	//商品显示面板
	private JPcommodityPack commodities=new JPcommodityPack();
	//head
	private JPanel head=new JPanel();
	//head的搜索框
	private JTextField findCom=new JTextField(16);
    //bottom
	private JPanel bottom=new JPanel();
	//标记是谁用商品选择面板
	private Role role;
	//确认
	private JLabel comfirm;
	//查询
	private JLabel findIcon;
	//查询
	private JLabel addIcon;
	//查询
	private JTextField detail=new JTextField(16);
	//frame的引用
	private Frame frame;
	//逻辑层接口
	private StubCommodityBlService stockbl=new StubStockController();
	private FinancialBlService financial = new Financial();
	//财务人员期初建账的附件
	
	private JComboBox box;
	
	public JPManagerCom(){
		//逻辑层接口
		StockManagerDriver smd=new StockManagerDriver();
		
		/*try
		{
			smd.start(stockbl,(StubCommodityDataService)Naming.lookup("rmi://127.0.0.1:1099/StubStockDataController"));
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (NotBoundException e)
		{
			e.printStackTrace();
		}*/
		this.setSize(617, 370);
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		
		content.setLocation(0, 40);
		commodities.setLocation(150, 40);
		//传递引用
		content.setJPmanagerCom(this);
		commodities.setJPmanagerCom(this);
		
		head.setBounds(0, 0, 617, 40);
		head.setLayout(null);
		head.setOpaque(false);

		
		findCom.setBounds(417, 5, 150, 30);
		findCom.setOpaque(false);//文本框透明
		findCom.setForeground(Color.white);//前景色
		//搜索标签
		JLabel find=new JLabel("查找：");
		find.setBounds(375, 5, 150, 30);
		find.setForeground(Color.white);
		find.setFont(new Font("宋体",Font.BOLD,14));
		//搜索按钮
		findIcon=new JLabel();
		findIcon.setIcon(new ImageIcon("src/image/ChooseCom/littleScan.png") );
		findIcon.setBounds(575, 8, 24, 24);
		findIcon.addMouseListener(new MouseListenerOfButton(1));
		//head背景
		JLabel bgOfHead=new JLabel();
		bgOfHead.setBounds(0, 0, 617, 40);
		bgOfHead.setIcon(new ImageIcon("src/image/ChooseCom/head.png") );
		
		bottom.setBounds(0, 340, 617, 30);
		bottom.setLayout(null);
		bottom.setOpaque(false);
		//bottom背景
		JLabel bgOfBottom=new JLabel();
		bgOfBottom.setBounds(0, 0, 617, 30);
		bgOfBottom.setIcon(new ImageIcon("src/image/ChooseCom/bottom.png") );
		//确认标签
		comfirm=new JLabel();
		comfirm.setBounds(575, 3, 24, 24);
		comfirm.setIcon(new ImageIcon("src/image/ChooseCom/confirm.png") );
		comfirm.addMouseListener(new MouseListenerOfButton(2));
		//add按钮
		addIcon=new JLabel();
		addIcon.setBounds(545, 3, 24, 24);
		addIcon.setIcon(new ImageIcon("src/image/function/littleAddW.png") );
		addIcon.addMouseListener(new MouseListenerOfButton(3));
		//期初建账版本选择
		box = new JComboBox();
		box.setBounds(10,10, 120, 20);
		box.setForeground(Color.white);
		box.setBackground(Color.black);
		updateVersion();
		
		box.setEditable(false);
		box.setVisible(false);
		box.addItemListener(new versionItemListener());
		
		detail.setBounds(15, 5, 550, 20);
		detail.setOpaque(false);//文本框透明
		detail.setBorder(null);
		detail.setForeground(Color.white);//前景色
		detail.setFont(new Font("宋体",Font.BOLD,14));
		
		head.add(findCom,0);
		head.add(find,1);
		head.add(findIcon,2);
		head.add(box,3);
		head.add(bgOfHead,4);
		
		bottom.add(comfirm,0);
		bottom.add(addIcon,1);
		bottom.add(detail,2);
		bottom.add(bgOfBottom,3);
		
		this.add(commodities,0);
		this.add(content,1);
		this.add(head,2);
		this.add(bottom,3);
		this.addMouseListener(new MouseListenerGetXY());
	}
	public class versionItemListener implements ItemListener {

		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				String s = e.getItem().toString();
				stockbl.setFilePath("accountBuild/commodity/"+s+".ser");
				System.out.println("accountBuild/commodity/"+s+".ser");
				content.innitial();
			}
		}
	}
	public void updateVersion(){
		box.removeAllItems();
		ArrayList<String> versions = financial.getVersions();
		if(versions==null) versions = new ArrayList<String>();
		int size = versions.size();
		for(int i=0;i<size;i++){
			box.addItem(versions.get(i));
		}
	}
	/*获取frame的引用*/
	public void getFrame( Frame f){
  		frame=f;
	}
	/*底部显示信息*/
	public void showDetail(String s){
		detail.setText(s);
	}
	public JPtreeContent getContent() {
		return content;
	}
	public void setContent(JPtreeContent content) {
		this.content = content;
	}
	public JPcommodityPack getCommodities() {
		return commodities;
	}
	public void setCommodities(JPcommodityPack commodities) {
		this.commodities = commodities;
	}
	public class MouseListenerOfButton implements MouseListener{
		private int num;//1、查询 2、确认 3、add
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
				findIcon.setIcon(new ImageIcon("src/image/function/littleScanR.png") );
				break;
			case 2:
				comfirm.setIcon(new ImageIcon("src/image/function/confirmR.png") );
				break;
			case 3:
				addIcon.setIcon(new ImageIcon("src/image/function/littleAddR.png") );
				break;
			}
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				findIcon.setIcon(new ImageIcon("src/image/ChooseCom/littleScan.png") );
				if(!findCom.getText().equals("")){
					//模糊查找商品
					ArrayList<CommodityVO> comFound=stockbl.fuzzyFindCommodity(findCom.getText(), 1);
					//将商品显示
					commodities.getCommodities().clear();
					commodities.addCommodities(comFound);
				}
				else{
					frame.getWarning().showWarning("请输入查找关键字");
				}
				break;
			case 2:
				comfirm.setIcon(new ImageIcon("src/image/ChooseCom/confirm.png") );
				//根据权限加商品到不同的地方
				switch(role){
				case MANAGER:
					//输出商品到编辑面板
					ArrayList<CommodityVO> temp=new ArrayList<CommodityVO>();
					for(CommodityVO vo:commodities.getOutput()){
						temp.add(vo);
					}
					if(frame.getManager().getPanelType()==PanelType.JPmanagerStrategy2){
						switch(frame.getManager().getManagerStrategy2().getStyle()){
							case LevelStrategy:
								frame.getManager().getManagerStrategy2().getJPeditOfLevel().setOutput(temp);
								break;
							case BarginStrategy:
								frame.getManager().getManagerStrategy2().getJPeditOfBargin().setOutput(temp);
								//自动计算总价
								Double total=0.0;
								for(int i=0;i<temp.size();i++){
									total+=temp.get(i).getOut()*temp.get(i).getNumber();
								}
								frame.getManager().getManagerStrategy2().getJPeditOfBargin().getOriginalTotalPriceText().setText(String.valueOf(total));
								break;
							case ReachStrategy:
								frame.getManager().getManagerStrategy2().getJPeditOfReach().setOutput(temp);
								break;
							}
					}
					else if(frame.getManager().getPanelType()==PanelType.JPpassBill2){
						frame.getManager().getPassbill2().getJPeditOfGift().setOutput(temp);
					}
					
					//清除选择痕迹
					commodities.getOutput().clear();
					commodities.getCommodities().clear();
					commodities.update();
					break;
				case PURCHASE_SALE_STAFF:
					//输出商品到编辑面板
					ArrayList<CommodityVO> temp2=new ArrayList<CommodityVO>();
					for(CommodityVO vo:commodities.getOutput()){
						temp2.add(vo);
					}
					ArrayList<String> tempNotes=new ArrayList<String>();
					for(String str:commodities.getOutputNotes()){
						tempNotes.add(str);
					}
					//自动计算总进价
					Double total=0.0;
					for(int i=0;i<temp2.size();i++){
						total+=temp2.get(i).getIn()*temp2.get(i).getNumber();
					}
					//自动计算总售价
					Double total2=0.0;
					for(int i=0;i<temp2.size();i++){
						total2+=temp2.get(i).getOut()*temp2.get(i).getNumber();
					}
					//如果是总经理审批时修改单据
					if(CommodityListbl.user.getR()==Role.MANAGER){
						frame.getManager().getPassbill2().getJPeditOfPur().setOutput(temp2);
						frame.getManager().getPassbill2().getJPeditOfPur().setOutputNotes(tempNotes);
						frame.getManager().getPassbill2().getJPeditOfPur().getTotalText().setText(String.valueOf(total));
					}
					//如果是进销人员制定修改单据
					else if(CommodityListbl.user.getR()==Role.PURCHASE_SALE_STAFF
							||CommodityListbl.user.getR()==Role.PURCHASE_SALE_MANAGER){
						switch(frame.getSale().getManageBills2().getStyle()){
							case PurSheet:
								frame.getSale().getManageBills2().getJPeditOfPur().setOutput(temp2);
								frame.getSale().getManageBills2().getJPeditOfPur().setOutputNotes(tempNotes);
								frame.getSale().getManageBills2().getJPeditOfPur().getTotalText().setText(String.valueOf(total));
								break;
							case PurBackSheet:
								frame.getSale().getManageBills2().getJPeditOfPurBack().setOutput(temp2);
								frame.getSale().getManageBills2().getJPeditOfPurBack().setOutputNotes(tempNotes);
								frame.getSale().getManageBills2().getJPeditOfPurBack().getTotalText().setText(String.valueOf(total));
								break;
							case SaleSheet:
								frame.getSale().getManageBills2().getJPeditOfSale().setOutput(temp2);
								frame.getSale().getManageBills2().getJPeditOfSale().setOutputNotes(tempNotes);
								frame.getSale().getManageBills2().getJPeditOfSale().getTotalText().setText(String.valueOf(total2));
								break;
							case SaleBackSheet:
								frame.getSale().getManageBills2().getJPeditOfSaleBack().setOutput(temp2);
								frame.getSale().getManageBills2().getJPeditOfSaleBack().setOutputNotes(tempNotes);
								frame.getSale().getManageBills2().getJPeditOfSaleBack().getTotalText().setText(String.valueOf(total2));
								break;
							}
					}
					
					//清除选择痕迹
					commodities.getOutput().clear();
					commodities.getCommodities().clear();
					commodities.update();
					break;
				case STOCK_STAFF:
					//获取选择的商品
					CommodityVO temp3=commodities.getChosen();
					frame.getStock().getManageBills2().getJPeditOfSpoil().setChosenVO(temp3);
					frame.getStock().getManageBills2().getJPeditOfSpoil().getCommodityText().setText(temp3.getName());
					frame.getStock().getManageBills2().getJPeditOfSpoil().getTypeText().setText(temp3.getModel());
					//清除选择痕迹
					commodities.getCommodities().clear();
					commodities.update();
					break;
				}
			
				
				//隐藏商品选择界面
				JPManagerCom.this.setVisible(false);
				break;
			case 3:
				addIcon.setIcon(new ImageIcon("src/image/function/littleAddW.png") );
				//加选择的商品到输出
				commodities.addToOutput();
				frame.getWarning().showWarning("已添加到打包中");
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
				findIcon.setIcon(new ImageIcon("src/image/ChooseCom/littleScan.png") );
				break;
			case 2:
				comfirm.setIcon(new ImageIcon("src/image/ChooseCom/confirm.png") );
				break;
			case 3:
				addIcon.setIcon(new ImageIcon("src/image/function/littleAddW.png") );
				break;
			}
		}
	}
	public JLabel getComfirm() {
		return comfirm;
	}
	public void setComfirm(JLabel comfirm) {
		this.comfirm = comfirm;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
		if(role==Role.FINANCIAL_STAFF){
			box.setVisible(true);
		}
	}

	public JLabel getAddIcon() {
		return addIcon;
	}
	public void setAddIcon(JLabel addIcon) {
		this.addIcon = addIcon;
	}
	public JPanel getHead() {
		return head;
	}
	public void setHead(JPanel head) {
		this.head = head;
	}
	public JPanel getBottom() {
		return bottom;
	}
	public void setBottom(JPanel bottom) {
		this.bottom = bottom;
	}
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
}
