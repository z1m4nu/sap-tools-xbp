/**
 * 
 */
package org.crossroad.sap.tools.service.xbp;

import org.crossroad.sap.tools.data.BTCSTATUS;
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

	public int executeJob(String destinationName, String jobFile, boolean wait) throws XBTException {
		try {
			/*
			 * Create destination
			 */
			this.createDestination(destinationName);

			parseJobConfig(jobFile);

			/*
			 * XBT Login
			 */
			login();

			return executeJob(wait);

		} catch (XBTException e) {
			throw e;
		} catch (Exception e) {
			throw new XBTException(e);
		} finally {
			logoff();

		}

	}

	protected int executeJob(boolean wait) throws XBTException {

		int status = 0;
		try {
			JCoFunction function = getDestination().getRepository().getFunction("BAPI_XBP_JOB_START_IMMEDIATELY");
			function.getImportParameterList().setValue("JOBNAME", getJobConfig().getJobName());
			function.getImportParameterList().setValue("JOBCOUNT", getJobConfig().getJobCount());
			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", getJobConfig().getExternalUser());
			function.getImportParameterList().setValue("TARGET_SERVER",
					getJobConfig().getExecution().getTargetServer());

			execute(function);

			if (wait) {
				String jobStatus = getStatus();
				do {
					log.info("Status return '{}' wait another 5 secs.", jobStatus);
					Thread.currentThread().sleep(5000L);

					jobStatus = getStatus();
				} while ("R".equalsIgnoreCase(jobStatus));

				status = BTCSTATUS.valueOf(jobStatus.charAt(0)).getStatus();
			} else {
				status = 0;
			}
		} catch (Exception e) {
			throw new XBTException(e);
		}
		return status;
	}
}
