package model;

public class ReceteTur implements IBaseModel<ReceteTur>{
    private int receteTurId;
    private String receteTurAd;

    public ReceteTur(){

    }

    public ReceteTur(int receteTurId, String receteTurAd) {
        this.receteTurId = receteTurId;
        this.receteTurAd = receteTurAd;
    }

    public int getReceteTurId() {
        return receteTurId;
    }

    public void setReceteTurId(int receteTurId) {
        this.receteTurId = receteTurId;
    }

    public String getReceteTurAd() {
        return receteTurAd;
    }

    public void setReceteTurAd(String receteTurAd) {
        this.receteTurAd = receteTurAd;
    }

    @Override
    public int getId() {
        return this.receteTurId;
    }
}
