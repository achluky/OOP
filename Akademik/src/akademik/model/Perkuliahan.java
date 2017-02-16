/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akademik.model;

/**
 *
 * @author Jayuk
 */
public class Perkuliahan 
{
    String nim;
    int idMatakuliah;
    double nilai;

    public Perkuliahan(String nim, int idMatakuliah, double nilai) {
        this.nim = nim;
        this.idMatakuliah = idMatakuliah;
        this.nilai = nilai;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public int getIdMatakuliah() {
        return idMatakuliah;
    }

    public void setIdMatakuliah(int idMatakuliah) {
        this.idMatakuliah = idMatakuliah;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }
    
    
}
