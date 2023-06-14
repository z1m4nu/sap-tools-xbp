/**
 * 
 */
package org.crossroad.sap.tools.archmig.jpa.repositories;

import org.crossroad.sap.tools.archmig.jpa.entities.BackendAdmiFileKey;
import org.crossroad.sap.tools.archmig.jpa.entities.BackendAdmiFiles;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author e.soden
 *
 */
public interface BackendAdmiFilesRepository extends PagingAndSortingRepository<BackendAdmiFiles, BackendAdmiFileKey> {

}
