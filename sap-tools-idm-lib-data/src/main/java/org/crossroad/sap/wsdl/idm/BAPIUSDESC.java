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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BAPIUSDESC complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BAPIUSDESC"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RESPONSIBLE" type="{urn:sap-com:document:sap:rfc:functions}char12"/&gt;
 *         &lt;element name="TECHDESC" type="{urn:sap-com:document:sap:rfc:functions}char80"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BAPIUSDESC", propOrder = {
    "responsible",
    "techdesc"
})
public class BAPIUSDESC {

    @XmlElement(name = "RESPONSIBLE", required = true)
    protected String responsible;
    @XmlElement(name = "TECHDESC", required = true)
    protected String techdesc;

    /**
     * Gets the value of the responsible property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESPONSIBLE() {
        return responsible;
    }

    /**
     * Sets the value of the responsible property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESPONSIBLE(String value) {
        this.responsible = value;
    }

    /**
     * Gets the value of the techdesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTECHDESC() {
        return techdesc;
    }

    /**
     * Sets the value of the techdesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTECHDESC(String value) {
        this.techdesc = value;
    }

}
