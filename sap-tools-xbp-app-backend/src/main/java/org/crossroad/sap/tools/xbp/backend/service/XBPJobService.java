/**
 * 
 */
package org.crossroad.sap.tools.xbp.backend.service;

import java.util.Comparator;

import org.crossroad.sap.tools.jco.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBPJobCreator;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBPOperations;
import org.crossroad.sap.tools.xbp.core.service.xmi.XMIService;
import org.crossroad.sap.tools.xbp.data.job.Job;
import org.crossroad.sap.tools.xbp.data.job.JobData;
import org.crossroad.sap.tools.xbp.data.job.JobStep;
import org.crossroad.sap.tools.xbp.data.result.JobStatusResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author e.soden
 *
 */
@Component
public class XBPJobService {
	@Autowired
	XBPJobCreator creator;

	@Autowired
	XBPOperations operations;

	@Autowired
	JCoDestinationWrapper wrapper;
	
	/**
	 * 
	 * @param destination
	 * @param job
	 * @return
	 */
	public JobStatusResult getStatus(String destination, Job job) {
		XMIService xmiService = new XMIService();

		try {
			wrapper.connect(destination);

			xmiService.login(wrapper.getDestination());

			return operations.getJobStatus(wrapper, job);

		} finally {
			if (xmiService.isConnected()) {
				xmiService.logoff(wrapper.getDestination());
			}

			wrapper.disconnect();
		}
	}

	/**
	 * 
	 * @param destination
	 * @param container
	 */
	public JobData create(String destination, JobData data) {
		XMIService xmiService = new XMIService();

		try {
			wrapper.connect(destination);

			xmiService.login(wrapper.getDestination());

			String count = creator.create(wrapper, data.getJob());
			data.getJob().setJobCount(count);

			data.getSteps().sort(new Comparator<JobStep>() {
				@Override
				public int compare(JobStep o1, JobStep o2) {
					return o1.getRank() - o2.getRank();
				}
			});

			for (JobStep step : data.getSteps()) {
				step.setStepCount(creator.addStep(wrapper, data.getJob(), step));
			}

			return data;
		} finally {
			if (xmiService.isConnected()) {
				xmiService.logoff(wrapper.getDestination());
			}
			wrapper.disconnect();
		}
	}

}
