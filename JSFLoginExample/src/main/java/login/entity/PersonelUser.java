package login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "perkul")
public class PersonelUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "kullaniciadi", nullable = true)
    @Size(max = 50)
    private String kullaniciAdi;

    @Column(name = "kullanicidurum")
    private String kullaniciDurum;

    @Column(name = "kullanicisifre", nullable = true)
    @Size(max = 50)
    private String kullaniciSifre;

    public PersonelUser(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getKullaniciDurum() {
        return kullaniciDurum;
    }

    public void setKullaniciDurum(String kullaniciDurum) {
        this.kullaniciDurum = kullaniciDurum;
    }

    public String getKullaniciSifre() {
        return kullaniciSifre;
    }

    public void setKullaniciSifre(String kullaniciSifre) {
        this.kullaniciSifre = kullaniciSifre;
    }

    @Override
    public String toString() {
        return "PersonelUser{" +
                "Id=" + Id +
                ", kullaniciAdi='" + kullaniciAdi + '\'' +
                ", kullaniciDurum='" + kullaniciDurum + '\'' +
                ", kullaniciSifre='" + kullaniciSifre + '\'' +
                '}';
    }
}
