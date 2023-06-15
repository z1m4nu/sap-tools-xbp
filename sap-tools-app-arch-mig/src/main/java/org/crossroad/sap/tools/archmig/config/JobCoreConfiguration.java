/**
 * 
 */
package org.crossroad.sap.tools.archmig.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * @author e.soden
 *
 */
@Configuration
@EnableBatchProcessing
public class JobCoreConfiguration  {
	private static final Logger log = LoggerFactory.getLogger(JobCoreConfiguration.class);

	@Value("${batch.jdbc.scripts.drop}")
	private Resource dropReopsitoryTables;

	@Value("${batch.jdbc.scripts.create}")
	private Resource dataReopsitorySchema;

	@Primary
	@Bean(name = "batch.ds")
	public DataSource batchds(@Value("${batch.jdbc.driver-class}") String driver,
			@Value("${batch.jdbc.url}") String url, @Value("${batch.jdbc.username:}") String username,
			@Value("${batch.jdbc.password:}") String password) {
		log.debug("Creating batch.ds...");

		final var managerDataSource = new DriverManagerDataSource();
		managerDataSource.setDriverClassName(driver);
		managerDataSource.setUrl(url);
		if (StringUtils.hasText(username)) {
			managerDataSource.setUsername(username);
			if (StringUtils.hasText(password)) {
				managerDataSource.setPassword(password);
			}
		}

		StringBuilder builder = new StringBuilder("\nBackend DB connection\n");
		builder.append("\n\tJDBC URL:").append(url).append("\n");
		builder.append("\tDriver class:").append(driver).append("\n");
		builder.append("\tUsername:").append(username).append("\n");
		log.info(builder.toString());

		return managerDataSource;
	}
	
	

	@Bean
	public DataSourceInitializer dataSourceInitializer(@Qualifier(value = "batch.ds") DataSource dataSource) {
		log.debug("Creating datasourceinitializer...");
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();

		databasePopulator.addScript(dropReopsitoryTables);
		databasePopulator.addScript(dataReopsitorySchema);
		databasePopulator.setIgnoreFailedDrops(true);

		DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator);

		return initializer;
	}

	@Bean(name = "transactionManager")
	@Primary
	public ResourcelessTransactionManager transactionManager() {
		log.debug("Creating transactionManager...");
		return new ResourcelessTransactionManager();
	}

	@Bean(name = "jobRepository")
	@Primary
	public JobRepository jobRepository(
			@Qualifier(value = "transactionManager") ResourcelessTransactionManager transactionManager,
			@Qualifier(value = "batch.ds") DataSource dataSource, @Value("${batch.jdbc.database-platform}") String dbType) throws Exception {
		log.debug("Creating jobRepository...");
		JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
		jobRepositoryFactoryBean.setTransactionManager(transactionManager);
		jobRepositoryFactoryBean.setDatabaseType("POSTGRES");
		jobRepositoryFactoryBean.setDataSource(dataSource);
		return jobRepositoryFactoryBean.getObject();
	}


	@Bean
	public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry) {
		log.debug("Creating jobRegistryBeanPostProcessor...");
		JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
		jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);
		return jobRegistryBeanPostProcessor;
	}

	@Bean(name = "task-executor")
	public ThreadPoolTaskExecutor jobThreadTaskExecutor(@Value("${batch.thread-pool.core}") String core,
			@Value("${batch.thread-pool.max}") String max,
			@Value("${batch.thread-pool.allow-timeout}") String allowtimeout,
			@Value("${batch.thread-pool.queue-capacity}") String queue) {
		log.debug("Creating task-executor...");
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(Integer.valueOf(max));
		taskExecutor.setMaxPoolSize(Integer.valueOf(max));
		taskExecutor.setAllowCoreThreadTimeOut(Boolean.valueOf(allowtimeout));
		taskExecutor.setQueueCapacity(Integer.valueOf(queue));
		return taskExecutor;
	}


	@Bean(name = "request-logging-filter")
	public CommonsRequestLoggingFilter logFilter() {
		log.debug("Creating CommonsRequestLoggingFilter...");
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludeQueryString(true);
		filter.setIncludeHeaders(true);
		filter.setIncludeClientInfo(true);
		return filter;
	}
}
