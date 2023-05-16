/**
 * 
 */
package org.crossroad.sap.tools.service.job;

import org.crossroad.sap.tools.service.AbstractJCO;
import org.crossroad.sap.tools.service.xbp.XBTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRecordMetaData;

/**
 * @author e.soden
 *
 */
@Component
public class JcoQueryJobs extends AbstractJCO {
	private static final Logger log = LoggerFactory.getLogger(JcoQueryJobs.class);

	public int getRunningJob(String destinationName) throws JobException {
		try {
			super.createDestination(destinationName);
			try {
				JCoFunction function = getDestination().getRepository().getFunction("BP_JOB_SELECT");

				JCoRecordMetaData meta = getDestination().getRepository().getStructureDefinition("JOBSEL_PARAM_IN");
				log.debug("RFC - FM Job Open successful ");
			} catch (Exception e) {
				throw new XBTException(e);
			}

		} catch (Exception e) {
			throw new JobException(e);
		}
		
		return 0;
	}

}
