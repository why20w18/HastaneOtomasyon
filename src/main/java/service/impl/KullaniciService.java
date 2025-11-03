package service.impl;

import model.Kullanici;
import repository.impl.KullaniciRepository;
import service.BaseService;
import service.IBaseService;

import java.sql.SQLException;
import java.util.List;

public class KullaniciService  {

    KullaniciRepository repo;

    public  KullaniciService(KullaniciRepository repo){
        this.repo = repo;
    }


}
