package service.impl;

import model.impl.Kullanici;
import repository.impl.KullaniciRepository;
import service.BaseService;

public class KullaniciService extends BaseService<Kullanici,KullaniciRepository> {

    KullaniciRepository repo;

    public  KullaniciService(KullaniciRepository repo){
        super(repo);
        this.repo = repo;
    }





}
