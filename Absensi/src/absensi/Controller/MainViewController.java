/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensi.Controller;

import absensi.Absensi;
import absensi.Dao.AkunDao;
import absensi.Dao.Impl.AkunDaoImpl;
import absensi.Dao.Impl.LogMahasiswaDaoImpl;
import absensi.Dao.Impl.MahasiswaDaoImpl;
import absensi.Dao.LogMahasiswaDao;
import absensi.Dao.MahasiswaDao;
import absensi.model.Logmahasiswa;
import absensi.model.Mahasiswa;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Jayuk
 */
public class MainViewController implements Initializable {

    @FXML
    private TableView<Mahasiswa> LogTV;
    @FXML
    private TableColumn<Mahasiswa, String> nimTC;
    @FXML
    private TableColumn<Mahasiswa, String> namaTC;
    @FXML
    private TableColumn<Mahasiswa, String> jenisKelaiminTC;
    @FXML
    private TableColumn<Mahasiswa, String> kelasTC;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField usernameTF;
    @FXML
    private Label pemberitahuanLabel;

    MahasiswaDao mahasiswaDao =  new MahasiswaDaoImpl();
    AkunDao akunDao = new AkunDaoImpl();
    LogMahasiswaDao logmahasiswaDao =  new LogMahasiswaDaoImpl();
    
    ObservableList<Mahasiswa> dataMahasiswa;
    public MainViewController() 
    {
        
    }
    
    private void loadData()
    {
        List<Logmahasiswa> listLogMahasiswa = logmahasiswaDao.getAllLogMahasiswa();
        List<Mahasiswa> listMahasiswa = mahasiswaDao.getAllMahasiswa();
        List<Mahasiswa> listMahasiswaTemp = new ArrayList<>();
        for(Logmahasiswa logMahasiswa : listLogMahasiswa)
        {
            for(Mahasiswa mahasiswa : listMahasiswa)
            {
                if(logMahasiswa.getNim().equalsIgnoreCase(mahasiswa.getNim()))
                {
                    listMahasiswaTemp.add(mahasiswa);
                }
            }
        }
        dataMahasiswa = FXCollections.observableList(listMahasiswaTemp);
        nimTC.setCellValueFactory(new PropertyValueFactory<>("nim"));
        namaTC.setCellValueFactory(new PropertyValueFactory<>("nama"));
        jenisKelaiminTC.setCellValueFactory(new PropertyValueFactory<>("jenisKelamin"));
        kelasTC.setCellValueFactory(new PropertyValueFactory<>("kelas"));
        LogTV.setItems(dataMahasiswa);
    }

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        loadData();
    }    

    @FXML
    private void MasukBtn(ActionEvent event) 
    {
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        String role = akunDao.login(username, password);
        if(role.equalsIgnoreCase("mahasiswa"))
        {
            String nama = mahasiswaDao.getDataMahasiswa(username).getNama();
            System.out.println("Mahasiswa Masuk");
            pemberitahuanLabel.setText("Selamat Datang : " + nama);
            System.out.println(nama);
        }
        else if( role.equalsIgnoreCase("admin"))
        {
            System.out.println("Admin Masuk");
            Absensi.namaAdmin = username;
            System.out.println(username);
        }
        else
        {
            pemberitahuanLabel.setText("Username atau password salah");
        }
        loadData();
    }
    
}
