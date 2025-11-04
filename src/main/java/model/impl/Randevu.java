package model.impl;

import model.IBaseModel;

import java.time.LocalDateTime;

public class Randevu implements IBaseModel<Randevu> {
    private int randevuId;
    private LocalDateTime randevuTar;
    private int kullaniciId;
    private int sagPersId;

    public Randevu(){

    }

    public Randevu(int randevuId, LocalDateTime randevuTar, int kullaniciId, int sagPersId) {
        this.randevuId = randevuId;
        this.randevuTar = randevuTar;
        this.kullaniciId = kullaniciId;
        this.sagPersId = sagPersId;
    }

    public int getRandevuId() {
        return randevuId;
    }

    public void setRandevuId(int randevuId) {
        this.randevuId = randevuId;
    }

    public LocalDateTime getRandevuTar() {
        return randevuTar;
    }

    public void setRandevuTar(LocalDateTime randevuTar) {
        this.randevuTar = randevuTar;
    }

    public int getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public int getSagPersId() {
        return sagPersId;
    }

    public void setSagPersId(int sagPersId) {
        this.sagPersId = sagPersId;
    }

    @Override
    public int getId() {
        return this.randevuId;
    }
}
