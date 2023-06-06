/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.job.query;

import java.io.Serializable;

/**
 * @author e.soden
 *
 */
public class BAPIXMJOB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String JOBNAME;
	private String JOBCOUNT;
	private Integer STEPCOUNT;
	private String SDLSTRTDT;
	private String SDLSTRTTM;
	private String BTCSYSTEM;
	private String SDLDATE;
	private String SDLTIME;
	private String SDLUNAME;
	private String LASTCHDATE;
	private String LASTCHTIME;
	private String LASTCHNAME;
	private String RELDATE;
	private String RELTIME;
	private String RELUNAME;
	private String STRTDATE;
	private String STRTTIME;
	private String ENDDATE;
	private String ENDTIME;
	private char PERIODIC;
	private char STATUS;
	private String AUTHCKNAM;
	private String AUTHCKMAN;
	private Integer SUCCNUM;
	private Integer PREDNUM;
	private String LASTSTRTDT;
	private String LASTSTRTTM;
	private Integer WPNUMBER;
	private Integer WPPROCID;
	private String EVENTID;
	private String EVENTPARM;
	private String JOBCLASS;
	private String CALENDARID;
	private String EXECSERVER;
	private String REAXSERVER;



	/**
	 * @return the jOBNAME
	 */
	public String getJOBNAME() {
		return JOBNAME;
	}
	/**
	 * @param jOBNAME the jOBNAME to set
	 */
	public void setJOBNAME(String jOBNAME) {
		JOBNAME = jOBNAME;
	}
	/**
	 * @return the jOBCOUNT
	 */
	public String getJOBCOUNT() {
		return JOBCOUNT;
	}
	/**
	 * @param jOBCOUNT the jOBCOUNT to set
	 */
	public void setJOBCOUNT(String jOBCOUNT) {
		JOBCOUNT = jOBCOUNT;
	}
	/**
	 * @return the sTEPCOUNT
	 */
	public Integer getSTEPCOUNT() {
		return STEPCOUNT;
	}
	/**
	 * @param sTEPCOUNT the sTEPCOUNT to set
	 */
	public void setSTEPCOUNT(Integer sTEPCOUNT) {
		STEPCOUNT = sTEPCOUNT;
	}
	/**
	 * @return the sDLSTRTDT
	 */
	public String getSDLSTRTDT() {
		return SDLSTRTDT;
	}
	/**
	 * @param sDLSTRTDT the sDLSTRTDT to set
	 */
	public void setSDLSTRTDT(String sDLSTRTDT) {
		SDLSTRTDT = sDLSTRTDT;
	}
	/**
	 * @return the sDLSTRTTM
	 */
	public String getSDLSTRTTM() {
		return SDLSTRTTM;
	}
	/**
	 * @param sDLSTRTTM the sDLSTRTTM to set
	 */
	public void setSDLSTRTTM(String sDLSTRTTM) {
		SDLSTRTTM = sDLSTRTTM;
	}
	/**
	 * @return the bTCSYSTEM
	 */
	public String getBTCSYSTEM() {
		return BTCSYSTEM;
	}
	/**
	 * @param bTCSYSTEM the bTCSYSTEM to set
	 */
	public void setBTCSYSTEM(String bTCSYSTEM) {
		BTCSYSTEM = bTCSYSTEM;
	}
	/**
	 * @return the sDLDATE
	 */
	public String getSDLDATE() {
		return SDLDATE;
	}
	/**
	 * @param sDLDATE the sDLDATE to set
	 */
	public void setSDLDATE(String sDLDATE) {
		SDLDATE = sDLDATE;
	}
	/**
	 * @return the sDLTIME
	 */
	public String getSDLTIME() {
		return SDLTIME;
	}
	/**
	 * @param sDLTIME the sDLTIME to set
	 */
	public void setSDLTIME(String sDLTIME) {
		SDLTIME = sDLTIME;
	}
	/**
	 * @return the sDLUNAME
	 */
	public String getSDLUNAME() {
		return SDLUNAME;
	}
	/**
	 * @param sDLUNAME the sDLUNAME to set
	 */
	public void setSDLUNAME(String sDLUNAME) {
		SDLUNAME = sDLUNAME;
	}
	/**
	 * @return the lASTCHDATE
	 */
	public String getLASTCHDATE() {
		return LASTCHDATE;
	}
	/**
	 * @param lASTCHDATE the lASTCHDATE to set
	 */
	public void setLASTCHDATE(String lASTCHDATE) {
		LASTCHDATE = lASTCHDATE;
	}
	/**
	 * @return the lASTCHTIME
	 */
	public String getLASTCHTIME() {
		return LASTCHTIME;
	}
	/**
	 * @param lASTCHTIME the lASTCHTIME to set
	 */
	public void setLASTCHTIME(String lASTCHTIME) {
		LASTCHTIME = lASTCHTIME;
	}
	/**
	 * @return the lASTCHNAME
	 */
	public String getLASTCHNAME() {
		return LASTCHNAME;
	}
	/**
	 * @param lASTCHNAME the lASTCHNAME to set
	 */
	public void setLASTCHNAME(String lASTCHNAME) {
		LASTCHNAME = lASTCHNAME;
	}
	/**
	 * @return the rELDATE
	 */
	public String getRELDATE() {
		return RELDATE;
	}
	/**
	 * @param rELDATE the rELDATE to set
	 */
	public void setRELDATE(String rELDATE) {
		RELDATE = rELDATE;
	}
	/**
	 * @return the rELTIME
	 */
	public String getRELTIME() {
		return RELTIME;
	}
	/**
	 * @param rELTIME the rELTIME to set
	 */
	public void setRELTIME(String rELTIME) {
		RELTIME = rELTIME;
	}
	/**
	 * @return the rELUNAME
	 */
	public String getRELUNAME() {
		return RELUNAME;
	}
	/**
	 * @param rELUNAME the rELUNAME to set
	 */
	public void setRELUNAME(String rELUNAME) {
		RELUNAME = rELUNAME;
	}
	/**
	 * @return the sTRTDATE
	 */
	public String getSTRTDATE() {
		return STRTDATE;
	}
	/**
	 * @param sTRTDATE the sTRTDATE to set
	 */
	public void setSTRTDATE(String sTRTDATE) {
		STRTDATE = sTRTDATE;
	}
	/**
	 * @return the sTRTTIME
	 */
	public String getSTRTTIME() {
		return STRTTIME;
	}
	/**
	 * @param sTRTTIME the sTRTTIME to set
	 */
	public void setSTRTTIME(String sTRTTIME) {
		STRTTIME = sTRTTIME;
	}
	/**
	 * @return the eNDDATE
	 */
	public String getENDDATE() {
		return ENDDATE;
	}
	/**
	 * @param eNDDATE the eNDDATE to set
	 */
	public void setENDDATE(String eNDDATE) {
		ENDDATE = eNDDATE;
	}
	/**
	 * @return the eNDTIME
	 */
	public String getENDTIME() {
		return ENDTIME;
	}
	/**
	 * @param eNDTIME the eNDTIME to set
	 */
	public void setENDTIME(String eNDTIME) {
		ENDTIME = eNDTIME;
	}
	/**
	 * @return the pERIODIC
	 */
	public char getPERIODIC() {
		return PERIODIC;
	}
	/**
	 * @param pERIODIC the pERIODIC to set
	 */
	public void setPERIODIC(char pERIODIC) {
		PERIODIC = pERIODIC;
	}
	/**
	 * @return the sTATUS
	 */
	public char getSTATUS() {
		return STATUS;
	}
	/**
	 * @param sTATUS the sTATUS to set
	 */
	public void setSTATUS(char sTATUS) {
		STATUS = sTATUS;
	}
	/**
	 * @return the aUTHCKNAM
	 */
	public String getAUTHCKNAM() {
		return AUTHCKNAM;
	}
	/**
	 * @param aUTHCKNAM the aUTHCKNAM to set
	 */
	public void setAUTHCKNAM(String aUTHCKNAM) {
		AUTHCKNAM = aUTHCKNAM;
	}
	/**
	 * @return the aUTHCKMAN
	 */
	public String getAUTHCKMAN() {
		return AUTHCKMAN;
	}
	/**
	 * @param aUTHCKMAN the aUTHCKMAN to set
	 */
	public void setAUTHCKMAN(String aUTHCKMAN) {
		AUTHCKMAN = aUTHCKMAN;
	}
	/**
	 * @return the sUCCNUM
	 */
	public Integer getSUCCNUM() {
		return SUCCNUM;
	}
	/**
	 * @param sUCCNUM the sUCCNUM to set
	 */
	public void setSUCCNUM(Integer sUCCNUM) {
		SUCCNUM = sUCCNUM;
	}
	/**
	 * @return the pREDNUM
	 */
	public Integer getPREDNUM() {
		return PREDNUM;
	}
	/**
	 * @param pREDNUM the pREDNUM to set
	 */
	public void setPREDNUM(Integer pREDNUM) {
		PREDNUM = pREDNUM;
	}
	/**
	 * @return the lASTSTRTDT
	 */
	public String getLASTSTRTDT() {
		return LASTSTRTDT;
	}
	/**
	 * @param lASTSTRTDT the lASTSTRTDT to set
	 */
	public void setLASTSTRTDT(String lASTSTRTDT) {
		LASTSTRTDT = lASTSTRTDT;
	}
	/**
	 * @return the lASTSTRTTM
	 */
	public String getLASTSTRTTM() {
		return LASTSTRTTM;
	}
	/**
	 * @param lASTSTRTTM the lASTSTRTTM to set
	 */
	public void setLASTSTRTTM(String lASTSTRTTM) {
		LASTSTRTTM = lASTSTRTTM;
	}
	/**
	 * @return the wPNUMBER
	 */
	public Integer getWPNUMBER() {
		return WPNUMBER;
	}
	/**
	 * @param wPNUMBER the wPNUMBER to set
	 */
	public void setWPNUMBER(Integer wPNUMBER) {
		WPNUMBER = wPNUMBER;
	}
	/**
	 * @return the wPPROCID
	 */
	public Integer getWPPROCID() {
		return WPPROCID;
	}
	/**
	 * @param wPPROCID the wPPROCID to set
	 */
	public void setWPPROCID(Integer wPPROCID) {
		WPPROCID = wPPROCID;
	}
	/**
	 * @return the eVENTID
	 */
	public String getEVENTID() {
		return EVENTID;
	}
	/**
	 * @param eVENTID the eVENTID to set
	 */
	public void setEVENTID(String eVENTID) {
		EVENTID = eVENTID;
	}
	/**
	 * @return the eVENTPARM
	 */
	public String getEVENTPARM() {
		return EVENTPARM;
	}
	/**
	 * @param eVENTPARM the eVENTPARM to set
	 */
	public void setEVENTPARM(String eVENTPARM) {
		EVENTPARM = eVENTPARM;
	}
	/**
	 * @return the jOBCLASS
	 */
	public String getJOBCLASS() {
		return JOBCLASS;
	}
	/**
	 * @param jOBCLASS the jOBCLASS to set
	 */
	public void setJOBCLASS(String jOBCLASS) {
		JOBCLASS = jOBCLASS;
	}
	/**
	 * @return the cALENDARID
	 */
	public String getCALENDARID() {
		return CALENDARID;
	}
	/**
	 * @param cALENDARID the cALENDARID to set
	 */
	public void setCALENDARID(String cALENDARID) {
		CALENDARID = cALENDARID;
	}
	/**
	 * @return the eXECSERVER
	 */
	public String getEXECSERVER() {
		return EXECSERVER;
	}
	/**
	 * @param eXECSERVER the eXECSERVER to set
	 */
	public void setEXECSERVER(String eXECSERVER) {
		EXECSERVER = eXECSERVER;
	}
	/**
	 * @return the rEAXSERVER
	 */
	public String getREAXSERVER() {
		return REAXSERVER;
	}
	/**
	 * @param rEAXSERVER the rEAXSERVER to set
	 */
	public void setREAXSERVER(String rEAXSERVER) {
		REAXSERVER = rEAXSERVER;
	}
	
	

}
