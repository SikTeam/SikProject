package org.ict.sik.fc.model.vo;

//가맹점 vo
public class Fc {
	private String fcId; //가맹점ID
	private String brandId; //브랜드ID
	private String fcPw; //가맹점비밀번호
	private String fcName; //매장명
	private String fcAdd; //주소
	private String fcArea; //평수
	private String fcNum; //사업자번호
	private String fcDh; //배달/홀
	private String fcOwner; //사업주명
	private String fcYn; //운영YN
	private String memberId; //사번
	
	public Fc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fc(String fcId, String fcPw) {
		super();
		this.fcId = fcId;
		this.fcPw = fcPw;
	}
	public Fc(String fcId, String brandId, String fcPw, String fcName, String fcAdd, String fcArea, String fcNum,
			String fcDh, String fcOwner, String fcYn, String memberId) {
		super();
		this.fcId = fcId;
		this.brandId = brandId;
		this.fcPw = fcPw;
		this.fcName = fcName;
		this.fcAdd = fcAdd;
		this.fcArea = fcArea;
		this.fcNum = fcNum;
		this.fcDh = fcDh;
		this.fcOwner = fcOwner;
		this.fcYn = fcYn;
		this.memberId = memberId;
	}

	public String getFcId() {
		return fcId;
	}

	public void setFcId(String fcId) {
		this.fcId = fcId;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getFcPw() {
		return fcPw;
	}

	public void setFcPw(String fcPw) {
		this.fcPw = fcPw;
	}

	public String getFcName() {
		return fcName;
	}

	public void setFcName(String fcName) {
		this.fcName = fcName;
	}

	public String getFcAdd() {
		return fcAdd;
	}

	public void setFcAdd(String fcAdd) {
		this.fcAdd = fcAdd;
	}

	public String getFcArea() {
		return fcArea;
	}

	public void setFcArea(String fcArea) {
		this.fcArea = fcArea;
	}

	public String getFcNum() {
		return fcNum;
	}

	public void setFcNum(String fcNum) {
		this.fcNum = fcNum;
	}

	public String getFcDh() {
		return fcDh;
	}

	public void setFcDh(String fcDh) {
		this.fcDh = fcDh;
	}

	public String getFcOwner() {
		return fcOwner;
	}

	public void setFcOwner(String fcOwner) {
		this.fcOwner = fcOwner;
	}

	public String getFcYn() {
		return fcYn;
	}

	public void setFcYn(String fcYn) {
		this.fcYn = fcYn;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	/*
	 * 로그인에 사용되는 메소드 isFc(Object object) 작성 
	 * 맞다면 true 리턴
	 * 아니라면 false 리턴
	 * */
	
	public boolean isFc(Object object) {
		return object instanceof Fc;
	}
	
	
	@Override
	public String toString() {
		return "Fc [fcId=" + fcId + ", brandId=" + brandId + ", fcPw=" + fcPw + ", fcName=" + fcName + ", fcAdd="
				+ fcAdd + ", fcArea=" + fcArea + ", fcNum=" + fcNum + ", fcDh=" + fcDh + ", fcOwner=" + fcOwner
				+ ", fcYn=" + fcYn + ", memberId=" + memberId + "]";
	}
	
	
	
}
