/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensi.Controller;

import absensi.Dao.Impl.MahasiswaDaoImpl;
import absensi.Dao.MahasiswaDao;
import absensi.model.Mahasiswa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jayuk
 */
public class AdminViewController implements Initializable {

    @FXML
    private TextField nimPerbaharuiTF;
    @FXML
    private TextField namaPerbaharuiTF;
    @FXML
    private TextField jenisKelaminPerbaharuiTF;
    @FXML
    private TextField kelasPerbaharuiTF;
    @FXML
    private TextField nimTambahTF;
    @FXML
    private TextField namaTambahTF;
    @FXML
    private TextField jenisKelaminTambahTF;
    @FXML
    private TextField kelasTambahTF;
    @FXML
    private Label namaAdminLabel;
    
    MahasiswaDao mahasiswaDao = new MahasiswaDaoImpl();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void perbaharuiMahaiswaBtn(ActionEvent event) 
    {
        String nim = nimPerbaharuiTF.getText();
        Mahasiswa mahasiswa = mahasiswaDao.getDataMahasiswa(nim);
        mahasiswa.setNama(namaPerbaharuiTF.getText());
        mahasiswa.setJenisKelamin(jenisKelaminPerbaharuiTF.getText());
        mahasiswa.setKelas(kelasPerbaharuiTF.getText());
        mahasiswaDao.updateDataMahasiswa(mahasiswa);
        System.out.println("Mahasiswa Diperbaharui");
    }

    @FXML
    private void tambahMahaiswaBtn(ActionEvent event) 
    {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setJenisKelamin(jenisKelaminTambahTF.getText());
        mahasiswa.setNim(nimTambahTF.getText());
        mahasiswa.setNama(namaTambahTF.getText());
        mahasiswa.setKelas(kelasTambahTF.getText());
        mahasiswaDao.saveDataMahasiswa(mahasiswa);
        System.out.println("Mahasiswa ditambahkan");
    }

    @FXML
    private void hapusMahaiswaBtn(ActionEvent event) 
    {
        String nim = nimPerbaharuiTF.getText();
        Mahasiswa mahasiswa = mahasiswaDao.getDataMahasiswa(nim);
        mahasiswaDao.deleteMahasiswa(mahasiswa);
    }

    @FXML
    private void cariButton(ActionEvent event) 
    {
        String nim = nimPerbaharuiTF.getText();
        Mahasiswa mahasiswa = mahasiswaDao.getDataMahasiswa(nim);
        namaPerbaharuiTF.setText(mahasiswa.getNama());
        jenisKelaminPerbaharuiTF.setText(mahasiswa.getJenisKelamin());
        kelasPerbaharuiTF.setText(mahasiswa.getKelas());
    }
    
}
