package vo;

import java.util.ArrayList;

import vo.stockpo.MockCommodityVO;

public class PackVO {
	ArrayList<MockCommodityVO> coms;
	int quantity;
	double discount;
	double price;//price = total-discount
}
