package org.rest.dao;

import java.util.ArrayList;
import java.util.List;
import org.rest.model.Mahasiswa;

/**
 *
 * @author Jayuk
 */
public enum MahasiswaDAO 
{
    intance;
    public List<Mahasiswa> mahasiswas =  new ArrayList<>();
    
    private MahasiswaDAO()
    {
        Mahasiswa a = new Mahasiswa("dapot","1",3.5);
        mahasiswas.add(a);
        a =  new Mahasiswa("dapotwati","2",3.6);
        mahasiswas.add(a);
        a = new Mahasiswa("dapotwati2","3",3.7);
        mahasiswas.add(a);
    }
    public List<Mahasiswa> getModel()
    {
        return mahasiswas;
    }
}
