package model;

public class Envanter implements IBaseModel<Envanter>{
    private int envaterId;
    private short doktorKapasite;
    private short hemsireKapasite;
    private short yardimciSagKapasite;
    private short yatakKapasite;
    private short ambulansSay;
    private int kurulusId;

    public Envanter(){

    }

    public Envanter(int envaterId, short doktorKapasite, short hemsireKapasite, short yardimciSagKapasite,
                    short yatakKapasite, short ambulansSay, int kurulusId) {
        this.envaterId = envaterId;
        this.doktorKapasite = doktorKapasite;
        this.hemsireKapasite = hemsireKapasite;
        this.yardimciSagKapasite = yardimciSagKapasite;
        this.yatakKapasite = yatakKapasite;
        this.ambulansSay = ambulansSay;
        this.kurulusId = kurulusId;
    }

    public int getEnvaterId() {
        return envaterId;
    }

    public void setEnvaterId(int envaterId) {
        this.envaterId = envaterId;
    }

    public short getDoktorKapasite() {
        return doktorKapasite;
    }

    public void setDoktorKapasite(short doktorKapasite) {
        this.doktorKapasite = doktorKapasite;
    }

    public short getHemsireKapasite() {
        return hemsireKapasite;
    }

    public void setHemsireKapasite(short hemsireKapasite) {
        this.hemsireKapasite = hemsireKapasite;
    }

    public short getYardimciSagKapasite() {
        return yardimciSagKapasite;
    }

    public void setYardimciSagKapasite(short yardimciSagKapasite) {
        this.yardimciSagKapasite = yardimciSagKapasite;
    }

    public short getYatakKapasite() {
        return yatakKapasite;
    }

    public void setYatakKapasite(short yatakKapasite) {
        this.yatakKapasite = yatakKapasite;
    }

    public short getAmbulansSay() {
        return ambulansSay;
    }

    public void setAmbulansSay(short ambulansSay) {
        this.ambulansSay = ambulansSay;
    }

    public int getKurulusId() {
        return kurulusId;
    }

    public void setKurulusId(int kurulusId) {
        this.kurulusId = kurulusId;
    }

    @Override
    public int getId() {
        return this.envaterId;
    }
}
