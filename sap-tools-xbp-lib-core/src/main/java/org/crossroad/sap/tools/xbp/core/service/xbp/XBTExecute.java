/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.service.xbp;

import org.crossroad.sap.tools.xbp.data.BTCSTATUS;
import org.crossroad.sap.tools.xbp.data.TimeUtils;
import org.crossroad.sap.tools.xbp.data.job.JobData;
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

	
	public int executeJob(String destinationName, JobData data, long waitTime) throws XBTException {
		try {
			/*
			 * Create destination
			 */
			this.createDestination(destinationName);

			setJobData(data);

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
			function.getImportParameterList().setValue("JOBNAME", getJobConfig().getName());
			function.getImportParameterList().setValue("JOBCOUNT", getJobConfig().getId());
			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", getJobConfig().getUser());
			function.getImportParameterList().setValue("TARGET_SERVER",
					getJobConfig().getExecution().getTargetServer());

			execute(function);

			if (waitTime >0) {
				String hms = TimeUtils.milliTohms(waitTime);
				
				String jobStatus = getStatus();
				do {
					log.info("Status return '{}' wait another {}.", jobStatus, hms);
					Thread.currentThread().sleep(waitTime);

					jobStatus = getStatus();
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
