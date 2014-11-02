package data.commoditydata;

import java.io.Serializable;
import java.util.*;

import po.*;

public class StubCommodityData implements Serializable{
	public String getID() {
		return id;
	}
	public void setID(String iD) {
		id = iD;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getIn() {
		return in;
	}
	public void setIn(double in) {
		this.in = in;
	}
	public double getOut() {
		return out;
	}
	public void setOut(double out) {
		this.out = out;
	}
	public double getLastin() {
		return lastin;
	}
	public void setLastin(double lastin) {
		this.lastin = lastin;
	}
	public double getLastout() {
		return lastout;
	}
	public void setLastout(double lastout) {
		this.lastout = lastout;
	}
	String id;
	String parent;
	String name;
	String model;
	int number;
	double in;
	double out;
	double lastin;
	double lastout;
	double average;
	
}
