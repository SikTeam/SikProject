package org.ict.sik.notice.model.vo;

public class BrandNotice extends Notice {
	
	private String brandName;
	private String memberName;
	
	
	public BrandNotice() {
		super();
	}

	public BrandNotice(String brandName, String memberName) {
		super();
		this.brandName = brandName;
		this.memberName = memberName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "BrandNotice [brandName=" + brandName + ", memberName=" + memberName + "]";
	}
}