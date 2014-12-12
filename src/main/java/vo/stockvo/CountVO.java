package vo.stockvo;

import java.util.*;

public class CountVO {
	public CountVO(ArrayList<CommodityVO> list, Date date, int no) {
		this.list = list;
		this.date = date;
		this.no = no;
	}
	//库存盘点
	ArrayList<CommodityVO> list = new ArrayList<CommodityVO>();
	Date date = new Date();//批次
	int no;//批号
	public ArrayList<CommodityVO> getList() {
		return list;
	}
	public void setList(ArrayList<CommodityVO> list) {
		this.list = list;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
}
