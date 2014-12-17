package presentation.financialui;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vo.AlertBillVO;
import vo.GiftBillVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.SpillsLossBillVO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;

public class BusinessProcessPanel extends JPanel{

	String[] columnNames1 = {"单据编号","客户","操作员","总额汇总","审批状态"};
    String[] columnNames2 = {"单据编号","银行账户","操作员","总额汇总","审批状态"};
    String[] columnNames3 = {"单据编号","供应商","仓库","操作员","备注","总额合计","审批状态"};
    String[] columnNames4 = {"单据编号","客户","业务员","操作员","仓库","折让前总额","折让","代金券","商品组合","折让后总额","备注","审批状态"};
    String[] columnNames5 = {"单据编号","商品名","类型","数量"};
    String[] columnNames1s = {"银行账户","金额","备注"};
    String[] columnNames2s = {"条目名","金额","备注"};
    String[] columnNames3s = {"商品编号","名称","型号","数量","单价","金额","备注"}; 
    String[] columnNames4s = {"商品编号","名称","型号","数量","单价","金额","备注"};
    String[] columnNames5s = {};
    ArrayList<GiftBillVO> gift;
    ArrayList<SpillsLossBillVO> spillsLoss; 
    ArrayList<AlertBillVO> alert;
    ArrayList<SaleSheetVO> saleSheet;
    ArrayList<SaleBackSheetVO> saleBackSheet;
    ArrayList<PurSheetVO> purSheet;
    ArrayList<PurBackSheetVO> purBackSheet;
    ArrayList<ReceiptVO> receipt;
    ArrayList<PaymentVO> payment;
    ArrayList<CashPaymentVO> cashPayment;
	JTable table1, table2;
	DefaultTableModel model1, model2;
	
	int choose = 0;//0：付款收款单；1：现金费用单；2：进货单据；3：销售单据；4：库存类单据
    String timeBefore;
    String timeAfter;
    public BusinessProcessPanel() {
		
	}
	
	public void initial() {
		
	}
}
