/**
 * 
 */
package org.crossroad.sap.tools.archmig.service;

import org.crossroad.sap.tools.archmig.data.ArchiveMigData;
import org.crossroad.sap.tools.archmig.data.ArchiveMigResult;
import org.crossroad.sap.tools.archmig.data.Status;
import org.crossroad.sap.tools.archmig.jpa.repositories.BackendAdmiFilesRepository;
import org.crossroad.sap.tools.archmig.sap.jpa.repositories.SAPAdmiFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author e.soden
 *
 */
@Component
@Slf4j
public class ArchiveMigService {
	@Autowired
	SAPAdmiFileRepository sapRepository;
	@Autowired
	BackendAdmiFilesRepository backendRepository;

	/**
	 * 
	 */
	public ArchiveMigResult migrate(ArchiveMigData cfg) {
		ArchiveMigResult res = new ArchiveMigResult();

		try {
			res.setRunId(System.currentTimeMillis());
			
			res.setTotal(sapRepository.countByCrep(cfg.getSrcArcId()));
			
			res.setStatus(Status.SUCCESS);
		} catch (Exception e) {
			res.setStatus(Status.ERROR);
		}

		return res;
	}
}
