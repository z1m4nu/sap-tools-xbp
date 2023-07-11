/**
 * 
 */
package org.crossroad.sap.data.idm;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author e.soden
 *
 */
public enum BAPIBOOLCHAR {
	TRUE('X'), FALSE(' ');

	char sap;

	private BAPIBOOLCHAR(char sap) {
		this.sap = sap;
	}

	public char asSAP() {
		return this.sap;
	}

	public String asSAPStr() {
		return String.valueOf(sap);
	}

	public static BAPIBOOLCHAR valueOf(char sap) {
		Optional<BAPIBOOLCHAR> optEnv = Arrays.stream(BAPIBOOLCHAR.values()).filter(accStatus -> accStatus.sap == sap)
				.findFirst();

		if (!optEnv.isEmpty()) {
			return optEnv.get();
		} else {
			throw new IllegalArgumentException(String.format("SAP Boolean for sigle '%c' does not exist.", sap));
		}

	}
}
