package org.crossroad.sap.tools.xbp.core.service.xbp;

import org.crossroad.sap.tools.xbp.core.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.data.job.Job;
import org.crossroad.sap.tools.xbp.data.job.JobStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

public class XBPJobCreator {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	private final JCoDestinationWrapper wrapper;

	public XBPJobCreator(JCoDestinationWrapper wrapper) {
		this.wrapper = wrapper;
	}

	/**
	 * 
	 * @param job
	 * @return
	 */
	public String create(Job job) {
		try {
			JCoFunction jobFunction = wrapper.getFunction("BAPI_XBP_JOB_OPEN");
			jobFunction.getImportParameterList().setValue("JOBNAME", job.getName());
			jobFunction.getImportParameterList().setValue("EXTERNAL_USER_NAME", job.getExtUsername());
			jobFunction.getImportParameterList().setValue("JOBCLASS", job.getJobClass());

			JCoParameterList data = wrapper.execute(jobFunction);
			return data.getField("JOBCOUNT").getString();
		} catch (Exception e) {
			throw new XBPException(e);
		}

	}

	public Integer addStep(Job job, JobStep step) {
		try {
			JCoFunction stepFunction = wrapper.getFunction("BAPI_XBP_JOB_ADD_ABAP_STEP");
			stepFunction.getImportParameterList().setValue("JOBNAME", job.getName());
			stepFunction.getImportParameterList().setValue("JOBCOUNT", job.getJobCount());
			stepFunction.getImportParameterList().setValue("EXTERNAL_USER_NAME", job.getExtUsername());

			stepFunction.getImportParameterList().setValue("ABAP_PROGRAM_NAME", step.getProgram());
			stepFunction.getImportParameterList().setValue("ABAP_VARIANT_NAME", step.getVariant());
			stepFunction.getImportParameterList().setValue("SAP_USER_NAME", step.getUser());
			stepFunction.getImportParameterList().setValue("LANGUAGE", step.getLanguage());

			JCoParameterList data = wrapper.execute(stepFunction);

			return data.getField("STEP_NUMBER").getInt();
		} catch (Exception e) {
			throw new XBPException(e);
		}
	}

}
