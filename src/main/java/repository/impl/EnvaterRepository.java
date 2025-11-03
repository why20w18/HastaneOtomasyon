package repository.impl;

import model.Envanter;
import repository.IBaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnvaterRepository implements IBaseRepository<Envanter> {
    private Connection conn;

    public EnvaterRepository(Connection conn){
        this.conn = conn;
    }

    @Override
    public void save(Envanter env) throws SQLException {
        String sql = "INSERT INTO ENVANTER() VALUES (doktorKapasite,hemsireKapasite,yardimciSagKapasite,yatakKapasite,ambulansSay,kurulusId)" +
                " VALUES (?,?,?,?,?,?);";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setShort(1,env.getDoktorKapasite());
            ps.setShort(2,env.getHemsireKapasite());
            ps.setShort(3,env.getYardimciSagKapasite());
            ps.setShort(4,env.getYatakKapasite());
            ps.setShort(5,env.getAmbulansSay());
            ps.setInt(6,env.getKurulusId());

            int affected = ps.executeUpdate();
            System.out.println("envanter save : " + affected);
        }
    }


    @Override
    public Envanter findById(int id) throws SQLException {
        String sql = "SELECT * FROM ENVANTER WHERE envanterId = ?;";

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
    public List<Envanter> findAll() throws SQLException {
        List<Envanter> listEnvanter = new ArrayList<>();
        String sql = "SELECT * FROM ENVANTER;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                listEnvanter.add(toMapping(rs));
            }
        }

        return listEnvanter;
    }

    @Override
    public void update(Envanter env) throws SQLException {
        String sql = "UPDATE ENVANTER SET " +
                "doktorKapasitesi = ?," +
                "hemsireKapasite = ?," +
                "yardimciSagKapasite = ?," +
                "yatakKapasite = ?," +
                "ambulansSay = ?," +
                "kurulusId = ? WHERE envanterId = ?;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setShort(1,env.getDoktorKapasite());
            ps.setShort(2,env.getHemsireKapasite());
            ps.setShort(3,env.getYardimciSagKapasite());
            ps.setShort(4,env.getYatakKapasite());
            ps.setShort(5,env.getAmbulansSay());
            ps.setInt(6,env.getKurulusId());
            ps.setInt(7,env.getEnvaterId());

            int affected = ps.executeUpdate();
            System.out.println("affected update envanter : " + affected);
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE ENVANTER WHERE envanterId = ?;";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            int affected = ps.executeUpdate();
            System.out.println("delete envanter affected : " + affected);
        }
    }

    @Override
    public Envanter toMapping(ResultSet resultSet) throws SQLException {
        return new Envanter(
                resultSet.getInt("envaterId"),
                resultSet.getShort("doktorKapasite"),
                resultSet.getShort("hemsireKapasite"),
                resultSet.getShort("yardimciSagKapasite"),
                resultSet.getShort("yatakKapasite"),
                resultSet.getShort("ambulansSay"),
                resultSet.getInt("kurulusId")
        );
    }
}
