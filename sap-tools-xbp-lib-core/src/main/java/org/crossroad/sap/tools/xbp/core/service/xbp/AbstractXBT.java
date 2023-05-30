/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.service.xbp;

import java.io.File;

import org.crossroad.sap.tools.xbp.core.data.JobData;
import org.crossroad.sap.tools.xbp.core.service.AbstractJCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author e.soden
 *
 */
public abstract class AbstractXBT extends AbstractJCO {

	private JobData jobConfig = null;

	
	XMIService xmiService;

	public AbstractXBT() {
		super();
		xmiService = new XMIService();
	}

	protected void setJobData(JobData data) {
		this.jobConfig = data;
	}

	protected JobData getJobConfig() {
		return jobConfig;
	}

	/**
	 * @param destination
	 * @throws XMIException
	 * @see org.crossroad.sap.tools.xbp.core.service.xbp.XMIService#login(com.sap.conn.jco.JCoDestination)
	 */
	public void login() throws XBTException {
		xmiService.login(getDestination());
	}

	/**
	 * @param destination
	 * @throws XMIException
	 * @see org.crossroad.sap.tools.xbp.core.service.xbp.XMIService#logoff(com.sap.conn.jco.JCoDestination)
	 */
	public void logoff() throws XBTException {
		xmiService.logoff(getDestination());
	}

}
