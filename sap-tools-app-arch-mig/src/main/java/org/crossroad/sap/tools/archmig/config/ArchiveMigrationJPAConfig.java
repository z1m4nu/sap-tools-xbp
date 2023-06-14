package org.crossroad.sap.tools.archmig.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "archmig.backend.entitymanager", transactionManagerRef = "archmig.backend.transactionmanager", basePackages = {
		"org.crossroad.sap.tools.archmig.jpa.repositories" })
@EntityScan(basePackages = { "org.crossroad.sap.tools.archmig.jpa.entities" })
public class ArchiveMigrationJPAConfig {

	private Logger log = LoggerFactory.getLogger(ArchiveMigrationJPAConfig.class);

	@Bean(name = "archmig.backend.db.ds")
	public DataSource plmExchangeBackendDS(@Value("${archmig.backend.jdbc.driver-class}") String driver,
			@Value("${archmig.backend.jdbc.url}") String url, @Value("${archmig.backend.jdbc.username:}") String username,
			@Value("${archmig.backend.jdbc.password:}") String password) {
		log.debug("Creating archmig.backend.db.ds...");

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

	@Bean(name = "archmig.backend.db.jdbc.template")
	public NamedParameterJdbcTemplate createExchangeTemplate(@Qualifier(value = "archmig.backend.db.ds") DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}

	@Bean(name = "archmig.backend.entitymanager")
	public LocalContainerEntityManagerFactoryBean exchangeEntityManager(
			@Qualifier(value = "archmig.backend.db.ds") DataSource ds,
			@Value("${archmig.backend.jdbc.database-platform:}") String dialect,
			@Value("${archmig.backend.jdbc.show-sql:false}") boolean showSql,
			@Value("${archmig.backend.jdbc.fetch-size:2000}") int fetchSize) {
		log.debug("Load bean archmig.backend.entitymanager...");

		final var em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(ds);
		em.setPackagesToScan("org.crossroad.sap.tools.archmig.jpa.entities");

		final var vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		final HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "none");
		properties.put("hibernate.show_sql", showSql);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.jdbc.fetch_size", fetchSize);

		if (StringUtils.hasText(dialect)) {
			properties.put("hibernate.dialect", dialect);
		}
		em.setJpaPropertyMap(properties);

		return em;
	}

	@Bean(name = "archmig.backend.transactionmanager")
	public PlatformTransactionManager exchangeTransactionManager(
			@Qualifier(value = "archmig.backend.entitymanager") LocalContainerEntityManagerFactoryBean em) {
		log.debug("Load bean archmig.backend.transactionmanager...");
		return new JpaTransactionManager(em.getObject());
	}
}
