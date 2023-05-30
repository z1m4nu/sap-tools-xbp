/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.service.xbp;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * @author e.soden
 *
 */
public class XBTStatus extends AbstractXBT {

	protected String getStatus() throws XBTException {
		JCoParameterList data = null;
		try {
			JCoFunction function = getDestination().getRepository().getFunction("BAPI_XBP_JOB_STATUS_GET");
			function.getImportParameterList().setValue("JOBNAME", getJobConfig().getName());
			function.getImportParameterList().setValue("JOBCOUNT", getJobConfig().getId());
			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", getJobConfig().getUser());

			data = execute(function);
		} catch (Exception e) {
			throw new XBTException(e);
		}
		return data.getField("STATUS").getString();
	}
}
