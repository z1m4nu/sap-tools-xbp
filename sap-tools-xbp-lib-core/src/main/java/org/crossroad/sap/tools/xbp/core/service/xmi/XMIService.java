package org.crossroad.sap.tools.xbp.core.service.xmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
@Component
public class XMIService {
	private static final Logger log = LoggerFactory.getLogger(XMIService.class);
	private boolean connected = false;

	public void login(JCoDestination destination) throws XMIException {
		try {
			JCoContext.begin(destination);
			JCoFunction xmiLogon = destination.getRepository().getFunction("BAPI_XMI_LOGON");
			xmiLogon.getImportParameterList().setValue("EXTCOMPANY", "CRD");
			xmiLogon.getImportParameterList().setValue("EXTPRODUCT", "TBP");
			xmiLogon.getImportParameterList().setValue("INTERFACE", "XBP");
			xmiLogon.getImportParameterList().setValue("VERSION", "3.0");
			xmiLogon.execute(destination);
			log.debug("XMI Retrurn\n{}\n",xmiLogon.getExportParameterList().toJSON());
			connected = true;
		} catch (Exception e) {
			throw new XMIException(e);
		}
	}

	public void logoff(JCoDestination destination) throws XMIException {
		try {
			JCoFunction xmiLogoff = destination.getRepository().getFunction("BAPI_XMI_LOGON");
			xmiLogoff.getImportParameterList().setValue("INTERFACE", "XBP");
			xmiLogoff.execute(destination);
		} catch (Exception e) {
			throw new XMIException(e);
		} finally {
			try {
				JCoContext.end(destination);
			} catch (JCoException e) {
				throw new XMIException(e);
			}
		}
		
	}
	
	public boolean isConnected() {
		return connected;
	}

}
