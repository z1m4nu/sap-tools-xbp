/**
 * 
 */
package org.crossroad.sap.tools.archmig.config;

import javax.sql.DataSource;

import org.crossroad.sap.tools.archmig.data.BackendAdmiFilesRowMapper;
import org.crossroad.sap.tools.archmig.job.MigrationProcessor;
import org.crossroad.sap.tools.archmig.job.MigrationReader;
import org.crossroad.sap.tools.archmig.job.MigrationWriter;
import org.crossroad.sap.tools.archmig.jpa.entities.BackendAdmiFiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
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
@SuppressWarnings("unused")
@Configuration
@EnableBatchProcessing
public class JobConfiguration {
	private Logger log = LoggerFactory.getLogger(JobConfiguration.class);
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean(name = "archmig.reader")
	public MigrationReader jdbcCursorItemReader(
			@Qualifier(value = "archmig.sap.db.ds") DataSource ds,
			@Value(value = "${migration.jdbc.fetch-size:2000}") int fetchSize) {
		log.debug("Creating archmig.reader...");
		MigrationReader reader = new MigrationReader();
		reader.setFetchSize(fetchSize);

		reader.setSql("SELECT 1 FROM DUMMY");
		reader.setName("SAP ADMI_FILES reader");
		reader.setDataSource(ds);
		reader.setRowMapper(new BackendAdmiFilesRowMapper());
		return reader;
	}

	@Bean(name = "archmig.writer")
	public MigrationWriter itemWriter() {
		log.debug("Creating archmig.writer...");
		return new MigrationWriter();
	}

	@Bean(name = "archmig.processor")
	public MigrationProcessor processor() {
		log.debug("Creating archmig.processor...");

		return new MigrationProcessor();
	}

	@Bean(name = "archmig.step")
	public Step migStep(@Qualifier(value = "archmig.reader") MigrationReader reader,
			@Qualifier(value = "archmig.processor") MigrationProcessor processor,
			@Qualifier(value = "archmig.writer") MigrationWriter writer,
			@Value("${batch.thread-pool.core:3}") int chunk) {
		log.debug("Creating archmig.step...");
		return this.stepBuilderFactory.get("MigrationStep").<BackendAdmiFiles, BackendAdmiFiles>chunk(chunk)
				.reader(reader).processor(processor).writer(writer).build();
	}

	@Bean(name = "archmig.job")
	public Job migrationJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager,
			@Qualifier(value = "archmig.step") Step step) {
		log.debug("Creating archmig.job...");
		return jobBuilderFactory.get("My-First-Job").start(step).build();
	}

}
