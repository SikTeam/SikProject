package org.ict.sik.request.model.vo;

//요청사항 vo
public class Request {
	private String mgId; //매장관리ID
	private String reqContent; //요청내용
	private String reqState;// 진행상태
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(String mgId, String reqContent, String reqState) {
		super();
		this.mgId = mgId;
		this.reqContent = reqContent;
		this.reqState = reqState;
	}

	public String getMgId() {
		return mgId;
	}

	public void setMgId(String mgId) {
		this.mgId = mgId;
	}

	public String getReqContent() {
		return reqContent;
	}

	public void setReqContent(String reqContent) {
		this.reqContent = reqContent;
	}

	public String getReqState() {
		return reqState;
	}

	public void setReqState(String reqState) {
		this.reqState = reqState;
	}

	@Override
	public String toString() {
		return "Request [mgId=" + mgId + ", reqContent=" + reqContent + ", reqState=" + reqState + "]";
	}
	
	
}
