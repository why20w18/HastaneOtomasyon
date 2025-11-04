package model.impl;

import model.IBaseModel;

import java.time.LocalDate;

public class Kurulus implements IBaseModel<Kurulus> {
    private int kurulusId;
    private String kurulusAd;
    private String kurulusSehir;
    private String kurulusIlce;
    private LocalDate kurulusTar;
    private String kurulusTur;
    private String kurulusSorumlusu;

    public Kurulus(){

    }

    public Kurulus(int kurulusId, String kurulusAd, String kurulusSehir, String kurulusIlce, LocalDate kurulusTar,
                   String kurulusTur, String kurulusSorumlusu) {
        this.kurulusId = kurulusId;
        this.kurulusAd = kurulusAd;
        this.kurulusSehir = kurulusSehir;
        this.kurulusIlce = kurulusIlce;
        this.kurulusTar = kurulusTar;
        this.kurulusTur = kurulusTur;
        this.kurulusSorumlusu = kurulusSorumlusu;
    }

    public int getKurulusId() {
        return kurulusId;
    }

    public void setKurulusId(int kurulusId) {
        this.kurulusId = kurulusId;
    }

    public String getKurulusAd() {
        return kurulusAd;
    }

    public void setKurulusAd(String kurulusAd) {
        this.kurulusAd = kurulusAd;
    }

    public String getKurulusSehir() {
        return kurulusSehir;
    }

    public void setKurulusSehir(String kurulusSehir) {
        this.kurulusSehir = kurulusSehir;
    }

    public String getKurulusIlce() {
        return kurulusIlce;
    }

    public void setKurulusIlce(String kurulusIlce) {
        this.kurulusIlce = kurulusIlce;
    }

    public LocalDate getKurulusTar() {
        return kurulusTar;
    }

    public void setKurulusTar(LocalDate kurulusTar) {
        this.kurulusTar = kurulusTar;
    }

    public String getKurulusTur() {
        return kurulusTur;
    }

    public void setKurulusTur(String kurulusTur) {
        this.kurulusTur = kurulusTur;
    }

    public String getKurulusSorumlusu() {
        return kurulusSorumlusu;
    }

    public void setKurulusSorumlusu(String kurulusSorumlusu) {
        this.kurulusSorumlusu = kurulusSorumlusu;
    }

    @Override
    public int getId() {
        return this.kurulusId;
    }
}
