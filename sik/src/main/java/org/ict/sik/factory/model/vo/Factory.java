package org.ict.sik.factory.model.vo;

//생산업체 vo
public class Factory {
	private String factoryId; //생산업체ID
	private String factoryName; //생산업체명
	private String factotyCeoname; //대표자명
	private String number; //연락처
	private String factoryRegistration; //사업자번호
	private String factoryAccount; //이체정보
	private String factoryAddress; //주소
	
	public Factory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Factory(String factoryId, String factoryName, String factotyCeoname, String number,
			String factoryRegistration, String factoryAccount, String factoryAddress) {
		super();
		this.factoryId = factoryId;
		this.factoryName = factoryName;
		this.factotyCeoname = factotyCeoname;
		this.number = number;
		this.factoryRegistration = factoryRegistration;
		this.factoryAccount = factoryAccount;
		this.factoryAddress = factoryAddress;
	}

	public String getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public String getFactotyCeoname() {
		return factotyCeoname;
	}

	public void setFactotyCeoname(String factotyCeoname) {
		this.factotyCeoname = factotyCeoname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFactoryRegistration() {
		return factoryRegistration;
	}

	public void setFactoryRegistration(String factoryRegistration) {
		this.factoryRegistration = factoryRegistration;
	}

	public String getFactoryAccount() {
		return factoryAccount;
	}

	public void setFactoryAccount(String factoryAccount) {
		this.factoryAccount = factoryAccount;
	}

	public String getFactoryAddress() {
		return factoryAddress;
	}

	public void setFactoryAddress(String factoryAddress) {
		this.factoryAddress = factoryAddress;
	}

	@Override
	public String toString() {
		return "Factory [factoryId=" + factoryId + ", factoryName=" + factoryName + ", factotyCeoname=" + factotyCeoname
				+ ", number=" + number + ", factoryRegistration=" + factoryRegistration + ", factoryAccount="
				+ factoryAccount + ", factoryAddress=" + factoryAddress + "]";
	}
	
	
	
	
}
