/**
 * 
 */
package org.crossroad.sap.tools.xbp.backend.service;

import java.util.Comparator;

import org.crossroad.sap.tools.xbp.core.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBPJobCreator;
import org.crossroad.sap.tools.xbp.core.service.xmi.XMIService;
import org.crossroad.sap.tools.xbp.data.job.JobData;
import org.crossroad.sap.tools.xbp.data.job.JobStep;
import org.springframework.stereotype.Component;

/**
 * @author e.soden
 *
 */
@Component
public class XBPJobService {

	/**
	 * 
	 * @param destination
	 * @param container
	 */
	public JobData create(String destination, JobData data) {
		JCoDestinationWrapper wrapper = null;
		XMIService xmiService = new XMIService();

		try {
			wrapper = new JCoDestinationWrapper(destination);
			wrapper.create();

			xmiService.login(wrapper.getDestination());

			XBPJobCreator creator = new XBPJobCreator(wrapper);
			String count = creator.create(data.getJob());
			data.getJob().setJobCount(count);

			data.getSteps().sort(new Comparator<JobStep>() {
				@Override
				public int compare(JobStep o1, JobStep o2) {
					return o1.getRank() - o2.getRank();
				}
			});

			for (JobStep step : data.getSteps()) {
				step.setStepCount(creator.addStep(data.getJob(), step));
			}

			
			return data;
		} finally {
			if(xmiService.isConnected()) {
				xmiService.logoff(wrapper.getDestination());
			}
		}
	}

}
