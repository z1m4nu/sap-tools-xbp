package org.crossroad.sap.tools.xbp.console;

import java.io.File;
import java.util.Comparator;
import java.util.List;

import org.crossroad.sap.tools.xbp.core.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBPConfigGenrator;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBPException;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBPJobCreator;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBPOperations;
import org.crossroad.sap.tools.xbp.core.service.xmi.XMIService;
import org.crossroad.sap.tools.xbp.data.BTCSTATUS;
import org.crossroad.sap.tools.xbp.data.job.JobData;
import org.crossroad.sap.tools.xbp.data.job.JobOptions;
import org.crossroad.sap.tools.xbp.data.job.JobStep;
import org.crossroad.sap.tools.xbp.data.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JobProcessor {
	private static final Logger log = LoggerFactory.getLogger(JobProcessor.class);

	@Autowired
	XBPConfigGenrator generator;

	@Autowired
	@Qualifier(value = "xbt.mapper")
	ObjectMapper mapper;

	public int process(JobOptions options) throws XBPException {
		XMIService xmiService = new XMIService();
		JCoDestinationWrapper wrapper = null;
		JobData data = null;
		int status = 1;
		try {
			wrapper = new JCoDestinationWrapper(options.getDestination());
			wrapper.create();

			xmiService.login(wrapper.getDestination());

			data = mapper.readValue(new File(options.getJobFile()), JobData.class);

			switch (options.getOperation()) {

			case CREATE:
			case CREATERUN:
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

				XBPOperations.execute(wrapper, data.getJob(), data.getExecution());

				Long waitTime = TimeUtils.parseTime(options.getWaitTime());

				if (waitTime > 0) {
					String hms = TimeUtils.milliTohms(waitTime);

					String jobStatus = XBPOperations.getJobStatus(wrapper, data.getJob());
					do {
						log.info("Status return '{}' wait another {}.", jobStatus, hms);
						Thread.currentThread().sleep(waitTime);

						jobStatus = XBPOperations.getJobStatus(wrapper, data.getJob());
					} while ("R".equalsIgnoreCase(jobStatus));

					status = BTCSTATUS.valueOf(jobStatus.charAt(0)).getStatus();
					log.info("Finale status '{}'.", jobStatus);
				} else {
					status = 0;
				}

				break;
			case GENERATE:
				generator.generate(options.getJobFile());
				break;
			default:
				throw new XBPException(String.format("Operation unknown '%s'", options.getOperation()));
			}

		} catch (XBPException e) {
			throw e;
		} catch (Exception e) {
			throw new XBPException(e);
		} finally {
			if (xmiService.isConnected()) {
				xmiService.logoff(wrapper.getDestination());
			}
		}

		return status;

	}

}
