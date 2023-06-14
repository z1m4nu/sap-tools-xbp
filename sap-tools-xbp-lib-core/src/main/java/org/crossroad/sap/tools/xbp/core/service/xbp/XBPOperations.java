/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.service.xbp;

import org.crossroad.sap.tools.jco.service.JCORuntimeException;
import org.crossroad.sap.tools.jco.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.data.job.Job;
import org.crossroad.sap.tools.xbp.data.job.JobExecution;
import org.crossroad.sap.tools.xbp.data.result.JobStatusResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * @author e.soden
 *
 */
@Component
public class XBPOperations {
	private static final Logger log = LoggerFactory.getLogger(XBPOperations.class);
	@Autowired
	@Qualifier(value = "xbp.objectmapper")
	ObjectMapper mapper;

	/**
	 * 
	 * @param wrapper
	 * @param container
	 * @return
	 * @throws XBPException
	 */
	public int executeImmediatly(JCoDestinationWrapper wrapper, Job job, JobExecution exec) {

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
			throw new JCORuntimeException(e);
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
	public JobStatusResult getJobStatus(JCoDestinationWrapper wrapper, Job job)  {
		try {
			JCoFunction function = wrapper.getFunction("BAPI_XBP_JOB_STATUS_GET");
			function.getImportParameterList().setValue("JOBNAME", job.getName());
			function.getImportParameterList().setValue("JOBCOUNT", job.getJobCount());

			
			wrapper.execute(function);
			JCoParameterList p = function.getExportParameterList();
			JobStatusResult res = mapper.readValue(p.toJSON(), JobStatusResult.class);
			return res;
		
		} catch (Exception e) {
			throw new JCORuntimeException(e);
		}
	}

}
