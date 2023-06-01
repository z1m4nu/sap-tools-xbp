/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.jco;

import java.io.Serializable;
import java.util.Properties;

/**
 * @author e.soden
 *
 */
public abstract class AbstractJco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract Properties asProperties();

}
