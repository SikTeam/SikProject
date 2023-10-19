package org.ict.sik.fcmu.model.vo;

//가맹-메뉴수정 vo
public class FcMu {
	public String fcId; //가맹점ID
	public String muId; //메뉴ID
	public String fcMuName; //수정메뉴명
	public String fcMuPrice; //수정가격
	
	public FcMu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FcMu(String fcId, String muId, String fcMuName, String fcMuPrice) {
		super();
		this.fcId = fcId;
		this.muId = muId;
		this.fcMuName = fcMuName;
		this.fcMuPrice = fcMuPrice;
	}

	public String getFcId() {
		return fcId;
	}

	public void setFcId(String fcId) {
		this.fcId = fcId;
	}

	public String getMuId() {
		return muId;
	}

	public void setMuId(String muId) {
		this.muId = muId;
	}

	public String getFcMuName() {
		return fcMuName;
	}

	public void setFcMuName(String fcMuName) {
		this.fcMuName = fcMuName;
	}

	public String getFcMuPrice() {
		return fcMuPrice;
	}

	public void setFcMuPrice(String fcMuPrice) {
		this.fcMuPrice = fcMuPrice;
	}

	@Override
	public String toString() {
		return "FcMu [fcId=" + fcId + ", muId=" + muId + ", fcMuName=" + fcMuName + ", fcMuPrice=" + fcMuPrice + "]";
	}
	
}
