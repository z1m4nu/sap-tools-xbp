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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="IV_MODDATE" type="{urn:sap-com:document:sap:rfc:functions}date10"/&gt;
 *         &lt;element name="IV_MODDATE_TO" type="{urn:sap-com:document:sap:rfc:functions}date10" minOccurs="0"/&gt;
 *         &lt;element name="IV_MODTIME" type="{urn:sap-com:document:sap:rfc:functions}time"/&gt;
 *         &lt;element name="IV_MODTIME_TO" type="{urn:sap-com:document:sap:rfc:functions}time" minOccurs="0"/&gt;
 *         &lt;element name="IV_OPTION" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
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
    "ivmoddate",
    "ivmoddateto",
    "ivmodtime",
    "ivmodtimeto",
    "ivoption"
})
@XmlRootElement(name = "SUSR_GET_CHANGED_USERS")
public class SUSRGETCHANGEDUSERS {

    @XmlElement(name = "IV_MODDATE", required = true)
    protected String ivmoddate;
    @XmlElement(name = "IV_MODDATE_TO")
    protected String ivmoddateto;
    @XmlElement(name = "IV_MODTIME", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar ivmodtime;
    @XmlElement(name = "IV_MODTIME_TO")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar ivmodtimeto;
    @XmlElement(name = "IV_OPTION", required = true)
    protected String ivoption;

    /**
     * Gets the value of the ivmoddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIVMODDATE() {
        return ivmoddate;
    }

    /**
     * Sets the value of the ivmoddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIVMODDATE(String value) {
        this.ivmoddate = value;
    }

    /**
     * Gets the value of the ivmoddateto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIVMODDATETO() {
        return ivmoddateto;
    }

    /**
     * Sets the value of the ivmoddateto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIVMODDATETO(String value) {
        this.ivmoddateto = value;
    }

    /**
     * Gets the value of the ivmodtime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIVMODTIME() {
        return ivmodtime;
    }

    /**
     * Sets the value of the ivmodtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIVMODTIME(XMLGregorianCalendar value) {
        this.ivmodtime = value;
    }

    /**
     * Gets the value of the ivmodtimeto property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIVMODTIMETO() {
        return ivmodtimeto;
    }

    /**
     * Sets the value of the ivmodtimeto property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIVMODTIMETO(XMLGregorianCalendar value) {
        this.ivmodtimeto = value;
    }

    /**
     * Gets the value of the ivoption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIVOPTION() {
        return ivoption;
    }

    /**
     * Sets the value of the ivoption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIVOPTION(String value) {
        this.ivoption = value;
    }

}
