/**
 * 
 */
package org.crossroad.sap.tools.service.xbp;

import org.springframework.stereotype.Component;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * @author e.soden
 *
 */
@Component
public class XBTStatus extends AbstractXBT {

	protected String getStatus() throws XBTException {
		JCoParameterList data = null;
		try {
			JCoFunction function = getDestination().getRepository().getFunction("BAPI_XBP_JOB_STATUS_GET");
			function.getImportParameterList().setValue("JOBNAME", getJobConfig().getJobName());
			function.getImportParameterList().setValue("JOBCOUNT", getJobConfig().getJobCount());
			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", getJobConfig().getExternalUser());

			data = execute(function);
		} catch (Exception e) {
			throw new XBTException(e);
		}
		return data.getField("STATUS").getString();
	}
}
