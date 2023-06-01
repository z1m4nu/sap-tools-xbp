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
public class JcoLBClient extends AbstractJco implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mshost;
	private String group;
	private String r3name;
	/**
	 * @return the mshost
	 */
	public String getMshost() {
		return mshost;
	}
	/**
	 * @param mshost the mshost to set
	 */
	public void setMshost(String mshost) {
		this.mshost = mshost;
	}
	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}
	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}
	/**
	 * @return the r3name
	 */
	public String getR3name() {
		return r3name;
	}
	/**
	 * @param r3name the r3name to set
	 */
	public void setR3name(String r3name) {
		this.r3name = r3name;
	}
	@Override
	public Properties asProperties() {
		Properties prp = new Properties();
		prp.put("jco.client.mshost", getMshost());
		prp.put("jco.client.group", getR3name());
		prp.put("jco.client.r3name", getGroup());
		return prp;
	}
	
}
