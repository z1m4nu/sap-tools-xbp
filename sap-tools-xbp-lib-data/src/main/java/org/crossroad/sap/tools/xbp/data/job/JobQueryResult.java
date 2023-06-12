/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.job;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMJOB;

/**
 * @author e.soden
 *
 */
public class JobQueryResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int count;
	private List<BAPIXMJOB> content = new LinkedList<>();
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the content
	 */
	public List<BAPIXMJOB> getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(List<BAPIXMJOB> content) {
		this.content = content;
	}

}
