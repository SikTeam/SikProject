package org.ict.sik.addmu.model.vo;

//가맹-메뉴추가
public class AddMu {
	public String fcId; //가맹점ID
	public String addMuId; //추가메뉴ID
	public String addMuName; //추가메뉴명
	public String addMuPrice; //추가메뉴가격
	
	public AddMu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddMu(String fcId, String addMuId, String addMuName, String addMuPrice) {
		super();
		this.fcId = fcId;
		this.addMuId = addMuId;
		this.addMuName = addMuName;
		this.addMuPrice = addMuPrice;
	}

	public String getFcId() {
		return fcId;
	}

	public void setFcId(String fcId) {
		this.fcId = fcId;
	}

	public String getAddMuId() {
		return addMuId;
	}

	public void setAddMuId(String addMuId) {
		this.addMuId = addMuId;
	}

	public String getAddMuName() {
		return addMuName;
	}

	public void setAddMuName(String addMuName) {
		this.addMuName = addMuName;
	}

	public String getAddMuPrice() {
		return addMuPrice;
	}

	public void setAddMuPrice(String addMuPrice) {
		this.addMuPrice = addMuPrice;
	}

	@Override
	public String toString() {
		return "AddMu [fcId=" + fcId + ", addMuId=" + addMuId + ", addMuName=" + addMuName + ", addMuPrice="
				+ addMuPrice + "]";
	}
	
	
}
