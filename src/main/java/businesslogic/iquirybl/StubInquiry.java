package businesslogic.iquirybl;

import java.util.ArrayList;

import businesslogic.examinebl.StubBillPool;
import vo.*;

public class StubInquiry {
	StubBillPool bp = new StubBillPool();
	public ArrayList<VO> inquirySale(InquirySaleVO isv) {
		//bp.getSaleSheet(st);
		//bp.getSaleBackSheet(st);
		return null;
	}
	
	public ArrayList<VO> inquiryProcess(InquiryProcessVO ipv) {
		return null;
	}
	
	public BusinessSituationVO inquiryCondition(String time, String type) {
		return null;
	}
}
