/**
 * 
 */
package org.crossroad.sap.tools.xbp.data.bapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * @author e.soden
 *
 */
@Setter
@Getter
public class RFCSI extends AbstractBAPI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("RFCPROTO")
	private String rfcProto;
	@JsonProperty("RFCCHARTYP")
	private String rfcCharType;
	@JsonProperty("RFCINTTYP")
	private String rfcIntType;
	@JsonProperty("RFCFLOTYP")
	private String rfcFloType;
	@JsonProperty("RFCDEST")
	private String rfcDest;
	@JsonProperty("RFCHOST")
	private String rfcHost;
	@JsonProperty("RFCSYSID")
	private String rfcSysID;
	@JsonProperty("RFCDATABS")
	private String rfcDataBS;
	@JsonProperty("RFCDBHOST")
	private String rfcDBHost;
	@JsonProperty("RFCDBSYS")
	private String rfcDBSys;
	@JsonProperty("RFCSAPRL")
	private String rfcAPRL;
	@JsonProperty("RFCMACH")
	private String rfcMach;
	@JsonProperty("RFCOPSYS")
	private String rfcOPSys;
	@JsonProperty("RFCTZONE")
	private String rfcTZone;
	@JsonProperty("RFCDAYST")
	private String rfcDayst;
	@JsonProperty("RFCIPADDR")
	private String rfcIPAddr;
	@JsonProperty("RFCKERNRL")
	private String rfcKernel;
	@JsonProperty("RFCHOST2")
	private String rfcHost2;
	@JsonProperty("RFCSI_RESV")
	private String rfcIResv;
	@JsonProperty("RFCIPV6ADDR")
	private String rfcV6Addr;

}
