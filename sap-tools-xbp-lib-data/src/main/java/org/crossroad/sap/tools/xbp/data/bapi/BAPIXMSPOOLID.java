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
public class BAPIXMSPOOLID extends AbstractBAPI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer STEPNO;
	private Integer SPOOLID;
	private String CLIENT;
	private String NAME;
	private String SUFFIX1;
	private String SUFFIX2;
	private String OWNER;
	private char FINAL;
	private String CRTIME;
	private String DLTIME;
	private Integer SPOPAGES;
	private char PRINTTIME;
	private char DELAFTERPRINT;
	private String DEVICE;
	private Integer COPIES;
	private Integer PRIORITY;
	private String SPOFORMAT;
	private Integer PJTOTAL;
	private Integer PJDONE;
	private Integer PJPROBLEM;
	private Integer PJERROR;
	private Integer WRITER;
	private char SPERROR;
	private String TEMSENAME;
	private Integer TEMSEPART;
	private String TEMSECLIENT;
	private String TITLE;
	private char SAPCOVER;
	private char OSCOVER;
	private String RECEIVER;
	private String DIVISION;
	private String AUTHORITY;
	private String MODTIME;
	private String DOCTYP;
	private String OSNAME;
	private Integer TMSSIZE;
	private String TEMSELOCAT;
	private Integer LINES;
	private Integer COLUMNS;
	private char LANGU;
	private Integer CODEPAGE;
	private Integer TMSPARTS;
}
