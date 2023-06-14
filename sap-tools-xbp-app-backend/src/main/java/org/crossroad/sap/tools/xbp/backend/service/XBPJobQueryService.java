/**
 * 
 */
package org.crossroad.sap.tools.xbp.backend.service;

import org.crossroad.sap.tools.jco.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBPJobQuery;
import org.crossroad.sap.tools.xbp.core.service.xmi.XMIService;
import org.crossroad.sap.tools.xbp.data.job.Job;
import org.crossroad.sap.tools.xbp.data.job.JobDefinition;
import org.crossroad.sap.tools.xbp.data.job.JobQuery;
import org.crossroad.sap.tools.xbp.data.result.JobQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author e.soden
 *
 */
@Component
public class XBPJobQueryService {
	@Autowired
	XBPJobQuery selector;
	
	@Autowired
	JCoDestinationWrapper wrapper;


	public JobQueryResult search(String destination, JobQuery data) {
		XMIService xmiService = new XMIService();

		try {
			wrapper.connect(destination);

			xmiService.login(wrapper.getDestination());

			return selector.foundJob(wrapper, data);

		} finally {
			if (xmiService.isConnected()) {
				xmiService.logoff(wrapper.getDestination());
			}
			
			wrapper.disconnect();
		}
	}

	public JobQueryResult count(String destination, String job, boolean withJobs) {
		XMIService xmiService = new XMIService();

		try {
			wrapper.connect(destination);

			xmiService.login(wrapper.getDestination());

			return selector.count(wrapper, job, withJobs);

		} finally {
			if (xmiService.isConnected()) {
				xmiService.logoff(wrapper.getDestination());
			}
			wrapper.disconnect();
		}
	}
	
	public JobDefinition getDefinition(String destination, Job job) {
		XMIService xmiService = new XMIService();

		try {
			wrapper.connect(destination);
			xmiService.login(wrapper.getDestination());

			return selector.getJobDefinition(wrapper, job);

		} finally {
			if (xmiService.isConnected()) {
				xmiService.logoff(wrapper.getDestination());
			}
			wrapper.disconnect();
		}
	}
}
