/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nauli.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import org.nauli.dao.PembayaranDao;
import org.nauli.dao.PemesananDao;
import org.nauli.dao.impl.PembayaranDaoImplHibernate;
import org.nauli.dao.impl.PemesananDaoImplHibernate;
import org.nauli.model.Pembayaran;
import org.nauli.model.Pemesanan;

/**
 *
 * @author Jayuk
 */
public class UtamaController implements Initializable {

    @FXML
    private TableView<Pemesanan> TabelPemesanan;
    @FXML
    private TableColumn<Pemesanan, Integer> idPemesanan;
    @FXML
    private TableColumn<Pemesanan, String> nama;
    @FXML
    private TableColumn<Pemesanan, String> tujuanPemesanan;
    @FXML
    private TableColumn<Pemesanan, Integer> jumlah;
    @FXML
    private TableColumn<Pemesanan, Integer> totalPemesanan;
    ObservableList<Pemesanan> dataPesanan;
    private PemesananDao pesananDao;

    @FXML
    private TableView<Pembayaran> TabelPembayaran;
    @FXML
    private TableColumn<Pembayaran, Integer> idPembayaran;
    @FXML
    private TableColumn<Pembayaran, Integer> totalPembayaran;
    @FXML
    private TableColumn<Pembayaran, String> tujuanPembayaran;
    @FXML
    ObservableList<Pembayaran> dataPembayaran;
    private PembayaranDao pembayaranDao;
     @FXML
    private BarChart<String, Number> bar;
    @FXML
    private TextField namaTF;
    @FXML
    private RadioButton radioSidikalang;
    @FXML
    private ToggleGroup tujuan;
    @FXML
    private RadioButton radioSibolga;
    @FXML
    private RadioButton radioMedan;
    @FXML
    private RadioButton radioKabanjahe;
    @FXML
    private RadioButton radioSiantar;
    @FXML
    private TextField jlhPenumpangTF;
    @FXML
    private TextField IdTF;
    @FXML
    private TextField pembayaranTF;
    @FXML
    private Label labelPemberitahuan;

    public UtamaController() {
        pesananDao = new PemesananDaoImplHibernate();
        TabelPemesanan = new TableView<>();
        pembayaranDao = new PembayaranDaoImplHibernate();
        TabelPembayaran = new TableView<>();
    }
    private ObservableList<XYChart.Series<String, Number>> getData() {
        ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList();
        XYChart.Series<String, Number> sudahDiBayar = new XYChart.Series<>();
        XYChart.Series<String, Number> belumDiBayar = new XYChart.Series<>();
        
        sudahDiBayar.setName("Telah Dibayarkan");
        belumDiBayar.setName("Belum Dibayarkan");
        
        sudahDiBayar.getData().add(new XYChart.Data<>("Medan", pembayaranDao.getTotalPembayaran(2)));        
        sudahDiBayar.getData().add(new XYChart.Data<>("Sidikalang", pembayaranDao.getTotalPembayaran(1)));
        sudahDiBayar.getData().add(new XYChart.Data<>("Sibolga", pembayaranDao.getTotalPembayaran(3)));
        sudahDiBayar.getData().add(new XYChart.Data<>("Pematang Siantar", pembayaranDao.getTotalPembayaran(4)));
        sudahDiBayar.getData().add(new XYChart.Data<>("Kabanjahe", pembayaranDao.getTotalPembayaran(5)));
        
        belumDiBayar.getData().add(new XYChart.Data<>("Medan", pesananDao.getTotalPemesanan("Medan")));        
        belumDiBayar.getData().add(new XYChart.Data<>("Sidikalang", pesananDao.getTotalPemesanan("Sidikalang")));
        belumDiBayar.getData().add(new XYChart.Data<>("Sibolga", pesananDao.getTotalPemesanan("Sibolga")));
        belumDiBayar.getData().add(new XYChart.Data<>("Pematang Siantar", pesananDao.getTotalPemesanan("Pematang Siantar")));
        belumDiBayar.getData().add(new XYChart.Data<>("Kabanjahe", pesananDao.getTotalPemesanan("Kabanjahe")));

        data.addAll(sudahDiBayar,belumDiBayar);
        return data;
    }
    public void loadData() {
        List<Pemesanan> pesanans = pesananDao.getAllPemesanan();
        dataPesanan = FXCollections.observableArrayList(pesanans);
        idPemesanan.setCellValueFactory(new PropertyValueFactory<>("id"));
        nama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        tujuanPemesanan.setCellValueFactory(new PropertyValueFactory<>("tujuan"));
        jumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        totalPemesanan.setCellValueFactory(new PropertyValueFactory<>("totalPemesanan"));
        TabelPemesanan.setItems(dataPesanan);

        List<Pembayaran> pembayarans = pembayaranDao.getAllPembayaran();
        dataPembayaran = FXCollections.observableArrayList(pembayarans);
        idPembayaran.setCellValueFactory(new PropertyValueFactory<>("id"));
        totalPembayaran.setCellValueFactory(new PropertyValueFactory<>("totalPembayaran"));
        tujuanPembayaran.setCellValueFactory(new PropertyValueFactory<>("tujuan"));
        TabelPembayaran.setItems(dataPembayaran);

    }

    private void inisialAwalInputan() {
        namaTF.setText("");
        jlhPenumpangTF.setText("");
        IdTF.setText("");
        pembayaranTF.setText("");
        radioKabanjahe.setSelected(false);
        radioMedan.setSelected(false);
        radioSiantar.setSelected(false);
        radioSibolga.setSelected(false);
        radioSidikalang.setSelected(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        inisialAwalInputan();
        bar.setData(getData());
    }

    @FXML
    private void pesan(ActionEvent event) {
        String nama = namaTF.getText();
        String tujuan = new String();
        int jumlah = Integer.parseInt(jlhPenumpangTF.getText());
        int totalPemesanan = 0;
        if (radioKabanjahe.isSelected()) {
            tujuan = "Kabanjahe";
            totalPemesanan = jumlah * 20000;
        } else if (radioMedan.isSelected()) {
            tujuan = "Medan";
            totalPemesanan = jumlah * 16000;
        } else if (radioSiantar.isSelected()) {
            tujuan = "Pematang Siantar";
            totalPemesanan = jumlah * 66000;
        } else if (radioSibolga.isSelected()) {
            tujuan = "Sibolga";
            totalPemesanan = jumlah * (1000+10000);
        } else if (radioSidikalang.isSelected()) {
            tujuan = "Sidikalang";
            totalPemesanan = jumlah *  (20000+4500);
        }
        Pemesanan pemesanan = new Pemesanan(nama, tujuan, jumlah, totalPemesanan);
        pesananDao.saveDataPesanan(pemesanan);
        loadData();
        inisialAwalInputan();
        bar.setData(getData());

    }

    @FXML
    private void konfirmasi(ActionEvent event) {
        int bayar = Integer.parseInt(pembayaranTF.getText());
        int id = Integer.parseInt(IdTF.getText());
        int totalBayar = pembayaranDao.getTotalPemesanan(id);
        if (bayar < totalBayar) {
            labelPemberitahuan.setVisible(true);
        } else {
            pembayaranDao.konfirmasi(pesananDao.getTujuanPesanan(id), id);
            pesananDao.deletePemesanan(id);
            labelPemberitahuan.setVisible(false);
        }

        loadData();
        inisialAwalInputan();
        bar.setData(getData());
    }

}
