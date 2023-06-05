package org.crossroad.sap.tools.xbp.backend.controler;

import org.crossroad.sap.tools.xbp.backend.service.XBPJobService;
import org.crossroad.sap.tools.xbp.data.job.JobData;
import org.crossroad.sap.tools.xbp.data.job.query.JobQuery;
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
@RequestMapping("/api/xbp/job/v1")
public class JobRestControler {

	@Autowired
	XBPJobService xbpJob;


	@PostMapping(path = "/create/{destination}")
	public JobData createJob(@PathVariable("destination")String dest, @RequestBody(required = true) JobData container) {
		try {
			return xbpJob.create(dest, container);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing",e);
		}
	}
	
}
