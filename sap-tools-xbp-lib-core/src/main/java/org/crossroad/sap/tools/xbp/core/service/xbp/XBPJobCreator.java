package org.crossroad.sap.tools.xbp.core.service.xbp;

import org.crossroad.sap.tools.xbp.core.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.data.job.Job;
import org.crossroad.sap.tools.xbp.data.job.JobStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sap.conn.jco.JCoFunction;
@Component
public class XBPJobCreator {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	

	/**
	 * 
	 * @param job
	 * @return
	 */
	public String create(JCoDestinationWrapper wrapper, Job job) {

		JCoFunction jobFunction = wrapper.getFunction("BAPI_XBP_JOB_OPEN");
		jobFunction.getImportParameterList().setValue("JOBNAME", job.getName());
		jobFunction.getImportParameterList().setValue("JOBCLASS", job.getJobClass());

		wrapper.execute(jobFunction);
		return jobFunction.getExportParameterList().getField("JOBCOUNT").getString();

	}

	/**
	 * 
	 * @param wrapper
	 * @param job
	 * @param step
	 * @return
	 */
	public Integer addStep(JCoDestinationWrapper wrapper, Job job, JobStep step) {

		JCoFunction stepFunction = wrapper.getFunction("BAPI_XBP_JOB_ADD_ABAP_STEP");
		stepFunction.getImportParameterList().setValue("JOBNAME", job.getName());
		stepFunction.getImportParameterList().setValue("JOBCOUNT", job.getJobCount());

		stepFunction.getImportParameterList().setValue("ABAP_PROGRAM_NAME", step.getProgram());
		stepFunction.getImportParameterList().setValue("ABAP_VARIANT_NAME", step.getVariant());
		stepFunction.getImportParameterList().setValue("SAP_USER_NAME", step.getUser());
		stepFunction.getImportParameterList().setValue("LANGUAGE", step.getLanguage());

		wrapper.execute(stepFunction);

		return stepFunction.getExportParameterList().getField("STEP_NUMBER").getInt();

	}

}
