package businesslogic.commoditybl;

import java.util.ArrayList;

import vo.PackVO;

public class StubPack 
{//特价包类
	public StubPack(String name, ArrayList<MockCommodity> coms, int quantity,
			double price) {
		this.ID = name;
		this.coms = coms;
		this.quantity = quantity;
		this.price = price;
	}
	public StubPack(PackVO vo)
	{
		
	}
	String ID;
	ArrayList<MockCommodity> coms;
	int quantity;
	double price;//总价，通过total-discount得出
	public ArrayList<MockCommodity> getComs() {
		return coms;
	}
	public void setComs(ArrayList<MockCommodity> coms) {
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
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
}