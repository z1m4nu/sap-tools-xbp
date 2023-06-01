/**
 * 
 */
package org.crossroad.sap.tools.xbp.backend.jpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author e.soden
 *
 */
@Entity(name = "destination")
public class JcoEntity {

	@Id
	@Column
	private String name;
	@Column
	private String def;
	@Column
	private Date creatime;
	@Column
	private Date modtime;

	
	
	/**
	 * @return the def
	 */
	public String getDef() {
		return def;
	}
	/**
	 * @param def the def to set
	 */
	public void setDef(String def) {
		this.def = def;
	}
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
	 * @return the creatime
	 */
	public Date getCreatime() {
		return creatime;
	}
	/**
	 * @param creatime the creatime to set
	 */
	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	/**
	 * @return the modtime
	 */
	public Date getModtime() {
		return modtime;
	}
	/**
	 * @param modtime the modtime to set
	 */
	public void setModtime(Date modtime) {
		this.modtime = modtime;
	}

	
}
