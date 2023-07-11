/**
 * 
 */
package org.crossroad.idm.app.ws;

import org.springframework.ws.WebServiceMessage;
import org.springframework.xml.transform.TransformerObjectSupport;

import lombok.extern.slf4j.Slf4j;

/**
 * @author e.soden
 *
 */
@Slf4j
public class HttpLoggingUtils extends TransformerObjectSupport {
		  private static final String NEW_LINE = System.getProperty("line.separator");

	  private HttpLoggingUtils() {}

	  public static void logMessage(String id, WebServiceMessage webServiceMessage) {
	    try {
	    	ByteArrayTransportOutputStream byteArrayTransportOutputStream =
	          new ByteArrayTransportOutputStream();
	      webServiceMessage.writeTo(byteArrayTransportOutputStream);

	      String httpMessage = new String(byteArrayTransportOutputStream.toByteArray());
	      log.debug(NEW_LINE + "----------------------------" + NEW_LINE + id + NEW_LINE
	          + "----------------------------" + NEW_LINE + httpMessage + NEW_LINE);
	    } catch (Exception e) {
	      log.error("Unable to log HTTP message.", e);
	    }
	  }

}
