package org.crossroad.sap.tools.xbp.data.job;

import java.io.Serializable;

public class Job implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String jobCount;
	private String jobClass;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getJobCount() {
		return jobCount;
	}

	/**
	 * @param id the id to set
	 */
	public void setJobCount(String id) {
		this.jobCount = id;
	}


	/**
	 * @return the type
	 */
	public String getJobClass() {
		return jobClass;
	}

	/**
	 * @param type the type to set
	 */
	public void setJobClass(String type) {
		this.jobClass = type;
	}

}
