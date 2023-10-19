package org.ict.sik.report.model.vo;

import java.sql.Date;

//보고서 vo
public class Report {
	private String reportId; //보고서ID
	private String reTitle; //제목
	private String reContent; //내용
	private String reFile; //첨부파일
	private Date reDate; //작성일
	
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(String reportId, String reTitle, String reContent, String reFile, Date reDate) {
		super();
		this.reportId = reportId;
		this.reTitle = reTitle;
		this.reContent = reContent;
		this.reFile = reFile;
		this.reDate = reDate;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getReTitle() {
		return reTitle;
	}

	public void setReTitle(String reTitle) {
		this.reTitle = reTitle;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public String getReFile() {
		return reFile;
	}

	public void setReFile(String reFile) {
		this.reFile = reFile;
	}

	public Date getReDate() {
		return reDate;
	}

	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}

	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", reTitle=" + reTitle + ", reContent=" + reContent + ", reFile="
				+ reFile + ", reDate=" + reDate + "]";
	}
	
	
}
