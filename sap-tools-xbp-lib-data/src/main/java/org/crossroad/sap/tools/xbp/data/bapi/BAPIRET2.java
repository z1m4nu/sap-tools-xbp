/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.bapi;

import lombok.Data;

/**
 * @author e.soden
 *
 */
@Data
public class BAPIRET2 extends AbstractBAPI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private char TYPE;
	private String ID;
	private Integer NUMBER;
	private String MESSAGE;
	private String LOG_NO;
	private Integer LOG_MSG_NO;
	private String MESSAGE_V1;
	private String MESSAGE_V2;
	private String MESSAGE_V3;
	private String MESSAGE_V4;
	private String PARAMETER;
	private String ROW;
	private String FIELD;
	private String SYSTEM;
}
