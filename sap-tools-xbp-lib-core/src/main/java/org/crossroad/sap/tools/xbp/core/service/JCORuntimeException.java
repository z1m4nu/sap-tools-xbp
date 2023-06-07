/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.service;

/**
 * @author e.soden
 *
 */
public class JCORuntimeException extends RuntimeException {

	private final int errId;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public JCORuntimeException(int id) {
		this.errId = id;
	}

	/**
	 * @param message
	 */
	public JCORuntimeException(String message, int id) {
		super(message);
		this.errId = id;
	}

	/**
	 * @param cause
	 */
	public JCORuntimeException(Throwable cause, int id) {
		super(cause);
		this.errId = id;
	}

	/**
	 * @param message
	 * @param cause
	 */
	public JCORuntimeException(String message, Throwable cause, int id) {
		super(message, cause);
		this.errId = id;
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public JCORuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int id) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errId = id;
	}
	
	public int getErrId() {
		return errId;
	}

}
