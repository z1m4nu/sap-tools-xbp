/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.job;

import org.crossroad.sap.tools.xbp.data.OPERATION;

/**
 * @author e.soden
 *
 */
public class JobOptions {
	private OPERATION operation;
	private String jobFile;
	private String waitTime;
	private String destination;

	/**
	 * @return the operation
	 */
	public OPERATION getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(OPERATION operation) {
		this.operation = operation;
	}

	/**
	 * @return the jobFile
	 */
	public String getJobFile() {
		return jobFile;
	}

	/**
	 * @param jobFile the jobFile to set
	 */
	public void setJobFile(String jobFile) {
		this.jobFile = jobFile;
	}

	/**
	 * @return the waitTime
	 */
	public String getWaitTime() {
		return waitTime;
	}

	/**
	 * @param waitTime the waitTime to set
	 */
	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

}
