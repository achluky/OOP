/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_teori_057;

import mvc_teori_057.Controller.MahasiswaController;
import mvc_teori_057.model.Mahasiswa;

/**
 *
 * @author Jayuk
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Mahasiswa mahasiswa = new Mahasiswa();
        MahasiswaController mc = new MahasiswaController(mahasiswa);
        mc.setDataMahasiswa();
    }
    
}
