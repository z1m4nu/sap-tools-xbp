package org.crossroad.sap.tools.xbp.data.jco;

import java.io.Serializable;
import java.util.Properties;

import org.springframework.util.StringUtils;

public class JcoBaseClient extends AbstractJco implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lang;
	private String client;
	private String user;
	private String passwd;
	private String saprouter;

	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	/**
	 * @return the saprouter
	 */
	public String getSaprouter() {
		return saprouter;
	}

	/**
	 * @param saprouter the saprouter to set
	 */
	public void setSaprouter(String saprouter) {
		this.saprouter = saprouter;
	}

	@Override
	public Properties asProperties() {
		Properties prp = new Properties();

		if (StringUtils.hasText(lang)) {
			prp.put("jco.client.lang", getLang());
		}

		prp.put("jco.client.client", getClient());
		prp.put("jco.client.user", getUser());
		prp.put("jco.client.passwd", getPasswd());
		if (StringUtils.hasText(saprouter)) {
			prp.put("", getSaprouter());
		}

		return prp;
	}

}
