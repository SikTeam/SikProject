package org.ict.sik.manager.model.vo;

public class Manager {
	private String brandId;
	private String memberId;
	
	public Manager() {
		super();
	}

	public Manager(String memberId, String brandId) {
		super();
		this.memberId = memberId;
		this.brandId = brandId;
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

	@Override
	public String toString() {
		return "Manager [memberId=" + memberId + ", brandId=" + brandId + "]";
	}
	
	
}
