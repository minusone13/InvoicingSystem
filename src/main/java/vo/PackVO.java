package vo;

import java.util.ArrayList;

import vo.stockvo.CommodityVO;

public class PackVO {
	ArrayList<CommodityVO> coms;
	int quantity;
	double discount;
	double price;//price = total-discount
}
