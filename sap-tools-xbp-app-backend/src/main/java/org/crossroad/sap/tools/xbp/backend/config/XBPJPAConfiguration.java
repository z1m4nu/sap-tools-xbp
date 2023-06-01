package org.crossroad.sap.tools.xbp.backend.config;

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
import org.springframework.util.StringUtils;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "xbp.jpa.entitymanager", transactionManagerRef = "xbp.jpa.transactionmanager", basePackages = "org.crossroad.sap.tools.xbp.backend.jpa.repositories")
@EntityScan(basePackages = "org.crossroad.sap.tools.xbp.backend.jpa.entities")
public class XBPJPAConfiguration {

	private Logger log = LoggerFactory.getLogger(XBPJPAConfiguration.class);

	@Bean(name = "xbp.jpa.db.ds")
	public DataSource plmExchangeBackendDS(@Value("${xbp.jpa.jdbc.driver-class}") String driver,
			@Value("${xbp.jpa.jdbc.url}") String url, @Value("${xbp.jpa.jdbc.username:}") String username,
			@Value("${xbp.jpa.jdbc.password:}") String password) {
		log.debug("Creating xbp.jpa.db.ds...");

		final DriverManagerDataSource managerDataSource = new DriverManagerDataSource();
		managerDataSource.setDriverClassName(driver);
		managerDataSource.setUrl(url);
		if (StringUtils.hasText(username)) {
			managerDataSource.setUsername(username);
			if (StringUtils.hasText(password)) {
				managerDataSource.setPassword(password);
			}
		}

		return managerDataSource;
	}

	@Bean(name = "xbp.jpa.db.template")
	public NamedParameterJdbcTemplate createJDBCTemplate(@Qualifier(value = "xbp.jpa.db.ds") DataSource ds) {
		log.debug("Creating xbp.jpa.db.template...");
		return new NamedParameterJdbcTemplate(ds);
	}

	@Bean(name = "xbp.jpa.entitymanager")
	public LocalContainerEntityManagerFactoryBean repoEntityManager(
			@Qualifier(value = "xbp.jpa.db.ds") DataSource ds,
			@Value("${xbp.jpa.jdbc.database-platform:}") String dialect,
			@Value("${xbp.jpa.jdbc.show-sql:false}") boolean showSql,
			@Value("${xbp.jpa.jdbc.fetch-size:2000}") int fetchSize) {
		log.debug("Create xbp.jpa.entitymanager...");

		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(ds);
		em.setPackagesToScan("org.crossroad.sap.tools.xbp.backend.jpa.entities");

		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		final HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "none");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.jdbc.fetch_size", fetchSize);
		
		if (StringUtils.hasText(dialect)) {
			properties.put("hibernate.dialect", dialect);
		}
		
		em.setJpaPropertyMap(properties);

		return em;
	}

	@Bean(name = "xbp.jpa.transactionmanager")
	public PlatformTransactionManager repoTransactionManager(
			@Qualifier(value = "xbp.jpa.entitymanager") LocalContainerEntityManagerFactoryBean em) {
		log.debug("Create xbp.jpa.transactionmanager...");
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(em.getObject());
		return transactionManager;
	}

}
