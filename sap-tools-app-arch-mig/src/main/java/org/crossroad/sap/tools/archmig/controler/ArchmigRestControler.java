/**
 * 
 */
package org.crossroad.sap.tools.archmig.controler;

import org.crossroad.sap.tools.archmig.data.ArchiveMigData;
import org.crossroad.sap.tools.archmig.data.ArchiveMigResult;
import org.crossroad.sap.tools.archmig.service.ArchiveMigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author e.soden
 *
 */
@RestController(value = "/archive-mig")
public class ArchmigRestControler {
	@Autowired
	ArchiveMigService service;
	
	
	@PostMapping("/migrate")
	public ArchiveMigResult migrate(@RequestBody(required = true) ArchiveMigData data)
	{
		return service.migrate(data);
	}
}
