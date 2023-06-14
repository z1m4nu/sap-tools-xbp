/**
 * 
 */
package org.crossroad.sap.tools.archmig.sap.jpa.entities;

import java.io.Serializable;

/**
 * @author e.soden
 *
 */
public class AdmiFileKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String document;

	private String archivKey;

	/**
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * @param document the document to set
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	/**
	 * @return the archivKey
	 */
	public String getArchivKey() {
		return archivKey;
	}

	/**
	 * @param archivKey the archivKey to set
	 */
	public void setArchivKey(String archivKey) {
		this.archivKey = archivKey;
	}
	
	
}
