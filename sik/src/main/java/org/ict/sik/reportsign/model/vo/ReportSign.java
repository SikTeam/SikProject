package org.ict.sik.reportsign.model.vo;

//결재
public class ReportSign {
	public String reportId; //보고서ID
	public String memberId; //사번
	public String reSign; //결재라인여부
	public String reRead; //승인/읽음여부
	public int reportSignCounter; //결재 순서
	
	public ReportSign() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportSign(String reportId, String memberId, String reSign, String reRead, int reportSignCounter) {
		super();
		this.reportId = reportId;
		this.memberId = memberId;
		this.reSign = reSign;
		this.reRead = reRead;
		this.reportSignCounter = reportSignCounter;
	}
	
	public int getReportSignCounter() {
		return reportSignCounter;
	}

	public void setReportSignCounter(int reportSignCounter) {
		this.reportSignCounter = reportSignCounter;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getReSign() {
		return reSign;
	}

	public void setReSign(String reSign) {
		this.reSign = reSign;
	}

	public String getReRead() {
		return reRead;
	}

	public void setReRead(String reRead) {
		this.reRead = reRead;
	}

	@Override
	public String toString() {
		return "ReportSign [reportId=" + reportId + ", memberId=" + memberId + ", reSign=" + reSign + ", reRead="
				+ reRead + "]";
	}
	
	
}
