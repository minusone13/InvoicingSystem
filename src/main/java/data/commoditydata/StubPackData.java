package data.commoditydata;

import java.io.Serializable;
import java.util.ArrayList;

public class StubPackData implements Serializable
{
	ArrayList<MockCommodityData> coms;
	int quantity;
	double price;

	public ArrayList<MockCommodityData> getComs()
	{
		return coms;
	}

	public double getPrice()
	{
		return price;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setComs(ArrayList<MockCommodityData> coms)
	{
		this.coms = coms;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

}
