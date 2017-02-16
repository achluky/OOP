/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lkmproject.DAOImpl.FakturDAOImpl;
import lkmproject.DAOImpl.ObatTerpilihDAOImpl;
import lkmproject.DAOImpl.PasienOnlineDAOImpl;
import lkmproject.model.Dokter;
import lkmproject.model.Faktur;
import lkmproject.model.ObatTerpilih;
import lkmproject.model.PasienOnline;

/**
 * FXML Controller class
 *
 * @author Jayuk
 */
public class PetugasController implements Initializable {
    @FXML
    private TableView<PasienOnline> informasiTV;
    @FXML
    private TableColumn<PasienOnline, Integer> IDPasienTC;
    @FXML
    private TableColumn<PasienOnline, String> namaPasienTC;
    @FXML
    private TableColumn<PasienOnline, String> tanggalLahirTC;
    @FXML
    private TableColumn<PasienOnline, String> namaPenyakitTC;
    @FXML
    private TextArea fakturTA;
    @FXML
    private Label idLbl;
    @FXML
    private Label namaLbl;
    @FXML
    private Label penyakitLbl;
    //==================================================list obat terpilih
    @FXML
    private TableView<ObatTerpilih> obatTV;
    @FXML
    private TableColumn<ObatTerpilih, String> daftarObatTC;
    @FXML
    private TableColumn<ObatTerpilih, Double> hargaObatTC;
    @FXML
    private Label biayaObatLbl;
    @FXML
    private Label biayaDokterLbl;
    
    private double totalHarga=0.0;
    
    List<PasienOnline> listPasienOnlineSudahDitangani =  new ArrayList<>();
    List<Dokter> listDokterMenangani =  new ArrayList<>();
    List<ObatTerpilih> listObatTerpilih =  new ArrayList<>();
    PasienOnlineDAOImpl pasienDao =  new PasienOnlineDAOImpl();
    ObatTerpilihDAOImpl obatDao =  new ObatTerpilihDAOImpl();
    FakturDAOImpl fakturDao;
    
    ObservableList<PasienOnline>   dataPasienOnlineSudahDitangani;
    ObservableList<Dokter> dataDokterMenangani;
    ObservableList<ObatTerpilih> dataObatTerpilih;
    @FXML
    private TextArea catatanLabel;

    PasienOnline pasienOnline = new PasienOnline();
    
    public PetugasController() 
    {
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        loadDataPasienYangSudahDitangani();
    }    
    
    public void inisialisasiAwal()
    {
        fakturTA.clear();
        dataObatTerpilih.clear();
        obatTV.refresh();
    }
    
    private void loadDataPasienYangSudahDitangani()
    {
        listPasienOnlineSudahDitangani.clear();
        List<PasienOnline> listPasienOnlineTemp = pasienDao.getAllPasienOnline();
        for(PasienOnline pasienOnlineTemp : listPasienOnlineTemp)
        {
            if(pasienOnlineTemp.getSudahDiperiksaDokter().equalsIgnoreCase("1"))
            {
                listPasienOnlineSudahDitangani.add(pasienOnlineTemp);
            }
        }
        dataPasienOnlineSudahDitangani = FXCollections.observableArrayList(listPasienOnlineSudahDitangani);
        IDPasienTC.setCellValueFactory(new PropertyValueFactory<>("idPasienOnline")); 
        namaPasienTC.setCellValueFactory(new PropertyValueFactory<>("namaPasienOnline"));
        tanggalLahirTC.setCellValueFactory(new PropertyValueFactory<>("tanggalLahirPasienOnline"));
        namaPenyakitTC.setCellValueFactory(new PropertyValueFactory<>("penyakitPasienOnline"));
        informasiTV.setItems(dataPasienOnlineSudahDitangani);
    }
    private void loadDataObatPasienOnline()
    {
        dataObatTerpilih = FXCollections.observableArrayList(listObatTerpilih);
        daftarObatTC.setCellValueFactory(new PropertyValueFactory<>("namaObat"));
        hargaObatTC.setCellValueFactory(new PropertyValueFactory<>("hargaObat"));
        obatTV.setItems(dataObatTerpilih);
    }

    @FXML
    private void simpanCetakBtn(ActionEvent event) throws FileNotFoundException 
    {
        FileChooser fileChooser =  new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files(*.txt)","*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(((Node) event.getSource()).getScene().getWindow());
        SaveFile(fakturTA.getText(), file);
    }
    
    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter;
             
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) 
        {
            
        }
         
    }

    @FXML
    private void simpanBtn(ActionEvent event) 
    {
        ObatTerpilihDAOImpl obatTerpilihTempDao = new  ObatTerpilihDAOImpl();
        PasienOnline pasienOnline =  informasiTV.getSelectionModel().getSelectedItem();
        PasienOnline pasienOnlineTemp =  pasienDao.getDataPasienOnline(pasienOnline.getIdPasienOnline());
        fakturTA.insertText(fakturTA.getLength(), "Layanan Kesehatan Masyarakat"+"\n");
        fakturTA.insertText(fakturTA.getLength(), "==================================================================\n");
        fakturTA.insertText(fakturTA.getLength(), pasienOnlineTemp.getIdPasienOnline()+"\n");
        fakturTA.insertText(fakturTA.getLength(), pasienOnlineTemp.getNamaPasienOnline()+"\n");
        fakturTA.insertText(fakturTA.getLength(), pasienOnlineTemp.getAlamatPasienOnline()+"\n");
        List<ObatTerpilih> listObatTerpilihTemp =  obatDao.getAllObatTerpilih();
        fakturTA.insertText(fakturTA.getLength(), "\n Daftar Obat :"+"\t"+"\t"+"\n");
        double totalHarga = 0;
        String daftarIdObat=null;
        for(ObatTerpilih obatTerpilih : listObatTerpilihTemp)
        {
            
            if(obatTerpilih.getIdPasienOnline()==pasienOnlineTemp.getIdPasienOnline())
            {
                totalHarga += obatTerpilih.getHargaObat();
                daftarIdObat = daftarIdObat + " " + obatTerpilih.getIdobatTerpilih();
                fakturTA.insertText(fakturTA.getLength(), obatTerpilih.getNamaObat()+"\t"+obatTerpilih.getTakaran()+"\t"+"\t"+obatTerpilih.getHargaObat()+ "\n");
            }
        }
        fakturTA.insertText(fakturTA.getLength(), "Total Harga Obat : "+totalHarga+"\n");
        fakturTA.insertText(fakturTA.getLength(), "===================================================================\n");
        fakturTA.insertText(fakturTA.getLength(), "\t\t\t\tTerima Kasih\n");
        Faktur faktur = new Faktur(0, totalHarga, 20000, "titin", daftarIdObat);
        fakturDao.save(faktur);
        List<ObatTerpilih> listObatTerpilihTempDelete = obatTerpilihTempDao.getAllObatTerpilih();
        for(ObatTerpilih obatTerpilih : listObatTerpilihTempDelete)
        {
            if(obatTerpilih.getIdPasienOnline()==pasienOnline.getIdPasienOnline())
            {
                obatDao.deleteObatTerpilih(obatTerpilih.getIdobatTerpilih());
                obatTerpilihTempDao.deleteObatTerpilih(obatTerpilih.getIdPasienOnline());
            }
        }
        pasienDao.deletePasienOnline(pasienOnlineTemp.getIdPasienOnline());
        pasienDao.deletePasienOnline(pasienOnline);
        loadDataPasienYangSudahDitangani();
    }

    @FXML
    private void layaniBtn(ActionEvent event) 
    {
        PasienOnline pasienOnlineTemporaly =  informasiTV.getSelectionModel().getSelectedItem();
        idLbl.setText(String.valueOf(pasienOnlineTemporaly.getIdPasienOnline()));
        System.out.println(pasienOnlineTemporaly.getIdPasienOnline());
        namaLbl.setText(pasienOnlineTemporaly.getNamaPasienOnline());
        catatanLabel.setText(pasienOnlineTemporaly.getCatatanPasienOnline());
        System.out.println(pasienOnlineTemporaly.getPenyakitPasienOnline());
        System.out.println(pasienOnlineTemporaly.getRiwayatPenyakitPasienOnline());
        penyakitLbl.setText(pasienOnlineTemporaly.getPenyakitPasienOnline());
        List<ObatTerpilih> listObatTerpilihTemp;
        listObatTerpilihTemp = obatDao.getAllObatTerpilih();
        if(!listObatTerpilihTemp.isEmpty())
        {
            System.out.println("masuk");
            for(ObatTerpilih obatTerpilihSementara : listObatTerpilihTemp)
            {
                System.out.println(obatTerpilihSementara.getIdPasienOnline());
                System.out.println(Integer.parseInt(idLbl.getText()));
                if(obatTerpilihSementara.getIdPasienOnline()==Integer.parseInt(idLbl.getText()))
                {
                    System.out.println("Ajax");
                    listObatTerpilih.add(obatTerpilihSementara);
                    totalHarga += obatTerpilihSementara.getHargaObat();
                    System.out.println(obatTerpilihSementara.getIdobatTerpilih());
                }
            }
            biayaObatLbl.setText(String.valueOf(totalHarga));
            loadDataObatPasienOnline();
       }
       else
       {
           penyakitLbl.setText("Tidak ada obat");
       }
    }

    @FXML
    private void gotoLoginPage(ActionEvent event) 
    {
        System.out.println("registrasi");
        ((Node) event.getSource()).getScene().getWindow().hide();
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lkmproject/view/LoginView.fxml"));
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
    
}
