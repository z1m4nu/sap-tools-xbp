/**
 * 
 */
package org.crossroad.sap.tools.archmig.job;

import org.crossroad.sap.tools.archmig.data.MigrationConfig;
import org.crossroad.sap.tools.archmig.jpa.entities.BackendAdmiFiles;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.database.JdbcCursorItemReader;

import lombok.extern.slf4j.Slf4j;

/**
 * @author e.soden
 *
 */
@Slf4j
public class MigrationReader extends JdbcCursorItemReader<BackendAdmiFiles>  implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {
		JobParameters parameters = stepExecution.getJobParameters();
		
		String crep = parameters.getString(MigrationConfig.KEY_SRC_CREP, null);
		Long items = parameters.getLong(MigrationConfig.KEY_ITEMS_COUNT, 0L);
		
		String sqlStmt = String.format("SELECT * FROM ADMI_FILES WHERE CREP = '%s' order by creat_date desc", crep);

		log.debug("Use SQL [{}]", sqlStmt);

		setSql(sqlStmt);
		setCurrentItemCount(0);

		if (items > 0) {
			setMaxItemCount(items.intValue());
		}		
	}



	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		return null;
	}

}
