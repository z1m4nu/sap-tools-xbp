/**
 * 
 */
package org.crossroad.sap.tools.archmig;

import lombok.Getter;
import lombok.Setter;

/**
 * @author e.soden
 *
 */
@Setter
@Getter
public class ArchiveMigrationConfig {
	private String destination;
	private String srcArcId;
	private String dstArcId;
}
