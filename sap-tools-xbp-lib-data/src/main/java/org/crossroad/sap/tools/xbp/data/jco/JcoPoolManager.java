package org.crossroad.sap.tools.xbp.data.jco;

import java.io.Serializable;
import java.util.Properties;

public class JcoPoolManager extends AbstractJco implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer connectiontimeout = 600000;
	private Integer maxwaittime = 30000;
	private Integer timeoutcheckinterval = 60000;

	/**
	 * @return the connectiontimeout
	 */
	public Integer getConnectiontimeout() {
		return connectiontimeout;
	}

	/**
	 * @param connectiontimeout the connectiontimeout to set
	 */
	public void setConnectiontimeout(Integer connectiontimeout) {
		this.connectiontimeout = connectiontimeout;
	}

	/**
	 * @return the maxwaittime
	 */
	public Integer getMaxwaittime() {
		return maxwaittime;
	}

	/**
	 * @param maxwaittime the maxwaittime to set
	 */
	public void setMaxwaittime(Integer maxwaittime) {
		this.maxwaittime = maxwaittime;
	}

	/**
	 * @return the timeoutcheckinterval
	 */
	public Integer getTimeoutcheckinterval() {
		return timeoutcheckinterval;
	}

	/**
	 * @param timeoutcheckinterval the timeoutcheckinterval to set
	 */
	public void setTimeoutcheckinterval(Integer timeoutcheckinterval) {
		this.timeoutcheckinterval = timeoutcheckinterval;
	}

	@Override
	public Properties asProperties() {
		Properties prp = new Properties();
		prp.put("jco.poolmgr.connectiontimeout", connectiontimeout);
		prp.put("jco.poolmgr.maxwaittime", maxwaittime);
		prp.put("jco.poolmgr.timeoutcheckinterval", timeoutcheckinterval);
		return prp;
	}

}
