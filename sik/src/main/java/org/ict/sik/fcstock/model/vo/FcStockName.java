package org.ict.sik.fcstock.model.vo;

public class FcStockName extends FcStock{
	
	private String fcName;
	private String itemName;
	
	public FcStockName() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FcStockName(String itemId, String fcId, String fcStockQuan, String fcStockEtc) {
		super(itemId, fcId, fcStockQuan, fcStockEtc);
		// TODO Auto-generated constructor stub
	}
	public String getFcName() {
		return fcName;
	}
	public void setFcName(String fcName) {
		this.fcName = fcName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public FcStockName(String fcName, String itemName) {
		super();
		this.fcName = fcName;
		this.itemName = itemName;
	}
	@Override
	public String toString() {
		return "FcStockName [fcName=" + fcName + ", itemName=" + itemName + "]";
	}
	
	
	
}
