/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.bapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author e.soden
 *
 */
@Data
public class BAPIXMRECIP extends AbstractBAPI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("RECIPIENT")
	private String recipient;
	@JsonProperty("REC_TYPE")
	private char recType;
	@JsonProperty("COPY")
	private char copy;
	@JsonProperty("BLIND_COPY")
	private char blindCopy;
	@JsonProperty("EXPRESS")
	private char express;
	@JsonProperty("NO_FORWARDING")
	private char noForwarding;
	@JsonProperty("DELIVER")
	private char deliver;
	@JsonProperty("NO_PRINT")
	private char noPrint;
	@JsonProperty("MAILSTATUS")
	private char mailstatus;


}
