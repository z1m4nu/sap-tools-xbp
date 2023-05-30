/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.job;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author e.soden
 *
 */
public class JobData implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String user;
	private String type;
	private String id;
	
	private JobExecution execution;
	
	private List<JobStep> steps = new LinkedList<>();
	
	/**
	 * @return the jobName
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param jobName the jobName to set
	 */
	public void setName(String jobName) {
		this.name = jobName;
	}
	/**
	 * @return the externalUser
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param externalUser the externalUser to set
	 */
	public void setUser(String externalUser) {
		this.user = externalUser;
	}
	/**
	 * @return the jobClass
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param jobClass the jobClass to set
	 */
	public void setType(String jobClass) {
		this.type = jobClass;
	}
	/**
	 * @return the steps
	 */
	public List<JobStep> getSteps() {
		return steps;
	}
	/**
	 * @param steps the steps to set
	 */
	public void setSteps(List<JobStep> steps) {
		this.steps = steps;
	}
	/**
	 * @return the jobCount
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param jobCount the jobCount to set
	 */
	public void setId(String jobCount) {
		this.id = jobCount;
	}
	/**
	 * @return the execution
	 */
	public JobExecution getExecution() {
		return execution;
	}
	/**
	 * @param execution the execution to set
	 */
	public void setExecution(JobExecution execution) {
		this.execution = execution;
	}
	
	

}
