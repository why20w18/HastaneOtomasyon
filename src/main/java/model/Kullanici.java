package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Kullanici {

    private int kullaniciId;
    private String kullaniciAd;
    private String kullaniciSoyad;
    private LocalDate kullaniciDogTar;
    private String kullaniciTelNo;
    private String kullaniciSehir;
    private String kullaniciIlce;
    private byte kullaniciKilo; //1byte
    private byte kullaniciBoy;
    private String kullaniciKanGrubu;
    private String kullaniciCinsiyet;


    public Kullanici(){

    }


    public Kullanici(int kullaniciId, String kullaniciAd, String kullaniciSoyad, LocalDate kullaniciDogTar, String kullaniciTelNo,
                     String kullaniciSehir, String kullaniciIlce, byte kullaniciKilo, byte kullaniciBoy, String kullaniciKanGrubu, String kullaniciCinsiyet) {
        this.kullaniciId = kullaniciId;
        this.kullaniciAd = kullaniciAd;
        this.kullaniciSoyad = kullaniciSoyad;
        this.kullaniciDogTar = kullaniciDogTar;
        this.kullaniciTelNo = kullaniciTelNo;
        this.kullaniciSehir = kullaniciSehir;
        this.kullaniciIlce = kullaniciIlce;
        this.kullaniciKilo = kullaniciKilo;
        this.kullaniciBoy = kullaniciBoy;
        this.kullaniciKanGrubu = kullaniciKanGrubu;
        this.kullaniciCinsiyet = kullaniciCinsiyet;
    }

    public int getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
    }

    public String getKullaniciSoyad() {
        return kullaniciSoyad;
    }

    public void setKullaniciSoyad(String kullaniciSoyad) {
        this.kullaniciSoyad = kullaniciSoyad;
    }

    public LocalDate getKullaniciDogTar() {
        return kullaniciDogTar;
    }

    public void setKullaniciDogTar(LocalDate kullaniciDogTar) {
        this.kullaniciDogTar = kullaniciDogTar;
    }

    public String getKullaniciTelNo() {
        return kullaniciTelNo;
    }

    public void setKullaniciTelNo(String kullaniciTelNo) {
        this.kullaniciTelNo = kullaniciTelNo;
    }

    public String getKullaniciSehir() {
        return kullaniciSehir;
    }

    public void setKullaniciSehir(String kullaniciSehir) {
        this.kullaniciSehir = kullaniciSehir;
    }

    public String getKullaniciIlce() {
        return kullaniciIlce;
    }

    public void setKullaniciIlce(String kullaniciIlce) {
        this.kullaniciIlce = kullaniciIlce;
    }

    public byte getKullaniciKilo() {
        return kullaniciKilo;
    }

    public void setKullaniciKilo(byte kullaniciKilo) {
        this.kullaniciKilo = kullaniciKilo;
    }

    public byte getKullaniciBoy() {
        return kullaniciBoy;
    }

    public void setKullaniciBoy(byte kullaniciBoy) {
        this.kullaniciBoy = kullaniciBoy;
    }

    public String getKullaniciKanGrubu() {
        return kullaniciKanGrubu;
    }

    public void setKullaniciKanGrubu(String kullaniciKanGrubu) {
        this.kullaniciKanGrubu = kullaniciKanGrubu;
    }

    public String getKullaniciCinsiyet() {
        return kullaniciCinsiyet;
    }

    public void setKullaniciCinsiyet(String kullaniciCinsiyet) {
        this.kullaniciCinsiyet = kullaniciCinsiyet;
    }
}
