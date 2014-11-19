package businesslogic.stockservice;

import java.util.ArrayList;

import businesslogic.commoditybl.MockCommodity;
import vo.stockvo.CommodityVO;

public interface StockBlForManager 
{//这是给总经理层内的接口，由StubStockController实现
	public ArrayList<CommodityVO> findCommodity(String name);//通过商品名称返回一系列的商品VO,这样可通过型号查找具体商品信息，通过最低库存判断是否可以生成单据
	//如输入飞利浦， 有可能返回飞利浦 SR01, 飞利浦 SR02等一系列商品
	
	public boolean addPack(ArrayList<MockCommodity> commodityarray,int quantity, double discount);//增加特价包功能
	//public boolean addPack(ArrayList<CommodityVO> commodityarray,int quantity, double discount);也可以换成这个，看你觉得哪个好用
}
