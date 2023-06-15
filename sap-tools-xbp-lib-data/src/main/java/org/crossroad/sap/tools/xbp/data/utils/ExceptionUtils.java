/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author e.soden
 *
 */
public class ExceptionUtils {

	private ExceptionUtils() {
	}

	public static String sumarizeException(Throwable e)
	{
		var sw = new StringWriter();
		var pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		
		return sw.toString();
	}

	public static String sumarizeException(Exception e)
	{
		var sw = new StringWriter();
		var pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		
		return sw.toString();
	}

}
