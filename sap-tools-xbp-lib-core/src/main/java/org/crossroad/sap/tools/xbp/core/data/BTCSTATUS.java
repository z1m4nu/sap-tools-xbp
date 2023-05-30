package org.crossroad.sap.tools.xbp.core.data;

import java.util.Arrays;
import java.util.Optional;


public enum BTCSTATUS {
	SCHEDULED('P',3,"Scheduled"), RELEASED('S',2,"Released"), READY('Y', 1, "Ready"), ACTIVE('R',0, "Active"), CANCELED('A', 7, "Canceled"), SUSPEND('Z',4,"Released/susp."), FINSIHED('F', 6,"Finished");

	private final char sigle;
	private final String full;
	private int status;

	private BTCSTATUS(char sigle, int status, String full) {
		this.sigle = sigle;
		this.full = full;
		this.status = status;
	}
	
	public int getStatus()
	{
		return this.status;
	}
	
	
	public String full() {
		return this.full;
	}
	
	public char sigle() {
		return this.sigle;
	}
	
	
	public String sigleString() {
		return String.valueOf(sigle());
	}

    public static BTCSTATUS valueOf(char sigle) {
        Optional<BTCSTATUS> optEnv = Arrays.stream(BTCSTATUS.values())
            .filter(accStatus -> accStatus.sigle == sigle)
            .findFirst();
        
        if (!optEnv.isEmpty())
        {
        	return optEnv.get();
        } else {
        	throw new IllegalArgumentException(String.format("BTC status for sigle '%c' does not exist.", sigle));
        }
        
    }


}
