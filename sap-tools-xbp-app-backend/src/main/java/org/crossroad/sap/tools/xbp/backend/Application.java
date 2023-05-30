package org.crossroad.sap.tools.xbp.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;

@SpringBootApplication(scanBasePackageClasses =  {Application.class},exclude = { JdbcRepositoriesAutoConfiguration.class })
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
