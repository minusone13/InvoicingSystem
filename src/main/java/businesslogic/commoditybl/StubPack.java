package businesslogic.commoditybl;

import java.util.ArrayList;

public class StubPack {
	ArrayList<StubCommodity> coms;
	int quantity;
	double price;
	public ArrayList<StubCommodity> getComs() {
		return coms;
	}
	public void setComs(ArrayList<StubCommodity> coms) {
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