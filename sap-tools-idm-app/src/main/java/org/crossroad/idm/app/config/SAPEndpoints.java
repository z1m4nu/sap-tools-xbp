package org.crossroad.idm.app.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "sap")
public class SAPEndpoints {
private Map<String, SAPEndpoint> endpoints;

	@Getter
	@Setter
	public static class SAPEndpoint {
		private String name;
		private String endpoint;
		private String username;
		private String password;
	}

}