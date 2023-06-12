/**
 * 
 */
package org.crossroad.sap.tools.xbp.backend.service;

import org.crossroad.sap.tools.xbp.core.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBPJobQuery;
import org.crossroad.sap.tools.xbp.core.service.xmi.XMIService;
import org.crossroad.sap.tools.xbp.data.job.Job;
import org.crossroad.sap.tools.xbp.data.job.JobDefinition;
import org.crossroad.sap.tools.xbp.data.job.JobQuery;
import org.crossroad.sap.tools.xbp.data.job.JobQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author e.soden
 *
 */
@Component
public class XBPJobQueryService {
	@Autowired
	XBPJobQuery selector;

	public JobQueryResult search(String destination, JobQuery data) {
		JCoDestinationWrapper wrapper = null;
		XMIService xmiService = new XMIService();

		try {
			wrapper = new JCoDestinationWrapper(destination);
			wrapper.create();

			xmiService.login(wrapper.getDestination());

			return selector.foundJob(wrapper, data);

		} finally {
			if (xmiService.isConnected()) {
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

			return selector.count(wrapper, job, withJobs);

		} finally {
			if (xmiService.isConnected()) {
				xmiService.logoff(wrapper.getDestination());
			}
		}
	}
	
	public JobDefinition getDefinition(String destination, Job job) {
		JCoDestinationWrapper wrapper = null;
		XMIService xmiService = new XMIService();

		try {
			wrapper = new JCoDestinationWrapper(destination);
			wrapper.create();

			xmiService.login(wrapper.getDestination());

			return selector.getJobDefinition(wrapper, job);

		} finally {
			if (xmiService.isConnected()) {
				xmiService.logoff(wrapper.getDestination());
			}
		}
	}
}
