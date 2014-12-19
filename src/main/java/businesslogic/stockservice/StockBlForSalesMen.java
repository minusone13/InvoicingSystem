package businesslogic.stockservice;

import java.util.ArrayList;

import po.RM;
import vo.stockvo.CommodityVO;

public interface StockBlForSalesMen 
{//这是给进货销售人员层内的接口，由StubStockController实现
	public ArrayList<CommodityVO> findCommodity(String name);//通过商品名称返回一系列的商品VO,这样可通过型号查找具体商品信息，通过最低库存判断是否可以生成单据
	//如输入飞利浦， 有可能返回飞利浦 SR01, 飞利浦 SR02等一系列商品
	
	public boolean isEnough(String name,String model,int n);//在填写单据时检查，给出的是潜在库存最小值，也就是最保险的值
	public boolean isEnough(String PackID,int n);//判断特价包
	
	public RM checkIn(String id,String name, String model, int quantity, double price);//当进货单被审批后，请调用,price是单价
	public RM checkOut(String id,String name, String model, int quantity, double price);//当销售单审批后，请调用,price是单价
	public RM undoCheckIn(String id,String name, String model, int quantity, double price);//当进货退货单被审批后，请调用,price是单价
	public RM undoCheckOut(String id,String name, String model, int quantity, double price);//当销售退货单被审批后，请调用,price是单价
	//上面两个方法会修改库存余量
	
	public RM readyForIn(String id,String name, String model, int quantity, double price);//当进货单或销售退货单提交后，请调用,price是单价
	public RM readyForOut(String id,String name, String model, int quantity, double price);//当销售单或进货退货单被提交后，请调用,price是单价
	public RM checkOut(String id, String packID, int quantity, double price);//销售特价包得到审批时时请调用, price是单价
	public RM readyForOut(String id,String packID, int quantity, double price);//销售特价包提交时请调用，price是单价
	public RM undoCheckOut(String id,String packID, int quantity, double price);//销售退货审批后请调用，price是单价
}
