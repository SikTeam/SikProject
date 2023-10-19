package org.ict.sik.inspection.model.vo;

public class Inspection {
	private String mgId;
	private String checklist;
	private String remarks;
	
	public Inspection() {
		super();
	}

	public Inspection(String mgId, String checklist, String remarks) {
		super();
		this.mgId = mgId;
		this.checklist = checklist;
		this.remarks = remarks;
	}

	public String getMgId() {
		return mgId;
	}

	public void setMgId(String mgId) {
		this.mgId = mgId;
	}

	public String getChecklist() {
		return checklist;
	}

	public void setChecklist(String checklist) {
		this.checklist = checklist;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Inspection [mgId=" + mgId + ", checklist=" + checklist + ", remarks=" + remarks + "]";
	}
	
	
}
