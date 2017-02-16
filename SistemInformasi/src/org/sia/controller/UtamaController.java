/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sia.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn; 
 
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory; 
 
import org.sia.dao.MahasiswaDao;
import org.sia.dao.MahasiswaDaoImplHibernate;
import org.sia.model.Mahasiswa; 
 
 

/**
 *
 * @author Jayuk
 */
public class UtamaController implements Initializable
{
    @FXML
    private TextField namaTF;
    @FXML
    private TextField ipkTF;
    @FXML
    private TextField jkTF;
    private MahasiswaDao mDao;
    
    @FXML
    private TableView<Mahasiswa> mahasiswaTB;
    @FXML
    private TableColumn<Mahasiswa,Integer> nim;
    @FXML
    private TableColumn<Mahasiswa,String> nama;
    @FXML
    private TableColumn<Mahasiswa,String> jenisKelamin;
    @FXML
    private TableColumn<Mahasiswa, Double> indeksPrestasi;
    
    ObservableList<Mahasiswa> data; 
 
public UtamaController() 
{
    mDao = new MahasiswaDaoImplHibernate();
    mahasiswaTB = new TableView<>(); 
}
 
public void loadData() 
{
    List<Mahasiswa> mahasiswas = mDao.getAllMahasiswa();
    for (Mahasiswa m : mahasiswas)     
    {
        System.out.println("nama :" + m.getNama());
    }
    data = FXCollections.observableArrayList(mahasiswas);
    nim.setCellValueFactory(new PropertyValueFactory<Mahasiswa, Integer>("nim"));
    nama.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nama"));
    jenisKelamin.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("jenisKelamin"));
    indeksPrestasi.setCellValueFactory(new PropertyValueFactory<Mahasiswa, Double>("indeksPrestasi")); 
    mahasiswaTB.setItems(data); } 
 
@FXML     
public void saveData(ActionEvent event) 
{
    System.out.println("dipanggil kok");
    String nama = namaTF.getText();
    double ipk = Double.parseDouble(ipkTF.getText());
    String jk = jkTF.getText();
    Mahasiswa m = new Mahasiswa(0, nama, ipk, jk);
    mDao.saveDataMahasiswa(m);
    data.add(m);
    inisialisiAwalInputan();
} 
 
private void inisialisiAwalInputan() 
{
    namaTF.setText("");
    ipkTF.setText("");
    jkTF.setText("");
} 
 
@Override     
public void initialize(URL location, ResourceBundle resources) 
{
    loadData();
}
} 
