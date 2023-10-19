package org.ict.sik.member.model.vo;

public class MemberDeptPosition extends Member{
	private static final long serialVersionUID = -8329420196448513034L;
	
	private String deptName;
	private String positionName;
	
	

	public MemberDeptPosition() {
		super();
	}

	public MemberDeptPosition(String deptName, String positionName) {
		super();
		this.deptName = deptName;
		this.positionName = positionName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	@Override
	public String toString() {
		return "DeptPosition [deptName=" + deptName + ", positionName=" + positionName + "]";
	}
	
	
}
