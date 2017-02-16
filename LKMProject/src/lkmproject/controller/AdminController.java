/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lkmproject.DAOImpl.AkunDAOImpl;
import lkmproject.DAOImpl.DokterDAOImpl;
import lkmproject.DAOImpl.ObatDAOImpl;
import lkmproject.DAOImpl.ObatTerpilihDAOImpl;
import lkmproject.DAOImpl.PasienDAOImpl;
import lkmproject.DAOImpl.PasienDaftarDAOImpl;
import lkmproject.DAOImpl.PetugasDAOImpl;
import lkmproject.model.Akun;
import lkmproject.model.Dokter;
import lkmproject.model.Pasien;
import lkmproject.model.PasienDaftar;
import lkmproject.model.Petugas;

/**
 * FXML Controller class
 *
 * @author gracia
 */
public class AdminController implements Initializable {

    ////////////////////////tab dokter
    @FXML
    private Tab dokterTab;
    @FXML
    private TableView<Dokter> dokterTV;
    @FXML
    private TableColumn<Dokter, Integer> idDokterTC;
    @FXML
    private TableColumn<Dokter, String> namaDokterTC;
    @FXML
    private TableColumn<Dokter, String> jkDokterTC;
    @FXML
    private TableColumn<Dokter, String> alamatDokterTC;
    @FXML
    private TableColumn<Dokter, String> emailDokterTC;
    @FXML
    private TableColumn<Dokter, Integer> noTlpDokterTC;
    @FXML
    private TableColumn<Dokter, String> tugasDokterTC;
    @FXML
    private TableColumn<Dokter, String> ruangKerjaDokterTC;
    @FXML
    private TableColumn<Dokter, Double> tarifDokterTC;
    @FXML
    private TextField namaDokterTF;
    ///================tambah dokter
    @FXML
    private TextField IdDokterTF;

    @FXML
    private TextField namaTF;
    @FXML
    private TextField alamatTF;
    @FXML
    private RadioButton lakiRadioButton;
    @FXML
    private RadioButton perempuanRadioButton;

    @FXML
    private TextField emailTF;
    @FXML
    private TextField nomorTeleponTF;
    @FXML
    private TextField tugasTF;
    @FXML
    private TextField tarifTF;
    @FXML
    private TextField ruangKerjaTF;
    ///===============================================================
    //================perbaharui dokter=====================
    @FXML
    private TextField idDokterTF;
    @FXML
    private TextField perbaharuanaNamaDokterTF;
    @FXML
    private TextField alamatPerbaharuanTF;
    @FXML
    private TextField emailPerbaharuanTF;
    @FXML
    private TextField nomorTeleponPerbaharuanTF;
    @FXML
    private TextField tugasPerbaharuanTF;
    @FXML
    private TextField ruangKerjaPerbaharuanTF;
    @FXML
    private TextField tarifPerbaharuanTF;
    //========================================================
    /////////////////////////////////tab petugas//////////////////////////////////////
    @FXML
    private Tab petugasTab;

    //table petugas
    @FXML
    private TableView<Petugas> petugasTV;
    @FXML
    private TableColumn<Petugas, Integer> idPetugasTC;
    @FXML
    private TableColumn<Petugas, String> namaTC;
    @FXML
    private TableColumn<Petugas, String> alamatTC;
    @FXML
    private TableColumn<Petugas, String> jkTC;
    @FXML
    private TableColumn<Petugas, String> emailTC;
    @FXML
    private TableColumn<Petugas, Integer> nomorTeleponTC;
    //=============petugas pembaharuan
    @FXML
    private TextField idPetugasPembaharuanTF;
    //petugas pembaharuan
    @FXML
    private TextField namaPetugasPembaharuanTF;
    @FXML
    private TextField alamatPetugasPembaharuanTF;
    @FXML
    private RadioButton lakiLakiPembaharuanPetugasRB;
    @FXML
    private RadioButton perempuanPembaharuanPetugasRB;
    @FXML
    private TextField emailPetugasPembaharuanTF;
    @FXML
    private TextField nomorTeleponPetugasPembaharuanTF;
    ///=======================namaPetugas Pencarian
    @FXML
    private TextField pencarianNamaPetugasTF;

    ///tambah petugas================================================
    @FXML
    private TextField idPetugasTF;
    @FXML
    private RadioButton lakiLakiPasienTambahRB;
    @FXML
    private RadioButton PerempuanPasienTambahRB;
    @FXML
    private TextField namaPetugasTF;
    @FXML
    private TextField alamatPetugasTF;
    @FXML
    private TextField emailPetugasTF;
    @FXML
    private TextField nomorTeleponPetugasTF;
    //////////////tab pasien
    @FXML
    private Tab pasienTab; //tab pasien
    //table pasien
    @FXML
    private TableView<PasienDaftar> pasienTV;
    // tabel registrasi
    @FXML
    private TableColumn<PasienDaftar, Integer> idPasienRegistrasiTC;
    @FXML
    private TableColumn<PasienDaftar, String> namaPasienRegsitrasiTC;
    @FXML
    private TableColumn<PasienDaftar, String> alamatPasienRegistrasiTC;
    @FXML
    private TableColumn<PasienDaftar, String> jkPasienRegistasiTC;
    @FXML
    private TableColumn<PasienDaftar, String> tanggalLahirPasienRegistasiTC;
    @FXML
    private TableColumn<PasienDaftar, String> riwayatPenyakitPasienRegistrasiTC;
    //table akun
    @FXML
    private TableView<Pasien> akunPasienViewTV;
    @FXML
    private TableColumn<Pasien, Integer> idPasienTC;
    @FXML
    private TableColumn<Pasien, String> namaPasienTC;
    @FXML
    private TableColumn<Pasien, String> alamatPasienTC;
    @FXML
    private TableColumn<Pasien, String> jkPasienTC;
    @FXML
    private TableColumn<Pasien, String> tanggalLahirPasienTC;
    @FXML
    private TableColumn<Pasien, String> riwayatPenyakitPasienTC;
    @FXML
    private TextField pencarianIDPasienTF;
    @FXML
    private TextField perbaharuiDataAkunPasienTF;
    @FXML
    private TextArea perbaharuiAlamatAkunPasienTA;
    @FXML
    private TextArea perbaharuiriwayatPenyakitAkunPasienTA;
    @FXML
    private TextField pencarianNamaPasienTF;
    @FXML
    private TextField namaPasienRegistrasiTF;

    //bar chart
    @FXML
    private BarChart<String, Number> kunjunganPasienBC;
    @FXML
    private BarChart<String, Number> obatBC;

    PasienDAOImpl pasienDao = new PasienDAOImpl();
    PasienDaftarDAOImpl pasienDaftarDao = new PasienDaftarDAOImpl();
    DokterDAOImpl dokterDao = new DokterDAOImpl();
    PetugasDAOImpl petugasDao = new PetugasDAOImpl();
    AkunDAOImpl akunDao = new AkunDAOImpl();

    ObservableList<Dokter> dataDokter;
    ObservableList<Petugas> dataPetugas;
    ObservableList<PasienDaftar> dataPasienDaftar;
    ObservableList<Pasien> dataAkun;

    List<Dokter> listDokter = new ArrayList<>();
    List<Petugas> listPetugas = new ArrayList<>();
    List<PasienDaftar> listPasienDaftar = new ArrayList<>();
    List<Pasien> listAkunPasien = new ArrayList<>();
    @FXML
    private RadioButton lakiLakiPasienPerbaharuiRB;
    @FXML
    private RadioButton perempuanPasienPerbaharuiRB;
    @FXML
    private TextField tanggalLahitTF;
    
    ObatDAOImpl obatDao =  new ObatDAOImpl();
    ObatTerpilihDAOImpl obatTerpilihDao =  new ObatTerpilihDAOImpl();

    private ObservableList<XYChart.Series<String, Number>> dataChart() {
        ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList();
        XYChart.Series<String, Number> dataKategori = new XYChart.Series<>();

        dataKategori.setName("data");
        dataKategori.getData().add(new XYChart.Data<String, Number>("Telah Diterima", pasienDao.getAllPasien().size()));
        dataKategori.getData().add(new XYChart.Data<String, Number>("Belum Diterima", pasienDaftarDao.getAllPasienDaftar().size()));
        data.add(dataKategori);
        return data;
    }
    
    private ObservableList<XYChart.Series<String, Number>> dataObatChart()
    {
        
        ObservableList<XYChart.Series<String, Number>> dataStatistikObat = FXCollections.observableArrayList();
        XYChart.Series<String, Number> dataStatistikObatChart =  new XYChart.Series<>();
        
        dataStatistikObatChart.setName("data");
        dataStatistikObatChart.getData().add(new XYChart.Data<String, Number>("Jumlah Obat", obatDao.getAllObat().size()));
        dataStatistikObatChart.getData().add(new XYChart.Data<String, Number>("Jumlah Obat Keluar", obatTerpilihDao.getAllObatTerpilih().size()));
        dataStatistikObat.add(dataStatistikObatChart);
        return dataStatistikObat;
    }

    public AdminController() {
        dokterTV = new TableView();
        petugasTV = new TableView();
        pasienTV = new TableView();
        akunPasienViewTV = new TableView();
    }

    public void loadTablePasienDaftar() {
        
        listPasienDaftar = pasienDaftarDao.getAllPasienDaftar();
        dataPasienDaftar = FXCollections.observableArrayList(listPasienDaftar);
        idPasienRegistrasiTC.setCellValueFactory(new PropertyValueFactory<>("idPasien"));
        namaPasienRegsitrasiTC.setCellValueFactory(new PropertyValueFactory<>("nama"));
        alamatPasienRegistrasiTC.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        jkPasienRegistasiTC.setCellValueFactory(new PropertyValueFactory<>("jenisKelamin"));
        tanggalLahirPasienRegistasiTC.setCellValueFactory(new PropertyValueFactory<>("tanggalLahirPasien"));
        riwayatPenyakitPasienRegistrasiTC.setCellValueFactory(new PropertyValueFactory<>("riwayatPenyakit"));
        pasienTV.setItems(dataPasienDaftar);
    }

    public void loadTableDokter() {
        listDokter = dokterDao.getAllDokter();
        dataDokter = FXCollections.observableArrayList(listDokter);
        idDokterTC.setCellValueFactory(new PropertyValueFactory<>("idDokter"));
        namaDokterTC.setCellValueFactory(new PropertyValueFactory<>("nama"));
        jkDokterTC.setCellValueFactory(new PropertyValueFactory<>("jenisKelamin"));
        alamatDokterTC.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        emailDokterTC.setCellValueFactory(new PropertyValueFactory<>("email"));
        noTlpDokterTC.setCellValueFactory(new PropertyValueFactory<>("noTelp"));
        tugasDokterTC.setCellValueFactory(new PropertyValueFactory<>("tugas"));
        ruangKerjaDokterTC.setCellValueFactory(new PropertyValueFactory<>("ruangKerja"));
        tarifDokterTC.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        dokterTV.setItems(dataDokter);

    }

    public void loadTablePetugas() {
        listPetugas = petugasDao.getAllPetugas();
        dataPetugas = FXCollections.observableArrayList(listPetugas);
        idPetugasTC.setCellValueFactory(new PropertyValueFactory<Petugas, Integer>("idPetugas"));
        namaTC.setCellValueFactory(new PropertyValueFactory<Petugas, String>("nama"));
        alamatTC.setCellValueFactory(new PropertyValueFactory<Petugas, String>("alamat"));
        jkTC.setCellValueFactory(new PropertyValueFactory<Petugas, String>("jenisKelamin"));
        emailTC.setCellValueFactory(new PropertyValueFactory<Petugas, String>("emailPetugas"));
        nomorTeleponTC.setCellValueFactory(new PropertyValueFactory<Petugas, Integer>("nomorTelepon"));
        petugasTV.setItems(dataPetugas);
    }

    public void loadTablePasien() {
        listAkunPasien = pasienDao.getAllPasien();
        dataAkun = FXCollections.observableArrayList(listAkunPasien);
        idPasienTC.setCellValueFactory(new PropertyValueFactory<Pasien, Integer>("idPasien"));
        namaPasienTC.setCellValueFactory(new PropertyValueFactory<Pasien, String>("nama"));
        alamatPasienTC.setCellValueFactory(new PropertyValueFactory<Pasien, String>("alamat"));
        jkPasienTC.setCellValueFactory(new PropertyValueFactory<Pasien, String>("jenisKelamin"));
        tanggalLahirPasienTC.setCellValueFactory(new PropertyValueFactory<Pasien, String>("tanggalLahirPasien"));
        riwayatPenyakitPasienTC.setCellValueFactory(new PropertyValueFactory<Pasien, String>("riwayatPenyakit"));
        akunPasienViewTV.setItems(dataAkun);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTableDokter();
        loadTablePetugas();
        loadTablePasien();
        loadTablePasienDaftar();
        kunjunganPasienBC.setData(dataChart());
        obatBC.setData(dataObatChart());
        
    }

    ////////////////////////////dokter
//==========================================hapus dan cari dokter
    @FXML
    private void cariDokterBtn(ActionEvent event) {
        String namaDokter = namaDokterTF.getText();
        listDokter.clear();
        listDokter = dokterDao.getAllDokter();
        int flag=0;
        for (Dokter dokter : listDokter) {
            if (dokter.getNama().equalsIgnoreCase(namaDokter)) {
                dokterTV.scrollTo(dokter);
                namaDokterTF.setText("Dokter ditemukan");
                flag=1;
            }
        }
        if(flag==0)
        {
            namaDokterTF.setText("Dokter tidak Ditemukan");
        }
    }

    @FXML
    private void hapusDokterBtn(ActionEvent event) {
        String namaDokter = namaDokterTF.getText();
        int flag=0;
        for (Dokter dokter : listDokter) {
            if (dokter.getNama().equalsIgnoreCase(namaDokter)) {
                listDokter.remove(dokter);
                dokterDao.delete(dokter.getIdDokter());
                loadTableDokter();
                flag=1;
            }
        }
        if(flag==0)
        {
            namaDokterTF.setText("Dokter tidak Ditemukan");
        }
    }
    //===================================================================

    @FXML
    private void daftarBtn(ActionEvent event) {
        Dokter dokter = new Dokter();
        dokter.setIdDokter(Integer.parseInt(IdDokterTF.getText()));
        dokter.setNama(namaTF.getText());
        if (lakiRadioButton.isSelected()) {
            dokter.setJenisKelamin("L");
        } else if (perempuanRadioButton.isSelected()) {
            dokter.setJenisKelamin("P");
        }
        dokter.setAlamat(alamatTF.getText());
        dokter.setEmail(emailTF.getText());
        dokter.setNoTelp(Integer.parseInt(nomorTeleponTF.getText()));
        dokter.setTugas(tugasTF.getText());
        dokter.setTarif(Double.parseDouble(tarifTF.getText()));
        dokter.setRuangKerja(ruangKerjaTF.getText());
        dokterDao.save(dokter);
        loadTableDokter();
    }

    @FXML
    private void cariDokterPerbaharui(ActionEvent event)
    {
        String idDokterPerbaharui = idDokterTF.getText();
        Dokter dokter = dokterDao.getDataDokter(Integer.parseInt(idDokterPerbaharui));
        perbaharuanaNamaDokterTF.setText(dokter.getNama());
        alamatPerbaharuanTF.setText(dokter.getAlamat());
        emailPerbaharuanTF.setText(dokter.getEmail());
        nomorTeleponPerbaharuanTF.setText(String.valueOf(dokter.getNoTelp()));
        tugasPerbaharuanTF.setText(dokter.getTugas());
        ruangKerjaPerbaharuanTF.setText(dokter.getRuangKerja());
        tarifPerbaharuanTF.setText(String.valueOf(dokter.getTarif()));
        dokterDao.edit(dokter);
    }

    @FXML
    private void perbaharuiBtn(ActionEvent event) {
        Dokter dokter = new Dokter();
        dokter.setIdDokter(Integer.parseInt(IdDokterTF.getText()));
        dokter.setNama(perbaharuanaNamaDokterTF.getText());
        dokter.setAlamat(alamatPerbaharuanTF.getText());
        dokter.setEmail(emailPerbaharuanTF.getText());
        dokter.setNoTelp(Integer.parseInt(nomorTeleponPerbaharuanTF.getText()));
        dokter.setTugas(tugasPerbaharuanTF.getText());
        dokter.setRuangKerja(ruangKerjaPerbaharuanTF.getText());
        dokter.setTarif(Double.parseDouble(tarifPerbaharuanTF.getText()));
        dokterDao.edit(dokter);
        loadTableDokter();
    }

    //////////////////////////petugas
    @FXML
    private void cariBtn(ActionEvent event) 
    {
        int flag =0;
        String namaPetugas = pencarianNamaPetugasTF.getText();
        for (Petugas petugasTemp : listPetugas) {
            if (namaPetugas.equalsIgnoreCase(petugasTemp.getNama())) {
                petugasTV.scrollTo(petugasTemp);
                pencarianNamaPetugasTF.setText("petugas ditemukan");
                flag=1;
            }
        }
        if(flag==0)
        {
            pencarianNamaPetugasTF.setText("petugas tidak ada");
        }
    }

    @FXML
    private void hapusBtn(ActionEvent event) 
    {
        int flag =0;
        String namaPetugas = pencarianNamaPetugasTF.getText();
        for (Petugas petugasTemp : listPetugas) {
            if (namaPetugas.equalsIgnoreCase(petugasTemp.getNama())) {
                listPetugas.remove(petugasTemp);
                petugasDao.delete(petugasTemp.getIdPetugas());
                loadTablePetugas();
                flag=1;
            }
        }
        if(flag==0)
        {
            pencarianNamaPetugasTF.setText("petugas tidak ada");
        }
    }

    @FXML
    private void daftarPetugasBtn(ActionEvent event) 
    {
        Petugas petugas = new Petugas();
        petugas.setIdPetugas(Integer.parseInt(idPetugasTF.getText()));
        if (lakiLakiPasienTambahRB.isSelected()) {
            petugas.setJenisKelamin("L");
        } else if (PerempuanPasienTambahRB.isSelected()) {
            petugas.setJenisKelamin("p");
        }
        petugas.setNama(namaPetugasTF.getText());
        petugas.setAlamat(alamatPetugasTF.getText());
        petugas.setEmailPetugas(emailPetugasTF.getText());
        petugas.setNomorTelepon(Integer.parseInt(nomorTeleponPetugasTF.getText()));
        petugasDao.save(petugas);
        loadTablePetugas();
    }

    @FXML
    private void perbaharuiPetugasBtn(ActionEvent event) 
    {
        Petugas petugas = new Petugas();
        petugas.setIdPetugas(Integer.parseInt(idPetugasPembaharuanTF.getText()));
        petugas.setNama(namaPetugasPembaharuanTF.getText());
        petugas.setAlamat(alamatPetugasPembaharuanTF.getText());
        if (lakiLakiPembaharuanPetugasRB.isSelected()) {
            petugas.setJenisKelamin("L");
        } else if (perempuanPembaharuanPetugasRB.isSelected()) {
            petugas.setJenisKelamin("P");
        }
        petugas.setEmailPetugas(emailPetugasPembaharuanTF.getText());
        petugas.setNomorTelepon(Integer.parseInt(nomorTeleponPetugasPembaharuanTF.getText()));
        petugasDao.edit(petugas);
        loadTablePetugas();
    }
/////////////////////////////////////pasien
/////================================pasien tetap

    @FXML
    private void hapusAkunPasienBtn(ActionEvent event) {
        int flag = 0;
        if (!pencarianIDPasienTF.getText().isEmpty()) {
            flag = 1;
            pasienDao.delete(Integer.parseInt(pencarianIDPasienTF.getText()));
        }
        else if (!pencarianNamaPasienTF.getText().isEmpty()) {
            String namaPasien = pencarianNamaPasienTF.getText();
            List<Pasien> listPasienTemp = pasienDao.getAllPasien();
            for (Pasien pasien : listPasienTemp) {
                if (pasien.getNama().equalsIgnoreCase(namaPasien)) {
                    pasienDao.delete(pasien.getIdPasien());
                    loadTablePasien();
                }
            }
        } else {
            pencarianIDPasienTF.setStyle("-fx-background-color: red;");
            pencarianNamaPasienTF.setStyle("-fx-background-color: red;");
        }
    }

    @FXML
    private void perbaharuiDataBtn(ActionEvent event) 
    {
        if (!pencarianIDPasienTF.getText().isEmpty())
        {
            pencarianIDPasienTF.setStyle("-fx-background-color: white;");
            pencarianNamaPasienTF.setStyle("-fx-background-color: white;");
            Pasien pasien = pasienDao.getDataPasien(Integer.parseInt(pencarianIDPasienTF.getText()));
            perbaharuiDataAkunPasienTF.setText(pasien.getNama());
            if (pasien.getJenisKelamin().equalsIgnoreCase("L")) {
                lakiLakiPasienPerbaharuiRB.setSelected(true);
                perempuanPasienPerbaharuiRB.setSelected(false);
            } else {
                lakiLakiPasienPerbaharuiRB.setSelected(false);
                perempuanPasienPerbaharuiRB.setSelected(true);
            }
            tanggalLahitTF.setText(pasien.getTanggalLahir());
            perbaharuiAlamatAkunPasienTA.setText(pasien.getAlamat());
            perbaharuiriwayatPenyakitAkunPasienTA.setText(pasien.getRiwayatPenyakit());
            tanggalLahitTF.setText(pasien.getTanggalLahir());
        }
        else if (!pencarianNamaPasienTF.getText().isEmpty())
        {
            pencarianIDPasienTF.setStyle("-fx-background-color: white;");
            pencarianNamaPasienTF.setStyle("-fx-background-color: white;");
            System.out.println("Masuk gan");
            String namaPasien = pencarianNamaPasienTF.getText();
            List<Pasien> listPasienTemp = pasienDao.getAllPasien();
            for (Pasien pasien : listPasienTemp) {
                if (pasien.getNama().equalsIgnoreCase(namaPasien)) {
                    perbaharuiDataAkunPasienTF.setText(pasien.getNama());
                    if (pasien.getJenisKelamin().equalsIgnoreCase("L")) {
                        lakiLakiPasienPerbaharuiRB.setSelected(true);
                        perempuanPasienPerbaharuiRB.setSelected(false);
                    } else {
                        lakiLakiPasienPerbaharuiRB.setSelected(false);
                        perempuanPasienPerbaharuiRB.setSelected(true);
                    }
                    tanggalLahitTF.setText(pasien.getTanggalLahir());
                    perbaharuiAlamatAkunPasienTA.setText(pasien.getAlamat());
                    perbaharuiriwayatPenyakitAkunPasienTA.setText(pasien.getRiwayatPenyakit());
                }
            }
        }
        else {
            pencarianIDPasienTF.setStyle("-fx-background-color: red;");
            pencarianNamaPasienTF.setStyle("-fx-background-color: red;");
        }
    }

    @FXML
    private void perbahariuBtn(ActionEvent event) 
    {
        Pasien pasienTemp = new Pasien();
        List<Pasien> listPasienTemp = pasienDao.getAllPasien();
        for (Pasien pasien : listPasienTemp) {
            if (pasien.getNama().equalsIgnoreCase(perbaharuiDataAkunPasienTF.getText())) {
                pasienTemp.setIdPasien(pasien.getIdPasien());
            }
        }
        if (lakiLakiPasienPerbaharuiRB.isSelected()) {
            pasienTemp.setJenisKelamin("L");
        } else {
            pasienTemp.setJenisKelamin("P");
        }
        pasienTemp.setTanggalLahir(tanggalLahitTF.getText());
        pasienTemp.setNama(perbaharuiDataAkunPasienTF.getText());
        pasienTemp.setAlamat(perbaharuiAlamatAkunPasienTA.getText());
        pasienTemp.setRiwayatPenyakit(perbaharuiriwayatPenyakitAkunPasienTA.getText());
        
        pasienDao.edit(pasienTemp);
        loadTablePasien();
    }
//===================================daftar akun yang menunggu dikonfirmasi admin

    @FXML
    private void tolakRegistrasiPasienFromSearchBtn(ActionEvent event) 
    {
        String namaPasienDaftar = namaPasienRegistrasiTF.getText();
        List<PasienDaftar> listPasienDaftarTemp = pasienDaftarDao.getAllPasienDaftar();
        int flag = 0;
        for (PasienDaftar pasienDaftar : listPasienDaftarTemp) {
            if (pasienDaftar.getNama().equalsIgnoreCase(namaPasienDaftar)) {
                pasienDaftarDao.delete(pasienDaftar.getIdPasien());
                loadTablePasien();
                loadTablePasienDaftar();
                flag = 1;
            }
        }
        if (flag == 0) {
            {
                namaPasienRegistrasiTF.setText("Pasien tidak ada");
            }
        }
    }

    @FXML
    private void terimaRegistrasiPasienFromSearchBtn(ActionEvent event) {
        String namaPasienDaftar = namaPasienRegistrasiTF.getText();
        List<PasienDaftar> listPasienDaftarTemp = pasienDaftarDao.getAllPasienDaftar();
        int flag = 0;
        for (PasienDaftar pasienDaftar : listPasienDaftarTemp) {
            if (pasienDaftar.getNama().equalsIgnoreCase(namaPasienDaftar)) {
                Pasien pasien = new Pasien();
                pasien.setIdPasien(pasienDaftar.getIdPasien());
                pasien.setNama(pasienDaftar.getNama());
                pasien.setAlamat(pasienDaftar.getAlamat());
                pasien.setJenisKelamin(pasienDaftar.getJenisKelamin());
                pasien.setTanggalLahir(pasienDaftar.getTanggalLahir());
                pasien.setRiwayatPenyakit(pasienDaftar.getRiwayatPenyakit());
                pasienDao.save(pasien);
                pasienDaftarDao.delete(pasienDaftar.getIdPasien());
                loadTablePasienDaftar();
                loadTablePasien();
                Akun akun = new Akun();
                akun.setGolongan("pasien");
                akun.setIdPengguna(pasienDaftar.getIdPasien());
                akun.setPasswordPengguna(pasienDaftar.getPassword());
                akunDao.saveAkun(akun);
                flag = 1;
            }
        }
        if (flag == 0) {
            {
                namaPasienRegistrasiTF.setText("Pasien tidak ada");
            }
        }
    }

    @FXML
    private void tolakRegistrasiBtn(ActionEvent event) {
        PasienDaftar pasienDaftar = pasienTV.getSelectionModel().getSelectedItem();
        pasienDaftarDao.delete(pasienDaftar.getIdPasien());
        loadTablePasienDaftar();
        loadTablePasien();
    }

    @FXML
    private void terimaRegistrasiPasienBtn(ActionEvent event) {
        PasienDaftar pasienDaftar = pasienTV.getSelectionModel().getSelectedItem();
        Pasien pasien = new Pasien();
        pasien.setIdPasien(pasienDaftar.getIdPasien());
        pasien.setNama(pasienDaftar.getNama());
        pasien.setAlamat(pasienDaftar.getAlamat());
        pasien.setJenisKelamin(pasienDaftar.getJenisKelamin());
        pasien.setTanggalLahir(pasienDaftar.getTanggalLahir());
        pasien.setRiwayatPenyakit(pasienDaftar.getRiwayatPenyakit());
        pasienDao.save(pasien);
        pasienDaftarDao.delete(pasienDaftar.getIdPasien());
        Akun akun = new Akun();
        akun.setGolongan("pasien");
        akun.setIdPengguna(pasien.getIdPasien());
        akun.setPasswordPengguna(pasienDaftar.getPassword());
        akunDao.saveAkun(akun);
        System.out.println(pasienDaftar.getPassword());
        loadTablePasienDaftar();
        loadTablePasien();
    }

    @FXML
    private void gotoLoginPage(ActionEvent event) {
        System.out.println("registrasi");
        ((Node) event.getSource()).getScene().getWindow().hide();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lkmproject/view/LoginView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Registrasi");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException io) {

        }
    }

    @FXML
    private void gotoRegistrationPage(ActionEvent event) {
        System.out.println("registrasi");
        ((Node) event.getSource()).getScene().getWindow().hide();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lkmproject/view/RegistrasiView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Registrasi");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException io) {

        }
    }

    @FXML
    private void closeApp(ActionEvent event) 
    {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void cariUntukDiperbaharuiButton(ActionEvent event) 
    {
        Petugas petugas = petugasDao.getDataPetugas(Integer.parseInt(idPetugasPembaharuanTF.getText()));
        namaPetugasPembaharuanTF.setText(petugas.getNama());
        alamatPetugasPembaharuanTF.setText(petugas.getAlamat());
        if (perempuanPembaharuanPetugasRB.isSelected()) {
            petugas.setJenisKelamin("P");
        } else {
            petugas.setJenisKelamin("L");
        }
        emailPetugasPembaharuanTF.setText(petugas.getEmailPetugas());
        nomorTeleponPetugasPembaharuanTF.setText(String.valueOf(petugas.getNomorTelepon()));
    }
}
