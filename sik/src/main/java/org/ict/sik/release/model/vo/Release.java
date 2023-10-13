package org.ict.sik.release.model.vo;

//출고 vo
import java.sql.Date;

public class Release {
	private String releaseId; //출고ID
	private String productId; //상품ID
	private String franchiseId; //가맹점ID
	private int releaseQuantity; //출고수량
	private Date relaseDate; //생산일
	
	public Release() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Release(String releaseId, String productId, String franchiseId, int releaseQuantity, Date relaseDate) {
		super();
		this.releaseId = releaseId;
		this.productId = productId;
		this.franchiseId = franchiseId;
		this.releaseQuantity = releaseQuantity;
		this.relaseDate = relaseDate;
	}




	public String getReleaseId() {
		return releaseId;
	}




	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}




	public String getProductId() {
		return productId;
	}




	public void setProductId(String productId) {
		this.productId = productId;
	}




	public String getFranchiseId() {
		return franchiseId;
	}




	public void setFranchiseId(String franchiseId) {
		this.franchiseId = franchiseId;
	}




	public int getReleaseQuantity() {
		return releaseQuantity;
	}




	public void setReleaseQuantity(int releaseQuantity) {
		this.releaseQuantity = releaseQuantity;
	}




	public Date getRelaseDate() {
		return relaseDate;
	}




	public void setRelaseDate(Date relaseDate) {
		this.relaseDate = relaseDate;
	}




	@Override
	public String toString() {
		return "Release [releaseId=" + releaseId + ", productId=" + productId + ", franchiseId=" + franchiseId
				+ ", releaseQuantity=" + releaseQuantity + ", relaseDate=" + relaseDate + "]";
	}
	
	
	
	
	
}
