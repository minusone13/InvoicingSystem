package data.commoditydata;

import java.io.Serializable;
import java.util.*;

import po.*;
import po.stockpo.CommodityPO;

public class MockCommodityData implements Serializable{
	CommodityPO po;//详见PO中的注释
	public boolean equals(MockCommodityData com)
	{
		return (po.getName().equals(com.getName()) && po.getModel().equals(com.getModel()));
	}
	
	public String getID() {
		return po.getId();
	}
	public void setID(String iD) {
		po.setId(iD);;
	}
	public String getParent() {
		return po.getParent();
	}
	public void setParent(String parent) {
		po.setParent(parent);
		po.setId(po.getParent()+"\\"+po.getName());
	}
	public String getName() {
		return po.getName();
	}
	private void setName(String name) {//名称和型号唯一确定一个商品，不能随意更改
		po.setName(name);
		po.setId(po.getParent()+"\\"+po.getName());
	}
	public String getModel() {
		return po.getModel();
	}
	private void setModel(String model) {
		po.setModel(model);;
	}
	public int getNumber() {
		return po.getNumber();
	}
	public void setNumber(int number) {
		po.setNumber(number);;
	}
	public double getIn() {
		return po.getIn();
	}
	public void setIn(double in) {
		po.setIn(in);;
	}
	public double getOut() {
		return po.getOut();
	}
	public void setOut(double out) {
		po.setOut(out);;
	}
	public double getLastin() {
		return po.getLastin();
	}
	public void setLastin(double lastin) {
		po.setLastIn(lastin);;
	}
	public double getLastout() {
		return po.getLastout();
	}
	public void setLastout(double lastout) {
		po.setLastOut(lastout);;
	}
	public MockCommodityData(CommodityPO po)
	{
		this.po=po;
	}
	public CommodityPO getPo() {
		return po;
	}
	public void setPo(CommodityPO po) {
		this.po = po;
	}
	
}
