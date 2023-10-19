package org.ict.sik.brandstock.model.vo;

//재고-브랜드 vo
public class BrandStock {
	public String brandId; //브랜드ID
	public String itemId; //상품ID
	public int brStockQuan; //수량
	public String brStockEtc; //비고
	
	public BrandStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BrandStock(String brandId, String itemId, int brStockQuan, String brStockEtc) {
		super();
		this.brandId = brandId;
		this.itemId = itemId;
		this.brStockQuan = brStockQuan;
		this.brStockEtc = brStockEtc;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getBrStockQuan() {
		return brStockQuan;
	}

	public void setBrStockQuan(int brStockQuan) {
		this.brStockQuan = brStockQuan;
	}

	public String getBrStockEtc() {
		return brStockEtc;
	}

	public void setBrStockEtc(String brStockEtc) {
		this.brStockEtc = brStockEtc;
	}

	@Override
	public String toString() {
		return "BrandStock [brandId=" + brandId + ", itemId=" + itemId + ", brStockQuan=" + brStockQuan
				+ ", brStockEtc=" + brStockEtc + "]";
	}
	
	
}
