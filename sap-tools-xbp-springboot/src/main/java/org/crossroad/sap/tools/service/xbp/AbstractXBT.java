/**
 * 
 */
package org.crossroad.sap.tools.service.xbp;

import java.io.File;

import org.crossroad.sap.tools.data.JobData;
import org.crossroad.sap.tools.service.AbstractJCO;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author e.soden
 *
 */
public abstract class AbstractXBT extends AbstractJCO {
	
	private JobData jobConfig = null;

	@Autowired
	XMIService xmiService;


	protected void parseJobConfig(String jobFile) throws XBTException {
		try {
		ObjectMapper mapper = new ObjectMapper();
		jobConfig = mapper.readValue(new File(jobFile), JobData.class);
		} catch(Exception e)
		{
			throw new XBTException(e);
		}
	}

	protected JobData getJobConfig() {
		return jobConfig;
	}

	/**
	 * @param destination
	 * @throws XMIException
	 * @see org.crossroad.sap.tools.service.xbp.XMIService#login(com.sap.conn.jco.JCoDestination)
	 */
	public void login() throws XBTException {
		xmiService.login(getDestination());
	}

	/**
	 * @param destination
	 * @throws XMIException
	 * @see org.crossroad.sap.tools.service.xbp.XMIService#logoff(com.sap.conn.jco.JCoDestination)
	 */
	public void logoff() throws XBTException {
		xmiService.logoff(getDestination());
	}
	
	
}
