/**
 * 
 */
package org.crossroad.sap.tools.xbp.console;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.crossroad.sap.tools.xbp.core.XBPCore;
import org.crossroad.sap.tools.xbp.data.OPERATION;
import org.crossroad.sap.tools.xbp.data.job.JobOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author e.soden
 *
 */
@SpringBootApplication(scanBasePackageClasses = { XBPCore.class })
public class Application implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	JobProcessor processor;
	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(Application.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("EXECUTING : command line runner");
		Options options = new Options();
		/*
		 * Destination
		 */
		options.addOption(new Option("c", "create", true, "Create a job based on the job description"));
		options.addOption(new Option("C", "create-run", true, "Create and run based on the job description"));
		options.addOption(new Option("d", "destination", true, "Set the destination to use to connect."));

		Option option = new Option("g", "generate-job-config", true, "Generate job definition");
		option.setOptionalArg(true);
		option.setRequired(false);
		options.addOption(option);
		
		option = new Option("w", "wait-time", true, "Specify a wait time for operation in format hms (HHhMMmSSs).");
		option.setOptionalArg(true);
		option.setRequired(false);
		options.addOption(option);
		
		

		options.addOption(new Option("h", "help", false, "Show this help"));
		options.addOption(new Option("v", "version", false, "print the version information and exit"));

		options.addOption(new Option(null, "spring.output.ansi.enabled", true, "Spring ansi output"));
		CommandLineParser parser = new DefaultParser();

	
		JobOptions jobOptions = new JobOptions();
		try {
			// parse the command line arguments
			CommandLine line = parser.parse(options, args, true);
			// has the buildfile argument been passed?
			if (line.hasOption("help")) {
				jobOptions.setOperation(OPERATION.HELP);
			} else if (line.hasOption("create")) {
				jobOptions.setOperation(OPERATION.CREATE);
				jobOptions.setJobFile(line.getOptionValue("create"));
			} else if (line.hasOption("create-run")) {
				jobOptions.setOperation(OPERATION.CREATERUN);
				jobOptions.setJobFile(line.getOptionValue("create-run"));
			}else if (line.hasOption("generate-job-config")) {
				jobOptions.setOperation(OPERATION.GENERATE);
				jobOptions.setJobFile(line.getOptionValue("generate-job-config","job-config.json"));
			}

			if (line.hasOption("destination")) {
				// initialise the member variable
				jobOptions.setDestination(line.getOptionValue("destination"));
			}
			
			if (line.hasOption("wait-time")) {
				jobOptions.setWaitTime(line.getOptionValue("wait-time","5s"));
			}

		} catch (ParseException exp) {
			// oops, something went wrong
			System.err.println("Parsing failed.  Reason: " + exp.getMessage());
		}

		if (jobOptions.getOperation() == OPERATION.HELP)
		{
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("XBT Tools", options);
		} else {
			processor.process(jobOptions);
		}
	}

}
