package org.ict.sik.produce.model.vo;

import java.sql.Date;

//생산 vo
public class Produce {
	private String produceId; //생산ID
	private String productId; //상품ID
	private String factoryId; //생산업체 ID
	private int produceQuantity; //생산수량
	private Date produceDate; //생산일
	private String producePrice; //생산원가
	
	public Produce() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produce(String produceId, String productId, String factoryId, int produceQuantity, Date produceDate,
			String producePrice) {
		super();
		this.produceId = produceId;
		this.productId = productId;
		this.factoryId = factoryId;
		this.produceQuantity = produceQuantity;
		this.produceDate = produceDate;
		this.producePrice = producePrice;
	}

	public String getProduceId() {
		return produceId;
	}

	public void setProduceId(String produceId) {
		this.produceId = produceId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}

	public int getProduceQuantity() {
		return produceQuantity;
	}

	public void setProduceQuantity(int produceQuantity) {
		this.produceQuantity = produceQuantity;
	}

	public Date getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(Date produceDate) {
		this.produceDate = produceDate;
	}

	public String getProducePrice() {
		return producePrice;
	}

	public void setProducePrice(String producePrice) {
		this.producePrice = producePrice;
	}

	@Override
	public String toString() {
		return "Produce [produceId=" + produceId + ", productId=" + productId + ", factoryId=" + factoryId
				+ ", produceQuantity=" + produceQuantity + ", produceDate=" + produceDate + ", producePrice="
				+ producePrice + "]";
	}
	
	
	
	
}
