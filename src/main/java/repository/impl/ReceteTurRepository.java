package repository.impl;

import model.ReceteTur;
import repository.IBaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReceteTurRepository implements IBaseRepository<ReceteTur> {

    private Connection conn;
    public ReceteTurRepository(Connection conn){
        this.conn = conn;
    }

    @Override
    public void save(ReceteTur receteTur) throws SQLException {
        String sql = "INSERT INTO RECETE_TUR(receteTurAd) VALUES(?);";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,receteTur.getReceteTurAd());
            int affected = ps.executeUpdate();

            System.out.println("recete tur save affected : " + affected);
        }

    }

    @Override
    public ReceteTur findById(int id) throws SQLException {
        String sql = "SELECT * FROM RECETE_TUR WHERE receteTurId = ?;";

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
    public List<ReceteTur> findAll() throws SQLException {
        List<ReceteTur> receteTurList = new ArrayList<>();
        String sql = "SELECT * FROM RECETE_TUR;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                receteTurList.add(toMapping(rs));
            }
        }

        return receteTurList;
    }

    @Override
    public void update(ReceteTur receteTur) throws SQLException {
        String sql = "UPDATE RECETE_TUR SET " +
                "receteTurAd = ? WHERE receteTurId = ?;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,receteTur.getReceteTurAd());
            ps.setInt(2,receteTur.getReceteTurId());
            int affected = ps.executeUpdate();
            System.out.println("recetetur update affected : " + affected);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE RECETE_TUR WHERE receteTurId = ?;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            int affected = ps.executeUpdate();
            System.out.println("affecteed recetetur delete : " + affected);
        }

    }

    @Override
    public ReceteTur toMapping(ResultSet resultSet) throws SQLException {
        return new ReceteTur(
                resultSet.getInt("receteTurId"),
                resultSet.getString("receteTurAd")
        );
    }
}
