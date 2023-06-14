/**
 * 
 */
package org.crossroad.sap.tools.jco.service;

/**
 * @author e.soden
 *
 */
public class JCORuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public JCORuntimeException() {
	}

	/**
	 * @param message
	 */
	public JCORuntimeException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public JCORuntimeException(Throwable cause) {
		super(cause);
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public JCORuntimeException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public JCORuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}
	

}
