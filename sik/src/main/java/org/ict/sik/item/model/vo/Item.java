package org.ict.sik.item.model.vo;

//상품 vo
public class Item {
	private String itemId; //상품ID
	private String itemName; //상품명
	private String itemPrice; //가격
	private String itemYn; //활성화YN
	private String secondCategoryId; //2차ID
	
	public Item() {
		super();
	}

	public Item(String itemId, String itemName, String itemPrice, String itemYn, String secondCategoryId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemYn = itemYn;
		this.secondCategoryId = secondCategoryId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemYn() {
		return itemYn;
	}

	public void setItemYn(String itemYn) {
		this.itemYn = itemYn;
	}

	public String getSecondCategoryId() {
		return secondCategoryId;
	}

	public void setSecondCategoryId(String secondCategoryId) {
		this.secondCategoryId = secondCategoryId;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemYn=" + itemYn
				+ ", secondCategoryId=" + secondCategoryId + "]";
	}
	
	
	
}
