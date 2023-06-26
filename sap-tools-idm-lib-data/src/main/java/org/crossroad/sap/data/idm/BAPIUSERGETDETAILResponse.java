//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.26 at 11:31:01 PM CEST 
//


package org.crossroad.sap.data.idm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ACTIVITYGROUPS" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIAGR" minOccurs="0"/&gt;
 *         &lt;element name="ADDCOMREM" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPICOMREM" minOccurs="0"/&gt;
 *         &lt;element name="ADDFAX" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIADFAX" minOccurs="0"/&gt;
 *         &lt;element name="ADDPAG" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIADPAG" minOccurs="0"/&gt;
 *         &lt;element name="ADDPRT" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIADPRT" minOccurs="0"/&gt;
 *         &lt;element name="ADDRESS" type="{urn:sap-com:document:sap:rfc:functions}BAPIADDR3"/&gt;
 *         &lt;element name="ADDRFC" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIADRFC" minOccurs="0"/&gt;
 *         &lt;element name="ADDRML" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIADRML" minOccurs="0"/&gt;
 *         &lt;element name="ADDSMTP" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIADSMTP" minOccurs="0"/&gt;
 *         &lt;element name="ADDSSF" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIADSSF" minOccurs="0"/&gt;
 *         &lt;element name="ADDTEL" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIADTEL" minOccurs="0"/&gt;
 *         &lt;element name="ADDTLX" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIADTLX" minOccurs="0"/&gt;
 *         &lt;element name="ADDTTX" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIADTTX" minOccurs="0"/&gt;
 *         &lt;element name="ADDURI" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIADURI" minOccurs="0"/&gt;
 *         &lt;element name="ADDX400" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIADX400" minOccurs="0"/&gt;
 *         &lt;element name="ADMINDATA" type="{urn:sap-com:document:sap:rfc:functions}BAPIUSERADMIN"/&gt;
 *         &lt;element name="ALIAS" type="{urn:sap-com:document:sap:rfc:functions}BAPIALIAS"/&gt;
 *         &lt;element name="COMPANY" type="{urn:sap-com:document:sap:rfc:functions}BAPIUSCOMP"/&gt;
 *         &lt;element name="DEFAULTS" type="{urn:sap-com:document:sap:rfc:functions}BAPIDEFAUL"/&gt;
 *         &lt;element name="DESCRIPTION" type="{urn:sap-com:document:sap:rfc:functions}BAPIUSDESC"/&gt;
 *         &lt;element name="EXTIDHEAD" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIUSEXTIDHEAD" minOccurs="0"/&gt;
 *         &lt;element name="EXTIDPART" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIUSEXTIDPART" minOccurs="0"/&gt;
 *         &lt;element name="GROUPS" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIGROUPS" minOccurs="0"/&gt;
 *         &lt;element name="IDENTITY" type="{urn:sap-com:document:sap:rfc:functions}BAPIIDENTITY"/&gt;
 *         &lt;element name="ISLOCKED" type="{urn:sap-com:document:sap:rfc:functions}BAPISLOCKD"/&gt;
 *         &lt;element name="LASTMODIFIED" type="{urn:sap-com:document:sap:rfc:functions}BAPIMODDAT"/&gt;
 *         &lt;element name="LOGONDATA" type="{urn:sap-com:document:sap:rfc:functions}BAPILOGOND"/&gt;
 *         &lt;element name="PARAMETER" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIPARAM" minOccurs="0"/&gt;
 *         &lt;element name="PARAMETER1" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIPARAM1" minOccurs="0"/&gt;
 *         &lt;element name="PROFILES" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIPROF" minOccurs="0"/&gt;
 *         &lt;element name="REF_USER" type="{urn:sap-com:document:sap:rfc:functions}BAPIREFUS"/&gt;
 *         &lt;element name="RETURN" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIRET2"/&gt;
 *         &lt;element name="SNC" type="{urn:sap-com:document:sap:rfc:functions}BAPISNCU"/&gt;
 *         &lt;element name="SYSTEMS" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIRCVSYS" minOccurs="0"/&gt;
 *         &lt;element name="UCLASS" type="{urn:sap-com:document:sap:rfc:functions}BAPIUCLASS"/&gt;
 *         &lt;element name="UCLASSSYS" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIUCLASSSYS" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "activitygroups",
    "addcomrem",
    "addfax",
    "addpag",
    "addprt",
    "address",
    "addrfc",
    "addrml",
    "addsmtp",
    "addssf",
    "addtel",
    "addtlx",
    "addttx",
    "adduri",
    "addx400",
    "admindata",
    "alias",
    "company",
    "defaults",
    "description",
    "extidhead",
    "extidpart",
    "groups",
    "identity",
    "islocked",
    "lastmodified",
    "logondata",
    "parameter",
    "parameter1",
    "profiles",
    "refuser",
    "_return",
    "snc",
    "systems",
    "uclass",
    "uclasssys"
})
@XmlRootElement(name = "BAPI_USER_GET_DETAILResponse")
public class BAPIUSERGETDETAILResponse {

    @XmlElement(name = "ACTIVITYGROUPS")
    protected TABLEOFBAPIAGR activitygroups;
    @XmlElement(name = "ADDCOMREM")
    protected TABLEOFBAPICOMREM addcomrem;
    @XmlElement(name = "ADDFAX")
    protected TABLEOFBAPIADFAX addfax;
    @XmlElement(name = "ADDPAG")
    protected TABLEOFBAPIADPAG addpag;
    @XmlElement(name = "ADDPRT")
    protected TABLEOFBAPIADPRT addprt;
    @XmlElement(name = "ADDRESS", required = true)
    protected BAPIADDR3 address;
    @XmlElement(name = "ADDRFC")
    protected TABLEOFBAPIADRFC addrfc;
    @XmlElement(name = "ADDRML")
    protected TABLEOFBAPIADRML addrml;
    @XmlElement(name = "ADDSMTP")
    protected TABLEOFBAPIADSMTP addsmtp;
    @XmlElement(name = "ADDSSF")
    protected TABLEOFBAPIADSSF addssf;
    @XmlElement(name = "ADDTEL")
    protected TABLEOFBAPIADTEL addtel;
    @XmlElement(name = "ADDTLX")
    protected TABLEOFBAPIADTLX addtlx;
    @XmlElement(name = "ADDTTX")
    protected TABLEOFBAPIADTTX addttx;
    @XmlElement(name = "ADDURI")
    protected TABLEOFBAPIADURI adduri;
    @XmlElement(name = "ADDX400")
    protected TABLEOFBAPIADX400 addx400;
    @XmlElement(name = "ADMINDATA", required = true)
    protected BAPIUSERADMIN admindata;
    @XmlElement(name = "ALIAS", required = true)
    protected BAPIALIAS alias;
    @XmlElement(name = "COMPANY", required = true)
    protected BAPIUSCOMP company;
    @XmlElement(name = "DEFAULTS", required = true)
    protected BAPIDEFAUL defaults;
    @XmlElement(name = "DESCRIPTION", required = true)
    protected BAPIUSDESC description;
    @XmlElement(name = "EXTIDHEAD")
    protected TABLEOFBAPIUSEXTIDHEAD extidhead;
    @XmlElement(name = "EXTIDPART")
    protected TABLEOFBAPIUSEXTIDPART extidpart;
    @XmlElement(name = "GROUPS")
    protected TABLEOFBAPIGROUPS groups;
    @XmlElement(name = "IDENTITY", required = true)
    protected BAPIIDENTITY identity;
    @XmlElement(name = "ISLOCKED", required = true)
    protected BAPISLOCKD islocked;
    @XmlElement(name = "LASTMODIFIED", required = true)
    protected BAPIMODDAT lastmodified;
    @XmlElement(name = "LOGONDATA", required = true)
    protected BAPILOGOND logondata;
    @XmlElement(name = "PARAMETER")
    protected TABLEOFBAPIPARAM parameter;
    @XmlElement(name = "PARAMETER1")
    protected TABLEOFBAPIPARAM1 parameter1;
    @XmlElement(name = "PROFILES")
    protected TABLEOFBAPIPROF profiles;
    @XmlElement(name = "REF_USER", required = true)
    protected BAPIREFUS refuser;
    @XmlElement(name = "RETURN", required = true)
    protected TABLEOFBAPIRET2 _return;
    @XmlElement(name = "SNC", required = true)
    protected BAPISNCU snc;
    @XmlElement(name = "SYSTEMS")
    protected TABLEOFBAPIRCVSYS systems;
    @XmlElement(name = "UCLASS", required = true)
    protected BAPIUCLASS uclass;
    @XmlElement(name = "UCLASSSYS")
    protected TABLEOFBAPIUCLASSSYS uclasssys;

    /**
     * Gets the value of the activitygroups property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIAGR }
     *     
     */
    public TABLEOFBAPIAGR getACTIVITYGROUPS() {
        return activitygroups;
    }

    /**
     * Sets the value of the activitygroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIAGR }
     *     
     */
    public void setACTIVITYGROUPS(TABLEOFBAPIAGR value) {
        this.activitygroups = value;
    }

    /**
     * Gets the value of the addcomrem property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPICOMREM }
     *     
     */
    public TABLEOFBAPICOMREM getADDCOMREM() {
        return addcomrem;
    }

    /**
     * Sets the value of the addcomrem property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPICOMREM }
     *     
     */
    public void setADDCOMREM(TABLEOFBAPICOMREM value) {
        this.addcomrem = value;
    }

    /**
     * Gets the value of the addfax property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIADFAX }
     *     
     */
    public TABLEOFBAPIADFAX getADDFAX() {
        return addfax;
    }

    /**
     * Sets the value of the addfax property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIADFAX }
     *     
     */
    public void setADDFAX(TABLEOFBAPIADFAX value) {
        this.addfax = value;
    }

    /**
     * Gets the value of the addpag property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIADPAG }
     *     
     */
    public TABLEOFBAPIADPAG getADDPAG() {
        return addpag;
    }

    /**
     * Sets the value of the addpag property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIADPAG }
     *     
     */
    public void setADDPAG(TABLEOFBAPIADPAG value) {
        this.addpag = value;
    }

    /**
     * Gets the value of the addprt property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIADPRT }
     *     
     */
    public TABLEOFBAPIADPRT getADDPRT() {
        return addprt;
    }

    /**
     * Sets the value of the addprt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIADPRT }
     *     
     */
    public void setADDPRT(TABLEOFBAPIADPRT value) {
        this.addprt = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link BAPIADDR3 }
     *     
     */
    public BAPIADDR3 getADDRESS() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link BAPIADDR3 }
     *     
     */
    public void setADDRESS(BAPIADDR3 value) {
        this.address = value;
    }

    /**
     * Gets the value of the addrfc property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIADRFC }
     *     
     */
    public TABLEOFBAPIADRFC getADDRFC() {
        return addrfc;
    }

    /**
     * Sets the value of the addrfc property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIADRFC }
     *     
     */
    public void setADDRFC(TABLEOFBAPIADRFC value) {
        this.addrfc = value;
    }

    /**
     * Gets the value of the addrml property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIADRML }
     *     
     */
    public TABLEOFBAPIADRML getADDRML() {
        return addrml;
    }

    /**
     * Sets the value of the addrml property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIADRML }
     *     
     */
    public void setADDRML(TABLEOFBAPIADRML value) {
        this.addrml = value;
    }

    /**
     * Gets the value of the addsmtp property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIADSMTP }
     *     
     */
    public TABLEOFBAPIADSMTP getADDSMTP() {
        return addsmtp;
    }

    /**
     * Sets the value of the addsmtp property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIADSMTP }
     *     
     */
    public void setADDSMTP(TABLEOFBAPIADSMTP value) {
        this.addsmtp = value;
    }

    /**
     * Gets the value of the addssf property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIADSSF }
     *     
     */
    public TABLEOFBAPIADSSF getADDSSF() {
        return addssf;
    }

    /**
     * Sets the value of the addssf property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIADSSF }
     *     
     */
    public void setADDSSF(TABLEOFBAPIADSSF value) {
        this.addssf = value;
    }

    /**
     * Gets the value of the addtel property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIADTEL }
     *     
     */
    public TABLEOFBAPIADTEL getADDTEL() {
        return addtel;
    }

    /**
     * Sets the value of the addtel property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIADTEL }
     *     
     */
    public void setADDTEL(TABLEOFBAPIADTEL value) {
        this.addtel = value;
    }

    /**
     * Gets the value of the addtlx property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIADTLX }
     *     
     */
    public TABLEOFBAPIADTLX getADDTLX() {
        return addtlx;
    }

    /**
     * Sets the value of the addtlx property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIADTLX }
     *     
     */
    public void setADDTLX(TABLEOFBAPIADTLX value) {
        this.addtlx = value;
    }

    /**
     * Gets the value of the addttx property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIADTTX }
     *     
     */
    public TABLEOFBAPIADTTX getADDTTX() {
        return addttx;
    }

    /**
     * Sets the value of the addttx property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIADTTX }
     *     
     */
    public void setADDTTX(TABLEOFBAPIADTTX value) {
        this.addttx = value;
    }

    /**
     * Gets the value of the adduri property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIADURI }
     *     
     */
    public TABLEOFBAPIADURI getADDURI() {
        return adduri;
    }

    /**
     * Sets the value of the adduri property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIADURI }
     *     
     */
    public void setADDURI(TABLEOFBAPIADURI value) {
        this.adduri = value;
    }

    /**
     * Gets the value of the addx400 property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIADX400 }
     *     
     */
    public TABLEOFBAPIADX400 getADDX400() {
        return addx400;
    }

    /**
     * Sets the value of the addx400 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIADX400 }
     *     
     */
    public void setADDX400(TABLEOFBAPIADX400 value) {
        this.addx400 = value;
    }

    /**
     * Gets the value of the admindata property.
     * 
     * @return
     *     possible object is
     *     {@link BAPIUSERADMIN }
     *     
     */
    public BAPIUSERADMIN getADMINDATA() {
        return admindata;
    }

    /**
     * Sets the value of the admindata property.
     * 
     * @param value
     *     allowed object is
     *     {@link BAPIUSERADMIN }
     *     
     */
    public void setADMINDATA(BAPIUSERADMIN value) {
        this.admindata = value;
    }

    /**
     * Gets the value of the alias property.
     * 
     * @return
     *     possible object is
     *     {@link BAPIALIAS }
     *     
     */
    public BAPIALIAS getALIAS() {
        return alias;
    }

    /**
     * Sets the value of the alias property.
     * 
     * @param value
     *     allowed object is
     *     {@link BAPIALIAS }
     *     
     */
    public void setALIAS(BAPIALIAS value) {
        this.alias = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link BAPIUSCOMP }
     *     
     */
    public BAPIUSCOMP getCOMPANY() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link BAPIUSCOMP }
     *     
     */
    public void setCOMPANY(BAPIUSCOMP value) {
        this.company = value;
    }

    /**
     * Gets the value of the defaults property.
     * 
     * @return
     *     possible object is
     *     {@link BAPIDEFAUL }
     *     
     */
    public BAPIDEFAUL getDEFAULTS() {
        return defaults;
    }

    /**
     * Sets the value of the defaults property.
     * 
     * @param value
     *     allowed object is
     *     {@link BAPIDEFAUL }
     *     
     */
    public void setDEFAULTS(BAPIDEFAUL value) {
        this.defaults = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link BAPIUSDESC }
     *     
     */
    public BAPIUSDESC getDESCRIPTION() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link BAPIUSDESC }
     *     
     */
    public void setDESCRIPTION(BAPIUSDESC value) {
        this.description = value;
    }

    /**
     * Gets the value of the extidhead property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIUSEXTIDHEAD }
     *     
     */
    public TABLEOFBAPIUSEXTIDHEAD getEXTIDHEAD() {
        return extidhead;
    }

    /**
     * Sets the value of the extidhead property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIUSEXTIDHEAD }
     *     
     */
    public void setEXTIDHEAD(TABLEOFBAPIUSEXTIDHEAD value) {
        this.extidhead = value;
    }

    /**
     * Gets the value of the extidpart property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIUSEXTIDPART }
     *     
     */
    public TABLEOFBAPIUSEXTIDPART getEXTIDPART() {
        return extidpart;
    }

    /**
     * Sets the value of the extidpart property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIUSEXTIDPART }
     *     
     */
    public void setEXTIDPART(TABLEOFBAPIUSEXTIDPART value) {
        this.extidpart = value;
    }

    /**
     * Gets the value of the groups property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIGROUPS }
     *     
     */
    public TABLEOFBAPIGROUPS getGROUPS() {
        return groups;
    }

    /**
     * Sets the value of the groups property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIGROUPS }
     *     
     */
    public void setGROUPS(TABLEOFBAPIGROUPS value) {
        this.groups = value;
    }

    /**
     * Gets the value of the identity property.
     * 
     * @return
     *     possible object is
     *     {@link BAPIIDENTITY }
     *     
     */
    public BAPIIDENTITY getIDENTITY() {
        return identity;
    }

    /**
     * Sets the value of the identity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BAPIIDENTITY }
     *     
     */
    public void setIDENTITY(BAPIIDENTITY value) {
        this.identity = value;
    }

    /**
     * Gets the value of the islocked property.
     * 
     * @return
     *     possible object is
     *     {@link BAPISLOCKD }
     *     
     */
    public BAPISLOCKD getISLOCKED() {
        return islocked;
    }

    /**
     * Sets the value of the islocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link BAPISLOCKD }
     *     
     */
    public void setISLOCKED(BAPISLOCKD value) {
        this.islocked = value;
    }

    /**
     * Gets the value of the lastmodified property.
     * 
     * @return
     *     possible object is
     *     {@link BAPIMODDAT }
     *     
     */
    public BAPIMODDAT getLASTMODIFIED() {
        return lastmodified;
    }

    /**
     * Sets the value of the lastmodified property.
     * 
     * @param value
     *     allowed object is
     *     {@link BAPIMODDAT }
     *     
     */
    public void setLASTMODIFIED(BAPIMODDAT value) {
        this.lastmodified = value;
    }

    /**
     * Gets the value of the logondata property.
     * 
     * @return
     *     possible object is
     *     {@link BAPILOGOND }
     *     
     */
    public BAPILOGOND getLOGONDATA() {
        return logondata;
    }

    /**
     * Sets the value of the logondata property.
     * 
     * @param value
     *     allowed object is
     *     {@link BAPILOGOND }
     *     
     */
    public void setLOGONDATA(BAPILOGOND value) {
        this.logondata = value;
    }

    /**
     * Gets the value of the parameter property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIPARAM }
     *     
     */
    public TABLEOFBAPIPARAM getPARAMETER() {
        return parameter;
    }

    /**
     * Sets the value of the parameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIPARAM }
     *     
     */
    public void setPARAMETER(TABLEOFBAPIPARAM value) {
        this.parameter = value;
    }

    /**
     * Gets the value of the parameter1 property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIPARAM1 }
     *     
     */
    public TABLEOFBAPIPARAM1 getPARAMETER1() {
        return parameter1;
    }

    /**
     * Sets the value of the parameter1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIPARAM1 }
     *     
     */
    public void setPARAMETER1(TABLEOFBAPIPARAM1 value) {
        this.parameter1 = value;
    }

    /**
     * Gets the value of the profiles property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIPROF }
     *     
     */
    public TABLEOFBAPIPROF getPROFILES() {
        return profiles;
    }

    /**
     * Sets the value of the profiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIPROF }
     *     
     */
    public void setPROFILES(TABLEOFBAPIPROF value) {
        this.profiles = value;
    }

    /**
     * Gets the value of the refuser property.
     * 
     * @return
     *     possible object is
     *     {@link BAPIREFUS }
     *     
     */
    public BAPIREFUS getREFUSER() {
        return refuser;
    }

    /**
     * Sets the value of the refuser property.
     * 
     * @param value
     *     allowed object is
     *     {@link BAPIREFUS }
     *     
     */
    public void setREFUSER(BAPIREFUS value) {
        this.refuser = value;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIRET2 }
     *     
     */
    public TABLEOFBAPIRET2 getRETURN() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIRET2 }
     *     
     */
    public void setRETURN(TABLEOFBAPIRET2 value) {
        this._return = value;
    }

    /**
     * Gets the value of the snc property.
     * 
     * @return
     *     possible object is
     *     {@link BAPISNCU }
     *     
     */
    public BAPISNCU getSNC() {
        return snc;
    }

    /**
     * Sets the value of the snc property.
     * 
     * @param value
     *     allowed object is
     *     {@link BAPISNCU }
     *     
     */
    public void setSNC(BAPISNCU value) {
        this.snc = value;
    }

    /**
     * Gets the value of the systems property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIRCVSYS }
     *     
     */
    public TABLEOFBAPIRCVSYS getSYSTEMS() {
        return systems;
    }

    /**
     * Sets the value of the systems property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIRCVSYS }
     *     
     */
    public void setSYSTEMS(TABLEOFBAPIRCVSYS value) {
        this.systems = value;
    }

    /**
     * Gets the value of the uclass property.
     * 
     * @return
     *     possible object is
     *     {@link BAPIUCLASS }
     *     
     */
    public BAPIUCLASS getUCLASS() {
        return uclass;
    }

    /**
     * Sets the value of the uclass property.
     * 
     * @param value
     *     allowed object is
     *     {@link BAPIUCLASS }
     *     
     */
    public void setUCLASS(BAPIUCLASS value) {
        this.uclass = value;
    }

    /**
     * Gets the value of the uclasssys property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIUCLASSSYS }
     *     
     */
    public TABLEOFBAPIUCLASSSYS getUCLASSSYS() {
        return uclasssys;
    }

    /**
     * Sets the value of the uclasssys property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIUCLASSSYS }
     *     
     */
    public void setUCLASSSYS(TABLEOFBAPIUCLASSSYS value) {
        this.uclasssys = value;
    }

}
