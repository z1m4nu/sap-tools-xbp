/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.service.xbp;

import org.crossroad.sap.tools.xbp.core.service.AbstractJCO;

/**
 * @author e.soden
 *
 */
public abstract class AbstractXBT extends AbstractJCO {

	
	XMIService xmiService;

	public AbstractXBT() {
		super();
		xmiService = new XMIService();
	}


	/**
	 * @param destination
	 * @throws XMIException
	 * @see org.crossroad.sap.tools.xbp.core.service.xbp.XMIService#login(com.sap.conn.jco.JCoDestination)
	 */
	public void login() throws XBTException {
		xmiService.login(getDestination());
	}

	/**
	 * @param destination
	 * @throws XMIException
	 * @see org.crossroad.sap.tools.xbp.core.service.xbp.XMIService#logoff(com.sap.conn.jco.JCoDestination)
	 */
	public void logoff() throws XBTException {
		xmiService.logoff(getDestination());
	}

}
