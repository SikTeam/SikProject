package org.ict.sik.noticeread.model.vo;

public class NoticeRead {
	private String readYn;
	private String noId;
	private String fcId;
	
	public NoticeRead() {
		super();
	}

	public NoticeRead(String readYn, String noId, String fcId) {
		super();
		this.readYn = readYn;
		this.noId = noId;
		this.fcId = fcId;
	}

	public String getReadYn() {
		return readYn;
	}

	public void setReadYn(String readYn) {
		this.readYn = readYn;
	}

	public String getNoId() {
		return noId;
	}

	public void setNoId(String noId) {
		this.noId = noId;
	}

	public String getFcId() {
		return fcId;
	}

	public void setFcId(String fcId) {
		this.fcId = fcId;
	}

	@Override
	public String toString() {
		return "NoticeRead [readYn=" + readYn + ", noId=" + noId + ", fcId=" + fcId + "]";
	}
	
	
}
