package org.ict.sik.menureaction.model.vo;

//메뉴반응 vo
public class MenuReaction {
	private String menuReactionId; //메뉴반응ID
	private String muId; //메뉴ID
	
	public MenuReaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuReaction(String menuReactionId, String muId) {
		super();
		this.menuReactionId = menuReactionId;
		this.muId = muId;
	}

	public String getMenuReactionId() {
		return menuReactionId;
	}

	public void setMenuReactionId(String menuReactionId) {
		this.menuReactionId = menuReactionId;
	}

	public String getMuId() {
		return muId;
	}

	public void setMuId(String muId) {
		this.muId = muId;
	}

	@Override
	public String toString() {
		return "MenuReaction [menuReactionId=" + menuReactionId + ", muId=" + muId + "]";
	}
	
	
}
