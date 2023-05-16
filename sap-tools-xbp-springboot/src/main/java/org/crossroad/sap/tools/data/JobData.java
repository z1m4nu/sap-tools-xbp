/**
 * 
 */
package org.crossroad.sap.tools.data;

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
	private String jobName;
	private String externalUser;
	private String jobClass;
	private String jobCount;
	
	private JobExecution execution;
	
	private List<JobStep> steps = new LinkedList<>();
	
	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}
	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	/**
	 * @return the externalUser
	 */
	public String getExternalUser() {
		return externalUser;
	}
	/**
	 * @param externalUser the externalUser to set
	 */
	public void setExternalUser(String externalUser) {
		this.externalUser = externalUser;
	}
	/**
	 * @return the jobClass
	 */
	public String getJobClass() {
		return jobClass;
	}
	/**
	 * @param jobClass the jobClass to set
	 */
	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
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
	public String getJobCount() {
		return jobCount;
	}
	/**
	 * @param jobCount the jobCount to set
	 */
	public void setJobCount(String jobCount) {
		this.jobCount = jobCount;
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
