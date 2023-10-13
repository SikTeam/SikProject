package org.ict.sik.mu.model.vo;

import java.sql.Date;

//메뉴 vo
public class Mu {
	public String muId; //메뉴ID
	public String muName; //메뉴명
	public String muPrice; // 가격
	public String muYn; //활성화YN
	public Date muEnDate; //등록일
	public Date muModDate; //수정일
	public String brandId; //브랜드ID

	public Mu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mu(String muId, String muName, String muPrice, String muYn, Date muEnDate, Date muModDate, String brandId) {
		super();
		this.muId = muId;
		this.muName = muName;
		this.muPrice = muPrice;
		this.muYn = muYn;
		this.muEnDate = muEnDate;
		this.muModDate = muModDate;
		this.brandId = brandId;
	}

	public String getMuId() {
		return muId;
	}

	public void setMuId(String muId) {
		this.muId = muId;
	}

	public String getMuName() {
		return muName;
	}

	public void setMuName(String muName) {
		this.muName = muName;
	}

	public String getMuPrice() {
		return muPrice;
	}

	public void setMuPrice(String muPrice) {
		this.muPrice = muPrice;
	}

	public String getMuYn() {
		return muYn;
	}

	public void setMuYn(String muYn) {
		this.muYn = muYn;
	}

	public Date getMuEnDate() {
		return muEnDate;
	}

	public void setMuEnDate(Date muEnDate) {
		this.muEnDate = muEnDate;
	}

	public Date getMuModDate() {
		return muModDate;
	}

	public void setMuModDate(Date muModDate) {
		this.muModDate = muModDate;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	@Override
	public String toString() {
		return "Mu [muId=" + muId + ", muName=" + muName + ", muPrice=" + muPrice + ", muYn=" + muYn + ", muEnDate="
				+ muEnDate + ", muModDate=" + muModDate + ", brandId=" + brandId + "]";
	}
	
	
}
