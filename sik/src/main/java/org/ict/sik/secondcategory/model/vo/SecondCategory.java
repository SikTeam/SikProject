package org.ict.sik.secondcategory.model.vo;

//2차 카테고리 vo
public class SecondCategory {
	private String secondCategoryId; //2차ID
	private String secondCategoryName; //2차카테고리명
	private String fristCategoryId; //1차ID
	
	public SecondCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SecondCategory(String secondCategoryId, String secondCategoryName, String fristCategoryId) {
		super();
		this.secondCategoryId = secondCategoryId;
		this.secondCategoryName = secondCategoryName;
		this.fristCategoryId = fristCategoryId;
	}

	public String getSecondCategoryId() {
		return secondCategoryId;
	}

	public void setSecondCategoryId(String secondCategoryId) {
		this.secondCategoryId = secondCategoryId;
	}

	public String getSecondCategoryName() {
		return secondCategoryName;
	}

	public void setSecondCategoryName(String secondCategoryName) {
		this.secondCategoryName = secondCategoryName;
	}

	public String getFristCategoryId() {
		return fristCategoryId;
	}

	public void setFristCategoryId(String fristCategoryId) {
		this.fristCategoryId = fristCategoryId;
	}

	@Override
	public String toString() {
		return "SecondCategory [secondCategoryId=" + secondCategoryId + ", secondCategoryName=" + secondCategoryName
				+ ", fristCategoryId=" + fristCategoryId + "]";
	}
	
	
}
