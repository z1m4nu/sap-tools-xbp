/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.bapi;

import lombok.Data;

/**
 * @author e.soden
 *
 */
@Data
public class BAPIXMRECIP extends AbstractBAPI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String JOBNAME;
	private String JOBCOUNT;
	private Integer STEPCOUNT;
	private String SDLSTRTDT;
	private String SDLSTRTTM;
	private String BTCSYSTEM;
	private String SDLDATE;
	private String SDLTIME;
	private String SDLUNAME;
	private String LASTCHDATE;
	private String LASTCHTIME;
	private String LASTCHNAME;
	private String RELDATE;
	private String RELTIME;
	private String RELUNAME;
	private String STRTDATE;
	private String STRTTIME;
	private String ENDDATE;
	private String ENDTIME;
	private char PERIODIC;
	private char STATUS;
	private String AUTHCKNAM;
	private String AUTHCKMAN;
	private Integer SUCCNUM;
	private Integer PREDNUM;
	private String LASTSTRTDT;
	private String LASTSTRTTM;
	private Integer WPNUMBER;
	private Integer WPPROCID;
	private String EVENTID;
	private String EVENTPARM;
	private String JOBCLASS;
	private String CALENDARID;
	private String EXECSERVER;
	private String REAXSERVER;


}
