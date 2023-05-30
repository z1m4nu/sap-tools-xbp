/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.service.xbp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;

/**
 * @author e.soden
 *
 */
public class XBTResources extends AbstractXBT {
	private static final Logger log = LoggerFactory.getLogger(XBTResources.class);

	public int check(String destinationName, String extUserName) throws XBTException {
		try {
			this.createDestination(destinationName);

			login();

			JCoFunction function = getDestination().getRepository().getFunction("BAPI_XBP_GET_CURR_BP_RESOURCES");

			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", extUserName);

			JCoParameterList data = execute(function);
			log.debug("RFC - FM Job Open successful ");
		} catch (Exception e) {
			throw new XBTException(e);
		} finally {
			logoff();
		}
		
		return 0;
	}

}
