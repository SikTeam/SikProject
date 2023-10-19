package org.ict.sik.ad.model.vo;

import java.util.Date;

public class Ad {
	private String adId;
	private String adTitle;
	private Date adBir;
	private Date adStDate;
	private Date adEndDate;
	private String adStatus;
	private String memberId;
	private String adDiv;
	
	public Ad() {
		super();
	}

	public Ad(String adId, String adTitle, Date adBir, Date adStDate, Date adEndDate, String adStatus, String memberId,
			String adDiv) {
		super();
		this.adId = adId;
		this.adTitle = adTitle;
		this.adBir = adBir;
		this.adStDate = adStDate;
		this.adEndDate = adEndDate;
		this.adStatus = adStatus;
		this.memberId = memberId;
		this.adDiv = adDiv;
	}

	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public String getAdTitle() {
		return adTitle;
	}

	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}

	public Date getAdBir() {
		return adBir;
	}

	public void setAdBir(Date adBir) {
		this.adBir = adBir;
	}

	public Date getAdStDate() {
		return adStDate;
	}

	public void setAdStDate(Date adStDate) {
		this.adStDate = adStDate;
	}

	public Date getAdEndDate() {
		return adEndDate;
	}

	public void setAdEndDate(Date adEndDate) {
		this.adEndDate = adEndDate;
	}

	public String getAdStatus() {
		return adStatus;
	}

	public void setAdStatus(String adStatus) {
		this.adStatus = adStatus;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getAdDiv() {
		return adDiv;
	}

	public void setAdDiv(String adDiv) {
		this.adDiv = adDiv;
	}

	@Override
	public String toString() {
		return "Ad [adId=" + adId + ", adTitle=" + adTitle + ", adStatus=" + adStatus + ", memberId=" + memberId
				+ ", adDiv=" + adDiv + "]";
	}
	
	
}
