package org.ict.sik.position.model.vo;

//직책
public class Position {
	public String position; //직책ID
	public String positionName; //직책명
	
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Position(String position, String positionName) {
		super();
		this.position = position;
		this.positionName = positionName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	@Override
	public String toString() {
		return "Position [position=" + position + ", positionName=" + positionName + "]";
	}
	
	
}
