package vo;

import java.util.ArrayList;

import vo.stockvo.CommodityVO;

public class PackVO {
	String name;
	ArrayList<CommodityVO> coms;
	int quantity;
	//double discount;
	double price;//price = total-discount
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<CommodityVO> getComs() {
		return coms;
	}
	public void setComs(ArrayList<CommodityVO> coms) {
		this.coms = coms;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
