/**
 * 
 */
package org.crossroad.sap.tools.archmig.config;

import javax.sql.DataSource;

import org.crossroad.sap.tools.archmig.data.BackendAdmiFilesRowMapper;
import org.crossroad.sap.tools.archmig.job.MigrationProcessor;
import org.crossroad.sap.tools.archmig.jpa.entities.BackendAdmiFiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author e.soden
 *
 */
@Configuration
@EnableBatchProcessing
public class JobConfiguration {
	private Logger log = LoggerFactory.getLogger(JobConfiguration.class);
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier(value = "archmig.sap.db.ds")
	DataSource ds;

	@Bean(name = "archmig.reader")
	public JdbcCursorItemReader<BackendAdmiFiles> jdbcCursorItemReader(
			@Value("${batch.sap.jdbc.fetch-size:2000}") int fetchSize,
			@Value("${batch.sap.jdbc.read-start:0}") int startRead, @Value("${batch.content-rep.source}") String crep) {
		log.debug("Creating archmig.reader...");
		JdbcCursorItemReader<BackendAdmiFiles> cursorItemReader = new JdbcCursorItemReader<>();
		String sqlStmt = String.format("SELECT * FROM ADMI_FILES WHERE CREP = '%s'", crep);
		
		log.debug("Use SQL [{}]", sqlStmt);

		cursorItemReader.setSql(sqlStmt);
		cursorItemReader.setFetchSize(fetchSize);
		cursorItemReader.setCurrentItemCount(startRead);
		cursorItemReader.setName("SAP ADMI_FILES reader");
		cursorItemReader.setDataSource(ds);
		cursorItemReader.setRowMapper(new BackendAdmiFilesRowMapper());
		return cursorItemReader;
	}
	
	@Bean(name = "archmig.writer")
	public ItemWriter<? super Object> itemWriter() {
		log.debug("Creating archmig.writer...");
		return emps -> {
			System.out.println("\nWriting chunk to console");
			for (Object emp : emps) {
				System.out.println(emp);
			}
		};
	}
	
	@Bean(name = "archmig.processor")
	public MigrationProcessor processor()
	{
		log.debug("Creating archmig.processor...");
		
		return new MigrationProcessor();
	}
	
	@Bean(name = "archmig.step")
	public Step migStep(@Qualifier(value = "archmig.reader")JdbcCursorItemReader<BackendAdmiFiles> reader,
			@Qualifier(value = "archmig.processor") MigrationProcessor  processor,
			@Qualifier(value = "archmig.writer")ItemWriter<? super Object> writer,
			@Value("${batch.thread-pool.core:3}") int chunk) {
		log.debug("Creating archmig.step...");
		return this.stepBuilderFactory.get("MigrationStep").<BackendAdmiFiles,BackendAdmiFiles>chunk(chunk)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
	}

	@Bean(name = "archmig.job")
	public Job migrationJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager,@Qualifier(value = "archmig.step") Step step) {
		log.debug("Creating archmig.job...");
		return jobBuilderFactory.get("My-First-Job").start(step).build();
	}

}
