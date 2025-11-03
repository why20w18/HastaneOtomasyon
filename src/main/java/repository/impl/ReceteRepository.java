package repository.impl;

import model.Recete;
import repository.IBaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceteRepository implements IBaseRepository<Recete> {

    private Connection conn;
    public ReceteRepository(Connection conn){
        this.conn = conn;
    }

    @Override
    public void save(Recete recete) throws SQLException {
        String sql = "INSERT INTO RECETE(receteKod,receteAlinmaTar,receteTurId,kullaniciId,sagPersId) " +
                "VALUES(?,?,?,?,?);";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,recete.getReceteKod());
            ps.setTimestamp(2, Timestamp.valueOf(recete.getReceteAlinmaTar()));
            ps.setInt(3,recete.getReceteTurId());
            ps.setInt(4,recete.getKullaniciId());
            ps.setInt(5,recete.getSagPersId());

            int affected = ps.executeUpdate();
            System.out.println("save recete affected : " + affected);
        }
    }

    @Override
    public Recete findById(int id) throws SQLException {
        String sql = "SELECT * FROM RECETE WHERE receteId = ?;";
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
    public List<Recete> findAll() throws SQLException {
        List<Recete> receteList = new ArrayList<>();
        String sql = "SELECT * FROM RECETE;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                receteList.add(toMapping(rs));
            }
        }

        return receteList;
    }

    @Override
    public void update(Recete recete) throws SQLException {
        String sql = "UPDATE RECETE SET " +
                "receteKod = ?," +
                "receteTar = ?," +
                "receteAlinmaTar = ?," +
                "receteTurId = ?," +
                "kullaniciId = ?," +
                "sagPersId = ? WHERE receteId = ?;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,recete.getReceteKod());
            ps.setTimestamp(2, Timestamp.valueOf(recete.getReceteTar()));
            ps.setTimestamp(3, Timestamp.valueOf(recete.getReceteAlinmaTar()));
            ps.setInt(4,recete.getReceteTurId());
            ps.setInt(5,recete.getKullaniciId());
            ps.setInt(6,recete.getSagPersId());
            ps.setInt(7,recete.getReceteId());

            int affected = ps.executeUpdate();
            System.out.println("update recete affected : " + affected);
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE RECETE WHERE receteId = ?;";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            int affected = ps.executeUpdate();
            System.out.println("affected delete recete : " + affected);
        }
    }

    @Override
    public Recete toMapping(ResultSet resultSet) throws SQLException {
        return new Recete(
               resultSet.getInt("receteId"),
               resultSet.getString("receteKod"),
               resultSet.getTimestamp("receteTar").toLocalDateTime(),
               resultSet.getTimestamp("receteAlinmaTar").toLocalDateTime(),
               resultSet.getInt("receteTurId"),
               resultSet.getInt("kullaniciId"),
                resultSet.getInt("sagPersId")
        );
    }
}
