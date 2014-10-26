package presentation.financialui;

import businesslogicservice.financialblservice.StubFinancialBlService;

public class FinancialBLDriver {
	StubFinancialBlService fbs;
	public FinancialBLDriver (StubFinancialBlService fbs) {
		this.fbs = fbs;
	}
	
	public void drive(StubFinancialBlService fbs) {
		fbs.addAccount("00001");
	}
}
