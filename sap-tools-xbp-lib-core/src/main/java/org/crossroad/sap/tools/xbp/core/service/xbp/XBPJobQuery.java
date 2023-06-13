package org.crossroad.sap.tools.xbp.core.service.xbp;

import java.util.List;

import org.crossroad.sap.tools.xbp.core.service.JCORuntimeException;
import org.crossroad.sap.tools.xbp.core.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMJOB;
import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMJOBLOG;
import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMJSEL;
import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMRECIP;
import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMSPOOLID;
import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMSTEP;
import org.crossroad.sap.tools.xbp.data.job.Job;
import org.crossroad.sap.tools.xbp.data.job.JobDefinition;
import org.crossroad.sap.tools.xbp.data.job.JobQuery;
import org.crossroad.sap.tools.xbp.data.job.JobQueryResult;
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
public class XBPJobQuery {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	@Qualifier(value = "xbp.objectmapper")
	ObjectMapper mapper;

	public JobQueryResult count(JCoDestinationWrapper wrapper, String jobName, boolean withJob) {

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
					//json = json.toLowerCase();
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
	public JobQueryResult foundJob(JCoDestinationWrapper wrapper, JobQuery query) {
		try {
			JCoFunction jobFunction = wrapper.getFunction("BAPI_XBP_JOB_SELECT");

			if (query.getParameters() != null) {
				BAPIXMJSEL jobSel = query.getParameters();

				JCoStructure btcSelect = jobFunction.getImportParameterList().getStructure(("JOB_SELECT_PARAM"));
				btcSelect.fromJSON(mapper.writeValueAsString(jobSel));
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
				//json = json.toLowerCase();
				log.debug("[JSON]\n{}\n", json);
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

	/**
	 * 
	 * @param wrapper
	 * @param job
	 * @return
	 */
	public JobDefinition getJobDefinition(JCoDestinationWrapper wrapper, Job job) {
		try {
			JCoFunction function = wrapper.getFunction("BAPI_XBP_JOB_DEFINITION_GET");
			function.getImportParameterList().setValue("JOBNAME", job.getName());
			function.getImportParameterList().setValue("JOBCOUNT", job.getJobCount());

			wrapper.execute(function);

			JCoParameterList p = function.getExportParameterList();

			JobDefinition definition = new JobDefinition();

			String data = p.getStructure("JOB_HEAD").toJSON();
			if (StringUtils.hasText(data)) {
				definition.setJob(mapper.readValue(data, BAPIXMJOB.class));
			}

			data = p.getStructure("JOBLG_ATTR").toJSON();
			if (StringUtils.hasText(data)) {
				definition.setJobLogAttr(mapper.readValue(data, BAPIXMJOBLOG.class));
			}

			data = p.getStructure("RECIPIENT").toJSON();
			if (StringUtils.hasText(data)) {
				definition.setRecipient(mapper.readValue(data, BAPIXMRECIP.class));
			}

			data = function.getTableParameterList().getTable("STEP_TBL").toJSON();
			if (StringUtils.hasText(data)) {
				definition.getSteps().addAll(mapper.readValue(data, new TypeReference<List<BAPIXMSTEP>>() {
				}));
			}
			data = function.getTableParameterList().getTable("SPOOL_ATTR").toJSON();
			if (StringUtils.hasText(data)) {
				definition.getSpools().addAll(mapper.readValue(data, new TypeReference<List<BAPIXMSPOOLID>>() {
				}));
			}
			return definition;
		} catch (JCORuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new JCORuntimeException(e, 0);
		}
	}

}
