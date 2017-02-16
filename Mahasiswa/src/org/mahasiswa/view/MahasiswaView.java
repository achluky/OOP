/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mahasiswa.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Observable;
import java.util.Observer;
import org.mahasiswa.model.Mahasiswa;

/**
 *
 * @author Jayuk
 */
public class MahasiswaView implements Observer
{
    Mahasiswa mahasiswa;
    
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader console =new BufferedReader(in);

    public MahasiswaView(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }
    
    
    public void printDataMahasiswa()
    {
        System.out.println("Mahasiswa");
        System.out.println("Nim     :"+mahasiswa.getNim());
        System.out.println("Nama    :"+mahasiswa.getNama());
        for(int i =0;i<mahasiswa.getMataKuliah().size();i++)
        {
            System.out.println("Matakuliah :"+mahasiswa.getMataKuliah().get(i)+"dengan Nilai :"+mahasiswa.getNilai().get(i));
        }
        System.out.println("Ipk     :"+mahasiswa.getIpk());
    }

    @Override
    public void update(Observable o, Object arg) 
    {
        if(o == mahasiswa)
        {
            printDataMahasiswa();
        }
    }
    
    public BufferedReader getInput()
    {
        return console;
    }
    
    
}
