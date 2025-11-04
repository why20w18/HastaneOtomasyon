package repository.impl;

import model.impl.Randevu;
import repository.IBaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RandevuRepository implements IBaseRepository<Randevu> {
    private Connection conn;

    public RandevuRepository(Connection conn){
        this.conn = conn;
    }


    @Override
    public void save(Randevu randevu) throws SQLException {
        String sql = "INSERT INTO RANDEVU(randevuTar,kullaniciId,sagPersId) VALUES(?,?,?);";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setTimestamp(1,Timestamp.valueOf(randevu.getRandevuTar()));
            ps.setInt(2,randevu.getKullaniciId());
            ps.setInt(3,randevu.getSagPersId());

            int affected = ps.executeUpdate();
            System.out.println("save randevu affected : " + affected);
        }


    }

    @Override
    public Randevu findById(int id) throws SQLException {
        String sql = "SELECT * FROM RANDEVU WHERE randevuId = ?;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return toMapping(rs);
            }
        }
        return null; /////////////TUM NULLER YERINE BOS CEVIR MODELLERI
    }

    @Override
    public List<Randevu> findAll() throws SQLException {
        List<Randevu> listRandevu = new ArrayList<>();
        String sql = "SELECT * FROM RANDEVU;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                listRandevu.add(toMapping(rs));
            }

        }
        return listRandevu;
    }

    @Override
    public void update(Randevu randevu) throws SQLException {
        String sql = "UPDATE RANDEVU SET " +
                "randevuTar = ?," +
                "kullaniciId = ?," +
                "sagPersId = ? WHERE randevuId = ?;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setTimestamp(1,Timestamp.valueOf(randevu.getRandevuTar()));
            ps.setInt(2,randevu.getKullaniciId());
            ps.setInt(3,randevu.getSagPersId());
            ps.setInt(4,randevu.getRandevuId());

            int affected = ps.executeUpdate();
            System.out.println("update randevu affected : " + affected);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE RANDEVU WHERE randevuId = ?;";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            int affected = ps.executeUpdate();
            System.out.println("randevu delete affected : " + affected);
        }
    }

    @Override
    public Randevu toMapping(ResultSet resultSet) throws SQLException {
        return new Randevu(
                resultSet.getInt("randevuId"),
                resultSet.getTimestamp("randevuTar").toLocalDateTime(),
                resultSet.getInt("kullaniciId"),
                resultSet.getInt("sagPersId")
        );
    }
}
