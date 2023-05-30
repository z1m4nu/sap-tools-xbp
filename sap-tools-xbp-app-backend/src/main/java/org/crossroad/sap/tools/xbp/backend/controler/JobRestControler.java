package org.crossroad.sap.tools.xbp.backend.controler;

import org.crossroad.sap.tools.xbp.core.service.xbp.XBTConfigGenrator;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBTCreate;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBTExecute;
import org.crossroad.sap.tools.xbp.data.job.JobContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	XBTCreate xbtCreate;

	@Autowired
	XBTExecute xbtExecute;

	@Autowired
	XBTConfigGenrator generator;

	@PostMapping(path = "/create/{destination}")
	public String createJob(@PathVariable("destination")String dest, @RequestBody(required = true) JobContainer container) {
		try {
			return xbtCreate.createJob(dest, container);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing",e);
		}
	}
	

}
