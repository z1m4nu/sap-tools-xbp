/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.service.xbp;

import org.crossroad.sap.tools.xbp.core.service.JCORuntimeException;
import org.crossroad.sap.tools.xbp.core.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.data.job.Job;
import org.crossroad.sap.tools.xbp.data.job.JobExecution;

import com.sap.conn.jco.JCoFunction;

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
	public static int execute(JCoDestinationWrapper wrapper, Job job, JobExecution exec) {

		int status = 0;
		try {
			JCoFunction function = wrapper.getFunction("BAPI_XBP_JOB_START_IMMEDIATELY");
			function.getImportParameterList().setValue("JOBNAME", job.getName());
			function.getImportParameterList().setValue("JOBCOUNT", job.getJobCount());
			function.getImportParameterList().setValue("TARGET_SERVER",
					exec.getTargetServer());

			wrapper.execute(function);
		} catch (JCORuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new JCORuntimeException(e, 0);
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
	public static String getJobStatus(JCoDestinationWrapper wrapper, Job job)  {
		try {
			JCoFunction function = wrapper.getFunction("BAPI_XBP_JOB_STATUS_GET");
			function.getImportParameterList().setValue("JOBNAME", job.getName());
			function.getImportParameterList().setValue("JOBCOUNT", job.getJobCount());

			wrapper.execute(function);
			
			return function.getExportParameterList().getField("STATUS").getString();
		} catch (JCORuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new JCORuntimeException(e, 0);
		}
		
	}
}
