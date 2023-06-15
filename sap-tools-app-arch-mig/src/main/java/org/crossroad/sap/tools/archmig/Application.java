/**
 * 
 */
package org.crossroad.sap.tools.archmig;

import org.crossroad.sap.tools.jco.JCOCore;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;

/**
 * @author e.soden
 *
 */
@EnableBatchProcessing
@SpringBootApplication(scanBasePackageClasses =  {Application.class, JCOCore.class},exclude = { JdbcRepositoriesAutoConfiguration.class })
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
