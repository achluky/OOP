package org.sia.dao;

import static java.util.Collections.list;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.sia.model.Mahasiswa;
import org.sia.util.HibernateUtil;

/**
 *
 * @author Jayuk
 */
public class MahasiswaDaoImplHibernate implements MahasiswaDao
{

    @Override
    public void saveDataMahasiswa(Mahasiswa m) 
    {
        
        Session session =  HibernateUtil.getSession();
        session.getTransaction().begin();
        //String hql = "insert into mahasiswa (nama, indeksPrestasi,jenisKelamin) values ('jaya',4,'pria');";
        String hq = "insert into mahasiswa (nama, indeksPrestasi,jenisKelamin) values ('"+m.getNama()+"','"+m.getIndeksPrestasi()+"','"+m.getJenisKelamin()+"')";
        Query query =  session.createQuery(hq);
        query.executeUpdate();
        //session.save(m);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Mahasiswa getDataMahasiswa(int nim) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Mahasiswa m = (Mahasiswa)session.get(Mahasiswa.class, nim);
        session.getTransaction().commit();
        return m;
    }

    @Override
    public List<Mahasiswa> getAllMahasiswa() 
    {
        Session session =  HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Mahasiswa> mahasiswas =  session.createCriteria(Mahasiswa.class).list();
        session.getTransaction().commit();
        session.flush();
        session.close();
        return mahasiswas;
    }
    
}
