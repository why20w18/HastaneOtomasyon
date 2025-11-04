package repository.impl;

import model.impl.Kurulus;
import repository.IBaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KurulusRepository implements IBaseRepository<Kurulus> {

    private Connection conn;

    public KurulusRepository(Connection conn){
        this.conn = conn;
    }

    @Override
    public void save(Kurulus kurulus) throws SQLException {
        String sql = "INSERT INTO KURULUS(kurulusAd,kurulusSehir,kurulusIlce,kurulusTar,kurulusTur,kurulusSorumlusu) " +
                "VALUES (?,?,?,?,?,?);";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,kurulus.getKurulusAd());
            ps.setString(2,kurulus.getKurulusSehir());
            ps.setString(3,kurulus.getKurulusIlce());
            ps.setDate(4, Date.valueOf(kurulus.getKurulusTar()));
            ps.setString(5,kurulus.getKurulusTur());
            ps.setString(6,kurulus.getKurulusSorumlusu());

            int affected = ps.executeUpdate();
            System.out.println("kurulus save : " + affected);
        }

    }

    @Override
    public Kurulus findById(int id) throws SQLException {
        String sql = "SELECT * FROM KURULUS WHERE kurulusId = ?;";

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
    public List<Kurulus> findAll() throws SQLException {
        List<Kurulus> kurulusList = new ArrayList<>();
        String sql = "SELECT * FROM KURULUS;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                kurulusList.add(toMapping(rs));
            }
        }

        return kurulusList;
    }

    @Override
    public void update(Kurulus kurulus) throws SQLException {
        String sql = "UPDATE KURULUS " +
                "SET kurulusAd = ? ," +
                "kurulusSehir = ? ," +
                "kurulusIlce = ? ," +
                "kurulusTar = ? ," +
                "kurulusTur = ? ," +
                "kurulusSorumlusu = ?" +
                "WHERE kurulusId = ?;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,kurulus.getKurulusAd());
            ps.setString(2,kurulus.getKurulusSehir());
            ps.setString(3,kurulus.getKurulusIlce());
            ps.setDate(4,Date.valueOf(kurulus.getKurulusTar()));
            ps.setString(5,kurulus.getKurulusTur());
            ps.setString(6,kurulus.getKurulusSorumlusu());
            ps.setInt(7,kurulus.getKurulusId());

            int affected = ps.executeUpdate();
            System.out.println("kurulus update affected : " + affected);
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE KURULUS WHERE kurulusId = ?;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            int affected = ps.executeUpdate();
            System.out.println("delete kurulus affected : " + affected);
        }
    }

    @Override
    public Kurulus toMapping(ResultSet resultSet) throws SQLException {
        //(int kurulusId, String kurulusAd, String kurulusSehir, String kurulusIlce, LocalDate kurulusTar,
        //                   String kurulusTur, String kurulusSorumlusu)
        return new Kurulus(
                resultSet.getInt("kurulusId"),
                resultSet.getString("kurulusAd"),
                resultSet.getString("kurulusSehir"),
                resultSet.getString("kurulusIlce"),
                resultSet.getDate("kurulusTar").toLocalDate(),
                resultSet.getString("kurulusTur"),
                resultSet.getString("kurulusSorumlusu")

        );
    }
}
