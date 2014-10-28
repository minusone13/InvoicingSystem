package vo;

import java.util.ArrayList;

public class PackVO {
	ArrayList<CommodityVO> coms;
	int quantity;
	double discount;
	double price;//price = total-discount
}
