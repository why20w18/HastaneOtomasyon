package model.impl;

import model.IBaseModel;

import java.time.LocalDateTime;

public class Recete implements IBaseModel<Recete> {
    private int receteId;
    private String receteKod;
    private LocalDateTime receteTar;
    private LocalDateTime receteAlinmaTar;
    private int receteTurId;
    private int kullaniciId;
    private int sagPersId;

    public Recete(){

    }

    public Recete(int receteId, String receteKod, LocalDateTime receteTar, LocalDateTime receteAlinmaTar, int receteTurId, int kullaniciId, int sagPersId) {
        this.receteId = receteId;
        this.receteKod = receteKod;
        this.receteTar = receteTar;
        this.receteAlinmaTar = receteAlinmaTar;
        this.receteTurId = receteTurId;
        this.kullaniciId = kullaniciId;
        this.sagPersId = sagPersId;
    }

    public int getReceteId() {
        return receteId;
    }

    public void setReceteId(int receteId) {
        this.receteId = receteId;
    }

    public String getReceteKod() {
        return receteKod;
    }

    public void setReceteKod(String receteKod) {
        this.receteKod = receteKod;
    }

    public LocalDateTime getReceteTar() {
        return receteTar;
    }

    public void setReceteTar(LocalDateTime receteTar) {
        this.receteTar = receteTar;
    }

    public LocalDateTime getReceteAlinmaTar() {
        return receteAlinmaTar;
    }

    public void setReceteAlinmaTar(LocalDateTime receteAlinmaTar) {
        this.receteAlinmaTar = receteAlinmaTar;
    }

    public int getReceteTurId() {
        return receteTurId;
    }

    public void setReceteTurId(int receteTurId) {
        this.receteTurId = receteTurId;
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
        return this.receteId;
    }
}
