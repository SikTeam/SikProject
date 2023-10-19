package org.ict.sik.orderdetail.model.vo;

import java.sql.Date;

//발주상세 vo
public class OrderDetail {
	public String productId; //상품ID
	public String orderId; //발주ID
	public int oredrQuantity; //발주수량
	public String orderState; //발주처리상태
	public Date orderDate; //발주일
	
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(String productId, String orderId, int oredrQuantity, String orderState, Date orderDate) {
		super();
		this.productId = productId;
		this.orderId = orderId;
		this.oredrQuantity = oredrQuantity;
		this.orderState = orderState;
		this.orderDate = orderDate;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getOredrQuantity() {
		return oredrQuantity;
	}
	public void setOredrQuantity(int oredrQuantity) {
		this.oredrQuantity = oredrQuantity;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "OrderDetail [productId=" + productId + ", orderId=" + orderId + ", oredrQuantity=" + oredrQuantity
				+ ", orderState=" + orderState + ", orderDate=" + orderDate + "]";
	}
	
	
}
