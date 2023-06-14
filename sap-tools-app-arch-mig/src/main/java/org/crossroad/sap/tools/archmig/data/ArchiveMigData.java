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
@Setter
@Getter
public class ArchiveMigData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String destination;
	private String srcArcId;
	private String dstArcId;

}
