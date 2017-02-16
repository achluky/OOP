package org.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jayuk
 */
@XmlRootElement
public class Mahasiswa 
{
    private String nama;
    private String nim;
    private double indeksPrestasi;

    public Mahasiswa() {
    }

    public Mahasiswa(String nama, String nim, double indeksPrestasi) {
        this.nama = nama;
        this.nim = nim;
        this.indeksPrestasi = indeksPrestasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public double getIndeksPrestasi() {
        return indeksPrestasi;
    }

    public void setIndeksPrestasi(double indeksPrestasi) {
        this.indeksPrestasi = indeksPrestasi;
    }
    
    
}
