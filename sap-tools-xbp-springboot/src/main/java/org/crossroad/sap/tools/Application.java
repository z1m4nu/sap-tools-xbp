/**
 * 
 */
package org.crossroad.sap.tools;

import java.util.LinkedList;
import java.util.List;

import org.crossroad.sap.tools.service.job.JcoQueryJobs;
import org.crossroad.sap.tools.service.xbp.XBTCreate;
import org.crossroad.sap.tools.service.xbp.XBTResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

/**
 * @author e.soden
 *
 */
@SpringBootApplication(scanBasePackageClasses = { Application.class })
public class Application implements ApplicationRunner {
	@Autowired
	XBTCreate xbtCreate;

	@Autowired
	XBTResources xbtResource;

	@Autowired
	JcoQueryJobs jcoQueryJobs;

	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(Application.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<String> destinations = new LinkedList<>();
		List<String> jobFiles = new LinkedList<>();
		boolean waitOnExecute = false;
		OPERATION operation = OPERATION.HELP;
		String extUserName = null;
		if (args.containsOption("xbt-create")) {
			operation = OPERATION.XBTCREATE;
			jobFiles.addAll(args.getOptionValues("xbt-create"));

		} else if (args.containsOption("resources")) {
			operation = OPERATION.RESOURCES;
			extUserName = args.getOptionValues("resources").get(0).toUpperCase();
		}

		if (args.containsOption("destination")) {
			destinations.addAll(args.getOptionValues("destination"));
		}

		if (args.containsOption("wait")) {
			waitOnExecute = true;
		}

		switch (operation) {
		case XBTCREATE:
			if (!destinations.isEmpty() && !jobFiles.isEmpty()) {
				for (String destinationName : destinations) {
					for (String jobFile : jobFiles) {
						xbtCreate.createJob(destinationName, jobFile, waitOnExecute);
					}
				}
			}
			break;
		case QUERY:
			if (!destinations.isEmpty() && !jobFiles.isEmpty()) {
				for (String destinationName : destinations) {
					jcoQueryJobs.getRunningJob(destinationName);
				}
			}
			break;
		case RESOURCES:
			if (!destinations.isEmpty() && StringUtils.hasText(extUserName)) {
				for (String destinationName : destinations) {
					xbtResource.check(destinationName, extUserName);
				}
			}
			break;
		case HELP:
		default:
			break;
		}

	}

}
