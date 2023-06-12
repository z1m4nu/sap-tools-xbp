/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.bapi;

import java.util.Date;

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
}
