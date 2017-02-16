/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mahasiswa.controller;

import java.io.IOException;
import java.util.List;
import org.mahasiswa.model.Mahasiswa;
import org.mahasiswa.view.MahasiswaView;

/**
 *
 * @author Jayuk
 */
public class MahasiswaController 
{
    Mahasiswa model;
    MahasiswaView view;

    public MahasiswaController(Mahasiswa model, MahasiswaView view) {
        this.model = model;
        this.view = view;
        model.addObserver(view);
    }
    
    public void setMatakuliah(List<String> listMataKuliah)
    {
        model.setMataKuliah(listMataKuliah);
    }
    public void setNilai(List<Double> listNilai)
    {
        model.setNilai(listNilai);
    }
    
    public void setNim() throws IOException
    {
        model.setNim(view.getInput().readLine());
    }
    public void setNama() throws IOException
    {
        model.setNama(view.getInput().readLine());
    }
}
