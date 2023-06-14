/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.result;

import java.io.Serializable;

import org.crossroad.sap.tools.xbp.data.bapi.BAPIRET2;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author e.soden
 *
 */
@Data
public abstract class AbstractJCoResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("RETURN")
	private BAPIRET2 bapiret2;


}
