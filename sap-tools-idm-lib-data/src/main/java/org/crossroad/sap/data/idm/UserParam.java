/**
 * 
 */
package org.crossroad.sap.data.idm;

import lombok.Getter;
import lombok.Setter;

/**
 * @author e.soden
 *
 */
@Getter
@Setter
public class UserParam {
	private USERSEARCHPARAM parameter;
	private BAPIOPTION option;
	private String low;
	private String high;
	private RSDSLOGOP logOp;
}
