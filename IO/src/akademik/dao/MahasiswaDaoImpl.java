
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akademik.dao;

import akademik.FileUtil;
import akademik.Mahasiswa;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jayuk
 */
public class MahasiswaDaoImpl implements MahasiswaDAO
{

    @Override
    public Mahasiswa getMahasiswa(String nim)
    {
        List<Mahasiswa> mhs = getAllMahasiswa();
        Mahasiswa m = new Mahasiswa();
        for(Mahasiswa mm : mhs)
        {
            if(nim.equalsIgnoreCase(mm.getNim()))
            {
                m=mm;
            }
        }
        return m;
    }
    
    @Override
    public List<Mahasiswa> getAllMahasiswa()
    {
        List<Mahasiswa> mhs = null; 
        try
        {
            FileUtil fu = new FileUtil();
            mhs = (List<Mahasiswa>) fu.getInputStream().readObject();
            fu.closeObjectInputStream();
        }
        catch (EOFException ex)
        {
            
        }
        catch (IOException ex)
        {
            
        }
        catch (ClassNotFoundException ex)
        {    
        ex.printStackTrace();
    }
    return mhs;
    }

    @Override
    public void insertMahasiswa(Mahasiswa m) 
    {
        List <Mahasiswa> mhs = getAllMahasiswa();
        if(mhs==null)
        {
            mhs = new ArrayList<>();
            mhs.add(m);
            try
            {
                FileUtil fu = new FileUtil();
                fu.getOutputStream().writeObject(mhs);
                fu.closeOnjectOutputStream();
            } 
            catch (IOException ex) 
            {
                
            }
        }
        else
        {
            mhs.add(m);
            try
            {
                FileUtil fu = new FileUtil();
                fu.getOutputStream().writeObject(mhs);
                fu.closeOnjectOutputStream();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
}
