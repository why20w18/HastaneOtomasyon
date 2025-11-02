package model;

public class SagPersonel {
    private int sagPersId;
    private String sagPersAd;
    private String sagPersSoyad;
    private String sagPersBirim;
    private int kurulusId;

    public SagPersonel(){

    }

    public SagPersonel(int sagPersId, String sagPersAd, String sagPersSoyad, String sagPersBirim, int kurulusId) {
        this.sagPersId = sagPersId;
        this.sagPersAd = sagPersAd;
        this.sagPersSoyad = sagPersSoyad;
        this.sagPersBirim = sagPersBirim;
        this.kurulusId = kurulusId;
    }

    public int getSagPersId() {
        return sagPersId;
    }

    public void setSagPersId(int sagPersId) {
        this.sagPersId = sagPersId;
    }

    public String getSagPersAd() {
        return sagPersAd;
    }

    public void setSagPersAd(String sagPersAd) {
        this.sagPersAd = sagPersAd;
    }

    public String getSagPersSoyad() {
        return sagPersSoyad;
    }

    public void setSagPersSoyad(String sagPersSoyad) {
        this.sagPersSoyad = sagPersSoyad;
    }

    public String getSagPersBirim() {
        return sagPersBirim;
    }

    public void setSagPersBirim(String sagPersBirim) {
        this.sagPersBirim = sagPersBirim;
    }

    public int getKurulusId() {
        return kurulusId;
    }

    public void setKurulusId(int kurulusId) {
        this.kurulusId = kurulusId;
    }
}
