package vo;

import java.util.ArrayList;

import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.LevelStrategyStyle;
import businesslogic.ReachStrategyStyle;
import businesslogic.Role;
import businesslogic.StrategyStyle;
import businesslogic.financialbillbl.StubItem;
import businesslogic.financialbillbl.TransferAccount;

public class VO {
	private BillStyle billstyle;//单据类型
	private StrategyStyle strategystyle;//策略类型
	private LevelStrategyStyle level_strategy_style;//客户分层策略种类
	private ReachStrategyStyle reach_strategy_style;//满额促销种类
	private String ID="0000";
	double total;
	String account;//账户
	double[] money;//金额
	String[] item;
	String[] remark;
	String[] accounts;
	BillState state;
	Role operator;
	ArrayList<StubItem> itemList;		
	String customer;
	ArrayList<TransferAccount> transferlist;
	/*获取单据类型*/
	public BillStyle getBillStyle(){
		return billstyle;
		
	}
	/*获取策略类型*/
	public StrategyStyle getStrategyStyle(){
		return strategystyle;
		
	}
	/*获取单据ID*/
	public String getID(){
		return ID;
		
	}
	/*设置单据ID*/
	public  void setID(String s){

		ID=s;
	}
	/*获取满额促销种类*/
	public ReachStrategyStyle getReach_strategy_style() {
		return reach_strategy_style;
	}
	/*设置满额促销的种类*/
	public void setReach_strategy_style(ReachStrategyStyle reach_strategy_style) {
		this.reach_strategy_style = reach_strategy_style;
	}
	/*获取客户分层策略的种类*/
	public LevelStrategyStyle getLevel_strategy_style() {
		return level_strategy_style;
	}
	/*设置客户分层策略的种类*/
	public void setLevel_strategy_style(LevelStrategyStyle level_strategy_style) {
		this.level_strategy_style = level_strategy_style;
	}
}
