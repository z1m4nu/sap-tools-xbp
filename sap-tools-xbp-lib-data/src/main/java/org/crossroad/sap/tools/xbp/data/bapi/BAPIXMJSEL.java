/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.bapi;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author e.soden
 *
 */
@Data
public class BAPIXMJSEL extends AbstractBAPI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("JOBNAME")
	private String jobName = "*";
	@JsonProperty("JOBCOUNT")
	private String jobCount = null;
	@JsonProperty("JOBGROUP")
	private String jobGroup = null;
	@JsonProperty("USERNAME")
	private String username = null;

	@JsonProperty("FROM_DATE")
	private Date fromDate = new Date();
	@JsonProperty("TO_DATE")
	private Date toDate = new Date();

	@JsonProperty("FROM_TIME")
	private String fromTime = "00:00:00";
	@JsonProperty("TO_TIME")
	private String toTime = "23:59:59";

	@JsonProperty("EVENTID")
	private String eventId = null;
	@JsonProperty("EVENTPARM")
	private String eventParm = null;
	@JsonProperty("NO_DATE")
	private char nodate = ' ';
	@JsonProperty("WITH_PRED")
	private char withPred = 'X';
	@JsonProperty("READY")
	private char ready = 'X';
	@JsonProperty("RUNNING")
	private char running = 'X';
	@JsonProperty("FINISHED")
	private char finished = 'X';
	@JsonProperty("PRELIM")
	private char prelim = 'X';
	@JsonProperty("SCHEDUL")
	private char schedul = ' ';
	@JsonProperty("ABORTED")
	private char aborted = 'X';
}
