/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.service.xbp;

import java.util.Comparator;
import java.util.List;

import org.crossroad.sap.tools.xbp.data.job.JobContainer;
import org.crossroad.sap.tools.xbp.data.job.JobStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * @author e.soden
 *
 */

@Component
public class XBTCreate extends AbstractXBT {
	private static final Logger log = LoggerFactory.getLogger(XBTCreate.class);
	private JobContainer container = null;

	public String createJob(String destinationName, JobContainer container) throws XBTException {

		try {
		
			this.container = container;
			/*
			 * Create destination
			 */
			this.createDestination(destinationName);

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

			log.info("Job '{}' ({}) created.", this.container.getJob().getName(),
					this.container.getJob().getJobCount());

			/*
			 * Execute
			 */
			return this.container.getJob().getJobCount();

		} catch (XBTException e) {
			throw e;
		} catch (Exception e) {
			throw new XBTException(e);
		} finally {
			logoff();
		}

	}

	/**
	 * Create the job specified in parsed class {@link JobContainer}
	 * 
	 * @throws XBTException
	 */
	private void createJob() throws XBTException {

		try {
			JCoFunction function = getDestination().getRepository().getFunction("BAPI_XBP_JOB_OPEN");

			function.getImportParameterList().setValue("JOBNAME", this.container.getJob().getName());
			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", this.container.getJob().getExtUsername());
			function.getImportParameterList().setValue("JOBCLASS", this.container.getJob().getJobClass());

			JCoParameterList data = execute(function);
			this.container.getJob().setJobCount(data.getField("JOBCOUNT").getString());

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
			function.getImportParameterList().setValue("JOBNAME", this.container.getJob().getName());
			function.getImportParameterList().setValue("JOBCOUNT", this.container.getJob().getJobCount());
			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", this.container.getJob().getExtUsername());

			List<JobStep> steps = this.container.getSteps();

			steps.sort(new Comparator<JobStep>() {
				@Override
				public int compare(JobStep o1, JobStep o2) {
					return o1.getRank() - o2.getRank();
				}
			});

			for (JobStep step : steps) {
				function.getImportParameterList().setValue("ABAP_PROGRAM_NAME", step.getProgram());
				function.getImportParameterList().setValue("ABAP_VARIANT_NAME", step.getVariant());
				function.getImportParameterList().setValue("SAP_USER_NAME", step.getUser());
				function.getImportParameterList().setValue("LANGUAGE", step.getLanguage());

				JCoParameterList data = execute(function);

				log.debug("Step '{}' with variant '{}' added to job '{}'", step.getProgram(), step.getVariant(),
						this.container.getJob().getName());
			}

			log.debug("RFC - FM Job Step added successful ");
		} catch (Exception e) {
			throw new XBTException(e);
		}
	}

}
