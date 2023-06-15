/**
 * 
 */
package org.crossroad.sap.tools.archmig.job;

import java.time.LocalDateTime;

import org.crossroad.sap.tools.archmig.data.Status;
import org.crossroad.sap.tools.archmig.jpa.entities.BackendAdmiFiles;
import org.crossroad.sap.tools.archmig.jpa.entities.MigrationLog;
import org.crossroad.sap.tools.archmig.jpa.repositories.MigrationLogRepository;
import org.crossroad.sap.tools.jco.service.JCoDestinationWrapper;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author e.soden
 *
 */
@Slf4j
public class MigrationProcessor implements ItemProcessor<BackendAdmiFiles, BackendAdmiFiles> {

	@Autowired
	@Qualifier(value = "archmig.sap.jco")
	JCoDestinationWrapper wrapper;

	@Autowired
	MigrationLogRepository logRepository;
	
	@Override
	public BackendAdmiFiles process(BackendAdmiFiles item) throws Exception {
		
		MigrationLog migLog = new MigrationLog();
		migLog.setArchivKey(item.getArchivKey());
		migLog.setDocument(item.getDocument());
		try  {
		if (wrapper != null)
		{
			item.setClient(wrapper.getDestination().getClient());
			item.setSid(this.wrapper.getSysInfo().getRfcSysID());

			migLog.setSeverity(Status.SUCCESS.getName());
		} else {
			item.setStatus(Status.ERROR.getCode());
			migLog.setSeverity(Status.ERROR.getName());
			migLog.setMsg("JCo destination not initialized");
		}
		} finally {
			migLog.setSid(item.getSid());
			migLog.setClient(item.getClient());
			migLog.setPosted(LocalDateTime.now());
			logRepository.save(migLog);
		}
		return item;
	}
	
	

}
