package org.crossroad.sap.tools.xbp.backend.controler;

import org.crossroad.sap.tools.xbp.backend.service.JcoDestinationService;
import org.crossroad.sap.tools.xbp.data.jco.JcoContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/xbp/dest/v1")
public class DestRestControler {

	@Autowired
	JcoDestinationService service;


	@PostMapping()
	public void createDestination(@RequestBody(required = true) JcoContainer container) {
		try {
			service.save(container, true);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing",e);
		}
	}
	
	@PutMapping()
	public void updateDestination(@RequestBody(required = true) JcoContainer container) {
		try {
			service.save(container, false);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing",e);
		}
	}
	
	@GetMapping(path = "/{destination}")
	public JcoContainer getDestination(@PathVariable("destination")String dest) {
		try {
			return service.getJcoInfo(dest);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing",e);
		}
	}

	@DeleteMapping(path = "/{destination}")
	public JcoContainer deleteDestination(@PathVariable("destination")String dest) {
		try {
			return service.delete(dest);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing",e);
		}
	}

	@PatchMapping(path = "/{destination}")
	public String dumpDestination(@PathVariable("destination")String dest) {
		try {
			return service.dump(dest);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error while processing",e);
		}
	}

}
