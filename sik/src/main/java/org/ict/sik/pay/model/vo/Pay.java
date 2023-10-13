package org.ict.sik.pay.model.vo;

//주문,결제내역 vo
public class Pay {
	public String payId; //주문번호
	public String payTime; //주문시간
	public String payCon; //주문내역
	public String payType; //결제타입
	public String payTake; //수령방법
	public String payPrice; //결제금액
	public String payStatus; //상태
	public String fcId; //가맹점ID
	public String muId; //메뉴ID
	
	public Pay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pay(String payId, String payTime, String payCon, String payType, String payTake, String payPrice,
			String payStatus, String fcId, String muId) {
		super();
		this.payId = payId;
		this.payTime = payTime;
		this.payCon = payCon;
		this.payType = payType;
		this.payTake = payTake;
		this.payPrice = payPrice;
		this.payStatus = payStatus;
		this.fcId = fcId;
		this.muId = muId;
	}

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getPayCon() {
		return payCon;
	}

	public void setPayCon(String payCon) {
		this.payCon = payCon;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPayTake() {
		return payTake;
	}

	public void setPayTake(String payTake) {
		this.payTake = payTake;
	}

	public String getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(String payPrice) {
		this.payPrice = payPrice;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
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

	@Override
	public String toString() {
		return "Pay [payId=" + payId + ", payTime=" + payTime + ", payCon=" + payCon + ", payType=" + payType
				+ ", payTake=" + payTake + ", payPrice=" + payPrice + ", payStatus=" + payStatus + ", fcId=" + fcId
				+ ", muId=" + muId + "]";
	}
	
	
}
