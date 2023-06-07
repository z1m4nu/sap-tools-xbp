/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.bapi;

import java.util.Date;

/**
 * @author e.soden
 *
 */
public class BAPIXMJSEL extends AbstractBAPI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String jobName = "*";
	private String jobCount = null;
	private String jobGroup = null;
	private String username = null;
	
	private Date fromDate = new Date();
	private Date toDate = new Date();
	
	private String fromTime = "00:00:00";
	private String toTime = "23:59:59";

	
	private String eventId = null;
	private String eventParm = null;
	private boolean nodate = false;
	private boolean withPred = false;
	private boolean ready = true;
	private boolean running = true;
	private boolean finished = true;
	private boolean prelim = true;
	private boolean schedul = false;
	private boolean aborted = true;
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
	 * @return the jobGroup
	 */
	public String getJobGroup() {
		return jobGroup;
	}
	/**
	 * @param jobGroup the jobGroup to set
	 */
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	/**
	 * @return the eventId
	 */
	public String getEventId() {
		return eventId;
	}
	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	/**
	 * @return the eventParm
	 */
	public String getEventParm() {
		return eventParm;
	}
	/**
	 * @param eventParm the eventParm to set
	 */
	public void setEventParm(String eventParm) {
		this.eventParm = eventParm;
	}
	/**
	 * @return the nodate
	 */
	public boolean isNodate() {
		return nodate;
	}
	/**
	 * @param nodate the nodate to set
	 */
	public void setNodate(boolean nodate) {
		this.nodate = nodate;
	}
	/**
	 * @return the withPred
	 */
	public boolean isWithPred() {
		return withPred;
	}
	/**
	 * @param withPred the withPred to set
	 */
	public void setWithPred(boolean withPred) {
		this.withPred = withPred;
	}
	/**
	 * @return the ready
	 */
	public boolean isReady() {
		return ready;
	}
	/**
	 * @param ready the ready to set
	 */
	public void setReady(boolean ready) {
		this.ready = ready;
	}
	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}
	/**
	 * @param running the running to set
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}
	/**
	 * @return the finished
	 */
	public boolean isFinished() {
		return finished;
	}
	/**
	 * @param finished the finished to set
	 */
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	/**
	 * @return the prelim
	 */
	public boolean isPrelim() {
		return prelim;
	}
	/**
	 * @param prelim the prelim to set
	 */
	public void setPrelim(boolean prelim) {
		this.prelim = prelim;
	}
	/**
	 * @return the schedul
	 */
	public boolean isSchedul() {
		return schedul;
	}
	/**
	 * @param schedul the schedul to set
	 */
	public void setSchedul(boolean schedul) {
		this.schedul = schedul;
	}
	/**
	 * @return the aborted
	 */
	public boolean isAborted() {
		return aborted;
	}
	/**
	 * @param aborted the aborted to set
	 */
	public void setAborted(boolean aborted) {
		this.aborted = aborted;
	}
	/**
	 * @return the fromTime
	 */
	public String getFromTime() {
		return fromTime;
	}
	/**
	 * @param fromTime the fromTime to set
	 */
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	/**
	 * @return the toTime
	 */
	public String getToTime() {
		return toTime;
	}
	/**
	 * @param toTime the toTime to set
	 */
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	


}
