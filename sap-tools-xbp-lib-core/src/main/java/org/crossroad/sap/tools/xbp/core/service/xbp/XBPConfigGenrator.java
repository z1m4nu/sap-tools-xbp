/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.service.xbp;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.crossroad.sap.tools.xbp.core.service.JCORuntimeException;
import org.crossroad.sap.tools.xbp.data.job.Job;
import org.crossroad.sap.tools.xbp.data.job.JobData;
import org.crossroad.sap.tools.xbp.data.job.JobStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author e.soden
 *
 */
@Component
public class XBPConfigGenrator {
	private static final Logger log = LoggerFactory.getLogger(XBPConfigGenrator.class);

	@Autowired
	@Qualifier(value = "xbp.objectmapper")
	ObjectMapper mapper;

	public void generate(String path) throws JCORuntimeException {
		JobData data = new JobData();
		Job key = new Job();
		key.setName("JOBNAME");

		key.setJobClass("C");

		data.setJob(key);
		

		for (int i = 0; i < 2; i++) {
			JobStep step = new JobStep();
			step.setLanguage("F");
			step.setProgram("REPORT_NAME");
			if (i > 0)
				step.setVariant("VARIANT");
			step.setUser("STEP_USER");
			step.setRank(i+1);
			
			data.getSteps().add(step);
		}
		

		try {
			Path file = Paths.get(path);
			if (file.getParent() != null) {
				Files.createDirectories(file.getParent());
			}

			
			mapper.writeValue(file.toFile(), data);

			log.info("Template generated in '{}'", file.toAbsolutePath());
		} catch (Exception e) {
			throw new JCORuntimeException(e,0);
		}
	}

}
