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
 * <p>Java class for BAPIUSSEXP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BAPIUSSEXP"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="LOGOP" type="{urn:sap-com:document:sap:rfc:functions}char3"/&gt;
 *         &lt;element name="ARITY" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="PARAMETER" type="{urn:sap-com:document:sap:rfc:functions}char32"/&gt;
 *         &lt;element name="FIELD" type="{urn:sap-com:document:sap:rfc:functions}char30"/&gt;
 *         &lt;element name="OPTION" type="{urn:sap-com:document:sap:rfc:functions}char2"/&gt;
 *         &lt;element name="LOW" type="{urn:sap-com:document:sap:rfc:functions}char45"/&gt;
 *         &lt;element name="HIGH" type="{urn:sap-com:document:sap:rfc:functions}char45"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BAPIUSSEXP", propOrder = {
    "logop",
    "arity",
    "parameter",
    "field",
    "option",
    "low",
    "high"
})
public class BAPIUSSEXP {

    @XmlElement(name = "LOGOP", required = true)
    protected String logop;
    @XmlElement(name = "ARITY")
    protected int arity;
    @XmlElement(name = "PARAMETER", required = true)
    protected String parameter;
    @XmlElement(name = "FIELD", required = true)
    protected String field;
    @XmlElement(name = "OPTION", required = true)
    protected String option;
    @XmlElement(name = "LOW", required = true)
    protected String low;
    @XmlElement(name = "HIGH", required = true)
    protected String high;

    /**
     * Gets the value of the logop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOGOP() {
        return logop;
    }

    /**
     * Sets the value of the logop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOGOP(String value) {
        this.logop = value;
    }

    /**
     * Gets the value of the arity property.
     * 
     */
    public int getARITY() {
        return arity;
    }

    /**
     * Sets the value of the arity property.
     * 
     */
    public void setARITY(int value) {
        this.arity = value;
    }

    /**
     * Gets the value of the parameter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARAMETER() {
        return parameter;
    }

    /**
     * Sets the value of the parameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARAMETER(String value) {
        this.parameter = value;
    }

    /**
     * Gets the value of the field property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIELD() {
        return field;
    }

    /**
     * Sets the value of the field property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIELD(String value) {
        this.field = value;
    }

    /**
     * Gets the value of the option property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPTION() {
        return option;
    }

    /**
     * Sets the value of the option property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPTION(String value) {
        this.option = value;
    }

    /**
     * Gets the value of the low property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOW() {
        return low;
    }

    /**
     * Sets the value of the low property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOW(String value) {
        this.low = value;
    }

    /**
     * Gets the value of the high property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHIGH() {
        return high;
    }

    /**
     * Sets the value of the high property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHIGH(String value) {
        this.high = value;
    }

}
