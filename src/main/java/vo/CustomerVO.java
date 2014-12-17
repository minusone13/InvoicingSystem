package vo;

public class CustomerVO {
	int type;
	String name;
	String phonenumber;
	String address;
	String postcode;
	double maxOwe;
	double shouldPay;//公司给客户的;
	double shouldTake;//公司从客户收取的;
	String deSaler;
	private String id;
	private String email;//电子邮箱；
	private int level;//客户级别
	
	public int getlevel(){
		return this.level;
	}
	
	public void setlevel(int level){
		this.level = level;
		this.setmaxOwe(this.level*2000);
	}
	
	public String getemail(){
		return this.email;
	}
	
	public void setemail(String email){
		this.email=email;
	}
	
	
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
	
	public double getShouldTake(){
		return this.shouldTake;
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
	
	public void setShouldTake(double shouleGive){
		this.shouldTake=shouleGive;
	}

	public void setid(String id) {
		// TODO Auto-generated method stub
		this.id=id;
	}

	public String getid() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
}
