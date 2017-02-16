
package org.ws.tiketservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getDataTiket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDataTiket"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="asal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tujuan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDataTiket", propOrder = {
    "asal",
    "tujuan"
})
public class GetDataTiket {

    protected String asal;
    protected String tujuan;

    /**
     * Gets the value of the asal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsal() {
        return asal;
    }

    /**
     * Sets the value of the asal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsal(String value) {
        this.asal = value;
    }

    /**
     * Gets the value of the tujuan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTujuan() {
        return tujuan;
    }

    /**
     * Sets the value of the tujuan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTujuan(String value) {
        this.tujuan = value;
    }

}
