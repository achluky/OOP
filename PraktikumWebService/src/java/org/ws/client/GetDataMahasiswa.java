
package org.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getDataMahasiswa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDataMahasiswa"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nim" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDataMahasiswa", propOrder = {
    "nim"
})
public class GetDataMahasiswa {

    protected String nim;

    /**
     * Gets the value of the nim property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNim() {
        return nim;
    }

    /**
     * Sets the value of the nim property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNim(String value) {
        this.nim = value;
    }

}
