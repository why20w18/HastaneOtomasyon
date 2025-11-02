package service;

import repository.impl.KullaniciRepository;

public class KullaniciService {
    private final KullaniciRepository repo;

    public KullaniciService(KullaniciRepository repo){
        this.repo = repo;
    }

}
