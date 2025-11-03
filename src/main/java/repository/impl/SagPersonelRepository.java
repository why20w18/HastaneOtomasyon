package repository.impl;

import model.SagPersonel;
import repository.IBaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SagPersonelRepository implements IBaseRepository<SagPersonel> {

    private Connection conn;

    public SagPersonelRepository(Connection conn){
        this.conn = conn;
    }

    @Override
    public void save(SagPersonel sagPersonel) throws SQLException {
        String sql = "INSERT INTO SAGPERSONEL(sagPersAd,sagPersSoyad,sagPersBirim,kurulusId) " +
                "VALUES(?,?,?,?);";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,sagPersonel.getSagPersAd());
            ps.setString(2,sagPersonel.getSagPersSoyad());
            ps.setString(3,sagPersonel.getSagPersBirim());
            ps.setInt(4,sagPersonel.getKurulusId());

            int affected = ps.executeUpdate();
            System.out.println("save sagpersonel affected : " + affected);
        }

    }


    @Override
    public SagPersonel findById(int id) throws SQLException {
        String sql = "SELECT * FROM SAGPERSONEL WHERE sagPersonelId = ?;";

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
    public List<SagPersonel> findAll() throws SQLException {
        List<SagPersonel> sagPersonelList = new ArrayList<>();
        String sql = "SELECT * FROM ENVANTER;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                sagPersonelList.add(toMapping(rs));
            }
        }

        return sagPersonelList;
    }

    @Override
    public void update(SagPersonel sagPersonel) throws SQLException {
        String sql = "UPDATE SAGPERSONEL SET " +
                "sagPersAd = ?," +
                "sagPersSoyad = ?," +
                "sagPersBirim = ?," +
                "kurulusId = ? WHERE sagPersId = ?;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,sagPersonel.getSagPersAd());
            ps.setString(2,sagPersonel.getSagPersSoyad());
            ps.setString(3,sagPersonel.getSagPersBirim());
            ps.setInt(4,sagPersonel.getKurulusId());
            ps.setInt(5,sagPersonel.getSagPersId());

            int affecteed = ps.executeUpdate();
            System.out.println("update sagpersonel affected : " + affecteed);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE SAGPERSONEL WHERE sagPersonelId = ?;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            int affected = ps.executeUpdate();
            System.out.println("delete sagpersonel affected : " + affected);
        }

    }

    @Override
    public SagPersonel toMapping(ResultSet resultSet) throws SQLException {
        return new SagPersonel(
                resultSet.getInt("sagPersonelId"),
                resultSet.getString("sagPersAd"),
                resultSet.getString("sagPersSoyad"),
                resultSet.getString("sagPersBirim"),
                resultSet.getInt("kurulusId")
        );
    }
}
