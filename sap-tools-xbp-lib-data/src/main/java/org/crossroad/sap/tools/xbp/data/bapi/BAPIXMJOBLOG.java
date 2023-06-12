/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.bapi;

import lombok.Data;

/**
 * @author e.soden
 *
 */
@Data
public class BAPIXMJOBLOG extends AbstractBAPI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String TMSNAME;
	private String TMSCLIENT;
	private Integer CHARCO;
	private String LANGU;
	private Integer TMSSIZE;
	public String getTMSNAME() {
		return TMSNAME;
	}
	public void setTMSNAME(String tMSNAME) {
		TMSNAME = tMSNAME;
	}
	public String getTMSCLIENT() {
		return TMSCLIENT;
	}
	public void setTMSCLIENT(String tMSCLIENT) {
		TMSCLIENT = tMSCLIENT;
	}
	public Integer getCHARCO() {
		return CHARCO;
	}
	public void setCHARCO(Integer cHARCO) {
		CHARCO = cHARCO;
	}
	public String getLANGU() {
		return LANGU;
	}
	public void setLANGU(String lANGU) {
		LANGU = lANGU;
	}
	public Integer getTMSSIZE() {
		return TMSSIZE;
	}
	public void setTMSSIZE(Integer tMSSIZE) {
		TMSSIZE = tMSSIZE;
	}
	
	
}
