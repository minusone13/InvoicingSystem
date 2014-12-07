package businesslogic.salebillbl;

import businesslogic.commoditybl.MockCommodity;

public class commodityInSheet {
		private MockCommodity commodity;
		private int num;//商品数量；
		private double price;//商品单价；
		private double money;//单项总价；
		
		public void setCommodity(MockCommodity commodity){
			this.commodity=commodity;
		}
		
		public void setnum(int num){
			this.num=num;
		}
		
		public void setprice(double pirce){
			this.price=price;
		}
		
		public void setmoney(double money){
			this.money=money;
		}
		
		public MockCommodity getcommodity(){
			return this.commodity;
		}
		
		public int getnum(){
			return this.num;
		}
		
		public double getprice(){
			return this.price;
		}
		
		public double getmoney(){
			return this.money;
		}
		
}
