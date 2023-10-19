package org.ict.sik.request.model.vo;

import java.sql.Date;

public class FranchiseeRequest extends Request {
	
	private Date mgCdate; //작성일
	private String fcOwner; //사업주명
	
	public FranchiseeRequest() {
		super();
	}

	public FranchiseeRequest(Date mgCdate, String fcOwner) {
		super();
		this.mgCdate = mgCdate;
		this.fcOwner = fcOwner;
	}

	public Date getMgCdate() {
		return mgCdate;
	}

	public void setMgCdate(Date mgCdate) {
		this.mgCdate = mgCdate;
	}

	public String getFcOwner() {
		return fcOwner;
	}

	public void setFcOwner(String fcOwner) {
		this.fcOwner = fcOwner;
	}

	@Override
	public String toString() {
		return "FranchiseeRequest [mgCdate=" + mgCdate + ", fcOwner=" + fcOwner + "]";
	}

	
}
