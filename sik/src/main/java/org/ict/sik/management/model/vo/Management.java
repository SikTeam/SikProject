package org.ict.sik.management.model.vo;

import java.sql.Date;

//매장관리
public class Management {
	public String mgId; //매장관리ID
	public String memberId; //사번
	public String franchiseId; //가맹점ID
	public Date mgDate; //일시
	public String mgClassify; //구분
	public Date mgCdate; //작성일
	public Date mgUdate; //수정일
	public String mgState; //처리상태
	
	public Management() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Management(String mgId, String memberId, String franchiseId, Date mgDate, String mgClassify, Date mgCdate,
			Date mgUdate, String mgState) {
		super();
		this.mgId = mgId;
		this.memberId = memberId;
		this.franchiseId = franchiseId;
		this.mgDate = mgDate;
		this.mgClassify = mgClassify;
		this.mgCdate = mgCdate;
		this.mgUdate = mgUdate;
		this.mgState = mgState;
	}
	public String getMgId() {
		return mgId;
	}
	public void setMgId(String mgId) {
		this.mgId = mgId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getFranchiseId() {
		return franchiseId;
	}
	public void setFranchiseId(String franchiseId) {
		this.franchiseId = franchiseId;
	}
	public Date getMgDate() {
		return mgDate;
	}
	public void setMgDate(Date mgDate) {
		this.mgDate = mgDate;
	}
	public String getMgClassify() {
		return mgClassify;
	}
	public void setMgClassify(String mgClassify) {
		this.mgClassify = mgClassify;
	}
	public Date getMgCdate() {
		return mgCdate;
	}
	public void setMgCdate(Date mgCdate) {
		this.mgCdate = mgCdate;
	}
	public Date getMgUdate() {
		return mgUdate;
	}
	public void setMgUdate(Date mgUdate) {
		this.mgUdate = mgUdate;
	}
	public String getMgState() {
		return mgState;
	}
	public void setMgState(String mgState) {
		this.mgState = mgState;
	}
	@Override
	public String toString() {
		return "Management [mgId=" + mgId + ", memberId=" + memberId + ", franchiseId=" + franchiseId + ", mgDate="
				+ mgDate + ", mgClassify=" + mgClassify + ", mgCdate=" + mgCdate + ", mgUdate=" + mgUdate + ", mgState="
				+ mgState + "]";
	}
	
	
}
