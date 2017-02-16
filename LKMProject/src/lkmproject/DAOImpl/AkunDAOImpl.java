/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lkmproject.DAOImpl;

import java.util.List;
import lkmproject.DAO.AkunDAOInterface;
import lkmproject.model.Akun;
import lkmproject.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author gracia
 */
public class AkunDAOImpl implements AkunDAOInterface
{

    @Override
    public void saveAkun(Akun akun) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(akun);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public Boolean deleteAkun(int idPengguna) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Akun akun = (Akun) session.get(Akun.class, idPengguna);
        if(akun == null)
            return false;
        session.delete(akun);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public Boolean editAkun(Akun akun) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(akun);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return true;
    }

    @Override
    public List<Akun> getAllAkun() 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Akun> listAkun = session.createCriteria(Akun.class).list();
        session.getTransaction().commit();
        session.close();
        return listAkun;
    }

    @Override
    public String getPasswordAkun(int idPengguna) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Akun akun = (Akun) session.get(Akun.class, idPengguna);
        session.getTransaction().commit();
        session.close();
        return akun.getPasswordPengguna();
    }

    @Override
    public String login(int idPengguna, String passwordPengguna) 
    {
        Session session = HibernateUtil.getSession();
        Akun akunTemp = new Akun();
        session.getTransaction().begin();
        /*
        String hql = "FROM Akun A Where E.idPengguna = "+idPengguna+"and passwordPengguna = "+passwordPengguna;
        Query query =  session.createQuery(hql);
        akunTemp =(Akun) query.uniqueResult();
        return akunTemp.getGolongan();*/
        
        int flag=0;
        List<Akun> listAkun = getAllAkun();
        for(Akun akun : listAkun)
        {
            if((akun.getIdPengguna()== idPengguna) && (akun.getPasswordPengguna().equalsIgnoreCase(passwordPengguna)))
            {
                flag=1;
                akunTemp = akun;
                System.out.println(akunTemp.getIdPengguna());
                return akunTemp.getGolongan();
            }
        }
        if(flag ==0)
        {

            return "akun tidak ada";
        }
        return "error";
    }
    
}
