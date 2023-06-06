/**
 * 
 */
package org.crossroad.sap.tools.xbp.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;

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
public class JCoDestinationWrapper {
	private static final Logger log = LoggerFactory.getLogger(JCoDestinationWrapper.class);
	private JCoDestination destination = null;
	private String name = null;

	public JCoDestinationWrapper(@NonNull String name) {
		this.name = name;
	}

	protected String getUserName()
	{
		return (this.destination != null) ? this.destination.getUser() : null;
	}
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
	public void create() throws JCoRuntimeException {
		try {
			this.destination = JCoDestinationManager.getDestination(name);
		} catch (Exception e) {
			throw new JCORuntimeException(e);
		}
	}

	public JCoFunction getFunction(String name) {
		try {
			return this.destination.getRepository().getFunction(name);
		} catch (Exception e) {
			throw new JCORuntimeException(e);
		}
	}

	/**
	 * 
	 * @param function
	 * @return
	 * @throws JCORuntimeException
	 */
	public void execute(JCoFunction function) throws JCORuntimeException {
		JCoParameterList data = null;
		try {
			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", getUserName());
			
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
		
	}

}
