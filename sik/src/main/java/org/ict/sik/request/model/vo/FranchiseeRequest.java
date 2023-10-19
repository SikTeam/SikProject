package org.ict.sik.request.model.vo;

import java.sql.Date;

public class FranchiseeRequest extends Request {
	
	private String fcId;
	private String mgId;
	private Date mgCdate; //작성일
	
	public FranchiseeRequest() {
		super();
	}
	public FranchiseeRequest(String fcId, String mgId, Date mgCdate) {
		super();
		this.fcId = fcId;
		this.mgId = mgId;
		this.mgCdate = mgCdate;
	}
	public String getFcId() {
		return fcId;
	}
	public void setFcId(String fcId) {
		this.fcId = fcId;
	}
	public String getMgId() {
		return mgId;
	}
	public void setMgId(String mgId) {
		this.mgId = mgId;
	}
	public Date getMgCdate() {
		return mgCdate;
	}
	public void setMgCdate(Date mgCdate) {
		this.mgCdate = mgCdate;
	}
	@Override
	public String toString() {
		return "FranchiseeRequest [fcId=" + fcId + ", mgId=" + mgId + ", mgCdate=" + mgCdate + "]";
	}
	
	
	
}
