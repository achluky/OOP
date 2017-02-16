/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_teori_057.Controller;

import mvc_teori_057.View.MahasiswaView;
import mvc_teori_057.model.Mahasiswa;

/**
 *
 * @author Jayuk
 */
public class MahasiswaController 
{
    private Mahasiswa mahasiswa;
    private MahasiswaView mahasiswaView;

    public MahasiswaController(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
        mahasiswaView = new MahasiswaView(mahasiswa);
        mahasiswa.addObserver(mahasiswaView);
    }

    public void setDataMahasiswa() {
        mahasiswa.setNamas();
        mahasiswa.setNims();
        mahasiswa.setIpk();
        mahasiswa.setMatakuliah();
        mahasiswa.setNilai();
    }
}
