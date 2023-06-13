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
public class BAPIRET2 extends AbstractBAPI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@JsonProperty("TYPE")
	private char type;
	@JsonProperty("ID")
	private String id;
	@JsonProperty("NUMBER")
	private Integer number;
	@JsonProperty("MESSAGE")
	private String message;
	@JsonProperty("LOG_NO")
	private String logNo;
	@JsonProperty("LOG_MSG_NO")
	private Integer LogMsgNo;
	@JsonProperty("MESSAGE_V1")
	private String messageV1;
	@JsonProperty("MESSAGE_V2")
	private String messageV2;
	@JsonProperty("MESSAGE_V3")
	private String messageV3;
	@JsonProperty("MESSAGE_V4")
	private String messageV4;
	@JsonProperty("PARAMETER")
	private String parameter;
	@JsonProperty("ROW")
	private String row;
	@JsonProperty("FIELD")
	private String field;
	@JsonProperty("SYSTEM")
	private String system;
}
