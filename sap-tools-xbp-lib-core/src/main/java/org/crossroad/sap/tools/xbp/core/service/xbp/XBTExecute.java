/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.service.xbp;

import org.crossroad.sap.tools.xbp.data.BTCSTATUS;
import org.crossroad.sap.tools.xbp.data.job.JobContainer;
import org.crossroad.sap.tools.xbp.data.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sap.conn.jco.JCoFunction;

/**
 * @author e.soden
 *
 */
@Component
public class XBTExecute extends XBTStatus {
	private static final Logger log = LoggerFactory.getLogger(XBTExecute.class);
private JobContainer container = null;
	
	public int executeJob(String destinationName, JobContainer data, long waitTime) throws XBTException {
		try {
			this.container = data;
			/*
			 * Create destination
			 */
			this.createDestination(destinationName);


			/*
			 * XBT Login
			 */
			login();

			return executeJob(waitTime);

		} catch (XBTException e) {
			throw e;
		} catch (Exception e) {
			throw new XBTException(e);
		} finally {
			logoff();

		}

	}

	protected int executeJob(long waitTime) throws XBTException {

		int status = 0;
		try {
			JCoFunction function = getDestination().getRepository().getFunction("BAPI_XBP_JOB_START_IMMEDIATELY");
			function.getImportParameterList().setValue("JOBNAME", this.container.getJob().getName());
			function.getImportParameterList().setValue("JOBCOUNT", this.container.getJob().getJobCount());
			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", this.container.getJob().getExtUsername());
			function.getImportParameterList().setValue("TARGET_SERVER",
					this.container.getExecution().getTargetServer());

			execute(function);

			if (waitTime >0) {
				String hms = TimeUtils.milliTohms(waitTime);
				
				String jobStatus = getStatus(this.container.getJob());
				do {
					log.info("Status return '{}' wait another {}.", jobStatus, hms);
					Thread.currentThread().sleep(waitTime);

					jobStatus = getStatus(this.container.getJob());
				} while ("R".equalsIgnoreCase(jobStatus));

				status = BTCSTATUS.valueOf(jobStatus.charAt(0)).getStatus();
				log.info("Finale status '{}'.", jobStatus);
			} else {
				status = 0;
			}
		} catch (Exception e) {
			throw new XBTException(e);
		}
		return status;
	}
}
