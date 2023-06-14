/**
 * 
 */
package org.crossroad.sap.tools.archmig.data;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author e.soden
 *
 */
@Getter
@Setter
public class ArchiveMigResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long total;
	private long migrate;
	private long error;
	private long bypass;
	private long runId;
	private Status status;

}
