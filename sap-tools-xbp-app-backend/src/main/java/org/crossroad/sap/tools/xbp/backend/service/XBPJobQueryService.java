/**
 * 
 */
package org.crossroad.sap.tools.xbp.backend.service;

import org.crossroad.sap.tools.xbp.core.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBPJobSelect;
import org.crossroad.sap.tools.xbp.core.service.xmi.XMIService;
import org.crossroad.sap.tools.xbp.data.job.query.JobQuery;
import org.crossroad.sap.tools.xbp.data.job.query.JobQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author e.soden
 *
 */
@Component
public class XBPJobQueryService {
	@Autowired
	XBPJobSelect selector;
	
	public JobQueryResult search(String destination, JobQuery data) {
		JCoDestinationWrapper wrapper = null;
		XMIService xmiService = new XMIService();

		try {
			wrapper = new JCoDestinationWrapper(destination);
			wrapper.create();

			xmiService.login(wrapper.getDestination());

			selector.setDestinationWrapper(wrapper);
			return selector.foundJob(data);
			
		} finally {
			if(xmiService.isConnected()) {
				xmiService.logoff(wrapper.getDestination());
			}
		}
	}
	
	public JobQueryResult count(String destination, String job, boolean withJobs) {
		JCoDestinationWrapper wrapper = null;
		XMIService xmiService = new XMIService();

		try {
			wrapper = new JCoDestinationWrapper(destination);
			wrapper.create();

			xmiService.login(wrapper.getDestination());

			selector.setDestinationWrapper(wrapper);
			return selector.count(job, withJobs);
			
		} finally {
			if(xmiService.isConnected()) {
				xmiService.logoff(wrapper.getDestination());
			}
		}
	}
}
