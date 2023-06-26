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
 *         &lt;element name="MAX_ROWS" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="RETURN" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIRET2" minOccurs="0"/&gt;
 *         &lt;element name="SELECTION_EXP" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIUSSEXP" minOccurs="0"/&gt;
 *         &lt;element name="SELECTION_RANGE" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIUSSRGE" minOccurs="0"/&gt;
 *         &lt;element name="USERLIST" type="{urn:sap-com:document:sap:rfc:functions}TABLE_OF_BAPIUSNAME" minOccurs="0"/&gt;
 *         &lt;element name="WITH_USERNAME" type="{urn:sap-com:document:sap:rfc:functions}char1" minOccurs="0"/&gt;
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
    "maxrows",
    "_return",
    "selectionexp",
    "selectionrange",
    "userlist",
    "withusername"
})
@XmlRootElement(name = "BAPI_USER_GETLIST")
public class BAPIUSERGETLIST {

    @XmlElement(name = "MAX_ROWS")
    protected Integer maxrows;
    @XmlElement(name = "RETURN")
    protected TABLEOFBAPIRET2 _return;
    @XmlElement(name = "SELECTION_EXP")
    protected TABLEOFBAPIUSSEXP selectionexp;
    @XmlElement(name = "SELECTION_RANGE")
    protected TABLEOFBAPIUSSRGE selectionrange;
    @XmlElement(name = "USERLIST")
    protected TABLEOFBAPIUSNAME userlist;
    @XmlElement(name = "WITH_USERNAME")
    protected String withusername;

    /**
     * Gets the value of the maxrows property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMAXROWS() {
        return maxrows;
    }

    /**
     * Sets the value of the maxrows property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMAXROWS(Integer value) {
        this.maxrows = value;
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
     * Gets the value of the selectionexp property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIUSSEXP }
     *     
     */
    public TABLEOFBAPIUSSEXP getSELECTIONEXP() {
        return selectionexp;
    }

    /**
     * Sets the value of the selectionexp property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIUSSEXP }
     *     
     */
    public void setSELECTIONEXP(TABLEOFBAPIUSSEXP value) {
        this.selectionexp = value;
    }

    /**
     * Gets the value of the selectionrange property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIUSSRGE }
     *     
     */
    public TABLEOFBAPIUSSRGE getSELECTIONRANGE() {
        return selectionrange;
    }

    /**
     * Sets the value of the selectionrange property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIUSSRGE }
     *     
     */
    public void setSELECTIONRANGE(TABLEOFBAPIUSSRGE value) {
        this.selectionrange = value;
    }

    /**
     * Gets the value of the userlist property.
     * 
     * @return
     *     possible object is
     *     {@link TABLEOFBAPIUSNAME }
     *     
     */
    public TABLEOFBAPIUSNAME getUSERLIST() {
        return userlist;
    }

    /**
     * Sets the value of the userlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link TABLEOFBAPIUSNAME }
     *     
     */
    public void setUSERLIST(TABLEOFBAPIUSNAME value) {
        this.userlist = value;
    }

    /**
     * Gets the value of the withusername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWITHUSERNAME() {
        return withusername;
    }

    /**
     * Sets the value of the withusername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWITHUSERNAME(String value) {
        this.withusername = value;
    }

}
