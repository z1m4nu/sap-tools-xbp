/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.service.xbp;

import org.crossroad.sap.tools.xbp.core.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.data.job.Job;
import org.crossroad.sap.tools.xbp.data.job.JobData;
import org.crossroad.sap.tools.xbp.data.job.JobExecution;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * @author e.soden
 *
 */
public class XBPOperations {
	/**
	 * 
	 * @param wrapper
	 * @param container
	 * @return
	 * @throws XBPException
	 */
	public static int execute(JCoDestinationWrapper wrapper, Job job, JobExecution exec) throws XBPException {

		int status = 0;
		try {
			JCoFunction function = wrapper.getFunction("BAPI_XBP_JOB_START_IMMEDIATELY");
			function.getImportParameterList().setValue("JOBNAME", job.getName());
			function.getImportParameterList().setValue("JOBCOUNT", job.getJobCount());
			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", job.getExtUsername());
			function.getImportParameterList().setValue("TARGET_SERVER",
					exec.getTargetServer());

			wrapper.execute(function);
		} catch (Exception e) {
			throw new XBPException(e);
		}
		return status;
	}
	/**
	 * 
	 * @param wrapper
	 * @param job
	 * @return
	 * @throws XBPException
	 */
	public static String getJobStatus(JCoDestinationWrapper wrapper, Job job) throws XBPException {
		JCoParameterList data = null;
		try {
			JCoFunction function = wrapper.getFunction("BAPI_XBP_JOB_STATUS_GET");
			function.getImportParameterList().setValue("JOBNAME", job.getName());
			function.getImportParameterList().setValue("JOBCOUNT", job.getJobCount());
			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", job.getExtUsername());

			data = wrapper.execute(function);
		} catch (Exception e) {
			throw new XBPException(e);
		}
		return data.getField("STATUS").getString();
	}
}
