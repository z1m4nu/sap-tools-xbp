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
 * <p>Java class for BAPIUSEXTIDX complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BAPIUSEXTIDX"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EXTID" type="{urn:sap-com:document:sap:rfc:functions}char1"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BAPIUSEXTIDX", propOrder = {
    "extid"
})
public class BAPIUSEXTIDX {

    @XmlElement(name = "EXTID", required = true)
    protected String extid;

    /**
     * Gets the value of the extid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXTID() {
        return extid;
    }

    /**
     * Sets the value of the extid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXTID(String value) {
        this.extid = value;
    }

}
