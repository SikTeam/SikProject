package org.ict.sik.fcstock.model.vo;

public class FcStockName extends FcStock{
	
	private String fcName; //매장명
	private String itemId; //상품ID
	private String fcId; //가맹점ID
	private String fcStockQuan; //수량
	private String fcStockEtc; //비고
	
	public String getFcName() {
		return fcName;
	}
	public void setFcName(String fcName) {
		this.fcName = fcName;
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
	public FcStockName(String fcName, String itemId, String fcId, String fcStockQuan, String fcStockEtc) {
		super();
		this.fcName = fcName;
		this.itemId = itemId;
		this.fcId = fcId;
		this.fcStockQuan = fcStockQuan;
		this.fcStockEtc = fcStockEtc;
	}
	@Override
	public String toString() {
		return "FcStockName [fcName=" + fcName + ", itemId=" + itemId + ", fcId=" + fcId + ", fcStockQuan="
				+ fcStockQuan + ", fcStockEtc=" + fcStockEtc + "]";
	}
	public FcStockName() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FcStockName(String itemId, String fcId, String fcStockQuan, String fcStockEtc) {
		super(itemId, fcId, fcStockQuan, fcStockEtc);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
