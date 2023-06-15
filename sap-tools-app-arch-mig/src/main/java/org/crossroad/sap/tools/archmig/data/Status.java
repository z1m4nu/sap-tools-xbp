/**
 * 
 */
package org.crossroad.sap.tools.archmig.data;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author e.soden
 *
 */
public enum Status {
	SUCCESS(0, "Success"), ERROR(1, "Error"), WARNING(1, "Warning");

	private int code;
	private String name;

	private Status(int code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}

	public static Status valueOf(int code) {
		Optional<Status> optEnv = Arrays.stream(Status.values()).filter(accStatus -> accStatus.code == code)
				.findFirst();

		if (!optEnv.isEmpty()) {
			return optEnv.get();
		} else {
			throw new IllegalArgumentException(String.format("Status unknown for code '%d' does not exist.", code));
		}

	}

}
