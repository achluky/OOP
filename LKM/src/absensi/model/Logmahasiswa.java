/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensi.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jayuk
 */
@Entity
@Table(name = "logmahasiswa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logmahasiswa.findAll", query = "SELECT l FROM Logmahasiswa l"),
    @NamedQuery(name = "Logmahasiswa.findByNim", query = "SELECT l FROM Logmahasiswa l WHERE l.nim = :nim"),
    @NamedQuery(name = "Logmahasiswa.findByTanggalMasuk", query = "SELECT l FROM Logmahasiswa l WHERE l.tanggalMasuk = :tanggalMasuk"),
    @NamedQuery(name = "Logmahasiswa.findByJamMasuk", query = "SELECT l FROM Logmahasiswa l WHERE l.jamMasuk = :jamMasuk")})
public class Logmahasiswa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nim")
    private String nim;
    @Basic(optional = false)
    @Column(name = "tanggalMasuk")
    private String tanggalMasuk;
    @Basic(optional = false)
    @Column(name = "jamMasuk")
    private String jamMasuk;

    public Logmahasiswa() {
    }

    public Logmahasiswa(String nim) {
        this.nim = nim;
    }

    public Logmahasiswa(String nim, String tanggalMasuk, String jamMasuk) {
        this.nim = nim;
        this.tanggalMasuk = tanggalMasuk;
        this.jamMasuk = jamMasuk;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getJamMasuk() {
        return jamMasuk;
    }

    public void setJamMasuk(String jamMasuk) {
        this.jamMasuk = jamMasuk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nim != null ? nim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logmahasiswa)) {
            return false;
        }
        Logmahasiswa other = (Logmahasiswa) object;
        if ((this.nim == null && other.nim != null) || (this.nim != null && !this.nim.equals(other.nim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "absensi.model.Logmahasiswa[ nim=" + nim + " ]";
    }
    
}
