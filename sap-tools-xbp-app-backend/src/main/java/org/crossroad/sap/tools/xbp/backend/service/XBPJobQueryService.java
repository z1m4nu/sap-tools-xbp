/**
 * 
 */
package org.crossroad.sap.tools.xbp.backend.service;

import org.crossroad.sap.tools.xbp.core.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBPException;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBPJobSelect;
import org.crossroad.sap.tools.xbp.core.service.xmi.XMIService;
import org.crossroad.sap.tools.xbp.data.job.query.JobQuery;
import org.springframework.stereotype.Component;

/**
 * @author e.soden
 *
 */
@Component
public class XBPJobQueryService {


	public void search(String destination, JobQuery data) throws XBPException{
		JCoDestinationWrapper wrapper = null;
		XMIService xmiService = new XMIService();

		try {
			wrapper = new JCoDestinationWrapper(destination);
			wrapper.create();

			xmiService.login(wrapper.getDestination());

			XBPJobSelect selector = new XBPJobSelect(wrapper);
			selector.foundJob(data);
			
		} finally {
			if(xmiService.isConnected()) {
				xmiService.logoff(wrapper.getDestination());
			}
		}
	}
	
}
