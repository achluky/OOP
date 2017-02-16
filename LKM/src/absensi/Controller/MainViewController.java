/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensi.Controller;

import absensi.Driver.AbsensiApp;
import absensi.Dao.AkunDao;
import absensi.Dao.Impl.AkunDaoImpl;
import absensi.Dao.Impl.LogMahasiswaDaoImpl;
import absensi.Dao.Impl.MahasiswaDaoImpl;
import absensi.Dao.LogMahasiswaDao;
import absensi.Dao.MahasiswaDao;
import absensi.model.Logmahasiswa;
import absensi.model.Mahasiswa;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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

    MahasiswaDao mahasiswaDao;
    AkunDao akunDao;
    LogMahasiswaDao logmahasiswaDao;
    
    ObservableList<Mahasiswa> dataMahasiswa;
    public MainViewController() 
    {
        mahasiswaDao =  new MahasiswaDaoImpl();
        akunDao = new AkunDaoImpl();
        logmahasiswaDao =  new LogMahasiswaDaoImpl();
        LogTV = new TableView<>();
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
    private void MasukBtn(ActionEvent event) throws IOException 
    {
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        String role = akunDao.login(username, password);
        System.out.println(role);
        if(role.equalsIgnoreCase("mahasiswa"))
        {
            Mahasiswa mahasiswa = mahasiswaDao.getDataMahasiswa(username);
            Logmahasiswa logMahasiswa = new Logmahasiswa();
            logMahasiswa.setNim(mahasiswa.getNim());
            logMahasiswa.setJamMasuk("jam");
            logMahasiswa.setTanggalMasuk("tanggal");
            logmahasiswaDao.saveLogMahasiswa(logMahasiswa);
            System.out.println("Mahasiswa Masuk");
            pemberitahuanLabel.setText("Selamat Datang : " +  mahasiswa.getNama());
            System.out.println(mahasiswa.getNama());
            loadData();
        }
        else if( role.equalsIgnoreCase("admin"))
        {
            System.out.println("Admin Masuk");
            AbsensiApp.namaAdmin = username;
            System.out.println(username);
            ((Node)(event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("/absensi/view/AdminView.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            pemberitahuanLabel.setText("Username atau password salah");
        }
    }
    
}
