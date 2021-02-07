package login.bean;

import login.dao.LoginDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "loginBean")
@SessionScoped

public class LoginManagedBean implements Serializable {

    String kullaniciAdi;
    String kullaniiciSifre;

    @EJB
    LoginDao loginDao;

    public boolean userControl(){
        try {
            return loginDao.userControl(kullaniciAdi, kullaniiciSifre);
        } catch (Exception e) {
            return false;
        }
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getKullaniiciSifre() {
        return kullaniiciSifre;
    }

    public void setKullaniiciSifre(String kullaniiciSifre) {
        this.kullaniiciSifre = kullaniiciSifre;
    }
}
