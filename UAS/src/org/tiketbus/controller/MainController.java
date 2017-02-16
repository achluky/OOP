/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tiketbus.controller;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import org.tiketbus.dao.impl.PenumpangDaoImpl;
import org.tiketbus.model.Penumpang;

/**
 * FXML Controller class
 *
 * @author Jayuk
 */
public class MainController implements Initializable 
{
    @FXML 
    private TableView<Penumpang> penumpangPemesananTB;
    @FXML
    private TableColumn<Penumpang, Integer> columnIdPemesanan;
    @FXML
    private TableColumn<Penumpang, String> columnNamaPemesanan;
    @FXML
    private TableColumn<Penumpang, String> columnTujuanPemesanan;
    @FXML
    private TableColumn<Penumpang,Integer > columnJumlahPemesanan;
    @FXML
    private TableColumn<Penumpang, Double> columnTotalPembayaranPemesanan;
    @FXML
    private TableView<Penumpang> penumpangPembayaranTB;
    @FXML
    private TableColumn<Penumpang, Integer> columnIdPembayaran;
    @FXML
    private TableColumn<Penumpang, Double> columnTotalPembayaran;
    @FXML
    private TableColumn<Penumpang, String> columnTujuanPembayaran;
    @FXML
    private TextField textNamaPemesanan;
    @FXML
    private TextField textJumlahPenumpangPemesanan;
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
    private RadioButton radioSiantar;;
    @FXML
    private TextField textIdPembayaran;
    @FXML
    private TextField textPembayaran;

    ObservableList<Penumpang> dataBelumBayar;
    ObservableList<Penumpang> dataSudahBayar;
    private PenumpangDaoImpl penumpangDao;
    @FXML
    private BarChart<String,Number> bar;
    public MainController()
    {
        penumpangDao = new PenumpangDaoImpl();
        penumpangPemesananTB = new TableView<>();
        penumpangPembayaranTB = new TableView<>();
    }
    
    public void loadData()
    {
        List<Penumpang> listPenumpang = penumpangDao.getAllPenumpang();
        List<Penumpang> listPenumpangSudahBayar = new ArrayList<>();
        List<Penumpang> listPenumpangBelumBayar = new ArrayList<>();
        for (Penumpang  p : listPenumpang)     
        {
            System.out.println("nama :" + p.getNama());
            if(p.getSudahBayar()==0)
                listPenumpangBelumBayar.add(p);
            else
                listPenumpangSudahBayar.add(p);
        }
            dataBelumBayar = FXCollections.observableArrayList(listPenumpangBelumBayar);
            columnIdPemesanan.setCellValueFactory(new PropertyValueFactory<Penumpang, Integer>("Id"));
            columnNamaPemesanan.setCellValueFactory(new PropertyValueFactory<Penumpang, String>("Nama"));
            columnTujuanPemesanan.setCellValueFactory(new PropertyValueFactory<Penumpang, String>("Tujuan"));
            columnJumlahPemesanan.setCellValueFactory(new PropertyValueFactory<Penumpang, Integer>("Jumlah"));
            columnTotalPembayaranPemesanan.setCellValueFactory(new PropertyValueFactory<Penumpang, Double>("TotalPembayaran"));
            penumpangPemesananTB.setItems(dataBelumBayar);
        
            dataSudahBayar = FXCollections.observableArrayList(listPenumpangSudahBayar);
            columnIdPembayaran.setCellValueFactory(new PropertyValueFactory<Penumpang, Integer>("Id"));
            columnTotalPembayaran.setCellValueFactory(new PropertyValueFactory<Penumpang, Double>("TotalPembayaran"));
            columnTujuanPembayaran.setCellValueFactory(new PropertyValueFactory<Penumpang, String>("Tujuan"));
            penumpangPembayaranTB.setItems(dataSudahBayar);
        
            
    }
    /*
    public void buttonPesanBtn(ActionEvent event)
    {
        
    }
    
    public void buttonKonfirmasiBtn(ActionEvent event)
    {
        System.out.println("konfirmasi dilakukan");
        int id = Integer.parseInt(textIdPembayaran.getText());
        double pembayaran = Double.parseDouble(textPembayaran.getText());
        Penumpang p = penumpangDao.getDataPenumpang(id);
        if(p.getTotalPembayaran()<=pembayaran)
        {
            p.setSudahBayar(1);
            dataBelumBayar.remove(p);
            dataSudahBayar.add(p);
        }
        else
        {
            System.out.println("Uang tidak cukup");
        }
    }
    */
    
    private void inisialisiAwalInputan() 
    {
        textIdPembayaran.setText("");
        textJumlahPenumpangPemesanan.setText("");
        textNamaPemesanan.setText("");
        textPembayaran.setText("");
        radioKabanjahe.setSelected(false);
        radioMedan.setSelected(false);
        radioSiantar.setSelected(false);
        radioSibolga.setSelected(false);
        radioSidikalang.setSelected(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        loadData();
        bar.setData(getData());
    }
    private ObservableList<XYChart.Series<String, Number>> getData() {
        ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList();
        XYChart.Series<String, Number> telah = new XYChart.Series<>();
        XYChart.Series<String, Number> belum = new XYChart.Series<>();
        
        telah.setName("Telah Dibayarkan");
        belum.setName("Belum Dibayarkan");
        
        telah.getData().add(new XYChart.Data<String, Number>("Medan", pembayaranDao.getTotalPembayaran(2)));        
        telah.getData().add(new XYChart.Data<String, Number>("Sidikalang", pembayaranDao.getTotalPembayaran(1)));
        telah.getData().add(new XYChart.Data<String, Number>("Sibolga", pembayaranDao.getTotalPembayaran(3)));
        telah.getData().add(new XYChart.Data<String, Number>("Pematang Siantar", pembayaranDao.getTotalPembayaran(4)));
        telah.getData().add(new XYChart.Data<String, Number>("Kabanjahe", pembayaranDao.getTotalPembayaran(5)));
        
        belum.getData().add(new XYChart.Data<String, Number>("Medan", pesananDao.getTotalPemesanan("Medan")));        
        belum.getData().add(new XYChart.Data<String, Number>("Sidikalang", pesananDao.getTotalPemesanan("Sidikalang")));
        belum.getData().add(new XYChart.Data<String, Number>("Sibolga", pesananDao.getTotalPemesanan("Sibolga")));
        belum.getData().add(new XYChart.Data<String, Number>("Pematang Siantar", pesananDao.getTotalPemesanan("Pematang Siantar")));
        belum.getData().add(new XYChart.Data<String, Number>("Kabanjahe", pesananDao.getTotalPemesanan("Kabanjahe")));

        data.addAll(telah,belum);
        return data;
    }
    /*
    private ObservableList<XYChart.Series<String, Number>> getData() 
    {
        ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList();
        XYChart.Series<String, Number> Medan = new XYChart.Series<>();
        XYChart.Series<String, Number> Kabanjahe = new XYChart.Series<>();
        XYChart.Series<String, Number> Siantar = new XYChart.Series<>();

        Medan.setName("Medan");
        Kabanjahe.setName("Kabanjahe");
        Siantar.setName("Siantar");
        Medan.getData().add(new XYChart.Data<String, Number>("MISOP", dataBelumBayar.size()));
        Kabanjahe.getData().add(new XYChart.Data<String, Number>("MISOP", dataSudahBayar.size()));

        data.addAll(Medan,Kabanjahe,Siantar);
        return data;
    }*/

    @FXML
    private void buttonPesanBtn(javafx.event.ActionEvent event) 
    {
        System.out.println("Pemesanan dilakukan");
        String nama = textNamaPemesanan.getText();
        String tujuan = null;
        double totalPembayaran=0.0;
        int jumlah = Integer.parseInt(textJumlahPenumpangPemesanan.getText());
        if (radioKabanjahe.isSelected()) {
            tujuan = "Kabanjahe";
            totalPembayaran = jumlah * 100000;
        } else if (radioMedan.isSelected()) {
            tujuan = "Medan";
            totalPembayaran = jumlah * 80000;
        } else if (radioSiantar.isSelected()) {
            tujuan = "Pematang Siantar";
            totalPembayaran = jumlah * 50000;
        } else if (radioSibolga.isSelected()) {
            tujuan = "Sibolga";
            totalPembayaran = jumlah * 70000;
        } else if (radioSidikalang.isSelected()) {
            tujuan = "Sidikalang";
            totalPembayaran = jumlah * 45000;
        }
        Penumpang penumpang = new Penumpang (0, nama,tujuan,jumlah, totalPembayaran,0);
        penumpangDao.saveDataPenumpang(penumpang);
        dataBelumBayar.add(penumpang);
        inisialisiAwalInputan();
        loadData();
    }

    @FXML
    private void buttonKonfirmasiBtn(javafx.event.ActionEvent event) 
    {
        System.out.println("konfirmasi dilakukan");
        int id = Integer.parseInt(textIdPembayaran.getText());
        double pembayaran = Double.parseDouble(textPembayaran.getText());
        Penumpang p = penumpangDao.getDataPenumpang(id);
        if(p.getTotalPembayaran()<=pembayaran)
        {
            p.setSudahBayar(1);
            penumpangDao.updateDataPenumpang(p);
            dataBelumBayar.remove(dataBelumBayar.indexOf(p));
            dataSudahBayar.add(p);
        }
        else
        {
            System.out.println("Uang tidak cukup");
        }
        loadData();
    }
    
}
