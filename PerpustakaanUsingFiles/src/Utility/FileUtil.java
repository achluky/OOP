/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Jayuk
 */
public class FileUtil 
{
    static String alamatFileBuku = "C:\\Users\\Jayuk\\Documents\\NetBeansProjects\\PerpustakaanUsingFiles\\src\\FileTXT\\Buku.txt";
    static String alamatFileAnggota  ="C:\\Users\\Jayuk\\Documents\\NetBeansProjects\\PerpustakaanUsingFiles\\src\\FileTXT\\Anggota.txt";
    private ObjectInputStream oisBuku,oisAnggota;
    private ObjectOutputStream oosBuku,oosAnggota;
    
    public ObjectOutputStream getOutputStreamBuku() throws IOException
    {
        oosBuku = new ObjectOutputStream(new FileOutputStream(new File(alamatFileBuku)));
        return oosBuku;
    }
    public ObjectInputStream getInputStreamBuku() throws IOException
    {
        oisBuku = new ObjectInputStream(new FileInputStream(new File(alamatFileBuku)));
        return oisBuku;
    }
    public ObjectOutputStream getOutputStreamAnggota() throws IOException
    {
        oosAnggota = new ObjectOutputStream(new FileOutputStream(new File(alamatFileAnggota)));
        return oosAnggota;
    }
    public ObjectInputStream getInputStreamAnggota() throws IOException
    {
        oisAnggota = new ObjectInputStream(new FileInputStream(new File(alamatFileAnggota)));
        return oisAnggota;
    }
    
    
    public void closeObjectInputStreamBuku() throws IOException
    {
        oisBuku.close();
    }
    public void closeOnjectOutputStreamBuku() throws IOException
    {
        oosBuku.close();
    }
    public void closeObjectInputStreamAnggota() throws IOException
    {
        oisAnggota.close();
    }
    public void closeOnjectOutputStreamAnggota() throws IOException
    {
        oosAnggota.close();
    }
}
