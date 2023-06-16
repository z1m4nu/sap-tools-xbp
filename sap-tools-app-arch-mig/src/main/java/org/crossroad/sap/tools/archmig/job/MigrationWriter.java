/**
 * 
 */
package org.crossroad.sap.tools.archmig.job;

import java.time.LocalDateTime;
import java.util.List;

import org.crossroad.sap.tools.archmig.jpa.entities.BackendAdmiFiles;
import org.crossroad.sap.tools.archmig.jpa.entities.MigrationLog;
import org.crossroad.sap.tools.archmig.jpa.repositories.BackendAdmiFilesRepository;
import org.crossroad.sap.tools.archmig.jpa.repositories.MigrationLogRepository;
import org.crossroad.sap.tools.xbp.data.utils.ExceptionUtils;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

/**
 * @author e.soden
 *
 */
@Slf4j
public class MigrationWriter implements ItemWriter<BackendAdmiFiles> {

	@Autowired
	BackendAdmiFilesRepository repository;

	@Autowired
	MigrationLogRepository logRepository;

	@Override
	public void write(List<? extends BackendAdmiFiles> items) throws Exception {
		for (BackendAdmiFiles item : items) {
			

			log.debug("CREP {} OldArchDocId {} Status {}", item.getOldCrep(), item.getOldArchDocId(),
					item.getStatusOp());

			try {
				repository.save(item);
			} catch (Exception e) {
				log.error(String.format("Error while saving information for '%s' - '%s'", item.getArchivKey(), item.getDocument()),e);
				
				MigrationLog migLog = new MigrationLog();
				migLog.setArchivKey(item.getArchivKey());
				migLog.setDocument(item.getDocument());
				migLog.setSid(item.getSid());
				migLog.setClient(item.getClient());
				migLog.setSeverity(item.getStatusOp());
				migLog.setPosted(LocalDateTime.now());
				migLog.setMsg(ExceptionUtils.sumarizeException(e));
				logRepository.save(migLog);
			}
		}
	}

}
