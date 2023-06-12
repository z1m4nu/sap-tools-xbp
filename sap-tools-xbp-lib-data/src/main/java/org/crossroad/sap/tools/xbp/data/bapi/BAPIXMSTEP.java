/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.bapi;

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
	private String PROGRAM;
	private char TYP;
	private String PARAMETER;
	private String OPSYSTEM;
	private String AUTHCKNAM;
	private Integer LISTIDENT;
	private String XPGPID;
	private String XPGTGTSYS;
	private char LANGUAGE;
	private char STATUS;
	private char CONNCNTL;
	private char STDINCNTL;
	private char STDOUTCNTL;
	private char STDERRCNTL;
	private char TRACECNTL;
	private char TERMCNTL;
	private String PDEST;
	private Integer PRCOP;
	private String PLIST;
	private String PRTXT;
	private char PRIMM;
	private char PRREL;
	private char PRNEW;
	private char PEXPI;
	private Integer LINCT;
	private Integer LINSZ;
	private String PAART;
	private char PRBIG;
	private char PRSAP;
	private String PRREC;
	private String PRABT;
	private String PRBER;
	private String PRDSN;
	private String PTYPE;
	private char ARMOD;
	private char FOOTL;
	private Integer PRCHK;
	private String SAP_OBJECT;
	private String AR_OBJECT;
	private String ARCHIV_ID;
	private String DOC_TYPE;
	private String RPC_HOST;
	private String RPC_SERVIC;
	private String INTERFACE;
	private String MANDANT;
	private String REPORT;
	private String INFO;
	private String ARCTEXT;
	private String DATUM;
	private String ARCUSER;
	private String PRINTER;
	private String FORMULAR;
	private String ARCHIVPATH;
	private String PROTOKOLL;
	private String VERSION;
	private Integer ACHECK;
}
