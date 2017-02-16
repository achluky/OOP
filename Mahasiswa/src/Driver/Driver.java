/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.io.IOException;
import java.util.List;
import org.mahasiswa.controller.MahasiswaController;
import org.mahasiswa.model.Mahasiswa;
import org.mahasiswa.view.MahasiswaView;

/**
 *
 * @author Jayuk
 */
public class Driver 
{
    
    public static void main(String[] args) throws IOException 
    {
        List<String> listMatakuliah = null;
        listMatakuliah.add("pbo");
        listMatakuliah.add("oak");
        listMatakuliah.add("sisop");
        List<Double> listNilai =null;
        listNilai.add(3.0);
        listNilai.add(4.0);
        listNilai.add(3.9);
        Mahasiswa model = new Mahasiswa();
        MahasiswaView view = new MahasiswaView(model);
        MahasiswaController MahasiswaController = new MahasiswaController(model, view);
        MahasiswaController.setMatakuliah(listMatakuliah);
        MahasiswaController.setNilai(listNilai);
        
        MahasiswaController.setNama();
        MahasiswaController.setNama();
    }
}
