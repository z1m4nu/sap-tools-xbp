package org.crossroad.sap.tools.xbp.backend;

import org.crossroad.sap.tools.xbp.core.XBPCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;

@SpringBootApplication(scanBasePackageClasses =  {Application.class, XBPCore.class},exclude = { JdbcRepositoriesAutoConfiguration.class })
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
