/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.data;

import java.io.Serializable;

/**
 * @author e.soden
 *
 */
public class JobExecution  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;
	private String mode;
	private String targetServer;
	private String targetGroup;
	
	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * @return the targetServer
	 */
	public String getTargetServer() {
		return targetServer;
	}
	/**
	 * @param targetServer the targetServer to set
	 */
	public void setTargetServer(String targetServer) {
		this.targetServer = targetServer;
	}
	/**
	 * @return the targetGroup
	 */
	public String getTargetGroup() {
		return targetGroup;
	}
	/**
	 * @param targetGroup the targetGroup to set
	 */
	public void setTargetGroup(String targetGroup) {
		this.targetGroup = targetGroup;
	}
	

}
