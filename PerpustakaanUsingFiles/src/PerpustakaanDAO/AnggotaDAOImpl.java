/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerpustakaanDAO;

import Utility.FileUtil;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Perpustakaan.Anggota;
import Perpustakaan.Buku;

/**
 *
 * @author Jayuk
 */
public class AnggotaDAOImpl implements AnggotaDAO
{
    
    @Override
    public Anggota getAnggota(String id)
    {
        List<Anggota> listAnggota = getAllAnggota();
        Anggota anggota = null;
        for(Anggota ang : listAnggota)
        {
            if(!id.equalsIgnoreCase(ang.getID()))
            {
                anggota = ang;
            }
        }
        return anggota;
        
    }
    @Override
    public List<Anggota> getAllAnggota()
    {
        List<Anggota> listAnggota = null;
        try
        {
            FileUtil fu = new FileUtil();
            listAnggota = (List<Anggota>) fu.getInputStreamAnggota().readObject();
            fu.closeObjectInputStreamAnggota();
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
        return listAnggota;
    }
    
    @Override
    public void insertAnggota(Anggota anggota)
    {
        List<Anggota> listAnggota = getAllAnggota();
        if(listAnggota == null)
        {
            listAnggota = new ArrayList<>();
            listAnggota.add(anggota);
            try
            {
                FileUtil fu = new FileUtil();
                fu.getOutputStreamBuku().writeObject(listAnggota);
                fu.closeOnjectOutputStreamBuku();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
        else
        {
            listAnggota.add(anggota);
            try
            {
                FileUtil fu = new FileUtil();
                fu.getOutputStreamBuku().writeObject(listAnggota);
                fu.closeOnjectOutputStreamBuku();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
    }
        
}
