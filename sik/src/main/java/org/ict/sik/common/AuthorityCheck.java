package org.ict.sik.common;

public class AuthorityCheck {
	
	public static boolean Authority(String authority, String authorityCheck) {
		return authority.equals(authorityCheck)?true:false;
	}
	
	
}