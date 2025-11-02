package repository.impl;

import model.Kullanici;
import repository.IBaseRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KullaniciRepository implements IBaseRepository<Kullanici> {
    private Connection conn;

    public KullaniciRepository(Connection conn){
        this.conn = conn;
    }

    @Override
    public void save(Kullanici kullanici) throws SQLException {
        String sql = "INSERT INTO(kullaniciAd,kullaniciSoyad,kullaniciDogTar,kullaniciTelNo,kullaniciSehir,kullaniciIlce,kullaniciKilo,kullaniciBoy" +
                ",kullaniciCinsiyet,kullaniciKanGrubu) VALUES (?,?,?,?,?,?,?,?,?,?);";

        //try catch resources
        try(PreparedStatement ps = conn.prepareStatement(sql)){ //ps otomatik kapatilacak
            ps.setString(1,kullanici.getKullaniciAd());
            ps.setString(2,kullanici.getKullaniciSoyad());
            ps.setDate(3,Date.valueOf(kullanici.getKullaniciDogTar()));
            ps.setString(4,kullanici.getKullaniciTelNo());
            ps.setString(5,kullanici.getKullaniciSehir());
            ps.setString(6,kullanici.getKullaniciIlce());
            ps.setInt(7,kullanici.getKullaniciKilo());
            ps.setInt(8,kullanici.getKullaniciBoy());
            ps.setString(9,kullanici.getKullaniciCinsiyet());
            ps.setString(10,kullanici.getKullaniciKanGrubu());

            int affectedRow = ps.executeUpdate();
            System.out.println("affectedRow : "+affectedRow);
        }
    }

    @Override
    public Kullanici findById(int id) throws SQLException {
        String sql = "SELECT * FROM KULLANICI WHERE kullaniciId = ?;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return toMapping(rs);
            }

        }

        return null;
    }

    @Override
    public List<Kullanici> findAll() throws SQLException {
        String sql = "SELECT * FROM KULLANICI;";
        List<Kullanici> kullaniciList = new ArrayList<>();

        try(PreparedStatement ps = conn.prepareStatement(sql)){
           ResultSet resultSet = ps.executeQuery();
           while(resultSet.next()){
                kullaniciList.add(toMapping(resultSet));
           }
        }

        return kullaniciList;
    }

    @Override
    public void update(Kullanici kullanici) throws SQLException {
        String sql = "UPDATE KULLANICI " +
                "SET kullaniciAd = ? , " +
                "kullaniciSoyad = ? , " +
                "kullaniciDogTar = ? , " +
                "kullaniciTelNo = ? , " +
                "kullaniciSehir = ? ," +
                "kullaniciIlce = ? ," +
                "kullaniciKilo = ? ," +
                "kullaniciBoy = ? ," +
                "kullaniciCinsiyet = ?," +
                "kullaniciKanGrubu = ? " +
                "WHERE kullaniciId = ?;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,kullanici.getKullaniciAd());
            ps.setString(2,kullanici.getKullaniciSoyad());
            ps.setDate(3,Date.valueOf(kullanici.getKullaniciDogTar()));
            ps.setString(4,kullanici.getKullaniciTelNo());
            ps.setString(5,kullanici.getKullaniciSehir());
            ps.setString(6,kullanici.getKullaniciIlce());
            ps.setByte(7,kullanici.getKullaniciKilo());
            ps.setByte(8,kullanici.getKullaniciBoy());
            ps.setString(9,kullanici.getKullaniciCinsiyet());
            ps.setString(10,kullanici.getKullaniciKanGrubu());
            ps.setInt(11,kullanici.getKullaniciId());

            int affectedRow = ps.executeUpdate();
            System.out.println("affectedRow : " + affectedRow);
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE KULLANICI WHERE kullaniciId = ?;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            int affectedRow = ps.executeUpdate();
            System.out.println("affected delete : " + affectedRow);
        }
    }

    @Override
    public Kullanici toMapping(ResultSet resultSet) throws SQLException {

        return new Kullanici(
                resultSet.getInt("kullaniciId"),
                resultSet.getString("kullaniciAd"),
                resultSet.getNString("kullaniciSoyad"),
                resultSet.getDate("kullaniciDogTar").toLocalDate(),
                resultSet.getString("kullaniciTelNo"),
                resultSet.getString("kullaniciSehir"),
                resultSet.getString("kullaniciIlce"),
                resultSet.getByte("kullaniciKilo"),
                resultSet.getByte("kullaniciBoy"),
                resultSet.getString("kullaniciCinsiyet"),
                resultSet.getString("kullaniciKanGrubu")
        );
    }
}
