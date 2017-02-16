/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.StringConverter;
import lkmproject.DAOImpl.PasienDaftarDAOImpl;
import lkmproject.model.PasienDaftar;

/**
 * FXML Controller class
 *
 * @author Jayuk
 */
public class RegistrasiController implements Initializable
{

    @FXML
    private Label lkmLbl;
    @FXML
    private Label idLbl;
    @FXML
    private Label alamatLbl;
    @FXML
    private Label TTLLbl;
    @FXML
    private Label jkLbl;
    @FXML
    private Label namaLbl;
    @FXML
    private Label riwayatPenyakitLbl;
    @FXML
    private TextField idTF;
    @FXML
    private TextField namaTF;
    @FXML
    private TextField alamatTF;
    @FXML
    private Label passwordLbl;
    @FXML
    private PasswordField passwordTf;
    @FXML
    private PasswordField ulangPasswordTF;
    @FXML
    private ImageView logoImage;
    @FXML
    private DatePicker tanggalLahirDate;
    @FXML
    private TextArea RiwayatTA;

    /**
     * Initializes the controller class.
     */
    PasienDaftarDAOImpl pasienDaftarDao = new PasienDaftarDAOImpl();
    @FXML
    private RadioButton lakiLakiRegistrasiRB;
    @FXML
    private RadioButton perempuanRegistrasiRB;
    @FXML
    private Label MessageLabel;
    
    private final String pattern = "yyyy-MM-dd";
    @Override 
    
    public void initialize(URL url, ResourceBundle rb) 
    {
        Locale.setDefault(Locale.US);
        tanggalLahirDate =  new DatePicker();
        tanggalLahirDate.setValue(LocalDate.now());
        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = 
                DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };             
        tanggalLahirDate.setConverter(converter);
        tanggalLahirDate.setPromptText(pattern.toLowerCase());
    }

    public void inisialisasiInputanAwal()
    {
        idTF.setText("");
        passwordTf.setText("");
        ulangPasswordTF.setText("");
        namaTF.setText("");
        alamatTF.setText("");
        lakiLakiRegistrasiRB.setSelected(false);
        perempuanRegistrasiRB.setSelected(false);
    }

    @FXML
    private void RegistrasiBtn(ActionEvent event) 
    {
        if(!"".equals(idTF.getText())&&
                !"".equals(passwordTf.getText())&&
                ulangPasswordTF.getText()!=""&&
                !"".equals(namaTF.getText()) &&
                !"".equals(alamatTF.getText()) &&
                (lakiLakiRegistrasiRB.isSelected() ||
                perempuanRegistrasiRB.isSelected()))
        {
            PasienDaftar pasienDaftarTemp = new PasienDaftar();
            pasienDaftarTemp.setIdPasien(Integer.parseInt(idTF.getText()));
            if(passwordTf.getText().equalsIgnoreCase(ulangPasswordTF.getText()))
                pasienDaftarTemp.setPassword(passwordTf.getText());
            else
            {
                passwordTf.setStyle("-fx-background-color: red;");
                ulangPasswordTF.setStyle("-fx-background-color: red;");
            }
            pasienDaftarTemp.setNama(namaTF.getText());
            pasienDaftarTemp.setAlamat(alamatTF.getText());
            if(lakiLakiRegistrasiRB.isSelected())
                pasienDaftarTemp.setJenisKelamin("L");
            if(perempuanRegistrasiRB.isSelected())
                pasienDaftarTemp.setJenisKelamin("P");
            else if(lakiLakiRegistrasiRB.isSelected() && perempuanRegistrasiRB.isSelected())
            {
                MessageLabel.setText("pilih hanya Satu Jenis Kelamin");
                return;
            }
            LocalDate date = tanggalLahirDate.getValue();
            String tanggalLahir = date.toString();
            pasienDaftarTemp.setTanggalLahir(tanggalLahir);
            pasienDaftarTemp.setRiwayatPenyakit(RiwayatTA.getText());
            try
            {
                pasienDaftarDao.getDataPasienDaftar(Integer.parseInt(idTF.getText()));
            }
            catch(NullPointerException npe)
            {
                pasienDaftarDao.save(pasienDaftarTemp);
                return;
            }
            pasienDaftarDao.save(pasienDaftarTemp);
            MessageLabel.setText("Anda Sudah masuk daftar tunggu");
        }
        else
        {
            MessageLabel.setText("Semua Isian Wajib diisi kecuali riwayat penyakit");
        }
    }

    @FXML
    private void gotoLoginWindow(ActionEvent event) throws IOException 
    {
        System.out.println("registrasi");
        ((Node) event.getSource()).getScene().getWindow().hide();
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lkmproject/view/LoginView.fxml"));
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
}
