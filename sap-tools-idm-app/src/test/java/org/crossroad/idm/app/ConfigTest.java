package org.crossroad.idm.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.crossroad.idm.app.config.SAPEndpoints;
import org.crossroad.idm.app.config.SAPEndpoints.SAPEndpoint;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConfigTest {
	@Autowired
	SAPEndpoints endpoints;

	@Test
	void checkConfiguration()
	{
		assertThat(endpoints).isNotNull();
		assertThat(endpoints.getEndpoints()).isNotEmpty().size().isEqualTo(1);
		
		SAPEndpoint endpoint = endpoints.getEndpoints().get("ecc-dev");
		assertThat(endpoint).isNotNull();
		assertThat(endpoint.getUsername()).isNotEmpty().isEqualTo("_IDM");
	}
}
