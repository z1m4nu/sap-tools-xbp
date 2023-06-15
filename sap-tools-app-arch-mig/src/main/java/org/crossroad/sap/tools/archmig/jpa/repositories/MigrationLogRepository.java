/**
 * 
 */
package org.crossroad.sap.tools.archmig.jpa.repositories;

import org.crossroad.sap.tools.archmig.jpa.entities.MigrationLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author e.soden
 *
 */
public interface MigrationLogRepository extends JpaRepository<MigrationLog, Long> {

}
