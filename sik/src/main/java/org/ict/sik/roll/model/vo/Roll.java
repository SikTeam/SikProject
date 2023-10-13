package org.ict.sik.roll.model.vo;

//권한 vo
public class Roll {
	public String deptId; //부서ID
	public String positionId; //직책ID
	public String roll; //권한
	
	public Roll() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Roll(String deptId, String positionId, String roll) {
		super();
		this.deptId = deptId;
		this.positionId = positionId;
		this.roll = roll;
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
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	@Override
	public String toString() {
		return "Roll [deptId=" + deptId + ", positionId=" + positionId + ", roll=" + roll + "]";
	}
	
	
}
