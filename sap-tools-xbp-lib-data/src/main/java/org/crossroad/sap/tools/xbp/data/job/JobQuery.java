/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.job;

import java.io.Serializable;

import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMJSEL;

import lombok.Data;

/**
 * @author e.soden
 *
 */
@Data
public class JobQuery  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    private String abapName = null;
    private boolean susp = false;
    private String systemId = null;
    private String selection = "AL";
    private BAPIXMJSEL parameters = null;

    
    
}
