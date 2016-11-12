package com.usermanagement.commons.exception;

public class UMException  extends Exception {

	private static final long serialVersionUID = 1L;

	public UMException() {

	}

	public UMException(String s) {
		super(s);
	}

	public UMException(Throwable cause){
		super(cause);
	}
	
	public UMException(String message, Throwable cause) {
		super(message, cause);
	}

	/*public UMException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
		super(message,cause,enableSuppression,writableStackTrace);  
	}*/

}
