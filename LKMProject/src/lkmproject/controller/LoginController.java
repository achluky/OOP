
package lkmproject.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lkmproject.DAOImpl.AkunDAOImpl;
import lkmproject.DAOImpl.PasienDAOImpl;
import lkmproject.DAOImpl.PasienOnlineDAOImpl;
import lkmproject.model.Akun;
import lkmproject.model.Pasien;
import lkmproject.model.PasienOnline;

/**
 * FXML Controller class
 *
 * @author gracia
 */
public class LoginController implements Initializable
{
    @FXML
    private Tab MayarakatTab;
    @FXML
    private Label lkmLbl;
    @FXML
    private PasswordField passwordPF;
    @FXML
    private Label registrasiLbl;
    @FXML
    private ImageView logoImage;
    @FXML
    private TextField idTF;
    @FXML
    private TextField keluhanTF;
    @FXML
    private Tab PetugasLKMTab;
    @FXML
    private TextField idPegawaiTF;
    @FXML
    private PasswordField passwordPegawaiPF;

    AkunDAOImpl akunDao =  new AkunDAOImpl();
    
    PasienOnlineDAOImpl  pasienOnlineDao = new PasienOnlineDAOImpl();
    
    @FXML
    private Label labelVerifikasiPasien;
    @FXML
    private Label labelPegawaiVerifikasi;
    @FXML
    private ImageView logoImage1;

    public LoginController() 
    {
        
    }
    PasienDAOImpl pasienDao =  new PasienDAOImpl();
    PasienOnlineDAOImpl pasienOnineDaoImpl =  new PasienOnlineDAOImpl();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @FXML
    private void loginPasienBtn(ActionEvent event) throws InterruptedException 
    {
        List<Akun> listAkun = akunDao.getAllAkun();
        int id = Integer.parseInt(idTF.getText());
        String password = passwordPF.getText();
        String golongan = akunDao.login(id, password);
        if(golongan.equalsIgnoreCase("pasien"))
            {
                String keluhan;
                keluhan = keluhanTF.getText();
                List<Pasien>  listPasien = pasienDao.getAllPasien();
                for(Pasien pasien : listPasien)
                {
                    if(pasien.getIdPasien()==id)
                    {
                        ((Node) event.getSource()).getScene().getWindow().hide(); 
                        PasienOnline pasienOnline =  new PasienOnline();
                        pasienOnline.setIdPasienOnline(pasien.getIdPasien());
                        pasienOnline.setNamaPasienOnline(pasien.getNama());
                        pasienOnline.setAlamatPasienOnline(pasien.getAlamat());
                        pasienOnline.setJenisKelaminPasienOnline(pasien.getJenisKelamin());
                        pasienOnline.setRiwayatPenyakitPasienOnline(pasien.getRiwayatPenyakit());
                        pasienOnline.setKeluhanPasienOnline(keluhan);
                        pasienOnline.setTanggalLahirPasienOnline(pasien.getTanggalLahir());
                        pasienOnline.setSudahDiperiksaDokter("0");
                        
                        if(pasienOnlineDao.getDataPasienOnline(pasienOnline.getIdPasienOnline())!=null)
                            pasienOnineDaoImpl.editPasienOnline(pasienOnline);
                        else
                            pasienOnineDaoImpl.savePasienOnline(pasienOnline);
                    }
                }
                
            }
            else if(golongan.equalsIgnoreCase("akun tidak ada"))
            {
                labelVerifikasiPasien.setText("akun tidak ada");
            }
            else
            {
                labelVerifikasiPasien.setText("error");
            }
    }

    @FXML
    private void registrasiPasienBtn(ActionEvent event) 
    {
        System.out.println("registrasi");
        ((Node) event.getSource()).getScene().getWindow().hide();
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lkmproject/view/RegistrasiView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Registrasi");
            stage.setScene(new Scene(root));
            stage.show();
            
            
        }
        catch(IOException io)
        {
                
        }
    }

    @FXML
    private void LoginPegawaiBtn(ActionEvent event) throws InterruptedException 
    {
        int id = Integer.parseInt(idPegawaiTF.getText());
        String password = passwordPegawaiPF.getText();
        System.out.println(id);
        System.out.println(password);
        if(akunDao.login(id, password).equalsIgnoreCase("petugas"))
        {
            System.out.println("petugas masuk");
            
            try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lkmproject/view/PetugasView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Petugas");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            ((Node) event.getSource()).getScene().getWindow().hide();
        }
        catch(IOException io)
        {
                
        }
        }
        else if(akunDao.login(id, password).equalsIgnoreCase("dokter"))
        {
            System.out.println("dokter masuk");
            ((Node) event.getSource()).getScene().getWindow().hide();
            try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lkmproject/view/DokterView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Registrasi");
            stage.setScene(new Scene(root));
            stage.show();
            
        }
        catch(IOException io)
        {
                
        }
        }
        else if(akunDao.login(id, password).equalsIgnoreCase("admin"))
        {
            System.out.println("admin masuk");
            ((Node) event.getSource()).getScene().getWindow().hide();
            try
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lkmproject/view/AdminView.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setTitle("Admin");
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            catch(IOException io)
            {
                
            }
        }
        else
        {
            labelPegawaiVerifikasi.setText("ID atau Password tidak valid");
        }
    }
    
}
