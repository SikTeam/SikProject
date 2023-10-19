package org.ict.sik.common;

import java.sql.Date;

public class Search {
	private String keyword;
	private String brand; // 브랜드 검색 시 필요
	private int startRow;  //페이지에 출력할 시작행
	private int endRow;   //페이지에 출력할 끝행
	private Date begin;
	private Date end;
	private int age;	//나이 검색 시 필요
	private String searchOption;
	
	public Search() {
		super();
	}
	public Search(String keyword, String brand, int startRow, int endRow, Date begin, Date end, int age,
			String searchOption) {
		super();
		this.keyword = keyword;
		this.brand = brand;
		this.startRow = startRow;
		this.endRow = endRow;
		this.begin = begin;
		this.end = end;
		this.age = age;
		this.searchOption = searchOption;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSearchOption() {
		return searchOption;
	}
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	@Override
	public String toString() {
		return "Search [keyword=" + keyword + ", brand=" + brand + ", startRow=" + startRow + ", endRow=" + endRow
				+ ", begin=" + begin + ", end=" + end + ", age=" + age + ", searchOption=" + searchOption + "]";
	}
	
		
}
