/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.result;

import java.util.LinkedList;
import java.util.List;

import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMJOB;

import lombok.Data;

/**
 * @author e.soden
 *
 */
@Data
public class JobQueryResult extends AbstractJCoResult {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int count;
	private List<BAPIXMJOB> content = new LinkedList<>();
	
	

}
