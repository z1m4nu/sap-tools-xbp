package org.crossroad.sap.tools.archmig.config;

import javax.sql.DataSource;

import org.crossroad.sap.tools.jco.service.JCoDestinationWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.StringUtils;

@Configuration
public class SAPBackendConfig {

	@Autowired
	JCoDestinationWrapper wrapper;
	
	private Logger log = LoggerFactory.getLogger(SAPBackendConfig.class);

	@Bean(name = "archmig.sap.db.ds")
	public DataSource plmExchangeBackendDS(@Value("${migration.jdbc.driver-class}") String driver,
			@Value("${migration.jdbc.url}") String url, @Value("${migration.jdbc.username:}") String username,
			@Value("${migration.jdbc.password:}") String password) {
		log.debug("Creating archmig.sap.db.ds...");

		final var managerDataSource = new DriverManagerDataSource();
		managerDataSource.setDriverClassName(driver);
		managerDataSource.setUrl(url);
		if (StringUtils.hasText(username)) {
			managerDataSource.setUsername(username);
			if (StringUtils.hasText(password)) {
				managerDataSource.setPassword(password);
			}
		}

		StringBuilder builder = new StringBuilder("\nSAP DB connection\n");
		builder.append("\n\tJDBC URL:").append(url).append("\n");
		builder.append("\tDriver class:").append(driver).append("\n");
		builder.append("\tUsername:").append(username).append("\n");
		log.info(builder.toString());

		return managerDataSource;
	}

	@Bean(name = "archmig.sap.db.jdbc.template")
	public NamedParameterJdbcTemplate createExchangeTemplate(@Qualifier(value = "archmig.sap.db.ds") DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}
	
	@Bean(name = "archmig.sap.jco")
	public JCoDestinationWrapper createJcoWrapper(@Value("${migration.jco}") String destination) {
		wrapper.connect(destination);
		
		return wrapper;
	}

}
