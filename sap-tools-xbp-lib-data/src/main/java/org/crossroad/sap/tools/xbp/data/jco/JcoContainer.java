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
public class JcoContainer extends AbstractJco implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private String name = null;
	private JcoClient client = null;
	private JcoPoolManager poolmgr = null;
	private JcoPerformanceMonitor performanceMonitor = null;
	private JcoPool pool = null;
	private JcoLBClient lbClient = null;
	private JcoBaseClient base = null;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the client
	 */
	public JcoClient getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(JcoClient client) {
		this.client = client;
	}

	/**
	 * @return the poolmgr
	 */
	public JcoPoolManager getPoolmgr() {
		return poolmgr;
	}

	/**
	 * @param poolmgr the poolmgr to set
	 */
	public void setPoolmgr(JcoPoolManager poolmgr) {
		this.poolmgr = poolmgr;
	}

	/**
	 * @return the performanceMonitor
	 */
	public JcoPerformanceMonitor getPerformanceMonitor() {
		return performanceMonitor;
	}

	/**
	 * @param performanceMonitor the performanceMonitor to set
	 */
	public void setPerformanceMonitor(JcoPerformanceMonitor performanceMonitor) {
		this.performanceMonitor = performanceMonitor;
	}

	/**
	 * @return the pool
	 */
	public JcoPool getPool() {
		return pool;
	}

	/**
	 * @param pool the pool to set
	 */
	public void setPool(JcoPool pool) {
		this.pool = pool;
	}

	/**
	 * @return the lbClient
	 */
	public JcoLBClient getLbClient() {
		return lbClient;
	}

	/**
	 * @param lbClient the lbClient to set
	 */
	public void setLbClient(JcoLBClient lbClient) {
		this.lbClient = lbClient;
	}

	/**
	 * @return the base
	 */
	public JcoBaseClient getBase() {
		return base;
	}

	/**
	 * @param base the base to set
	 */
	public void setBase(JcoBaseClient base) {
		this.base = base;
	}

	@Override
	public Properties asProperties() {
		Properties prp = new Properties();

		if (client != null) {
			prp.putAll(client.asProperties());
		}

		if (base != null) {
			prp.putAll(base.asProperties());
		}

		if (lbClient != null) {
			prp.putAll(lbClient.asProperties());
		}

		if (performanceMonitor != null) {
			prp.putAll(performanceMonitor.asProperties());
		}

		if (pool != null) {
			prp.putAll(pool.asProperties());
		}

		if (poolmgr != null) {
			prp.putAll(poolmgr.asProperties());
		}
		return prp;
	}

}
