package org.ict.sik.agr.model.vo;

import java.util.Date;

public class Agr {
	private String agrId;
	private Date agrDate;
	private Date agrEndDate;
	private Date agrMgOpen;
	private String agrDepYn;
	private String agrDep;
	private String fcId;
	private String memberId;
	
	public Agr() {
		super();
	}

	public Agr(String agrId, Date agrDate, Date agrEndDate, Date agrMgOpen, String agrDepYn, String agrDep, String fcId,
			String memberId) {
		super();
		this.agrId = agrId;
		this.agrDate = agrDate;
		this.agrEndDate = agrEndDate;
		this.agrMgOpen = agrMgOpen;
		this.agrDepYn = agrDepYn;
		this.agrDep = agrDep;
		this.fcId = fcId;
		this.memberId = memberId;
	}

	public String getAgrId() {
		return agrId;
	}

	public void setAgrId(String agrId) {
		this.agrId = agrId;
	}

	public Date getAgrDate() {
		return agrDate;
	}

	public void setAgrDate(Date agrDate) {
		this.agrDate = agrDate;
	}

	public Date getAgrEndDate() {
		return agrEndDate;
	}

	public void setAgrEndDate(Date agrEndDate) {
		this.agrEndDate = agrEndDate;
	}

	public Date getAgrMgOpen() {
		return agrMgOpen;
	}

	public void setAgrMgOpen(Date agrMgOpen) {
		this.agrMgOpen = agrMgOpen;
	}

	public String getAgrDepYn() {
		return agrDepYn;
	}

	public void setAgrDepYn(String agrDepYn) {
		this.agrDepYn = agrDepYn;
	}

	public String getAgrDep() {
		return agrDep;
	}

	public void setAgrDep(String agrDep) {
		this.agrDep = agrDep;
	}

	public String getFcId() {
		return fcId;
	}

	public void setFcId(String fcId) {
		this.fcId = fcId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Agr [agrId=" + agrId + ", agrDate=" + agrDate + ", agrEndDate=" + agrEndDate + ", agrMgOpen="
				+ agrMgOpen + ", agrDepYn=" + agrDepYn + ", agrDep=" + agrDep + ", fcId=" + fcId + ", memberId="
				+ memberId + "]";
	}
	
	
}
