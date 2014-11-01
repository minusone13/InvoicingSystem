package po;

import java.util.*;


public class CommodityPO {
	public enum Type
	{
		Category,
		Commodity
	} 
	Type t;
	String parent;
	String name;
	String model;
	int number;
	double in;
	double out;
	double lastin;
	double lastout;
	double average;
	public CommodityPO(Type t,String parent,String name,String model,int number,double in,double out,double lastin,double lastout,double average)
	{
		this.t=t;
		this.parent=parent;
		this.name=name;
		this.model=model;
		this.number=number;
		this.in=in;
		this.out=out;
		this.lastin=lastin;
		this.lastout=lastout;
		this.average=average;
	}
	public CommodityPO(String parent,String name,String model,int number,double in,double out,double lastin,double lastout,double average)
	{
		t=t.Commodity;
		this.parent=parent;
		this.name=name;
		this.model=model;
		this.number=number;
		this.in=in;
		this.out=out;
		this.lastin=lastin;
		this.lastout=lastout;
		this.average=average;
	}
	public CommodityPO(Type t,String parent,String name)
	{
		this.t=t;
		this.parent=parent;
		this.name=name;
	}
	public CommodityPO(String parent,String name)
	{
		t=t.Category;
		this.parent=parent;
		this.name=name;
	}
	public Type getType()
	{
		return t;
	}
	public String getParent()
	{
		return parent;
	}
	public String getName()
	{
		return name;
	}
	public int getNumber()
	{
		return number;
	}
	public double getIn()
	{
		return in;
	}
	public double getOut()
	{
		return out;
	}
	public double getLastIn()
	{
		return lastin;
	}
	public double getLastOut()
	{
		return lastout;
	}
	public void setNumber(int number)
	{
		this.number=number;
	}
	public void setLastIn(double lastin)
	{
		this.lastin=lastin;
	}
	public void setLastOut(double lastout)
	{
		this.lastout=lastout;
	}
	public void setIn(double in)
	{
		this.in=in;
	}
	public void setOut(double out)
	{
		this.out=out;
	}
	public Type getT() {
		return t;
	}
	public void setT(Type t) {
		this.t = t;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
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
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public void setName(String name) {
		this.name = name;
	}
}
