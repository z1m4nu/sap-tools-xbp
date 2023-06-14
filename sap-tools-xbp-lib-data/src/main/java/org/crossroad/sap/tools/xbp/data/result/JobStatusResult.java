/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.result;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author e.soden
 *
 */
@Data
public class JobStatusResult extends AbstractJCoResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("STATUS")
	private char status;
	
	@JsonProperty("CHAR1")
	private char ch1;
	
	@JsonProperty("HAS_CHILD")
	private char hasChild;

}
