package org.ict.sik.brand.model.vo;

import java.util.Date;

public class Brand {
	private String brandId;
	private String brandName;
	private Date brandBir;
	private Date brandUp;
	private String brandYn;
	
	public Brand() {
		super();
	}

	public Brand(String brandId, String brandName, Date brandBir, Date brandUp, String brandYn) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
		this.brandBir = brandBir;
		this.brandUp = brandUp;
		this.brandYn = brandYn;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Date getBrandBir() {
		return brandBir;
	}

	public void setBrandBir(Date brandBir) {
		this.brandBir = brandBir;
	}

	public Date getBrandUp() {
		return brandUp;
	}

	public void setBrandUp(Date brandUp) {
		this.brandUp = brandUp;
	}

	public String getBrandYn() {
		return brandYn;
	}

	public void setBrandYn(String brandYn) {
		this.brandYn = brandYn;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandName=" + brandName + ", brandBir=" + brandBir + ", brandUp="
				+ brandUp + ", brandYn=" + brandYn + "]";
	}
}
