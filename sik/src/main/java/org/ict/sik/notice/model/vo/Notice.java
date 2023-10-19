package org.ict.sik.notice.model.vo;

import java.util.Date;

public class Notice {
	private String noId;
	private String memberId;
	private String brandId;
	private Date noCdate;
	private Date noUdate;
	private Date noDdate;
	private String noFile;
	private String noVcount;
	private String noCon;
	private String noTitle;
	
	public Notice() {
		super();
	}

	public Notice(String noId, String memberId, String brandId, Date noCdate, Date noUdate, Date noDdate, String noFile,
			String noVcount, String noCon, String noTitle) {
		super();
		this.noId = noId;
		this.memberId = memberId;
		this.brandId = brandId;
		this.noCdate = noCdate;
		this.noUdate = noUdate;
		this.noDdate = noDdate;
		this.noFile = noFile;
		this.noVcount = noVcount;
		this.noCon = noCon;
		this.noTitle = noTitle;
	}

	public String getNoId() {
		return noId;
	}

	public void setNoId(String noId) {
		this.noId = noId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public Date getNoCdate() {
		return noCdate;
	}

	public void setNoCdate(Date noCdate) {
		this.noCdate = noCdate;
	}

	public Date getNoUdate() {
		return noUdate;
	}

	public void setNoUdate(Date noUdate) {
		this.noUdate = noUdate;
	}

	public Date getNoDdate() {
		return noDdate;
	}

	public void setNoDdate(Date noDdate) {
		this.noDdate = noDdate;
	}

	public String getNoFile() {
		return noFile;
	}

	public void setNoFile(String noFile) {
		this.noFile = noFile;
	}

	public String getNoVcount() {
		return noVcount;
	}

	public void setNoVcount(String noVcount) {
		this.noVcount = noVcount;
	}

	public String getNoCon() {
		return noCon;
	}

	public void setNoCon(String noCon) {
		this.noCon = noCon;
	}

	public String getNoTitle() {
		return noTitle;
	}

	public void setNoTitle(String noTitle) {
		this.noTitle = noTitle;
	}

	@Override
	public String toString() {
		return "Notice [noId=" + noId + ", memberId=" + memberId + ", brandId=" + brandId + ", noCdate=" + noCdate
				+ ", noUdate=" + noUdate + ", noDdate=" + noDdate + ", noFile=" + noFile + ", noVcount=" + noVcount
				+ ", noCon=" + noCon + ", noTitle=" + noTitle + "]";
	}
	
	
}
