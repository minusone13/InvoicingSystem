package businesslogic;

import java.util.ArrayList;

import vo.stockvo.CommodityVO;

public interface StockBlForSalesMen 
{//这是给进货销售人员层内的接口，由StubStockController实现
	public ArrayList<CommodityVO> findCommodity(String name);//通过商品名称返回一系列的商品VO,这样可通过型号查找具体商品信息，通过最低库存判断是否可以生成单据
	//如输入飞利浦， 有可能返回飞利浦 SR01, 飞利浦 SR02等一系列商品
	
	public boolean checkIn(String id,String name, String model, int quantity, double price);//当进货单被审批后，请调用
	public boolean checkOut(String id,String name, String model, int quantity, double price);//当销售单被审批后，请调用
	//上面两个方法会修改库存余量
}
