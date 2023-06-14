package org.crossroad.sap.tools.xbp.backend.controler;

import org.crossroad.sap.tools.jco.service.JCORuntimeException;
import org.crossroad.sap.tools.xbp.backend.service.XBPJobQueryService;
import org.crossroad.sap.tools.xbp.backend.service.XBPJobService;
import org.crossroad.sap.tools.xbp.data.job.Job;
import org.crossroad.sap.tools.xbp.data.job.JobData;
import org.crossroad.sap.tools.xbp.data.job.JobDefinition;
import org.crossroad.sap.tools.xbp.data.job.JobQuery;
import org.crossroad.sap.tools.xbp.data.result.JobQueryResult;
import org.crossroad.sap.tools.xbp.data.result.JobStatusResult;
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
@RequestMapping("/api/xbp/v1/job")
public class JobRestControler {

	@Autowired
	XBPJobService xbpJob;

	@Autowired
	XBPJobQueryService xbpQuery;


	@PostMapping(path = "/create/{destination}")
	public JobData createJob(@PathVariable("destination")String dest, @RequestBody(required = true) JobData container) {
		try {
			return xbpJob.create(dest, container);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing",e);
		}
	}

	@PostMapping(path = "/search/{destination}")
	public JobQueryResult foundJobs(@PathVariable("destination") String dest,
			@RequestBody(required = true) JobQuery container) {
		try {
			return xbpQuery.search(dest, container);
		} catch (JCORuntimeException e) {			
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing", e);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing", e);
		}
	}

	@GetMapping(path = "/count/{destination}")
	public JobQueryResult countJobs(@PathVariable("destination") String dest,
			@RequestParam(defaultValue = "*") String job, @RequestParam(defaultValue = "false") boolean withJobs) {
		try {
			return xbpQuery.count(dest, job, withJobs);
		} catch (JCORuntimeException e) {			
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing", e);
		}
	}
	
	@PostMapping(path = "/status/{destination}")
	public JobStatusResult jobStatus(@PathVariable("destination") String dest,
			@RequestBody(required = true) Job container) {
		try {
			return xbpJob.getStatus(dest, container);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing", e);
		}
	}

	@PostMapping(path = "/info/{destination}")
	public JobDefinition jobInfo(@PathVariable("destination") String dest,
			@RequestBody(required = true) Job container) {
		try {
			return xbpQuery.getDefinition(dest, container);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing", e);
		}
	}
}
