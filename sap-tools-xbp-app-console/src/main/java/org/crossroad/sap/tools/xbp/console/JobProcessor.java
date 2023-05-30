package org.crossroad.sap.tools.xbp.console;

import java.io.File;

import org.crossroad.sap.tools.xbp.core.service.job.JcoQueryJobs;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBTConfigGenrator;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBTCreate;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBTException;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBTExecute;
import org.crossroad.sap.tools.xbp.data.OPERATION;
import org.crossroad.sap.tools.xbp.data.job.Job;
import org.crossroad.sap.tools.xbp.data.job.JobContainer;
import org.crossroad.sap.tools.xbp.data.job.JobOptions;
import org.crossroad.sap.tools.xbp.data.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JobProcessor {
	private static final Logger log  = LoggerFactory.getLogger(JobProcessor.class);
	@Autowired
	XBTCreate xbtCreate;

	@Autowired
	JcoQueryJobs jcoQueryJobs;

	@Autowired
	XBTExecute xbtExecute;

	@Autowired
	XBTConfigGenrator generator;

	@Autowired
	@Qualifier(value = "xbt.mapper")
	ObjectMapper mapper;

	public void process(JobOptions options) throws XBTException {
		switch (options.getOperation()) {

		case CREATE:
		case CREATERUN:
			try {
				JobContainer data = mapper.readValue(new File(options.getJobFile()), JobContainer.class);

				data.getJob().setJobCount(xbtCreate.createJob(options.getDestination(), data));

				if (options.getOperation() == OPERATION.CREATERUN) {
					xbtExecute.executeJob(options.getDestination(), data, TimeUtils.parseTime(options.getWaitTime()));
				}
			} catch (XBTException e) {
				throw e;
			} catch (Exception e) {
				throw new XBTException(e);
			}
			break;
		case GENERATE:
			generator.generate(options.getJobFile());
			break;
		default:
			throw new XBTException(String.format("Operation unknown '%s'", options.getOperation()));
		}

	}
	
	

}
