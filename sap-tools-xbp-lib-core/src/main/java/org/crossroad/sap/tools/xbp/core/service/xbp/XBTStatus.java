/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.service.xbp;

import org.crossroad.sap.tools.xbp.data.job.Job;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * @author e.soden
 *
 */
public class XBTStatus extends AbstractXBT {

	protected String getStatus(Job job) throws XBTException {
		JCoParameterList data = null;
		try {
			JCoFunction function = getDestination().getRepository().getFunction("BAPI_XBP_JOB_STATUS_GET");
			function.getImportParameterList().setValue("JOBNAME", job.getName());
			function.getImportParameterList().setValue("JOBCOUNT", job.getJobCount());
			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", job.getExtUsername());

			data = execute(function);
		} catch (Exception e) {
			throw new XBTException(e);
		}
		return data.getField("STATUS").getString();
	}
}
