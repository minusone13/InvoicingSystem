package presentation.commodityui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import po.Role;
import presentation.managerui.MouseListenerGetXY;
import userui.Frame;
import vo.stockvo.CommodityVO;

public class JPManagerCom extends JPanel{

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
    Frame frame;
	public JPManagerCom(){
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
		
		detail.setBounds(15, 5, 550, 20);
		detail.setOpaque(false);//文本框透明
		detail.setBorder(null);
		detail.setForeground(Color.white);//前景色
		detail.setFont(new Font("宋体",Font.BOLD,14));
		
		head.add(findCom,0);
		head.add(find,1);
		head.add(findIcon,2);
		head.add(bgOfHead,3);
		
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
					switch(frame.getManager().getManagerStrategy2().getStyle()){
					case LevelStrategy:
						frame.getManager().getManagerStrategy2().getJPeditOfLevel().setOutput(temp);
						System.out.println("output");
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
					//清除选择痕迹
					commodities.getOutput().clear();
					commodities.getCommodities().clear();
					commodities.update();
					break;
				case PURCHASE_SALE_STAFF:
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
	}
	
}
