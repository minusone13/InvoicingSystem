package data.commoditydata;

import java.io.Serializable;
import java.util.ArrayList;

public class StubPackData implements Serializable{
	ArrayList<StubCommodityData> coms;
	int quantity;
	double price;
	public ArrayList<StubCommodityData> getComs() {
		return coms;
	}
	public void setComs(ArrayList<StubCommodityData> coms) {
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
