package org.crossroad.sap.tools.xbp.data.jco;

import java.io.Serializable;
import java.util.Properties;

public class JcoPool extends AbstractJco implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer maxconn = 15;
	private Integer maxpoolsize = 10;

	private boolean monitor = false;
	private long interval = 300000;
	/**
	 * @return the maxconn
	 */
	public Integer getMaxconn() {
		return maxconn;
	}
	/**
	 * @param maxconn the maxconn to set
	 */
	public void setMaxconn(Integer maxconn) {
		this.maxconn = maxconn;
	}
	/**
	 * @return the maxpoolsize
	 */
	public Integer getMaxpoolsize() {
		return maxpoolsize;
	}
	/**
	 * @param maxpoolsize the maxpoolsize to set
	 */
	public void setMaxpoolsize(Integer maxpoolsize) {
		this.maxpoolsize = maxpoolsize;
	}
	/**
	 * @return the monitor
	 */
	public boolean isMonitor() {
		return monitor;
	}
	/**
	 * @param monitor the monitor to set
	 */
	public void setMonitor(boolean monitor) {
		this.monitor = monitor;
	}
	/**
	 * @return the interval
	 */
	public long getInterval() {
		return interval;
	}
	/**
	 * @param interval the interval to set
	 */
	public void setInterval(long interval) {
		this.interval = interval;
	}
	@Override
	public Properties asProperties() {
		Properties prp = new Properties();
		prp.put("jco.pool.maxconn", maxconn);
		prp.put("jco.pool.maxpoolsize", maxpoolsize);
		prp.put("jco.pool.monitor", (monitor ? 1 : 0));
		prp.put("jco.pool.monitor.interval", interval);

		return prp;
	}
	
	
	

}
