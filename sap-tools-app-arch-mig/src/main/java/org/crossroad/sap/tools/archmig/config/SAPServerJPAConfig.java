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
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.StringUtils;

@Configuration
public class SAPServerJPAConfig {

	private Logger log = LoggerFactory.getLogger(SAPServerJPAConfig.class);

	@Bean(name = "archmig.sap.db.ds")
	public DataSource plmExchangeBackendDS(@Value("${archmig.sap.jdbc.driver-class}") String driver,
			@Value("${archmig.sap.jdbc.url}") String url, @Value("${archmig.sap.jdbc.username:}") String username,
			@Value("${archmig.sap.jdbc.password:}") String password) {
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

}
