package org.ict.sik.brandstock.model.vo;

public class BrandStockName extends BrandStock{
	
	private String brandName;
	private String itemName;
	
	
	public BrandStockName() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BrandStockName(String brandId, String itemId, int brStockQuan, String brStockEtc) {
		super(brandId, itemId, brStockQuan, brStockEtc);
		// TODO Auto-generated constructor stub
	}
	public BrandStockName(String brandName, String itemName) {
		super();
		this.brandName = brandName;
		this.itemName = itemName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	@Override
	public String toString() {
		return "BrandStockName [brandName=" + brandName + ", itemName=" + itemName + "]";
	}
	
	
	
}
