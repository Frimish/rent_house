package com.itany.jdbc.exception;

/**
 * 数据访问异常
 */
public class DataAccessException extends RuntimeException {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6672221094093815744L;

	public DataAccessException() {
	}

	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(Throwable cause) {
		super(cause);
	}

	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

}
