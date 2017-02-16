/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_teori_057.View;

import java.util.Observable;
import java.util.Observer;
import mvc_teori_057.model.Mahasiswa;

/**
 *
 * @author Jayuk
 */
public class MahasiswaView implements Observer
{
    private Mahasiswa mahasiswa;

    public MahasiswaView(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }
    
    
    public void tampilkanData() {
        for (int i = 0; i < 3; i++) {
            System.out.println("\n\nnama : " + mahasiswa.getNama(i));
            System.out.println("nim : " + mahasiswa.getNim(i));
            System.out.println("ipk : " + mahasiswa.getIpk(i));
            System.out.println("matakuliah : " + mahasiswa.getMatakuliah(i));
            for (int j = 1; j <= 2; j++) {
                System.out.println("nilai matakuliah[" + i + "][" + j + "] : " + mahasiswa.getNilai(i, j));
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) 
    {
        if (o == mahasiswa) {
            tampilkanData();
        }
    }
}
