/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAOImpl;

import java.util.List;
import lkmproject.DAO.ObatTerpilihDAOInterface;
import lkmproject.model.ObatTerpilih;
import lkmproject.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author gracia
 */
public class ObatTerpilihDAOImpl implements ObatTerpilihDAOInterface
{

    @Override
    public void saveObatTerpilih(ObatTerpilih obatTerpilih) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(obatTerpilih);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Boolean deleteObatTerpilih(int idObatTerpilih) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        ObatTerpilih obatTerpilih = (ObatTerpilih) session.get(ObatTerpilih.class, idObatTerpilih);
        if(obatTerpilih == null)
            return false;
        session.delete(obatTerpilih);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public Boolean editObatTerpilih(ObatTerpilih obatTerpilih) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(obatTerpilih);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public List<ObatTerpilih> getAllObatTerpilih() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<ObatTerpilih> listObatTerpilih = session.createCriteria(ObatTerpilih.class).list();
        session.getTransaction().commit();
        session.close();
        return listObatTerpilih;
    }

    @Override
    public ObatTerpilih getDataObatTerpilih(int idObatTerpilih) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        ObatTerpilih obatTerpilih = (ObatTerpilih) session.get(ObatTerpilih.class, idObatTerpilih);
        session.getTransaction().commit();
        session.close();
        return obatTerpilih;
    }
    public ObatTerpilih getDataObatTerpilih(String namaObat)
    {
        List<ObatTerpilih> listObatTemp =  getAllObatTerpilih();
        for(ObatTerpilih obatTerpilih : listObatTemp)
        {
            if(obatTerpilih.getNamaObat().equalsIgnoreCase(namaObat));
            return obatTerpilih;
        }
        return null;
    }
}
