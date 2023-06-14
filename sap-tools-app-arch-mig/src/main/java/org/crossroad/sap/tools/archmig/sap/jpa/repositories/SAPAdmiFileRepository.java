/**
 * 
 */
package org.crossroad.sap.tools.archmig.sap.jpa.repositories;

import org.crossroad.sap.tools.archmig.sap.jpa.entities.AdmiFileKey;
import org.crossroad.sap.tools.archmig.sap.jpa.entities.SAPAdmiFiles;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author e.soden
 *
 */
public interface SAPAdmiFileRepository extends PagingAndSortingRepository<SAPAdmiFiles, AdmiFileKey> {

	long countByCrep(String crep);
	
}
