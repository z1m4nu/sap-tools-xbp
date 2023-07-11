//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.28 at 09:18:34 PM CEST 
//


package org.crossroad.sap.wsdl.idm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for BAPILOGOND complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BAPILOGOND"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GLTGV" type="{urn:sap-com:document:sap:rfc:functions}date10"/&gt;
 *         &lt;element name="GLTGB" type="{urn:sap-com:document:sap:rfc:functions}date10"/&gt;
 *         &lt;element name="USTYP" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="CLASS" type="{urn:sap-com:document:sap:rfc:functions}char12"/&gt;
 *         &lt;element name="ACCNT" type="{urn:sap-com:document:sap:rfc:functions}char12"/&gt;
 *         &lt;element name="TZONE" type="{urn:sap-com:document:sap:rfc:functions}char6"/&gt;
 *         &lt;element name="LTIME" type="{urn:sap-com:document:sap:rfc:functions}time"/&gt;
 *         &lt;element name="BCODE" type="{urn:sap-com:document:sap:rfc:functions}byte8"/&gt;
 *         &lt;element name="CODVN" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="PASSCODE" type="{urn:sap-com:document:sap:rfc:functions}byte20"/&gt;
 *         &lt;element name="CODVC" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="PWDSALTEDHASH" type="{urn:sap-com:document:sap:rfc:functions}char255"/&gt;
 *         &lt;element name="CODVS" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="SECURITY_POLICY" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BAPILOGOND", propOrder = {
    "gltgv",
    "gltgb",
    "ustyp",
    "_class",
    "accnt",
    "tzone",
    "ltime",
    "bcode",
    "codvn",
    "passcode",
    "codvc",
    "pwdsaltedhash",
    "codvs",
    "securitypolicy"
})
public class BAPILOGOND {

    @XmlElement(name = "GLTGV", required = true)
    protected String gltgv;
    @XmlElement(name = "GLTGB", required = true)
    protected String gltgb;
    @XmlElement(name = "USTYP", required = true)
    protected String ustyp;
    @XmlElement(name = "CLASS", required = true)
    protected String _class;
    @XmlElement(name = "ACCNT", required = true)
    protected String accnt;
    @XmlElement(name = "TZONE", required = true)
    protected String tzone;
    @XmlElement(name = "LTIME", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar ltime;
    @XmlElement(name = "BCODE", required = true)
    protected byte[] bcode;
    @XmlElement(name = "CODVN", required = true)
    protected String codvn;
    @XmlElement(name = "PASSCODE", required = true)
    protected byte[] passcode;
    @XmlElement(name = "CODVC", required = true)
    protected String codvc;
    @XmlElement(name = "PWDSALTEDHASH", required = true)
    protected String pwdsaltedhash;
    @XmlElement(name = "CODVS", required = true)
    protected String codvs;
    @XmlElement(name = "SECURITY_POLICY", required = true)
    protected String securitypolicy;

    /**
     * Gets the value of the gltgv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGLTGV() {
        return gltgv;
    }

    /**
     * Sets the value of the gltgv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGLTGV(String value) {
        this.gltgv = value;
    }

    /**
     * Gets the value of the gltgb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGLTGB() {
        return gltgb;
    }

    /**
     * Sets the value of the gltgb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGLTGB(String value) {
        this.gltgb = value;
    }

    /**
     * Gets the value of the ustyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSTYP() {
        return ustyp;
    }

    /**
     * Sets the value of the ustyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSTYP(String value) {
        this.ustyp = value;
    }

    /**
     * Gets the value of the class property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLASS() {
        return _class;
    }

    /**
     * Sets the value of the class property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLASS(String value) {
        this._class = value;
    }

    /**
     * Gets the value of the accnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCNT() {
        return accnt;
    }

    /**
     * Sets the value of the accnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCNT(String value) {
        this.accnt = value;
    }

    /**
     * Gets the value of the tzone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTZONE() {
        return tzone;
    }

    /**
     * Sets the value of the tzone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTZONE(String value) {
        this.tzone = value;
    }

    /**
     * Gets the value of the ltime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLTIME() {
        return ltime;
    }

    /**
     * Sets the value of the ltime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLTIME(XMLGregorianCalendar value) {
        this.ltime = value;
    }

    /**
     * Gets the value of the bcode property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBCODE() {
        return bcode;
    }

    /**
     * Sets the value of the bcode property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBCODE(byte[] value) {
        this.bcode = value;
    }

    /**
     * Gets the value of the codvn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODVN() {
        return codvn;
    }

    /**
     * Sets the value of the codvn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODVN(String value) {
        this.codvn = value;
    }

    /**
     * Gets the value of the passcode property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPASSCODE() {
        return passcode;
    }

    /**
     * Sets the value of the passcode property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPASSCODE(byte[] value) {
        this.passcode = value;
    }

    /**
     * Gets the value of the codvc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODVC() {
        return codvc;
    }

    /**
     * Sets the value of the codvc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODVC(String value) {
        this.codvc = value;
    }

    /**
     * Gets the value of the pwdsaltedhash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPWDSALTEDHASH() {
        return pwdsaltedhash;
    }

    /**
     * Sets the value of the pwdsaltedhash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPWDSALTEDHASH(String value) {
        this.pwdsaltedhash = value;
    }

    /**
     * Gets the value of the codvs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODVS() {
        return codvs;
    }

    /**
     * Sets the value of the codvs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODVS(String value) {
        this.codvs = value;
    }

    /**
     * Gets the value of the securitypolicy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSECURITYPOLICY() {
        return securitypolicy;
    }

    /**
     * Sets the value of the securitypolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSECURITYPOLICY(String value) {
        this.securitypolicy = value;
    }

}