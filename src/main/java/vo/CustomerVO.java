package vo;

public class CustomerVO {
	int type;
	String name;
	String phonenumber;
	String address;
	String postcode;
	double maxOwe;
	double shouldPay;
	double shouldGive;
	String deSaler;
	private String id;
	
	public int gettype(){
		return this.type;
	}
	
	public String getname(){
		return this.name;
	}
	
	public String getphonenumber(){
		return this.phonenumber;
	}
	
	public String getaddress(){
		return this.address;
	}
	
	public String getpostcode(){
		return this.postcode;
	}
	
	public String getdeSaler(){
		return this.deSaler;
	}
	
	public double getmaxOwe(){
		return this.maxOwe;
	}
	
	public double getShouldPay(){
		return this.shouldPay;
	}	
	
	public double getShouldGive(){
		return this.shouldGive;
	}
	
	public void settype(int type){
		this.type=type;
	}
	
	public void setname(String name){
		this.name=name;
	}
	
	public void setphonenumber(String phonenumber){
		this.phonenumber=phonenumber;
	}
	
	public void setaddress(String address){
		this.address=address;
	}
	
	public void setpostcode(String postcode){
		this.postcode=postcode;
	}
	
	public void setdeSaler(String deSaler){
		this.deSaler=deSaler;
	}
	
	public void setmaxOwe(double maxOwe){
		this.maxOwe=maxOwe;
	}
	
	public void setShouldPay(double ShouldPay){
		this.shouldPay=ShouldPay;
	}	
	
	public void setShouldGive(double shouleGive){
		this.shouldGive=shouleGive;
	}

	public void setid(String id) {
		// TODO Auto-generated method stub
		this.id=id;
	}
	
}
