package org.ict.sik.ordersimple.model.vo;

//발주 vo
public class OrderSimple {
	public String orderId; //발주ID
	public String fcId; //가맹점ID
	
	public OrderSimple() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderSimple(String orderId, String fcId) {
		super();
		this.orderId = orderId;
		this.fcId = fcId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getFcId() {
		return fcId;
	}
	public void setFcId(String fcId) {
		this.fcId = fcId;
	}
	@Override
	public String toString() {
		return "OrderSimple [orderId=" + orderId + ", fcId=" + fcId + "]";
	}
	
	
}
