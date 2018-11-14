package com.itany.rent.exception;

public class UserStatusInvalidException extends Exception {

	public UserStatusInvalidException() {
		super();
	}

	public UserStatusInvalidException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserStatusInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserStatusInvalidException(String message) {
		super(message);
	}

	public UserStatusInvalidException(Throwable cause) {
		super(cause);
	}

}
