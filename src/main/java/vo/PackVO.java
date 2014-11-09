package vo;

import java.util.ArrayList;

public class PackVO {
	ArrayList<MockCommodityVO> coms;
	int quantity;
	double discount;
	double price;//price = total-discount
}
