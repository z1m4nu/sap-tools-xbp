/**
 * 
 */
package org.crossroad.sap.tools.xbp.backend.jpa.repositories;

import org.crossroad.sap.tools.xbp.backend.jpa.entities.JcoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author e.soden
 *
 */
public interface JcoDestinationRepository extends JpaRepository<JcoEntity, String> {
	
}
