package data.commoditydata;

import java.io.Serializable;
import java.util.ArrayList;

public class PackData implements Serializable
{
	ArrayList<CommodityData> coms;
	int quantity;
	double price;

	public ArrayList<CommodityData> getComs()
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

	public void setComs(ArrayList<CommodityData> coms)
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
