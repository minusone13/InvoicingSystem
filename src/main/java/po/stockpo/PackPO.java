package po.stockpo;

import java.io.Serializable;
import java.util.ArrayList;

public class PackPO implements Serializable, Cloneable{
	String name;
	ArrayList<CommodityPO> coms;
	int quantity;
	double price;
	public ArrayList<CommodityPO> getComs() {
		return coms;
	}
	public void setComs(ArrayList<CommodityPO> coms) {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
