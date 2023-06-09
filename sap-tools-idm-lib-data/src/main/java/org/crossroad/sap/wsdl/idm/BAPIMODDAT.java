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
 * <p>Java class for BAPIMODDAT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BAPIMODDAT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MODDATE" type="{urn:sap-com:document:sap:rfc:functions}date10"/&gt;
 *         &lt;element name="MODTIME" type="{urn:sap-com:document:sap:rfc:functions}time"/&gt;
 *         &lt;element name="MODIFIER" type="{urn:sap-com:document:sap:rfc:functions}char12"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BAPIMODDAT", propOrder = {
    "moddate",
    "modtime",
    "modifier"
})
public class BAPIMODDAT {

    @XmlElement(name = "MODDATE", required = true)
    protected String moddate;
    @XmlElement(name = "MODTIME", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar modtime;
    @XmlElement(name = "MODIFIER", required = true)
    protected String modifier;

    /**
     * Gets the value of the moddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMODDATE() {
        return moddate;
    }

    /**
     * Sets the value of the moddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMODDATE(String value) {
        this.moddate = value;
    }

    /**
     * Gets the value of the modtime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMODTIME() {
        return modtime;
    }

    /**
     * Sets the value of the modtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMODTIME(XMLGregorianCalendar value) {
        this.modtime = value;
    }

    /**
     * Gets the value of the modifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMODIFIER() {
        return modifier;
    }

    /**
     * Sets the value of the modifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMODIFIER(String value) {
        this.modifier = value;
    }

}
