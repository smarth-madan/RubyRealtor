package org.springframework.social.showcase.customer.helper;

public enum MaritalStatusEnum {

	SINGLE(0,"Single"),
	MARRIED(1, "Married"),
	UNKNOWN(2, "Unknown"),
	ANNULLED(3,"Annuled"),
	DIVORCED(4,"Divorced"),
	SEPARATED(5,"Separated"),
	WIDOWED(6,"Widowed");

	private int code;
	private String message;

	private MaritalStatusEnum(final int code, String msg) {
		this.code = code;
		this.message= msg;
	}

	public int getCode() {
		return code;
	}

	public String getMessage(){
		return message;
	}
}