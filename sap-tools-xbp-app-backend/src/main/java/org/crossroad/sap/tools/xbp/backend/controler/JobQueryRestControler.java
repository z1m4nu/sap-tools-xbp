package org.crossroad.sap.tools.xbp.backend.controler;

import java.util.List;

import org.crossroad.sap.tools.xbp.backend.service.XBPJobQueryService;
import org.crossroad.sap.tools.xbp.backend.service.XBPJobService;
import org.crossroad.sap.tools.xbp.core.service.JCORuntimeException;
import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMJOB;
import org.crossroad.sap.tools.xbp.data.job.JobData;
import org.crossroad.sap.tools.xbp.data.job.query.JobQueryResult;
import org.crossroad.sap.tools.xbp.data.job.query.JobQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/xbp/job/query/v1")
public class JobQueryRestControler {
	private static final Logger log = LoggerFactory.getLogger(JobQueryRestControler.class);
	@Autowired
	XBPJobQueryService xbpJob;

	@PostMapping(path = "/{destination}")
	public JobQueryResult foundJobs(@PathVariable("destination") String dest,
			@RequestBody(required = true) JobQuery container) {
		try {
			return xbpJob.search(dest, container);
		} catch (JCORuntimeException e) {
			if (e.getErrId() == 57) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Job query '%s' not found", container.getJobParam().getJobName()), e);
			}
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing", e);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing", e);
		}
	}

	@GetMapping(path = "/count/{destination}")
	public JobQueryResult countJobs(@PathVariable("destination") String dest,
			@RequestParam(defaultValue = "*") String job, @RequestParam(defaultValue = "false") boolean withJobs) {
		try {
			return xbpJob.count(dest, job, withJobs);
		} catch (JCORuntimeException e) {
			if (e.getErrId() == 57) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Job query '%s' not found", job), e);
			}
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing", e);
		}
	}
}
