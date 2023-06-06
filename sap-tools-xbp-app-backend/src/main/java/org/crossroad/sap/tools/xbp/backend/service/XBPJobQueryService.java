/**
 * 
 */
package org.crossroad.sap.tools.xbp.backend.service;

import java.util.List;

import org.crossroad.sap.tools.xbp.core.service.JCoDestinationWrapper;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBPException;
import org.crossroad.sap.tools.xbp.core.service.xbp.XBPJobSelect;
import org.crossroad.sap.tools.xbp.core.service.xmi.XMIService;
import org.crossroad.sap.tools.xbp.data.job.query.BAPIXMJOB;
import org.crossroad.sap.tools.xbp.data.job.query.JobQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author e.soden
 *
 */
@Component
public class XBPJobQueryService {
	@Autowired
	XBPJobSelect selector;
	public List<BAPIXMJOB> search(String destination, JobQuery data) throws XBPException{
		JCoDestinationWrapper wrapper = null;
		XMIService xmiService = new XMIService();

		try {
			wrapper = new JCoDestinationWrapper(destination);
			wrapper.create();

			xmiService.login(wrapper.getDestination());

			selector.setDestinationWrapper(wrapper);
			return selector.foundJob(data);
			
		} finally {
			if(xmiService.isConnected()) {
				xmiService.logoff(wrapper.getDestination());
			}
		}
	}
	
}
