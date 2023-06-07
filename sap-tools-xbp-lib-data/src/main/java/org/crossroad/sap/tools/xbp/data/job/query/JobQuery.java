/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.job.query;

import java.io.Serializable;

import org.crossroad.sap.tools.xbp.data.bapi.BAPIXMJSEL;

/**
 * @author e.soden
 *
 */
public class JobQuery  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    private String abapName = null;
    private boolean susp = false;
    private String systemId = null;
    private String selection = "AL";
    private BAPIXMJSEL jobParam = null;

	/**
	 * @return the abapName
	 */
	public String getAbapName() {
		return abapName;
	}
	/**
	 * @param abapName the abapName to set
	 */
	public void setAbapName(String abapName) {
		this.abapName = abapName;
	}
	/**
	 * @return the susp
	 */
	public boolean isSusp() {
		return susp;
	}
	/**
	 * @param susp the susp to set
	 */
	public void setSusp(boolean susp) {
		this.susp = susp;
	}
	/**
	 * @return the systemId
	 */
	public String getSystemId() {
		return systemId;
	}
	/**
	 * @param systemId the systemId to set
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	/**
	 * @return the selection
	 */
	public String getSelection() {
		return selection;
	}
	/**
	 * @param selection the selection to set
	 */
	public void setSelection(String selection) {
		this.selection = selection;
	}
	/**
	 * @return the jobParam
	 */
	public BAPIXMJSEL getJobParam() {
		return jobParam;
	}
	/**
	 * @param jobParam the jobParam to set
	 */
	public void setJobParam(BAPIXMJSEL jobParam) {
		this.jobParam = jobParam;
	}
    
    
}
