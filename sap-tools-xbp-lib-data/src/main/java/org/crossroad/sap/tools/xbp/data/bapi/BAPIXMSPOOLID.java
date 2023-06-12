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
public class BAPIXMSPOOLID extends AbstractBAPI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("STEPNO")
	private Integer STEPNO;
	@JsonProperty("SPOOLID")
	private Integer SPOOLID;
	@JsonProperty("CLIENT")
	private String CLIENT;
	@JsonProperty("NAME")
	private String NAME;
	@JsonProperty("SUFFIX1")
	private String SUFFIX1;
	@JsonProperty("SUFFIX2")
	private String SUFFIX2;
	@JsonProperty("OWNER")
	private String OWNER;
	@JsonProperty("FINAL")
	private char FINAL;
	@JsonProperty("CRTIME")
	private String CRTIME;
	@JsonProperty("DLTIME")
	private String DLTIME;
	@JsonProperty("SPOPAGES")
	private Integer SPOPAGES;
	@JsonProperty("PRINTTIME")
	private char PRINTTIME;
	@JsonProperty("DELAFTERPRINT")
	private char DELAFTERPRINT;
	@JsonProperty("DEVICE")
	private String DEVICE;
	@JsonProperty("COPIES")
	private Integer COPIES;
	@JsonProperty("PRIORITY")
	private Integer PRIORITY;
	@JsonProperty("SPOFORMAT")
	private String SPOFORMAT;
	@JsonProperty("PJTOTAL")
	private Integer PJTOTAL;
	@JsonProperty("PJDONE")
	private Integer PJDONE;
	@JsonProperty("PJPROBLEM")
	private Integer PJPROBLEM;
	@JsonProperty("PJERROR")
	private Integer PJERROR;
	@JsonProperty("WRITER")
	private Integer WRITER;
	@JsonProperty("SPERROR")
	private char SPERROR;
	@JsonProperty("TEMSENAME")
	private String TEMSENAME;
	@JsonProperty("TEMSEPART")
	private Integer TEMSEPART;
	@JsonProperty("TEMSECLIENT")
	private String TEMSECLIENT;
	@JsonProperty("TITLE")
	private String TITLE;
	@JsonProperty("SAPCOVER")
	private char SAPCOVER;
	@JsonProperty("OSCOVER")
	private char OSCOVER;
	@JsonProperty("RECEIVER")
	private String RECEIVER;
	@JsonProperty("DIVISION")
	private String DIVISION;
	@JsonProperty("AUTHORITY")
	private String AUTHORITY;
	@JsonProperty("MODTIME")
	private String MODTIME;
	@JsonProperty("DOCTYP")
	private String DOCTYP;
	@JsonProperty("OSNAME")
	private String OSNAME;
	@JsonProperty("TMSSIZE")
	private Integer TMSSIZE;
	@JsonProperty("TEMSELOCAT")
	private String TEMSELOCAT;
	@JsonProperty("LINES")
	private Integer LINES;
	@JsonProperty("COLUMNS")
	private Integer COLUMNS;
	@JsonProperty("LANGU")
	private char LANGU;
	@JsonProperty("CODEPAGE")
	private Integer CODEPAGE;
	@JsonProperty("TMSPARTS")
	private Integer TMSPARTS;
}
