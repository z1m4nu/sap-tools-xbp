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
 * <p>Java class for BAPIPWD complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BAPIPWD"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BAPIPWD" type="{urn:sap-com:document:sap:rfc:functions}char40"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BAPIPWD", propOrder = {
    "bapipwd"
})
public class BAPIPWD {

    @XmlElement(name = "BAPIPWD", required = true)
    protected String bapipwd;

    /**
     * Gets the value of the bapipwd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBAPIPWD() {
        return bapipwd;
    }

    /**
     * Sets the value of the bapipwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBAPIPWD(String value) {
        this.bapipwd = value;
    }

}
