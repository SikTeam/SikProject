package org.ict.sik.repu.model.vo;

import java.util.Date;

public class Repu {
	private String repuId;
	private String brandId;
	private Date repuDate;
	
	public Repu() {
		super();
	}

	public Repu(String repuId, String brandId, Date repuDate) {
		super();
		this.repuId = repuId;
		this.brandId = brandId;
		this.repuDate = repuDate;
	}

	public String getRepuId() {
		return repuId;
	}

	public void setRepuId(String repuId) {
		this.repuId = repuId;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public Date getRepuDate() {
		return repuDate;
	}

	public void setRepuDate(Date repuDate) {
		this.repuDate = repuDate;
	}

	@Override
	public String toString() {
		return "Repu [repuId=" + repuId + ", brandId=" + brandId + ", repuDate=" + repuDate + "]";
	}
	
	
}
