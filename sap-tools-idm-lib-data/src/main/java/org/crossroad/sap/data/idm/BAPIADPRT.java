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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BAPIADPRT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BAPIADPRT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="STD_NO" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="PRINT_DEST" type="{urn:sap-com:document:sap:rfc:functions}char4"/&gt;
 *         &lt;element name="STD_RECIP" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="HOME_FLAG" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="CONSNUMBER" type="{urn:sap-com:document:sap:rfc:functions}numeric3"/&gt;
 *         &lt;element name="ERRORFLAG" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="FLG_NOUSE" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *         &lt;element name="VALID_FROM" type="{urn:sap-com:document:sap:rfc:functions}char14"/&gt;
 *         &lt;element name="VALID_TO" type="{urn:sap-com:document:sap:rfc:functions}char14"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BAPIADPRT", propOrder = {
    "stdno",
    "printdest",
    "stdrecip",
    "homeflag",
    "consnumber",
    "errorflag",
    "flgnouse",
    "validfrom",
    "validto"
})
public class BAPIADPRT {

    @XmlElement(name = "STD_NO", required = true)
    protected String stdno;
    @XmlElement(name = "PRINT_DEST", required = true)
    protected String printdest;
    @XmlElement(name = "STD_RECIP", required = true)
    protected String stdrecip;
    @XmlElement(name = "HOME_FLAG", required = true)
    protected String homeflag;
    @XmlElement(name = "CONSNUMBER", required = true)
    protected String consnumber;
    @XmlElement(name = "ERRORFLAG", required = true)
    protected String errorflag;
    @XmlElement(name = "FLG_NOUSE", required = true)
    protected String flgnouse;
    @XmlElement(name = "VALID_FROM", required = true)
    protected String validfrom;
    @XmlElement(name = "VALID_TO", required = true)
    protected String validto;

    /**
     * Gets the value of the stdno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTDNO() {
        return stdno;
    }

    /**
     * Sets the value of the stdno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTDNO(String value) {
        this.stdno = value;
    }

    /**
     * Gets the value of the printdest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRINTDEST() {
        return printdest;
    }

    /**
     * Sets the value of the printdest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRINTDEST(String value) {
        this.printdest = value;
    }

    /**
     * Gets the value of the stdrecip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTDRECIP() {
        return stdrecip;
    }

    /**
     * Sets the value of the stdrecip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTDRECIP(String value) {
        this.stdrecip = value;
    }

    /**
     * Gets the value of the homeflag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHOMEFLAG() {
        return homeflag;
    }

    /**
     * Sets the value of the homeflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHOMEFLAG(String value) {
        this.homeflag = value;
    }

    /**
     * Gets the value of the consnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONSNUMBER() {
        return consnumber;
    }

    /**
     * Sets the value of the consnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONSNUMBER(String value) {
        this.consnumber = value;
    }

    /**
     * Gets the value of the errorflag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERRORFLAG() {
        return errorflag;
    }

    /**
     * Sets the value of the errorflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERRORFLAG(String value) {
        this.errorflag = value;
    }

    /**
     * Gets the value of the flgnouse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFLGNOUSE() {
        return flgnouse;
    }

    /**
     * Sets the value of the flgnouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFLGNOUSE(String value) {
        this.flgnouse = value;
    }

    /**
     * Gets the value of the validfrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALIDFROM() {
        return validfrom;
    }

    /**
     * Sets the value of the validfrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALIDFROM(String value) {
        this.validfrom = value;
    }

    /**
     * Gets the value of the validto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALIDTO() {
        return validto;
    }

    /**
     * Sets the value of the validto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALIDTO(String value) {
        this.validto = value;
    }

}
