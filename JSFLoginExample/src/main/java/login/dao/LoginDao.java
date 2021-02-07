package login.dao;


import login.entity.PersonelUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
public class LoginDao implements Serializable {

    public static final String JPA_UNIT = "JsfJpaPU";

    private static final EntityManager em =
            Persistence.createEntityManagerFactory(JPA_UNIT).createEntityManager();

    public boolean userControl(String kullaniciAdi, String kullaniciSifre){
        final EntityTransaction entityTransaction = em.getTransaction();
        try {
            entityTransaction.begin();
            Query q = em.createQuery("select p from PersonelUser p where p.kullaniciAdi = :kullaniciAdi and p.kullaniciSifre = :kullaniciSifre and p.kullaniciDurum= :kullaniciDurum");
            q.setParameter("kullaniciAdi", kullaniciAdi);
            q.setParameter("kullaniciSifre", kullaniciSifre);
            q.setParameter("kullaniciDurum", "A");

            List<PersonelUser> personelUserList = q.getResultList();

            if(!personelUserList.isEmpty())
                return true;
            else
                return false;
        } catch(Exception e){
            entityTransaction.rollback();
            return  false;
        }finally {
            entityTransaction.commit();
        }
    }
}
