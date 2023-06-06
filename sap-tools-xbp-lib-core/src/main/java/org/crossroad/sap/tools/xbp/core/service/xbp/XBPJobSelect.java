package org.crossroad.sap.tools.xbp.core.service.xbp;

import java.util.LinkedList;
import java.util.List;

import org.crossroad.sap.tools.xbp.core.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.data.job.query.BAPIXMJOB;
import org.crossroad.sap.tools.xbp.data.job.query.BAPIXMJSEL;
import org.crossroad.sap.tools.xbp.data.job.query.JobQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
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

	/**
	 * 
	 * @param job
	 * @return
	 */
	public List<BAPIXMJOB> foundJob(JobQuery query) {
		try {
			JCoFunction jobFunction = wrapper.getFunction("BAPI_XBP_JOB_SELECT");

			if (query.getJobParam() != null) {
				BAPIXMJSEL jobSel = query.getJobParam();

				JCoStructure btcSelect = jobFunction.getImportParameterList().getStructure(("JOB_SELECT_PARAM"));
				btcSelect.setValue("JOBNAME", (StringUtils.hasText(jobSel.getJobName()) ? jobSel.getJobName() : "*"));
				
				if (StringUtils.hasText(jobSel.getUsername())) {
				btcSelect.setValue("USERNAME",jobSel.getUsername());
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

			jobFunction.getImportParameterList().setValue("SELECTION", (StringUtils.hasText(query.getSelection()) ? query.getSelection() : "AL"));

			log.debug("Parameters: {}",jobFunction.getImportParameterList().toXML());
			
			 wrapper.execute(jobFunction);
			 
			 JCoTable head = jobFunction.getTableParameterList().getTable("JOB_HEAD");
			 String json = head.toJSON();
			 
			 
			 List<BAPIXMJOB> arr = new LinkedList<>();
			 
			 if(StringUtils.hasText(json))
			 {
				 json = json.toLowerCase();
				 arr.addAll(mapper.readValue(json, new TypeReference<List<BAPIXMJOB>>(){}));
			 }
			 

			return arr;
		} catch (Exception e) {
			throw new XBPException(e);
		}

	}

}
