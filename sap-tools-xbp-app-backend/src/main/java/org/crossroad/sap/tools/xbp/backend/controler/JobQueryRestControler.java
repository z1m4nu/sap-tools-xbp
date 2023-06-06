package org.crossroad.sap.tools.xbp.backend.controler;

import java.util.List;

import org.crossroad.sap.tools.xbp.backend.service.XBPJobQueryService;
import org.crossroad.sap.tools.xbp.backend.service.XBPJobService;
import org.crossroad.sap.tools.xbp.data.job.JobData;
import org.crossroad.sap.tools.xbp.data.job.query.BAPIXMJOB;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/xbp/job/query/v1")
public class JobQueryRestControler {
	private static final Logger log = LoggerFactory.getLogger(JobQueryRestControler.class);
	@Autowired
	XBPJobQueryService xbpJob;

	@PostMapping(path = "/{destination}")
	public List<BAPIXMJOB> foundJobs(@PathVariable("destination") String dest, @RequestBody(required = true) JobQuery container) {
		try {
			return xbpJob.search(dest, container);
		} catch (Exception e) {
			log.error("Found job error",e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing", e);
		}
	}
	
}
