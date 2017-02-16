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
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lkmproject.DAOImpl.ObatDAOImpl;
import lkmproject.DAOImpl.ObatTerpilihDAOImpl;
import lkmproject.DAOImpl.PasienOnlineDAOImpl;
import lkmproject.DAOImpl.PenyakitDAOImpl;
import lkmproject.model.Obat;
import lkmproject.model.ObatTerpilih;
import lkmproject.model.PasienOnline;
import lkmproject.model.Penyakit;

/**
 * FXML Controller class
 *
 * @author Jayuk
 */
public class DokterController implements Initializable 
{
    //========================================================Tabel Pasien Online
    @FXML
    private TableView<PasienOnline> pasienOnlineTV;
    @FXML
    private TableColumn<PasienOnline, Integer> idPasienTC;
    @FXML
    private TableColumn<PasienOnline, String> namaPasienTC;
    @FXML
    private TableColumn<PasienOnline, String> keluhanPasien;
    @FXML
    private TableColumn<PasienOnline,String> riwayatPenyakit;
    
    //========================================================Tabel Obat
    @FXML
    private TableView<Obat> rekomendasiObatTV;
    @FXML
    private TableColumn<Obat, String> namaRekObatTC;
    @FXML
    private TableColumn<Obat, String> komposisiRekTC;
    @FXML
    private TableColumn<Obat, String> jenisObatRekTC;
    
    //========================================================Tabel Obat Terpilih
    @FXML
    private TableView<ObatTerpilih> obatTerpilihTV;
    @FXML
    private TableColumn<ObatTerpilih, String> namaObatTerpilihTC;
    @FXML
    private TableColumn<ObatTerpilih, String> komposisiObatTerpilihTC;
    @FXML
    private TableColumn<ObatTerpilih, String> jenisObatTerpilihTC;
    @FXML
    private TableColumn<ObatTerpilih, String> TakaranObatTerpilihTC;
    
    
    //=========================================================pendeklarasian
    @FXML
    private MenuBar menuBar;
    @FXML
    private TextField PenyakitTF;
    @FXML
    private Separator separator1;
    @FXML
    private Label idLbl;
    @FXML
    private Label namaLbl;
    @FXML
    private Label penyakitLbl;
    @FXML
    private Label rekomendasiLbl;
    @FXML
    private Separator separator2;
    @FXML
    private Label obatLbl;
    @FXML
    private Separator separator3;
    @FXML
    private TextField NamaObatTF;
    @FXML
    private Separator separator4;
    @FXML
    private Label idPasienterpilihLbl;
    @FXML
    private Label namaPasienterpilihLbl;
    @FXML
    private Label cariObatLbl;
    @FXML
    private Label catatanLbl;
    @FXML
    private TextArea catatanTA;
    
    
    
    
    ObservableList<PasienOnline> dataPasienOnline;
    ObservableList<Obat> dataObat;
    ObservableList<ObatTerpilih> dataObatTerpilih;
    
    List<Obat> listObatRekomendasi=  new ArrayList<>();
    List<ObatTerpilih> listObatTerpilih=  new ArrayList<>();
    List<PasienOnline> listPasienOnline=  new ArrayList<>();
    
    ObatDAOImpl obatDao = new ObatDAOImpl();
    PasienOnlineDAOImpl pasienOnlineDao =  new PasienOnlineDAOImpl();
    PenyakitDAOImpl penyakitDao = new PenyakitDAOImpl();
    ObatTerpilihDAOImpl obatTerpilihDao = new ObatTerpilihDAOImpl();
    @FXML
    private RadioButton sekaliRadioBtn;
    @FXML
    private RadioButton seduaRadioBtn;
    @FXML
    private RadioButton seTigaRadioBtn;
    @FXML
    private RadioButton seLainRadioBtn;
    
    ToggleGroup group =  new ToggleGroup();

    public DokterController() 
    {
        pasienOnlineTV =  new TableView();
        rekomendasiObatTV =  new TableView<>();
        obatTerpilihTV =  new TableView<>();
    }
    
    private void inisialisasiAwalInputan()
    {
        PenyakitTF.setText("");
        catatanTA.setText("");
        NamaObatTF.setText("");
    }
    
    public void loadDataRekomendasiObat()
    {
        String penyakit = PenyakitTF.getText();
        List <Penyakit> listPenyakitTemp = penyakitDao.getAllPenyakit();
        Penyakit penyakitPasien = new Penyakit();
        
        for(Penyakit penyakitTemp : listPenyakitTemp)
        {
            if(penyakitTemp.getNamaPenyakit().equalsIgnoreCase(penyakit))
            {
                penyakitPasien = penyakitTemp;
            }
        }
        String obatTemp = penyakitPasien.getDaftarIdObatPenawar();
        String[] listObat = obatTemp.split("\\s*,\\s*");
        for (String idObatTemp : listObat) 
        {
            listObatRekomendasi.add(obatDao.getDataObat(Integer.parseInt(idObatTemp)));
            System.out.println(idObatTemp);
        }
        dataObat = FXCollections.observableArrayList(listObatRekomendasi);
        namaRekObatTC.setCellValueFactory(new PropertyValueFactory<>("namaObat"));
        komposisiRekTC.setCellValueFactory(new PropertyValueFactory<>("komposisi"));
        jenisObatRekTC.setCellValueFactory(new PropertyValueFactory<>("jenisObat"));
        rekomendasiObatTV.setItems(dataObat); 
    }
    public void loadDataPasienOnline()
    {
        try
        {
            List<PasienOnline> listPasienOnlineTemp = pasienOnlineDao.getAllPasienOnline();
        
            for(PasienOnline pasienOnline : listPasienOnlineTemp)
            {
                if(pasienOnline.getSudahDiperiksaDokter().equalsIgnoreCase("0"))
                {
                    listPasienOnline.add(pasienOnline);
                }
            }
            dataPasienOnline  = FXCollections.observableArrayList(listPasienOnline);
            idPasienTC.setCellValueFactory(new PropertyValueFactory<>("idPasienOnline"));
            namaPasienTC.setCellValueFactory(new PropertyValueFactory<>("namaPasienOnline"));
            keluhanPasien.setCellValueFactory(new PropertyValueFactory<>("keluhanPasienOnline"));
            riwayatPenyakit.setCellValueFactory(new PropertyValueFactory<>("riwayatPenyakitPasienOnline"));
            pasienOnlineTV.setItems(dataPasienOnline);
        }
        catch(NullPointerException npe)
        {
            
        }
    }
    public void loadObatTerpilih()
    {
        listObatTerpilih = obatTerpilihDao.getAllObatTerpilih();
        dataObatTerpilih = FXCollections.observableArrayList(listObatTerpilih);
        namaObatTerpilihTC.setCellValueFactory(new PropertyValueFactory<>("namaObat"));
        komposisiObatTerpilihTC.setCellValueFactory(new PropertyValueFactory<>("komposisi"));
        jenisObatTerpilihTC.setCellValueFactory(new PropertyValueFactory<>("jenisObat"));
        TakaranObatTerpilihTC.setCellValueFactory(new PropertyValueFactory<>("takaran"));
        obatTerpilihTV.setItems(dataObatTerpilih);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        loadDataPasienOnline();
        sekaliRadioBtn.setToggleGroup(group);
        seduaRadioBtn.setToggleGroup(group);
        seTigaRadioBtn.setToggleGroup(group);
        seLainRadioBtn.setToggleGroup(group);
    }    

    @FXML
    private void tanganiBtn(ActionEvent event) 
    {
        PasienOnline pasienOnlineTemp = pasienOnlineTV.getSelectionModel().getSelectedItem();
        idPasienterpilihLbl.setText(String.valueOf(pasienOnlineTemp.getIdPasienOnline()));
        namaPasienterpilihLbl.setText(pasienOnlineTemp.getNamaPasienOnline());
        pasienOnlineTemp.setTujuanRuangan("512");
        pasienOnlineDao.editPasienOnline(pasienOnlineTemp);
    }

    @FXML
    private void tambahkanBtn(ActionEvent event) 
    {
        PasienOnline pasienOnlineTenmp = pasienOnlineTV.getSelectionModel().getSelectedItem();
        Obat obat = rekomendasiObatTV.getSelectionModel().getSelectedItem();
        ObatTerpilih ObatTerpilihTemp = new ObatTerpilih();
        ObatTerpilihTemp.setIdobatTerpilih(obat.getIdObat());
        ObatTerpilihTemp.setIdPasienOnline(pasienOnlineTenmp.getIdPasienOnline());
        ObatTerpilihTemp.setNamaObat(obat.getNamaObat());
        ObatTerpilihTemp.setJenisObat(obat.getJenisObat());
        ObatTerpilihTemp.setKompisisi(obat.getKomposisi());
        ObatTerpilihTemp.setNamaObat(obat.getNamaObat());
        ObatTerpilihTemp.setHargaObat(obat.getHargaObat());
        ObatTerpilihTemp.setTakaran("");
        listObatTerpilih.add(ObatTerpilihTemp);
        obatTerpilihDao.saveObatTerpilih(ObatTerpilihTemp);
        loadObatTerpilih();
    }

    @FXML
    private void cariTambahObatBtn(ActionEvent event) 
    {
        PasienOnline pasienOnlineTenmp = pasienOnlineTV.getSelectionModel().getSelectedItem();
        String nama  = NamaObatTF.getText();
        List<Obat> listObatTemp = obatDao.getAllObat();
        for(Obat obat :listObatTemp)
        {
            if(obat.getNamaObat().equalsIgnoreCase(nama))
            {
                ObatTerpilih ObatTerpilihTemp = new ObatTerpilih();
                ObatTerpilihTemp.setIdobatTerpilih(obat.getIdObat());
                ObatTerpilihTemp.setIdPasienOnline(pasienOnlineTenmp.getIdPasienOnline());
                ObatTerpilihTemp.setNamaObat(obat.getNamaObat());
                ObatTerpilihTemp.setJenisObat(obat.getJenisObat());
                ObatTerpilihTemp.setKompisisi(obat.getKomposisi());
                ObatTerpilihTemp.setNamaObat(obat.getNamaObat());
                ObatTerpilihTemp.setTakaran("");
                listObatTerpilih.add(ObatTerpilihTemp); 
                obatTerpilihDao.saveObatTerpilih(ObatTerpilihTemp);
            }
        }
        loadObatTerpilih();
    }


    @FXML
    private void kirimdataBtn(ActionEvent event) 
    {
        PasienOnline pasienOnlineTemp = pasienOnlineDao.getDataPasienOnline(pasienOnlineTV.getSelectionModel().getSelectedItem().getIdPasienOnline());
        pasienOnlineTemp.setSudahDiperiksaDokter("1");
        pasienOnlineTemp.setCatatanPasienOnline(catatanTA.getText());
        pasienOnlineTemp.setPenyakitPasienOnline(PenyakitTF.getText());
        pasienOnlineDao.editPasienOnline(pasienOnlineTemp);
        inisialisasiAwalInputan();
        listObatRekomendasi.clear();
        listObatTerpilih.clear();
        loadObatTerpilih();
        loadDataRekomendasiObat();
        for(ObatTerpilih obatTerpilih : listObatTerpilih)
        {
            obatTerpilihDao.saveObatTerpilih(obatTerpilih);
        }
        loadDataPasienOnline();
    }

    @FXML
    private void HapusObatBtn(ActionEvent event) 
    {
        ObatTerpilih obatTerpilihTemp = obatTerpilihTV.getSelectionModel().getSelectedItem();
        try
        {
            ObatTerpilih obatDipilih =  obatTerpilihDao.getDataObatTerpilih(obatTerpilihTemp.getNamaObat());
            for(int i=0;i<listObatTerpilih.size();i++)
            {
                if(((listObatTerpilih.get(i).getIdobatTerpilih())== (obatDipilih.getIdobatTerpilih())) && ((obatTerpilihTemp.getIdPasienOnline()) == (listObatTerpilih.get(i).getIdPasienOnline())))
                {
                    listObatTerpilih.remove(i);
                    obatTerpilihDao.editObatTerpilih(obatTerpilihTemp);
                }
            }
        }
        catch(NullPointerException npe)
        {
            
        }
        loadObatTerpilih();
    }

    @FXML
    private void tambahPenyakitBtn(ActionEvent event) 
    {
        if("".equals(PenyakitTF.getText()))
        {
            PenyakitTF.setText("Jj");
        }
        else if("".equals(idPasienterpilihLbl.getText()) || idPasienterpilihLbl.getText().equalsIgnoreCase("Pilih dahulu pasien"))
        {
            idPasienterpilihLbl.setText("Pilih dahulu pasien");
        }
        else
        {
           loadDataRekomendasiObat();
           PasienOnline pasienOnlineTemp = pasienOnlineTV.getSelectionModel().getSelectedItem();
           PasienOnline pasienOnline = pasienOnlineDao.getDataPasienOnline(pasienOnlineTemp.getIdPasienOnline());
           pasienOnline.setRiwayatPenyakitPasienOnline(pasienOnline.getRiwayatPenyakitPasienOnline()+" "+PenyakitTF.getText());
           pasienOnline.setPenyakitPasienOnline(PenyakitTF.getText());
           pasienOnlineDao.editPasienOnline(pasienOnline);
        }
    }
    
    
    @FXML
    private void gotoLoginPage(ActionEvent event) 
    {
        System.out.println("Login");
        //((Node) event.getSource()).getScene().getWindow().hide();
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lkmproject/view/LoginView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(IOException io)
        {
                
        }
    }

    

    @FXML
    private void gotoRegistrationPage(ActionEvent event) 
    {
        System.out.println("registrasi");
        ((Node) event.getSource()).getScene().getWindow().hide();
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lkmproject/view/RegistrasiView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Registrasi");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();
            
        }
        catch(IOException io)
        {
                
        }
    }

    @FXML
    private void closeApp(ActionEvent event) 
    {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void resetApp(ActionEvent event) 
    {
        inisialisasiAwalInputan();
        loadDataPasienOnline();
    }

    @FXML
    private void SesuaikanBtn(ActionEvent event) 
    {
        ObatTerpilih obatTerpilih =  new ObatTerpilih();
        try
        {
            obatTerpilih = obatTerpilihTV.getSelectionModel().getSelectedItem();
            ObatTerpilih obatTerpilihTemp = obatTerpilihDao.getDataObatTerpilih(obatTerpilih.getNamaObat());
        
            if(sekaliRadioBtn.isSelected())
                obatTerpilih.setTakaran("sekali sehari");
            else if(seduaRadioBtn.isSelected())
                obatTerpilih.setTakaran("sedua sehari");
            else if(seTigaRadioBtn.isSelected())
                obatTerpilih.setTakaran("setiga sehari");
            else
                obatTerpilih.setTakaran("Selain sehari");
            obatTerpilihDao.editObatTerpilih(obatTerpilih);
            loadObatTerpilih();
        }
        catch(NullPointerException npe)
        {
            System.out.println("Obat tidak ada");
        }
    }
}
