package vo.inquiryVO;

public class InquiryConditionVO {
	
	private String timeBefore;
	private String timeAfter;
	//private int type;
	
	
	public InquiryConditionVO() {}
	
	public InquiryConditionVO(String before, String after) {
		this.timeBefore = before;
		this.timeAfter = after;
	}
	public String getTimeBefore() {
		return timeBefore;
	}

	public void setTimeBefore(String timeBefore) {
		this.timeBefore = timeBefore;
	}

	public String getTimeAfter() {
		return timeAfter;
	}

	public void setTimeAfter(String timeAfter) {
		this.timeAfter = timeAfter;
	}

}
