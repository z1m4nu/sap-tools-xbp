/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.bapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author e.soden-adm
 *
 */
@Data
public class BAPIXMSTEP extends AbstractBAPI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("PROGRAM")
	private String program;
	@JsonProperty("TYP")
	private char type;
	@JsonProperty("PARAMETER")
	private String parameter;
	@JsonProperty("OPSYSTEM")
	private String opSystem;
	@JsonProperty("AUTHCKNAM")
	private String authckNam;
	@JsonProperty("LISTIDENT")
	private Integer listIdent;
	@JsonProperty("XPGPID")
	private String xpgpId;
	@JsonProperty("XPGTGTSYS")
	private String XPGTGTSYS;
	@JsonProperty("LANGUAGE")
	private char language;
	@JsonProperty("STATUS")
	private char status;
	@JsonProperty("CONNCNTL")
	private char CONNCNTL;
	@JsonProperty("STDINCNTL")
	private char STDINCNTL;
	@JsonProperty("STDOUTCNTL")
	private char STDOUTCNTL;
	@JsonProperty("STDERRCNTL")
	private char STDERRCNTL;
	@JsonProperty("TRACECNTL")
	private char TRACECNTL;
	@JsonProperty("TERMCNTL")
	private char TERMCNTL;
	@JsonProperty("PDEST")
	private String PDEST;
	@JsonProperty("PRCOP")
	private Integer PRCOP;
	@JsonProperty("PLIST")
	private String PLIST;
	@JsonProperty("PRTXT")
	private String PRTXT;
	@JsonProperty("PRIMM")
	private char PRIMM;
	@JsonProperty("PRREL")
	private char PRREL;
	@JsonProperty("PRNEW")
	private char PRNEW;
	@JsonProperty("PEXPI")
	private char PEXPI;
	@JsonProperty("LINCT")
	private Integer LINCT;
	@JsonProperty("LINSZ")
	private Integer LINSZ;
	@JsonProperty("PAART")
	private String PAART;
	@JsonProperty("PRBIG")
	private char PRBIG;
	@JsonProperty("PRSAP")
	private char PRSAP;
	@JsonProperty("PRREC")
	private String PRREC;
	@JsonProperty("PRABT")
	private String PRABT;
	@JsonProperty("PRBER")
	private String PRBER;
	@JsonProperty("PRDSN")
	private String PRDSN;
	@JsonProperty("PTYPE")
	private String PTYPE;
	@JsonProperty("ARMOD")
	private char ARMOD;
	@JsonProperty("FOOTL")
	private char FOOTL;
	@JsonProperty("PRCHK")
	private Integer PRCHK;
	@JsonProperty("SAP_OBJECT")
	private String SAP_OBJECT;
	@JsonProperty("AR_OBJECT")
	private String AR_OBJECT;
	@JsonProperty("ARCHIV_ID")
	private String ARCHIV_ID;
	@JsonProperty("DOC_TYPE")
	private String DOC_TYPE;
	@JsonProperty("RPC_HOST")
	private String RPC_HOST;
	@JsonProperty("RPC_SERVIC")
	private String RPC_SERVIC;
	@JsonProperty("INTERFACE")
	private String INTERFACE;
	@JsonProperty("MANDANT")
	private String MANDANT;
	@JsonProperty("REPORT")
	private String REPORT;
	@JsonProperty("INFO")
	private String INFO;
	@JsonProperty("ARCTEXT")
	private String ARCTEXT;
	@JsonProperty("DATUM")
	private String DATUM;
	@JsonProperty("ARCUSER")
	private String ARCUSER;
	@JsonProperty("PRINTER")
	private String PRINTER;
	@JsonProperty("FORMULAR")
	private String FORMULAR;
	@JsonProperty("ARCHIVPATH")
	private String ARCHIVPATH;
	@JsonProperty("PROTOKOLL")
	private String PROTOKOLL;
	@JsonProperty("VERSION")
	private String VERSION;
	@JsonProperty("ACHECK")
	private Integer ACHECK;
}
