/**
 * 
 */
package org.crossroad.sap.tools.archmig.job;

import java.time.LocalDateTime;

import org.crossroad.sap.tools.archmig.data.MigrationConfig;
import org.crossroad.sap.tools.archmig.data.Status;
import org.crossroad.sap.tools.archmig.jpa.entities.BackendAdmiFiles;
import org.crossroad.sap.tools.archmig.jpa.entities.MigrationLog;
import org.crossroad.sap.tools.archmig.jpa.repositories.MigrationLogRepository;
import org.crossroad.sap.tools.jco.service.JCORuntimeException;
import org.crossroad.sap.tools.jco.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.data.utils.ExceptionUtils;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

import lombok.extern.slf4j.Slf4j;

/**
 * @author e.soden
 *
 */
@Slf4j
public class MigrationProcessor implements ItemProcessor<BackendAdmiFiles, BackendAdmiFiles>, StepExecutionListener {

	@Autowired
	@Qualifier(value = "archmig.sap.jco")
	JCoDestinationWrapper wrapper;

	@Autowired
	MigrationLogRepository logRepository;

	private long runId = 0L;

	private String dstCREP = null;
	
	

	@Override
	public BackendAdmiFiles process(BackendAdmiFiles item) throws Exception {

		MigrationLog migLog = new MigrationLog();
		migLog.setArchivKey(item.getArchivKey());
		migLog.setDocument(item.getDocument());

		item.setRunId(runId);

		try {
			if (wrapper != null) {

				item.setClient(wrapper.getDestination().getClient());
				item.setSid(this.wrapper.getSysInfo().getRfcSysID());
				migLog.setSid(item.getSid());
				migLog.setClient(item.getClient());
				
				if (StringUtils.hasText(dstCREP)) {
					item.setNewCrep(dstCREP);

					copyArchiveToNew(item, migLog);
					
				} else {
					item.setStatusOp(Status.ERROR.name());
					migLog.setMsg("Destination content repository not set");
				}
			} else {
				item.setStatusOp(Status.ERROR.name());
				migLog.setMsg("JCo destination not initialized");
			}
		} finally {
			migLog.setSeverity(item.getStatusOp());
			migLog.setPosted(LocalDateTime.now());
			logRepository.save(migLog);
		}
		return item;
	}

	private void copyArchiveToNew(BackendAdmiFiles item, MigrationLog migLog) throws JCORuntimeException {
		log.debug("Start copying '{}' from '{}' to '{}'", item.getOldArchDocId(), item.getOldCrep(), item.getNewCrep());

		try {
			JCoFunction statusFunction = wrapper.getFunction("ZARCHIVE_STATUS");
			statusFunction.getImportParameterList().setValue("ARC_ID", item.getOldCrep());
			statusFunction.getImportParameterList().setValue("DOC_ID", item.getOldArchDocId());
			
			wrapper.executeJco(statusFunction);
			
			JCoParameterList export = statusFunction.getExportParameterList();
			log.debug("Status return: \n{}", export.toJSON());
			
			int status = export.getInt("STATUS");
			
			if (status == 0)
			{
				JCoFunction cpyFunction = wrapper.getFunction("ZARCHIVE_COPY");
				cpyFunction.getImportParameterList().setValue("SRC_ARC_ID", item.getOldCrep());
				cpyFunction.getImportParameterList().setValue("DST_ARC_ID", item.getNewCrep());
				cpyFunction.getImportParameterList().setValue("SRC_DOC_ID", item.getOldArchDocId());
				
				wrapper.executeJco(cpyFunction);

				export = cpyFunction.getExportParameterList();
				log.debug("Copy return: \n{}", export.toJSON());
				
				item.setNewArchDocId(export.getString("DST_DOC_ID"));
				
				item.setStatusOp(Status.SUCCESS.name());
				
			} else {
				item.setStatusOp(Status.NOTFOUND.name());
				migLog.setMsg(export.getString("MSG"));
			}
			
		} catch(Exception e)
		{
			item.setStatusOp(Status.ERROR.name());
			migLog.setMsg(ExceptionUtils.sumarizeException(e));
			throw new JCORuntimeException(String.format("Export parameter DST_DOC_ID not set for '%s' while copying from '%s' to '%s'", item.getOldArchDocId(), item.getOldCrep(), item.getNewCrep()),e);
		}

	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		if (stepExecution != null) {
			this.runId = stepExecution.getJobParameters().getLong(MigrationConfig.KEY_RUNID);
			this.dstCREP = stepExecution.getJobParameters().getString(MigrationConfig.KEY_DST_CREP);
		}

	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		return null;
	}

}
