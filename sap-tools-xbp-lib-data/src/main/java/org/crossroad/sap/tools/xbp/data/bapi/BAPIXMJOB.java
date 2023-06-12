/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.bapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author e.soden
 *
 */
@Data
public class BAPIXMJOB extends AbstractBAPI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("JOBNAME")
	private String jobName;
	@JsonProperty("JOBCOUNT")
	private String jobCount;
	@JsonProperty("STEPCOUNT")
	private Integer stepCount;
	@JsonProperty("SDLSTRTDT")
	private String sdlStrTdt;
	@JsonProperty("SDLSTRTTM")
	private String sdlStrTim;
	@JsonProperty("BTCSYSTEM")
	private String btcSystem;
	@JsonProperty("SDLDATE")
	private String sdlDate;
	@JsonProperty("SDLTIME")
	private String sdlTime;
	@JsonProperty("SDLUNAME")
	private String sdlUname;
	@JsonProperty("LASTCHDATE")
	private String LASTCHDATE;
	@JsonProperty("LASTCHTIME")
	private String LASTCHTIME;
	@JsonProperty("LASTCHNAME")
	private String LASTCHNAME;
	@JsonProperty("RELDATE")
	private String RELDATE;
	@JsonProperty("RELTIME")
	private String RELTIME;
	@JsonProperty("RELUNAME")
	private String RELUNAME;
	@JsonProperty("STRTDATE")
	private String STRTDATE;
	@JsonProperty("STRTTIME")
	private String STRTTIME;
	@JsonProperty("ENDDATE")
	private String ENDDATE;
	@JsonProperty("ENDTIME")
	private String ENDTIME;
	@JsonProperty("PERIODIC")
	private char PERIODIC;
	@JsonProperty("STATUS")
	private char STATUS;
	@JsonProperty("AUTHCKNAM")
	private String AUTHCKNAM;
	@JsonProperty("AUTHCKMAN")
	private String AUTHCKMAN;
	@JsonProperty("SUCCNUM")
	private Integer SUCCNUM;
	@JsonProperty("PREDNUM")
	private Integer PREDNUM;
	@JsonProperty("LASTSTRTDT")
	private String LASTSTRTDT;
	@JsonProperty("LASTSTRTTM")
	private String LASTSTRTTM;
	@JsonProperty("WPNUMBER")
	private Integer WPNUMBER;
	@JsonProperty("WPPROCID")
	private Integer WPPROCID;
	@JsonProperty("EVENTID")
	private String EVENTID;
	@JsonProperty("EVENTPARM")
	private String EVENTPARM;
	@JsonProperty("JOBCLASS")
	private String JOBCLASS;
	@JsonProperty("CALENDARID")
	private String CALENDARID;
	@JsonProperty("EXECSERVER")
	private String EXECSERVER;
	@JsonProperty("REAXSERVER")
	private String REAXSERVER;
}
