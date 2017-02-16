package org.perpus.controller;

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
import org.perpus.dao.BukuDao;
import org.perpus.controller.impl.BukuDaoImplHibernate;
import org.perpus.model.Buku;
/**
 *
 * @author Wira
 */
public class MainController implements Initializable
{
    @FXML
    private TextField isbnTF;
    @FXML
    private TextField judulTF;
    @FXML
    private TextField pengarangTF;
    @FXML
    private TextField penerbitTF;
    @FXML
    private TextField tipeTF;
    @FXML
    private TextField stokTF;
    
    @FXML
    private TextField tfISBN;
    
    private BukuDao bukuDao;
    @FXML
    private TableView<Buku> bukuTB;
    @FXML
    private TableColumn<Buku, Integer> isbn;
    @FXML
    private TableColumn<Buku, String> judul;
    @FXML
    private TableColumn<Buku, String> pengarang;
    @FXML
    private TableColumn<Buku, String> penerbit;
    @FXML
    private TableColumn<Buku, String> tipe;
    @FXML
    private TableColumn<Buku, Integer> stok;
    ObservableList<Buku> data;

    public MainController()
    {
        bukuDao = new BukuDaoImplHibernate();
        bukuTB = new TableView<>();
    }

    public void loadData()
    {
        List<Buku> bukus = bukuDao.getAllBuku();
        for (Buku b : bukus)
        {
            System. out.println( "Judul :" + b.getJudul());
            data = FXCollections.observableArrayList(bukus);
            isbn.setCellValueFactory(new PropertyValueFactory<Buku, Integer>("isbn"));
            judul.setCellValueFactory(new PropertyValueFactory<Buku, String>("judul"));
            pengarang.setCellValueFactory(new PropertyValueFactory<Buku, String>("pengarang"));
            penerbit.setCellValueFactory(new PropertyValueFactory<Buku, String>("penerbit"));
            tipe.setCellValueFactory(new PropertyValueFactory<Buku, String>("tipe"));
            stok.setCellValueFactory(new PropertyValueFactory<Buku, Integer>("stok"));
            bukuTB.setItems(data);
        }
    }

    @FXML
    public void btnSave(ActionEvent event)
    {
        System.out.println("IT DEL");
        int isbn = Integer.parseInt(isbnTF.getText());
        String judul = judulTF.getText();
        String pengarang = pengarangTF.getText();
        String penerbit = penerbitTF.getText();
        String tipe = tipeTF.getText();
        int stok = Integer.parseInt(stokTF.getText());
        Buku b = new Buku(isbn, judul, pengarang, penerbit, tipe, stok);
        bukuDao.saveDataBuku(b);
        data.add(b);
        inisialisiAwalInputan();
    }
    
    @FXML
    public void btnSearch(ActionEvent event)
    {
        List<Buku> bukus = bukuDao.getAllBuku();
        for(Buku b : bukus)
        {  
            int isbnn = Integer.parseInt(tfISBN.getText());
            if(isbnn == b.getIsbn())
            {
                inisialisiAwalInputan();
                System. out.println( "Judul :" + b.getJudul());
                data = FXCollections.observableArrayList(bukus);
                isbn.setCellValueFactory(new PropertyValueFactory<Buku, Integer>("isbn"));
                judul.setCellValueFactory(new PropertyValueFactory<Buku, String>("judul"));
                pengarang.setCellValueFactory(new PropertyValueFactory<Buku, String>("pengarang"));
                penerbit.setCellValueFactory(new PropertyValueFactory<Buku, String>("penerbit"));
                tipe.setCellValueFactory(new PropertyValueFactory<Buku, String>("tipe"));
                stok.setCellValueFactory(new PropertyValueFactory<Buku, Integer>("stok"));
                kosong();
                data.add(b);
                bukuTB.setItems(data);
  
            }
            else
                bukuTB.setItems(data);
            
        }
    }
    public void kosong()
    {
        isbn.setText("");
        judul.setText("");
        pengarang.setText("");
        penerbit.setText("");
        tipe.setText("");
        stok.setText("");
    }
    
    @FXML
    public void btnBorrow(ActionEvent event)
    {
         List<Buku> bukus = bukuDao.getAllBuku();
        for(Buku b : bukus)
        {  
            int isbnn = Integer.parseInt(tfISBN.getText());
            if(isbnn == b.getIsbn())
            {
                System. out.println( "Judul :" + b.getJudul());
                data = FXCollections.observableArrayList(bukus);
                isbn.setCellValueFactory(new PropertyValueFactory<Buku, Integer>("isbn"));
                judul.setCellValueFactory(new PropertyValueFactory<Buku, String>("judul"));
                pengarang.setCellValueFactory(new PropertyValueFactory<Buku, String>("pengarang"));
                penerbit.setCellValueFactory(new PropertyValueFactory<Buku, String>("penerbit"));
                tipe.setCellValueFactory(new PropertyValueFactory<Buku, String>("tipe"));
                stok.setCellValueFactory(new PropertyValueFactory<Buku, Integer>("stok"));
                
                bukuTB.setItems(data);
                
  
            }
            else
                bukuTB.setItems(data);
            
        }
        
    }

    private void inisialisiAwalInputan()
    {
        isbnTF.setText("");
        judulTF.setText("");
        pengarangTF.setText("");
        penerbitTF.setText("");
        tipeTF.setText("");
        stokTF.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        
        loadData();
    }
    
}


