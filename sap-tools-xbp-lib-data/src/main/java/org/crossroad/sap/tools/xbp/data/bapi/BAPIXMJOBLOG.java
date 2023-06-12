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
public class BAPIXMJOBLOG extends AbstractBAPI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("TMSNAME")
	private String tmsName;
	@JsonProperty("TMSCLIENT")
	private String tmsClient;
	@JsonProperty("CHARCO")
	private Integer charco;
	@JsonProperty("LANGU")
	private String langu;
	@JsonProperty("TMSSIZE")
	private Integer tmsSize;


}
