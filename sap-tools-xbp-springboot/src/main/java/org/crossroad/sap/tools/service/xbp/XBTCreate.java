/**
 * 
 */
package org.crossroad.sap.tools.service.xbp;

import java.util.Comparator;
import java.util.List;

import org.crossroad.sap.tools.data.JobData;
import org.crossroad.sap.tools.data.JobStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * @author e.soden
 *
 */

@Component
public class XBTCreate extends XBTExecute {
	private static final Logger log = LoggerFactory.getLogger(XBTCreate.class);


	public int createJob(String destinationName, String jobDefinitionFile, boolean wait) throws XBTException {

		try {
			/*
			 * Create destination
			 */
			this.createDestination(destinationName);

			parseJobConfig(jobDefinitionFile);

			/*
			 * XBT Login
			 */
			login();

			/*
			 * Create job
			 */
			createJob();

			/*
			 * Add step
			 */
			addStep();

			/*
			 * Execute
			 */
			return executeJob(wait);

		} catch (XBTException e) {
			throw e;
		} catch (Exception e) {
			throw new XBTException(e);
		} finally {
			logoff();
		}

	}

	/**
	 * Create the job specified in parsed class {@link JobData}
	 * 
	 * @throws XBTException
	 */
	private void createJob() throws XBTException {

		try {
			JCoFunction function = getDestination().getRepository().getFunction("BAPI_XBP_JOB_OPEN");

			function.getImportParameterList().setValue("JOBNAME", getJobConfig().getJobName());
			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", getJobConfig().getExternalUser());
			function.getImportParameterList().setValue("JOBCLASS", getJobConfig().getJobClass());

			JCoParameterList data = execute(function);
			getJobConfig().setJobCount(data.getField("JOBCOUNT").getString());

			log.debug("RFC - FM Job Open successful ");
		} catch (Exception e) {
			throw new XBTException(e);
		}
	}

	/**
	 * Iterate over {@link JobStep} to create the steps
	 * 
	 * @throws XBTException
	 */
	private void addStep() throws XBTException {
		try {
			JCoFunction function = getDestination().getRepository().getFunction("BAPI_XBP_JOB_ADD_ABAP_STEP");
			function.getImportParameterList().setValue("JOBNAME", getJobConfig().getJobName());
			function.getImportParameterList().setValue("JOBCOUNT", getJobConfig().getJobCount());
			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", getJobConfig().getExternalUser());

			List<JobStep> steps = getJobConfig().getSteps();

			steps.sort(new Comparator<JobStep>() {
				@Override
				public int compare(JobStep o1, JobStep o2) {
					return o1.getRank() - o2.getRank();
				}
			});

			for (JobStep step : steps) {
				function.getImportParameterList().setValue("ABAP_PROGRAM_NAME", step.getProgram());
				function.getImportParameterList().setValue("ABAP_VARIANT_NAME", step.getVariant());
				function.getImportParameterList().setValue("SAP_USER_NAME", step.getStepUser());
				function.getImportParameterList().setValue("LANGUAGE", step.getLanguage());

				JCoParameterList data = execute(function);
				
				log.debug("Step '{}' with variant '{}' added to job '{}'", step.getProgram(), step.getVariant(), getJobConfig().getJobName());
			}

			log.debug("RFC - FM Job Step added successful ");
		} catch (Exception e) {
			throw new XBTException(e);
		}
	}

}
