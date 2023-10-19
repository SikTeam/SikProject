package org.ict.sik.firstcategory.model.vo;

//1차 카테고리 vo
public class FirstCategory {
	private String firstCategoryId; //1차ID
	private String firstCategoryName; //1차카테고리명
	
	public FirstCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FirstCategory(String firstCategoryId, String firstCategoryName) {
		super();
		this.firstCategoryId = firstCategoryId;
		this.firstCategoryName = firstCategoryName;
	}

	public String getFirstCategoryId() {
		return firstCategoryId;
	}

	public void setFirstCategoryId(String firstCategoryId) {
		this.firstCategoryId = firstCategoryId;
	}

	public String getFirstCategoryName() {
		return firstCategoryName;
	}

	public void setFirstCategoryName(String firstCategoryName) {
		this.firstCategoryName = firstCategoryName;
	}

	@Override
	public String toString() {
		return "FristCategory [firstCategoryId=" + firstCategoryId + ", firstCategoryName=" + firstCategoryName + "]";
	}
	
	
}
