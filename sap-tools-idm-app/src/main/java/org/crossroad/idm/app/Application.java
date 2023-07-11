/**
 * 
 */
package org.crossroad.idm.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;

/**
 * @author e.soden
 *
 */
@SpringBootApplication(scanBasePackageClasses = {Application.class},exclude = { JdbcRepositoriesAutoConfiguration.class })
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
