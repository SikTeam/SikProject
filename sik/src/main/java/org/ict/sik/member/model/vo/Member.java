package org.ict.sik.member.model.vo;

public class Member implements java.io.Serializable{
	private static final long serialVersionUID = -8259111127292047344L;
	private String memberId;		//사번
	private String memberName;	//이름
	private String pw;				//패스워드
	private String enrollDate;		//입사일
	private String adminYn;		//관리자YN
	private String superiorId;		//상급자사번
	private String deptId;			//부서ID
	private String positionId;		//직책ID
	
	public Member() {
		super();
	}

	/**
	 * @param memberId
	 * @param memberName
	 * @param pw
	 * @param adminYn
	 * @param superiorId
	 * @param deptId
	 * @param positionId
	 */

	public Member(String memberId, String memberName, String pw, String enrollDate, String adminYn, String superiorId, String deptId,
			String positionId) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.pw = pw;
		this.enrollDate = enrollDate;
		this.adminYn = adminYn;
		this.superiorId = superiorId;
		this.deptId = deptId;
		this.positionId = positionId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getAdminYn() {
		return adminYn;
	}

	public void setAdminYn(String adminYn) {
		this.adminYn = adminYn;
	}

	public String getSuperiorId() {
		return superiorId;
	}

	public void setSuperiorId(String superiorId) {
		this.superiorId = superiorId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", pw=" + pw + ", enrollDate="
				+ enrollDate + ", adminYn=" + adminYn + ", superiorId=" + superiorId + ", deptId=" + deptId
				+ ", positionId=" + positionId + "]";
	}
	
}
