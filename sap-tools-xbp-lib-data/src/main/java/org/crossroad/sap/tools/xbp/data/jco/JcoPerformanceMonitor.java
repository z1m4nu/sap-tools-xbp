package org.crossroad.sap.tools.xbp.data.jco;

import java.io.Serializable;
import java.util.Properties;

public class JcoPerformanceMonitor extends AbstractJco implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean monitor = false;
	private Integer interval = 30000;
	/**
	 * @return the monitor
	 */
	public boolean getMonitor() {
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
	public Integer getInterval() {
		return interval;
	}
	/**
	 * @param interval the interval to set
	 */
	public void setInterval(Integer interval) {
		this.interval = interval;
	}
	@Override
	public Properties asProperties() {
		Properties prp = new Properties();
		prp.put("jco.performance.monitor", (monitor ? 1 : 0));
		prp.put("jco.performance.monitor.interval",  interval);
		return prp;
	}



}
