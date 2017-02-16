/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absensi.Dao.Impl;

import absensi.Dao.MahasiswaDao;
import absensi.model.Akun;
import absensi.model.Mahasiswa;
import absensi.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Jayuk
 */
public class MahasiswaDaoImpl implements MahasiswaDao
{

    @Override
    public void saveDataMahasiswa(Mahasiswa mahasiswa) 
    {
         Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(mahasiswa);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void deleteMahasiswa(Mahasiswa mahasiswa) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.delete(mahasiswa);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void updateDataMahasiswa(Mahasiswa mahasiswa)
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(mahasiswa);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Mahasiswa getDataMahasiswa(String nim) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Mahasiswa mahasiswa = (Mahasiswa) session.get(Mahasiswa.class, nim);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return mahasiswa;
    }

    @Override
    public List<Mahasiswa> getAllMahasiswa() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Mahasiswa> mahasiswa = session.createCriteria(Mahasiswa.class).list();
        session.getTransaction().commit();
        return mahasiswa;
    }
    
}
