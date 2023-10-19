package org.ict.sik.cal.model.vo;

//정산내역 vo
public class Cal {
	private String calId; //정산내역ID
	private String calData; //정산일자
	private String calTerm; //정산기간
	private String calIn; //입금금액
	private String calYn; //상태
	private String fcId; //가맹점ID
	
	public Cal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cal(String calId, String calData, String calTerm, String calIn, String calYn, String fcId) {
		super();
		this.calId = calId;
		this.calData = calData;
		this.calTerm = calTerm;
		this.calIn = calIn;
		this.calYn = calYn;
		this.fcId = fcId;
	}

	public String getCalId() {
		return calId;
	}

	public void setCalId(String calId) {
		this.calId = calId;
	}

	public String getCalData() {
		return calData;
	}

	public void setCalData(String calData) {
		this.calData = calData;
	}

	public String getCalTerm() {
		return calTerm;
	}

	public void setCalTerm(String calTerm) {
		this.calTerm = calTerm;
	}

	public String getCalIn() {
		return calIn;
	}

	public void setCalIn(String calIn) {
		this.calIn = calIn;
	}

	public String getCalYn() {
		return calYn;
	}

	public void setCalYn(String calYn) {
		this.calYn = calYn;
	}

	public String getFcId() {
		return fcId;
	}

	public void setFcId(String fcId) {
		this.fcId = fcId;
	}

	@Override
	public String toString() {
		return "Cal [calId=" + calId + ", calData=" + calData + ", calTerm=" + calTerm + ", calIn=" + calIn + ", calYn="
				+ calYn + ", fcId=" + fcId + "]";
	}
	
	
}
