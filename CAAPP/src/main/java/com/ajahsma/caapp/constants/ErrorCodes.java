package com.ajahsma.caapp.constants;

/**
 * @author devappa_arali
 *
 */
public enum ErrorCodes 
{
	EORMEXISTS("Email/Mobile already exists");
	
	private final String value;

	private ErrorCodes(String value) {
		this.value = value;
	}
	
	public String value() {
        return value;
    }

    public static ErrorCodes fromValue(String value) {
        for (ErrorCodes appCode : ErrorCodes.values()) {
            if (appCode.value.equals(value)) {
                return appCode;
            }
        }
        throw new IllegalArgumentException(value);
    }
}
