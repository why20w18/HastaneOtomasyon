package app;

import model.impl.Kullanici;
import repository.DatabaseConnection;
import repository.impl.KullaniciRepository;
import service.impl.KullaniciService;

import java.sql.Connection;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        System.out.println("Hastane Otomasyon Programi");

        DatabaseConnection databaseConnection = new DatabaseConnection(
                Configuration.DB_USERNAME.getConfig(),
                Configuration.DB_PASSWORD.getConfig(),
                Configuration.DB_NAME.getConfig()
                );
        Connection connection = databaseConnection.getConnection();
        if(connection == null)
            return;

        KullaniciRepository kullaniciRepository = new KullaniciRepository(connection);
        KullaniciService kullaniciService = new KullaniciService(kullaniciRepository);

        try {
            Kullanici yeni = new Kullanici();
            yeni.setKullaniciAd("Ahmet");
            yeni.setKullaniciSoyad("Yılmaz");
            yeni.setKullaniciDogTar(LocalDate.of(1337, 12, 12));
            yeni.setKullaniciTelNo("01234567890");
            yeni.setKullaniciSehir("Istanbul");
            yeni.setKullaniciIlce("Halkali");
            yeni.setKullaniciKilo((byte)70);
            yeni.setKullaniciBoy((byte)175);
            yeni.setKullaniciCinsiyet("E");
            yeni.setKullaniciKanGrubu("A RH+");

           kullaniciService.addModel(yeni);

            System.out.println("EKLENDI !");
        }
        catch (Exception e) {
            System.out.println("HATA_MAIN : " + e.getMessage());
        }
        finally {
            databaseConnection.closeConnection();
        }


    }
}
