package org.ict.sik.reitem.model.vo;

//레시피 vo
public class ReItem {
	private String itemId; //상품ID
	private String muId; //메뉴ID
	private int reItemCount; //상품수량
	
	public ReItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReItem(String itemId, String muId, int reItemCount) {
		super();
		this.itemId = itemId;
		this.muId = muId;
		this.reItemCount = reItemCount;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getMuId() {
		return muId;
	}

	public void setMuId(String muId) {
		this.muId = muId;
	}

	public int getReItemCount() {
		return reItemCount;
	}

	public void setReItemCount(int reItemCount) {
		this.reItemCount = reItemCount;
	}

	@Override
	public String toString() {
		return "ReItem [itemId=" + itemId + ", muId=" + muId + ", reItemCount=" + reItemCount + "]";
	}

	
}
