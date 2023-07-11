/**
 * 
 */
package org.crossroad.idm.app.controller;

import org.crossroad.idm.app.service.IDMService;
import org.crossroad.sap.wsdl.idm.BAPIUSERGETDETAILResponse;
import org.crossroad.sap.wsdl.idm.BAPIUSERLOCKResponse;
import org.crossroad.sap.wsdl.idm.BAPIUSERUNLOCKResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author e.soden
 *
 */
@RestController("/idm")
public class IDMController {
	@Autowired
	IDMService service;

	@PostMapping("/unlock/{id}/{username}")
	public BAPIUSERUNLOCKResponse unlock(@PathVariable(name = "id") String id,
			@PathVariable(name = "username") String username) {
		return service.userUnlock(id, username);
	}

	@PostMapping("/lock/{id}/{username}")
	public BAPIUSERLOCKResponse lock(@PathVariable(name = "id") String id,
			@PathVariable(name = "username") String username) {
		return service.userLock(id, username);
	}

	@PostMapping("/detail/{id}/username")
	public BAPIUSERGETDETAILResponse detail(@PathVariable(name = "id") String id,
			@PathVariable(name = "username") String username) {
		try {
			return service.userDetail(id, username);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing", e);
		}
	}

}
