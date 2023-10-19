package org.ict.sik.fcstock.model.vo;

//재고-가맹점 vo
public class FcStock {
	private String itemId; //상품ID
	private String fcId; //가맹점ID
	private String fcStockQuan; //수량
	private String fcStockEtc; //비고
	
	
	public FcStock() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FcStock(String itemId, String fcId, String fcStockQuan, String fcStockEtc) {
		super();
		this.itemId = itemId;
		this.fcId = fcId;
		this.fcStockQuan = fcStockQuan;
		this.fcStockEtc = fcStockEtc;
	}


	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	public String getFcId() {
		return fcId;
	}


	public void setFcId(String fcId) {
		this.fcId = fcId;
	}


	public String getFcStockQuan() {
		return fcStockQuan;
	}


	public void setFcStockQuan(String fcStockQuan) {
		this.fcStockQuan = fcStockQuan;
	}


	public String getFcStockEtc() {
		return fcStockEtc;
	}


	public void setFcStockEtc(String fcStockEtc) {
		this.fcStockEtc = fcStockEtc;
	}


	@Override
	public String toString() {
		return "FcStock [itemId=" + itemId + ", fcId=" + fcId + ", fcStockQuan=" + fcStockQuan + ", fcStockEtc="
				+ fcStockEtc + "]";
	}
	
	
}
