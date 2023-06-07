package org.crossroad.sap.tools.xbp.core.service.xbp;

import java.util.List;

import org.crossroad.sap.tools.xbp.core.service.JCORuntimeException;
import org.crossroad.sap.tools.xbp.core.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMJOB;
import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMJSEL;
import org.crossroad.sap.tools.xbp.data.job.query.JobQuery;
import org.crossroad.sap.tools.xbp.data.job.query.JobQueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

@Component
public class XBPJobSelect {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	private JCoDestinationWrapper wrapper;

	@Autowired
	@Qualifier(value = "xbp.objectmapper")
	ObjectMapper mapper;

	public void setDestinationWrapper(JCoDestinationWrapper wrapper) {
		this.wrapper = wrapper;
	}

	public JobQueryResult count(String jobName, boolean withJob) {

		try {
			JobQueryResult res = new JobQueryResult();
			JCoFunction jobFunction = wrapper.getFunction("BAPI_XBP_JOB_COUNT");

			jobFunction.getImportParameterList().setValue("JOBNAME", (StringUtils.hasText(jobName) ? jobName : "*"));
			jobFunction.getImportParameterList().setValue("DONT_LIST_JOBS", (withJob ? 'X' : ' '));

			wrapper.execute(jobFunction);
			res.setCount(jobFunction.getExportParameterList().getInt("NUMBER_OF_JOBS"));
			if (withJob) {
				JCoTable head = jobFunction.getTableParameterList().getTable("JOB_TABLE");
				String json = head.toJSON();

				if (StringUtils.hasText(json)) {
					json = json.toLowerCase();
					res.getContent().addAll(mapper.readValue(json, new TypeReference<List<BAPIXMJOB>>() {
					}));
				}
			}
			return res;
		} catch (JCORuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new JCORuntimeException(e, 0);
		}

	}

	/**
	 * 
	 * @param job
	 * @return
	 */
	public JobQueryResult foundJob(JobQuery query) {
		try {
			JCoFunction jobFunction = wrapper.getFunction("BAPI_XBP_JOB_SELECT");

			if (query.getJobParam() != null) {
				BAPIXMJSEL jobSel = query.getJobParam();

				JCoStructure btcSelect = jobFunction.getImportParameterList().getStructure(("JOB_SELECT_PARAM"));
				btcSelect.setValue("JOBNAME", (StringUtils.hasText(jobSel.getJobName()) ? jobSel.getJobName() : "*"));

				if (StringUtils.hasText(jobSel.getUsername())) {
					btcSelect.setValue("USERNAME", jobSel.getUsername());
				}

				if (jobSel.getFromDate() != null) {
					btcSelect.setValue("FROM_DATE", jobSel.getFromDate());
				}

				if (jobSel.getToDate() != null) {
					btcSelect.setValue("TO_DATE", jobSel.getToDate());
				}
				if (StringUtils.hasText(jobSel.getFromTime())) {
					btcSelect.setValue("FROM_TIME", jobSel.getFromTime());
				}

				if (StringUtils.hasText(jobSel.getToTime())) {
					btcSelect.setValue("TO_TIME", jobSel.getToTime());
				}

				if (StringUtils.hasText(jobSel.getJobCount())) {
					btcSelect.setValue("JOBCOUNT", jobSel.getJobCount());
				}

				if (StringUtils.hasText(jobSel.getJobGroup())) {
					btcSelect.setValue("JOBGROUP", jobSel.getJobGroup());
				}

				if (StringUtils.hasText(jobSel.getEventId())) {
					btcSelect.setValue("EVENTID", jobSel.getEventId());
				}

				if (StringUtils.hasText(jobSel.getEventParm())) {
					btcSelect.setValue("EVENTPARM", jobSel.getEventParm());
				}

				if (jobSel.isPrelim()) {
					btcSelect.setValue("PRELIM", 'X');
				}
				if (jobSel.isSchedul()) {
					btcSelect.setValue("SCHEDUL", 'X');
				}
				if (jobSel.isRunning()) {
					btcSelect.setValue("RUNNING", 'X');
				}
				if (jobSel.isReady()) {
					btcSelect.setValue("READY", 'X');
				}
				if (jobSel.isFinished()) {
					btcSelect.setValue("FINISHED", 'X');
				}
				if (jobSel.isAborted()) {
					btcSelect.setValue("ABORTED", 'X');
				}
			}

			if (query.isSusp()) {
				jobFunction.getImportParameterList().setValue("SUSP", 'X');
			}
			if (StringUtils.hasText(query.getSystemId())) {
				jobFunction.getImportParameterList().setValue("SYSTEMID", query.getSystemId());
			}

			if (StringUtils.hasText(query.getAbapName())) {
				jobFunction.getImportParameterList().setValue("ABAPNAME", query.getAbapName());
			}

			jobFunction.getImportParameterList().setValue("SELECTION",
					(StringUtils.hasText(query.getSelection()) ? query.getSelection() : "AL"));

			log.debug("Parameters: {}", jobFunction.getImportParameterList().toXML());

			wrapper.execute(jobFunction);

			JCoTable head = jobFunction.getTableParameterList().getTable("JOB_HEAD");

			JobQueryResult res = new JobQueryResult();

			String json = head.toJSON();

			if (StringUtils.hasText(json)) {
				json = json.toLowerCase();
				res.getContent().addAll(mapper.readValue(json, new TypeReference<List<BAPIXMJOB>>() {
				}));
			}

			res.setCount(res.getContent().size());

			return res;
		} catch (JCORuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new JCORuntimeException(e, 0);
		}

	}

}
