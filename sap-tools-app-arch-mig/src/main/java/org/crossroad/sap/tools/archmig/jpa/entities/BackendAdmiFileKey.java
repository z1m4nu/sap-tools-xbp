/**
 * 
 */
package org.crossroad.sap.tools.archmig.jpa.entities;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * @author e.soden
 *
 */
@Setter
@Getter
public class BackendAdmiFileKey implements Serializable {
	private static final long serialVersionUID = 1L;
	private String document;
	private String archivKey;
	private String sid;
	private long runId;

	
}
