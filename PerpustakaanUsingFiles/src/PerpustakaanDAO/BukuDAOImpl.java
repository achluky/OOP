/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerpustakaanDAO;

import Perpustakaan.Buku;
import Utility.FileUtil;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jayuk
 */
public class BukuDAOImpl implements BukuDAO
{
    @Override
    public Buku getBuku(String ISBN)
    {
        List<Buku> listBuku = getAllBuku();
        Buku buku = new Buku();
        for(Buku b : listBuku)
        {
            if(b.getISBN().equalsIgnoreCase(b.getISBN()))
            {
                buku=b;
            }
        }
        return buku;
    }
    
    @Override
    public List<Buku> getAllBuku()
    {
        List<Buku> listBuku = null;
        try
        {
            FileUtil fu = new FileUtil();
            listBuku = (List<Buku>) fu.getInputStreamBuku().readObject();
            fu.closeObjectInputStreamBuku();
        }
        catch (EOFException eofe)
        {
            eofe.printStackTrace();
        }
        catch (IOException ioe)
        {
            
        }
        catch (ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }
        return listBuku;
    }
    
    @Override
    public void insertBuku(Buku buku)
    {
        List<Buku> listBuku = getAllBuku();
        if(listBuku == null)
        {
            listBuku = new ArrayList<>();
            listBuku.add(buku);
            try
            {
                FileUtil fu = new FileUtil();
                fu.getOutputStreamBuku().writeObject(listBuku);
                fu.closeOnjectOutputStreamBuku();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
        else
        {
            listBuku.add(buku);
            try
            {
                FileUtil fu = new FileUtil();
                fu.getOutputStreamBuku().writeObject(listBuku);
                fu.closeOnjectOutputStreamBuku();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
    }
}
