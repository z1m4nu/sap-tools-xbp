/**
 * 
 */
package org.crossroad.sap.tools.jco.service;

import org.crossroad.sap.tools.xbp.data.bapi.BAPIRET2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
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
@Component
public class JCoDestinationWrapper {
	private static final Logger log = LoggerFactory.getLogger(JCoDestinationWrapper.class);
	
	@Autowired
	@Qualifier(value = "xbp.objectmapper")
	ObjectMapper mapper;

	private JCoDestination destination = null;

	

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
	public void connect(String name) throws JCoRuntimeException {
		try {
			this.destination = JCoDestinationManager.getDestination(name);
		} catch (Exception e) {
			throw new JCORuntimeException(e);
		}
	}
	
	public void disconnect() throws JCoRuntimeException {
		try {
			this.destination = null;
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
	public BAPIRET2 execute(JCoFunction function) throws JCORuntimeException {
		JCoParameterList data = null;
		try {
			function.getImportParameterList().setValue("EXTERNAL_USER_NAME", getUserName());
			
			function.execute(this.destination);
			data = function.getExportParameterList();
			JCoStructure bapiRet2Jco = data.getStructure("RETURN");
			BAPIRET2 bapiRet2 = mapper.readValue(bapiRet2Jco.toJSON(), BAPIRET2.class);
	
			return bapiRet2;
		} catch (Exception e) {
			log.error(String.format("Error while processing '%s' on '%s'", function.getName(), destination.getDestinationName()), e);
			throw new JCORuntimeException(e);
		}
		
	}

}
