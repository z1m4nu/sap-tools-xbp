/**
 * 
 */
package org.crossroad.sap.tools.archmig.controller;

import org.crossroad.sap.tools.archmig.data.MigrationConfig;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author e.soden
 *
 */
@RestController("/job/archive/migration")
public class JobController {
	@Autowired
	JobLauncher launcher;

	@Autowired
	@Qualifier(value = "archmig.job")
	Job migration;
	
	
	@PostMapping()
	public ResponseEntity<Object> startMigration(@RequestBody(required = true) MigrationConfig config) {
		try {
			JobParametersBuilder builder = new JobParametersBuilder();
			builder.addString(MigrationConfig.KEY_SRC_CREP, config.getSrcCREP());
			builder.addString(MigrationConfig.KEY_DST_CREP, config.getDstCREP());
			builder.addLong(MigrationConfig.KEY_ITEMS_COUNT, config.getDocToMigrate());
			builder.addLong(MigrationConfig.KEY_RUNID, System.currentTimeMillis());
			
			JobExecution execution = launcher.run(migration, builder.toJobParameters());
			
			return ResponseEntity.ok(execution.toString());
		} catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
