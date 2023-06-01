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
public class JcoClient extends AbstractJco  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ashost;
	private String sysnr;
	/**
	 * @return the ashost
	 */
	public String getAshost() {
		return ashost;
	}
	/**
	 * @param ashost the ashost to set
	 */
	public void setAshost(String ashost) {
		this.ashost = ashost;
	}
	/**
	 * @return the sysnr
	 */
	public String getSysnr() {
		return sysnr;
	}
	/**
	 * @param sysnr the sysnr to set
	 */
	public void setSysnr(String sysnr) {
		this.sysnr = sysnr;
	}
	@Override
	public Properties asProperties() {
		Properties prp = new Properties();
		prp.put("jco.client.ashost", getAshost());
		prp.put("jco.client.sysnr", getSysnr());
		return prp;
	}
	
	
	
}
