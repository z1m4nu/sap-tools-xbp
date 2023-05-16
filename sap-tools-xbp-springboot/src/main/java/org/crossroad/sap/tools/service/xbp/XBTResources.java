/**
 * 
 */
package org.crossroad.sap.tools.service.xbp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

/**
 * @author e.soden
 *
 */
@Component
public class XBTResources extends AbstractXBT {
	private static final Logger log = LoggerFactory.getLogger(XBTResources.class);

	public int check(String destinationName, String extUserName) throws XBTException {
		try {
			this.createDestination(destinationName);

			login();

			JCoFunction function = getDestination().getRepository().getFunction("BAPI_XBP_GET_CURR_BP_RESOURCES");

			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", extUserName);

			JCoParameterList data = execute(function);
			//JCoTable table = data.getTable("RESOURCE_INFO");

			log.debug("RFC - FM Job Open successful ");
		} catch (Exception e) {
			throw new XBTException(e);
		} finally {
			logoff();
		}
		
		return 0;
	}

}
