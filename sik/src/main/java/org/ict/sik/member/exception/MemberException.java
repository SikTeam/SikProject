package org.ict.sik.member.exception;

public class MemberException extends Exception implements java.io.Serializable{
	private static final long serialVersionUID = -7223692723962815291L;

	public MemberException(String message) {
		super(message);
	}
}
