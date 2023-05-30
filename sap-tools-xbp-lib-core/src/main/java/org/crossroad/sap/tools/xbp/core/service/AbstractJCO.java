/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.service;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRuntimeException;
import com.sap.conn.jco.JCoStructure;

/**
 * @author e.soden
 *
 */
public abstract class AbstractJCO {
	private JCoDestination destination = null;



	/**
	 * @return the destination
	 */
	public JCoDestination getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 * @throws JCoException
	 */
	protected void createDestination(String destinationName) throws JCoRuntimeException {
		try {
			this.destination = JCoDestinationManager.getDestination(destinationName);
		} catch (Exception e) {
			throw new JCORuntimeException(e);
		}
	}

	protected JCoParameterList execute(JCoFunction function) throws JCORuntimeException {
		JCoParameterList data = null;
		try {
			function.execute(this.destination);

			data = function.getExportParameterList();
			JCoStructure struct = data.getStructure("RETURN");
			String type = struct.getString("TYPE");

			if ("E".equalsIgnoreCase(type)) {
				throw new JCORuntimeException(String.format("[%s] - %s - %s", struct.getString("MESSAGE_V1"),
						struct.getString("MESSAGE"), struct.getString("SYSTEM")));
			}
		} catch (JCORuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new JCORuntimeException(e);
		}
		return data;
	}
	
	
}
