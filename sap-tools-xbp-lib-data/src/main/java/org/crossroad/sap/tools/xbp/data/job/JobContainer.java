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
public class JobContainer implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	private Job job;
	
	private JobExecution execution;
	
	private List<JobStep> steps = new LinkedList<>();
	
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
	/**
	 * @return the job
	 */
	public Job getJob() {
		return job;
	}
	/**
	 * @param job the job to set
	 */
	public void setJob(Job job) {
		this.job = job;
	}
	
	

}
