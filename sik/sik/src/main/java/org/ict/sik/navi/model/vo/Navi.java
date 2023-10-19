package org.ict.sik.navi.model.vo;

//지도
public class Navi {
	public String fcId; //가맹점ID
	public String fcAddress; //주소
	public String fcX; //X
	public String fcY; //Y
	
	public Navi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Navi(String fcId, String fcAddress, String fcX, String fcY) {
		super();
		this.fcId = fcId;
		this.fcAddress = fcAddress;
		this.fcX = fcX;
		this.fcY = fcY;
	}

	public String getFcId() {
		return fcId;
	}

	public void setFcId(String fcId) {
		this.fcId = fcId;
	}

	public String getFcAddress() {
		return fcAddress;
	}

	public void setFcAddress(String fcAddress) {
		this.fcAddress = fcAddress;
	}

	public String getFcX() {
		return fcX;
	}

	public void setFcX(String fcX) {
		this.fcX = fcX;
	}

	public String getFcY() {
		return fcY;
	}

	public void setFcY(String fcY) {
		this.fcY = fcY;
	}

	@Override
	public String toString() {
		return "Map [fcId=" + fcId + ", fcAddress=" + fcAddress + ", fcX=" + fcX + ", fcY=" + fcY + "]";
	}
	
	
}
