package presentation.commodityui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import vo.RM;
import vo.stockvo.CategoryVO;
import vo.stockvo.CommodityVO;
import vo.stockvo.StockVO;
import vo.stockvo.StockVO.Type;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.commodityblservice.StubCommodityBlService;
import data.commoditydata.StubStockDataController;

public class JPtreeContent extends JPanel {

	private JScrollPane SCR;
	private JPManagerCom JPmanagerCom;//整个商品管理界面的引用
	private DefaultTreeModel treeModel;//树模型
	private final JTree tree ;//树
	private DefaultMutableTreeNode top ;
	//逻辑层接口
	private StubCommodityBlService stockbl=new StubStockController();
	
	public StubCommodityBlService getStockbl() {
		return stockbl;
	}
	public void setStockbl(StubCommodityBlService stockbl) {
		this.stockbl = stockbl;
	}
	public JPtreeContent(){
		//逻辑层接口
		StockManagerDriver smd=new StockManagerDriver();
		smd.start(stockbl,StubStockDataController.getInstance());
		
		this.setSize(150, 350);
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		JLabel back=new JLabel();
		back.setIcon(new ImageIcon("src/image/ChooseCom/contentBack.png"));
		back.setBounds(0, 0, 150, 300);
		//滚动面板
		SCR = new JScrollPane();
		SCR.setBounds(0, 0, 150, 300);
		SCR.setOpaque(false);//设置透明
		SCR.getViewport().setOpaque(false);//设置透明
		SCR.setBorder(null);
		
        top= new DefaultMutableTreeNode("商品分类");
        //通过树节点对象创建树模型对象
        treeModel=new DefaultTreeModel(top);
        //通过树模型对象创建树对象
        tree= new JTree(treeModel);
        //根据数据层初始化树
        innitial();
      
        //设置树可编辑
        tree.setEditable(true);
        //设置树透明
        tree.setOpaque(false); 
        //设置树节点透明
        DefaultTreeCellRenderer cellRenderer = new DefaultTreeCellRenderer();
        cellRenderer.setBackgroundNonSelectionColor(new Color(0, 0, 0, 0));
        cellRenderer.setBackgroundSelectionColor(new Color(0, 0, 0, 0));
        tree.setCellRenderer(cellRenderer);
        //设置节点高度的像素
        tree.setRowHeight(28);
        tree.setFont(new Font("宋体",Font.BOLD,16));//设置节点的字体样式

       //事件监听
        tree.addTreeSelectionListener(new TreeSelectionListener(){
        public void valueChanged(TreeSelectionEvent e) {
         DefaultMutableTreeNode thisNode=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        //判断当前节点下有没有商品
         if(thisNode!=null){
        	 ArrayList<StockVO> stockvo= stockbl.openCategory(rePath(thisNode));
             if(stockvo.size()!=0){//如果有分类或者商品
            	 if(stockvo.get(0).getT()==Type.Commodity){//如果是商品
            		 ArrayList<CommodityVO> temp=new ArrayList<CommodityVO>();
            		 for(int i=0;i<stockvo.size();i++){
            			 temp.add(stockvo.get(i).getCom());
            		 }
            		 JPmanagerCom.getCommodities().getCommodities().clear();
            		 JPmanagerCom.getCommodities().addCommodities(temp);
            	 }
             }
             else{
            	 JPmanagerCom.getCommodities().getCommodities().clear();
            	 JPmanagerCom.getCommodities().update();
             }
         }
        
        }
        });
        tree.getCellEditor().addCellEditorListener(new CellEditorAction());  
//        tree.startEditingAtPath(tree.getSelectionPath());  
        
        SCR.setViewportView(tree);
        
		add(SCR,0);
		add(back,1);
	}
	public void innitial(){
		  //根据逻辑层数据构建树
		top.removeAllChildren();
        ArrayList<StockVO> stockList=stockbl.openCategory("1");
        if(stockList.size()!=0){
        	 if(stockList.get(0).getT()==Type.Category){
           	  for(StockVO temp:stockList){
           		  DefaultMutableTreeNode child=new DefaultMutableTreeNode(temp.getCat().getName());
           		  treeModel.insertNodeInto(child, top, top.getChildCount());
           		 addCategory(child);//递归加子分类
           	  }
           }
        }
	}
	/*节点编辑监听*/
	private class CellEditorAction implements CellEditorListener{  
        public void editingCanceled(ChangeEvent e) {  
            System.out.println("编辑取消");  
        }  
        public void editingStopped(ChangeEvent e) {
        	DefaultMutableTreeNode thisNode=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        	String parentID=rePath((DefaultMutableTreeNode)thisNode.getParent());
        	CategoryVO categryvo=new CategoryVO(parentID,thisNode.getUserObject().toString());
        	RM rm=stockbl.updateCategory(categryvo);
            System.out.println("编辑结束,结果是"+rm);  
        }  
    }  
	/*返回逻辑层对应路径*/
	public String rePath(DefaultMutableTreeNode node){
		//路径转换成逻辑层的对应格式
		String path;
		TreeNode[] nodePath=node.getPath();
		if(nodePath.length==1){
			return "1";
		}
		 path="1\\";
		for(int i=1;i<nodePath.length-1;i++){
			path+=(((DefaultMutableTreeNode)nodePath[i]).getUserObject().toString()+"\\");
		}
		path+=node.getUserObject().toString();
		
		return path;
	}
	/*递归构建树*/
	public void addCategory(DefaultMutableTreeNode parent){
		//路径转换成逻辑层的对应格式
		String path=rePath(parent);
		//通过路径找到子分类
		ArrayList<StockVO> stockList=stockbl.openCategory(path);
		//如果有子分类又不是商品就加到界面父节点下
		if(stockList.size()!=0){
			 if(stockList.get(0).getT()==Type.Category){
	        	  for(StockVO temp:stockList){
	        		  CategoryVO category=temp.getCat();
	        		  String name=category.getName();
	        		  DefaultMutableTreeNode child=new DefaultMutableTreeNode(name);
	        		  treeModel.insertNodeInto(child, parent, parent.getChildCount());
	        		  addCategory(child);
	        		 
	              }
	        }
		}
	}
	/*删除树节点*/
	public void removeTreeNode(DefaultMutableTreeNode node){
		//调用逻辑层
		RM rm=stockbl.deleteCategory(rePath(node));
		if(rm==RM.done){
			System.out.println("已成功删除");
			treeModel.removeNodeFromParent(node);
		}
		else{
			System.out.println("删除失败，已有子分类或者商品");
		}
	}
	/*返回最后选择的节点*/
	public DefaultMutableTreeNode reLastSelectedNode(){
		DefaultMutableTreeNode lastSelectedNode=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		return lastSelectedNode;
	}
	/*增加新节点*/
	public void addTreeNode(DefaultMutableTreeNode newChild,DefaultMutableTreeNode parent){
	
		//调用逻辑层
		CategoryVO newCategory=new CategoryVO(rePath(parent),newChild.getUserObject().toString());
		RM rm=stockbl.addCategory(newCategory);
		if(rm==RM.done){
			treeModel.insertNodeInto(newChild, parent, parent.getChildCount());
		}
		else if(rm==RM.treeerror){
			System.out.println("该分类下已有商品，不能创建分类");
		}
		else if(rm==RM.redundance){
			System.out.println("已存在该分类");
		}
	}
	/*删除当前选中的节点*/
	public void removeChosen(){
		DefaultMutableTreeNode lastSelected=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if(lastSelected!=null){
			removeTreeNode(lastSelected);
		}
		else{
			System.out.println("请选择要删除的分类");
		}
	}
	/*增加新节点到当前选中的节点*/
	public void addTreeNodeToChosen(DefaultMutableTreeNode newChild){
		DefaultMutableTreeNode lastSelected=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if(lastSelected!=null){
			addTreeNode(newChild,lastSelected);
		}
		else{
			System.out.println("请选择父节点分类");
		}
		
	}
	/*增加已命名的新节点到当前选中的节点*/
	public void addTreeNodeToChosen(){
		DefaultMutableTreeNode lastSelected=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if(lastSelected!=null){
			addTreeNode(new DefaultMutableTreeNode("未命名"),lastSelected);
		}
		else{
			System.out.println("请选择父节点分类");
		}
		
	}
	
	/*获取和给予管理商品界面的引用*/
	public JPManagerCom getJPmanagerCom() {
		return JPmanagerCom;
	}
	public void setJPmanagerCom(JPManagerCom jPmanagerCom) {
		JPmanagerCom = jPmanagerCom;
	}
}
