package presentation.commodityui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class JPtreeContent extends JPanel {

	private JScrollPane SCR;
	private JPManagerCom JPmanagerCom;//整个商品管理界面的引用
	private DefaultTreeModel treeModel;//树模型
	private final JTree tree ;//树
	DefaultMutableTreeNode top ;
	public JPtreeContent(){
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
		
		//tree test
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("软件部");
        node1.add(new DefaultMutableTreeNode("小花"));
        node1.add(new DefaultMutableTreeNode("小虎"));
        node1.add(new DefaultMutableTreeNode("小龙"));
 
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("销售部");
        node2.add(new DefaultMutableTreeNode("小叶"));
        node2.add(new DefaultMutableTreeNode("小雯"));
        node2.add(new DefaultMutableTreeNode("小夏"));
 
        top= new DefaultMutableTreeNode("职员管理");
 
        top.add(new DefaultMutableTreeNode("总经理"));
        top.add(node1);
        top.add(node2);
        
        treeModel=new DefaultTreeModel(top);//通过树节点对象创建树模型对象
        tree= new JTree(treeModel);//通过树模型对象创建树对象
        tree.setEditable(true);//设置树可编辑
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
//        	JPmanagerCom.addMouseListener(JPtreeContent.this);
        TreePath treePath=e.getPath();
         System.out.println("path="+treePath.getPath()[0]+"\ntreePath"+treePath);
         //取得新节点的父节点

        }
        });
        
        SCR.setViewportView(tree);
        
		add(SCR,0);
		add(back,1);
	}
	/*删除树节点*/
	public void removeTreeNode(DefaultMutableTreeNode node){
		treeModel.removeNodeFromParent(node);
	}
	/*增加新节点*/
	public void addTreeNode(DefaultMutableTreeNode newChild,DefaultMutableTreeNode parent){
		treeModel.insertNodeInto(newChild, parent, parent.getChildCount());
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
